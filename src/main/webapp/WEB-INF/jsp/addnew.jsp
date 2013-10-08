<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ohtu.justinbiber.domain.Entry"%>
<%@page import="ohtu.justinbiber.domain.EntryType"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="addClass" value="disabled"/>
</jsp:include>

<form role="form" action="add-bibtext" method="post" modelAttribute="bib">
    <div class="form-group">
        <label for="bibtype">Entry type</label>
        <select class="form-control" id="bibtype" name="bibtype">
            <c:forEach var="type" items="${types}">
                <option value="${type.typeKey}">${type.typeKey}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="key">key</label>
        <input type="text" class="form-control" id="key" name="key">
    </div>
    <c:forEach var="type" items="${types}">
        <div class="fields ${type.typeKey}">
            <c:forEach var="field" items="${type.requiredFieldTypes}">
                <div class="form-group">
                    <label for="${type.typeKey}_${field.fieldKey}">${field.fieldKey}</label>
                    <input type="${field.valueType.typeString}" class="form-control" id="${type.typeKey}_${field.fieldKey}" name="${type.typeKey}_${field.fieldKey}" disabled>
                </div>
            </c:forEach>
        </div>
    </c:forEach>
    <div class="text-right">
        <input type="submit" class="btn btn-primary" value="Submit">
        <a class="btn btn-default" href="list">Cancel</a>
    </div>
</form>

<script>
    $(function() {
        // disable form sending when enter is pressed
        ctrls = $('form').find('select, input');
        $('form').on('keypress', 'select, input', function(e) {
            ctrl = $(this);
            if (e.keyCode === 13) {
                if (ctrl.attr('type') !== 'submit' &&
                        ctrl.attr('type') !== 'number') {
                    e.preventDefault();
                    next = $(ctrls[ctrls.index(ctrl) + 1]);
                    next.focus();
                }
            }
        });
        // show selected fields
        var bibtype = $('#bibtype');
        function onchange() {
            var type = bibtype.val();
            var all = $('.fields');
            var sel = $('.fields.' + type);
            all.hide();
            all.find('input').prop('disabled', true);
            sel.show();
            sel.find('input').prop('disabled', false);
        }
        bibtype.change(onchange);
        onchange();
    });
</script>
<%@include file="footer.jsp"%>
