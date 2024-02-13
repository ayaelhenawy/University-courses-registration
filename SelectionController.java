/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fagr
 */
public class SelectionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    
     @FXML
    private Button csbtn;

    @FXML
    private Button itbtn;

    @FXML
    private Button isbtn;

   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

     @FXML
    public void selectform(ActionEvent event) throws IOException{
       
         if(event.getSource()==csbtn){
             csbtn.getScene().getWindow().hide();
                
                Parent root =FXMLLoader.load(getClass().getResource("cs.fxml"));
                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            
             
            
        }
         else if(event.getSource()==itbtn){
            itbtn.getScene().getWindow().hide();
                
                Parent root =FXMLLoader.load(getClass().getResource("cs_1.fxml"));
                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
                
        }
          else if(event.getSource()==isbtn){
            isbtn.getScene().getWindow().hide();
                
                Parent root =FXMLLoader.load(getClass().getResource("cs_2.fxml"));
                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
                
        }
    }
    
}
