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
		System.out.println(" ���� || ����");
		String Str = scn.nextLine();
		Gender gender = null;
		if(Str.equals("����")) {
			gender = Gender.����;
		}else if(Str.equals("����")) {
			gender =Gender.����;
		}else {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		}
		
		// ������.valueof(���ڿ� A)
		// �� ���ڿ� A�� �ݵ�� ������ �ȿ� �ִ� ������ �� �ϳ����߸� �ؿ�
		// �װ� �ƴϸ� �ùٸ��� ���� �����Ͱ� ���Ӵٰ� ������ �߻����ѿ�.��
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