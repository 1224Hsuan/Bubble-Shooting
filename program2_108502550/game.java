package program2_108502550;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class game implements EventHandler<KeyEvent>{
	
	
	
	//遊戲畫面
	//main character setting
	@FXML
	Pane mainch;
	int down=0;
	@FXML
	ImageView ch1,ch2,ch3,ch4,ch5,ch6,ch7;
	@FXML
	public Text start_remind;
	int main_index=5;
	static int character;
	
	//enemy setting
	@FXML
	Pane enemy1,enblood1;
	@FXML
	Rectangle enblood1_1,enblood1_2,enblood1_3,enblood1_inv;
	@FXML
	Pane enemy2,enblood2;
	@FXML
	Rectangle enblood2_1,enblood2_2,enblood2_3,enblood2_inv;
	@FXML
	Pane enemy3,enblood3;
	@FXML
	Rectangle enblood3_1,enblood3_2,enblood3_3,enblood3_inv;
	@FXML
	Pane enemy4,enblood4;
	@FXML
	Rectangle enblood4_1,enblood4_2,enblood4_3,enblood4_inv;
	@FXML
	Pane enemy5,enblood5;
	@FXML
	Rectangle enblood5_1,enblood5_2,enblood5_3,enblood5_inv;
	
	@FXML
	Text enblood_num1,enblood_num2,enblood_num3,enblood_num4,enblood_num5;
	int e2_xindex=5,e3_xindex=5,e4_xindex=4,e5_xindex=4;
	int e1_status=0,e2_status=0,e3_status=0,e4_status=0,e5_status=0;
	int e1_finish=0,e2_finish=0,e3_finish=0,e4_finish=0,e5_finish=0;
	
	//else setting
	@FXML
	Line boundary;
	
	//bubble setting
	@FXML
	Pane bubble;
	int bubble_yindex=7,bubble_xindex=5,bubble_status=0;
	
	//score and time setting
	@FXML
	Text Score_word,Score_num;
	int Score=0;
	@FXML
	Rectangle timeline,timeline_inv;
	@FXML
	Text time_num;
	int success=0,game_over=0;
	
	//continue
	@FXML
	Button  next_page;
	
	//遊戲開始按鍵
	@Override
	public void handle(KeyEvent e) {
		if(down==0&&e.getCode()==KeyCode.DOWN) {
			start_remind.setVisible(false);
			boundary.setVisible(true);
			down=1;
			Score_word.setVisible(true);
			Score_num.setVisible(true);
			timeline.setVisible(true);
			timeline_inv.setVisible(true);
			time_num.setVisible(true);
			if(character==1) {
				ch1.setVisible(true);
			}
			else if(character==2) {
				ch2.setVisible(true);
			}
			else if(character==3) {
				ch3.setVisible(true);
			}
			else if(character==4) {
				ch4.setVisible(true);
			}
			else if(character==5) {
				ch5.setVisible(true);
			}
			else if(character==6) {
				ch6.setVisible(true);
			}
			else if(character==7) {
				ch7.setVisible(true);
			}
			
			//enemy1移動
			class Type1 extends Thread {
			    @Override
			    public void run() {
			        enemy1.setVisible(true);
			        enblood1.setVisible(true);
			        enblood1_1.setVisible(true);
			        enblood_num1.setVisible(true);
			        enblood1_inv.setVisible(true);
			        int p1=5;
	        		int left_or_right=(int)(Math.random()*100);
	        		left_or_right%=2;
	        		for(int i=p1;;) {
	        			try {
	        				Thread.sleep(300);
	        			}catch(InterruptedException e){}
	        			if(left_or_right==1) {
	        				i++;
	        				GridPane.setColumnIndex(enemy1, i);
	        				GridPane.setColumnIndex(enblood1, i);
	        				if(i==bubble_xindex&&bubble_yindex==2) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+300;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num1.getText())-100;
								enblood_num1.setText(Integer.toString(tmp_blood));
	        					if(enblood1_2.isVisible()) {
	        						enblood1_2.setVisible(false);
		        					enblood1_3.setVisible(true);
	        					}
	        					else if(enblood1_1.isVisible()){
	        						enblood1_1.setVisible(false);
		        					enblood1_2.setVisible(true);
	        					}
	        					else {
	        						enblood1_3.setVisible(false);
	        						enemy1.setVisible(false);
	        						enblood_num1.setVisible(false);
	        						enblood1_inv.setVisible(false);
	        						e1_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==9) {
	        					left_or_right=0;
	        					continue;
	        				}
	        			}
	        			if(left_or_right==0) {
	        				i--;
	        				GridPane.setColumnIndex(enemy1, i);
	        				GridPane.setColumnIndex(enblood1, i);
	        				if(i==bubble_xindex&&bubble_yindex==2) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+300;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num1.getText())-100;
								enblood_num1.setText(Integer.toString(tmp_blood));
	        					if(enblood1_2.isVisible()) {
	        						enblood1_2.setVisible(false);
		        					enblood1_3.setVisible(true);
	        					}
	        					else if(enblood1_1.isVisible()){
	        						enblood1_1.setVisible(false);
		        					enblood1_2.setVisible(true);
	        					}
	        					else {
	        						enblood1_3.setVisible(false);
	        						enemy1.setVisible(false);
	        						enblood_num1.setVisible(false);
	        						enblood1_inv.setVisible(false);
	        						e1_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==0) {
	        					left_or_right=1;
	        					continue;
	        				}
	        			}
	        			if(e1_finish==1) {
	        				break;
	        			}
	        			if(game_over==1) {
	        				enblood1.setVisible(false);
    						enemy1.setVisible(false);
    						break;
	        			}
	        		}
			    }
			}
			
			//enemy2移動
			class Type2 extends Thread {
			    @Override
			    public void run() {
			        enemy2.setVisible(true);
			        enblood2_1.setVisible(true);
			        enblood_num2.setVisible(true);
			        enblood2_inv.setVisible(true);
			        int p1=0;
			        if(enemy4.isVisible()&&e4_xindex==5) {
			        	GridPane.setColumnIndex(enemy2, 1);
			        	GridPane.setColumnIndex(enblood2, 1);
			        	p1=1;
			        }
			        else {
			        	p1=5;
			        }
	        		int left_or_right=(int)(Math.random()*100);
	        		left_or_right%=2;
	        		for(int i=p1;;) {
	        			try {
	        				Thread.sleep(300);
	        			}catch(InterruptedException e){}
	        			if(left_or_right==1) {
	        				i++;
	        				GridPane.setColumnIndex(enemy2, i);
	        				GridPane.setColumnIndex(enblood2, i);
	        				if(i==bubble_xindex&&bubble_yindex==4) {
	        					int tmp_blood = Integer.valueOf(enblood_num2.getText())-100;
								enblood_num2.setText(Integer.toString(tmp_blood));
	        					int tmp_score = Integer.valueOf(Score_num.getText())+200;
								Score_num.setText(Integer.toString(tmp_score));
	        					if(enblood2_2.isVisible()) {
	        						enblood2_2.setVisible(false);
		        					enblood2_3.setVisible(true);
	        					}
	        					else if(enblood2_1.isVisible()){
	        						enblood2_1.setVisible(false);
		        					enblood2_2.setVisible(true);
	        					}
	        					else {
	        						enblood2_3.setVisible(false);
	        						enemy2.setVisible(false);
	        						enblood_num2.setVisible(false);
	        						enblood2_inv.setVisible(false);
	        						e2_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==9) {
	        					left_or_right=0;
	        					continue;
	        				}
	        			}
	        			if(left_or_right==0) {
	        				i--;
	        				GridPane.setColumnIndex(enemy2, i);
	        				GridPane.setColumnIndex(enblood2, i);
	        				if(i==bubble_xindex&&bubble_yindex==4) {
	        					int tmp_blood = Integer.valueOf(enblood_num2.getText())-100;
								enblood_num2.setText(Integer.toString(tmp_blood));
	        					int tmp_score = Integer.valueOf(Score_num.getText())+200;
								Score_num.setText(Integer.toString(tmp_score));
	        					if(enblood2_2.isVisible()) {
	        						enblood2_2.setVisible(false);
		        					enblood2_3.setVisible(true);
	        					}
	        					else if(enblood2_1.isVisible()){
	        						enblood2_1.setVisible(false);
		        					enblood2_2.setVisible(true);
	        					}
	        					else {
	        						enblood2_3.setVisible(false);
	        						enemy2.setVisible(false);
	        						enblood_num2.setVisible(false);
	        						enblood2_inv.setVisible(false);
	        						e2_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==0) {
	        					left_or_right=1;
	        					continue;
	        				}
	        			}
	        			if(e2_finish==1) {
	        				break;
	        			}
	        			if(game_over==1) {
	        				enblood2.setVisible(false);
    						enemy2.setVisible(false);
    						break;
	        			}
	        		}
			    }
			}
			
			//enemy3移動
			class Type3 extends Thread {
			    @Override
			    public void run() {
			        enemy3.setVisible(true);
			        enblood3_1.setVisible(true);
			        enblood_num3.setVisible(true);
			        enblood3_inv.setVisible(true);
			        int p1=0;
			        if(enemy5.isVisible()&&e5_xindex==5) {
			        	GridPane.setColumnIndex(enemy3, 1);
			        	GridPane.setColumnIndex(enblood3, 1);
			        	p1=1;
			        }
			        else {
			        	p1=5;
			        }
	        		int left_or_right=(int)(Math.random()*100);
	        		left_or_right%=2;
	        		for(int i=p1;;) {
	        			try {
				        	Thread.sleep(300);
				        }catch(InterruptedException e){}
	        			if(left_or_right==1) {
	        				i++;
	        				GridPane.setColumnIndex(enemy3, i);
	        				GridPane.setColumnIndex(enblood3, i);
	        				if(i==bubble_xindex&&bubble_yindex==6&&bubble_status==1) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+100;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num3.getText())-100;
								enblood_num3.setText(Integer.toString(tmp_blood));
	        					if(enblood3_2.isVisible()) {
	        						enblood3_2.setVisible(false);
		        					enblood3_3.setVisible(true);
	        					}
	        					else if(enblood3_1.isVisible()){
	        						enblood3_1.setVisible(false);
		        					enblood3_2.setVisible(true);
	        					}
	        					else {
	        						enblood3_3.setVisible(false);
	        						enemy3.setVisible(false);
	        						enblood_num3.setVisible(false);
	        						enblood3_inv.setVisible(false);
	        						e3_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==9) {
	        					left_or_right=0;
	        					continue;
	        				}
	        			}
	        			if(left_or_right==0) {
	        				i--;
	        				GridPane.setColumnIndex(enemy3, i);
	        				GridPane.setColumnIndex(enblood3, i);
	        				if(i==bubble_xindex&&bubble_yindex==6&&bubble_status==1) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+100;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num3.getText())-100;
								enblood_num3.setText(Integer.toString(tmp_blood));
	        					if(enblood3_2.isVisible()) {
	        						enblood3_2.setVisible(false);
		        					enblood3_3.setVisible(true);
	        					}
	        					else if(enblood3_1.isVisible()){
	        						enblood3_1.setVisible(false);
		        					enblood3_2.setVisible(true);
	        					}
	        					else {
	        						enblood3_3.setVisible(false);
	        						enemy3.setVisible(false);
	        						enblood_num3.setVisible(false);
	        						enblood3_inv.setVisible(false);
	        						e3_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==0) {
	        					left_or_right=1;
	        					continue;
	        				}
	        			}
	        			if(e3_finish==1) {
	        				break;
	        			}
	        			if(game_over==1) {
        					enemy3.setVisible(false);
        					enblood3.setVisible(false);
        					break;
        				}
	        		}
			   }
			}
			
			//enemy4移動
			class Type4 extends Thread {
			    @Override
			    public void run() {
			        enemy4.setVisible(true);
			        enblood4_1.setVisible(true);
			        enblood_num4.setVisible(true);
			        enblood4_inv.setVisible(true);
			        int p1=0;
			        if(enemy2.isVisible()&&e2_xindex==4) {
			        	GridPane.setColumnIndex(enemy4, 8);
        				GridPane.setColumnIndex(enblood4, 8);
			        	p1=8;
			        }
			        else {
			        	p1=4;
			        }
	        		int left_or_right=(int)(Math.random()*100);
	        		left_or_right%=2;
	        		for(int i=p1;;) {
	        			try {
	        				Thread.sleep(300);
	        			}catch(InterruptedException e){}
	        			if(left_or_right==1) {
	        				i++;
	        				GridPane.setColumnIndex(enemy4, i);
	        				GridPane.setColumnIndex(enblood4, i);
	        				if(i==bubble_xindex&&bubble_yindex==4) {
	        					int tmp_blood = Integer.valueOf(enblood_num4.getText())-100;
								enblood_num4.setText(Integer.toString(tmp_blood));
	        					int tmp_score = Integer.valueOf(Score_num.getText())+200;
								Score_num.setText(Integer.toString(tmp_score));
	        					if(enblood4_2.isVisible()) {
	        						enblood4_2.setVisible(false);
		        					enblood4_3.setVisible(true);
	        					}
	        					else if(enblood4_1.isVisible()){
	        						enblood4_1.setVisible(false);
		        					enblood4_2.setVisible(true);
	        					}
	        					else {
	        						enblood4_3.setVisible(false);
	        						enemy4.setVisible(false);
	        						enblood_num4.setVisible(false);
	        						enblood4_inv.setVisible(false);
	        						e4_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==9) {
	        					left_or_right=0;
	        					continue;
	        				}
	        			}
	        			if(left_or_right==0) {
	        				i--;
	        				GridPane.setColumnIndex(enemy4, i);
	        				GridPane.setColumnIndex(enblood4, i);
	        				if(i==bubble_xindex&&bubble_yindex==4) {
	        					int tmp_blood = Integer.valueOf(enblood_num4.getText())-100;
								enblood_num4.setText(Integer.toString(tmp_blood));
	        					int tmp_score = Integer.valueOf(Score_num.getText())+200;
								Score_num.setText(Integer.toString(tmp_score));
	        					if(enblood4_2.isVisible()) {
	        						enblood4_2.setVisible(false);
		        					enblood4_3.setVisible(true);
	        					}
	        					else if(enblood4_1.isVisible()){
	        						enblood4_1.setVisible(false);
		        					enblood4_2.setVisible(true);
	        					}
	        					else {
	        						enblood4_3.setVisible(false);
	        						enemy4.setVisible(false);
	        						enblood_num4.setVisible(false);
	        						enblood4_inv.setVisible(false);
	        						e4_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==0) {
	        					left_or_right=1;
	        					continue;
	        				}
	        			}
	        			if(e4_finish==1) {
	        				break;
	        			}
	        			if(game_over==1) {
	        				enblood4.setVisible(false);
    						enemy4.setVisible(false);
    						break;
	        			}
	        		}
			    }
			}
			
			//enemy5移動
			class Type5 extends Thread {
			    @Override
			    public void run() {
			        enemy5.setVisible(true);
			        enblood5_1.setVisible(true);
			        enblood_num5.setVisible(true);
			        enblood5_inv.setVisible(true);
			        int p1=0;
			        if(enemy3.isVisible()&&e3_xindex==4) {
			        	GridPane.setColumnIndex(enemy5, 8);
        				GridPane.setColumnIndex(enblood5, 8);
			        	p1=8;
			        }
			        else {
			        	p1=4;
			        }
	        		int left_or_right=(int)(Math.random()*100);
	        		left_or_right%=2;
	        		for(int i=p1;;) {
	        			try {
				        	Thread.sleep(300);
				        }catch(InterruptedException e){}
	        			if(left_or_right==1) {
	        				i++;
	        				GridPane.setColumnIndex(enemy5, i);
	        				GridPane.setColumnIndex(enblood5, i);
	        				if(i==bubble_xindex&&bubble_yindex==6&&bubble_status==1) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+100;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num5.getText())-100;
								enblood_num5.setText(Integer.toString(tmp_blood));
	        					if(enblood5_2.isVisible()) {
	        						enblood5_2.setVisible(false);
		        					enblood5_3.setVisible(true);
	        					}
	        					else if(enblood5_1.isVisible()){
	        						enblood5_1.setVisible(false);
		        					enblood5_2.setVisible(true);
	        					}
	        					else {
	        						enblood5_3.setVisible(false);
	        						enemy5.setVisible(false);
	        						enblood_num5.setVisible(false);
	        						enblood5_inv.setVisible(false);
	        						e5_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==9) {
	        					left_or_right=0;
	        					continue;
	        				}
	        			}
	        			if(left_or_right==0) {
	        				i--;
	        				GridPane.setColumnIndex(enemy5, i);
	        				GridPane.setColumnIndex(enblood5, i);
	        				if(i==bubble_xindex&&bubble_yindex==6&&bubble_status==1) {
	        					int tmp_score = Integer.valueOf(Score_num.getText())+100;
								Score_num.setText(Integer.toString(tmp_score));
								int tmp_blood = Integer.valueOf(enblood_num5.getText())-100;
								enblood_num5.setText(Integer.toString(tmp_blood));
	        					if(enblood5_2.isVisible()) {
	        						enblood5_2.setVisible(false);
		        					enblood5_3.setVisible(true);
	        					}
	        					else if(enblood5_1.isVisible()){
	        						enblood5_1.setVisible(false);
		        					enblood5_2.setVisible(true);
	        					}
	        					else {
	        						enblood5_3.setVisible(false);
	        						enemy5.setVisible(false);
	        						enblood_num5.setVisible(false);
	        						enblood5_inv.setVisible(false);
	        						e5_finish=1;
	        					}
	        					bubble_status=0;
	        					bubble.setVisible(false);
	        				}
	        				if(i==0) {
	        					left_or_right=1;
	        					continue;
	        				}
	        			}
	        			if(e5_finish==1) {
	        				break;
	        			}
	        			if(game_over==1) {
	        				enblood5.setVisible(false);
    						enemy5.setVisible(false);
    						break;
	        			}
	        		}
			   }
			}
			
			new Thread() {
	        	//call enemy to show and move
	        	public void run() {
	        		try{
	        			for(;;) {
	        				int temp=(int)(Math.random()*100);
	        				if(temp%5==1&&e1_status==0) {
	        					Thread thread1 = new Type1();
	        					thread1.start();
	        					e1_status=1;
	        				}
	        				else if(temp%5==1&&e1_status==1)
	        					temp++;
	        				if(temp%5==2&&e2_status==0) {
	        					Thread thread2 = new Type2();
	        					thread2.start();
	        					e2_status=1;
	        				}
	        				else if(temp%5==2&&e2_status==1)
	        					temp++;
	        				if(temp%5==3&&e3_status==0) {
	        					Thread thread3 = new Type3();
	        					thread3.start();
	        					e3_status=1;
	        				}
	        				else if(temp%5==3&&e3_status==1)
	        					temp++;
	        				if(temp%5==4&&e4_status==0) {
	        					Thread thread4 = new Type4();
	        					thread4.start();
	        					e4_status=1;
	        				}
	        				else if(temp%5==4&&e4_status==1)
	        					temp++;
	        				if(temp%5==0&&e5_status==0) {
	        					Thread thread5 = new Type5();
	        					thread5.start();
	        					e5_status=1;
	        				}
	        				else if(temp%5==0&&e5_status==1) {
	        					temp++;
	        					if(temp%5==1&&e1_status==0) {
		        					Thread thread1 = new Type1();
		        					thread1.start();
		        					e1_status=1;
		        				}
	        				}
	        				Thread.sleep(500);
	        				if(e1_status==1&&e2_status==1&&e3_status==1&&e4_status==1&&e5_status==1)
	        					break;
	        			}
		        		
	        		}catch(InterruptedException e){}
	        	}
	        }.start();
	        
	        new Thread(){
	        	//timeline running
	        	public void run(){
	        		try{
	        			for(int i=0;i<80;i++) {
	        				Thread.sleep(1000);
		        			double temp=timeline.getHeight()-3;
		        			timeline.setHeight(temp);
		        			int temp2 = Integer.valueOf(time_num.getText())-1;
							time_num.setText(Integer.toString(temp2));
							if(e1_finish==1&&e2_finish==1&&e3_finish==1&&e4_finish==1&&e5_finish==1) {
								success=1;
								game_over=1;
								break;
							}
	        			}
	        			if(Integer.valueOf(time_num.getText())==0)
	        				game_over=1;
	        			if(game_over==1) {
	        				bubble.setVisible(false);
	            			game_over=1;
	            			timeline.setVisible(false);
	            			timeline_inv.setVisible(false);
	            			time_num.setVisible(false);
	            			next_page.setVisible(true);
	        			}
	        		}catch(InterruptedException e){}
	        	}
	        }.start();
			
	        new Thread(){
	        	//bubble shooting
				public void run(){
					while(down==1&&game_over==0) {
						if(down==1&&bubble_status==0) {//bubble移動
							bubble_xindex=main_index;
							GridPane.setColumnIndex(bubble,bubble_xindex);
							bubble.setVisible(true);
							bubble_status=1;
							GridPane.setColumnIndex(bubble,bubble_xindex);
							for(bubble_yindex=7;bubble_yindex>0;bubble_yindex--) {
								GridPane.setRowIndex(bubble,bubble_yindex);
								try{
									Thread.sleep(60);
								}catch(InterruptedException e){}
							}
							bubble.setVisible(false);
							bubble_status=0;
						}
					}
				}
			}.start();
	        
		}

		
		//人物控制
		if(down==1&&e.getCode()==KeyCode.LEFT) {
			main_index--;
		}
		if(down==1&&e.getCode()==KeyCode.RIGHT) {
			main_index++;
		}
		walk();
	}
	
	//人物移動
	private void walk(){
		if(main_index<0){
			main_index=0;
		}
		if(main_index>9){
			main_index=9;
		}
		GridPane.setColumnIndex(mainch,main_index);
	}
	
	//next scene
	@FXML
	public void next_page_pressed() throws Exception{
		next_page.requestFocus();
		if(game_over==1) {
			if(success==1) {
				Parent game = FXMLLoader.load(getClass().getResource("successful.fxml"));
				Scene gameScene = new Scene(game);
				gameScene.getRoot().requestFocus();
				program2_108502550.currentStage.setScene(gameScene);
			}
			else if(success==0){
				Parent game = FXMLLoader.load(getClass().getResource("again.fxml"));
				Scene gameScene = new Scene(game);
				gameScene.getRoot().requestFocus();
				program2_108502550.currentStage.setScene(gameScene);
			}
		}
	}
}
