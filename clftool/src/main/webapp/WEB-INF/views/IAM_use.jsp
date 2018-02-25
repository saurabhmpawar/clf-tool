<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>





<!-- /.panel-heading -->
<div class="panel-body">
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>UserName</th>
					<th>Created on</th>
					<th>PasswordLastUsed</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">

					<tr>
						<td>${user.userName}</td>
						<td>${user.createDate}</td>
						<td>${user.passwordLastUsed}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>
<!-- /.panel-body -->
</div>
<!-- /.panel -->
<%@ include file="../common/footer.jspf"%>