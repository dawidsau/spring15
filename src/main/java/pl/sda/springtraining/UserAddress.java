package pl.sda.springtraining;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private String zipCode;
    private String city;
    private Countries country;
    private String street;
}
