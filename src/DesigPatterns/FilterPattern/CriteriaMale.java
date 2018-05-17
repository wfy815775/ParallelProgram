package DesigPatterns.FilterPattern;

import DesigPatterns.PrototypePattern.Meal;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CriteriaMale implements Criteria{


    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> meetPersons = new ArrayList<>();
        for (Person person:persons){
            if (person.getGender().equalsIgnoreCase("Male")) {
                meetPersons.add(person);
            }
        }

        return meetPersons;
    }
}
