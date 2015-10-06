package chef;

import java.util.List;

/**
 * Created by Сергей on 06.10.2015.
 */
public class Dish {
    private String name;
    private List<Ingredient> composition;

    public String getName() {
        return name;
    }

    public List<Ingredient> getComposition() {
        return composition;
    }
}
