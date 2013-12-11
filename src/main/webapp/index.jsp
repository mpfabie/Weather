<html>
<body>
	<form:form modelAttribute="state">
		<label for="zipCodeLabel">City: </label>
		<form:input path="zipCode" id="zipCodeLabel" />
		<br />

		<label for="stateLabel">State: </label>
		<form:input path="stateName" id="stateLabel" />
		<br />
		<label for="cityLabel">City: </label>
		<form:input path="cityName" id="cityLabel" />
		<br />
		<label for="tempLabel">Email: </label>
		<form:input path="temp" id="tempLabel" />

		<br />
		<br />
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>
