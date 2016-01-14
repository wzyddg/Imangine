package imangine.database.entity;

// Generated 2016-1-14 13:50:25 by Hibernate Tools 4.3.1

/**
 * Friend generated by hbm2java
 */
public class Friend implements java.io.Serializable {

	private FriendId id;
	private User userByFriendId;
	private User userByMyId;

	public Friend() {
	}

	public Friend(FriendId id, User userByMyId) {
		this.id = id;
		this.userByMyId = userByMyId;
	}

	public Friend(FriendId id, User userByFriendId, User userByMyId) {
		this.id = id;
		this.userByFriendId = userByFriendId;
		this.userByMyId = userByMyId;
	}

	public FriendId getId() {
		return this.id;
	}

	public void setId(FriendId id) {
		this.id = id;
	}

	public User getUserByFriendId() {
		return this.userByFriendId;
	}

	public void setUserByFriendId(User userByFriendId) {
		this.userByFriendId = userByFriendId;
	}

	public User getUserByMyId() {
		return this.userByMyId;
	}

	public void setUserByMyId(User userByMyId) {
		this.userByMyId = userByMyId;
	}

}