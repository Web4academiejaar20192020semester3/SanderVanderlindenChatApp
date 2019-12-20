<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<main>
    <c:choose>
        <c:when test="${user != null}">

            <div class="grid-container">
                <div class="left" style="background-color:#EEEEEE;">
                    <h3>Hi ${user.getFirstName()}!</h3>

                    <h3>Status</h3>
                    <div id="status"></div>

                    <h3>Friends</h3>
                    <div id="friends"></div>

                    <h3>Change Status</h3>
                    <input type="text" id="statusInput" placeholder="status..."/>
                    <input type="button" id="changeStatusButton" value="Change"/>

                    <h3>Add Friend</h3>
                    <input type="text" id="newFriendId" placeholder="friend id..."/>
                    <input type="button" id="addFriendButton" value="Add"/>


                </div>
                <div class="right" style="background-color:#FFCC00;">
                    <button id="toggleChatButton">Hide chat</button>
                    <div id="chatWindow">
                        <div id="chatWindowName">Klik op een naam!</div>
                        <div id="chatWindowContent"></div>
                        <div id="chatWindowSendDiv">
                            <input type="text" id="chatWindowInput" placeholder="type message...">
                            <button id="chatWindowSendButton">send</button>
                        </div>
                        <input type="hidden" id="receiver" name="receiver"/>
                        <input type="hidden" id="sender" name="sender" value="${user.userId}"/>
                    </div>
                </div>
            </div>
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

    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/friendList.js"></script>
    <script type="text/javascript" src="js/addFriend.js"></script>
    <script type="text/javascript" src="js/chat.js"></script>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chatpagina" />
</jsp:include>
</body>
</html>