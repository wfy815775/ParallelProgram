package CallBack;

public class Teacher implements CallBack {

    public Student student;
    public Teacher(Student student) {
            this.student = student;
    }

    public void tellStudentToDotask(){
        System.out.println(this.getClass().getName()+" 请你做完卷子后告诉我");
        student.doTask(this);
    }
    @Override
    public void Callme() {
        System.out.println(this.getClass().getName()+" 你可以休息一会，我来给你判分");
    }
}
