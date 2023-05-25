package ajax.login.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 9:08
 **/
public class Student {
    private Integer id;
    private String name;
    private String borntime;
    private String sex;
    private Grade grade;
    private  Integer gradeId;



    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }


    public Student(String name, String borntime, String sex, Integer gradeId) {
        this.name = name;
        this.borntime = borntime;
        this.sex = sex;
        this.gradeId = gradeId;
    }

    public Student(String name, String borntime, String sex, Grade grade, Integer gradeId) {
        this.name = name;
        this.borntime = borntime;
        this.sex = sex;
        this.grade = grade;
        this.gradeId = gradeId;
    }

    public Student(Integer id, String name, String borntime, String sex, Integer gradeId) {
        this.id = id;
        this.name = name;
        this.borntime = borntime;
        this.sex = sex;
        this.gradeId = gradeId;
    }

    public Student(Integer id, String name, String borntime, String sex, Grade grade, Integer gradeId) {
        this.id = id;
        this.name = name;
        this.borntime = borntime;
        this.sex = sex;
        this.grade = grade;
        this.gradeId = gradeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorntime() {
        return borntime;
    }

    public void setBorntime(String borntime) {
        this.borntime = borntime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borntime='" + borntime + '\'' +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                ", gradeId=" + gradeId +
                '}';
    }
}
