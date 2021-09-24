package PersonSystem;

public class Company extends Person {
	private String companyName;

	Company(String name, Gender gender, String phone) {
		super(name, gender, phone);
	}

	Company(String name, Gender gender, String phone, String companyName) {
		super(name, gender, phone);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void showInfo() {
		System.out.println("Name: " + super.getName() + " Gender: " + this.getGender() + " phone: " + this.getPhone()
				+ " schoolName: " + this.getCompanyName());
	}

	public String toString() {
		return "Person [name=" + this.getName() + ", gender=" + this.getGender() + ", phone=" + this.getPhone() + "]"
				+ " companyName=" + this.getCompanyName() + "]";
	}
}
