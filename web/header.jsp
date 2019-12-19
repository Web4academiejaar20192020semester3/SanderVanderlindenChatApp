<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <img alt="Books" src="images/banner.jpg">
    <h1><span>Chat App</span></h1>
    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title=='Home'}">
                    <li id="actual"><a class="actuala" href="Controller">Home</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller">Home</a></li>
                </c:otherwise>
            </c:choose>

            <c:if test="${user != null}">
                <c:choose>
                    <c:when test="${param.title=='Chat'}">
                        <li id="actual"><a class="actuala" href="Controller?action=Chatpagina">Chat</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="Controller?action=Chatpagina">Chat</a></li>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${param.title=='Blog'}">
                        <li id="actual"><a class="actuala" href="Controller?action=BlogPagina">Blog</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="Controller?action=Blogpagina">Blog</a></li>
                    </c:otherwise>
                </c:choose>
            </c:if>

        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>

</header>