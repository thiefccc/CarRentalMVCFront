package models;

import forms.RenterForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Renter {
    private Long renterId;
    private String renterName;
    private String renterInfo;
    
    public static Renter from(RenterForm form){
        return Renter
                .builder()
                .renterName(form.getRenterName())
                .renterInfo(form.getRenterInfo())
                .build();
    }
}
