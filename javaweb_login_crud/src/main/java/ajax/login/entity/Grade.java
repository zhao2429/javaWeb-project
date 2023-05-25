package ajax.login.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 9:12
 **/
public class Grade {
    private Integer gradeId;
    private String gradeName;


    public Grade() {
    }

    public Grade(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Grade(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade(Integer gradeId, String gradeName) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;

    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
