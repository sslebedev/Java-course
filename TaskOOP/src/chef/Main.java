package chef;

/*
Шеф-повар. Определить иерархию овощей. Сделать салат. Посчитать калорийность.
Провести сортировку овощей для салата на основе одного из параметров. Найти
овощи в салате, соответствующие заданному диапазону калорийности.
*/

import chef.products.liquids.Oil;
import chef.products.vegetables.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome, Chef!");

        System.out.println("Initializing products database...");
        Product[] products = {
                new Oil("Olive Oil", 8270.8f),
                new Cabbage("White Cabbage", 270),
                new Fruit("Tomato", 100),
                new Melon("Squash", 160),
                new Onion("Green Onion", 220),
                new Root("Parsley", 380),
                new SeedPod("Peas", 3330),
                new Sheet("Green Salad", 160),
                new Spice("Horseradish", 490),
                new Tuber("Potato", 830)
        };
        System.out.println(Arrays.deepToString(products));

        System.out.println("Forming combination...");
        List<Ingredient> combination = new ArrayList<>();
        Random random = new Random(0);
        for (Product p : products) {
            combination.add(new Ingredient(p, random.nextFloat()));
        }
        String dishName = "Salad 'All In'";
        Dish dish = new Dish(dishName, combination);
        System.out.println(dish);
        System.out.println("Making...");
        dish.Make();

        System.out.println("Salad calories: " + dish.getCalories());

        System.out.println("Arrange combination: only vegetables by (product) calories: ");
        List<Product> vegetables1 = Helpers.getCalSortedVegetables(dish);
        System.out.println(vegetables1);

        System.out.println("Select in combination: only vegetables with calories between 0.5 and 1 kcal : ");

        List<Product> vegetables2 = Helpers.getProductsInCalRange(vegetables1, 500, 1000);
        System.out.println(vegetables2);
    }

}
