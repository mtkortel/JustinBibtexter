<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ohtu.justinbiber.domain.Entry"%>
<%@page import="ohtu.justinbiber.domain.EntryType"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="addClass" value="disabled"/>
</jsp:include>

<script lang="javascript">
    $(document).ready(function() {

	function hide_all() {
		$('label[for="author"]').hide();
		$('label[for="title"]').hide();
		$('label[for="journal"]').hide();
		$('label[for="booktitle"]').hide();
		$('label[for="year"]').hide();
		$('label[for="month"]').hide();
		$('label[for="publisher"]').hide();
		$('label[for="howpublished"]').hide();
		$('label[for="note"]').hide();
		$('label[for="keyname"]').hide();
		$('#author').hide();
    		$('#title').hide();
		$('#journal').hide();
		$('#booktitle').hide();
		$('#year').hide();
		$('#month').hide();
		$('#publisher').hide();
		$('#howpublished').hide();
		$('#note').hide();
		$('#keyname').hide();
	}

	$("#bibtype").change(function(event) {
		hide_all();
	    	if ($('#bibtype').val() == 'inproceedings') {

//    An article in a conference proceedings.
//    Required fields: author, title, booktitle, year
//    Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key

			$('label[for="author"]').show();
       	         	$('label[for="title"]').show();
       	         	$('label[for="booktitle"]').show();
                	$('label[for="year"]').show();
		        $('#author').show();
	        	$('#title').show();
	        	$('#booktitle').show();
	        	$('#year').show();
	    	} else if ($('#bibtype').val() == 'book') {

//    A book with an explicit publisher.
//    Required fields: author/editor, title, publisher, year
//    Optional fields: volume/number, series, address, edition, month, note, key

                        $('label[for="author"]').show();
                        $('label[for="title"]').show();
                        $('label[for="publisher"]').show();
                        $('label[for="year"]').show();
	       		$('#author').show();
	        	$('#title').show();
	        	$('#publisher').show();
	        	$('#year').show();
	    	} else if ($('#bibtype').val() == 'article') {

//    An article from a journal or magazine.
//    Required fields: author, title, journal, year
//    Optional fields: volume, number, pages, month, note, key

                        $('label[for="author"]').show();
                        $('label[for="title"]').show();
                        $('label[for="journal"]').show();
                        $('label[for="year"]').show();
                        $('#author').show();
                        $('#title').show();
                        $('#journal').show();
                        $('#year').show();
		} else if ($('#bibtype').val() == 'misc') {

//    For use when nothing else fits.
//    Required fields: none
//    Optional fields: author, title, howpublished, month, year, note, key

                        $('label[for="author"]').show();
                        $('label[for="title"]').show();
                        $('label[for="howpublished"]').show();
			$('label[for="month"]').show();
                        $('label[for="year"]').show();
			$('label[for="note"]').show();
			$('label[for="keyname"]').show();
                        $('#author').show();
                        $('#title').show();
                        $('#howpublished').show();
                        $('#month').show();
                        $('#year').show();
                        $('#note').show();
                        $('#keyname').show();
                }

	});

	$("#bibtype").val('book').change();

/*
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
*/

    });
</script>

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
                <option value="${type.keyname}">${type.keyname}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="id">Id</label>
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
        <label for="publisher">Publisher</label>
        <input type="text" class="form-control" id="publisher" name="publisher">
    </div>
    <div class="form-group">
        <label for="journal">Journal</label>
        <input type="text" class="form-control" id="journal" name="journal">
    </div>
    <div class="form-group">
        <label for="booktitle">Booktitle</label>
        <input type="text" class="form-control" id="booktitle" name="booktitle">
    </div>
    <div class="form-group">
        <label for="howpublished">Howpublished</label>
        <input type="text" class="form-control" id="howpublished" name="howpublished">
    </div>
    <div class="form-group">
        <label for="month">Month</label>
        <input type="number" class="form-control" id="month" name="month">
    </div>
    <div class="form-group">
        <label for="year">Year</label>
        <input type="number" class="form-control" id="year" name="year">
    </div>
    <div class="form-group">
        <label for="note">Note</label>
        <input type="text" class="form-control" id="note" name="note">
    </div>
    <div class="form-group">
        <label for="keyname">Key</label>
        <input type="text" class="form-control" id="keyname" name="keyname">
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
