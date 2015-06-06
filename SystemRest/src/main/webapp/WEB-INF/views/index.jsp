<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="http://code.jquery.com/jquery-2.1.4.js" type="text/javascript"></script>
    <script src="http://localhost:8080/resources/js/jquery.flot.js" type="text/javascript"></script>
    <script src="http://localhost:8080/resources/js/default.js" type="text/javascript"></script>


    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>SystemMonitor</title>
    <style>
        #memory-flot {
            width: 100%;
            height: 300px;
        }
        .center {
            padding: 100px 300px 0 300px;
        }
        .grid-title {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1 class="grid-title">Memory Monitor</h1>
    <div id="memory-flot"></div>
    <div id="disk-c-flot"></div>
    <div id="disk-d-flot"></div>
    <div id="disk-e-flot"></div>
</div>

</body>
</html>