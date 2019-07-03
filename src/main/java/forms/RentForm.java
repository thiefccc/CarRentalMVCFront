package forms;

import lombok.Data;

import java.util.Date;

@Data
public class RentForm {
    private Long rentId;
    private String expirationDate;
    private String rentInfo;
    private Long renterId;
    private Long rentedItemId;
    private Long getRentalOfficeId;
    private Long returnRentalOfficeId;
}