package DesigPatterns.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria male = new CriteriaMale();

        Criteria single = new CriteriaSingle();
        Criteria singleOrMale = new OrCriteria(single, male);
        Criteria singleMale = new AndCriteria(single, male);
        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));




        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Males: ");
        printPersons(singleOrMale.meetCriteria(persons));

    }


    public static void printPersons(List<Person> persons){

        for (Person person : persons) {

            System.out.println("Person : [ Name : " + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMaritalStatus()
                    +" ]");
        }
    }

}
