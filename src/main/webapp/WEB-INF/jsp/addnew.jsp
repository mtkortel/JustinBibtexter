<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ohtu.justinbiber.domain.Entry"%>
<%@page import="ohtu.justinbiber.domain.EntryType"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="addClass" value="disabled"/>
</jsp:include>
<!--
<script lang="javascript">
    $(document).ready(function() {
        $('#foo').change(function() {
            if($('#foo').val() == 1){
                // Number of inputs to create
                //var number = document.getElementById("member").value;
                // Container <div> where dynamic content will be placed
                var container = document.getElementById("add-bibtext");
                // Clear previous contents of the container
                while (container.hasChildNodes()) {
                    container.removeChild(container.lastChild);
                }
                for (i=0;i<number;i++){
                    // Append a node with a random text
                    container.appendChild(document.createTextNode("Author: " ));
                    // Create an <input> element, set its type and name attributes
                    var input = document.createElement("input");
                    input.type = "text";
                    input.name = "author";
                    container.appendChild(input);
                    // Append a line break 
                    container.appendChild(document.createElement("br"));
                }
            } else if($('#foo').val()==2{
                //your code here
            }
        //etc. etc.
        });
    });
</script>
-->
<!--
<form>
    <select id="foo" onchange="this.form.ready();">
        <option value='1'>Inproceedings</option>
        <option value='2'>N/A</option>        
        <option value='3'>N/A</option>
    </select>
</form>
<form action="add-bibtext" method="post">

</form>
-->
<form role="form" action="add-bibtext" method="post" modelAttribute="bib">
    <div class="form-group">
        <label for="bibtype">Entry type</label>
        <select class="form-control" id="bibtype" name="bibtype">
            <c:forEach var="type" items="${types}">
                <option value="${type.key}">${type.key}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="id">Author</label>
        <input type="text" class="form-control" id="id" name="id">
    </div>
    <div class="form-group">
        <label for="author">Author</label>
        <input type="text" class="form-control" id="author" name="author">
    </div>
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="form-group">
        <label for="title">Booktitle</label>
        <input type="text" class="form-control" id="booktitle" name="booktitle">
    </div>
    <div class="form-group">
        <label for="title">Year</label>
        <input type="number" class="form-control" id="year" name="year">
    </div>
    <div class="text-right">
        <input type="submit" class="btn btn-primary" value="Submit"/>
        <a class="btn btn-default" href="list">Cancel</a>
    </div>
</form>
<script>
    $(function() {
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
    });
</script>
<%@include file="footer.jsp"%>
