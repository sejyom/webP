package Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Member.JDBCutil;

public class ReviewDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertReview(ReviewVO vo) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("insert into tbl_review values(?, ?, ?, ?, ?);");
		
		pstmt.setString(1, vo.getReserve_id());
		pstmt.setString(2, vo.getUser_id());
		pstmt.setString(3, vo.getRoom_id());
		pstmt.setString(4, vo.getComment());
		pstmt.setInt(5, vo.getRating());
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
	}
	
	public void deleteResv(String reserve_id) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("delete from tbl_review where reserve_id='" + reserve_id + "';");
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
	}
	
	public ArrayList<ReviewVO> AllReviewList() throws SQLException {
		// 작성된 모든 리뷰 출력
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("select * from tbl_review;");
		rs = pstmt.executeQuery();
		
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			vo.setReserve_id(rs.getString("reserve_id"));
			vo.setUser_id(rs.getString("id"));
			vo.setRoom_id(rs.getString("room_id"));
			vo.setComment(rs.getString("comment"));
			vo.setRating(rs.getInt("star"));
			reviewList.add(vo);
			
		}
		JDBCutil.close(rs, pstmt, conn);
		return reviewList;
	}

	public ArrayList<ReviewVO> selectReviewList(String id) throws SQLException {
		// 특정 유저의 모든 리뷰 출력
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("select * from tbl_review where id='" + id + "';");
		System.out.println("id : " + id);
		rs = pstmt.executeQuery();
		
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();

		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			vo.setReserve_id(rs.getString("reserve_id"));
			vo.setUser_id(rs.getString("id"));
			vo.setRoom_id(rs.getString("room_id"));
			vo.setComment(rs.getString("comment"));
			vo.setRating(rs.getInt("star"));
			reviewList.add(vo);
		}
		JDBCutil.close(rs, pstmt, conn);
		return reviewList;
	}
	
	public void modifyReview(String rsv_id, String comment, int rating) throws SQLException {
		// 리뷰 수정
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("update tbl_review set comment = '" + comment + "',star = " + rating + " where reserve_id='" + rsv_id + "';");
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
	}
	
	public ArrayList<ReviewVO> filterReview(String hidden) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement("select * from tbl_review where room_id='" + hidden + "';");
		System.out.println("cond: " + hidden);
		rs = pstmt.executeQuery();
		
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		while(rs.next()) {
			ReviewVO vo = new ReviewVO();
			System.out.println(rs.getString("reserve_id"));
			System.out.println(rs.getString("room_id"));
			System.out.println(rs.getString("comment"));
			vo.setReserve_id(rs.getString("reserve_id"));
			vo.setUser_id(rs.getString("id"));
			vo.setRoom_id(rs.getString("room_id"));
			vo.setComment(rs.getString("comment"));
			vo.setRating(rs.getInt("star"));
			reviewList.add(vo);
		}
		JDBCutil.close(rs, pstmt, conn);
		return reviewList;
	}
}
