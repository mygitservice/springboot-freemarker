package com.demo.example.bean;

import java.util.ArrayList;
import java.util.List;

public class DistrictNode extends Node{
	private List<Node> childen = new ArrayList<>();
	
	public DistrictNode(String name){
		super(name);
	}
	
	@Override
	public List<Node> getChildren() {
		return childen;
	}
	
	public void addChilden(Node node){
		childen.add(node);
	}
	
	public void delChilden(int i){
		childen.remove(i);
	}

}
