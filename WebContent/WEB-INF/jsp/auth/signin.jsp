<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<%-- MENU / TEMPLATE --%>
	<div class="ui raised very padded text container segment">
		<form class="ui form" method="POST">
			<div class="ui segment">
				<h4 class="ui dividing header">
					<sp:message code="signin.form.personali"/>
				</h4>
				<div class="field">
					<div class="two fields">
						<div class="required field">
							<label><sp:message code="signin.form.personali.firstname"/></label>
							<input type="text" name="personal[first-name]"
								placeholder="<sp:message code='signin.form.personali.firstname.placeholder'/>" />
						</div>
						<div class="required field">
							<label><sp:message code="signin.form.personali.lastname"/></label>
							<input type="text" name="personal[last-name]"
								placeholder="<sp:message code='signin.form.personali.lastname.placeholder'/>" />
						</div>
					</div>
				</div>
				<div class="required field">
					<label><sp:message code="signin.form.personali.email"/></label>
					<input type="text" name="personal[email]" placeholder="<sp:message code="signin.form.personali.email.placeholder"/>"/>
				</div>
				<div class="required field">
					<label><sp:message code="signin.form.personali.genderandbirthday"/></label>
					<div class="two fields">
						<div class="field">
							<select>
								<option value=""><sp:message code="signin.form.personali.gender"/></option>
								<option value="1"><sp:message code="signin.form.personali.gender.male"/></option>
								<option value="2"><sp:message code="signin.form.personali.gender.female"/></option>
							</select>
						</div>
						<div class="field">
							<input type="text" name="birthday[birthday]" placeholder="<sp:message code="signin.form.personali.birthday.placeholder"/>"/>
						</div>
					</div>
				</div>
			</div>
			<div class="ui segment">
				<h4 class="ui dividing header"><sp:message code="signin.form.accounti"/></h4>
				<div class="required field">
					<label><sp:message code="signin.form.accounti.username"/></label> <input type="text" name="username"
						placeholder="<sp:message code="signin.form.accounti.username.placeholder"/>" />
				</div>
				<div class="required field">
					<label><sp:message code="signin.form.accounti.password"/></label> <input type="password"
						name="password" placeholder="<sp:message code="signin.form.accounti.passwordagain.placeholder"/>" />
				</div>
				<div class="required field">
					<label><sp:message code="signin.form.accounti.passwordagain"/></label> <input type="password"
						name="passwordAgain" placeholder="<sp:message code="signin.form.accounti.passwordagain.placeholder"/>" />
				</div>
			</div>
			<div class="ui segment">
				<div class="g-recaptcha" data-sitekey="6LdqF1IUAAAAAItuPzmDymKxfKUUWfsRGTQ8b7I7"></div>
			</div>
			<div class="ui segment">
				<input class="ui button" tabindex="0" type="submit"
					value="<sp:message code="signin.form.submit"/>" />
			</div>
		</form>
	</div>
</body>
</html>