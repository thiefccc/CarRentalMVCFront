package models;

import forms.RentForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    private Long rentId;
    private Date getTimestamp;
    private Date returnTimestamp;
    private Date expirationDate;
    private String rentInfo;

    private Renter renter;
    private RentedItem rentedItem;
    private RentalOffice getRentalOffice;
    private RentalOffice returnRentalOffice;

    public static Rent buildFromOpenForm(RentForm form) throws ParseException {
        Renter renter = Renter.builder()
            .renterId(form.getRenterId())
            .build();
        RentedItem item = RentedItem.builder()
            .rentedItemId(form.getRentedItemId())
            .build();
        RentalOffice office = RentalOffice.builder()
            .rentalOfficeId(form.getGetRentalOfficeId())
            .build();

        return Rent.builder()
            .renter(renter).rentedItem(item).getRentalOffice(office)
            .expirationDate(new SimpleDateFormat("dd-MM-yyyy").parse(form.getExpirationDate()))
            .rentInfo(form.getRentInfo())
            .build();
    }

    public static Rent buildFromUpdateForm(RentForm form) throws ParseException {
        RentalOffice office = null;
        Date newExpirationDate = null;
        if(form.getExpirationDate() == null) {
            office = RentalOffice.builder()
                    .rentalOfficeId(form.getReturnRentalOfficeId())
                    .build();
        }
        else{
            newExpirationDate = new SimpleDateFormat("dd-MM-yyyy").parse(form.getExpirationDate());
        }

        return Rent.builder()
                .rentId(form.getRentId())
                .returnRentalOffice(office)
                .expirationDate(newExpirationDate)
                .build();
    }
}

