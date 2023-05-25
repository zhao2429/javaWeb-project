package ajax.jsp.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/6 9:42
 **/
public class Person {
    private String name;
    private String[] phones;
    private List<String> citys;
    private Map<String,Object> map;

    public Person() {
    }

    public Person(String name, String[] phones, List<String> citys, Map<String, Object> map) {
        this.name = name;
        this.phones = phones;
        this.citys = citys;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCitys() {
        return citys;
    }

    public void setCitys(List<String> citys) {
        this.citys = citys;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", citys=" + citys +
                ", map=" + map +
                '}';
    }
}
