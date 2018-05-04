<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
			<html>

			<head>
				<title>Welcome to Hyper Engage</title>
				<%-- 
	I will use template or import to remove the all of repeat part in the page.
	I didn't do it yet because i wan't to see where i can do it.
	
	That part of imports is one of them, here i can make one file to put all of import that i can share 
	in another pages!
 --%>
			<%-- list of links/var --%>
			<c:url var="semanticUiCss" value="/assets/css/semantic-ui-css/semantic.min.css" />
			<c:url var="defaultCss" value="/assets/css/default.css" />

			<!-- styles -->
			<link href="${defaultCSs}" rel="stylesheet" type="text/css" />
			<link href="${semanticUiCss}" rel="stylesheet" type="text/css" />

			</head>

			<body>
				<%-- MENU / TEMPLATE --%>
					<jsp:include page="base/header.jsp" />
					<%-- MENU / TEMPLATE --%>

						<c:if test="${message != null}">
							<div class="ui icon message">
								<i class="inbox icon"></i>
								<div class="content">
									<div class="header">
										Account created!
									</div>
									<p>${message.description} - ${pageContext.response.locale} / ${locale}</p>
									<!-- <spring:message code="welcome.greeting" arguments="${startMeeting}" /> -->
								</div>
							</div>
						</c:if>
						<%-- CONTENT FAKE --%>
							<div class="ui raised very padded text container segment">
								<h2 class="ui header right floated">JavaServer Pages</h2>
								<div class="ui clearing divider"></div>
								<p>JSP Filename extension .jsp Internet media type application/jsp Latest release 2.3 Standard JSR 245 Website JavaServer
									Pages Technology JavaServer Pages (JSP) is a technology that helps software developers create dynamically generated
									web pages based on HTML, XML, or other document types. Released in 1999 by Sun Microsystems,[1] JSP is similar to
									PHP and ASP, but it uses the Java programming language.
								</p>
								<p>To deploy and run JavaServer Pages, a compatible web server with a servlet container, such as Apache Tomcat or Jetty,
									is required.
								</p>
							</div>
							<div class="ui raised very padded text container segment">
								<h2 class="ui header right floated">Spring Web MVC</h2>
								<div class="ui clearing divider"></div>
								<p>Spring Web MVC is the original web framework built on the Servlet API and included in the Spring Framework from the
									very beginning. The formal name "Spring Web MVC" comes from the name of its source module spring-webmvc but it is
									more commonly known as "Spring MVC".</p>
								<p>Parallel to Spring Web MVC, Spring Framework 5.0 introduced a reactive stack, web framework whose name Spring WebFlux
									is also based on its source module spring-webflux. This section covers Spring Web MVC. The next section covers Spring
									WebFlux.
								</p>
								<p>For baseline information and compatibility with Servlet container and Java EE version ranges please visit the Spring
									Framework Wiki.</p>
							</div>
							<div class="ui raised very padded text container segment">
								<h2 class="ui header right floated">Web application security</h2>
								<div class="ui clearing divider"></div>
								<p>Web application security, is a branch of Information Security that deals specifically with security of websites,
									web applications and web services. At a high level, Web application security draws on the principles of application
									security but applies them specifically to Internet and Web systems.[1]</p>
								<h3 class="ui header right floated">Security threats</h3>
								<div class="ui clearing divider"></div>
								<p>With the emergence of Web 2.0, increased information sharing through social networking and increasing business adoption
									of the Web as a means of doing business and delivering service, websites are often attacked directly. Hackers either
									seek to compromise the corporate network or the end-users accessing the website by subjecting them to drive-by downloading</p>
								<p>As a result, industry[4] is paying increased attention to the security of the web applications[5] themselves in addition
									to the security of the underlying computer network and operating systems.</p>
								<p>The majority of web application attacks occur through cross-site scripting (XSS) and SQL injection attacks[6] which
									typically result from flawed coding, and failure to sanitize input to and output from the web application. These
									are ranked in the 2009 CWE/SANS Top 25 Most Dangerous Programming Errors.</p>
								<p>Phishing is another common threat to the Web application and global losses from this type of attack in 2012 were
									estimated at $1.5 billion.
								</p>
								<p>According to the security vendor Cenzic, the top vulnerabilities in March 2012 include:</p>
								<ul>
									<li>37% Cross-site scripting</li>
									<li>16% SQL injection</li>
									<li>5% Path disclosure</li>
									<li>5% Denial-of-service attack</li>
									<li>4% Arbitrary code execution</li>
									<li>4% Memory corruption</li>
									<li>4% Cross-site request forgery</li>
									<li>3% Data breach (information disclosure)</li>
									<li>3% Arbitrary file inclusion</li>
									<li>2% Local file inclusion</li>
									<li>1% Remote file inclusion</li>
									<li>1% Buffer overflow</li>
									<li>15% Other, including code injection (PHP/JavaScript), etc.</li>
								</ul>
							</div>

							<%-- FOOTER --%>
								<%-- 
		Is the 'jsp:include' the best way to avoid repeat a lot of code?
	--%>
									<jsp:include page="base/footer.jsp" />
									<%-- FOOTER --%>

			</body>

			</html>