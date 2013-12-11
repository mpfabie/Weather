<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>
<body>
	<%-- <h1>City: ${city}</h1>	
	<h1>State: ${state}</h1>	
	<h1>Temperature: ${temperature}</h1> --%>	
	
	<h1>${message}</h1>
	<form:form modelAttribute="state">
		<label for="zipCodeLabel">ZipCode: </label>
		<form:input path="zipCode" id="zipCodeLabel" />
		 <form:errors path="zipCode" cssclass="error"></form:errors>
		<br />
		<input type="submit" value="Submit" />
		<h2>${state.cityName}<br />${state.stateName}<br />${state.temp} </h2>			
	</form:form>
</body>
</html>