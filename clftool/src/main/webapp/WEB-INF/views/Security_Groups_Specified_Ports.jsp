<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>







<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">Security Group List</div>
		<div>
			<font color="red">${errorMessage}</font>
		</div>

		<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Group Name</th>
							<th>Risk color</th>
							<th>IpPermission</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${securityGroupList}" var="group">

							<tr>
								<td>${group.groupName}</td>
								<td>${group.color}</td>
								<td>

									<table class="table-bordered">
										<thead>
											<tr>
												<th>IpProtocol</th>
												<th>FromPort</th>
												<th>ToPort</th>
												<th>Ipv4Ranges</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${group.ipPermissions}" var="ip">
												<tr>
													<td>${ip.ipProtocol}</td>
													<td>${ip.fromPort}</td>
													<td>${ip.toPort}</td>
													<td>${ip.ipv4Ranges}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>



								</td>
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
<%@ include file="../common/footer.jspf"%>