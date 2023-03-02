package model;

import java.io.Serializable;

public class HealthData implements Serializable{
	
	//フィールド
	private double height , weight , bmi;
	private String bodyType;
	
	//コンストラクタ
	public HealthData() {}

	//getterとsetter
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
}
