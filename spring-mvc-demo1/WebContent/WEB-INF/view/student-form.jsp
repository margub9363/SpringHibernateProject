<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName" />
		<br>
		<br>

Last name: <form:input path="lastName" />
		<br>
		<br>
Country: <form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
	
Favourite Language: 
	JAVA<form:radiobutton path="favouriteLanguage" value="Java" />
	C<form:radiobutton path="favouriteLanguage" value="C" />
	Python<form:radiobutton path="favouriteLanguage" value="Python" />
	JavaScript<form:radiobutton path="favouriteLanguage" value="Ruby" />
		<br>
		<br>
		
		
	Operating Systems:
	Linux <form:checkbox path="operatingSystems" value="Linux" />
	MAC OS <form:checkbox path="operatingSystems" value="Mac Os" />
	Windows <form:checkbox path="operatingSystems" value="Ms Windows" />


		<input type="submit" value="Submit" />
	</form:form>


</body>

</html>