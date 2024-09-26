package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;


public class UserDAO {
   
   private static UserDAO instance = new UserDAO();
   //싱글톤 패턴: 다른쪽에서는 getInstance로 호출만 가능하지, 새로 만들지 못합니다.
   public static UserDAO getInstance() {
      return instance;
   }
   private UserDAO() {};
   /**
    *@param conn
    *@param id
    *@return UserVO
    *로그인관련
    * @throws SQLException 
    */
   public UserVO loginUser(Connection conn, String id) throws SQLException {
      StringBuffer query = new StringBuffer();
      query.append(" SELECT user_id");
      query.append("      , user_pw");
      query.append("      , user_nm");
      query.append(" FROM tb_user");
      query.append(" WHERE user_id = ? ");
      query.append(" AND use_yn = 'Y' ");
      PreparedStatement ps = conn.prepareStatement(query.toString());   //오류 throw 처리
      ps.setString(1, id);   //물음표에 입력받은 id 를 맵핑합니다.
      ResultSet rs = ps.executeQuery();
      UserVO vo = new UserVO();
      while(rs.next()) {
         vo.setUserId(rs.getString("user_id"));
         vo.setUserPw(rs.getString("user_pw"));
         vo.setUserNm(rs.getString("user_nm"));
      }
      if(ps != null) ps.close();
      if(rs != null) rs.close();
      return vo;
   }
   //회원가입 (INSERT)
   public int insertUser(Connection conn, UserVO vo) throws SQLException {
   StringBuffer query = new StringBuffer();
   query.append("INSERT INTO tb_user(user_id,user_pw,user_nm,use_yn,create_dt)");
   query.append(" VALUES(? ,? ,? ,'Y',SYSDATE)");
   PreparedStatement ps = conn.prepareStatement(query.toString());
   int idx =1;
   ps.setString(idx++,vo.getUserId());
   ps.setString(idx++,vo.getUserPw());
   ps.setString(idx++,vo.getUserNm());
   
   int cnt = ps.executeUpdate();
   if(ps != null) ps.close();
   return cnt;
   
   }
   //bbs 조회
   public ArrayList<BbsVO> bbsList(Connection conn) throws SQLException {
       StringBuffer query = new StringBuffer();
       query.append(" SELECT (SELECT name");
       query.append("        FROM stock");
       query.append("        WHERE code = a.code) as nm");
       query.append(" ,a.title                     as title");
       query.append(" ,a.read_count                as read_count");
       query.append(" ,TO_CHAR(a.update_dt,'YYYYMMDD HH24:MI:SS') as update_dt");
       query.append(" FROM stock_bbs a");
       query.append(" ORDER BY 1,4 DESC");

       PreparedStatement ps = conn.prepareStatement(query.toString());   //오류 throw 처리
       ResultSet rs = ps.executeQuery();
       ArrayList<BbsVO> arr = new ArrayList<BbsVO>();
       while(rs.next()) {
          BbsVO vo = new BbsVO();
          vo.setNm(rs.getString("nm"));
          vo.setTitle(rs.getString("title"));
          vo.setReadCount(rs.getString("read_count"));
          vo.setUpdateDt(rs.getString("update_dt"));
          arr.add(vo);
       }
       if(ps !=null) ps.close();
       if(rs !=null) rs.close();
       return arr;
    }
 
   

   }
   
   
   
   
