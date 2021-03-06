package inMemoryTest;

import java.util.ArrayList;
import java.util.List;

public class Directory1 extends Entry1{
	List<Entry1> contents;
	public Directory1(String n, Directory1 p) {
		super(n, p);
		contents = new ArrayList<Entry1>();
	}
	
	public List<Entry1> getContents() {
		return this.contents;
	}
	
	
	@Override
	public int size() {
		int size = 0;
		for (Entry1 e: contents) {
			size += e.size();
		}
		return size;
	}
	
	public int numberOfFiles() {
		int num = 0;
		for (Entry1 e: contents) {
			if (e instanceof Directory1) {
				num++;
				Directory1 d = (Directory1) e;
				num += d.numberOfFiles();
			} else if (e instanceof File1) {
				num++;
			}
		}
		return num;
	}
	
	public void deleteEntry(Entry1 e) {
		contents.remove(e);
	}
	
	public void addEntry(Entry1 e) {
		contents.add(e);
	}

}
