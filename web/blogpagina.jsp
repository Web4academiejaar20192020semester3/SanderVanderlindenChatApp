<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Blogpagina" />
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Blogpagina" />
	</jsp:include>
	<main>
        <c:choose>
            <c:when test="${user != null}">
                <h3>Hi ${user.getFirstName()}!</h3>

                <h3>Topics</h3>
                <div id="blogtopics"></div>

            </c:when>
            <c:otherwise>
                <p>Login required!</p>
                <form method="post" action="Controller?action=LogIn">
                    <p>
                        <label for="email">Your email </label>
                        <input type="text" id="email" name="email" value="jan@ucll.be">
                    </p>
                    <p>
                        <label for="password">Your password</label>
                        <input type="password" id="password" name="password" value="t">
                    </p>
                    <p>
                        <input type="submit" id="loginbutton" value="Log in">
                    </p>
                </form>
            </c:otherwise>
        </c:choose>

        <script type="text/javascript" src="js/blogTopicList.js"></script>
    </main>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Blogpagina" />
	</jsp:include>
</body>
</html>