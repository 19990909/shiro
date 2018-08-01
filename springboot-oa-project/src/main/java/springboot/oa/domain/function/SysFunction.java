package springboot.oa.domain.function;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysFunction implements Serializable {
    private String id;

    private String name;

    private String funcUrl;

    private String funcDesc;

    private String funcType;

    private Date createtime;

    private String pid;

    private boolean isParent;

    private boolean open;

    private String classfield;

    private String siteId;

    private boolean isleaf;

    private boolean checked;

    private String roleId;

    private String pidName;

    List<String> idList; //用于递归查询id,和删除时使用

    List<SysFunction> sysFuncList;

    public List<SysFunction> getSysFuncList() {
        return sysFuncList;
    }

    public void setSysFuncList(List<SysFunction> sysFuncList) {
        this.sysFuncList = sysFuncList;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc == null ? null : funcDesc.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open ;
    }

    public String getClassfield() {
        return classfield;
    }

    public void setClassfield(String classfield) {
        this.classfield = classfield == null ? null : classfield.trim();
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId == null ? null : siteId.trim();
    }

    public boolean getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(boolean isleaf) {
        this.isleaf = isleaf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", funcUrl=").append(funcUrl);
        sb.append(", funcDesc=").append(funcDesc);
        sb.append(", funcType=").append(funcType);
        sb.append(", createtime=").append(createtime);
        sb.append(", pid=").append(pid);
        sb.append(", isParent=").append(isParent);
        sb.append(", open=").append(open);
        sb.append(", classfield=").append(classfield);
        sb.append(", siteId=").append(siteId);
        sb.append(", isleaf=").append(isleaf);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}