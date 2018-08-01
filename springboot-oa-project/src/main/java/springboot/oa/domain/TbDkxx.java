package springboot.oa.domain;

import java.io.Serializable;

public class TbDkxx implements Serializable {
    private Integer id;

    private String dkbm;

    private String dz;

    private String xz;

    private String nz;

    private String bz;

    private String cid;

    private Integer qzbm;

    private String xzdwName;

    private String xzdwId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDkbm() {
        return dkbm;
    }

    public void setDkbm(String dkbm) {
        this.dkbm = dkbm == null ? null : dkbm.trim();
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz == null ? null : dz.trim();
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz == null ? null : xz.trim();
    }

    public String getNz() {
        return nz;
    }

    public void setNz(String nz) {
        this.nz = nz == null ? null : nz.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getQzbm() {
        return qzbm;
    }

    public void setQzbm(Integer qzbm) {
        this.qzbm = qzbm;
    }

    public String getXzdwName() {
        return xzdwName;
    }

    public void setXzdwName(String xzdwName) {
        this.xzdwName = xzdwName == null ? null : xzdwName.trim();
    }

    public String getXzdwId() {
        return xzdwId;
    }

    public void setXzdwId(String xzdwId) {
        this.xzdwId = xzdwId == null ? null : xzdwId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dkbm=").append(dkbm);
        sb.append(", dz=").append(dz);
        sb.append(", xz=").append(xz);
        sb.append(", nz=").append(nz);
        sb.append(", bz=").append(bz);
        sb.append(", cid=").append(cid);
        sb.append(", qzbm=").append(qzbm);
        sb.append(", xzdwName=").append(xzdwName);
        sb.append(", xzdwId=").append(xzdwId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}