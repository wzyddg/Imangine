package imangine;

// Generated 2015-6-2 19:52:21 by Hibernate Tools 4.3.1

/**
 * AlbumIncluded generated by hbm2java
 */
public class AlbumIncluded implements java.io.Serializable {

	private AlbumIncludedId id;
	private Albums albums;
	private Pictures pictures;

	public AlbumIncluded() {
	}

	public AlbumIncluded(AlbumIncludedId id, Albums albums) {
		this.id = id;
		this.albums = albums;
	}

	public AlbumIncluded(AlbumIncludedId id, Albums albums, Pictures pictures) {
		this.id = id;
		this.albums = albums;
		this.pictures = pictures;
	}

	public AlbumIncludedId getId() {
		return this.id;
	}

	public void setId(AlbumIncludedId id) {
		this.id = id;
	}

	public Albums getAlbums() {
		return this.albums;
	}

	public void setAlbums(Albums albums) {
		this.albums = albums;
	}

	public Pictures getPictures() {
		return this.pictures;
	}

	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}

}
