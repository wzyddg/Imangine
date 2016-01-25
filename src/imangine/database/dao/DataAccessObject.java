package imangine.database.dao;

import imangine.database.entity.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	static Session singleSession;

	private static Session sessionStart() {
		if (sessionFactory == null) {
			configuration = new Configuration().configure();
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration
					.buildSessionFactory(standardServiceRegistry);
		}
		if(singleSession==null){
			singleSession = sessionFactory.openSession();
		}
		return singleSession;
	}

	public static void main(String[] args) {
		// login("zsr", "12345");
		// getPicWithPicId(2);
		// getPictureTagsWithPicId(3);
		// getPicLikeUserIdsWithPicId(2);
		// getPicsWithPosterIdNIndex(2,1);
		// getPicIdsWithTagNIndex("ô",0);
		// getPictureCommentsWithPicId(2);
		// getGroupMemberWithGroupId(1);
		// getGroupWithUserId(1);
		// getGroupWithGroupId(2);
		// getGroupWithSetterId(1);
		// getGroupMembersWithGroupId(1);
		// getGroupCommentsWithGroupId(1);
		// getFriendWithUserId(1);
		// getAlbumWithAlbumId(2);
		// getAlbumWithSetterId(1);
		// getAlbumContentsPicIdsWithAlbumId(1);
		// List<AlbumIncluded> a=getAlbumWithPicId(25);
		// System.out.println(a.size());
		// getAlbumLikeUserIdsWithAlbumId(1);
		// register("����","wzysddg");
		// setPicLikeWithPicIdNUserId(67,20);
		// getUserWithUserId(2);
		// updateUserInfo(2,
		// "������","C:��Ƭ������",null,"shanghai","male","��TM�����Ұ�������","1999-05-18");
		// changePasswordWithUserIdNOldPasswordNNewPassword(2,"456","456789");

		// setPicWithPathNTitleNTagsNposterId("���22ͼƬ����","��22Ůͼ","��2Ů,Ұ2��,��2��",2);

		// setPicLikeWithPicIdNUserId(20,6);
		// setPictureCommentWithPicIdNUserIdNContent(1, 2, "�Բ���ţ���ˣ�");
		// setGroupWithNameNSetterIdNTheme("FFF��", 1, "����������");
		// joinGroupWithUserIdNGroupId(13, 4);
		// setGroupCommentWithGroupIdNUserIdNContent(4, 2, "�ðײ˶������ˣ�");
		// setAlbumWithSetterIdNThemeNDescr(13, "��Ϸ", "��Ҷ��������ʹ֮��");
		// addPicToAlbumWithPicId(20, 4);
		// setAlbumLikeWithAlbumIdNUserId(4, 14);
		// Album albums = getAlbumWithAlbumId(4);
		// System.out.println(albums.getPicNum() + " "
		// + albums.getUser().getUserName());
//
//		setPictureCommentWithPicIdNUserIdNContent(36, 16, "MW 2016.1.5 1102");
//		System.out.println("over1");
		// setPictureCommentWithPicIdNUserIdNContent(36, 16, "MW 2016.1.5 10:32");
		// System.out.println("over");
		// quitGroupWithUserIdNGroupId(13, 4);
		// setPicWithPathNTitleNTagsNDescriptionNposterId("dd111`",
		// "das222d",
		// "dds333d", "44444", 15);
		// System.out.println(getPicIdsWithLikedUserIdNIndex(14, 1).size());
		// System.out.println(getPicIdsWithLikedUserIdNIndex(14, 2).size());
//		setPicLikeWithPicIdNUserId(25, 14);
//		removePicLikeWithPicIdNUserId(25,14);
		setAlbumCommentWithAlbumIdNUserIdNContent(2, 16	, "some like it hot");
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
		List<User> user = query.list();
		if (user.size() == 0)
			return null;
		////session.close();
		// System.out.println(user.get(0).getEmail());
		return user.get(0);
	}

	public static User getUserWithUserId(Integer userId) {
		Session session = sessionStart();
		String hql = "from User where userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<User> user = query.list();
		if (user.size() == 0)
			return null;
		// System.out.println(user.get(0).getEmail());
//		////session.close();
		return user.get(0);

	}

	public static User register(String email, String password) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		User user = new User(email, password);
		System.out.println(user.getPassword());
		try {
			session.save(user);
		} catch (Exception e) {
			System.out.println("register failed");
			return null;
		}
		tx.commit();
		////session.close();

		return user; // return user instance With empty password,register and
						// auto-login
	}

	public static User updateUserInfo(Integer userId, String userName,
			String avatar, String email, String city, String gender,
			String description, String birthday) {
		// �����Ƿ�Ϊ���ж�
		User user = getUserWithUserId(userId);
		if (userName == null) {
			userName = user.getUserName();
		}
		if (avatar == null) {
			avatar = user.getAvatarPath();
		}
		if (email == null) {
			email = user.getEmail();
		} // ���޸ļ�����ԭ������
		if (city == null) {
			city = user.getCity();
		}
		if (gender == null) {
			gender = user.getGender();
		}
		if (description == null) {
			description = user.getDescription();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // �������ڸ�ʽString
																	// to Date
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
		queryupdate.executeUpdate();
		tx.commit();
		////session.close();

		return null;
	}

	public static User updateUserInfo(Integer userId, String userName,
			String password, String avatar, String email, String city,
			String gender, String description, String birthday) {
		// �����Ƿ�Ϊ���ж�
		User user = getUserWithUserId(userId);
		if (userName == null) {
			userName = user.getUserName();
		}
		if (avatar == null) {
			avatar = user.getAvatarPath();
		}
		if (email == null) {
			email = user.getEmail();
		} // ���޸ļ�����ԭ������
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // �������ڸ�ʽString
																	// to Date
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
		////session.close();

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
			////session.close();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @pic
	 */
	public static Picture getPicWithPicId(Integer pictureId) {

		Session session = sessionStart();
		String hql = "from Picture where pictureId =?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<Picture> picture = query.list();
		// System.out.println(picture.get(0).getPath());
//		////session.close();
		return (picture.size() == 0 ? null : picture.get(0));
	}

	public static List<Picture> getPicsWithPosterIdNIndex(Integer posterId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from Picture where user.userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, posterId);
		List<Picture> picList = query.list();
		//
		// for(Picture picture :picList)
		// System.out.println(picture.getPath());

		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Picture> picListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Picture picture :picListWant)
		// System.out.println(picture.getPath());
		////session.close();
		return picListWant;

	}

	public static List<PictureTag> getPicIdsWithTagNIndex(String tag, Integer index) {
		Session session = sessionStart();
		String hql = "from PictureTag where id.tag= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, tag);
		List<PictureTag> picList = query.list();
		System.out.println(tag);
		int pageContain = 2; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;

		List<PictureTag> picListWant = new ArrayList<PictureTag>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(PictureTag pictureTag :picListWant)
		// System.out.println(pictureTag.getId().getPicId());
		////session.close();
		return picListWant;
	}

	public static Integer setPicWithPathNTitleNTagsNDescriptionNposterId(
			String path, String title, String tags, String description,
			Integer posterId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Picture picture = new Picture(path, getUserWithUserId(posterId),
				title);
		picture.setDescription(description);
		// System.out.println(picture.getTitle());
		session.save(picture);
		tx.commit();
		// ���ñ�ǩ
		String singleTag[] = tags.split(",");
		// System.out.println(singleTag.length);

		for (int i = 0; i < singleTag.length; i++) {

			Transaction tx1 = session.beginTransaction();
			PictureTagId pictureTagId = new PictureTagId(singleTag[i], picture.getPictureId());
			PictureTag pictureTag = new PictureTag(pictureTagId, picture);
			session.save(pictureTag);
			// System.out.println(pictureTag.getId().getPicId());
			tx1.commit();
		}
		// System.out.println(picture.getPicId());
		////session.close();

		File folder = new File("F:\\files\\hahahah");
		if (folder.exists()) {
			// System.out.println("����");
		} else {
			folder.mkdirs();
			// System.out.println("makedir");
		}

		////session.close();
		return picture.getPictureId();
	}

	public static List<PictureTag> getPictureTagsWithPicId(Integer pictureId) {
		Session session = sessionStart();
		String hql = "from PictureTag where picture = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureTag> pictureTag = query.list();
		// for(PictureTag ptPictureTag :pictureTag){
		// System.out.println(ptPictureTag.getId().getTag());
		// }
		////session.close();
		return pictureTag;

	}

	/**
	 * @piclike
	 */

	public static Boolean removePicLikeWithPicIdNUserId(Integer pictureId,
			Integer userId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from PictureLiked where id.pictureId=? and id.userId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql); // �ҵ���Ҫɾ������
		query.setInteger(0, pictureId);
		query.setInteger(1, userId);
		List<PictureLiked> PictureLiked = query.list();
		for(int i = 0;i<PictureLiked.size();i++){
			System.out.println(PictureLiked.get(i).getUser().getUserId()+"kk"+PictureLiked.get(i).getPicture().getPictureId());
		}
		// System.out.println(GroupMemberWant.get(0).getId().getUserId());

		try {
			session.delete(PictureLiked.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("remove picture Like Fail!");
			return false;
		}

		tx.commit();
		////session.close();
		return true;
	}

	public static Boolean removeAlubmLikedWithPicIdNUserId(Integer albumId,
			Integer userId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from AlbumLiked where id.albumId=? and id.userId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql); // �ҵ���Ҫɾ������
		query.setInteger(0, albumId);
		query.setInteger(1, userId);
		List<AlbumLiked> AlbumLiked = query.list();
		// System.out.println(GroupMemberWant.get(0).getId().getUserId());

		try {
			session.delete(AlbumLiked.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ȡ�ش���");
			return false;
		}

		tx.commit();
		////session.close();
		return true;
	}

	public static List<PictureLiked> getPicLikeUserIdsWithPicId(Integer pictureId) {
		Session session = sessionStart();
		String hql = "from PictureLiked where picture = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureLiked> useridList = query.list();

		////session.close();
		return useridList;
	}

	public static Boolean setPicLikeWithPicIdNUserId(Integer pictureId,
			Integer userId) {

		Session session = sessionStart();
		String hql = "from PictureLiked where id.pictureId = ? and id.userId = ?"; // �����Ƿ�������Ѵ���
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		query.setInteger(1, userId);
		List<PictureLiked> useridList = query.list();
		if (useridList.size() == 0) {
			Transaction tx1 = session.beginTransaction();
			PictureLikedId picLikedId = new PictureLikedId(pictureId, userId);
			PictureLiked picLiked = new PictureLiked(picLikedId, getPicWithPicId(pictureId));
			// System.out.println(picLiked.getId().getPicId()+"dsasadas");
			session.save(picLiked);
			tx1.commit();
		} else
			System.out.println("already like!");
		////session.close();
		return true;
	}

	/**
	 * @piccomment
	 */

	public static List<PictureComment> getPictureCommentsWithPicId(Integer pictureId) {

		Session session = sessionStart();
		String hql = "from PictureComment where picture= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<PictureComment> comments = query.list();
		// for(PictureComment pictureComment :comments)
		// System.out.println(pictureComment.getContent());
		////session.close();
		return comments;

	}

	public static boolean setPictureCommentWithPicIdNUserIdNContent(Integer picId,
			Integer userId, String content) {
		Date commentDate = new Date();
		// System.out.println(commentDate);
		Session session = sessionStart();
		Transaction tx1 = session.beginTransaction();
		PictureComment picComment = new PictureComment(getPicWithPicId(picId),
				getUserWithUserId(userId), commentDate, content);
		try {
			session.save(picComment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return false;
		}

		tx1.commit();
		System.out.println("setPicCommentWithPicIdNUserIdNContent");
		//session.close();
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
		// System.out.println(member.get(0).getId().getUserId());
		////session.close();
		return member;

	}

	public static List<GroupMember> getGroupWithUserId(Integer userId) {

		Session session = sessionStart();
		String hql = "from GroupMember where id.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<GroupMember> group = query.list();
		// System.out.println(group.get(1).getId().getGroupId());
		////session.close();
		return group;

	}

	public static List<GroupMember> getGroupWithUserIdNIndex(Integer userId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from GroupMember where id.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<GroupMember> group = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<GroupMember> groupMemberListWant = new ArrayList<GroupMember>();
		for (int i = first; i < pageContain + first && i < group.size(); i++) {
			groupMemberListWant.add(group.get(i));
		}

		// System.out.println(groupMemberListWant.size());
		////session.close();

		return groupMemberListWant;

	}

	public static Group getGroupWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from Group where groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<Group> group = query.list();
		// System.out.println(group.get(0).getTheme());
//		////session.close();
		return (group.size() == 0 ? null : group.get(0));

	}

	public static List<Group> getGroupWithSetterId(Integer setterId) {
		Session session = sessionStart();
		String hql = "from Group where user.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Group> group = query.list();
		// System.out.println(group.get(2).getTheme());
		////session.close();
		return group;
	}

	public static List<Group> getGroupWithSetterIdNIndex(Integer setterId,
			Integer index) {
		Session session = sessionStart();
		String hql = "from Group where user.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Group> group = query.list();
		// System.out.println(group.get(2).getTheme());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Group> groupListWant = new ArrayList<Group>();
		for (int i = first; i < pageContain + first && i < group.size(); i++) {
			groupListWant.add(group.get(i));
		}
		// for(Group Group :groupListWant)
		// System.out.println(Group.getSetDate());
		////session.close();
		return groupListWant;

	}

	public static Group setGroupWithNameNSetterIdNTheme(String groupName,
			Integer setterId, String theme) {
		Date setDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Group group = new Group(getUserWithUserId(setterId), groupName,
				setDate, theme);
		try {
			session.save(group);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return null;
		}

		tx.commit();
		////session.close();
		return group;

	}

	public static boolean joinGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		GroupMemberId groupMemberId = new GroupMemberId(groupId, userId);
		GroupMember groupMember = new GroupMember(groupMemberId,
				getGroupWithGroupId(groupId), getUserWithUserId(userId));
		try {
			session.save(groupMember);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		////session.close();
		return true;
	}

	public static boolean quitGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from GroupMember where id.userId=? and id.groupId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql); // �ҵ���Ҫɾ������
		query.setInteger(0, userId);
		query.setInteger(1, groupId);
		List<GroupMember> GroupMemberWant = query.list();
		// System.out.println(GroupMemberWant.get(0).getId().getUserId());

		try {
			session.delete(GroupMemberWant.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�˳�ʧ��");
			return false;
		}

		tx.commit();
		////session.close();
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
		////session.close();
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
		////session.close();
		return groupComments;
	}

	public static boolean setGroupCommentWithGroupIdNUserIdNContent(
			Integer groupId, Integer userId, String content) {

		Date commentDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		GroupComment GroupComment = new GroupComment(
				getGroupWithGroupId(groupId), getUserWithUserId(userId),
				commentDate, content);
		try {
			session.save(GroupComment);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		////session.close();
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
		////session.close();
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
		List<Album> Album = query.list();
		// Album resulAlbum = (Album) query.uniqueResult();
//		////session.close();
		return (Album.size() == 0 ? null : Album.get(0));
		// return resulAlbum;
	}

	public static List<Album> getAlbumWithSetterId(Integer setterId) {

		Session session = sessionStart();
		String hql = "from Album where user= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Album> Album = query.list();
		// for(Album Albummm:Album)
		// System.out.println(Albummm.getTheme());
		////session.close();
		return Album;

	}

	public static List<Album> getAlbumWithSetterIdNIndex(Integer setterId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from Album where user= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Album> albums = query.list();
		// for(Album Albummm:Album)
		// System.out.println(Albummm.getTheme());
		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Album> albumListWant = new ArrayList<Album>();
		for (int i = first; i < pageContain + first && i < albums.size(); i++) {
			albumListWant.add(albums.get(i));
		}

		////session.close();
		return albumListWant;

	}

	public static Boolean setAlbumWithSetterIdNThemeNDescr(Integer setterId,
			String theme, String description) {
		Date setDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Album albums = new Album(getUserWithUserId(setterId), setDate, theme,
				description);
		try {
			session.save(albums);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		////session.close();
		return true;
	}
	
	public static List<Album> getHotAlbumsWithIndex(int index) {

		Session session = sessionStart();
		String sql = "select album_id from (select album_id as album_id ,count(distinct user_id) as likedCount from album_liked group by album_id order by likedCount desc)as countlist";
		Query query = ((SharedSessionContract) session).createSQLQuery(sql);
		List<Integer> albumList = query.list(); // �õ���Ƭ���

		// for(Integer hotPic :picList)
		// System.out.println(hotPic);
		//

		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Album> albumListWant = new ArrayList<Album>();
//		for (int i = first; i < pageContain + first && i < albumList.size(); i++) {
//			System.out.println(albumList.get(i));
//			albumListWant.add(getAlbumWithAlbumId(albumList.get(i))); // ͨ����ŷ�����Ƭ��
//		}
//		
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
		// for(Picture picture :picListWant)
		// System.out.println(picture.getPostDate());
		////session.close();
		return albumListWant;
	}
	

	public static List<AlbumIncluded> getAlbumContentsPicIdsWithAlbumId(
			Integer AlubmId) {

		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, AlubmId);
		List<AlbumIncluded> picture = query.list();
		// for(AlbumIncluded picture: picture)
		// System.out.println(picture.getId().getPicId());
		////session.close();
		return picture;

	}

	public static Boolean addPicToAlbumWithPicId(Integer pictureId, Integer albumId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		AlbumIncludedId albumIncludedId = new AlbumIncludedId(albumId, pictureId);
		AlbumIncluded albumIncluded = new AlbumIncluded(albumIncludedId,
				getAlbumWithAlbumId(albumId), getPicWithPicId(pictureId));
		try {
			session.save(albumIncluded);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ʧ��");
			return false;
		}

		tx.commit();
		////session.close();
		return true;
	}
	
	public static List<AlbumComment> getAlbumCommentsWithAlbumId(Integer albumId) {

		Session session = sessionStart();
		String hql = "from AlbumComment where album= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		List<AlbumComment> comments = query.list();
		// for(PictureComment pictureComment :comments)
		// System.out.println(pictureComment.getContent());
		////session.close();
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
		List<AlbumLiked> user = query.list();
		// for(AlbumLiked user: user)
		// System.out.println(user.getId().getUserId());
		////session.close();
		return user;
	}

	public static Boolean setAlbumLikeWithAlbumIdNUserId(Integer albumId,
			Integer userId) {

		Session session = sessionStart();
		String hql = "from AlbumLiked where id.albumId = ? and id.userId = ?"; // �����Ƿ�������Ѵ���
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		query.setInteger(1, userId);
		List<AlbumLiked> useridList = query.list();
		// System.out.println(useridList.size());
		if (useridList.size() == 0) {

			Transaction tx = session.beginTransaction();
			AlbumLikedId albumLikedId = new AlbumLikedId(albumId, userId);
			AlbumLiked albumLiked = new AlbumLiked(albumLikedId,
					getAlbumWithAlbumId(albumId), getUserWithUserId(userId));
			try {
				session.save(albumLiked);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("���ʧ��");
				return false;
			}
			tx.commit();
		} else
			System.out.println("liked alerady!");
		////session.close();
		return true;
	}

	// public static Boolean setPicLikeWithPicIdNUserId(Integer pictureId,Integer
	// userId) {
	//
	// Session session=sessionStart();
	// String hql = "from PictureLiked where id.pictureId = ? and id.userId = ?";
	// //�����Ƿ�������Ѵ���
	// Query query = ((SharedSessionContract) session).createQuery(hql);
	// query.setInteger(0, pictureId);
	// query.setInteger(1, userId);
	// List<PictureLiked> useridList = query.list();
	// if(useridList.size() == 0){
	// Transaction tx1 = session.beginTransaction();
	// PictureLikedId picLikedId = new PictureLikedId(pictureId, userId);
	// PictureLiked picLiked = new PictureLiked(picLikedId, getPicWithPicId(pictureId));
	// // System.out.println(picLiked.getId().getPicId()+"dsasadas");
	// session.save(picLiked);
	// tx1.commit();
	// }
	// else System.out.println("�ѵ����");
	// return true;
	// }

	/**
	 * @new interfaces
	 */
	public static List<AlbumIncluded> getAlbumsWithPicId(Integer pictureId) {
		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.pictureId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, pictureId);
		List<AlbumIncluded> albumIncludeds = query.list();
		// for(AlbumLiked user: user)
		// System.out.println(user.getId().getUserId());
		////session.close();
		return albumIncludeds;
	}

	// public static List<Picture> getMomentSharePicsWithIndex(int index) {
//	 return getHotSharePicsWithIndex(index);
	// }
	//
	// public static List<Picture> getDiscoverPicsWithIndex() {
	// return getHotSharePicsWithIndex(1);
	// }
	//
	public static List<Picture> getMomentSharePicsWithIndex(int index) { // ������Ƭ
		Session session = sessionStart();
		String hql = "from Picture order by postDate desc";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Picture> picList = query.list();
		//
		// for(Picture picture :picList)
		// System.out.println(picture.getPostDate());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Picture> picListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Picture picture :picListWant)
		// System.out.println(picture.getPostDate());
		////session.close();
		return picListWant;

	}

	public static List<Picture> getDiscoverPics() { // �������

		Session session = sessionStart();
		String hql = "from Picture order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Picture> picList = query.list();
		//
		// for(Picture picture :picList)
		// System.out.println(picture.getPostDate());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int first = 0;
		List<Picture> picListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Picture picture :picListWant)
		// System.out.println(picture.getPath());
		////session.close();
		return picListWant;
	}

	public static List<Group> getRandomGroup() {
		Session session = sessionStart();
		String hql = "from Group order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Group> groupList = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		List<Group> groupListWant = new ArrayList<Group>();
		for (int i = 0; i < pageContain && i < groupList.size(); i++) {
			groupListWant.add(groupList.get(i));
		}
		// for(Group Group :groupListWant)
		// System.out.println(Group.getSetDate());
		////session.close();
		return groupListWant;

	}

	public static List<Album> getRandomAlbum() {
		Session session = sessionStart();
		String hql = "from Album order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Album> AlbumList = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		List<Album> AlbumListWant = new ArrayList<Album>();
		for (int i = 0; i < pageContain && i < AlbumList.size(); i++) {
			AlbumListWant.add(AlbumList.get(i));
		}
		// for(Album Album :AlbumListWant)
		// System.out.println(Album.getSetDate());
		////session.close();
		return AlbumListWant;
	}

	public static List<Picture> getPicsWithLikedUserIdNIndex(Integer userId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from PictureLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<PictureLiked> picList = query.list();
		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;

		List<Picture> picListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			Picture tmp = picList.get(i).getPicture();
			picListWant.add(tmp);
		}
		// for(PictureLiked PictureLiked :picListWant)
		// System.out.println(PictureLiked.getId().getPicId());
//		////session.close();
		return picListWant;

	}

	public static List<Picture> getHotSharePicsWithIndex(int index) {

		Session session = sessionStart();
		String sql = "select picture_id from (select picture_id as picture_id ,count(distinct user_id) as likedCount from picture_liked group by picture_id order by likedCount desc)as countlist";
		Query query = ((SharedSessionContract) session).createSQLQuery(sql);
		List<Integer> picList = query.list(); // �õ���Ƭ���

		// for(Integer hotPic :picList)
		// System.out.println(hotPic);
		//

		int pageContain = 8; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;
		List<Picture> picListWant = new ArrayList<Picture>();
		for (int i = first; i < pageContain + first && i < picList.size(); i++) {
			picListWant.add(getPicWithPicId(picList.get(i))); // ͨ����ŷ�����Ƭ��
		}
		// for(Picture picture :picListWant)
		// System.out.println(picture.getPostDate());
		////session.close();
		return picListWant;

	}

	public static List<AlbumLiked> getAlbumWithLikedUserIdNIndex(
			Integer userId, Integer index) {

		Session session = sessionStart();
		String hql = "from AlbumLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<AlbumLiked> albumList = query.list();
		int pageContain = 9; // һҳ��ʾͼƬ����
		int first = (index) * pageContain;

		List<AlbumLiked> albumListWant = new ArrayList<AlbumLiked>();
		for (int i = first; i < pageContain + first && i < albumList.size(); i++) {
			albumListWant.add(albumList.get(i));
		}
		// for(AlbumLiked AlbumLiked :albumListWant)
		// System.out.println(AlbumLiked.getId().getAlbumId());
		////session.close();
		return albumListWant;

	}

	public static Boolean setAlbumCommentWithAlbumIdNUserIdNContent(
			Integer albumId, Integer userId, String comCon) {
		// TODO Auto-generated method stub
		Date commentDate = new Date();
		// System.out.println(commentDate);
		Session session = sessionStart();
		Transaction tx1 = session.beginTransaction();
		AlbumComment albumComment = new AlbumComment(getAlbumWithAlbumId(albumId),
				getUserWithUserId(userId), commentDate, comCon);
		System.out.println(albumComment.getContent());
		try {
			session.save(albumComment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("album comment fail");
			return false;
		}

		tx1.commit();
		////session.close();
		return true;
	}

}
