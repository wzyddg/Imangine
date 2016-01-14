package imangine.database.entity;

// Generated 2016-1-14 10:25:48 by Hibernate Tools 4.3.1

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String password;
	private String avatarPath;
	private String email;
	private String city;
	private String gender;
	private Date birthday;
	private String discription;
	private Set groupComments = new HashSet(0);
	private Set groupMems = new HashSet(0);
	private Set picLikeds = new HashSet(0);
	private Set albumLikeds = new HashSet(0);
	private Set pictureses = new HashSet(0);
	private Set friendsesForFriendId = new HashSet(0);
	private Set albumses = new HashSet(0);
	private Set friendsesForMyId = new HashSet(0);
	private Set groupses = new HashSet(0);
	private Set picComments = new HashSet(0);

	public Users() {
	}

	public Users(String userName, String password, Date birthday) {
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
	}

	public Users(String userName, String password, String avatarPath,
			String email, String city, String gender, Date birthday,
			String discription, Set groupComments, Set groupMems,
			Set picLikeds, Set albumLikeds, Set pictureses,
			Set friendsesForFriendId, Set albumses, Set friendsesForMyId,
			Set groupses, Set picComments) {
		this.userName = userName;
		this.password = password;
		this.avatarPath = avatarPath;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.birthday = birthday;
		this.discription = discription;
		this.groupComments = groupComments;
		this.groupMems = groupMems;
		this.picLikeds = picLikeds;
		this.albumLikeds = albumLikeds;
		this.pictureses = pictureses;
		this.friendsesForFriendId = friendsesForFriendId;
		this.albumses = albumses;
		this.friendsesForMyId = friendsesForMyId;
		this.groupses = groupses;
		this.picComments = picComments;
	}

	public Users(String email2, String password2) {
		this.email = email2;
		this.password = password2;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarPath() {
		return this.avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Set getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set groupComments) {
		this.groupComments = groupComments;
	}

	public Set getGroupMems() {
		return this.groupMems;
	}

	public void setGroupMems(Set groupMems) {
		this.groupMems = groupMems;
	}

	public Set getPicLikeds() {
		return this.picLikeds;
	}

	public void setPicLikeds(Set picLikeds) {
		this.picLikeds = picLikeds;
	}

	public Set getAlbumLikeds() {
		return this.albumLikeds;
	}

	public void setAlbumLikeds(Set albumLikeds) {
		this.albumLikeds = albumLikeds;
	}

	public Set getPictureses() {
		return this.pictureses;
	}

	public void setPictureses(Set pictureses) {
		this.pictureses = pictureses;
	}

	public Set getFriendsesForFriendId() {
		return this.friendsesForFriendId;
	}

	public void setFriendsesForFriendId(Set friendsesForFriendId) {
		this.friendsesForFriendId = friendsesForFriendId;
	}

	public Set getAlbumses() {
		return this.albumses;
	}

	public void setAlbumses(Set albumses) {
		this.albumses = albumses;
	}

	public Set getFriendsesForMyId() {
		return this.friendsesForMyId;
	}

	public void setFriendsesForMyId(Set friendsesForMyId) {
		this.friendsesForMyId = friendsesForMyId;
	}

	public Set getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set groupses) {
		this.groupses = groupses;
	}

	public Set getPicComments() {
		return this.picComments;
	}

	public void setPicComments(Set picComments) {
		this.picComments = picComments;
	}

	public String getBirthdayString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tmp = birthday;
		return sdf.format(tmp);
	}

}