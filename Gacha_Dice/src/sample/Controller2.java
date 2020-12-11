package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    public Button btnLogin;
    @FXML
    public TextField txtNhap;

    public int numOfPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set màu cho nút bấm
        btnLogin.setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 13px; -fx-text-fill: #ffffff");
        // gán sự kiện cho nút login chuyển màn hình
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // kiểm tra điều kiện của textField
                    if (!txtNhap.getText().isEmpty()) {
                        if (Integer.parseInt(txtNhap.getText()) <= 3) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Bạn đã nhập sai số lượng người chơi");
                            alert.show();
                        } else if(Integer.parseInt(txtNhap.getText()) > 0 && Integer.parseInt(txtNhap.getText()) <= 4){
                            numOfPlayer = Integer.parseInt(txtNhap.getText());
                            // thông báo đăng nhập thành công
                            Image img = new Image("image/success.png");
                            String title = "Chúc mừng";
                            String message = "Bạn đã đăng nhập thành công";
                            TrayNotification tray = new TrayNotification();
                            tray.setTitle(title);
                            tray.setRectangleFill(Paint.valueOf("#2A9A84"));
                            tray.setImage(img);
                            tray.setMessage(message);
                            tray.showAndDismiss(Duration.seconds(1.5));  // thời gian delay
                            ((Node)event.getSource()).getScene().getWindow().hide();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
                            Parent root = (Parent) loader.load();
                            Stage stage = new Stage();
                            stage.setTitle("Game Xúc Xắc");
                            stage.setScene(new Scene(root, 653, 902));
                            stage.setResizable(false);
                            stage.show();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
