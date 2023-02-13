package tk.mybatis.simple.type;

public enum Enabled {

	disabled(0),//禁用
	enabled(1); //启用

	
	private final int value;

	private Enabled(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
