<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/common/header.jsp" />


<c:url var="optionsURL" value="/options"/>
<h2>What is the impact of the decision?</h2>
	<ul>
		<li>Minimal</li>
		<li>Moderate</li>
		<li>Major</li>
	</ul>
	<div>	
		<form:form action = "${optionsURL}" method = "POST" modelAttribute="decision">
			<form:select path="impact">
				<form:option value="Minimal">Simple</form:option>
				<form:option value="Moderate">Moderate</form:option>
				<form:option value="Major">Compound</form:option>
			</form:select>
			<form:button value = "submit">Next>>></form:button>
		</form:form>
	</div>
	
<c:import url="/WEB-INF/common/footer.jsp" />

