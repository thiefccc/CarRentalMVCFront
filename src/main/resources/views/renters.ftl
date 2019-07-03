<html>
<head>
    <title>Renters</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/includer.js"></script>
</head>
<body>
<div id="navigation"></div>
<form method="post" action="/addRenter">
    <div class="form-group">
        <label for="renterName">Renter name</label>
        <input type="text" class="form-control" id="renterName" name="renterName" placeholder="Enter new renter name">
    </div>
    <div class="form-group">
        <label for="renterInfo">Renter info</label>
        <input type="text" class="form-control" id="renterInfo" name="renterInfo" placeholder="Enter renter address or info">
    </div>
    <button type="submit" class="btn btn-primary">Add renter</button>
</form>
<hr>
<table class="table table-striped">
    <tr>
        <th>Renter Id</th>
        <th>Renter Name</th>
        <th>Renter Info</th>
    </tr>
    <#list rentersFromService as renter>
        <tr>
            <td>${(renter.renterId)!""}</td>
            <td>${(renter.renterName)!""}</td>
            <td>${(renter.renterInfo)!""}</td>
        </tr>
    </#list>
</table>
</body>
</html>
