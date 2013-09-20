<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.formation.jee.domain.*" %>

<jsp:include page="include/header.jsp" />
<section id="main">

	<h1>Add Computer</h1>
	
	<!-- 	les information saisies par l'utilisateur seront transmis par la méthode post -->
	<form method="POST" action="EditPCServlet">
		<input type="hidden" name="insertID" value="${computer.id}"> 
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input">
					<input type="text" name="name" value="${computer.name}"/>
					<span class="help-inline">Required</span>
				</div>
			</div>
	
			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input">
					<input type="date" name="introducedDate" pattern="YY-MM-dd" value="${computer.introducedAsString}"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input">
					<input type="date" name="discontinuedDate" pattern="YY-MM-dd" value="${computer.discontinuedAsString}"/>
					<span class="help-inline">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input">
					<select name="company">
<!-- 						Parcours de la BD pour récuperer toutes les entreprises -->
						<c:forEach items="${requestScope.companies}" var="company">
							<option value="<c:out value="${computer.company.id}"/> ">${computer.company.name}</option>
							<option value="<c:out value="${company.id}"/> ">${company.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
<!-- 		Bouton pour supprimer un ordinateur -->
			<input type="submit" name="isClear" value="Clear" class="btn primary">
<!-- 		Bouton pour modifier un ordinateur -->
			<input type="submit" name="isUpdate" value="Update" class="btn primary">
			or <a href="DatabaseServlet" class="btn">Cancel</a>             <!-- 		Retour à l'accueil -->
			
		</div>
	</form>
</section>

<jsp:include page="include/footer.jsp" />