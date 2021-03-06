package inMemoryTest;

public abstract class Entry1 {
	private String name;
	private long createTime;
	private long accessTime;
	private long modifyTime;
	private Directory1 parent;

	public abstract int size();
	
	public Entry1(String n, Directory1 p) {
		this.name = n;
		this.parent = p;
		this.createTime = System.currentTimeMillis();
	}
	
	public void delete() {
		if (this.parent != null) {
			parent.deleteEntry(this);
		}
	}
	
	public String getFullPath() {
		return parent.getFullPath() + "/" + name;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public long getAccessTime() {
		return accessTime;
	}
	
	public long getModifyTime() {
		return modifyTime;
	}
	
	public String getName() {
		return name;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
}
