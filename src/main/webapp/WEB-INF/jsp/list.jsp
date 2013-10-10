<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="query" value="${query}"/>
</jsp:include>
<c:forEach var="entry" items="${entries}">
            <div id="entry_${entry.id}" class="panel panel-default entry">
                <div class="panel-heading">
                    <h4>${entry.title}</h4>
                </div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <c:forEach var="field" items="${entry.fields}">
                            <div id="field_${field.id}">
                                <dt>${field.key}</dt><dd>${field.value}</dd>
                            </div>
                        </c:forEach>
                    </dl>
                </div>
            </div>
</c:forEach>
            <script src="${pageContext.request.contextPath}/app/entries.js"></script>
            <script>
                function update(entries) {
                    $('.entry').hide();
                    entries.forEach(function(e) {
                        $('#entry_'+e.id).show();
                    });
                }
                $('#query').on('input', function() {
                    justin.filter($(this).val(), update);
                });
                // filter on load
                justin.filter('${query}', update);
            </script>
<%@include file="footer.jsp"%>
