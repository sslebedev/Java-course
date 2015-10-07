package chef;

import java.util.List;

/**
 * Created by Сергей on 06.10.2015.
 */
public class Dish {
    private String name;
    private List<Ingredient> composition;

    /**
     * @param name Dish name
     * @param composition Ingredients list
     */
    public Dish(String name, List<Ingredient> composition) {
        this.name = name;
        this.composition = composition;
    }

    /**
     * Makes this!
     */
    public void Make() {
        System.out.println("Done!");
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(name).append(": ");
        for (int i = 0, s = composition.size(); i < s; i++) {
            Ingredient ingredient = composition.get(i);
            strBuilder.append(ingredient.getValue()).append(" ").append(ingredient.getProduct().getMeasure().toString()).append(" of ").append(ingredient.getProduct().getName());
            strBuilder.append(i < s - 1 ? ";" : ".");
        }

        return strBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getComposition() {
        return composition;
    }
}
