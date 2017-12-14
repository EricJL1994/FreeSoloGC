<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.user != null}">
    <a href="/logout">
        <button type="button" class="btn btn-danger">Logout</button>
    </a>
</c:if>
