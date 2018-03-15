<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>




<!-- /.panel-heading -->
<div class="panel-body">
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>VolumeId</th>
					<th>AvailabilityZone</th>
					<th>Size</th>
					<th>CreateTime</th>
					<th>State</th>
					<th>Cost saving per gb per month</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${volumeList}" var="volume">

					<tr>
						<td>${volume.volumeId}</td>
						<td>${volume.size}</td>
						<td>${volume.availabilityZone}</td>
						<td>${volume.state}</td>
						<td>${volume.createTime}</td>
						<td>$ ${volume.size*0.05}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>
<!-- /.panel-body -->
<%@ include file="../common/footer.jspf"%>