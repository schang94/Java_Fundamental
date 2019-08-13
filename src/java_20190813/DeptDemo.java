package java_20190813;

import java.util.ArrayList;

public class DeptDemo {
	public static void main(String[] args) {
		DeptDao dao = DeptDao.getInstance();
		
		boolean isSuccess = dao.insert(new DeptDto(50,"Develpement","강남역"));
		if(isSuccess) {
			System.out.println("부서가 추가되었습니다.");
		} else {
			System.out.println("부서 추가 실패!");
		}
		
		ArrayList<DeptDto> list1 = dao.select();
		
		for (DeptDto d : list1) {
			System.out.printf("부서 번호 : %d, 부서 이름 : %s, 부서 지역 : %s\n",d.getNo(),d.getName(),d.getLoc());
		}
		
		isSuccess = dao.update(new DeptDto(50,"개발부","서초역"));
		if(isSuccess) {
			System.out.println("부서가 수정되었습니다.");
		} else {
			System.out.println("부서 수정 실패!");
		}
		
		ArrayList<DeptDto> list2 = dao.select();
		
		for (DeptDto d : list2) {
			System.out.printf("부서 번호 : %d, 부서 이름 : %s, 부서 지역 : %s\n",d.getNo(),d.getName(),d.getLoc());
		}
		
		isSuccess = dao.delete(50);
		if(isSuccess) {
			System.out.println("부서가 삭제되었습니다.");
		} else {
			System.out.println("부서 삭제 실패!");
		}
		
		ArrayList<DeptDto> list3 = dao.select();
		
		for (DeptDto d : list3) {
			System.out.printf("부서 번호 : %d, 부서 이름 : %s, 부서 지역 : %s\n",d.getNo(),d.getName(),d.getLoc());
		}
	}
}
