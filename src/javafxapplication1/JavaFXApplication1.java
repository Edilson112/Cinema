/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sysadmin
 */
public class JavaFXApplication1 extends Application {
    
  private double x=0;
private double y=0;  
  

    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene= new Scene(root);
        
       root.setOnMousePressed((MouseEvent event) ->{
           
           x= event.getSceneX();
           y= event.getSceneY();
       });
         
       root.setOnMouseDragged((MouseEvent event) ->{
           
           stage.setX(event.getScreenX() -x);
           stage.setY(event.getScreenY() -y);
       });
               
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
