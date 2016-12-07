package com.mercury.collection;

public class Counter implements Comparable<Counter>{
	private int count;
	public Counter(){}
	public Counter(int count){
		this.count = count;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(Counter another){
		//all the positive and negative numbers are the same in this scenario
		/*if (count < another.count) return -1;
		else if (count == another.count) return 0;
		else return 1;*/
		return count - another.count;
	}
	
}
