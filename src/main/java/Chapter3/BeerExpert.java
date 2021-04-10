package Chapter3;

import java.util.ArrayList;
import java.util.List;

//Model Class
public class BeerExpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        switch (color) {
            case "amber" -> {
                brands.add("Jack Amber");
                brands.add("Red Moose");
            }
            default -> {
                brands.add("Jail Pale Ale");
                brands.add("Gout Stout");
            }
        }
        return brands;
    }
}
