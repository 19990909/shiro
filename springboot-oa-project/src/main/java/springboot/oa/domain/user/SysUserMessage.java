package springboot.oa.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUserMessage implements Serializable {
    private Integer id;

    private String sjr;

    private String zt;

    private String zw;

    private String uploadpath;

    private String fjr;

    private String xxlb;

    private String fszt;

    private String dqzt;

    private String by3; // 收发类别  1 发件  2 收件

    private String by4; //当删除到回收站的时候记录当前操作的用户名，用户回收站的查询条件

    private String by5; //存储该邮件从哪里删到回收站的，记录改邮件的原位置

    private String by6; //用来区别直接接收和转发接收的邮件   1 直接接收   0 转发接收

    private String by7;

    private Date fssj;

    private List<Integer> ids;

    private List<SysUserMessage> userMessageList;

    public List<SysUserMessage> getUserMessageList() {
        return userMessageList;
    }

    public void setUserMessageList(List<SysUserMessage> userMessageList) {
        this.userMessageList = userMessageList;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr == null ? null : sjr.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public String getUploadpath() {
        return uploadpath;
    }

    public void setUploadpath(String uploadpath) {
        this.uploadpath = uploadpath == null ? null : uploadpath.trim();
    }

    public String getFjr() {
        return fjr;
    }

    public void setFjr(String fjr) {
        this.fjr = fjr == null ? null : fjr.trim();
    }

    public String getXxlb() {
        return xxlb;
    }

    public void setXxlb(String xxlb) {
        this.xxlb = xxlb == null ? null : xxlb.trim();
    }

    public String getFszt() {
        return fszt;
    }

    public void setFszt(String fszt) {
        this.fszt = fszt == null ? null : fszt.trim();
    }

    public String getDqzt() {
        return dqzt;
    }

    public void setDqzt(String dqzt) {
        this.dqzt = dqzt == null ? null : dqzt.trim();
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3 == null ? null : by3.trim();
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4 == null ? null : by4.trim();
    }

    public String getBy5() {
        return by5;
    }

    public void setBy5(String by5) {
        this.by5 = by5 == null ? null : by5.trim();
    }

    public String getBy6() {
        return by6;
    }

    public void setBy6(String by6) {
        this.by6 = by6 == null ? null : by6.trim();
    }

    public String getBy7() {
        return by7;
    }

    public void setBy7(String by7) {
        this.by7 = by7 == null ? null : by7.trim();
    }

    public Date getFssj() {
        return fssj;
    }

    public void setFssj(Date fssj) {
        this.fssj = fssj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sjr=").append(sjr);
        sb.append(", zt=").append(zt);
        sb.append(", zw=").append(zw);
        sb.append(", uploadpath=").append(uploadpath);
        sb.append(", fjr=").append(fjr);
        sb.append(", xxlb=").append(xxlb);
        sb.append(", fszt=").append(fszt);
        sb.append(", dqzt=").append(dqzt);
        sb.append(", by3=").append(by3);
        sb.append(", by4=").append(by4);
        sb.append(", by5=").append(by5);
        sb.append(", by6=").append(by6);
        sb.append(", by7=").append(by7);
        sb.append(", fssj=").append(fssj);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}