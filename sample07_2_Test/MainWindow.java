package sample07_2_Test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	//---フィールド---//
	ScreenMode screenMode = ScreenMode.MAIN;
	
	//---定数---//
	final int WIDTH  = 400;		//フレームの幅
	final int HEIGHT = 400;		//フレームの高さ
	
	
	//レイアウト(紙芝居のような流れ）
	CardLayout layout = new CardLayout();
	
	
	//コンポーネント
	MainPanel mainPanel;
	
	
	//コンストラクタ
	MainWindow(){
		
		//アイコンのイメージデータ
		this.setTitle( "タイトルを設定" );
		ImageIcon icon = new ImageIcon( getClass().getClassLoader().getResource( "onepiece01_luffy.png" ) );		//他人に配布用のコード
		this.setIconImage( icon.getImage() );
		
		
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );			//×ボタンで終了
		this.setResizable( false );									//画面のサイズ変更を抑制
		this.getContentPane().setBackground( Color.green );			//背景の色を設定
		this.setLayout( layout );									//紙芝居のような演出
		this.setPreferredSize( new Dimension ( WIDTH ,HEIGHT ) );	//サイズ設定
		this.pack();												//自動サイズ調整
		this.setLocationRelativeTo( null );							//起動時のスクリーンの位置を中央にする（サイズ調整後に呼び出すこと）
		
		
		
	}
	
	
	//コンストラクタが呼ばれた後、メインメソッドから最初に呼び出す。
	public void preparePanels() {
		mainPanel = new MainPanel();
		
		this.add( mainPanel , "メイン画面" );
		this.pack();
		
	}
	
	
	//preparePanels()が呼ばれた後、メインメソッドからさらに手動で呼び出す。
	public void prepareComponents() {
		
		mainPanel.prepareComponents();
		
	}
	
	
	//スクリーンモードを切り替える。
	//メインメソッドから最後に呼び出す。
	public void setFrontScreenAndFocus( ScreenMode s ) {
		
		screenMode = s ;
		
		//表示される画面の設定
		switch( screenMode ) {
		
		case MAIN :
			layout.show(this.getContentPane() , "メイン画面" );
			mainPanel.requestFocus();
			break;

		}
		
	}
	
}
