package imangine.database.entity;

// Generated 2016-1-14 13:50:25 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Album generated by hbm2java
 */
public class Album implements java.io.Serializable {

	private Integer albumId;
	private User user;
	private int pictureNum;
	private Date setDate;
	private String description;
	private String coverPath;
	private String theme;
	private Set albumLikeds = new HashSet(0);
	private Set albumIncludeds = new HashSet(0);
	private Set albumComments = new HashSet(0);

	public Album() {
	}

	public Album(User user, int pictureNum, Date setDate, String theme) {
		this.user = user;
		this.pictureNum = pictureNum;
		this.setDate = setDate;
		this.theme = theme;
	}

	public Album(User user, int pictureNum, Date setDate, String description,
			String coverPath, String theme, Set albumLikeds,
			Set albumIncludeds, Set albumComments) {
		this.user = user;
		this.pictureNum = pictureNum;
		this.setDate = setDate;
		this.description = description;
		this.coverPath = coverPath;
		this.theme = theme;
		this.albumLikeds = albumLikeds;
		this.albumIncludeds = albumIncludeds;
		this.albumComments = albumComments;
	}

	public Album(User user2, Date setDate2, String theme2, String description2) {
		this.user = user2;
		this.setDate = setDate2;
		this.theme = theme2;
		this.description = description2;
	}

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPictureNum() {
		return this.pictureNum;
	}

	public void setPictureNum(int pictureNum) {
		this.pictureNum = pictureNum;
	}

	public Date getSetDate() {
		return this.setDate;
	}

	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverPath() {
		return this.coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Set getAlbumLikeds() {
		return this.albumLikeds;
	}

	public void setAlbumLikeds(Set albumLikeds) {
		this.albumLikeds = albumLikeds;
	}

	public Set getAlbumIncludeds() {
		return this.albumIncludeds;
	}

	public void setAlbumIncludeds(Set albumIncludeds) {
		this.albumIncludeds = albumIncludeds;
	}

	public Set getAlbumComments() {
		return this.albumComments;
	}

	public void setAlbumComments(Set albumComments) {
		this.albumComments = albumComments;
	}

}