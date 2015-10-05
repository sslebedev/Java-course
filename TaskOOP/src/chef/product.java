package chef;

/**
 * Created by Сергей on 05.10.2015.
 */
public class Product {
    private String name;
    private float calories;

    public Product(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public float getCalories() {
        return calories;
    }
}
