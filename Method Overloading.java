import java.io.*;
class Student {
    public void StudentId(String name, int roll_no)
    {
            System.out.println("Name :" + name + " " + "Roll-No :" + roll_no);
    }
    public void StudentId(int roll_no, String name)
    {
        System.out.println("Roll-No :" + roll_no + " " + "Name :" + name);
    }
}
class MethodOveloading{
  
    public static void main(String[] args)
    {
        Student obj = new Student();
        obj.StudentId(2,"Raamu");
        obj.StudentId("Maanvi",3);
    }
}