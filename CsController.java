/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fagr
 */
public class CsController implements Initializable {

    @FXML
    
    private TableColumn<studentdatacs, Integer> idtab;

    @FXML
    private TableColumn<studentdatacs, String> nametab;

    @FXML
    private Button addbtn;

    @FXML
    private TextField course3feild;
    @FXML
    private TextField course1feild;

    @FXML
    private TextField course4feild;

    @FXML
    private TextField course5feild;

    @FXML
    private TextField course2feild;
      @FXML
    private TextField course6feild;

    @FXML
    private Button deletebtn;

    @FXML
    private AnchorPane Formcs;
      @FXML
    private TableView<studentdatacs> tablecs;

    @FXML
    private TextField namefeild;
       @FXML
    private Button gobackbtn;


    @FXML
    private TableColumn<studentdatacs, String> course5tab;

    @FXML
    private TableColumn<studentdatacs, String> course6tab;

    @FXML
    private TableColumn<studentdatacs, String> course4tab;

    @FXML
    private TableColumn<studentdatacs, String> course3tab;

    @FXML
    private TextField idfeild;

    @FXML
    private TableColumn<studentdatacs, String> course1tab;

    @FXML
    private TableColumn<studentdatacs, String> course2tab;
  
       private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    
    @FXML
    public void sett(){
        String sql="INSERT INTO studentscs(id,username,course1,coures2,course3,course4,course5,course6) VALUES(?,?,?,?,?,?,?,?)";
        connect =Database.connect();
        try{
             Alert alert;
            if (idfeild.getText().isEmpty() || namefeild.getText().isEmpty()||course1feild.getText().isEmpty()
                    ||course2feild.getText().isEmpty()||course3feild.getText().isEmpty()||course4feild.getText().isEmpty()
                    ||course5feild.getText().isEmpty()||course6feild.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Rrror Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank fields");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, idfeild.getText());
                prepare.setString(2, namefeild.getText());
                prepare.setString(3, course1feild.getText());
                prepare.setString(4, course2feild.getText());
                prepare.setString(5, course3feild.getText());
                prepare.setString(6, course4feild.getText());
                prepare.setString(7, course5feild.getText());
                prepare.setString(8, course6feild.getText());

                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("sucsessfully  add");
                alert.showAndWait();
                 studentShowData();

            }
            
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
   public ObservableList<studentdatacs> studentlistData() {
    ObservableList<studentdatacs> listData = FXCollections.observableArrayList();
    String selectData = "SELECT * FROM studentscs";
    connect = Database.connect();
    try {
        prepare = connect.prepareStatement(selectData);
        result = prepare.executeQuery(); // Retrieve the result set after executing the query
        studentdatacs sData;
        while (result.next()) {
            sData = new studentdatacs(result.getInt("id"), result.getString("username"),
                    result.getString("course1"), result.getString("coures2"),
                    result.getString("course3"), result.getString("course4"),
                    result.getString("course5"), result.getString("course6"));

            listData.add(sData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources (result, prepare, and connect) here if needed
    }
    return listData;
}

    private ObservableList<studentdatacs> studentdatacs;
    @FXML
    public void studentShowData(){
        studentdatacs =studentlistData();
        idtab.setCellValueFactory(new PropertyValueFactory<>("st_id"));
        nametab.setCellValueFactory(new PropertyValueFactory<>("st_name"));
       course1tab.setCellValueFactory(new PropertyValueFactory<>("st_course1"));
       course2tab.setCellValueFactory(new PropertyValueFactory<>("st_course2"));
        course3tab.setCellValueFactory(new PropertyValueFactory<>("st_course3"));
        course4tab.setCellValueFactory(new PropertyValueFactory<>("st_course4"));
        course5tab.setCellValueFactory(new PropertyValueFactory<>("st_course5"));
       course6tab.setCellValueFactory(new PropertyValueFactory<>("st_course6"));
       
       tablecs.setItems(studentdatacs);
        
        
    }
    
    @FXML
    public void studentselectdata(){
        studentdatacs sdata = tablecs.getSelectionModel().getSelectedItem();
        int num = tablecs.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        idfeild.setText(String.valueOf(sdata.getSt_id()));
        namefeild.setText(sdata.getSt_name());
        course1feild.setText(sdata.getSt_course1());
        course2feild.setText(sdata.getSt_course2());
        course3feild.setText(sdata.getSt_course3());
        course4feild.setText(sdata.getSt_course4());
        course5feild.setText(sdata.getSt_course5());
        course6feild.setText(sdata.getSt_course6());
       

    }
    @FXML
     public void goback() throws IOException{
          gobackbtn.getScene().getWindow().hide();
                
                Parent root =FXMLLoader.load(getClass().getResource("selection.fxml"));
                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
                
     }
    
   
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         studentShowData();
    }    
    
}
