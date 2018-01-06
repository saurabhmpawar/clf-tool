<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>




<div class="bs-example">
	<form class="form-horizontal" action="smtp-setting.do" method="post">
		<div>
			<font color="red">${errorMessage}</font>
		</div>
		<div>
			<font color="green">${successMessage}</font>
		</div>
		
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				url</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url" placeholder="URL"
					name="SmtpUrl">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				name</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url"
					placeholder=" smtp name" name="SmtpName">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="control-label col-xs-2">
				SMTP Password</label>
			<div class="col-xs-10">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password" required name="SmtpPassword">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				port</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url"
					placeholder=" port no" name="SmtpPort">
			</div>
		</div>






		<div class="form-group">
			<label for="sel1" class="control-label col-xs-2">SSL:</label>
			<div class="col-xs-10">
				<select class="form-control" id="sel1" name="SmtpSsl">
					<option>false</option>
					<option>true</option>
				</select>
			</div>
		</div>






		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2">
				Sender Email</label>
			<div class="col-xs-10">
				<input type="email" class="form-control" id="inputEmail"
					placeholder="Email" required name="SmtpEmail">
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