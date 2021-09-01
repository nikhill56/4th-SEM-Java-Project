package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ItemController {
	int billno=100;
	
	private final double tcprice=1.4;
	private final double tpprice=1.3;
	private final double scprice=1.6;
	
	private final double caprice=1.8;
	private final double clprice=2.5;
	private final double cmprice=3.0;
	
	private final double cfprice=2.3;
	private final double cbprice=1.9;
	private final double ceprice=2.1;
	
	@FXML
	private CheckBox tccb;
	@FXML
	private CheckBox tpcb;
	@FXML
	private CheckBox sccb;
	@FXML
	private CheckBox cacb;
	@FXML
	private CheckBox clcb;
	@FXML
	private CheckBox cmcb;
	@FXML
	private CheckBox cfcb;
	@FXML
	private CheckBox cbcb;
	@FXML
	private CheckBox cecb;
	@FXML
	private Label sbl;
	@FXML
	private Label taxl;
	@FXML
	private Label totall;
	@FXML
	private Label sbtf;
	@FXML
	private Label taxtf;
	@FXML
	private Label totaltf;
	@FXML
	private TextField tcqty;
	@FXML
	private TextField tpqty;
	@FXML
	private TextField scqty;
	@FXML
	private TextField caqty;
	@FXML
	private TextField clqty;
	@FXML
	private TextField cmqty;
	@FXML
	private TextField cfqty;
	@FXML
	private TextField cbqty;
	@FXML
	private TextField ceqty;
	
	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;
	@FXML
	private Button calc;
	@FXML
	private Label custname;
	@FXML
	private Label custphno;
	@FXML
	private TextField custnametf;
	@FXML
	private TextField custphnotf;
	@FXML
	private Button proceed;
	
	public void proceedebutton(ActionEvent e)
	{
		DatabaseConnection connectNow= new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		
		String insertdata ="insert into custdetails values('"+billno+"','"+custnametf.getText()+"','"+custphnotf.getText()+"','"+subtotal+"','"+tax+"','"+TotalPrice+"');";
		
		Statement statement;
		try {
			statement = connectDB.createStatement();
			
			int row= statement.executeUpdate(insertdata);
			System.out.println(row+" row Affected");
		} catch (SQLException e1) {
			
			billno++;
			proceedebutton(e);
			
		}
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
		
	}
	public void closeButtonOnAction(ActionEvent ae)
	{
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	public void backButt(ActionEvent e) throws IOException
	{
			backB();
		
	}
	public void backB() throws IOException
	{
		Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));
		Stage window=(Stage) backButton.getScene().getWindow();
		window.setScene(new Scene (root,600,400));
	}
	
	public void calcbutt(ActionEvent e) throws IOException
	{
			totalCalc();
		
	}
	double subtotal=0;
	double tax=0;
	double TotalPrice=0;
	
	public void totalCalc() throws IOException
	{
		
		
		
		int tccount= Integer.parseInt(tcqty.getText());
		int tpcount= Integer.parseInt(tpqty.getText());
		int sccount= Integer.parseInt(scqty.getText());
		int cacount= Integer.parseInt(caqty.getText());
		int clcount= Integer.parseInt(clqty.getText());
		int cmcount= Integer.parseInt(cmqty.getText());
		int cfcount= Integer.parseInt(cfqty.getText());
		int cbcount= Integer.parseInt(cbqty.getText());
		int cecount= Integer.parseInt(ceqty.getText());
		
		
		
				if(tccb.isSelected())
				{
					subtotal+=tccount*tcprice;
				}
				if(tpcb.isSelected())
				{
					subtotal+=tpcount*tpprice;
				}
				if(sccb.isSelected())
				{
					subtotal+=sccount*scprice;
				}
				if(cacb.isSelected())
				{
					subtotal+=cacount*caprice;
				}
				if(clcb.isSelected())
				{
					subtotal+=clcount*clprice;
				}
				if(cmcb.isSelected())
				{
					subtotal+=cmcount*cmprice;
				}
				if(cfcb.isSelected())
				{
					subtotal+=cfcount*cfprice;
				}
				if(cbcb.isSelected())
				{
					subtotal+=cbcount*cbprice;
				}
				if(cecb.isSelected())
				{
					subtotal+=cecount*ceprice;
				}
				subtotal=Math.round(subtotal*100)/100.0;
				
				tax=subtotal*0.13;
				tax=Math.round(tax*100)/100.0;
				
				TotalPrice=subtotal+tax;
				TotalPrice=Math.round(TotalPrice*100)/100.0;
				
				String sb= Double.toString(subtotal);
				sbtf.setText(sb);
				String taxs= Double.toString(tax);
				taxtf.setText(taxs);
				String Totalprice = Double.toString(TotalPrice);
				totaltf.setText(Totalprice);
				
				
	}
	
}
