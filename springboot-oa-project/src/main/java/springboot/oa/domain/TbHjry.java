package springboot.oa.domain;

import java.io.Serializable;

public class TbHjry implements Serializable {
    private Integer id;

    private String hjsf;

    private String hjryxm;

    private String hjzw;

    private String hjdz;

    private String hjyx;

    private String hjlxdh;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHjsf() {
        return hjsf;
    }

    public void setHjsf(String hjsf) {
        this.hjsf = hjsf;
    }

    public String getHjryxm() {
        return hjryxm;
    }

    public void setHjryxm(String hjryxm) {
        this.hjryxm = hjryxm;
    }

    public String getHjzw() {
        return hjzw;
    }

    public void setHjzw(String hjzw) {
        this.hjzw = hjzw;
    }

    public String getHjdz() {
        return hjdz;
    }

    public void setHjdz(String hjdz) {
        this.hjdz = hjdz;
    }

    public String getHjyx() {
        return hjyx;
    }

    public void setHjyx(String hjyx) {
        this.hjyx = hjyx;
    }

    public String getHjlxdh() {
        return hjlxdh;
    }

    public void setHjlxdh(String hjlxdh) {
        this.hjlxdh = hjlxdh;
    }

    @Override
    public String toString() {
        return "TbHjry{" +
                "id=" + id +
                ", hjsf='" + hjsf + '\'' +
                ", hjryxm='" + hjryxm + '\'' +
                ", hjzw='" + hjzw + '\'' +
                ", hjdz='" + hjdz + '\'' +
                ", hjyx='" + hjyx + '\'' +
                ", hjlxdh='" + hjlxdh + '\'' +
                '}';
    }
}