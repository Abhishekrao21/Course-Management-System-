
import java.util.Arrays;
import java.util.Scanner;
public class Admin extends Main {
    public Admin(AData[] admin, int i, Courses[] CData, SData[] StudentD, PData[] ProfD,Complaint complaint) {
        System.out.println("welcome to dashboard");
        System.out.println("1) Manage Course Catalog");
        System.out.println("2) Manage Student Records");
        System.out.println("3) Assign Professors to Courses");
        System.out.println("4) Handle Complaints");
        System.out.println("Press -1 to logout");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        switch (option){
            case 1:
                manageCourseCatalog(CData);
                new Admin(admin,i,CData,StudentD,ProfD,complaint);
                break;
            case 2:
                manageStudentRecords(admin[i], CData,StudentD,ProfD);
                new Admin(admin,i,CData,StudentD,ProfD,complaint);
                break;
            case 3:
                assignProfessors(CData,ProfD);
                new Admin(admin,i,CData,StudentD,ProfD,complaint);
                break;
            case 4:
                handleComplaints(complaint);
                new Admin(admin,i,CData,StudentD,ProfD,complaint);
                break;
            case -1:
                System.out.println("Logging out...");
                Home(StudentD,ProfD,admin,CData,complaint);
        }
    }

    public void manageCourseCatalog(Courses[] CData) {
        System.out.println("what would u like to do");
        System.out.println("1) view course");
        System.out.println("2) add course");
        System.out.println("3) del course");
        System.out.println("enter course name");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();

        switch (option){
            case 1:
                System.out.println("enter course code");
                String temp=sc.next();
                int index=0;
                for (int i=0;i<CData.length;i++){
                    if (CData[i]!=null&&CData[i].Code.equals(temp)) {
                        index=i;
                        break;
                    }
                }
                System.out.println(CData[index].Name);
                System.out.println(CData[index].Timing);
                if(CData[index].Pre==null){
                    System.out.println("null");
                }
                else{
                    System.out.println(CData[index].Pre.Name);
                }
                System.out.println(CData[index].Credits);
                System.out.println(CData[index].Prof);
                System.out.println(CData[index].Sem);
                System.out.println(CData[index].syllabus);
                break;
            case 2:

                System.out.println("Enter course code:");
                String code = sc.next();
                System.out.println("Enter course name:");
                String name = sc.next();
                sc.nextLine();
                System.out.println("Enter class timings:");
                String timings = sc.nextLine();
                System.out.println("Enter prerequisites :");
                String preReq = sc.next();
                boolean isPre=true;
                if(preReq==null){
                    isPre=false;
                }
                String te = preReq;
                int ind=0;
                for (int i=0;i<CData.length; i++) {
                    if (CData[i]!=null&&CData[i].Code.equals(te)) {
                        ind=i;
                        break;
                    }
                }
                //CData[i]=preq
                System.out.println("Enter credits:");
                int credits = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter professor name:");
                String professor = sc.nextLine();
                System.out.println("Enter semester:");
                int semester = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter syllabus:");
                String syllabus = sc.nextLine();
                Courses dada;
                if(isPre==true) {
                    dada = new Courses(name,code,professor,semester,timings,CData[ind]);
                }
                else{
                    dada = new Courses(name,code,professor,semester,timings, null);
                }
                dada.syllabus=syllabus;
                dada.Credits=credits;
                for (int i=0;i<CData.length; i++) {
                    if (CData[i]==null) {
                        CData[i]=dada;
                        break;
                    }
                }
                break;
            case 3:
                int inde=0;
                for (int i=0;i<CData.length; i++) {
                    if (CData[i]==null) {
                        inde=i;
                        break;
                    }
                }
                System.out.println("enter course code");
                String temp1 = sc.next();
                int index2=0;
                for (int i=0;i<CData.length; i++) {
                    if (CData[i]!=null && CData[i].Code.equals(temp1)) {
                        index2=i;
                        break;
                    }
                }
                CData[index2]=CData[inde - 1];
                CData[inde-1]=null;

        }
    }

    public void manageStudentRecords(AData admin, Courses[] CData, SData[] StudentD, PData[] ProfD) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<StudentD.length;i++){
            if(StudentD[i]!=null) {
                System.out.println(StudentD[i].getEmail());
            }
        }
        System.out.println("enter student email that you will like to access");
        String temp = sc.nextLine();
        int index=0;
        for (int i=0;i<StudentD.length; i++) {
            if (StudentD[i]!=null&&StudentD[i].getEmail().equals(temp)) {
                index=i;
            }
        }
        System.out.println("Manage Student Records:");
        System.out.println("1) View Students");
        System.out.println("2) Update Student Info");
        System.out.println("3) Update Student Grades");
        int option=sc.nextInt();
        switch (option){
            case 1:
                System.out.println(StudentD[index].getEmail());
                System.out.println(StudentD[index].getPassword());
                System.out.println(StudentD[index].getSemester());
                System.out.println(Arrays.toString(StudentD[index].getGrades()));
                break;

            case 2:
                System.out.println("what will you like to update");
                System.out.println("1) email");
                System.out.println("2) password");
                System.out.println("3) sem");
                System.out.println("4) courses");
                int temp1=sc.nextInt();
                switch (temp1) {
                    case 1:
                        System.out.println("Enter new email:");
                        sc.nextLine();
                        String new1=sc.nextLine();
                        StudentD[index].setEmail(new1);
                        break;

                    case 2:
                        System.out.println("Enter new password:");
                        sc.nextLine();
                        String new2=sc.nextLine();
                        StudentD[index].setPassword(new2);
                        break;

                    case 3:
                        System.out.println("Enter new sem:");
                        int new3=sc.nextInt();
                        StudentD[index].setSemester(new3);
                        break;

                    case 4:
                        System.out.println("Enter number of courses to update:");
                        int Count=sc.nextInt();
                        Courses[] newC=new Courses[Count];
                        for (int i=0;i<Count;i++) {
                            System.out.println("Enter course code :");
                            sc.nextLine();
                            String new4 = sc.nextLine();
                            for(int j=0;j<CData.length;j++){
                                if(CData[j]!=null&&CData[j].Code.equals(new4)){
                                    newC[i] = CData[j];
                                    break;
                                }
                            }
                        }

                        StudentD[index].setCourses(newC);
                        break;
                        }

            case 3:
                System.out.println("enter no of 2 credit and no of 4 credit courses");
                int courses2=sc.nextInt();
                int courses4=sc.nextInt();
                int temp4=courses2+courses4;
                System.out.println("Enter new grades for 4 credit courses");
                int[][] new5=new int[2][10];
                for (int i=0;i<courses4;i++) {
                    new5[0][i]=sc.nextInt();
                }
                for (int i=courses4;i<new5[0].length;i++) {
                    new5[0][i]=-1;
                }
                System.out.println("Enter new grades for 2 credit courses");
                for (int i=0;i<courses2;i++) {
                    new5[1][i]=sc.nextInt();
                }
                for (int i=courses4;i<new5[1].length;i++) {
                    new5[1][i]=-1;
                }
                StudentD[index].setGrades(new5);
                int semmm=StudentD[index].getSemester();
                semmm++;
                StudentD[index].setSemester(semmm);
                break;

        }
    }
    public void assignProfessors(Courses[] CData,PData[] ProfD){
        System.out.println("enter the email of prof");
        Scanner sc=new Scanner(System.in);
        String temp=sc.next();
        int index=0;
        for(int i=0;i<ProfD.length;i++){
            if(ProfD[i]!=null&&ProfD[i].getEmail().equals(temp)){
                index = i;
            }
        }
        System.out.println("enter course code");
        String temp2=sc.next();
        for(int i=0;i<CData.length;i++){
            if(CData[i]!=null&&CData[i].Code.equals(temp2)){
                CData[i].Prof=ProfD[index].getEmail();
            }
        }

    }
    private void handleComplaints(Complaint complaint){
        System.out.println("what do you want to do:");
        System.out.println("1) view all complaint");
        System.out.println("2) update complaint status");
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        if(temp==1){
            for(int i=0;i<complaint.getCount();i++){
                System.out.print(complaint.getComplaint()[i]);
                System.out.print(".  ->");
                System.out.println(complaint.getStatus()[i]);
            }
        }
        else if(temp==2){
            System.out.println("enter complain no");
            int temp2=sc.nextInt();
            System.out.println("what will you like the statu to be Pending(0) and Resolved(1)");
            int temp3=sc.nextInt();
            complaint.setStatus(temp2,temp3);
        }

    }

}

