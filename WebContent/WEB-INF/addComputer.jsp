<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.formation.jee.domain.*" %>

<jsp:include page="include/header.jsp" />
<section id="main">

	<h1>Add Computer</h1>
	
	<!-- 	les information saisies par l'utilisateur seront transmis par la méthode post au Servlet -->
	<form id="theForm" method="POST" action="AddPCServlet">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name: <span class="red">*</span></label>
				<div class="input">
					<input id="name" type="text" name="name"/>
					<span class="help-inline">Required</span>
<!-- 					indique qu'il y a une erreur avec le nom -->
					<label id="nameError" class="red">&nbsp;</label> 
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introducedDate">Introduced date: <span class="red">*</span></label>
				<div class="input">
					<input id="introducedDate" type="date" name="introducedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
<!-- 					indique qu'il y a une erreur avec la date d'introduction -->
					<label id="introducedDateError" class="red">&nbsp;</label>
				</div>
			</div>
			
			<div class="clearfix">
				<label for="discontinued">Discontinued date: <span class="red">*</span></label>
				<div class="input">
					<input id="discontinued" type="date" name="discontinuedDate" pattern="YY-MM-dd"/>
					<span class="help-inline">YYYY-MM-DD</span>
<!-- 					indique qu'il y a une erreur avec la date d'interruption -->
					<label id="discontinuedError" class="red">&nbsp;</label>
				</div>
			</div>
			
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="company">
						<option value="-1">No company</option>
<!-- 						Parcours de la BD pour récuperer toutes les entreprise -->
						<c:forEach items="${requestScope.companies}" var="company">
						<option value="<c:out value="${company.id}"/>">${company.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<input type="submit" value="Add" class="btn primary">
			or <a href="DatabaseServlet" class="btn">Cancel</a>             <!-- 		Retour à l'accueil -->
		</div>
	</form>
</section>

<jsp:include page="include/footer.jsp" />