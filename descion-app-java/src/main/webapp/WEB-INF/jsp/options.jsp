<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/common/header.jsp" />

<c:set var="resultsURL" value="/results"/>
<h2>Tell me about your options</h2>
	<div>	
		<form action = "${resultsURL}" method = "GET">
			
			<label for="optionName">Option Name:</label>
			<input type="text" name="optionName" id="optionName" />
			
			<h3>Pros to making this decision:</h3>
			<label for="proName">Name of pro:</label>
			<input type="text" name="proName" id="proName" />
			<label for="proVal">Value tied to reason:</label>
			<select name="proVal" id="proVal">
				<option value="1">Low</option>
				<option value="2">Medium</option>
				<option value="3">High</option>
			</select>
			
			<h3>Cons to making this decision:</h3>
			<label for="conName">Name of con:</label>
			<input type="text" name="conName" id="conName" />
			<label for="conVal">Value tied to reason:</label>
			<select name="conVal" id="conVal">
				<option value="1">Low</option>
				<option value="2">Medium</option>
				<option value="3">High</option>
			</select>
			<input type="submit" value = "Next>>>" />
		</form>
	</div>
	
<c:import url="/WEB-INF/common/footer.jsp" />