package dbMatter;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.apache.catalina.authenticator.SavedRequest;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mysql.fabric.xmlrpc.base.Member;

import imangine.AlbumIncluded;
import imangine.AlbumIncludedId;
import imangine.AlbumLiked;
import imangine.AlbumLikedId;
import imangine.Albums;
import imangine.Friends;
import imangine.GroupComment;
import imangine.GroupMem;
import imangine.GroupMemId;
import imangine.Groups;
import imangine.PicComment;
import imangine.PicLiked;
import imangine.PicLikedId;
import imangine.PicTag;
import imangine.PicTagId;
import imangine.Pictures;
import imangine.Users;

public class DBQuerrier {
	static SessionFactory sessionFactory;
	static Configuration configuration;

	private static Session sessionStart() {
		if (sessionFactory == null) {
			configuration = new Configuration().configure();
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration
					.buildSessionFactory(standardServiceRegistry);
		}
		return sessionFactory.openSession();
	}

	public static void main(String[] args) {
		// login("zsr", "12345");
		// getPicWithPicId(2);
		// getPicTagsWithPicId(3);
		// getPicLikeUserIdsWithPicId(2);
		// getPicsWithPosterIdNIndex(2,1);
		// getPicIdsWithTagNIndex("ô",0);
		// getPicCommentsWithPicId(2);
		// getGroupMemberWithGroupId(1);
		// getGroupsWithUserId(1);
		// getGroupWithGroupId(2);
		// getGroupsWithSetterId(1);
		// getGroupMembersWithGroupId(1);
		// getGroupCommentsWithGroupId(1);
		// getFriendsWithUserId(1);
		// getAlbumWithAlbumId(2);
		// getAlbumsWithSetterId(1);
		// getAlbumContentsPicIdsWithAlbumId(1);
		// List<AlbumIncluded> a=getAlbumsWithPicId(25);
		// System.out.println(a.size());
		// getAlbumLikeUserIdsWithAlbumId(1);
		// register("����","wzysddg");
//		setPicLikeWithPicIdNUserId(67,20);
		// getUserwithuserId(2);
		// updateUserInfo(2,
		// "������","C:��Ƭ������",null,"shanghai","male","��TM�����Ұ�������","1999-05-18");
		// changePasswordWithUserIdNOldPasswordNNewPassword(2,"456","456789");

		// setPicWithAddressNTitleNTagsNposterId("���22ͼƬ����","��22Ůͼ","��2Ů,Ұ2��,��2��",2);

		// setPicLikeWithPicIdNUserId(20,6);
		// setPicCommentWithPicIdNUserIdNContent(1, 2, "�Բ���ţ���ˣ�");
		// setGroupWithNameNSetterIdNTheme("FFF��", 1, "����������");
		// joinGroupWithUserIdNGroupId(13, 4);
		// setGroupCommentWithGroupIdNUserIdNContent(4, 2, "�ðײ˶������ˣ�");
		// setAlbumWithSetterIdNThemeNDescr(13, "��Ϸ", "��Ҷ��������ʹ֮��");
		// addPicToAlbumWithPicId(20, 4);
		 setAlbumLikeWithAlbumIdNUserId(4, 14);
		// quitGroupWithUserIdNGroupId(13, 4);
		// setPicWithAddressNTitleNTagsNDescriptionNposterId("dd111`",
		// "das222d",
		// "dds333d", "44444", 15);
		// System.out.println(getPicIdsWithLikedUserIdNIndex(14, 1).size());
		// System.out.println(getPicIdsWithLikedUserIdNIndex(14, 2).size());
	}

	/**
	 * @user
	 */
	// public static Users login1(String userName,String passWord){
	// Session session=sessionStart();
	// String hql = "from Users where userName=? and password=? ";
	// Query query = ((SharedSessionContract) session).createQuery(hql);
	// query.setString(0, userName);
	// query.setString(1, passWord);
	// List<Users> users = query.list();
	// if(users.size()==0)
	// return null;
	// // System.out.println(users.get(0).getEmail());
	// return users.get(0);
	// }

	public static Users login(String email, String passWord) {
		Session session = sessionStart();
		String hql = "from Users where email=? and password=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, email);
		query.setString(1, passWord);
		List<Users> users = query.list();
		if (users.size() == 0)
			return null;
		// System.out.println(users.get(0).getEmail());
		return users.get(0);
	}

	public static Users getUserwithuserId(Integer userId) {
		Session session = sessionStart();
		String hql = "from Users where userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<Users> users = query.list();
		if (users.size() == 0)
			return null;
		// System.out.println(users.get(0).getEmail());
		return users.get(0);

	}

	public static Users register(String email, String password) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Users users = new Users(email, password);
		System.out.println(users.getPassword());
		try {
			session.save(users);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("�����ѱ�ʹ��");
			return null;
		}
		tx.commit();
		session.close();

		return users; // return users instance with empty password,register and
						// auto-login
	}

	public static Users updateUserInfo(Integer userId, String userName,
			String doll, String email, String city, String gender,
			String discription, String birthday) {
		// �����Ƿ�Ϊ���ж�
		Users user = getUserwithuserId(userId);
		if (userName == null) {
			userName = user.getUserName();
		}
		if (doll == null) {
			doll = user.getDoll();
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
		if (discription == null) {
			discription = user.getDiscription();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // �������ڸ�ʽString
																	// to Date
		Date userBirthday = new Date();
		// System.out.println(birthday);
		try {
			userBirthday = sdf.parse(birthday);
			// System.out.println(userBirthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "update Users user set user.userName=? ,user.doll=? , user.email=? , user.city=? , user.gender=? ,user.birthday=? ,user.discription=? where user.userId=?";
		Query queryupdate = ((SharedSessionContract) session).createQuery(hql);
		queryupdate.setString(0, userName);
		queryupdate.setString(1, doll);
		queryupdate.setString(2, email);
		queryupdate.setString(3, city);
		queryupdate.setString(4, gender);
		queryupdate.setDate(5, userBirthday);
		queryupdate.setString(6, discription);
		queryupdate.setInteger(7, userId);
		queryupdate.executeUpdate();
		tx.commit();
		session.close();

		return null;
	}

	public static Users updateUserInfo(Integer userId, String userName,
			String password, String doll, String email, String city,
			String gender, String discription, String birthday) {
		// �����Ƿ�Ϊ���ж�
		Users user = getUserwithuserId(userId);
		if (userName == null) {
			userName = user.getUserName();
		}
		if (doll == null) {
			doll = user.getDoll();
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
		if (discription == null) {
			discription = user.getDiscription();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "update Users user set user.userName=? ,user.doll=? , user.email=? , user.city=? , user.gender=? ,user.birthday=? ,user.discription=? ,user.password=? where user.userId=?";
		Query queryupdate = ((SharedSessionContract) session).createQuery(hql);
		queryupdate.setString(0, userName);
		queryupdate.setString(1, doll);
		queryupdate.setString(2, email);
		queryupdate.setString(3, city);
		queryupdate.setString(4, gender);
		queryupdate.setDate(5, userBirthday);
		queryupdate.setString(6, discription);
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
		// System.out.println(getUserwithuserId(userId).getPassword());
		if (oldPassword.equals(getUserwithuserId(userId).getPassword())) {
			Session session = sessionStart();
			Transaction tx = session.beginTransaction();
			String hql = "update Users user set user.password=? where user.userId=?";
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
	 * @pic
	 */
	public static Pictures getPicWithPicId(Integer picId) {

		Session session = sessionStart();
		String hql = "from Pictures where picId =?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, picId);
		List<Pictures> picture = query.list();
		// System.out.println(picture.get(0).getAddress());
		return (picture.size()==0 ? null : picture.get(0));
	}

	public static List<Pictures> getPicsWithPosterIdNIndex(Integer posterId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from Pictures where users.userId=? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, posterId);
		List<Pictures> picList = query.list();
		//
		// for(Pictures pictures :picList)
		// System.out.println(pictures.getAddress());

		int pageContain = 9; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<Pictures> picListWant = new ArrayList<Pictures>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Pictures pictures :picListWant)
		// System.out.println(pictures.getAddress());
		return picListWant;

	}

	public static List<PicTag> getPicIdsWithTagNIndex(String tag, Integer index) {
		Session session = sessionStart();
		String hql = "from PicTag where id.tag= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setString(0, tag);
		List<PicTag> picList = query.list();
		System.out.println(tag);
		int pageContain = 2; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;

		List<PicTag> picListWant = new ArrayList<PicTag>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(PicTag picTag :picListWant)
		// System.out.println(picTag.getId().getPicId());
		return picListWant;
	}

	public static Integer setPicWithAddressNTitleNTagsNDescriptionNposterId(
			String address, String title, String tags, String description,
			Integer posterId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Pictures pictures = new Pictures(address, getUserwithuserId(posterId),
				title);
		pictures.setDescription(description);
		// System.out.println(pictures.getTitle());
		session.save(pictures);
		tx.commit();
		// ���ñ�ǩ
		String singleTag[] = tags.split(",");
		// System.out.println(singleTag.length);

		for (int i = 0; i < singleTag.length; i++) {

			Transaction tx1 = session.beginTransaction();
			PicTagId picTagId = new PicTagId(singleTag[i], pictures.getPicId());
			PicTag picTag = new PicTag(picTagId, pictures);
			session.save(picTag);
			// System.out.println(picTag.getId().getPicId());
			tx1.commit();
		}
		// System.out.println(pictures.getPicId());
		session.close();

		File folder = new File("F:\\files\\hahahah");
		if (folder.exists()) {
			// System.out.println("����");
		} else {
			folder.mkdirs();
			// System.out.println("makedir");
		}

		return pictures.getPicId();
	}

	public static List<PicTag> getPicTagsWithPicId(Integer picId) {
		Session session = sessionStart();
		String hql = "from PicTag where pictures = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, picId);
		List<PicTag> picTag = query.list();
		// for(PicTag ptPicTag :picTag){
		// System.out.println(ptPicTag.getId().getTag());
		// }
		return picTag;

	}

	/**
	 * @piclike
	 */

	public static Boolean removePicLikeWithPicIdNUserId(Integer picId,
			Integer userId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from PicLiked where id.picId=? and id.userId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql); // �ҵ���Ҫɾ������
		query.setInteger(0, picId);
		query.setInteger(1, userId);
		List<PicLiked> PicLiked = query.list();
		// System.out.println(GroupMemWant.get(0).getId().getUserId());

		try {
			session.delete(PicLiked.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ȡ�ش���");
			return false;
		}

		tx.commit();
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
		// System.out.println(GroupMemWant.get(0).getId().getUserId());

		try {
			session.delete(AlbumLiked.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ȡ�ش���");
			return false;
		}

		tx.commit();
		return true;
	}

	public static List<PicLiked> getPicLikeUserIdsWithPicId(Integer picId) {
		Session session = sessionStart();
		String hql = "from PicLiked where pictures = ?";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, picId);
		List<PicLiked> useridList = query.list();

		return useridList;
	}

	
public static Boolean setPicLikeWithPicIdNUserId(Integer picId,Integer userId) {
		
		Session session=sessionStart();
		String hql = "from PicLiked where id.picId = ? and id.userId = ?";                                   //�����Ƿ�������Ѵ���
        Query query = ((SharedSessionContract) session).createQuery(hql);  
        query.setInteger(0, picId);
        query.setInteger(1, userId);
        List<PicLiked> useridList = query.list();  
		if(useridList.size() == 0){
		Transaction tx1 = session.beginTransaction();
		PicLikedId picLikedId = new PicLikedId(picId, userId);
		PicLiked picLiked = new PicLiked(picLikedId, getPicWithPicId(picId));
//		System.out.println(picLiked.getId().getPicId()+"dsasadas");
		session.save(picLiked);
		tx1.commit();
		}
		else System.out.println("�ѵ����");
		return true;
	}

	/**
	 * @piccomment
	 */

	public static List<PicComment> getPicCommentsWithPicId(Integer picId) {

		Session session = sessionStart();
		String hql = "from PicComment where pictures= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, picId);
		List<PicComment> comments = query.list();
		// for(PicComment picComment :comments)
		// System.out.println(picComment.getContent());
		return comments;

	}

	public static boolean setPicCommentWithPicIdNUserIdNContent(Integer picId,
			Integer userId, String content) {
		Date commentDate = new Date();
		// System.out.println(commentDate);
		Session session = sessionStart();
		Transaction tx1 = session.beginTransaction();
		PicComment picComment = new PicComment(getPicWithPicId(picId),
				getUserwithuserId(userId), commentDate, content);
		try {
			session.save(picComment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return false;
		}

		tx1.commit();
		return true;
	}

	/**
	 * @group
	 */

	public static List<GroupMem> getGroupMemberWithGroupId(Integer groupId) {

		Session session = sessionStart();
		String hql = "from GroupMem where id.groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupMem> member = query.list();
		// System.out.println(member.get(0).getId().getUserId());
		return member;

	}

	public static List<GroupMem> getGroupsWithUserId(Integer userId) {

		Session session = sessionStart();
		String hql = "from GroupMem where id.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<GroupMem> groups = query.list();
		// System.out.println(groups.get(1).getId().getGroupId());
		return groups;

	}

	public static List<GroupMem> getGroupsWithUserIdNIndex(Integer userId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from GroupMem where id.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<GroupMem> groups = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<GroupMem> groupMemListWant = new ArrayList<GroupMem>();
		for (int i = fisrt; i < pageContain + fisrt && i < groups.size(); i++) {
			groupMemListWant.add(groups.get(i));
		}

		// System.out.println(groupMemListWant.size());

		return groupMemListWant;

	}

	public static Groups getGroupWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from Groups where groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<Groups> groups = query.list();
		// System.out.println(groups.get(0).getTheme());
		return (groups.size()==0 ? null : groups.get(0));

	}

	public static List<Groups> getGroupsWithSetterId(Integer setterId) {
		Session session = sessionStart();
		String hql = "from Groups where users.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Groups> groups = query.list();
		// System.out.println(groups.get(2).getTheme());
		return groups;
	}

	public static List<Groups> getGroupsWithSetterIdNIndex(Integer setterId,
			Integer index) {
		Session session = sessionStart();
		String hql = "from Groups where users.userId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Groups> groups = query.list();
		// System.out.println(groups.get(2).getTheme());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<Groups> groupListWant = new ArrayList<Groups>();
		for (int i = fisrt; i < pageContain + fisrt && i < groups.size(); i++) {
			groupListWant.add(groups.get(i));
		}
		// for(Groups Groups :groupListWant)
		// System.out.println(Groups.getSetDate());
		return groupListWant;

	}

	public static Groups setGroupWithNameNSetterIdNTheme(String groupName,
			Integer setterId, String theme) {
		Date setDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Groups groups = new Groups(getUserwithuserId(setterId), groupName,
				setDate, theme);
		try {
			session.save(groups);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return null;
		}

		tx.commit();
		return groups;

	}

	public static boolean joinGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		GroupMemId groupMemId = new GroupMemId(groupId, userId);
		GroupMem groupMem = new GroupMem(groupMemId,
				getGroupWithGroupId(groupId), getUserwithuserId(userId));
		try {
			session.save(groupMem);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		return true;
	}

	public static boolean quitGroupWithUserIdNGroupId(Integer userId,
			Integer groupId) {

		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		String hql = "from GroupMem where id.userId=? and id.groupId=?";
		Query query = ((SharedSessionContract) session).createQuery(hql); // �ҵ���Ҫɾ������
		query.setInteger(0, userId);
		query.setInteger(1, groupId);
		List<GroupMem> GroupMemWant = query.list();
		// System.out.println(GroupMemWant.get(0).getId().getUserId());

		try {
			session.delete(GroupMemWant.get(0));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�˳�ʧ��");
			return false;
		}

		tx.commit();
		return true;
	}

	public static List<GroupMem> getGroupMembersWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from GroupMem where id.groupId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupMem> groups = query.list();
		// for(GroupMem Member:groups)
		// System.out.println(Member.getUsers().getUserId());
		return groups;
	}

	/**
	 * @group_comment
	 */

	public static List<GroupComment> getGroupCommentsWithGroupId(Integer groupId) {
		Session session = sessionStart();
		String hql = "from GroupComment where groups= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, groupId);
		List<GroupComment> groupComments = query.list();
		// for(GroupComment comments:groupComments)
		// System.out.println(comments.getContent());
		return groupComments;
	}

	public static boolean setGroupCommentWithGroupIdNUserIdNContent(
			Integer groupId, Integer userId, String content) {

		Date commentDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		GroupComment GroupComment = new GroupComment(
				getGroupWithGroupId(groupId), getUserwithuserId(userId),
				commentDate, content);
		try {
			session.save(GroupComment);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		return true;
	}

	/**
	 * @friends
	 */

	public static List<Friends> getFriendsWithUserId(Integer userId) {
		Session session = sessionStart();
		String hql = "from Friends where usersByMyId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<Friends> Friends = query.list();
		// for(Friends guys:Friends)
		// System.out.println(guys.getId().getFriendId());
		return Friends;

	}

	/**
	 * @albums
	 */
	public static Albums getAlbumWithAlbumId(Integer albumId) {
		Session session = sessionStart();
		String hql = "from Albums where albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, albumId);
		List<Albums> Album = query.list();
		// System.out.println(Album.get(0).getTheme());
		return (Album.size()==0 ? null : Album.get(0));
	}

	public static List<Albums> getAlbumsWithSetterId(Integer setterId) {

		Session session = sessionStart();
		String hql = "from Albums where users= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Albums> Albums = query.list();
		// for(Albums Albummm:Albums)
		// System.out.println(Albummm.getTheme());
		return Albums;

	}

	public static List<Albums> getAlbumsWithSetterIdNIndex(Integer setterId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from Albums where users= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, setterId);
		List<Albums> albums = query.list();
		// for(Albums Albummm:Albums)
		// System.out.println(Albummm.getTheme());
		int pageContain = 9; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<Albums> albumListWant = new ArrayList<Albums>();
		for (int i = fisrt; i < pageContain + fisrt && i < albums.size(); i++) {
			albumListWant.add(albums.get(i));
		}

		return albumListWant;

	}

	public static Boolean setAlbumWithSetterIdNThemeNDescr(Integer setterId,
			String theme, String description) {
		Date setDate = new Date();
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		Albums albums = new Albums(getUserwithuserId(setterId), setDate, theme,
				description);
		try {
			session.save(albums);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("����ʧ��");
			return false;
		}

		tx.commit();
		return true;
	}

	public static List<AlbumIncluded> getAlbumContentsPicIdsWithAlbumId(
			Integer AlubmId) {

		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.albumId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, AlubmId);
		List<AlbumIncluded> pictures = query.list();
		// for(AlbumIncluded picture: pictures)
		// System.out.println(picture.getId().getPicId());
		return pictures;

	}

	public static Boolean addPicToAlbumWithPicId(Integer picId, Integer albumId) {
		Session session = sessionStart();
		Transaction tx = session.beginTransaction();
		AlbumIncludedId albumIncludedId = new AlbumIncludedId(albumId, picId);
		AlbumIncluded albumIncluded = new AlbumIncluded(albumIncludedId,
				getAlbumWithAlbumId(albumId), getPicWithPicId(picId));
		try {
			session.save(albumIncluded);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ʧ��");
			return false;
		}

		tx.commit();
		return true;
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
		List<AlbumLiked> users = query.list();
		// for(AlbumLiked user: users)
		// System.out.println(user.getId().getUserId());
		return users;
	}

	public static Boolean setAlbumLikeWithAlbumIdNUserId(Integer albumId,
			Integer userId) {

		
		Session session=sessionStart();
		String hql = "from AlbumLiked where id.albumId = ? and id.userId = ?";                                   //�����Ƿ�������Ѵ���
        Query query = ((SharedSessionContract) session).createQuery(hql);  
        query.setInteger(0, albumId);
        query.setInteger(1, userId);
        List<AlbumLiked> useridList = query.list();  
//        System.out.println(useridList.size());
		if(useridList.size() == 0){
		

		Transaction tx = session.beginTransaction();
		AlbumLikedId albumLikedId = new AlbumLikedId(albumId, userId);
		AlbumLiked albumLiked = new AlbumLiked(albumLikedId,
				getAlbumWithAlbumId(albumId), getUserwithuserId(userId));
		try {
			session.save(albumLiked);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ʧ��");
			return false;
		}
		tx.commit();
		}
		else System.out.println("liked alerady!");
		return true;
	}
	
//public static Boolean setPicLikeWithPicIdNUserId(Integer picId,Integer userId) {
//		
//		Session session=sessionStart();
//		String hql = "from PicLiked where id.picId = ? and id.userId = ?";                                   //�����Ƿ�������Ѵ���
//        Query query = ((SharedSessionContract) session).createQuery(hql);  
//        query.setInteger(0, picId);
//        query.setInteger(1, userId);
//        List<PicLiked> useridList = query.list();  
//		if(useridList.size() == 0){
//		Transaction tx1 = session.beginTransaction();
//		PicLikedId picLikedId = new PicLikedId(picId, userId);
//		PicLiked picLiked = new PicLiked(picLikedId, getPicWithPicId(picId));
////		System.out.println(picLiked.getId().getPicId()+"dsasadas");
//		session.save(picLiked);
//		tx1.commit();
//		}
//		else System.out.println("�ѵ����");
//		return true;
//	}

	/**
	 * @new interfaces
	 */
	public static List<AlbumIncluded> getAlbumsWithPicId(Integer picId) {
		Session session = sessionStart();
		String hql = "from AlbumIncluded where id.picId= ? ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, picId);
		List<AlbumIncluded> albumIncludeds = query.list();
		// for(AlbumLiked user: users)
		// System.out.println(user.getId().getUserId());
		return albumIncludeds;
	}

	// public static List<Pictures> getMomentSharePicsWithIndex(int index) {
	// return getHotSharePicsWithIndex(index);
	// }
	//
	// public static List<Pictures> getDiscoverPicsWithIndex() {
	// return getHotSharePicsWithIndex(1);
	// }
	//
	public static List<Pictures> getMomentSharePicsWithIndex(int index) { // ������Ƭ
		Session session = sessionStart();
		String hql = "from Pictures order by postDate desc";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Pictures> picList = query.list();
		//
		// for(Pictures pictures :picList)
		// System.out.println(pictures.getPostDate());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<Pictures> picListWant = new ArrayList<Pictures>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Pictures pictures :picListWant)
		// System.out.println(pictures.getPostDate());
		return picListWant;

	}

	public static List<Pictures> getDiscoverPics() { // �������

		Session session = sessionStart();
		String hql = "from Pictures order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Pictures> picList = query.list();
		//
		// for(Pictures pictures :picList)
		// System.out.println(pictures.getPostDate());

		int pageContain = 8; // һҳ��ʾͼƬ����
		int fisrt = 0;
		List<Pictures> picListWant = new ArrayList<Pictures>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			picListWant.add(picList.get(i));
		}
		// for(Pictures pictures :picListWant)
		// System.out.println(pictures.getAddress());
		return picListWant;
	}

	public static List<Groups> getRandomGroups() {
		Session session = sessionStart();
		String hql = "from Groups order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Groups> groupList = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		List<Groups> groupListWant = new ArrayList<Groups>();
		for (int i = 0; i < pageContain && i < groupList.size(); i++) {
			groupListWant.add(groupList.get(i));
		}
		// for(Groups Groups :groupListWant)
		// System.out.println(Groups.getSetDate());
		return groupListWant;

	}

	public static List<Albums> getRandomAlbums() {
		Session session = sessionStart();
		String hql = "from Albums order by rand() ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List<Albums> AlbumsList = query.list();

		int pageContain = 9; // һҳ��ʾͼƬ����
		List<Albums> AlbumsListWant = new ArrayList<Albums>();
		for (int i = 0; i < pageContain && i < AlbumsList.size(); i++) {
			AlbumsListWant.add(AlbumsList.get(i));
		}
		// for(Albums Albums :AlbumsListWant)
		// System.out.println(Albums.getSetDate());
		return AlbumsListWant;
	}

	public static List<Pictures> getPicsWithLikedUserIdNIndex(Integer userId,
			Integer index) {

		Session session = sessionStart();
		String hql = "from PicLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<PicLiked> picList = query.list();
		int pageContain = 9; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;

		List<Pictures> picListWant = new ArrayList<Pictures>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			Pictures tmp = picList.get(i).getPictures();
			picListWant.add(tmp);
		}
		// for(PicLiked PicLiked :picListWant)
		// System.out.println(PicLiked.getId().getPicId());
		return picListWant;

	}

	public static List<Pictures> getHotSharePicsWithIndex(int index) {

		Session session = sessionStart();
		String sql = "select pic_id from (select pic_id as pic_id ,count(distinct user_id) as likedCount from pic_liked group by pic_id order by likedCount desc)as countlist";
		Query query = ((SharedSessionContract) session).createSQLQuery(sql);
		List<Integer> picList = query.list(); // �õ���Ƭ���

		// for(Integer hotPic :picList)
		// System.out.println(hotPic);
		//

		int pageContain = 8; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;
		List<Pictures> picListWant = new ArrayList<Pictures>();
		for (int i = fisrt; i < pageContain + fisrt && i < picList.size(); i++) {
			picListWant.add(getPicWithPicId(picList.get(i))); // ͨ����ŷ�����Ƭ��
		}
		// for(Pictures pictures :picListWant)
		// System.out.println(pictures.getPostDate());
		return picListWant;

	}

	public static List<AlbumLiked> getAlbumsWithLikedUserIdNIndex(
			Integer userId, Integer index) {

		Session session = sessionStart();
		String hql = "from AlbumLiked where id.userId= ?  ";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		query.setInteger(0, userId);
		List<AlbumLiked> albumList = query.list();
		int pageContain = 9; // һҳ��ʾͼƬ����
		int fisrt = (index) * pageContain;

		List<AlbumLiked> albumListWant = new ArrayList<AlbumLiked>();
		for (int i = fisrt; i < pageContain + fisrt && i < albumList.size(); i++) {
			albumListWant.add(albumList.get(i));
		}
		// for(AlbumLiked AlbumLiked :albumListWant)
		// System.out.println(AlbumLiked.getId().getAlbumId());
		return albumListWant;

	}

}
