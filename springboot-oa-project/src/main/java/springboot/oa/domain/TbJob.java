package springboot.oa.domain;

import java.io.Serializable;

public class TbJob  implements Serializable {
    private Integer id;

    private String name;

    private String remanrk;

    private String qzlqrxm;

    private String qzlqrzjhm;

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
        this.name = name == null ? null : name.trim();
    }

    public String getRemanrk() {
        return remanrk;
    }

    public void setRemanrk(String remanrk) {
        this.remanrk = remanrk == null ? null : remanrk.trim();
    }

    public String getQzlqrxm() {
        return qzlqrxm;
    }

    public void setQzlqrxm(String qzlqrxm) {
        this.qzlqrxm = qzlqrxm;
    }

    public String getQzlqrzjhm() {
        return qzlqrzjhm;
    }

    public void setQzlqrzjhm(String qzlqrzjhm) {
        this.qzlqrzjhm = qzlqrzjhm;
    }

    @Override
    public String toString() {
        return "TbJob{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remanrk='" + remanrk + '\'' +
                ", qzlqrxm='" + qzlqrxm + '\'' +
                ", qzlqrzjhm='" + qzlqrzjhm + '\'' +
                '}';
    }
}