package DesigPatterns.FlyweightPattern;

import java.util.HashMap;

public class StudentFactory {
     private static final HashMap<String,student> students = new HashMap<>();

     public static student getStudent(String name){
         student student =students.get(name);

         if (student == null){
             System.out.println("添加该学生信息");
             student = new HighSchooStudents(name);
             students.put(name,student);
         }
         return student;


     }
}
