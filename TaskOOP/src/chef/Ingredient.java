package chef;

/**
 * Created by Сергей on 06.10.2015.
 */
public abstract class Ingredient {
    private Product product;
    private float value;

    /**
     * @param product Product
     * @param value How much
     */
    public Ingredient(Product product, float value) {
        this.product = product;
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public float getValue() {
        return value;
    }

    public float getContainingCalories() {
        return product.getCalories() * value;
    }
}
