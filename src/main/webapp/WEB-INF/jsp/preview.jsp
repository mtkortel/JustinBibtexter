<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="preview" value="disabled"/>
</jsp:include>
<pre><c:forEach var="entrybib" items="${preview}"><div id="entry_${entrybib.entry.id}" class="entry">${entrybib.bibtex}</div></c:forEach></pre>
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
