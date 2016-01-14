package imangine.database.entity;

// Generated 2016-1-14 13:50:25 by Hibernate Tools 4.3.1

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer userId;
	private String userName;
	private String password;
	private String avatarPath;
	private String email;
	private String city;
	private String gender;
	private Date birthday;
	private String description;
	private Set groupComments = new HashSet(0);
	private Set albums = new HashSet(0);
	private Set groupMembers = new HashSet(0);
	private Set friendsForFriendId = new HashSet(0);
	private Set pictureComments = new HashSet(0);
	private Set groups = new HashSet(0);
	private Set albumLikeds = new HashSet(0);
	private Set friendsForMyId = new HashSet(0);
	private Set albumComments = new HashSet(0);
	private Set pictures = new HashSet(0);
	private Set pictureLikeds = new HashSet(0);

	public User() {
	}

	public User(String userName, String password, Date birthday) {
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
	}

	public User(String userName, String password, String avatarPath,
			String email, String city, String gender, Date birthday,
			String description, Set groupComments, Set albums,
			Set groupMembers, Set friendsForFriendId, Set pictureComments,
			Set groups, Set albumLikeds, Set friendsForMyId, Set albumComments,
			Set pictures, Set pictureLikeds) {
		this.userName = userName;
		this.password = password;
		this.avatarPath = avatarPath;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.birthday = birthday;
		this.description = description;
		this.groupComments = groupComments;
		this.albums = albums;
		this.groupMembers = groupMembers;
		this.friendsForFriendId = friendsForFriendId;
		this.pictureComments = pictureComments;
		this.groups = groups;
		this.albumLikeds = albumLikeds;
		this.friendsForMyId = friendsForMyId;
		this.albumComments = albumComments;
		this.pictures = pictures;
		this.pictureLikeds = pictureLikeds;
	}

	public User(String email2, String password2) {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set groupComments) {
		this.groupComments = groupComments;
	}

	public Set getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set albums) {
		this.albums = albums;
	}

	public Set getGroupMembers() {
		return this.groupMembers;
	}

	public void setGroupMembers(Set groupMembers) {
		this.groupMembers = groupMembers;
	}

	public Set getFriendsForFriendId() {
		return this.friendsForFriendId;
	}

	public void setFriendsForFriendId(Set friendsForFriendId) {
		this.friendsForFriendId = friendsForFriendId;
	}

	public Set getPictureComments() {
		return this.pictureComments;
	}

	public void setPictureComments(Set pictureComments) {
		this.pictureComments = pictureComments;
	}

	public Set getGroups() {
		return this.groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	public Set getAlbumLikeds() {
		return this.albumLikeds;
	}

	public void setAlbumLikeds(Set albumLikeds) {
		this.albumLikeds = albumLikeds;
	}

	public Set getFriendsForMyId() {
		return this.friendsForMyId;
	}

	public void setFriendsForMyId(Set friendsForMyId) {
		this.friendsForMyId = friendsForMyId;
	}

	public Set getAlbumComments() {
		return this.albumComments;
	}

	public void setAlbumComments(Set albumComments) {
		this.albumComments = albumComments;
	}

	public Set getPictures() {
		return this.pictures;
	}

	public void setPictures(Set pictures) {
		this.pictures = pictures;
	}

	public Set getPictureLikeds() {
		return this.pictureLikeds;
	}

	public void setPictureLikeds(Set pictureLikeds) {
		this.pictureLikeds = pictureLikeds;
	}

	public String getBirthdayString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tmp = birthday;
		return sdf.format(tmp);
	}

}