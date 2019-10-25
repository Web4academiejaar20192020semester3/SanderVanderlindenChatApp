<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Chatpagina" />
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Chatpagina" />
	</jsp:include>
	<main>
        <c:choose>
            <c:when test="${user != null}">
                <h3>Hi ${user.getFirstName()}!</h3>
                <div id="status"></div>

                <h3>Change Status</h3>
                <input type="text" id="statusInput" placeholder="status..."/>
                <input type="button" id="statusButton" value="Change"/>

                <h3>Vrienden</h3>
                <table>
                    <tr>
                        <th>Naam</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="vriend" items="${user.getFriends()}">
                        <tr>
                            <td>${vriend.firstName}</td>
                            <td>${vriend.status}</td>
                        </tr>
                    </c:forEach>
                </table>
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

        <script type="text/javascript" src="js/status.js"></script>
	</main>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Chatpagina" />
	</jsp:include>
</body>
</html>