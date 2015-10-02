<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp"%>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>User Name</th>
			<th>Operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<a href='<spring:url value="/user/${user.id}.html"></spring:url>'>${user.name}</a>
				</td>
				<td>
					<a href='<spring:url value="/user/remove/${user.id}.html" />' class="btn btn-small btn-danger">Remove User</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>