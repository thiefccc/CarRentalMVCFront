<html>
<head>
    <title>Rents</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
    <script src="../js/includer.js"></script>
    <script src="../js/rents/inputMasks.js"></script>
    <script src="../js/rents/selectFiller.js"></script>
    <script src="../js/rents/actionButtonsHandler.js"></script>
</head>
<body>
<div id="navigation"></div>
<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h5 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    Open Rent form
                </button>
            </h5>
        </div>
        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
                <form method="post" action="/rents" id="openRent">
                    <div class="form-group">
                        <label for="rentedItemId">Rented item</label>
                        <select class="form-control" id="rentedItemId" name="rentedItemId"></select>
                    </div>
                    <div class="form-group">
                        <label for="renterId">Renter</label>
                        <select class="form-control" id="renterId" name="renterId"></select>
                    </div>
                    <div class="form-group">
                        <label for="getRentalOfficeId">Get office</label>
                        <select class="form-control" id="getRentalOfficeId" name="getRentalOfficeId"></select>
                    </div>
                    <div class="form-group">
                        <label for="expirationDate">Expiration date</label>
                        <input type="text" class="form-control datePicker" id="expirationDate" name="expirationDate">
                    </div>
                    <div class="form-group">
                        <label for="rentInfo">Rent info</label>
                        <input type="text" class="form-control" id="rentInfo" name="rentInfo">
                    </div>
                    <button type="submit" class="btn btn-primary">Open rent</button>
                </form>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingTwo">
            <h5 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Extend Rent form
                </button>
            </h5>
        </div>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card-body">
                <form method="post" action="/rents" id="extendRent">
                    <input type="hidden" name="_method" value="PUT">
                    <input hidden type="text" class="form-control" id="extRentId" name="rentId">
                    <div class="form-group">
                        <label for="expirationDate">New expiration date</label>
                        <input type="text" class="form-control datePicker" id="expirationDate" name="expirationDate">
                    </div>
                    <button type="submit" class="btn btn-primary">Extend date</button>
                </form>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingThree">
            <h5 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Close Rent form
                </button>
            </h5>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                <form method="post" action="/rents" id="closeRent">
                    <input type="hidden" name="_method" value="PUT">
                    <input hidden type="text" class="form-control" id="closeRentId" name="rentId">
                    <div class="form-group">
                        <label for="returnRentalOfficeId">Return office</label>
                        <select class="form-control" id="returnRentalOfficeId" name="returnRentalOfficeId"></select>
                    </div>
                    <button type="submit" class="btn btn-primary">Close rent</button>
                </form>
            </div>
        </div>
    </div>
</div>

<table class="table table-striped">
    <tr>
        <th scope="col" hidden>Id</th>
        <th scope="col">Car Mark</th>
        <th scope="col">Plate number</th>
        <th scope="col">Renter</th>
        <th scope="col">Expiration date</th>
        <th scope="col">Receipt office</th>
        <th scope="col">Receipt date</th>
        <th scope="col">Return office</th>
        <th scope="col">Return date</th>
        <th scope="col">Info</th>
        <th scope="col">Actions</th>
    </tr>
    <#assign host = "http://localhost:8083">
    <#list rentsFromService as rent>
        <tr>
            <td hidden>${rent.rentId}</td>
            <td><a href="${host}/rents/${rent.rentedItem.rentedItemId}">${rent.rentedItem.carModel}</a></td>
            <td>${rent.rentedItem.carPlateNumber}</td>
            <td>${rent.renter.renterName}</td>
            <td>${rent.expirationDate?date}</td>
            <td>${rent.getRentalOffice.rentalOfficeName}</td>
            <td>${rent.getTimestamp?datetime}</td>
            <td>${(rent.returnRentalOffice.rentalOfficeName)!""}</td>
            <td>${(rent.returnTimestamp?datetime)!""}</td>
            <td>${(rent.rentInfo)!""}</td>
            <td>
                <#if (rent.returnTimestamp)??>
                <#else>
                <a href="" class="ext_link" rentId=${rent.rentId}>Ext.</a>
                <a href="" class="close_link" rentId=${rent.rentId}>Close</a>
                </#if>
            </td>
            <td></td>
        </tr>
    </#list>
</table>
</body>
</html>
