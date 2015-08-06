package imangine;

// Generated 2015-6-2 19:52:21 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pictures generated by hbm2java
 */
public class Pictures implements java.io.Serializable {

	private Integer picId;
	private Users users;
	private String address;
	private Date postDate;
	private String title;
	private String description;
	private Set picLikeds = new HashSet(0);
	private Set picComments = new HashSet(0);
	private Set picTags = new HashSet(0);
	private Set albumIncludeds = new HashSet(0);

	public Pictures() {
	}

	public Pictures(String address, Users user, String title) {
		this.address = address;
		this.users=user;
		this.title = title;
		this.postDate=new Date();
	}

	public Pictures(Users users, String address, Date postDate, String title,
			Set picLikeds, Set picComments, Set picTags, Set albumIncludeds) {
		this.users = users;
		this.address = address;
		this.postDate = postDate;
		this.title = title;
		this.picLikeds = picLikeds;
		this.picComments = picComments;
		this.picTags = picTags;
		this.albumIncludeds = albumIncludeds;
	}

	public Integer getPicId() {
		return this.picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getPicLikeds() {
		return this.picLikeds;
	}

	public void setPicLikeds(Set picLikeds) {
		this.picLikeds = picLikeds;
	}

	public Set getPicComments() {
		return this.picComments;
	}

	public void setPicComments(Set picComments) {
		this.picComments = picComments;
	}

	public Set getPicTags() {
		return this.picTags;
	}

	public void setPicTags(Set picTags) {
		this.picTags = picTags;
	}

	public Set getAlbumIncludeds() {
		return this.albumIncludeds;
	}

	public void setAlbumIncludeds(Set albumIncludeds) {
		this.albumIncludeds = albumIncludeds;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}