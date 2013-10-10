<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<c:forEach var="entry" items="${entries}">
            <div id="entry_${entry.id}" class="panel panel-default entry">
                <div class="panel-heading">
                    <h4>${entry.title}</h4>
                </div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <c:forEach var="field" items="${entry.fields}">
                            <dt>${field.fieldKey}</dt><dd>${field.fieldValue}</dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
</c:forEach>
            <script>
            $(function() {
                justin.filtered(function(entries) {
                    $('.entry').hide();
                    entries.forEach(function(e) {
                        $('#entry_'+e.id).show();
                    });
                })
            });
            </script>
<%@include file="footer.jsp"%>
