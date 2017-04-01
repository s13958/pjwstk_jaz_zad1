package com.credit.servlets;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credit.calculation.RatePlanGenerator;
import com.credit.calculation.InstalmentType;
import com.credit.calculation.Rate;
import com.credit.calculation.RatePlanViewer;
import com.itextpdf.text.DocumentException;

@WebServlet("/Credit")
public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_PAGE_PATH = "errorpage.jsp";

	public Credit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestedData = null;

		// AMOUNT
		requestedData = request.getParameter("amount");
		if (isInvalid(requestedData)) {
			response.sendRedirect(ERROR_PAGE_PATH);
		}
		double amount = Double.valueOf(requestedData);
		if (isNegative(amount))
			response.sendRedirect(ERROR_PAGE_PATH);

		// INSTALMENT QUANTITY
		requestedData = request.getParameter("instalmentQuantity");
		if (isInvalid(requestedData)) {
			response.sendRedirect(ERROR_PAGE_PATH);
		}
		int instalmentQuantity = Integer.valueOf(requestedData);
		if (isNegative(instalmentQuantity))
			response.sendRedirect(ERROR_PAGE_PATH);

		// INTEREST RATE
		requestedData = request.getParameter("interestRate");
		if (isInvalid(requestedData)) {
			response.sendRedirect(ERROR_PAGE_PATH);
		}
		double interestRate = Double.valueOf(requestedData);
		if (isNegative(interestRate))
			response.sendRedirect(ERROR_PAGE_PATH);

		// CONSTANT CHARGE
		requestedData = request.getParameter("constantCharge");
		if (isInvalid(requestedData)) {
			response.sendRedirect(ERROR_PAGE_PATH);
		}
		double constantCharge = Double.valueOf(requestedData);
		if (isNegative(constantCharge)) {
			response.sendRedirect(ERROR_PAGE_PATH);
		}

		// INSTALMENT TYPE
		InstalmentType instalmentType = null;
		if (request.getParameter("instalmentType").equals("constant")) {
			instalmentType = InstalmentType.CONSTANT;
		} else if (request.getParameter("instalmentType").equals("decreasing")) {
			instalmentType = InstalmentType.DECREASING;
		} else {
			response.sendRedirect(ERROR_PAGE_PATH);
		}

		List<Rate> ratePlan = RatePlanGenerator.generateRatePlan(amount, instalmentQuantity, interestRate,
				constantCharge, instalmentType);
		String action = request.getParameter("action");
		if (action.equals("Calculate")) {
			response.getWriter().append(RatePlanViewer.generateHtmlTable(ratePlan));
		} else if (action.equals("Generate PDF")) {
			response.setContentType("application/pdf");
			try {
				RatePlanViewer.generatePdf(ratePlan, response.getOutputStream());
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean isInvalid(String requestedData) {
		return requestedData == null || requestedData.isEmpty() || !isInteger(requestedData);
	}

	private boolean isInteger(String amount) {
		Pattern pattern = Pattern.compile("^[0-9]*?");
		Matcher matcher = pattern.matcher(amount);
		return matcher.matches();
	}

	private boolean isNegative(double amount) {
		if (amount <= 0)
			return true;
		else
			return false;
	}

}
