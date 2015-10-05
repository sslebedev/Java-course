package chef.products;

import chef.Product;

/**
 * Created by Сергей on 05.10.2015.
 * <p>
 * Vegetable is basic vegetable
 * Concrete classification is based on http://recept.domovest.ru/produkti/3-ovoshi.html
 * Why not?
 */
public abstract class Vegetable extends Product {
    /**
     * @param name name
     * @param calories calories in 1 kg
     */
    public Vegetable(String name, float calories) {
        super(name, calories);
    }
}
