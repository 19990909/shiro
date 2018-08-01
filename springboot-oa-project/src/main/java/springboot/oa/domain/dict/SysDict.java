package springboot.oa.domain.dict;

import java.io.Serializable;

public class SysDict implements Serializable {
    private String id;

    private String dictType; //字典类别

    private String dictCode; //字典代码

    private String dictValue; //字典值

    private String dictStatus; //字典状态 0 失效   1正常

    private String dictCreateuser; //创建人

    private String dictCodePid;  //字典父id (不是必须的)

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus == null ? null : dictStatus.trim();
    }

    public String getDictCreateuser() {
        return dictCreateuser;
    }

    public void setDictCreateuser(String dictCreateuser) {
        this.dictCreateuser = dictCreateuser == null ? null : dictCreateuser.trim();
    }

    public String getDictCodePid() {
        return dictCodePid;
    }

    public void setDictCodePid(String dictCodePid) {
        this.dictCodePid = dictCodePid == null ? null : dictCodePid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dictType=").append(dictType);
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictValue=").append(dictValue);
        sb.append(", dictStatus=").append(dictStatus);
        sb.append(", dictCreateuser=").append(dictCreateuser);
        sb.append(", dictCodePid=").append(dictCodePid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}