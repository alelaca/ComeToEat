package utils;

public enum Sex {
	MAN ("M"),
	WOMAN ("W");
	
	private String sex;
	
	private Sex(String sex) {
		this.setSex(sex);
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
