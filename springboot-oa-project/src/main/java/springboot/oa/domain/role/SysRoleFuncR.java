package springboot.oa.domain.role;

import java.io.Serializable;
import java.util.List;

public class SysRoleFuncR implements Serializable {
    private String id;

    private String roleId;

    private String funcId;

    private List<SysRoleFuncR> sysRoleFuncRList;

    public List<SysRoleFuncR> getSysRoleFuncRList() {
        return sysRoleFuncRList;
    }

    public void setSysRoleFuncRList(List<SysRoleFuncR> sysRoleFuncRList) {
        this.sysRoleFuncRList = sysRoleFuncRList;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", funcId=").append(funcId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}