<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ohtu.justinbiber.domain.Entry"%>
<%@page import="ohtu.justinbiber.domain.EntryType"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="addClass" value="disabled"/>
</jsp:include>

<script lang="javascript">

// inproceedings
//    An article in a conference proceedings.
//    Required fields: author, title, booktitle, year
//    Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key

// book
//    A book with an explicit publisher.
//    Required fields: author/editor, title, publisher, year
//    Optional fields: volume/number, series, address, edition, month, note, key

// article
//    An article from a journal or magazine.
//    Required fields: author, title, journal, year
//    Optional fields: volume, number, pages, month, note, key

// misc
//    For use when nothing else fits.
//    Required fields: none
//    Optional fields: author, title, howpublished, month, year, note, key

	$(document).ready(function() {

		// EntryType ja FieldType arrayt pitaisi saada Java puolelta tahan..

		var EntryType = {
			'article' : ['author', 'title', 'journal', 'year'],
			'book' : ['author', 'title', 'publisher', 'year'],
			'inproceedings' : ['author', 'title', 'booktitle', 'year'],
			'misc' : ['author', 'title', 'howpublished', 'month', 'year', 'note', 'key']
		};

		var FieldType = {
			'author' : 'text',
			'title' : 'text',
			'booktitle' : 'text',
			'year' : 'number',
			'editor' : 'text',
			'publisher' : 'text',
			'journal' : 'text',
			'howpublished' : 'text',
			'month' : 'number',
			'note' : 'text',
			'key' : 'text'
		};

		function print_fields() {
			$.each(FieldType, function(key, value) {
				$('#content').append('<div class="form-group"><label for="' + key + '">' + key.substr(0,1).toUpperCase() + key.substr(1) + '</label><input type="' + value + '" class="form-control" id="' + key + '" name="' + key + '"></div>');
			});
		}

		function hide_all() {
			$('label').hide();

			$('input').hide();
//			$('input').attr('disabled','disabled').hide();

			$('label[for="id"]').show();
			$('#id').removeAttr('disabled').show();

			$('input[type="submit"]').removeAttr('disabled').show();
		}

		$("#bibtype").change(function(event) {
			hide_all();
			$.each(EntryType, function(key, value) {
				if ($('#bibtype').val() == key) {
					$.each(value, function(key2, value2) {
						$('label[for="' + value2 + '"]').show();
						$('#' + value2 + '').removeAttr('disabled').show();
					});
				}
			});
		});

		print_fields();
		$("#bibtype").val('article').change();

	});
</script>

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
        <label for="id">Id</label>
        <input type="text" class="form-control" id="id" name="id">
    </div>

    <div id="content"></div>

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
