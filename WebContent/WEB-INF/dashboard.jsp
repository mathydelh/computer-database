<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.formation.jee.domain.*" %>

<jsp:include page="include/header.jsp" />

<section id="main">
 	<h1 id="homeTitle">${number_PC} Computers found</h1> 
	<div id="actions">
		<form action="" method="GET">
			<input type="search" id="searchbox" name="search"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn primary">
		</form>
		<a class="btn success" id="add" href="AddPCServlet">Add Computer</a>
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
				<c:forEach items="${requestScope.computers}" var="computer">
				<tr>
					<td>${computer.name}</td>
 					<td>${computer.introducedAsString}</td> 
 					<td>${computer.discontinuedAsString}</td> 
 					<td>${computer.company.name}</td> 
				</tr>
				</c:forEach>
			</tbody>
		</table>
</section>

<jsp:include page="include/footer.jsp" />
