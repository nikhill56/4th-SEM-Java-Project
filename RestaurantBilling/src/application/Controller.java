package application;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

	
	@FXML
	private Label logindet;
	@FXML
	private AnchorPane pane;
	@FXML
	private TextField usernameTF;
	@FXML
	private PasswordField passPF;
	@FXML
	private Button loginButton;
	@FXML
	private Button closeButton;
	
	public void closeButtonOnAction(ActionEvent ae)
	{
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	public void loginButtonOnAction(ActionEvent e)
	{
		
		if(usernameTF.getText().isEmpty()== false && passPF.getText().isEmpty()==false)
		{
			logindet.setText("Try to login");
			validatelogin();
		}
		else {
			logindet.setText("Please enter username and password");
		}
	}
	public void validatelogin()
	{
		DatabaseConnection connectNow= new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String verifylogin ="select count(1) from useraccounts where Username = '"+ usernameTF.getText()+ "' and password = '"+ passPF.getText() + "'";
		
		try {
			Statement statement=connectDB.createStatement();
			ResultSet queryResult= statement.executeQuery(verifylogin);
			while(queryResult.next()) {
				if(queryResult.getInt(1)==1)
				{
					logindet.setText("Welcome!");
					Parent root= FXMLLoader.load(getClass().getResource("Coffee.fxml"));
					Stage window=(Stage) loginButton.getScene().getWindow();
					window.setScene(new Scene (root,600,400));
					
				}
				else
				{
					logindet.setText("Please enter a valid username and password");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
