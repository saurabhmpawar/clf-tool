<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>






<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Bucket Name</th>
							<th>cost saving </th>
							

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ipList}" var="ip">

							<tr>
								<td>${ip.publicIp}</td>
								<td>$1</td>
								
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.panel-body -->

<%@ include file="../common/footer.jspf"%>