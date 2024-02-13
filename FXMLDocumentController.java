/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author fagr
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private PasswordField log_password;

    @FXML
    private TextField sig_year;

    @FXML
    private Button log_btn;

    private BorderPane signup_form;

    @FXML
    private TextField log_username;

    @FXML
    private TextField sig_fig;

    @FXML
    private TextField sig_username;


    @FXML
    private BorderPane login_form;

    @FXML
    private Button log_register;

    @FXML
    private Button sig_register;

    @FXML
    private PasswordField sig_password;

    @FXML
    private Button sig_btn;

     private AnchorPane select_form;
    @FXML
    private BorderPane sign_form;

    void cs_btn(ActionEvent event) {

    }

   
    void it_btn(ActionEvent event) {

    }

   

    void is_btn(ActionEvent event) {

    }

  

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @FXML
    public void LoginAccount() throws IOException {
        String sql = "SELECT username , password FROM admin where username=? and password=?";
        connect = Database.connect();
        try {
            Alert alert;
            if (log_username.getText().isEmpty() || log_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Rrror Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank fields");
                alert.showAndWait();
            } else {
                 prepare = connect.prepareStatement(sql);
                prepare.setString(1, log_username.getText());
                prepare.setString(2, log_password.getText());
                result = prepare.executeQuery();
               if (result.next()) {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("sucsessfully login");
                alert.showAndWait();
                
                
                
               
                log_btn.getScene().getWindow().hide();
                
                Parent root =FXMLLoader.load(getClass().getResource("selection.fxml"));
                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
                
                
              
                
                }
                else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Rrror Message");
                alert.setHeaderText(null);
                alert.setContentText("incorrect password or username");
                alert.showAndWait(); 
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
   // Register /signup
    @FXML
    public void registerAccount(){
        String sql="INSERT INTO admin (username,password,figure,year) VALUES(?,?,?,?)";
        connect =Database.connect();
        try{
             Alert alert;
            if (sig_username.getText().isEmpty() || sig_password.getText().isEmpty()||sig_fig.getText().isEmpty()||sig_year.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Rrror Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank fields");
                alert.showAndWait();
            } else{
                 prepare = connect.prepareStatement(sql);
                prepare.setString(1, sig_username.getText());
                prepare.setString(2, sig_password.getText());
                prepare.setString(3, sig_fig.getText());
                prepare.setString(4, sig_year.getText());
               prepare.executeUpdate();
                 alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("sucsessfully create Account");
                alert.showAndWait();
                login_form.setVisible(true);
                 signup_form.setVisible(false);
                 sig_username.setText("");
                 sig_password.setText("");
                 sig_fig.setText("");
                 sig_year.setText("");
            }
            
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // switch forms
    
    
    @FXML
    public void switchform(ActionEvent event){
       
         if(event.getSource()==sig_register){
             
             login_form.setVisible(true);
           sign_form.setVisible(false);
             
            
        }
         else if(event.getSource()==log_register){
            login_form.setVisible(false);
            sign_form.setVisible(true);
        }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}



