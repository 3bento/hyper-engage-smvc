<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
			<html lang="en">

			<head>
				<title>Create account - Hyper Engage</title>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				<%-- list of links/var --%>
					<c:url var="semanticUiCss" value="/assets/css/semantic-ui-css/semantic.min.css" />
					<c:url var="defaultCss" value="/assets/css/default.css" />

					<!-- styles -->
					<link href="${defaultCSs}" rel="stylesheet" type="text/css" />
					<link href="${semanticUiCss}" rel="stylesheet" type="text/css" />
					<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
			</head>

			<body>
				<%-- MENU / TEMPLATE --%>
					<jsp:include page="../base/header.jsp" />
					<%-- MENU / TEMPLATE --%>
						<div class="ui negative message container attached">
							<i class="close icon"></i>
							<div class="header">We're sorry we can't create your account!</div>
							<p>First name is empty</p>
							<p>Email is invalid!</p>
							<p>Username already exists!</p>
							<p>These passwords don't match.</p>
							<p>Short passwords are easy to guess. Try one with at least 8 characters.</p>
						</div>
						<form class="ui form attached container" name="user" method="POST" action="${pageContext.servletContext.contextPath}/signup/save">
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
										<input type="text" name="email" placeholder="<sp:message code=" signup.form.personali.email.placeholder
										    "/>" />
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
											<input type="text" name="birthday" placeholder="<sp:message code=" signup.form.personali.birthday.placeholder "/>" />
										</div>
									</div>
								</div>
							</div>
							<div class="ui segment attached">
								<h4 class="ui dividing header">
									<sp:message code="signup.form.accounti" />
								</h4>
								<div class="required field">
									<label>
										<sp:message code="signup.form.accounti.username" />
									</label>
									<div class="ui left action input">
										<button class="ui  labeled icon button">
											<%-- loading --%>
												<i class="eye icon"></i>Check it
										</button>
										<input type="text" name="username" placeholder="<sp:message code=" signup.form.accounti.username.placeholder "/>" />
									</div>
								</div>
								<div class="two fields">
									<div class="required field">
										<label>
											<sp:message code="signup.form.accounti.password" />
										</label>
										<div class="ui left icon input">
											<i class="key icon"></i>
											<input type="password" name="password" placeholder="<sp:message code=" signup.form.accounti.passwordagain.placeholder
											    "/>" />
										</div>
									</div>
									<div class="required field">
										<label>
											<sp:message code="signup.form.accounti.passwordagain" />
										</label>
										<div class="ui left icon input">
											<i class="key icon"></i>
											<input type="password" name="passwordAgain" placeholder="<sp:message code=" signup.form.accounti.passwordagain.placeholder
											    "/>" />
										</div>
									</div>
								</div>
							</div>
							<div class="ui segment attached">
								<div class="g-recaptcha" data-sitekey="6LdqF1IUAAAAAItuPzmDymKxfKUUWfsRGTQ8b7I7"></div>
							</div>
							<div class="ui segment attached">
								<input class="ui primary button" tabindex="0" type="submit" value="<sp:message code=" signup.form.submit "/>" />
							</div>
						</form>
						<div class="ui bottom warning message container attached">
							<i class="icon help"></i> Already signed up?
							<a href="${pageContext.servletContext.contextPath}/signin">Login here
							</a> instead.
						</div>
			</body>

			</html>