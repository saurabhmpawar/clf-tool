<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<div class="panel-body">
	<div class="table-responsive">
	<div class="panel-heading">VPC List</div>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>CIDR</th>
					<th>NAME</th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vpcList}" var="vpc">

					<tr>
						<td>${vpc.cidrBlock}</td>
						<td>${vpc.state}</td>
						
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</div><!-- div class="panel-body"> -->




	<%@ include file="../common/footer.jspf"%>