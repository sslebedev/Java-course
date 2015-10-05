package chef;

/**
 * Created by Сергей on 05.10.2015.
 *
 * Anything to be food is product:
 *   something named and energetically valuable
 */
public abstract class Product {
    private String name;
    private float calories;

    public Product(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() { return name; }

    public float getCalories() {
        return calories;
    }
}
