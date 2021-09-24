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
		PersonAry[0] = new Person("�����", Gender.����, "1111-1211");
		PersonAry[1] = new Person("������", Gender.����, "2222-1211");
		PersonAry[2] = new Person("ȫ����", Gender.����, "2222-1311");
		PersonAry[3] = new Student("�ڼ���", Gender.����, "2345-1234", "���а�");
		PersonAry[4] = new Company("��ö��", Gender.����, "2222-1212", "������");
	}

	public void execute() {
		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println(" 1.���������߰�, 2. ����������ȸ , 3. �������׼���, 4. �������׻���, 5.����");
			System.out.println("---------------------------------------------------");
			int menu = ScanUtil.readInt("�޴��� �����ϼ���.");
			if (menu == 1) {
				System.out.println("���������߰�");
				addPerson();
			} else if (menu == 2) {
				System.out.println("����������ȸ");
				showList();
			} else if (menu == 3) {
				System.out.println("�������׼���");
				modify();
			} else if (menu == 4) {
				System.out.println("�������׻���");
				remove();
			} else if (menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			}
		}
		System.out.println("��!");

	}

	private void addPerson() {
		System.out.println("1.�Ϲݻ����� 2.�б������� 3.ȸ�������");
		int choice = ScanUtil.readInt("��ȣ�� �������ּ���");

		String name = ScanUtil.readStr("�̸��� �Է����ּ���");
		Gender gender = ScanUtil.readGen("������ �Է����ּ���");
		String phone = ScanUtil.readStr("��ȭ��ȣ�� �Է����ּ���.");
		Person person = null;

		if (choice == 1) {
			person = new Person(name, gender, phone);
		} else if (choice == 2) {
			String schoolName = ScanUtil.readStr("�б��̸��� �Է��ϼ���");
			person = new Student(name, gender, phone, schoolName);
		} else if (choice == 3) {
			String companyName = ScanUtil.readStr("ȸ���̸��� �Է��ϼ���");
		}

		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] == null) {
				PersonAry[i] = person;
				break;
			}
		}

	}

	private void showList() {
		String search = ScanUtil.readStr("�̸��� �Է��ϼ���.");
		Gender sex = ScanUtil.readGen("������ �Է��ϼ���.");
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
		System.out.println("[�������׸��]");
		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] != null)
				System.out.println("[" + i + "]" + PersonAry[i].toString());
		}
		int num = ScanUtil.readInt("������ ģ���� �����ϼ���.");
		String name = ScanUtil.readStr("�ٲ� �̸��� �Է��ϼ���.");
		if (!name.equals("")) {
			PersonAry[num].setName(name);
			Gender gender = ScanUtil.readGen("�ٲܼ����� �Է��ϼ���.");
			if (gender != null) {
				PersonAry[num].setGender(gender);
			}
			String phone = ScanUtil.readStr("�ٲ� ��ȣ�� �Է��ϼ���.");
			if (!phone.equals("")) {
				PersonAry[num].setPhone(phone);
			}
		} else if (PersonAry[num] instanceof Student) {
			String schoolName = ScanUtil.readStr("�ٲ� �б��̸��� �Է��ϼ���.");
			if (!schoolName.equals("")) {
				((Student) PersonAry[num]).setPhone(schoolName);
			}
		} else if (PersonAry[num] instanceof Company) {
			String companyName = ScanUtil.readStr("�ٲ� ȸ���̸��� �Է��ϼ���.");
			if (!companyName.equals("")) {
				((Company) PersonAry[num]).setPhone(companyName);
			}
		}

		System.out.println("�����Ϸ�.");

	}

	private void remove() {
		System.out.println("[�������׸��]");
		for (int i = 0; i < PersonAry.length; i++) {
			if (PersonAry[i] != null)
				System.out.println("[" + i + "]" + PersonAry[i].toString());
			}
			int num = ScanUtil.readInt("������ ģ���� �����ϼ���.");

			if (PersonAry[num] != null) {
				PersonAry[num] = null;
				System.out.println("ģ���� �����Ǿ����ϴ�.");
			} else if (PersonAry[num] == null) {
				System.out.println("�̹� ������ ģ���Դϴ�.");
			}
		}
	}

