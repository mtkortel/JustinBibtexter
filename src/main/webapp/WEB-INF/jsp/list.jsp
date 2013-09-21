<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>We &hearts; Justin BibTex!</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/justinbiber.css" rel="stylesheet"
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">
            <h1>We &hearts; Justin <img class="bibtex" src="http://upload.wikimedia.org/wikipedia/commons/3/30/BibTeX_logo.svg" height=""alt="BibTex">!</h1>
            <c:forEach var="entry" items="${entries}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>${entry.getValue("title")}</h4>
                    </div>
                    <div class="panel-body">
                        <dl class="dl-horizontal">
                            <c:forEach var="field" items="${entry.getFields()}">
                                <dt>${field.getKey()}</dt><dd>${field.getValue()}</dd>
                            </c:forEach>
                        </dl>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
