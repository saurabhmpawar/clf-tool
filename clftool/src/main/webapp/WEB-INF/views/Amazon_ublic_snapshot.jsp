<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<!-- /.panel-heading -->
<div class="panel-body">
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>SnapshotId</th>
					<th>VolumeId</th>
					<th>OwnerId</th>
					<th>VolumeSize</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${snapshots}" var="snapshot">

					<tr>
						<td>${snapshot.snapshotId}</td>
						<td>${snapshot.volumeId}</td>
						<td>${snapshot.ownerId}</td>
						<td>${snapshot.volumeSize} GB</td>
						<td>${snapshot.description}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>


<%@ include file="../common/footer.jspf"%>