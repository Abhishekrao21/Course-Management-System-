import java.util.Scanner;
public class Prof extends Main {
    public Prof(PData[] prof,int i,Courses[] CData,SData[] StudentD,AData[] AdminD,Complaint comp) {
        System.out.println("welcome to dashboard");
        System.out.println("What matches best with your query");
        System.out.println("1) Manage Courses:");
        System.out.println("2) View Enrolled Students:");
        System.out.println("Press -1 to logout");
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        switch (temp) {
            case 1:
                manageCourses(prof[i],CData);
                new Prof(prof,i,CData,StudentD,AdminD,comp);
                break;
            case 2:
                viewEnrolledStudents(prof[i],CData);
                new Prof(prof,i,CData,StudentD,AdminD,comp);
                break;
            case -1:
                System.out.println("returning to Dashboard");
                Home(StudentD,prof,AdminD,CData,comp);
            default:
                new Prof(prof,i,CData,StudentD,AdminD,comp);
        }
    }
    public void manageCourses(PData prof,Courses[] Cdata) {
        Courses[] profC = new Courses[20];
        int count = 0;
        for (int i=0;i<Cdata.length;i++) {
            if (Cdata[i]!=null&&Cdata[i].Prof.equalsIgnoreCase(prof.getEmail())){
                profC[count]=Cdata[i];
                count++;
            }
        }
        System.out.println("Showing all courses select one to view or edit");
        for (int i=0;i<count;i++){
            if (profC[i]!=null){
                System.out.println(profC[i].Code);
            }
        }
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        int index=0;
        for (int i=0;i<count;i++) {
            if (profC[i] != null && profC[i].Code.equals(temp)) {
                index =i;
            }
        }
        System.out.println("do u want view(enter 1) or edit(enter 0)");
        int option=sc.nextInt();
        if (option==1) {
            String print = Cdata[index].Name + " Limit is " + Cdata[index].Limit + " Syllabus is " + Cdata[index].syllabus + " Timing is " + Cdata[index].Timing + " Credits is " + Cdata[index].Credits + " prerequisites, ";
            if(Cdata[index].Pre!=null){
                print=print+Cdata[index].Pre.Name;
            }
            else{
                print=print+"null";
            }
            System.out.println(print);
        } else if (option==0) {
            System.out.println("what do you want to edit");
            System.out.println("1) syllabus");
            System.out.println("2) Class Timings");
            System.out.println("3) Credits");
            System.out.println("4) Prerequisites");
            System.out.println("5) Enrollment Limit");

            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the new syllabus:");
                    sc.nextLine();
                    String syllabus=sc.nextLine();
                    Cdata[index].syllabus=syllabus;
                    break;

                case 2:
                    System.out.println("Enter the new class timings:");
                    sc.nextLine();
                    String classTimings=sc.nextLine();
                    Cdata[index].Timing=classTimings;
                    break;

                case 3:
                    System.out.println("Enter the new credits:");
                    int credits=sc.nextInt();
                    Cdata[index].Credits=credits;
                    break;

                case 4:
                    System.out.println("Enter the new prerequisites code:");
                    sc.nextLine();
                    String Temp1=sc.nextLine();
                    for(int i=0;i<Cdata.length;i++){
                        if(Cdata[i]!=null&&Cdata[i].Code.equals(Temp1)){
                            Cdata[index].Pre = Cdata[i];
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter the new enrollment limit:");
                    int enrollmentLimit=sc.nextInt();
                    Cdata[index].Limit=enrollmentLimit;
                    System.out.println("Enrollment limit updated.");
                    break;

            }
        }
    }
    public void viewEnrolledStudents(PData prof,Courses[] Cdata){
        System.out.println("enter course code that u need to view ");
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        for(int i=0;i<Cdata.length;i++){
            if(Cdata[i]!=null&&Cdata[i].Code.equals(temp)){
                for(int j=0;j<Cdata[i].Enrol.length;j++) {
                    if(Cdata[i].Enrol[j]!=null){
                        System.out.println(Cdata[i].Enrol[j].getEmail());
                        }
                }
            }
        }
    }
}
