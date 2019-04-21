package com.demo.example.bean;

import com.alibaba.fastjson.JSON;

public class Client {
	public static void main(String[] args) {
		
		sendfruit();
	}
	
	public static void sendfruit(){
		DistrictNode root = new DistrictNode("根");
		root.addChilden(new DistrictNode("上海"));
		/*root.addChilden(new DistrictNode("天津"));
		DistrictNode districtNode = new DistrictNode("北京");
		districtNode.addChilden(new DistrictNode("海淀区"));
		districtNode.addChilden(new DistrictNode("西城区"));
		DistrictNode districtNode2 = new DistrictNode("朝阳区");
		districtNode2.addChilden(new DistrictNode("三里屯"));
		districtNode2.addChilden(new DistrictNode("朝阳外街"));
		
		districtNode.addChilden(districtNode2);*/
		//root.addChilden(districtNode);
		System.out.println(JSON.toJSON(root));
	}
	
}
