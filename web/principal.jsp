<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_top.jsp" %>
<div class="col-lg-12">

    <ul class="col-lg-12">
        <c:forEach var="opcion" items="${MenuPrincipal}">
            <li class=""><a href="${pageContext.servletContext.contextPath}/${opcion.comando}?op=${opcion.idComando}">${opcion.comando}</a></li>
            </c:forEach>
    </ul>

</div>

<%@include file="_down.jsp" %>
