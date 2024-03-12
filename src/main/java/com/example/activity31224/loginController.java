package com.example.activity31224;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class loginController {
    public VBox homePanel;
    public TextField usernInput;
    public PasswordField passwordInput;
    public ColorPicker cpPickerTEST;
    public Button btnLogOut;
    @FXML
    private Label welcomeText;
    @FXML
    private Text actiontarget;
    @FXML
    private GridPane loginGridPane;
    String userName1 = "jellatino";
    String password1 = "1234gwapa";
    @FXML
    ColorPicker cpPicker = new ColorPicker(Color.BLUE);
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML
    protected void onSignInClick() throws IOException {
        Parent homeview = FXMLLoader.load(loginMain.class.getResource("home-view.fxml"));

        String userTestlang = usernInput.getText();
        String passwTestlang = passwordInput.getText();

        if(userTestlang.equals(userName1) && passwTestlang.equals(password1)) {
            AnchorPane p = (AnchorPane) loginGridPane.getParent();

            loginGridPane.getScene().getStylesheets().clear();
            loginGridPane.getScene().getStylesheets().add(getClass().
                    getResource("user1CSS.css").toExternalForm());
            p.getChildren().remove(loginGridPane);
            p.getChildren().add(homeview);
        }
    }

    @FXML
    protected void onSignOutClick() throws IOException {
        Parent loginView = FXMLLoader.load(loginMain.class.getResource("login-view.fxml"));

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().
                    getResource("user1CSS.css").getPath()));
            bw.write(".root { -fx-background-image: url(\"bg.jpg\"); }");
            bw.newLine();
            bw.write(".button { - fx-background-color: #" +
                    cpPicker.getValue().toString().substring(2,8) + "; }");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        AnchorPane p = (AnchorPane) homePanel.getParent();
        p.getChildren().remove(homePanel);
        p.getChildren().add(loginView);
    }
    
}