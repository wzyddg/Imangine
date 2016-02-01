package imangine.database.dao;

import imangine.database.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DataAccessObject {
	static SessionFactory sessionFactory;
	static Configuration configuration;
	static private String filesDirectory;

	public static String getFilesDirectory() {
		if (filesDirectory == null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse("./WebContent/META-INF/context.xml");

				NodeList contextList = doc.getElementsByTagName("Context");
				for (int i = 0; i < contextList.getLength(); i++) {
					Node context = contextList.item(i);
					Element elem = (Element) context;
					if ("/Imangine/files".equals(elem.getAttribute("path"))) {
						filesDirectory = elem.getAttribute("docBase");
					}
				}
			} catch (Exception e) {
				return null;
			}
		}
		return filesDirectory;
	}

	private static Session sessionStart() {
		if (sessionFactory == null) {
			configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration
					.buildSessionFactory(standardServiceRegistry);
		}
		return sessionFactory.openSession();
	}

	public static void main(String[] args) {
		// setAlbumCommentWithAlbumIdNUserIdNContent(2, 16, "some like it hot");
		// System.out.println(16+getUserWithEmail("104@qq.com").getUserName());
		// System.out.println("616:");
		// System.out.println(getUserWithEmail("104@qqasdafasfwea.com"));
		// register("104@qq.com", "addas");
		System.out.println(getFilesDirectory());
	}

	/**
	 * @user
	 */

	public static User login(String email, String passWord) {
		Session session = sessionStart();
		String hql = "from User where email=? and password=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, email);
		query.setString(1, passWord);
		User user = (User) query.uniqueResult();
		session.close();
		// System.out.println(user.get(0).getEmail());
		return user;
	}

	public static User getUserWithUserId(Integer userId) {
		if (userId == 0 || userId == null)
			return null;

		Session session = sessionStart();
		String hql = "from User where userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);

		User user = (User) query.uniqueResult();
		session.close();

		return user;
	}

	public static User getUserWithEmail(String email) {
		if ("".equals(email) || email == null)
			return null;

		Session session = sessionStart();
		String hql = "from User where email=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, email);

		User user = (User) query.uniqueResult();
		session.close();

		return user;
	}

	public static User register(String email, String password) {
		if (getUserWithEmail(email) != null) {
			System.err.println("email already used");
			return null;
		}

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();

		User user = new User(email, password);
		// System.out.println(user.getPassword());
		try {
			session.save(user);
		} catch (Exception e) {
			tx.rollback();
			session.close();
			return null;
		}
		tx.commit();
		session.close();
		user.setPassword(null);
		return user; // return user instance With empty password,register and
						// auto-login
	}

	public static User updateUserInfo(Integer userId, String userName,
			String avatar, String email, String city, String gender,
			String description, String birthday) {

		if (userId == 0 || userId == null)
			return null;

		User user = getUserWithUserId(userId);

		if (userName == null) {
			userName = user.getUserName();
		}
		if (avatar == null) {
			avatar = user.getAvatarPath();
		}
		if (email == null) {
			email = user.getEmail();
		}
		if (city == null) {
			city = user.getCity();
		}
		if (gender == null) {
			gender = user.getGender();
		}
		if (description == null) {
			description = user.getDescription();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date userBirthday = new Date();
		// System.out.println(birthday);
		try {
			userBirthday = sdf.parse(birthday);
			// System.out.println(userBirthday);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "update User user set user.userName=? ,user.avatar=? , user.email=? , user.city=? , user.gender=? ,user.birthday=? ,user.description=? where user.userId=?";
		Query queryupdate = ((SharedSessionContract) session).createQuery(hql);
		queryupdate.setString(0, userName);
		queryupdate.setString(1, avatar);
		queryupdate.setString(2, email);
		queryupdate.setString(3, city);
		queryupdate.setString(4, gender);
		queryupdate.setDate(5, userBirthday);
		queryupdate.setString(6, description);
		queryupdate.setInteger(7, userId);
		try {
			queryupdate.executeUpdate();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			return null;
		}
		tx.commit();
		session.close();

		return getUserWithUserId(userId);
	}

	public static User updateUserInfo(Integer userId, String userName,
			String password, String avatar, String email, String city,
			String gender, String description, String birthday) {

		User user = getUserWithUserId(userId);
		if (userName == null) {
			userName = user.getUserName();
		}
		if (avatar == null) {
			avatar = user.getAvatarPath();
		}
		if (email == null) {
			email = user.getEmail();
		}
		if (city == null) {
			city = user.getCity();
		}
		if (gender == null) {
			gender = user.getGender();
		}
		if (description == null) {
			description = user.getDescription();
		}
		if (password == null) {
			password = user.getPassword();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // convert
																	// String to
																	// Date
		Date userBirthday = new Date();
		// System.out.println(birthday);
		try {
			userBirthday = sdf.parse(birthday);
			// System.out.println(userBirthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "update User user set user.userName=? ,user.avatar=? , user.email=? , user.city=? , user.gender=? ,user.birthday=? ,user.description=? ,user.password=? where user.userId=?";
		Query queryupdate = ((SharedSessionContract) session).createQuery(hql);
		queryupdate.setString(0, userName);
		queryupdate.setString(1, avatar);
		queryupdate.setString(2, email);
		queryupdate.setString(3, city);
		queryupdate.setString(4, gender);
		queryupdate.setDate(5, userBirthday);
		queryupdate.setString(6, description);
		queryupdate.setString(7, password);
		queryupdate.setInteger(8, userId);
		queryupdate.executeUpdate();
		tx.commit();
		session.close();

		return null;
	}

	public static boolean changePasswordWithUserIdNOldPasswordNNewPassword(
			Integer userId, String oldPassword, String newPassword) {
		// System.out.println(oldPassword);
		// System.out.println(getUserWithUserId(userId).getPassword());
		if (oldPassword.equals(getUserWithUserId(userId).getPassword())) {
			Session session = sessionStart();
			Transaction tx = session.beginTransaction();
			String hql = "update User user set user.password=? where user.userId=?";
			Query queryupdate = ((SharedSessionContract) session)
					.createQuery(hql);
			queryupdate.setString(0, newPassword);
			queryupdate.setInteger(1, userId);
			queryupdate.executeUpdate();
			tx.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @picture
	 */
	public static Picture getPictureWithPictureId(Integer pictureId) {

		Session session = sessionStart();
		String hql = "from Picture where pictureId =?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		// List<Picture> picture = query.list();
		Picture resultPicture = (Picture) query.uniqueResult();
		// System.out.println(picture.get(0).getPath());
		session.close();
		// return (picture.size() == 0 ? null : picture.get(0));
		return resultPicture;
	}

	// TODO: change page contain

	// TODO: change page contain
	public static List<Picture> getPicturesWithPosterIdNIndex(Integer posterId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from Picture where user.userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, posterId);
		List<Picture> pictureList = query.list();
		// for(Picture picture :pictureList)
		// System.out.println(picture.getPath());

		int pageContain = 9; // how many pictures in one page
		int first = (index) * pageContain;
		List<Picture> pictureListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < pictureList.size(); i++) {
			pictureListWant.add(pictureList.get(i));
		}
		// for(Picture picture :pictureListWant)
		// System.out.println(picture.getPath());
		session.close();
		return pictureListWant;

	}

	// TODO: change page contain

	public static List<PictureTag> getPictureIdsWithTagNIndex(String tag,
			Integer index) {
		Session session = sessionStart();
		String hql = "from PictureTag where id.tag= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, tag);
		List<PictureTag> pictureList = query.list();
		System.out.println(tag);
		int pageContain = 2;
		int first = (index) * pageContain;

		List<PictureTag> pictureListWant = new ArrayList<PictureTag>();
		for (int i = first; i < pageContain + first && i < pictureList.size(); i++) {
			pictureListWant.add(pictureList.get(i));
		}
		// for(PictureTag pictureTag :pictureListWant)
		// System.out.println(pictureTag.getId().getPictureId());
		session.close();
		return pictureListWant;
	}

	public static Picture setPictureWithPathNTitleNTagsNDescriptionNPosterId(
			String path, String title, String tags, String description,
			Integer posterId) {
		Picture picture = new Picture(path, getUserWithUserId(posterId), title);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		picture.setDescription(description);
		// System.out.println(picture.getTitle());
		session.save(picture);
		tx.commit();
		String singleTag[] = tags.split(",");
		// System.out.println(singleTag.length);

		for (int i = 0; i < singleTag.length; i++) {

			tx = session.beginTransaction();
			PictureTagId pictureTagId = new PictureTagId(singleTag[i],
					picture.getPictureId());
			PictureTag pictureTag = new PictureTag(pictureTagId, picture);
			session.save(pictureTag);
			// System.out.println(pictureTag.getId().getPictureId());
			tx.commit();
		}
		// System.out.println(picture.getPictureId());
		session.close();

		return picture;
	}

	public static List<PictureTag> getPictureTagsWithPictureId(Integer pictureId) {
		Session session = sessionStart();
		String hql = "from PictureTag where picture = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureTag> pictureTag = query.list();
		session.close();
		return pictureTag;
	}

	/**
	 * @picturelike
	 */

	public static Boolean removePictureLikeWithPictureIdNUserId(
			Integer pictureId, Integer userId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from PictureLiked where id.pictureId=? and id.userId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		query.setInteger(1, userId);
		PictureLiked pictureLiked = (PictureLiked) query.uniqueResult();

		if (pictureLiked != null) {
			try {
				session.delete(pictureLiked);
			} catch (Exception e) {
				System.err.println("remove picture Like Fail!");

				tx.rollback();
				session.close();
				return false;
			}
			tx.commit();
		}
		session.close();
		return true;
	}

	public static List<PictureLiked> getPictureLikeUserIdsWithPictureId(
			Integer pictureId) {
		Session session = sessionStart();
		String hql = "from PictureLiked where picture = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureLiked> userIdList = query.list();

		session.close();
		return userIdList;
	}

	public static Boolean setPictureLikeWithPictureIdNUserId(Integer pictureId,
			Integer userId) {

		Session session = sessionStart();
		String hql = "from PictureLiked where id.pictureId = ? and id.userId = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		query.setInteger(1, userId);
		List<PictureLiked> useridList = query.list();
		session.close();

		if (useridList.size() == 0) {
			PictureLiked pictureLiked = new PictureLiked(new PictureLikedId(
					pictureId, userId), getPictureWithPictureId(pictureId));
			session = sessionStart();
			Transaction tx = session.beginTransaction();
			session.save(pictureLiked);
			tx.commit();
			return true;
		} else {
			System.out.println("already like!");
			return false;
		}
	}

	/**
	 * @picturecomment
	 */

	public static List<PictureComment> getPictureCommentsWithPictureId(
			Integer pictureId) {

		Session session = sessionStart();
		String hql = "from PictureComment where picture= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureComment> comments = query.list();
		session.close();
		return comments;

	}

	public static boolean setPictureCommentWithPictureIdNUserIdNContent(
			Integer pictureId, Integer userId, String content) {
		Date commentDate = new Date();
		PictureComment pictureComment = new PictureComment(
				getPictureWithPictureId(pictureId), getUserWithUserId(userId),
				commentDate, content);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		try {
			session.save(pictureComment);
		} catch (Exception e) {
			System.err.println("set picture comment failed");
			tx.rollback();
			session.close();
			return false;
		}

		tx.commit();
		session.close();
		return true;

	}

	/**
	 * @group
	 */

	public static List<GroupMember> getGroupMemberWithGroupId(Integer groupId) {

		Session session = sessionStart();
		String hql = "from GroupMember where id.groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupMember> member = query.list();

		session.close();
		return member;
	}

	public static List<GroupMember> getGroupWithUserId(Integer userId) {

		Session session = sessionStart();
		String hql = "from GroupMember where id.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<GroupMember> group = query.list();
		session.close();
		return group;
	}

	// TODO: change page contain
	public static List<GroupMember> getGroupWithUserIdNIndex(Integer userId,
			Integer index) {
		List<GroupMember> group = getGroupWithUserId(userId);

		int pageContain = 9;
		int first = (index) * pageContain;
		List<GroupMember> groupMemberListWant = new ArrayList<GroupMember>();
		for (int i = first; i < pageContain + first && i < group.size(); i++) {
			groupMemberListWant.add(group.get(i));
		}

		return groupMemberListWant;
	}

	public static Group getGroupWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from Group where groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		Group group = (Group) query.uniqueResult();

		session.close();
		return group;

	}

	public static List<Group> getGroupWithSetterId(Integer setterId) {
		Session session = sessionStart();
		String hql = "from Group where user.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Group> group = query.list();
		session.close();
		return group;
	}

	// TODO: change page contain
	public static List<Group> getGroupWithSetterIdNIndex(Integer setterId,
			Integer index) {
		List<Group> group = getGroupWithSetterId(setterId);

		int pageContain = 8;
		int first = (index) * pageContain;
		List<Group> groupListWant = new ArrayList<Group>();
		for (int i = first; i < pageContain + first && i < group.size(); i++) {
			groupListWant.add(group.get(i));
		}

		return groupListWant;

	}

	public static Group setGroupWithNameNSetterIdNTheme(String groupName,
			Integer setterId, String theme) {
		Date setDate = new Date();
		Group group = new Group(getUserWithUserId(setterId), groupName,
				setDate, theme);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();

		try {
			session.save(group);
		} catch (Exception e) {
			System.err.println("set group failed");
			tx.rollback();
			session.close();
			return null;
		}

		tx.commit();
		session.close();
		return group;

	}

	public static boolean joinGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {
		GroupMember groupMember = new GroupMember(new GroupMemberId(groupId,
				userId), getGroupWithGroupId(groupId),
				getUserWithUserId(userId));
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();

		try {
			session.save(groupMember);
		} catch (Exception e) {
			System.err.println("joinGroup failed");
			tx.rollback();
			session.close();
			return false;
		}

		tx.commit();
		session.close();
		return true;
	}

	public static boolean quitGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {

		Session session = sessionStart();
		String hql = "from GroupMember where id.userId=? and id.groupId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		query.setInteger(1, groupId);
		GroupMember groupMember = (GroupMember) query.uniqueResult();
		// System.out.println(GroupMemberWant.get(0).getId().getUserId());

		if (groupMember != null) {
			Transaction tx = session.beginTransaction();
			try {
				session.delete(groupMember);
			} catch (Exception e) {
				System.err.println("quitGroup failed");
				tx.rollback();
				session.close();
				return false;
			}

			tx.commit();
		}
		session.close();
		return true;
	}

	public static List<GroupMember> getGroupMembersWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from GroupMember where id.groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupMember> group = query.list();
		// for(GroupMember Member:group)
		// System.out.println(Member.getUser().getUserId());
		session.close();
		return group;
	}

	/**
	 * @group_comment
	 */

	public static List<GroupComment> getGroupCommentsWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from GroupComment where group= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupComment> groupComments = query.list();
		// for(GroupComment comments:groupComments)
		// System.out.println(comments.getContent());
		session.close();
		return groupComments;
	}

	public static boolean setGroupCommentWithGroupIdNUserIdNContent(
			Integer groupId, Integer userId, String content) {

		Date commentDate = new Date();
		GroupComment groupComment = new GroupComment(
				getGroupWithGroupId(groupId), getUserWithUserId(userId),
				commentDate, content);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();

		try {
			session.save(groupComment);
		} catch (Exception e) {
			System.err.println("set group comment failed");
			tx.rollback();
			session.close();
			return false;
		}

		tx.commit();
		session.close();
		return true;
	}

	/**
	 * @friend
	 */

	public static List<Friend> getFriendWithUserId(Integer userId) {
		Session session = sessionStart();
		String hql = "from Friend where userByMyId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<Friend> Friend = query.list();
		// for(Friend guys:Friend)
		// System.out.println(guys.getId().getFriendId());
		session.close();
		return Friend;

	}

	/**
	 * @albums
	 */
	public static Album getAlbumWithAlbumId(Integer albumId) {
		Session session = sessionStart();
		String hql = "from Album where albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		Album album = (Album) query.uniqueResult();
		session.close();
		return album;
	}

	public static List<Album> getAlbumWithSetterId(Integer setterId) {

		Session session = sessionStart();
		String hql = "from Album where user= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Album> albums = query.list();
		// for(Album Albummm:Album)
		// System.out.println(Albummm.getTheme());
		session.close();
		return albums;

	}

	// TODO: change page contain
	public static List<Album> getAlbumWithSetterIdNIndex(Integer setterId,
			Integer index) {
		List<Album> albums = getAlbumWithSetterId(setterId);

		int pageContain = 9;
		int first = (index) * pageContain;
		List<Album> albumListWant = new ArrayList<Album>();
		for (int i = first; i < pageContain + first && i < albums.size(); i++) {
			albumListWant.add(albums.get(i));
		}
		return albumListWant;
	}

	public static Boolean setAlbumWithSetterIdNThemeNDescription(
			Integer setterId, String theme, String description) {
		Date setDate = new Date();
		Album albums = new Album(getUserWithUserId(setterId), setDate, theme,
				description);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();

		try {
			session.save(albums);
			tx.commit();
		} catch (Exception e) {
			System.err.println("set album failed");
			tx.rollback();
			session.close();
			return false;
		}

		session.close();
		return true;
	}

	// TODO: change page contain and fill the function
	public static List<Album> getHotAlbumsWithIndex(int index) {

		Session session = sessionStart();
		String sql = "select album_id from (select album_id as album_id ,count(distinct user_id) as likedCount from album_liked group by album_id order by likedCount desc)as countlist";
		Query query = ((SharedSessionContract) session).createSQLQuery(sql);
		List<Integer> albumList = query.list(); // �õ���Ƭ���
		session.close();

		int pageContain = 9;
		int first = (index) * pageContain;
		List<Album> albumListWant = new ArrayList<Album>();

		albumListWant = new ArrayList<Album>();
		albumListWant.add(getAlbumWithAlbumId(1));
		albumListWant.add(getAlbumWithAlbumId(2));
		albumListWant.add(getAlbumWithAlbumId(4));
		albumListWant.add(getAlbumWithAlbumId(5));
		albumListWant.add(getAlbumWithAlbumId(1));
		albumListWant.add(getAlbumWithAlbumId(2));
		albumListWant.add(getAlbumWithAlbumId(4));
		albumListWant.add(getAlbumWithAlbumId(5));
		albumListWant.add(getAlbumWithAlbumId(2));

		return albumListWant;
	}

	public static List<AlbumIncluded> getAlbumContentsPictureIdsWithAlbumId(
			Integer AlubmId) {

		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, AlubmId);
		List<AlbumIncluded> albumContents = query.list();

		session.close();
		return albumContents;

	}

	public static Boolean addPictureToAlbumWithPictureId(Integer pictureId,
			Integer albumId) {

		AlbumIncluded albumIncluded = new AlbumIncluded(new AlbumIncludedId(
				albumId, pictureId), getAlbumWithAlbumId(albumId),
				getPictureWithPictureId(pictureId));

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		try {
			session.save(albumIncluded);
			tx.commit();
		} catch (Exception e) {
			System.err.println("add picture to album failed");
			tx.rollback();
			session.close();
			return false;
		}

		session.close();
		return true;
	}

	public static List<AlbumComment> getAlbumCommentsWithAlbumId(Integer albumId) {

		Session session = sessionStart();
		String hql = "from AlbumComment where album= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		List<AlbumComment> comments = query.list();

		session.close();
		return comments;

	}

	/**
	 * @albumlike
	 */

	public static List<AlbumLiked> getAlbumLikeUserIdsWithAlbumId(
			Integer albumId) {
		Session session = sessionStart();
		String hql = "from AlbumLiked where id.albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		List<AlbumLiked> albumLikes = query.list();

		session.close();
		return albumLikes;
	}

	public static Boolean removeAlubmLikedWithAlbumIdNUserId(Integer albumId,
			Integer userId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from AlbumLiked where id.albumId=? and id.userId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		query.setInteger(1, userId);
		AlbumLiked albumLiked = (AlbumLiked) query.uniqueResult();
		// System.out.println(GroupMemberWant.get(0).getId().getUserId());

		try {
			session.delete(albumLiked);
			tx.commit();
		} catch (Exception e) {
			System.err.println("remove album liek failed");
			tx.rollback();
			session.close();
			return false;
		}

		session.close();
		return true;
	}

	public static Boolean setAlbumLikeWithAlbumIdNUserId(Integer albumId,
			Integer userId) {

		Session session = sessionStart();
		String hql = "from AlbumLiked where id.albumId = ? and id.userId = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		query.setInteger(1, userId);
		AlbumLiked checkAlbumLiked = (AlbumLiked) query.uniqueResult();
		session.close();

		if (checkAlbumLiked == null) {
			session = sessionStart();
			AlbumLiked albumLiked = new AlbumLiked(new AlbumLikedId(albumId,
					userId), getAlbumWithAlbumId(albumId),
					getUserWithUserId(userId));
			Transaction tx = session.beginTransaction();
			try {
				session.save(albumLiked);
				tx.commit();
			} catch (Exception e) {
				System.err.println("set album like failed");
				tx.rollback();
				session.close();
				return false;
			}
			session.close();
		} else
			System.out.println("liked alerady!");
		return true;
	}

	/**
	 * @new interfaces
	 */
	public static List<AlbumIncluded> getAlbumsWithPictureId(Integer pictureId) {
		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.pictureId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<AlbumIncluded> albumIncludeds = query.list();

		session.close();
		return albumIncludeds;
	}

	// TODO: change page contain
	public static List<Picture> getMomentSharePicturesWithIndex(int index) {
		Session session = sessionStart();
		String hql = "from Picture order by postDate desc";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Picture> pictureList = query.list();

		int pageContain = 8;
		int first = (index) * pageContain;
		List<Picture> pictureListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < pictureList.size(); i++) {
			pictureListWant.add(pictureList.get(i));
		}

		session.close();
		return pictureListWant;
	}

	// TODO: change page contain
	public static List<Picture> getDiscoverPictures() {

		Session session = sessionStart();
		String hql = "from Picture order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Picture> pictureList = query.list();

		int pageContain = 8;
		List<Picture> pictureListWant = new ArrayList<Picture>();
		for (int i = 0; i < pageContain && i < pictureList.size(); i++) {
			pictureListWant.add(pictureList.get(i));
		}

		session.close();
		return pictureListWant;
	}

	public static List<Group> getRandomGroup(int pageContain) {
		Session session = sessionStart();
		String hql = "from Group order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Group> groupList = query.list();

		List<Group> groupListWant = new ArrayList<Group>();
		for (int i = 0; i < pageContain && i < groupList.size(); i++) {
			groupListWant.add(groupList.get(i));
		}

		session.close();
		return groupListWant;

	}

	// TODO: change page contain
	public static List<Album> getRandomAlbum() {
		Session session = sessionStart();
		String hql = "from Album order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Album> AlbumList = query.list();

		int pageContain = 9;
		List<Album> AlbumListWant = new ArrayList<Album>();
		for (int i = 0; i < pageContain && i < AlbumList.size(); i++) {
			AlbumListWant.add(AlbumList.get(i));
		}

		session.close();
		return AlbumListWant;
	}

	// TODO: change page contain
	public static List<Picture> getPicturesWithLikedUserIdNIndex(
			Integer userId, Integer index) {

		Session session = sessionStart();
		String hql = "from PictureLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<PictureLiked> pictureList = query.list();
		int pageContain = 9;
		int first = (index) * pageContain;

		List<Picture> pictureListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < pictureList.size(); i++) {
			Picture tmp = pictureList.get(i).getPicture();
			pictureListWant.add(tmp);
		}

		session.close();
		return pictureListWant;

	}

	// TODO: change page contain
	public static List<Picture> getHotSharePicturesWithIndex(int index) {

		Session session = sessionStart();
		String sql = "select picture_id from (select picture_id as picture_id ,count(distinct user_id) as likedCount from picture_liked group by picture_id order by likedCount desc)as countlist";
		Query query = ((SharedSessionContract) session).createSQLQuery(sql);
		List<Integer> pictureList = query.list();
		session.close();
		int pageContain = 8;
		int first = (index) * pageContain;
		List<Picture> pictureListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < pictureList.size(); i++) {
			pictureListWant.add(getPictureWithPictureId(pictureList.get(i)));
		}
		return pictureListWant;

	}

	// TODO: change page contain
	public static List<AlbumLiked> getAlbumWithLikedUserIdNIndex(
			Integer userId, Integer index) {

		Session session = sessionStart();
		String hql = "from AlbumLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<AlbumLiked> albumList = query.list();
		session.close();
		int pageContain = 9;
		int first = (index) * pageContain;

		List<AlbumLiked> albumListWant = new ArrayList<AlbumLiked>();
		for (int i = first; i < pageContain + first && i < albumList.size(); i++) {
			albumListWant.add(albumList.get(i));
		}

		return albumListWant;

	}

	public static Boolean setAlbumCommentWithAlbumIdNUserIdNContent(
			Integer albumId, Integer userId, String comCon) {
		Date commentDate = new Date();
		AlbumComment albumComment = new AlbumComment(
				getAlbumWithAlbumId(albumId), getUserWithUserId(userId),
				commentDate, comCon);
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		System.out.println(albumComment.getContent());
		try {
			session.save(albumComment);
			tx.commit();
		} catch (Exception e) {
			System.err.println("album comment fail");
			tx.rollback();
			session.close();
			return false;
		}

		session.close();
		return true;
	}

}
