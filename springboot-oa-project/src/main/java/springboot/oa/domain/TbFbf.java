package springboot.oa.domain;

import java.io.Serializable;

public class TbFbf  implements Serializable {
    private Integer id;

    private String fbfmc;

    private String fbfzjhm;
    
    private String fbflxdh;
    
    private String fbfdz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getFbfmc() {
		return fbfmc;
	}

	public void setFbfmc(String fbfmc) {
		this.fbfmc = fbfmc;
	}

	public String getFbfzjhm() {
		return fbfzjhm;
	}

	public void setFbfzjhm(String fbfzjhm) {
		this.fbfzjhm = fbfzjhm;
	}

	public String getFbflxdh() {
		return fbflxdh;
	}

	public void setFbflxdh(String fbflxdh) {
		this.fbflxdh = fbflxdh;
	}

	public String getFbfdz() {
		return fbfdz;
	}

	public void setFbfdz(String fbfdz) {
		this.fbfdz = fbfdz;
	}

	@Override
	public String toString() {
		return "TbDept [id=" + id + ", fbfmc=" + fbfmc + ", fbfzjhm=" + fbfzjhm + ", fbflxdh=" + fbflxdh + ", fbfdz="
				+ fbfdz + "]";
	}

    
    
}