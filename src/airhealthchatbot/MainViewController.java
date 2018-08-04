/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airhealthchatbot;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MainViewController implements Initializable {
    
    @FXML
    public TextField userText;
    
    @FXML
    public TextArea msg;
    
    @FXML
    public Button Send;
            

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }  
  
    
     
      BotMessage Botchat = new BotMessage();
      String[][] chatBot = Botchat.chatBot;
  
    
    @FXML
    public void SendMsg(){
        
        Send.setOnAction(InputEvent  -> {
 
                //------grabing text -------
                
                String gtext = userText.getText();
                
                msg.setText("\t\t\t\t\t\t\t\t\t\t\t\t" + gtext +"\n");
                
                userText.setText("");
                gtext = gtext.trim();
                while(gtext.charAt(gtext.length()-1)== '!' ||
                        gtext.charAt(gtext.length()-1)== '?' ||
                        gtext.charAt(gtext.length()-1)== '.'){
                    gtext = gtext.substring(0,gtext.length()-1);
                }
                gtext = gtext.trim();
                byte response=0;
                //-------check for matches--------
                int j=0;
                while(response==0){
                    if(inArray(gtext.toLowerCase(),chatBot[j*2])){
                        response=2;
                        int r = (int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
                        bot(chatBot[(j*2)+1][r]);
                    }
                    j++;
                    if(j*2==chatBot.length-1 && response==0)
                    {
                        response=1;
                    }
                }
                //---default---
                if(response==1){
                    msg.appendText("");
                }
                msg.appendText("\n");
            
            
             
        });
    }
                
          
            
        
        
        private void bot(String str){
          msg.appendText("Doctor :"  +str+ "\n");
          }  
        

    private boolean inArray(String in, String[] str) {
        boolean match = false;
        for(int i=0;i<str.length;i++){
            if(str[i].equals(in)){
                match=true;
            }
            
        }
        return match;
    }
          
      
    }

