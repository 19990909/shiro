package springboot.oa.domain;

import java.io.Serializable;

public class TbSfqk implements Serializable {
	private Integer id;
	private String  sqhdm;
	private String sfmc;
	private String sccbdmj;
	private String qqmj;
	private String bzs;
	private String wcqqqk;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSqhdm() {
		return sqhdm;
	}

	public void setSqhdm(String sqhdm) {
		this.sqhdm = sqhdm;
	}

	public String getSfmc() {
		return sfmc;
	}

	public void setSfmc(String sfmc) {
		this.sfmc = sfmc;
	}

	public String getSccbdmj() {
		return sccbdmj;
	}

	public void setSccbdmj(String sccbdmj) {
		this.sccbdmj = sccbdmj;
	}

	public String getQqmj() {
		return qqmj;
	}

	public void setQqmj(String qqmj) {
		this.qqmj = qqmj;
	}

	public String getBzs() {
		return bzs;
	}

	public void setBzs(String bzs) {
		this.bzs = bzs;
	}

	public String getWcqqqk() {
		return wcqqqk;
	}

	public void setWcqqqk(String wcqqqk) {
		this.wcqqqk = wcqqqk;
	}

	@Override
	public String toString() {
		return "TbSfqk{" +
				"id=" + id +
				", sqhdm='" + sqhdm + '\'' +
				", sfmc='" + sfmc + '\'' +
				", sccbdmj='" + sccbdmj + '\'' +
				", qqmj='" + qqmj + '\'' +
				", bzs='" + bzs + '\'' +
				", wcqqqk='" + wcqqqk + '\'' +
				'}';
	}
}