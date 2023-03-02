package model;

public class HelthCheckLogic {
	
	//BMIを算出して設定
	public void execute(HealthData health) {
		double weight = health.getWeight();
		double height = health.getHeight();
		double bmi    = weight/ ( height / 100.0 * height / 100.0 );
		health.setBmi(bmi);
	
	//BMI指数から体系を判定して設定
	health.setBodyType( bmi < 18.5 ? "瘦せ型" : bmi < 25 ? "普通" : "肥満" );
	
	}
}