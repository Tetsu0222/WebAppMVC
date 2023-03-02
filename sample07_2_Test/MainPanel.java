package sample07_2_Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	//定数
	Color backgroundColor = Color.green;
	final int MAXHP = 243;
	final int DAMAGE = 43;
	
	
	//コーポネント
	JPanel hpPanel;
	JPanel mainPanel;
	JPanel buttonPanel;
	List<createPanel> list1 = new ArrayList<>();
	
	JLabel mainLabel;
	JLabel label;
	
	JButton button;

	MyProgressBar hpBar;
	
	Timer checHPcondition;
	
	List<ImageIcon> list2 = new ArrayList<>();
	
	
	//リスナー
	MyActionListener myActionListener ;
	
	
	//コンストラクタ
	MainPanel(){
		this.setLayout( new BorderLayout()  );
		this.setBackground( backgroundColor );
		
		//メインパネルに貼るパネルを生成
		//0がHP,1がmain,2がbutton
		IntStream.range( 0 ,  3 )
		.forEach( s -> list1.add( new createPanel( s ) ));
		
		list1.stream()
		.forEach( s -> s.setBackground( s.color ));
		
		hpPanel     = list1.get(0);
		mainPanel   = list1.get(1);
		buttonPanel = list1.get(2);
		
		this.add( hpPanel     , BorderLayout.NORTH  );
		this.add( mainPanel   , BorderLayout.CENTER );
		this.add( buttonPanel , BorderLayout.SOUTH  );
	}
	
	//コンストラクタが呼ばれた後、手動で呼び出す。
	public void prepareComponents() {
		
		//コンポーネントに関する命令
		//中央の画像を準備
		mainLabel = new JLabel();
		
		//インデックス0が勇者,1が爆発,2がお墓,3が蘇生
		Stream <String> stream = Stream.of( "yuusya_game.png" , "bakuhatsu4.png" , "ohaka_seiyou.png" , "pose_genki09_businessman.png" );
		stream.forEach( s -> list2.add( new ImageIcon(getClass().getClassLoader().getResource(s) ) ) );
		
		mainLabel.setIcon(list2.get(0));
		mainPanel.add(mainLabel);
		
		
		//ボタン
		button = new JButton();
		button.setText("勇者を攻撃（HPを" + DAMAGE + "減らす" );
		button.setFocusable(false);
		myActionListener = new MyActionListener();
		button.addActionListener(myActionListener);
		buttonPanel.add(button);
		
		//パネル内にプログレスバーを表示（制限時間用）
		hpBar = new MyProgressBar( "HP" , MAXHP );
		checHPcondition = new Timer( 5 , myActionListener );
		checHPcondition.start();
		hpPanel.add(hpBar);
	}
	
	private class MyActionListener implements ActionListener{
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		//ボタン用
		if( e.getSource() == button ) {
			if( mainLabel.getIcon() == list2.get(0) ) {
				hpBar.minus(DAMAGE);
				mainLabel.setIcon( list2.get(1) );
				button.setEnabled(false);
				button.setText("勇者に" + DAMAGE + "のダメージ！");
			
			}else if( mainLabel.getIcon() == list2.get(2) ) {
				hpBar.plus(MAXHP);
				mainLabel.setIcon( list2.get(3) );
				button.setEnabled(false);
				button.setText("蘇生中");
			}
		}
	
		//HPを監視
		if( e.getSource() == checHPcondition ) {
			if( hpBar.mode == MyProgressBar.Mode.max ) {
				mainLabel.setIcon( list2.get(0) );
				button.setEnabled(true);
				button.setText("勇者を攻撃(HPを" + DAMAGE + "減らす)");
				hpBar.mode = MyProgressBar.Mode.waiting;
				
			}else if( hpBar.mode == MyProgressBar.Mode.zero ) {
				mainLabel.setIcon( list2.get(2) );
				button.setEnabled(true);
				button.setText("勇者を蘇生");
				hpBar.mode = MyProgressBar.Mode.waiting;
				
			}else if( hpBar.mode == MyProgressBar.Mode.middle ) {
				mainLabel.setIcon( list2.get(0) );
				button.setEnabled(true);
				button.setText("勇者を攻撃(HPを" + DAMAGE + "減らす)");
				hpBar.mode = MyProgressBar.Mode.waiting;
			}
		}
		
	}

	}
}
