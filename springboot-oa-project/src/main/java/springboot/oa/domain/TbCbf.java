package springboot.oa.domain;

/**
 * Created by dell on 2018/3/20.
 */
public class TbCbf {

    private Integer id;
    private String cbfbm;
    private String cbfmc;
    private String cbflx;
    private String cbfzjhm;
    private String lxdh;
    private Integer jid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCbfbm() {
        return cbfbm;
    }

    public void setCbfbm(String cbfbm) {
        this.cbfbm = cbfbm;
    }

    public String getCbfmc() {
        return cbfmc;
    }

    public void setCbfmc(String cbfmc) {
        this.cbfmc = cbfmc;
    }

    public String getCbflx() {
        return cbflx;
    }

    public void setCbflx(String cbflx) {
        this.cbflx = cbflx;
    }

    public String getCbfzjhm() {
        return cbfzjhm;
    }

    public void setCbfzjhm(String cbfzjhm) {
        this.cbfzjhm = cbfzjhm;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    @Override
    public String toString() {
        return "TbCbf{" +
                "id=" + id +
                ", cbfbm='" + cbfbm + '\'' +
                ", cbfmc='" + cbfmc + '\'' +
                ", cbflx='" + cbflx + '\'' +
                ", cbfzjhm='" + cbfzjhm + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", jid=" + jid +
                '}';
    }
}
