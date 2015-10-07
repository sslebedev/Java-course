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

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(name + ": ");
        for (int i = 0, s = composition.size(); i < s; i++) {
            Ingredient ingredient = composition.get(i);
            strBuilder.append(ingredient.getValue() + " " + ingredient.getProduct().getMeasure().toString()
                    + " of " + ingredient.getProduct().getName());
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
