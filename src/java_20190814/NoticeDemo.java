package java_20190814;

import java.util.ArrayList;

public class NoticeDemo {
	public static void main(String[] args) {
		NoticeDao dao = NoticeDao.getInstance();
		boolean isSuccess = false;
		isSuccess = dao.insert(new NoticeDto("성영한","제목","내용",""));
		if(isSuccess) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
		
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		list = dao.select();
		for (NoticeDto n : list) {
			System.out.printf("작성자 : %s, 제목 : %s, 내용 : %s, 작성 시간 : %s\n",n.getWriter(),n.getTitle(),n.getContent(),n.getRegdate());
		}
		
		isSuccess = dao.update(new NoticeDto("성영한0","제목0","내용0",""), 22);
		if(isSuccess) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		list = new ArrayList<NoticeDto>();
		list = dao.select();
		for (NoticeDto n : list) {
			System.out.printf("작성자 : %s, 제목 : %s, 내용 : %s, 작성 시간 : %s\n",n.getWriter(),n.getTitle(),n.getContent(),n.getRegdate());
		}
		
		isSuccess = dao.delete(20);
		if(isSuccess) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		list = new ArrayList<NoticeDto>();
		list = dao.select();
		for (NoticeDto n : list) {
			System.out.printf("작성자 : %s, 제목 : %s, 내용 : %s, 작성 시간 : %s\n",n.getWriter(),n.getTitle(),n.getContent(),n.getRegdate());
		}
	}
}
