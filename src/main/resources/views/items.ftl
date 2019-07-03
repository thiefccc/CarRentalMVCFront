<html>
<head>
    <title>Renters</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/includer.js"></script>
</head>
<body>
<div id="navigation"></div>
<form method="post" action="/items">
    <div class="form-group">
        <label for="rentedItemName">Item name</label>
        <input type="text" class="form-control" id="rentedItemName" name="rentedItemName" placeholder="Item name">
    </div>
    <input hidden type="text" value="1" id="rentedItemType" name="rentedItemType">
    <div class="form-group">
        <label for="carModel">Car model</label>
        <input type="text" class="form-control" id="carModel" name="carModel" placeholder="Car model">
    </div>
    <div class="form-group">
        <label for="carModel">Car plate number</label>
        <input type="text" class="form-control" id="carPlateNumber" name="carPlateNumber" placeholder="Car plate number">
    </div>
    <input hidden type="text" value="true" id="isRented" name="isRented">
    <button type="submit" class="btn btn-primary">Add item</button>
</form>
<hr>
<table class="table table-striped">
    <tr>
        <th hidden>Item Id</th>
        <th>Item name</th>
        <th>Car model</th>
        <th>Car plate number</th>
        <th>Is Free</th>
    </tr>
    <#list itemsFromService as item>
        <tr>
            <td hidden>${item.rentedItemId}</td>
            <td>${(item.rentedItemName)!""}</td>
            <td>${(item.carModel)!""}</td>
            <td>${(item.carPlateNumber)!""}</td>
            <td><#if item.isRented == true>
                    Rented
                <#else>
                    Free
                </#if>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
