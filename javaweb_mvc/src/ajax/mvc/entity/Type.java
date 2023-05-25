package ajax.mvc.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 19:05
 **/
//对应type表
public class Type {
    private  Integer typeId;
    private  String typeName;

    public Type() {
    }

    public Type(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
