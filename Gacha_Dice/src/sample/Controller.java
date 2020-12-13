package sample;

import data.Dice;
import data.Robot;
import data.Player;
import data.TrongTai;
import function.Click;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.notification.TrayNotification;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class Controller implements Initializable, Click {
    @FXML
    public TextField edtPlayer1;
    @FXML
    public TextField edtPlayer2;
    @FXML
    public TextField edtPlayer3;
    @FXML
    public TextField edtPlayer4;
    @FXML
    public Label txtScorePlayer1;
    @FXML
    public Label txtScorePlayer2;
    @FXML
    public Label txtScorePlayer3;
    @FXML
    public Label txtScorePlayer4;
    @FXML
    public Label txtInfoGame;
    @FXML
    public CheckBox checkRobot1;
    @FXML
    public CheckBox checkRobot2;
    @FXML
    public CheckBox checkRobot3;
    @FXML
    public CheckBox checkRobot4;
    @FXML
    public Button btnStart;
    @FXML
    public Button btnRoll;
    @FXML
    public Button btnLoad;
    @FXML
    public Button btnRobot1, btnRobot2, btnRobot3, btnRobot4;
    @FXML
    public ImageView imgPlayer1;
    @FXML
    public ImageView imgPlayer2;
    @FXML
    public ImageView imgPlayer3;
    @FXML
    public ImageView imgPlayer4;

    public List<Label> dsScorePlayers = new ArrayList<>(4);
    public List<ImageView> listImages = new ArrayList<>(4);
    private List<Dice> listDice = new ArrayList<>();
    private Vector<Player> dsPlayers = new Vector<>(4);
    private int[] random = new int[2];   // mảng chứa: xúc xắc và người
    private int firstTurn = 0;
    private TrongTai TrongTaiGame;

    Player player1;
    Player player2;
    Player player3;
    Player player4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClicksStart();
        ClicksRoll();
        ClickLoad();
    }

    public void setCheckRobot1Change() {
        btnRobot1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkRobot1.isSelected()) {
                    edtPlayer1.setText("Máy 1");
                } else {
                    edtPlayer1.clear();
                }
            }
        });
    }

    public void setCheckRobot2Change() {
        btnRobot2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkRobot2.isSelected()) {
                    edtPlayer2.setText("Máy 2");
                } else {
                    edtPlayer2.clear();
                }
            }
        });
    }

    public void setCheckRobot3Change() {
        btnRobot3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkRobot3.isSelected()) {
                    edtPlayer3.setText("Máy 3");
                } else {
                    edtPlayer3.clear();
                }
            }
        });
    }

    public void setCheckRobot4Change() {
        btnRobot4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkRobot4.isSelected()) {
                    edtPlayer4.setText("Máy 4");
                } else {
                    edtPlayer4.clear();
                }
            }
        });
    }

    // thêm người chơi
    public void addPlayer() {
        dsScorePlayers.add(txtScorePlayer1);
        dsScorePlayers.add(txtScorePlayer2);
        dsScorePlayers.add(txtScorePlayer3);
        dsScorePlayers.add(txtScorePlayer4);
        listImages.add(imgPlayer1);
        listImages.add(imgPlayer2);
        listImages.add(imgPlayer3);
        listImages.add(imgPlayer4);
        Dice A = new Dice(1);
        Dice B = new Dice(2);
        Dice C = new Dice(3);
        Dice D = new Dice(4);
        listDice.add(A);
        listDice.add(B);
        listDice.add(C);
        listDice.add(D);
        checkPlayer();
        dsPlayers.add(player1);
        dsPlayers.add(player2);
        dsPlayers.add(player3);
        dsPlayers.add(player4);
        TrongTaiGame = new TrongTai(dsPlayers);
    }

    // Chọn loại người chơi
    public void checkPlayer() {
        if (checkRobot1.isSelected()) {
            player1 = new Robot("Máy 1");
            txtScorePlayer1.setText((player1).getName() + "\n"
                    + "Điểm số : " + (player1).getScore());    // set tên và điểm số cho máy 1
            Image image = new Image("/image/Robot.PNG");
            imgPlayer1.setImage(image);
        } else {
            player1 = new Player(edtPlayer1.getText());
            txtScorePlayer1.setText((player1).getName() + "\n"
                    + "Điểm số : " + (player1).getScore());    // set tên và điểm số cho player1
            Image image = new Image("/image/itachi2.png");
            imgPlayer1.setImage(image);
        }
        if (checkRobot2.isSelected()) {
            player2 = new Robot("Máy 2");
            txtScorePlayer2.setText((player2).getName() + "\n"
                    + "Điểm số : " + (player2).getScore());
            Image image = new Image("/image/Robot.PNG");    // set tên và điểm số cho máy 2
            imgPlayer2.setImage(image);
        } else {
            player2 = new Player(edtPlayer2.getText());
            txtScorePlayer2.setText((player2).getName() + "\n"
                    + "Điểm số : " + (player2).getScore());    // set tên và điểm số cho player2
            Image image = new Image("/image/sharingan.png");
            imgPlayer2.setImage(image);
        }
        if (checkRobot3.isSelected()) {
            player3 = new Robot("Máy 3");
            txtScorePlayer3.setText((player3).getName() + "\n"
                    + "Điểm số : " + (player3).getScore());    // set tên và điểm số cho máy 3
            Image image = new Image("/image/Robot.PNG");
            imgPlayer3.setImage(image);
        } else {
            player3 = new Player(edtPlayer3.getText());
            txtScorePlayer3.setText((player3).getName() + "\n"
                    + "Điểm số : " + (player3).getScore());   // set tên và điểm số cho player3
            Image image = new Image("/image/rinnegan.png");
            imgPlayer3.setImage(image);
        }
        if (checkRobot4.isSelected()) {
            player4 = new Robot("Máy 4");
            txtScorePlayer4.setText((player4).getName() + "\n"
                    + "Điểm số : " + (player4).getScore());   // set tên và điểm số cho máy 4
            Image image = new Image("/image/Robot.PNG");
            imgPlayer4.setImage(image);
        } else {
            player4 = new Player(edtPlayer4.getText());
            txtScorePlayer4.setText((player4).getName() + "\n"
                    + "Điểm số : " + (player4).getScore());   // set tên và điểm số cho player4
            Image image = new Image("/image/madara.png");
            imgPlayer4.setImage(image);
        }
    }

    // Roll
    private void Gacha_Dice(int n) {
        if (dsPlayers.get(n).getClass().getName() == "Player") {
            firstTurn = listDice.get(random[1]).Roll();
            TrongTaiGame.tinhDiem(dsPlayers.get(n), firstTurn);
            dsScorePlayers.get(n).setText((dsPlayers.get(n)).getName() + "\n"
                    + "Điểm số: " + dsPlayers.get(n).getScore());
        } else {
            firstTurn = listDice.get(random[1]).Roll();
            TrongTaiGame.tinhDiem(dsPlayers.get(n), firstTurn);
            dsScorePlayers.get(n).setText((dsPlayers.get(n)).getName() + "\n"
                    + "Điểm số: " + (dsPlayers.get(n)).getScore());
        }
    }

    // thông tin người chơi
    public void dialogInformation() {
        while (true) {
            firstTurn = 0;
            random = TrongTaiGame.Random1st();
            txtInfoGame.setText(" Trọng tài : Người chơi tiếp là "
                    + (dsPlayers.get(random[0])).getName()
                    + ", sử dụng xúc xắc số " + (random[1] + 1));
            int NguoiDuocChon = random[0];
            Gacha_Dice(NguoiDuocChon);
            break;
        }
    }

    // thông báo chiến thắng
    public void dialogWin() {
        Object ketQua = TrongTaiGame.checkOver();
        if (ketQua != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Người chiến thắng");
            alert.setContentText(" Người chơi " + ((Player) ketQua).getName() + " là người chiến thắng");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            alert.getButtonTypes().setAll(buttonTypeYes);
            alert.showAndWait();
            txtInfoGame.setText(" Trọng tài : Người chơi " + ((Player) ketQua).getName() + " là người chiến thắng");
        }
    }

    // reset lại toàn bộ trò chơi
    public void loadInfo(){
        edtPlayer1.setText("");
        edtPlayer2.setText("");
        edtPlayer3.setText("");
        edtPlayer4.setText("");
        imgPlayer1.setImage(null);
        imgPlayer2.setImage(null);
        imgPlayer3.setImage(null);
        imgPlayer4.setImage(null);
    }

    // thông báo tạo nhân vật thành công
    // https://stackoverflow.com/questions/47764216/can-javafx-natively-show-os-notifications/47765402
    public void txtNotification(){
        // https://github.com/controlsfx/controlsfx.git
        // https://github.com/PlusHaze/TrayNotification.git
        Image img = new Image("image/success.png");
        String title = "Chúc mừng";
        String message = "Bạn đã tạo nhân vật thành công";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        tray.setImage(img);
        tray.setMessage(message);
        tray.showAndDismiss(Duration.seconds(1.4));
    }

    // bắt sự kiện ClickStart
    @Override
    public void ClicksStart() {
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPlayer();
                txtNotification();
            }
        });
    }

    // bắt sự kiện ClicksRoll
    @Override
    public void ClicksRoll() {
        btnRoll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogInformation();
                dialogWin();
            }
        });
    }

    // bắt sự kiện ClickLoad
    @Override
    public void ClickLoad() {
        btnLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadInfo();
            }
        });
    }
}
