<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<c:forEach var="entry" items="${entries}">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4>${entry.title}</h4>
        </div>
        <div class="panel-body">
            <dl class="dl-horizontal">
                <c:forEach var="field" items="${entry.fields}">
                    <dt>${field.key}</dt><dd>${field.value}</dd>
                </c:forEach>
            </dl>
        </div>
    </div>
</c:forEach>
<%@include file="footer.jsp"%>
