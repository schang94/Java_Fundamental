
import java.util.*;
public class Hello{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int A,B,C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		if(A >= B) {
			if(C >= A) {
				System.out.println(A);
			} else {
				if(B >= C) {
					System.out.println(B);
				} else {
					System.out.println(C);
				}
			}
		}else {
			if(C >= B) {
				System.out.println(B);
			} else {
				if(A >= C) {
					System.out.println(A);
				} else {
					System.out.println(C);
				}
			}
		}
	}
}
