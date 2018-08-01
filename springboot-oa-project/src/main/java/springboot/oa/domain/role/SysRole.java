package springboot.oa.domain.role;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private String id;

    private String roleName;

    private String roleCode;

    private Date createtime;

    private String createuser;

    private String siteId;

    private String roleBz;

    private boolean roleFlag;

    public boolean getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(boolean roleFlag) {
        this.roleFlag = roleFlag;
    }


    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId == null ? null : siteId.trim();
    }

    public String getRoleBz() {
        return roleBz;
    }

    public void setRoleBz(String roleBz) {
        this.roleBz = roleBz == null ? null : roleBz.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", createtime=").append(createtime);
        sb.append(", createuser=").append(createuser);
        sb.append(", siteId=").append(siteId);
        sb.append(", roleBz=").append(roleBz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}