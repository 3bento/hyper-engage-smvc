<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="ui attached stackable menu">
	<div class="ui container">
		<div class="item">
			<a class="home icon"
				href="${pageContext.servletContext.contextPath}/"><spring:message
					code="menu.home" /></a>
		</div>
		<div class="item">
			<a class="mail icon"
				href="${pageContext.servletContext.contextPath}/aboutus"> <spring:message
					code="menu.aboutus" /></a>
		</div>

		<div class="right menu">
			<div class="ui simple dropdown item">
				<i class="world icon"></i>
				<spring:message code="menu.language" />
				<i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="?lang=en"><i class="us flag"></i> <spring:message
							code="menu.language.en" /> </a> <a class="item" href="?lang=ja"><i
						class="jp flag"></i> <spring:message code="menu.language.ja" /> </a>
					<a class="item" href="?lang=pt"><i class="br flag"></i> <spring:message
							code="menu.language.pt" /> </a>
				</div>
			</div>
			<div class=" item">
				<a class="grid layout icon"
					href="${pageContext.servletContext.contextPath}/signup"><spring:message
						code="menu.signup" /></a>
			</div>
			<div class=" item">
				<a class="mail icon"
					href="${pageContext.servletContext.contextPath}/signin"><spring:message
						code="menu.signin" /></a>
			</div>
		</div>
	</div>
</div>