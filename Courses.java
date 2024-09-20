public class Courses {
    public String Name;
    public String Code;
    public String Prof;
    public int Sem;
    public Courses Pre;
    public String Timing;
    public SData[] Enrol;
    public int Limit;
    public int Credits;
    public String syllabus;
    public int index=0;

    public Courses(String name, String code, String prof,int sem, String timing, Courses pre) {
        this.Name=name;
        this.Code=code;
        this.Prof=prof;
        this.Sem=sem;
        this.Timing=timing;
        this.Pre=pre;
        this.Enrol=new SData[20];
        this.syllabus="";
        this.Limit=100000;
        this.Credits=4;
    }
    public void SetLimit(int limit){
        this.Limit=limit;
    }
    public void SetCredit(int credit){
        this.Credits=credit;
    }
    public void AddEnrol(SData Enrol){
        this.Enrol[index]=Enrol;
        index++;
    }
}
class PData {
    private String email;
    private String password;

    public PData(String email, String password) {
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
class SData {
    private String email;
    private String password;
    private int[][] Grades;
    private Courses[] Cour;
    private Courses[] Preq;
    private int sem;

    public SData(String email, String password,int[][] grades,Courses[] cour,Courses[] preq ,int sem ){
        this.email=email;
        this.password=password;
        this.Grades=grades;
        this.Cour=cour;
        this.Preq=preq;
        this.sem=sem;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getSemester() {
        return sem;
    }

    public Courses[] getCourses() {
        return Cour;
    }

    public int[][] getGrades() {
        return Grades;
    }
    public Courses[] getPreq() {
        return Preq;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public void setGrades(int[][] grades) {
        this.Grades=grades;
    }

    public void setCourses(Courses[] cour) {
        this.Cour=cour;
    }

    public void setPreq(Courses[] preq) {
        this.Preq=preq;
    }

    public void setSemester(int sem) {
        this.sem=sem;
    }
}
class Complaint {
        private String[] complaint=new String[50];
        private int[] status=new int[50];
        private int count;


        public Complaint() {
            this.count=0;
            for(int i=0;i<50;i++){
                status[i]=0;
            }
        }

        public String[] getComplaint() {
            return complaint;
        }

        public int[] getStatus() {
            return status;
        }

        public int getCount() {
            return count;
        }

        public void setComplaints(String complaint1){
            this.complaint[count]=complaint1;
            this.status[count]=0;
//            int coun =count++;
            this.count++;
        }
        public void setStatus(int i,int i2){
            this.status[i]=i2;
        }
}
class AData {
    private String email;
    private String password;

    public AData(String email, String password) {
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
