/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Client.Client;
import client.Request;
import static controller.OnlinePlayerController.online_mode;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//import tictactoe.controller.*;
/**
 *
 * @author aliaa
 */
public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/ChooseMode.fxml"));
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        try {
            primaryStage.setOnCloseRequest(t -> {
                if (online_mode) {
                    String type = "LogOut";
                    Request message = new Request(type);
                    message.setData("userName", Client.client.player.getUsername());
                    Client.client.sendRequest(message, Client.client);
                    System.exit(0);
                } else {
                    System.exit(1);
                }
            }
            );
        } catch (Exception e) {

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        launch(args);
    }

}
