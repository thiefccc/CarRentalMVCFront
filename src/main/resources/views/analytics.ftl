<html>
<head>
    <title>Renters</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/includer.js"></script>
</head>
<body>
<div id="navigation"></div>
<table class="table table-striped">
    <tr>
        <th>Average rental duration (days)</th>
        <th>Car model</th>
        <th>Get rental point</th>
    </tr>
    <#list reportRows as row>
        <tr>
            <td>${(row.avgDuration)!""}</td>
            <td>${(row.carModel)!""}</td>
            <td>${(row.rentalOfficeName)!""}</td>
        </tr>
    </#list>
</table>
</body>
</html>
