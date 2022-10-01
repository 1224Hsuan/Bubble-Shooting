package program2_108502550;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;



public class program2_108502550 extends Application {
	
	public static Stage currentStage;
	public static Scene menu;
	public static Scene lastone;
	
	//起始畫面
	@FXML
	public Button btn_input;
	@FXML
	public TextField name_text;
	@FXML
	public Text Warning_text;
	
	//rule
	int character=-1;
	@FXML
	public Button play;
	@FXML
	public Button ch_1,ch_2,ch_3,ch_4,ch_5,ch_6,ch_7;
	@FXML
	public Text Warning;
	
	
	@FXML
	public void btn_input_press() throws IOException {// 主頁按鍵
		if (name_text.getText().equals("")) {
			Warning_text.setVisible(true);
		} else {
			Parent game = FXMLLoader.load(getClass().getResource("rule.fxml"));
			Scene gameScene = new Scene(game);
			gameScene.getRoot().requestFocus();
			program2_108502550.currentStage.setScene(gameScene);
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		currentStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
		menu = new Scene(root);
		currentStage.setScene(menu);
		currentStage.show();
	}
	
	@FXML
	public void ch1_press() throws IOException{
		game.character=1;
		character=1;
	}
	@FXML
	public void ch2_press() throws IOException{
		game.character=2;
		character=2;
	}
	@FXML
	public void ch3_press() throws IOException{
		game.character=3;
		character=3;
	}
	@FXML
	public void ch4_press() throws IOException{
		game.character=4;
		character=4;
	}
	@FXML
	public void ch5_press() throws IOException{
		game.character=5;
		character=5;
	}
	@FXML
	public void ch6_press() throws IOException{
		game.character=6;
		character=6;
	}
	@FXML
	public void ch7_press() throws IOException{
		game.character=7;
		character=7;
	}
	
	@FXML
	public void button_play_pressed() throws IOException {// 遊戲規則按鍵
		if(character>0) {
			Parent game = FXMLLoader.load(getClass().getResource("game.fxml"));
			Scene gameScene = new Scene(game);
			gameScene.getRoot().requestFocus();
			program2_108502550.currentStage.setScene(gameScene);
		}
		else {
			Warning.setVisible(true);
		}
	}
	
	@FXML
	public void button_leave_press() {
		program2_108502550.currentStage.close();
	}
	
	@FXML
	public void again_no_pressed() {
		program2_108502550.currentStage.close();
	}
	
	@FXML
	public void again_yes_pressed() throws IOException{
		Parent game = FXMLLoader.load(getClass().getResource("rule.fxml"));
		Scene gameScene = new Scene(game);
		gameScene.getRoot().requestFocus();
		program2_108502550.currentStage.setScene(gameScene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
	