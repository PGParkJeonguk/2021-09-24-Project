package PersonSystem;

import java.util.Scanner;

public class ScanUtil {

	static Scanner scn = new Scanner(System.in);

	public static int readInt(String msg) {
		System.out.println(msg);
		int num = scn.nextInt();
		scn.nextLine();
		return num;

	}

	public static String readStr(String msg) {
		System.out.println(msg);
		return scn.nextLine();
	}

	public static Gender readGen(String msg) {
		System.out.println(msg);
		System.out.println(" 남자 || 여자");
		String Str = scn.nextLine();
		Gender gender = null;
		if(Str.equals("남자")) {
			gender = Gender.남자;
		}else if(Str.equals("여자")) {
			gender =Gender.여자;
		}else {
			System.out.println("입력이 잘못되었습니다.");
		}
		
		// 열거형.valueof(문자열 A)
		// 이 문자열 A가 반드시 열거형 안에 있는 데이터 중 하나여야만 해요
		// 그게 아니면 올바르지 않은 데이터가 들어왓다고 오류를 발생시켜요.ㅣ
		/*
		 * int a = scn.nextInt();
		 * Gender Gend ;
		 * if(a == 0) Gend = Gender.MAN;
		 * else Gend = Gender.WOMAN;
		 * return Gend;
		 * 		 */
		return gender;
	}

}