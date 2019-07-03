package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentedItem {
    private Long rentedItemId;
    private String rentedItemName;
    private String rentedItemType;
    private String carModel;
    private String carPlateNumber;
    private Boolean isRented;
}