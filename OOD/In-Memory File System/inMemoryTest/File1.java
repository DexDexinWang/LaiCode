package inMemoryTest;

public class File1 extends Entry1 {
	private String content; //or byte[]
	private int size;
	
	public File1(String n, Directory1 p, int size) {
		super(n, p);
		this.size = size;
	}

	@Override
	public int size() {
		return content.length();
	}

	public String getContents() {
		return content;
	}
	
	public void setContents(String c) {
		content = c;
	}
}
