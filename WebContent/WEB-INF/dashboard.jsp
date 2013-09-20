<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.formation.jee.domain.*" %>

<jsp:include page="include/header.jsp" />

<section id="main">
 	<h1 id="homeTitle">${number_PC} Computers found</h1> 
	<div id="actions">
		<!-- 	les information saisies par l'utilisateur dans le champs de recherche seront transmis par la méthode get -->	
		<form action="" method="GET">
			<input type="search" id="searchbox" name="search"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn primary">
		</form>
		<a class="btn success" id="add" href="AddPCServlet">Add Computer</a> <!--  Lien vers la page d'ajout d'ordinateur -->
	</div>

		<table class="computers zebra-striped">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th><a href="<c:url value="DatabaseServlet?sort=name" />">Computer Name</a></th>
					<!-- Table header for Discontinued Date -->
 					<th><a href="<c:url value="DatabaseServlet?sort=introduced" />">Introduced Date</a></th> 
					<!-- Table header for Discontinued Date -->
 					<th><a href="<c:url value="DatabaseServlet?sort=discontinued" />">Discontinued Date</a></th> 
					<!-- Table header for Company -->
 					<th><a href="<c:url value="DatabaseServlet?sort=company" />">Company</a></th> 
				</tr>
			</thead>
			<tbody>
<!-- 						Parcours de la BD pour récuperer touts les ordinateurs -->
				<c:forEach items="${requestScope.computers}" var="computer">
				<tr>
<!-- 						l'Identifiant est transmis par l'url -->
					<td><a href="<c:url value="EditPCServlet?id=${computer.id}" />">${computer.name}</a></td>
 					<td>${computer.introducedAsString}</td> 
 					<td>${computer.discontinuedAsString}</td> 
 					<td>${computer.company.name}</td> 
				</tr>
				</c:forEach>
			</tbody> 
		</table>
<!-- 						Affichage du numéro des pages -->
		<table class="computers zebra-striped"> 
			        <tr>
			            <c:forEach begin="1" end="${noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${currentPage eq i}">
			                        <td>${i}</td>
			                    </c:when>
			                    <c:otherwise>
			                        <td><a href="DatabaseServlet?page=${i}">${i}</a></td>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
			        </tr>
			    </table>
			 
			    <%--For displaying Next link --%>
			    <c:if test="${currentPage lt noOfPages}">
			        <td><a href="DatabaseServlet?page=${currentPage + 1}">Next</a></td>
			    </c:if>
</section>

<jsp:include page="include/footer.jsp" />
