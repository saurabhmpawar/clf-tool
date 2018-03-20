<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">Ec2 instance list</div>
		<div>
			<font color="red">${errorMessage}</font>
		</div>

		<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>InstanceId</th>
							<th>LaunchTime</th>
							<th>InstanceType</th>
							<th>Tags</th>
							<th>PublicIpAddress</th>
							<th>cost</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${instances}" var="instance">

							<tr>
								<td>${instance.instanceId}</td>
								<td>${instance.launchTime}</td>
								<td>${instance.instanceType}</td>
								<td>${instance.tags}</td>
								<td>${instance.publicIpAddress}</td>
								<td>$1.5</td>
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