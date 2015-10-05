package chef.products;

import chef.Product;

/**
 * Created by Сергей on 05.10.2015.
 *
 * Vegetable is basic vegetable
 */
public abstract class Vegetable extends Product{
    public Vegetable(String name, float calories) {
        super(name, calories);
    }
}
