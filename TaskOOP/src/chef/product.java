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

    /**   7
     * @param name name
     * @param calories calories in 1 kg
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
     * @return Calories in 1 kg
     */
    public float getCalories() {
        return calories;
    }
}
