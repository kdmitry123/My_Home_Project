<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<table class="table">
  <thead class="thead-light">
  <tr>
    <th scope="col">Date</th>
    <th scope="col">Value</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${items}">
    <tr>
      <td>${item.getDate()}</td>
      <td>${item.getValue()}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>


<jsp:include page="footer.jsp"/>