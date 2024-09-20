import java.util.Scanner;

public class Students extends Main {
    public Students(SData[] student,int i,Courses[] CCData,Complaint complaint ,PData[] ProfD, AData[] AdminD) {
        System.out.println("welcome to dashboard");
        System.out.println("What matches best with your query");
        System.out.println("1) View Available Courses:");
        System.out.println("2) Register for Courses:");
        System.out.println("3) View Schedule::");
        System.out.println("4) Track Academic Progress:");
        System.out.println("5) Drop Courses:");
        System.out.println("6) Submit Complaints:");
        System.out.println("Press -1 to logout");
        Scanner sc=new Scanner(System.in);
        int temp=sc.nextInt();
        switch(temp) {
            case 1:
                ViewAvailableCourses(CCData,student[i]);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;
            case 2:
                RegisterForCourses(student[i],CCData);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;
            case 3:
                ViewSchedule(student[i]);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;
            case 4:
                TrackAcademicProgress(student[i]);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;
            case 5:
                DropCourses(student[i],CCData);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;
            case 6:
                SubmitComplaints(complaint);
                new Students(student,i,CCData,complaint,ProfD,AdminD);
                break;

            case -1:
                System.out.println("returning to Dashboard");
                Home(student,ProfD,AdminD,CCData,complaint);
        }
    }

    public void ViewAvailableCourses(Courses[] CCData, SData student) {
        int semm=student.getSemester();
        for (int i=0;i<CCData.length;i++) {
            if (CCData[i]!=null&&CCData[i].Sem==semm ) {
                        System.out.print(CCData[i].Name);
                        System.out.print(".   ");
                        System.out.print(CCData[i].Code);
                        System.out.print(".   ");
                        System.out.print(CCData[i].Prof);
                        System.out.print(".   ");
                        if(CCData[i].Pre==null){
                            System.out.print("null");
                        }
                        else {
                            System.out.print(CCData[i].Pre.Name);
                        }
                        System.out.print(".   ");
                        System.out.print(CCData[i].Timing);
                        System.out.print(".   ");
                        System.out.println(CCData[i].Credits);

            }
        }
    }
    public void RegisterForCourses(SData student,Courses[] CCData){
        int totalCredits = 0;

        for (int i=0;i<student.getCourses().length;i++) {
            if (student.getCourses()[i]!=null) {
                totalCredits=totalCredits+student.getCourses()[i].Credits;
            }
        }
        if (totalCredits==20) {
            System.out.println("Already registered drop all courses");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Available Courses:");
        ViewAvailableCourses(CCData, student);
        System.out.println("Enter the no of courses you want to register:");
        int num=sc.nextInt();
        Courses[] NCourses=new Courses[num];
        for(int i=0;i<num;i++) {
            System.out.println("Enter the code of the courses you want to register for:");
            String courseCode = sc.next();
            Courses selectedCourse = null;
            for (int j=0;j<CCData.length;j++) {
                if (CCData[i]!=null&&CCData[j].Code.equals(courseCode)) {
                    selectedCourse=CCData[j];
                    break;
                }
            }
            boolean pmet = false;
            if(selectedCourse.Pre==null){
                pmet=true;
            }
            if (selectedCourse.Sem==student.getSemester()) {
                for (int j=0;j<student.getPreq().length;j++) {
                    if (selectedCourse.Pre==student.getPreq()[j]) {
                        pmet=true;
                    }
                }
            }
            if(pmet==false) {
                System.out.println("error");
                return;
            }
            NCourses[i]=selectedCourse;
            selectedCourse.AddEnrol(student);
        }
        int credit=0;
        for(int i=0;i<num;i++){
            credit+=NCourses[i].Credits;
        }
        if(credit==20) {
            student.setCourses(NCourses);
        }
        else{
            System.out.println("Credits not equal to 20");
        }
    }
    public void ViewSchedule(SData student){
        Courses[] temp=student.getCourses();
        for(int i=0;i<temp.length;i++){
            Courses c =student.getCourses()[i];
            System.out.print(c.Name);
            System.out.print("  ->");
            System.out.print(c.Timing);
            System.out.print(".->");
            System.out.println(c.Prof);
        }
    }
    public void TrackAcademicProgress(SData student){
        float cgpa=0;
        for(int i=0;i<student.getGrades()[0].length;i++) {
            if(student.getGrades()[0][i]!=-1) {
                cgpa += student.getGrades()[0][i]*4;
            }
        }
        for(int i=0;i<student.getGrades()[1].length;i++) {
            if(student.getGrades()[1][i]!=-1) {
                cgpa += student.getGrades()[1][i]*2;
            }
        }
        cgpa=cgpa/20;
        System.out.println(cgpa);
    }
    public void DropCourses(SData student,Courses[] CCData){
        Scanner sc=new Scanner(System.in);
        Courses[] Temp=new Courses[(student.getCourses().length)-1];
        System.out.println("select the course which u wish to drop ?");
        for(int i=0;i<student.getCourses().length;i++){
            if(student.getCourses()[i]!=null) {
                System.out.println(student.getCourses()[i].Code);
            }
        }
        int index=-1;
        String code=sc.next();
        for(int i=0;i<student.getCourses().length;i++) {
            if(student.getCourses()[i].Code.equals(code)){
                index=i;
            }
        }
        if(index==-1){
            System.out.println("erroe");
        }
        int iiii=0;
        for(int i=0;i<student.getCourses().length;i++) {
            if(!student.getCourses()[i].Code.equals(code)){
                Temp[iiii]=student.getCourses()[i];
                iiii++;
            }
        }
        student.setCourses(Temp);
        for(int i=0;i<CCData.length;i++){
            if(CCData[i]!=null&&CCData[i].Code.equals(code)){
                index=i;
            }
        }
        for(int i=0;i<CCData[index].Enrol.length;i++){
            if(CCData[index].Enrol!=null&&CCData[index].Enrol[i].getEmail().equals(student.getEmail())){
                CCData[index].Enrol[i]=null;
                break;
            }
        }
        student.setCourses(Temp);
    }
    public void SubmitComplaints(Complaint complaint){
        System.out.println("Do you want to view(0) or register(1) new comp");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        if(option==1) {
            System.out.println("enter you complain:");
            sc.nextLine();
            String comp = sc.nextLine();
            complaint.setComplaints(comp);
            System.out.print("your complain no is:");
            System.out.println(complaint.getCount()-1);
        }
        else if(option==0){
            System.out.println("enter complain no");
            int temp=sc.nextInt();
            System.out.println(complaint.getComplaint()[temp]);
            System.out.println(complaint.getStatus()[temp]);
        }
    }
}

