<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h1>Sensor Catalog</h1>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Serial Number</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="item" items="${items}">
    <tr>
      <th scope="row">${item.id}</th>
      <td><a href="${pageContext.request.contextPath}/sensor/${item.serialnumber}">${item.serialnumber}</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<jsp:include page="footer.jsp"/>