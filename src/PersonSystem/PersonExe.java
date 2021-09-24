package PersonSystem;

import PersonSystem.ScanUtil;

public class PersonExe {

	private static PersonExe singleton = new PersonExe();
	private static Person[] PersonAry;

	public static PersonExe getInstance() {
		return singleton;
	}

	private PersonExe() {
		PersonAry = new Person[100];
		PersonAry[0] = new Person("정상수", Gender.남자, "1111-1211");
		PersonAry[1] = new Person("정수아", Gender.여자, "2222-1211");
		PersonAry[2] = new Person("홍수영", Gender.여자, "2222-1311");
		PersonAry[3] = new Student("박수진", Gender.남자, "2345-1234", "수학과");
		PersonAry[4] = new Company("김철수", Gender.남자, "2222-1212", "영업부");
	}

	public void execute() {
		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println(" 1.인적사항추가, 2. 인적사항조회 , 3. 인정사항수정, 4. 인적사항삭제, 5.종료");
			System.out.println("---------------------------------------------------");
			int menu = ScanUtil.readInt("메뉴를 선택하세요.");
			if (menu == 1) {
				System.out.println("인적사항추가");
				addPerson();
			} else if (menu == 2) {
				System.out.println("인적사항조회");
				showList();
			} else if (menu == 3) {
				System.out.println("인적사항수정");
				modify();
			} else if (menu == 4) {
				System.out.println("인적사항삭제");
				remove();
			} else if (menu == 5) {
				System.out.println("종료합니다.");
				break;
			}
		}
		System.out.println("끝!");

	}

	private void addPerson() {
		System.out.println("1.일반사람등록 2.학교사람등록 3.회사사람등록");
		int choice = ScanUtil.readInt("번호를 선택해주세요");

		String name = ScanUtil.readStr("이름을 입력해주세요");
		Gender gender = ScanUtil.readGen("성별을 입력해주세요");
		String phone = ScanUtil.readStr("전화번호를 입력해주세요.");
		Person person = null;

		if (choice == 1) {
			person = new Person(name, gender, phone);
		} else if (choice == 2) {
			String schoolName = ScanUtil.readStr("학교이름을 입력하세요");
			person = new Student(name, gender, phone, schoolName);
		} else if (choice == 3) {
			String companyName = ScanUtil.readStr("회사이름을 입력하세요");
		}

		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] == null) {
				PersonAry[i] = person;
				break;
			}
		}

	}

	private void showList() {
		String search = ScanUtil.readStr("이름을 입력하세요.");
		Gender sex = ScanUtil.readGen("성별을 입력하세요.");
		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] != null)
				if (!search.equals("")&& sex !=null) {
					if (PersonAry[i].getName().indexOf(search) != -1 && PersonAry[i].getGender().equals(sex));
					System.out.println(PersonAry[i].toString());
				} else if (!search.equals("")) {
					if (PersonAry[i].getName().indexOf(search) != -1) {
						System.out.println(PersonAry[i].toString());
					}
				} else if (sex != null) {
					if (PersonAry[i].getGender().equals(sex))
						System.out.println(PersonAry[i].toString());
				}
		}
	}

	private void modify() {
		System.out.println("[인적사항목록]");
		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] != null)
				System.out.println("[" + i + "]" + PersonAry[i].toString());
		}
		int num = ScanUtil.readInt("수정할 친구를 선택하세요.");
		String name = ScanUtil.readStr("바꿀 이름을 입력하세요.");
		if (!name.equals("")) {
			PersonAry[num].setName(name);
			Gender gender = ScanUtil.readGen("바꿀성별을 입력하세요.");
			if (gender != null) {
				PersonAry[num].setGender(gender);
			}
			String phone = ScanUtil.readStr("바꿀 번호를 입력하세요.");
			if (!phone.equals("")) {
				PersonAry[num].setPhone(phone);
			}
		} else if (PersonAry[num] instanceof Student) {
			String schoolName = ScanUtil.readStr("바꿀 학교이름을 입력하세요.");
			if (!schoolName.equals("")) {
				((Student) PersonAry[num]).setPhone(schoolName);
			}
		} else if (PersonAry[num] instanceof Company) {
			String companyName = ScanUtil.readStr("바꿀 회사이름을 입력하세요.");
			if (!companyName.equals("")) {
				((Company) PersonAry[num]).setPhone(companyName);
			}
		}

		System.out.println("수정완료.");

	}

	private void remove() {
		System.out.println("[인적사항목록]");
		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] != null)
				System.out.println("[" + i + "]" + PersonAry[i].toString());
			}
			int num = ScanUtil.readInt("삭제할 친구를 선택하세요.");

			if (PersonAry[num] != null) {
				PersonAry[num] = null;
				System.out.println("친구가 삭제되었습니다.");
			} else if (PersonAry[num] == null) {
				System.out.println("이미 삭제된 친구입니다.");
			}
		}
	}

