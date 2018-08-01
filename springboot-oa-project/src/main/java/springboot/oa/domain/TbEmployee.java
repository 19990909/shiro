package springboot.oa.domain;

import java.io.Serializable;
import java.util.Date;

public class TbEmployee  implements Serializable {
	private Integer id;

	private String address;

	private Date birthday;

	private String cardid;

	private Date createdate;

	private String education;

	private String email;

	private Integer gender;

	private String hobby;

	private String name;

	private String party;

	private String phone;

	private String postcode;

	private String qqnum;

	private String race;

	private String remark;

	private String speciality;

	private Integer did;

	private Integer jid;

	private Integer uid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid == null ? null : cardid.trim();
	}

	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getcreatedate() {
		return createdate;
	}

	public void setcreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby == null ? null : hobby.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party == null ? null : party.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode == null ? null : postcode.trim();
	}

	public String getQqnum() {
		return qqnum;
	}

	public void setQqnum(String qqnum) {
		this.qqnum = qqnum == null ? null : qqnum.trim();
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race == null ? null : race.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality == null ? null : speciality.trim();
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "TbEmployee [id=" + id + ", address=" + address + ", birthday=" + birthday + ", cardid=" + cardid
				+ ", createdate=" + createdate + ", education=" + education + ", email=" + email + ", gender=" + gender
				+ ", hobby=" + hobby + ", name=" + name + ", party=" + party + ", phone=" + phone + ", postcode="
				+ postcode + ", qqnum=" + qqnum + ", race=" + race + ", remark=" + remark + ", speciality=" + speciality
				+ ", did=" + did + ", jid=" + jid + ", uid=" + uid + "]";
	}


	
}