package PersonSystem;

public class Student extends Person {
	private String schoolName;
	
	Student(String name, Gender gender, String phone){
		super(name,gender,phone);
	}
	
	Student(String name, Gender gender, String phone, String schoolName){
		super(name,gender,phone);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void showInfo() {
		System.out.println("Name: " + super.getName() + " Gender: " + this.getGender() + " phone: " + this.getPhone() + " schoolName: " + this.getSchoolName());
	}

	@Override
	public String toString() {
		return "Person [name=" + this.getName() + ", gender=" + this.getGender() + ", phone=" + this.getPhone() + "]" + " schoolName=" + this.getSchoolName() + "]";
	}
	
	

}
