<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="History" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="History" />
</jsp:include>
<main>
    <div class="left" style="background-color:#EEEEEE;">
        <h3>Chat-history</h3>
        <div id="history"></div>
    </div>
    <script type="text/javascript" src="js/history.js"></script>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Historypagina" />
</jsp:include>
</body>
</html>