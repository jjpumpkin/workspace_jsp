package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcMain {
    private static final String Url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private static final String DB_ID = "java";
    private static final String DB_PW ="oracle";


    public static void main(String[]args) {
    	while(true) {
    		Scanner scan = new Scanner (System.in);
    		System.out.println("핵사 정보 시스템입니다");
    		System.out.println("1.조회| 2.수정(q:종료)");
    		String msg =scan.nextLine();
    		if(msg.equals("q")) {
    			System.out.println("학사 정보 시스템 종료");
    			break;
    		}
    		int sel =Integer.parseInt(msg);
    		if(sel ==1) {
    			System.out.println("조회할 학번을 입력해주세요:");
    			int idol = Integer.parseInt(scan.nextLine());
    	// scan으로 받아온 문자열을 정수로 변환해서(인티져 파세인트) 변수 idol에 담습니다.
    			view(idol);
    			// 학생의 정보 출력
    		}else if(sel ==2) {
    			System.out.println("수정할 학번을 입력해주세요:");
    			// 이름 변경
    		}else {
    			System.out.println("다시 입력!!");
    			
    	  	
    			
    			
    			
    			
    		}
    	}
    }

    public static void  view (int num) {  //학번은 숫자이니까 int num으로 치환
    	
    	  //db와 연결
    			Connection conn= null;
    			//sql명령
    			PreparedStatement ps=null;
    			//쿼리실행 결과
    			ResultSet rs = null;
    	 try {
    		   	conn = DriverManager.getConnection(Url, DB_ID, DB_PW);
        			// 학생의 정보 출력
    		   	    // 위에 출력이돼서 함수에서 출력하면 2번출력되버려 안씀
    		   	  	StringBuffer query= new StringBuffer();
    		   	  	query.append(" SELECT 이름,전공,평점");
    		   	    query.append(" FROM 학생");
    		      	query.append(" WHERE 학번 =" +num);

    		    	System.out.println(query);
    		    	ps = conn.prepareStatement(query.toString());
    		    	rs = ps.executeQuery();  //쿼리문 실행
    		    		
    		    	while(rs.next()) {
    		    		
    		    		String name = rs.getString("이름");
    		    		String major = rs.getString("전공");
    		    		int avg = rs.getInt("평점");
    		    		System.out.println("이름:" +name+ "전공:" +major
    		    		+ "평점:" + avg);
    		    		
    		    		
    		    	}
    			} catch (SQLException e) {
    				e.printStackTrace();
    			} finally {
    				// connection 객체를 꼭 닫아야함.
    				// 안닫으면 계속 쌓여서 에러 발생
    				if(rs!=null) {try {rs.close();}catch (SQLException e){e.printStackTrace();}}
    				if(ps!=null) {try {ps.close();}catch (SQLException e){e.printStackTrace();}}
    				if(conn!=null) {try {conn.close();}catch (SQLException e){e.printStackTrace();}}
    				
    				// 닫아줘야함!
    				
    			
    				  
    			}
    
    
    
    
    
}
}














