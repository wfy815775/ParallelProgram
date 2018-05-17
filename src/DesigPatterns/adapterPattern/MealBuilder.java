package DesigPatterns.adapterPattern;

import DesigPatterns.PrototypePattern.ChinkenBurger;
import DesigPatterns.PrototypePattern.Coke;
import DesigPatterns.PrototypePattern.Meal;

public class MealBuilder {
    public Meal preareMeal(){

        Meal meal=new Meal();
        meal.addItem(new ChinkenBurger());
        meal.addItem(new Coke());
        meal.addItem(new ChinkenBurger());

        return meal;
    }

}
