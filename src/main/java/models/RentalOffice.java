package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalOffice {
    private Long rentalOfficeId;
    private String rentalOfficeName;
    private String rentalOfficeAddress;
}
