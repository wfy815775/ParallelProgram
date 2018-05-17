package CallBack;

public class CallBackDemo {

    public static void main(String[] args) {

       Student tom = new Tom();
        Teacher James = new Teacher(tom);

        James.tellStudentToDotask();



    }
}
