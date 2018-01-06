<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>




<div class="bs-example">
	<form class="form-horizontal" action="add-user.do" method="post">
		<div class="form-group">
									<div>
							<font color="red">${errorMessage}</font>
							</div>

			<label for="inputEmail" name="name" class="control-label col-xs-2"> First
				name</label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url" placeholder="First Name" name = "firstname">
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> last
				name </label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="url" name ="lastname"
					placeholder=" Last Name">
			</div>
		</div>

		<div class="form-group">
			<label for="inputEmail"  class="control-label col-xs-2"> Email</label>
			<div class="col-xs-10">
				<input type="email"  class="form-control" id="inputEmail" name="email"
					placeholder="Email" required>
			</div>
		</div>
		


		<div class="form-group">
			<label for="sel1" class="control-label col-xs-2">role:</label>
			<div class="col-xs-10">
				<select class="form-control" id="sel1" name ="role">
					<option>user</option>
					<option>super</option>
				</select>
			</div>
		</div>


		<div class="form-group">
			<label for="inputPassword" class="control-label col-xs-2">
				Password</label>
			<div class="col-xs-10">
				<input type="password" class="form-control" id="inputPassword" name = "password" 
					placeholder="Password" required>
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