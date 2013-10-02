<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="preview" value="disabled"/>
</jsp:include>
<pre>
${preview}
</pre>
<%@include file="footer.jsp"%>
