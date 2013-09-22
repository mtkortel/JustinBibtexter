<%@page import="ohtu.justinbiber.domain.Entry"%>
<%@page import="ohtu.justinbiber.domain.EntryType"%>
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
          <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.js"></script>
        <![endif]-->
    </head>
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
    <body>
        <div class="container">
            <h1>We &hearts; Justin <img class="bibtex" src="http://upload.wikimedia.org/wikipedia/commons/3/30/BibTeX_logo.svg" height=""alt="BibTex">!</h1>
        
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
            <form action="add-bibtext" method="post" modelAttribute="bib">
                Viite tyyppi 
                <select id="bibtype" name="bibtype">
                    <option value="inproceedings">Inproceedings</option>
                </select>
                Author <input type="text" id="author" name="author"/>
                Title <input type="text" id="title" name="title"/>
                Booktitle <input type="text" id="booktitle" name="booktitle"/>
                Year <input type="number" id="year" name="year"/>
                <input type="submit" value="Add New"/>
            </form>
            
    </body>
</html>
