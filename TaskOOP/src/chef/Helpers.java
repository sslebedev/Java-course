package chef;

import chef.products.Vegetable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Сергей on 07.10.2015.
 */
public class Helpers {
    public static List<Product> getProductsInCalRange(List<Product> vegetables1, float min, int max) {
        return vegetables1.stream().filter(product -> min <= product.getCalories() && product.getCalories() <= max)
                .collect(Collectors.toList());
    }

    public static List<Product> getCalSortedVegetables(Dish dish) {
        return dish.getComposition().stream().filter(ingredient -> ingredient.getProduct() instanceof Vegetable)
                .map(Ingredient::getProduct)
                .sorted((p1, p2) -> Float.compare(p1.getCalories(), p2.getCalories()))
                .collect(Collectors.toList());
    }
}
