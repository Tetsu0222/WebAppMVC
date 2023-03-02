package sample07_2_Test;

public class Main {

	static MainWindow mainWindow;
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		mainWindow = new MainWindow();
		mainWindow.preparePanels();
		mainWindow.prepareComponents();
		
		
		mainWindow.setFrontScreenAndFocus(
				
				ScreenMode.MAIN
				
				);
		
		
		mainWindow.setVisible( true );
	}

}
