package springboot.oa.domain;


import java.io.Serializable;

public class Message  implements Serializable {
	private String name;
	private String gender;
	private String phone;
	private String email;
	private TbJob job;
	private String education;
	private String cardid;
	private TbFbf fbf;
	private String address;
	private String createDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TbJob getJob() {
		return job;
	}
	public void setJob(TbJob job) {
		this.job = job;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public TbFbf getDept() {
		return fbf;
	}
	public void setDept(TbFbf dept) {
		this.fbf = dept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Message [name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", job=" + job
				+ ", education=" + education + ", cardid=" + cardid + ", fbf=" + fbf + ", address=" + address
				+ ", createDate=" + createDate + "]";
	}

}