
package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

//<editor-fold defaultstate="collapsed" desc="Class variables">

public class FXMLDocumentController implements Initializable {
    
    private final int MAX = 99;
    private final int MIN = 1;
    
    private int getNum1;
    private int getNum2;
    private int getNum3;
    private int getNum4;
    private int getNum5;
    
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FXML items import">
    
    
    @FXML
    private Label alertText;
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Button alertButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private Label resultLabel;
//</editor-fold>
    
    @FXML
    private void handleButtonAlert(ActionEvent event) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
    }
     
    @FXML
    private void handleButtonAction( ActionEvent event) {
        
        //We are generating numbers
        getNum1 = 0;
        getNum2 = 0;
        getNum3 = 0;
        getNum4 = 0;
        getNum5 = 0;
        getNum1 = getRandomNumber();
        getNum2 = getRandomNumber();
        getNum3 = getRandomNumber();
        getNum4 = getRandomNumber();
        getNum5 = getRandomNumber();
        
        //We are setting the generated numbers to the labes
        label1.setText("" + getNum1);
        label2.setText("" + getNum2);
        label3.setText("" + getNum3);
        label4.setText("" + getNum4);
        label5.setText("" + getNum5);
        
        calculate();
    }
    
    private String calculate(){
        
        try{
            selNum1 = Integer.parseInt(input1.getText());
            selNum2 = Integer.parseInt(input2.getText());
            selNum3 = Integer.parseInt(input3.getText());
            selNum4 = Integer.parseInt(input4.getText());
            selNum5 = Integer.parseInt(input5.getText());
        
        }catch(Exception e){
            alert("Nem jó számot adtál meg!");
            return "";
        }
        
        if  (selNum1< 1 || selNum1 > 99 || selNum2 < 1 || selNum2 > 99 || selNum3< 1 || selNum3 > 99 || selNum4 < 1 || selNum4 > 99 || selNum5 < 1 || selNum5 > 99){
            alert("Minden számnak 1 és 99 között kell lennie!");
            return "";
            }
        
        
        Set<Integer> selectedNumbers = new HashSet<>();
        selectedNumbers.add(selNum1);
        selectedNumbers.add(selNum2);
        selectedNumbers.add(selNum3);
        selectedNumbers.add(selNum4);
        selectedNumbers.add(selNum5);
 
        if (selectedNumbers.size() < 5){
         alert("Egy számot csak egyszer használhatsz fel!");   
            return "";   
        }
        
        ArrayList<Integer> userNumbers = new ArrayList<>(selectedNumbers);
        
        int result = 0;
        for(int i = 0; i < userNumbers.size(); i++){
         if(userNumbers.get(i) == getNum1 || userNumbers.get(i) == getNum2 || userNumbers.get(i) == getNum3  || userNumbers.get(i) == getNum4  || userNumbers.get(i) == getNum5 ){
          result++;   
         }
           
        switch(result){
           case 0 : resultLabel.setText("Sajnos egyik sem talált!      ");
               break;
           case 1 : resultLabel.setText("   Egy találatod van!");
               break;
           case 2 : resultLabel.setText("   Két találatod van!");
               break;
           case 3 : resultLabel.setText("   Három találatod van!");
               break;
           case 4 : resultLabel.setText("   Négy találatod van!");
               break;
           case 5 : resultLabel.setText("    Telitalálat!!!");
               break;    
        }  
        
    }
        
        return "";
    }    
 private void alert(String text){
    basePane.setDisable(true);
    basePane.setOpacity(0.3); 
    alertPane.setVisible(true);
    alertText.setText(text);
        
    }
    
    private int  getRandomNumber(){
        int random = (int) (Math.random() * MAX) + MIN;
        
        if ( random == getNum1 || random == getNum2 || random == getNum3 || random == getNum4 || random == getNum5) {
            return getRandomNumber();
                }
        return random;
     }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Sziasztok, sok szerencsét!");
    }    

    
 }
