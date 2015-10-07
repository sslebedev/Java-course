package chef.products.liquids;

import chef.Product;
import chef.products.Measure;

/**
 * Created by Сергей on 06.10.2015.
 *
 * For example: olive oil
 */
public class Oil extends Product {
    /**
     * @param name     name
     * @param calories calories in 1 liter
     */
    public Oil(String name, float calories) {
        super(name, calories);
    }

    @Override
    public Measure getMeasure() {
        return Measure.LITER;
    }
}
