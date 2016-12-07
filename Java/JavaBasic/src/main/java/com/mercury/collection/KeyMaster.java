package com.mercury.collection;

public class KeyMaster {
	private int key;

	public KeyMaster(){}
	public KeyMaster(int key){
		this.key = key;
	}
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public int hashCode(){
		return key;
	}
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof KeyMaster)) return false;
		KeyMaster km = (KeyMaster)obj;
		return key == km.key;
	}
	
}
