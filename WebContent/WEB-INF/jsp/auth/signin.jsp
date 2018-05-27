<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Log in - Hyper Engage</title>
<meta http-equiv="Content-type" charset="utf-8"
	content="text/html; charset=UTF-8" />
<%-- vars --%>
<c:url var="defaultCss" value="/assets/css/default.css" />
<c:url var="semanticUiCss"
	value="/assets/css/semantic-ui-css/semantic.min.css" />
<c:url var="recaptcha"
	value="https://www.google.com/recaptcha/api.js?hl=en" />
<%-- styles --%>
<link href="${defaultCss}" rel="stylesheet" type="text/css" />
<link href="${semanticUiCss}" rel="stylesheet" type="text/css" />

</head>
<body>
	<form method="POST"
		action="${pageContext.servletContext.contextPath}/signin/login"
		onsubmit="return validateForm()">
		<div>
			<div>
				<label><sp:message code="signin.form.login.username" /> </label><input
					type="text"
					placeholder="<sp:message code='signin.form.login.username.placeholder'/>" />
				<input type="checkbox" /> <sp:message code="signin.form.login.remember" />
			</div>
			<div>
				<label><sp:message code="signin.form.login.password" /></label> <input
					type="password" placeholder="<sp:message  code='signin.form.login.password'/>" />
			</div>
		</div>
		<div>
			<a href="${pageContext.servletContext.contextPath}/signin/forgot/password" ><sp:message code="signin.form.login.forgot.password" /></a>
		</div>
		<div>
			<input type="submit" value="Login"/>
		</div>
	</form>
	<script>
		function validateForm(){
			return false;
		}
	</script>
</body>
</html>