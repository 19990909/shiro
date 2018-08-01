package springboot.oa.domain;

/**
 * Created by dell on 2018/3/20.
 */
public class TbJz {

    private Integer id;
    private String jzbm;
    private String jzlx;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJzbm() {
        return jzbm;
    }

    public void setJzbm(String jzbm) {
        this.jzbm = jzbm;
    }

    public String getJzlx() {
        return jzlx;
    }

    public void setJzlx(String jzlx) {
        this.jzlx = jzlx;
    }

    @Override
    public String toString() {
        return "TbJz{" +
                "id=" + id +
                ", jzbm='" + jzbm + '\'' +
                ", jzlx='" + jzlx + '\'' +
                '}';
    }
}
