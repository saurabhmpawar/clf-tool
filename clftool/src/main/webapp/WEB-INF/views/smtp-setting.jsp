<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>




<div class="bs-example">
	<form class="form-horizontal" action="success.html" method="post">
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				url</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url" placeholder="URL">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				name</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url"
					placeholder=" smtp name">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="control-label col-xs-2">
				SMTP Password</label>
			<div class="col-xs-10">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password" required>
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> SMTP
				port</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url"
					placeholder=" port no">
			</div>
		</div>






		<div class="form-group">
			<label for="sel1" class="control-label col-xs-2">SSL:</label>
			<div class="col-xs-10">
				<select class="form-control" id="sel1">
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
					placeholder="Email" required>
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