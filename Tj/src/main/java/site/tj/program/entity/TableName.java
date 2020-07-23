package site.tj.program.entity;

public enum TableName {
	DayRecords(1),Emplyees(2),EmplyeesRecord(3),WorkPrograms(4);
	private int i;
	TableName(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
