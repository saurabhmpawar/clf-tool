<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>




<div class="bs-example">
	<form class="form-horizontal" action="aws-setting.do" method="post">
		<div>
			<font color="red">${errorMessage}</font>
		</div>
		<div>
			<font color="green">${successMessage}</font>
		</div>

		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2">
				Access Key</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" placeholder="Access Key"
					name="accessKey">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2">
				Secret Key</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" placeholder="Secret Key"
					name="secertKey">
			</div>
		</div>


		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</div>

	</form>
</div>




<%@ include file="../common/footer.jspf"%>