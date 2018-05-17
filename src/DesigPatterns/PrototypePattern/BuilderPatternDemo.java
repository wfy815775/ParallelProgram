package DesigPatterns.PrototypePattern;

import DesigPatterns.adapterPattern.MealBuilder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder m = new MealBuilder();

        Meal meal = m.preareMeal();

        meal.showItems();

        meal.getCost();
    }
}
