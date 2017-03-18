<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Credit Scheduler</title>
</head>
<body>
	<form action="Credit" method="get">
	<fieldset>
		<h1>Credit scheduler</h1><hr />
		<label>Amount: <input type="number" id="amount" name="amount" required /> zł</label><hr />
		<label>Instalment quantity: 
		<select name="instalmentQuantity">
			<option value="6">6</option>
			<option value="12">12</option>
			<option value="18">18</option>		
			<option value="24">24</option>
			<option value="30">30</option>
			<option value="36">36</option>
		</select><hr/>
		</label>
		<label>Interest rate: <input type="number" id="interestRate" name="interestRate"
		min="0" max="99" required /> %<hr /></label>
		<label>Constant charge: <input type="number" id="constantCharge" name="constantCharge" required /> zł</label><hr /> 
		<label>Instalment type:<br />
			<input type="radio" id="instalmentType" name="instalmentType" value="increasing" required />Increasing<br /> 
			<input type="radio" id="instalmentType" name="instalmentType" value="decreasing" required />Decreasing<br /> 
		</label>
		<hr />
		<input type="submit" value="Calculate"/>
		</fieldset>
	</form>
	<p>
		<i>Credit scheduler accepts only <b>integer</b> values.</i><br />
	</p>
</body>
</html>