<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Job Name</th>
							<th>Group Name</th>
							<th>Next Fire Time</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobList}" var="job">

							<tr>
								<td>${job.jobName}</td>
								<td>${job.jobGroup}</td>
								<td>${job.nextFireTime}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>

<%@ include file="../common/footer.jspf"%>