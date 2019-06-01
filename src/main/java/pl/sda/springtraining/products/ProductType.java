package pl.sda.springtraining.products;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    FOOD("Jedzenie"),
    BOOK("Ksiązka"),
    FISH("Ryby");

    String plName;
}
