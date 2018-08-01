package springboot.oa.domain.org;

import java.io.Serializable;
import java.util.Date;

public class SysOrg implements Serializable {
    private String id;

    private String orgName;

    private String orgTel;

    private String orgAddress;

    private String orgCode;

    private String orgStatus;

    private String orgBz;

    private String orgCreateuser;

    private Date createtime;

    private String orgRegionId;

    private String pid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel == null ? null : orgTel.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus == null ? null : orgStatus.trim();
    }

    public String getOrgBz() {
        return orgBz;
    }

    public void setOrgBz(String orgBz) {
        this.orgBz = orgBz == null ? null : orgBz.trim();
    }

    public String getOrgCreateuser() {
        return orgCreateuser;
    }

    public void setOrgCreateuser(String orgCreateuser) {
        this.orgCreateuser = orgCreateuser == null ? null : orgCreateuser.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOrgRegionId() {
        return orgRegionId;
    }

    public void setOrgRegionId(String orgRegionId) {
        this.orgRegionId = orgRegionId == null ? null : orgRegionId.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgTel=").append(orgTel);
        sb.append(", orgAddress=").append(orgAddress);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", orgBz=").append(orgBz);
        sb.append(", orgCreateuser=").append(orgCreateuser);
        sb.append(", createtime=").append(createtime);
        sb.append(", orgRegionId=").append(orgRegionId);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}