<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:if test="${not empty query}">
    <s:eval expression="T(java.net.URLEncoder).encode(query)" var="urlQuery" />
    <c:set var="urlQuery" value="?query=${urlQuery}" />
</c:if>
<c:set var="bibtex" value="view-bibtext" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>We &hearts; Justin BibTex!</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/justinbiber.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.js"></script>
        <![endif]-->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/justin.js"></script>
        <script>
            $(function() {
                // collapse navbar when clicked anywhere in the page
                var searchInput = $('#query');
                $(document).on('click', function(e) {
                    if (e.target !== searchInput.get(0)) {
                        $('.navbar-collapse.in').collapse('hide');
                    }
                });
                // update preview link
                var previewLink = $('#preview');
                function updatePreviewLink() {
                    var url = '${bibtex}';
                    var query = $(this).val();
                    if (query) {
                        url += '?query=' + encodeURIComponent(query);
                    }
                    previewLink.attr('href', url);
                }
                searchInput.on('input', updatePreviewLink);
            });
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="list">We &hearts; Justin <img class="bibtex" src="http://upload.wikimedia.org/wikipedia/commons/3/30/BibTeX_logo.svg" alt="BibTex">!</a>
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <form action="${pageContext.request.contextPath}/app/list" class="navbar-form navbar-left" role="search" method="get">
                        <div class="form-group">
                            <input id="query" name="query" type="text" class="form-control" placeholder="Search" value="${query}">
                        </div>
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a id="preview" class="btn btn-primary ${param.preview}" href="${bibtex}${urlQuery}">Preview</a></li>
                        <li><a class="btn btn-primary ${param.addClass}" href="add">Add new</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
        <div class="container">