import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SData[] StudentD=new SData[5];
        PData[] ProfD=new PData[5];
        AData[] AdminD=new AData[5];
        Courses[] CData=new Courses[50];
        Complaint comp=new Complaint();
        CData[0]=new Courses("Algorithms", "CS201", "prof1@iiitd.com", 1, "Mon-Wed 12:00-1:30", null);
        CData[1]=new Courses("Database Systems", "CS202", "prof1@iiitd.com", 1, "Tue-Thu 1:00-2:30", null);
        CData[2]=new Courses("Web Development", "CS203", "prof1@iiitd.com", 1, "Mon-Wed 3:00-4:30", null);
        CData[3]=new Courses("Operating Systems", "CS204", "prof1@iiitd.com", 1, "Tue-Thu 12:00-1:00", null);
        CData[4]=new Courses("Computers", "CS205", "prof1@iiitd.com", 1, "Mon-Wed 10:00-11:30", null);
        CData[4].Credits=2;
        CData[5]=new Courses("Artificial Intelligence", "CS206", "prof2@iiitd.com", 2, "Tue-Thu 2:00-3:30", CData[0]);
        CData[6]=new Courses("Software ", "CS207", "prof2@iiitd.com", 2, "Mon-Wed 1:00-2:30", null);
        CData[7]=new Courses("Machine Learning", "CS208", "prof1@iiitd.com", 2, "Tue-Thu 3:30-4:30", CData[3]);
        CData[8]=new Courses("Cyber Security", "CS209", "prof1@iiitd.com", 2, "Mon-Wed 11:00-12:30", null);
        CData[9]=new Courses("HCI", "CS210", "prof1@iiitd.com", 2, "Tue-Thu 10:00-11:30", null);

        CData[10]=new Courses("Data S", "CS211", "prof1@iiitd.com", 3, "Mon-Wed 2:00-3:30", CData[6]);
        CData[11]=new Courses("Computing", "CS212", "prof1@iiitd.com", 3, "Tue-Thu 1:00-2:30", CData[5]);
        CData[12]=new Courses("CO", "CS213", "prof1@iiitd.com", 3, "Mon-Wed 12:30-1:30", CData[0]);
        CData[13]=new Courses("Discrete Mathematics", "CS214", "prof1@iiitd.com", 3, "Tue-Thu 3:30-5:00", null);
        CData[14]=new Courses("Bioinformatics", "CS215", "prof1@iiitd.com", 3, "Mon-Wed 3:30-4:00", null);
        CData[15]=new Courses("AP", "CS216", "prof1@iiitd.com", 3, "Tue-Thu 12:00-1:00", CData[5]);
        CData[13].Credits=2;
        CData[16]=new Courses("Processing", "CS217", "prof1@iiitd.com", 4, "Mon-Wed 10:00-11:30", CData[6]);
        CData[17]=new Courses("Game Development", "CS218", "prof1@iiitd.com", 5, "Tue-Thu 2:00-3:30", CData[0]);
        CData[18]=new Courses("LLM", "CS219", "prof1@iiitd.com", 6, "Mon-Wed 1:00-2:30", CData[5]);
        CData[19]=new Courses("Advanced Artificial Intelligence", "CS220", "prof1@iiitd.com", 7, "Tue-Thu 3:00-4:30", CData[1]);

        StudentD[0]=new SData("adit@iiitd.com", "123", new int[][]{{9, 8, 7, 7, 8},{}}, new Courses[]{CData[0], CData[1], CData[2], CData[3],CData[4] ,CData[13]}, new Courses[]{}, 1);
        CData[0].AddEnrol(StudentD[0]);
        CData[1].AddEnrol(StudentD[0]);
        CData[2].AddEnrol(StudentD[0]);
        CData[3].AddEnrol(StudentD[0]);
        CData[13].AddEnrol(StudentD[0]);
        CData[4].AddEnrol(StudentD[0]);
        StudentD[1]=new SData("akshay@iiitd.com", "123", new int[][]{{9, 8, 5, 10},{8,7}}, new Courses[5], new Courses[]{CData[0], CData[1], CData[2], CData[3], CData[4]}, 2);
        StudentD[2]=new SData("daksh@iiitd.com", "123", new int[][]{{9, 8, 5, 4, 5},{}}, new Courses[5], new Courses[]{CData[0], CData[1], CData[2], CData[3], CData[4], CData[5], CData[6], CData[7], CData[8], CData[9]}, 3);

        ProfD[0]=new PData("prof1@iiitd.com", "123");
        ProfD[1]=new PData("prof2@iiitd.com", "123");
        ProfD[2]=new PData("prof3@iiitd.com", "123");
        AdminD[0]=new AData("admin@iiitd.com", "123");
        Home(StudentD,ProfD,AdminD,CData,comp);
    }
    public static void Home(SData[] StudentD, PData[] ProfD, AData[] AdminD, Courses[] CData, Complaint comp) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to this server");
        System.out.println("What describes you the best");
        System.out.println("1) Student");
        System.out.println("2) Professor");
        System.out.println("3) Admin");
        System.out.println("4) New student user");
        int temp=sc.nextInt();
        if (temp==1) {
            Login login=new Student_login(StudentD);
            System.out.println("Enter email ");
            String email=sc.next();
            System.out.println("Enter password ");
            String password=sc.next();
            if (login.isPresent(email, password)) {
                System.out.println("Login Completed Going to dashbord");
                int stu=login.getD(email, password);
                new Students(StudentD,stu,CData,comp,ProfD,AdminD);
            }
            else {
                Home(StudentD,ProfD,AdminD,CData,comp);
            }

        } else if (temp==2) {
            Login login=new Prof_login(ProfD);
            System.out.println("Enter email ");
            String email=sc.next();
            System.out.println("Enter password ");
            String password=sc.next();
            if (login.isPresent(email, password)) {
                System.out.println("Login Completed Going to dashbord");
                int stu=login.getD(email, password);
                new Prof(ProfD,stu,CData,StudentD,AdminD,comp);
            }
            else {
                Home(StudentD,ProfD,AdminD,CData,comp);
            }
        } else if (temp==3) {
            Login login=new Admin_login(AdminD);
            System.out.println("Enter email ");
            String email=sc.next();
            System.out.println("Enter password ");
            String password=sc.next();
            if (login.isPresent(email, password)) {
                System.out.println("Login Completed Going to dashbord");
                int stu=login.getD(email, password);
                new Admin(AdminD,stu,CData,StudentD,ProfD,comp);
            }
            else {
                Home(StudentD,ProfD,AdminD,CData,comp);
            }
        }
        else if(temp==4){
            // new user
            System.out.println("enter your email");
            sc.nextLine();
            String temp1= sc.nextLine();
            System.out.println("enter your password");
            String temp2=sc.nextLine();
            int[][] grades =new int[2][10];
            for(int i=0;i<StudentD.length;i++){
                if(StudentD[i]==null){
                    StudentD[i]=new SData(temp1,temp2,grades,new Courses[]{},new Courses[]{},1);
                }
            }
            Home(StudentD,ProfD,AdminD,CData,comp);
        }
        else if(temp==-1){
            System.out.println("quiting");
        }

            else{
                System.out.println("Error try again");
                Home(StudentD,ProfD,AdminD,CData,comp);
            }
        }

}


interface Login{
    public boolean isPresent(String email,String password);
    public int getD(String email,String password);
}
class Student_login implements Login {
    private SData[] students;
    public Student_login(SData[] students) {
        this.students=students;
    }

    @Override
    public boolean isPresent(String email,String password) {
        for(int i=0;i<students.length;i++){
            if(students[i]!=null&&students[i].getEmail().equalsIgnoreCase(email)){
                if(students[i].getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public int getD(String email,String password){
        for(int i=0;i<students.length;i++){
            if(students[i]!=null&&students[i].getEmail().equalsIgnoreCase(email)){
                if(students[i].getPassword().equals(password)){
                    return i;
                }
            }
        }
        return -1;
    }
}
class Prof_login implements Login{
    private PData[] prof;

    public Prof_login(PData[] prof) {
        this.prof=prof;
    }

    @Override
    public boolean isPresent(String email,String password) {
        for (int i=0;i<prof.length;i++) {
            if (prof[i]!=null&&prof[i].getEmail().equalsIgnoreCase(email)) {
                if (prof[i].getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public int getD(String email,String password){
        for (int i=0;i<prof.length;i++) {
            if (prof[i].getEmail().equalsIgnoreCase(email)) {
                if (prof[i].getPassword().equals(password)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
class Admin_login implements Login{
    private AData[] admin;
    public Admin_login(AData[] admin) {
        this.admin=admin;
    }

    @Override
    public boolean isPresent(String email,String password) {
        for (int i=0;i<admin.length;i++) {
            if (admin[i]!=null&&admin[i].getEmail().equalsIgnoreCase(email)) {
                if (admin[i].getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public int getD(String email,String password) {
        for (int i=0;i<admin.length;i++) {
            if (admin[i].getEmail().equalsIgnoreCase(email)) {
                if (admin[i].getPassword().equals(password)) {
                    return i;
                }
            }
        }
        return -1;
    }
}