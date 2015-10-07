package chef;

/*
���-�����. ���������� �������� ������. ������� �����. ��������� ������������.
�������� ���������� ������ ��� ������ �� ������ ������ �� ����������. �����
����� � ������, ��������������� ��������� ��������� ������������.
*/

import chef.products.liquids.Oil;
import chef.products.vegetables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<Ingredient> combination = new ArrayList<Ingredient>();
        String dishName = "Salad 'All In'";

    }
}
