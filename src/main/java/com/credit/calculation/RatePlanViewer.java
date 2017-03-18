package com.credit.calculation;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class RatePlanViewer {
	
	public static String generateHtmlTable(List<Rate> rates) {
		StringBuilder result = new StringBuilder("<style>"
				+ "table, th, td { border: 1px groove black; padding: 2px} </style>");
		
		result.append("<table><tr>"
				+ "<th>Number</th>"
				+ "<th>Capital</th>"
				+ "<th>Amount</th>"
				+ "<th>Constant charge</th>"
				+ "<th>Total</th>"
				+ "</tr>");
		
		for (int i = 0; i < rates.size(); i++) {
			result.append("<tr>"
					+ "<td>"+(i+1)+"</td>"
					+ "<td>"+String.format("%.2f", rates.get(i).getCapital())+"</td>"
					+ "<td>"+String.format("%.2f", rates.get(i).getAmount())+"</td>"
					+ "<td>"+String.format("%.2f", rates.get(i).getConstantCharge())+"</td>"
					+ "<td>"+String.format("%.2f", rates.get(i).getTotal())+"</td>"
					+ "</tr>");
		}
		
		result.append("</table>");
		
		return result.toString();
	}
	
	public static void generatePdf(List<Rate> rates, ServletOutputStream outputStream) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		String htmlTable = "<html><head></head><body>" 
				+ generateHtmlTable(rates) 
				+ "</body></html>";
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(htmlTable)); 
		document.close();
	}
}
