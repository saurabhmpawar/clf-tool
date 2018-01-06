<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">s3 Bucket List</div>
		<div>
			<font color="red">${errorMessage}</font>
		</div>

		<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Bucket Name</th>
							<th>created on</th>
							<th>size</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bucketList}" var="bucket">

							<tr>
								<td>${bucket.name}a</td>
								<td>${bucket.creationDate}</td>
								<td>${bucket.owner}</td>
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