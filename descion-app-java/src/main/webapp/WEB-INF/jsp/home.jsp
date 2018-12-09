<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/common/header.jsp" />



<!--Header has option to return home and start new decision-->
<!--Home page greets user and takes in complexity and impact from user and stores to session-->
<c:url var="impactURL" value="/impact" />
<h1>What is the complexity of the decision at hand?</h1>
	<ul>
		<li>Simple</li>
		<li>Moderate</li>
		<li>Compound</li>
	</ul>
	<div>	
		<form:form action = "${impactURL}" method = "POST" modelAttribute="decision">
			<form:select path="complexity">
				<form:option value="Simple">Simple</form:option>
				<form:option value="Moderate">Moderate</form:option>
				<form:option value="Compound">Compound</form:option>
			</form:select>
			<form:button value = "submit">Next>>></form:button>
		</form:form>
	</div>
<c:import url="/WEB-INF/common/footer.jsp" />