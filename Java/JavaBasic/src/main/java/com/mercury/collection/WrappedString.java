package com.mercury.collection;

public class WrappedString {
	private String str;
	public WrappedString(){}
	public WrappedString(String str){
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override//java 1.5
	public int hashCode(){
		return str.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof WrappedString)) return false;
		WrappedString ws = (WrappedString) obj;
		return str.equals(ws.str);
	}
}
