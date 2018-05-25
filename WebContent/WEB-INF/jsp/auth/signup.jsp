<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Create account - Hyper Engage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%-- list of links/var --%>
<c:url var="semanticUiCss"
	value="/assets/css/semantic-ui-css/semantic.min.css" />
<c:url var="defaultCss" value="/assets/css/default.css" />
<!-- styles -->
<link href="${defaultCSs}" rel="stylesheet" type="text/css" />
<link href="${semanticUiCss}" rel="stylesheet" type="text/css" />
<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
</head>

<body>
	<%-- MENU / TEMPLATE --%>
	<jsp:include page="../base/header.jsp" />
	<%-- ERROR / FORM --%>
	<c:if test="${message.isError}">
		<div class="ui negative message container attached">
			<i class="close icon"></i>
			<div class="header">We're sorry we can't create your account!</div>
			<c:forEach items="${message.descriptions}" var="description">
				<p>
					<c:out value="${description}" />
				</p>
			</c:forEach>
		</div>
	</c:if>
	<%-- FIELDS / FORM --%>
	<form class="ui form attached container" name="user" method="POST"
		action="${pageContext.servletContext.contextPath}/signup/save"
		onsubmit="return validateForm()">
		<%-- 
	Changed*
	The field below will be necessary after active account by email.
		firstname
		lastname
		gender
		birthday


	<div class="ui segment attached">
		<h4 class="ui dividing header">
			<sp:message code="signup.form.personali" />
		</h4>
		<div class="field">
			<div class="two fields">
				<div class="required field">
					<label>
						<sp:message code="signup.form.personali.firstname" />
					</label>
					<input type="text" name="firstName" placeholder="<sp:message code='signup.form.personali.firstname.placeholder'/>" />
				</div>
				<div class="required field">
					<label>
						<sp:message code="signup.form.personali.lastname" />
					</label>
					<input type="text" name="lastName" placeholder="<sp:message code='signup.form.personali.lastname.placeholder'/>" />
				</div>
			</div>
		</div>
		<div class="required field">
			<label>
				<sp:message code="signup.form.personali.email" />
			</label>
			<div class="ui left icon input">
				<i class="icon mail"></i>
				<input type="text" name="email" placeholder="<sp:message code='signup.form.personali.email.placeholder'/>" />
			</div>
		</div>
		<div class="required field">
			<label>
				<sp:message code="signup.form.personali.genderandbirthday" />
			</label>
			<div class="two fields">
				<div class="field">
					<select name="gender">
						<option value="">
							<sp:message code="signup.form.personali.gender" />
						</option>
						<option value="1">
							<sp:message code="signup.form.personali.gender.male" />
						</option>
						<option value="2">
							<sp:message code="signup.form.personali.gender.female" />
						</option>
					</select>
				</div>
				<div class="field">
					<input type="text" name="birthday" placeholder="<sp:message code='signup.form.personali.birthday.placeholder'/>" />
				</div>
			</div>
		</div>
	</div>
	--%>
		<div class="ui segment attached">
			<h4 class="ui dividing header">
				<sp:message code="signup.form.accounti" />
			</h4>
			<div class="two fields">
				<div class="required field">
					<label> <sp:message code="signup.form.accounti.username" />
					</label>
					<div class="ui left action input">
						<button class="ui labeled icon button" id="check-username">
							<%-- loading --%>
							<i class="eye icon"></i>Check it
						</button>
						<input type="text" name="username" id="username"
							placeholder="<sp:message code='signup.form.accounti.username.placeholder'/>" />
					</div>
					<div id="usernameMessage"></div>
				</div>
				<div class="required field">
					<label> <sp:message code="signup.form.personali.email" />
					</label>
					<div class="ui left icon input">
						<i class="icon mail"></i> <input type="text" name="email"
							placeholder="<sp:message code='signup.form.personali.email.placeholder'/>" />
					</div>

				</div>
			</div>
			<div class="two fields">
				<div class="required field">
					<label> <sp:message code="signup.form.accounti.password" />
					</label>
					<div class="ui left icon input">
						<i class="key icon"></i> <input type="password" id="pwd"
							name="password"
							placeholder="<sp:message code='signup.form.accounti.password.placeholder'/>"
							onkeyup="validatePassword()" />
					</div>
					<div id="pwdMessage"></div>
				</div>
				<div class="required field">
					<label> <sp:message
							code="signup.form.accounti.passwordagain" />
					</label>
					<div class="ui left icon input">
						<i class="key icon"></i> <input type="password" id="pwdAgain"
							name="passwordAgain"
							placeholder="<sp:message code='signup.form.accounti.passwordagain.placeholder'/>"
							onkeyup="validatePassword()" />
					</div>
					<div id="pwdMessageAgain"></div>
				</div>
			</div>
		</div>
		<div class="ui segment attached">
			<div class="g-recaptcha"
				data-sitekey="6LdqF1IUAAAAAItuPzmDymKxfKUUWfsRGTQ8b7I7"></div>
		</div>
		<div class="ui segment attached">
			<input class="ui primary button" tabindex="0" type="submit"
				value="<sp:message code='signup.form.submit'/>" />
		</div>
	</form>
	<div class="ui bottom warning message container attached">
		<i class="icon help"></i> Already signed up? <a
			href="${pageContext.servletContext.contextPath}/signin">Login
			here </a> instead.
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$('#check-username').click(function(){
			var username = $('#username').val();
			//console.log(username);
			$.getJSON("${pageContext.servletContext.contextPath}/api/signup/search/"+username, success);
		});

		function success(data){
			var username = document.getElementById("username");
			var usernameMessage = document.getElementById("usernameMessage");
			if(data.isError){
				usernameMessage.className = "ui pointing red basic label";
				usernameMessage.innerHTML = "<sp:message code='usermessage.user.username.exist'/>";
			} else {
				usernameMessage.className = "ui pointing green basic label";
				usernameMessage.innerHTML = "<sp:message code='usermessage.user.username.not.exist'/>";
			}
		}
	

		function validateForm(){
				return validateUsername() && validatePassword();
		}
		
		function validateUsername(){
			var username = document.getElementById("username");
			var usernameMessage = document.getElementById("usernameMessage");
			
			if(username.value.length < 4){
				usernameMessage.className = "ui pointing red basic label";
				usernameMessage.innerHTML = "<sp:message code='signup.form.accounti.error.username.minimum'/>";
				return false;
			}
			return true;
		}
	
		function validatePassword(){
			
			// get the pwd and pwd_again fields.
			var pwd = document.getElementById("pwd");
			var pwdAgain = document.getElementById("pwdAgain");
			var result = true;
			
			// div to show errors
			var pwdMessage = document.getElementById("pwdMessage");
			var pwdMessageAgain = document.getElementById("pwdMessageAgain");
			
			// check the size of pwd fields.
			result = isPwdLargerOrEqualToEight(pwd,pwdMessage, "<sp:message code='signup.form.accounti.error.password.minimum'/>");
			result = isPwdLargerOrEqualToEight(pwdAgain,pwdMessageAgain, "<sp:message code='signup.form.accounti.error.passwordagain.minimum'/>");
						
			// check if the passwords are equal.
			if(pwd.value != pwdAgain.value){
				pwdMessageAgain.className = "ui pointing red basic label";
				pwdMessageAgain.innerHTML = "<sp:message code='signup.form.accounti.error.passwords.not.equal'/>";
				result = false;
			}
			
			return result;
		}
	
		/**
			Check the minimum value of password!
			It should be greater or equal to 8!
		**/
		function isPwdLargerOrEqualToEight(e, eMessage, text){
			if(e.value.length < 8){
				eMessage.className = "ui pointing red basic label";
				eMessage.innerHTML = text;
				return false;
			}else{
				eMessage.className = "";
				eMessage.innerHTML = "";
				return true;
			}
		}
	</script>

</body>
</html>