package chef.products.vegetables;

import chef.products.Vegetable;

/**
 * Created by Сергей on 05.10.2015.
 *
 * For example: horseradish
 */
public class Spice extends Vegetable {
    /**
     * @param name name
     * @param calories calories in 1 kg
     */
    public Spice(String name, float calories) {
        super(name, calories);
    }
}
