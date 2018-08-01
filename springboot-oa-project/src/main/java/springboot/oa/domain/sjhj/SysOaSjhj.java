package springboot.oa.domain.sjhj;

import java.io.Serializable;
import java.util.Date;

public class SysOaSjhj implements Serializable {
    private Integer id;

    private String proname;

    private String provinceCode;

    private String cityname;

    private String cityCode;

    private String hjrxm;

    private String hjrxmId;

    private String hjjzdm;

    private String hjjzdmId;

    private String bz;

    private Date hjsj;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getHjrxm() {
        return hjrxm;
    }

    public void setHjrxm(String hjrxm) {
        this.hjrxm = hjrxm == null ? null : hjrxm.trim();
    }

    public String getHjrxmId() {
        return hjrxmId;
    }

    public void setHjrxmId(String hjrxmId) {
        this.hjrxmId = hjrxmId == null ? null : hjrxmId.trim();
    }

    public String getHjjzdm() {
        return hjjzdm;
    }

    public void setHjjzdm(String hjjzdm) {
        this.hjjzdm = hjjzdm == null ? null : hjjzdm.trim();
    }

    public String getHjjzdmId() {
        return hjjzdmId;
    }

    public void setHjjzdmId(String hjjzdmId) {
        this.hjjzdmId = hjjzdmId == null ? null : hjjzdmId.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Date getHjsj() {
        return hjsj;
    }

    public void setHjsj(Date hjsj) {
        this.hjsj = hjsj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proname=").append(proname);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", cityname=").append(cityname);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", hjrxm=").append(hjrxm);
        sb.append(", hjrxmId=").append(hjrxmId);
        sb.append(", hjjzdm=").append(hjjzdm);
        sb.append(", hjjzdmId=").append(hjjzdmId);
        sb.append(", bz=").append(bz);
        sb.append(", hjsj=").append(hjsj);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}