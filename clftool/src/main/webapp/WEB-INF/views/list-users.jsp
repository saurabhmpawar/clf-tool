<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<a href="add-user.do" class="btn btn-info" role="button">ADD USER </a>
<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">IAM User details
			${userList[0].firstName}</div>
		<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>EmailID</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user1">

							<tr>
								<td>${user1.firstName}a</td>
								<td>${user1.lastName}</td>
								<td>${user1.emailid}</td>
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
</div>
<!-- /.col-lg-6 -->



todo table
<%@ include file="../common/footer.jspf"%>