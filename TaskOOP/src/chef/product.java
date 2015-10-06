package chef;

import chef.products.Measure;

/**
 * Created by Сергей on 05.10.2015.
 *
 * Anything to be food is product:
 *   something named and energetically valuable
 */
public abstract class Product {
    private String name;
    private float calories;

    /**
     * @param name name
     * @param calories calories in 1 measure
     */
    public Product(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    /**
     * @return Vegetable name
     */
    public String getName() { return name; }

    /**
     * @return Calories in 1 measure
     */
    public float getCalories() {
        return calories;
    }

    /**
     * @return Measure type
     */
    public abstract Measure getMeasure();
}
