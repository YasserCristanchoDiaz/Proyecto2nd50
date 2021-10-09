package presentation.proyecto2nd50;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.admin.ManagementAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMenuBar implements Initializable {

    private ManagementAdmin mngAdmin;

    public ControllerMenuBar() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.menuBar.setVisible(false);
        mngAdmin = new ManagementAdmin();
        try {
            mngAdmin.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //-LOGIN------------------------------------------------------------------------------------------------------------

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField userTxt;

    @FXML
    private Label usAlertLbl;

    @FXML
    private PasswordField pwTxt;

    @FXML
    private Label pwAlertLbl;

    @FXML
    private Button loginBtn;

    @FXML
    void onLogin(ActionEvent event) {
        if (mngAdmin.checkUser(this.userTxt.getText())) {
            this.usAlertLbl.setText("");
            if (mngAdmin.checkPassword(this.pwTxt.getText())) {
                this.pwAlertLbl.setText("");
                System.out.println("Entro ome'");
                this.loginAnchorPane.setVisible(false);
                this.menuBar.setVisible(true);
                this.menuBar.setDisable(false);
            } else {
                this.pwAlertLbl.setText("Contraseña invalida");
            }
        } else {
            this.usAlertLbl.setText("Usuario desconocido");
        }
    }

    //-MENUBAR----------------------------------------------------------------------------------------------------------

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem mItemPedido;

    @FXML
    private MenuItem mItemListFecha;

    @FXML
    private MenuItem mItemCerrarTienda;

    @FXML
    private MenuItem mItemGesDom;

    @FXML
    private MenuItem mItemGesProd;

    @FXML
    void onCerrarTienda(ActionEvent event) {

    }

    @FXML
    void onGesDom(ActionEvent event) {

    }

    @FXML
    void onGesProd(ActionEvent event) {

    }

    @FXML
    void onListFecha(ActionEvent event) {

    }

    @FXML
    void onPedido(ActionEvent event) {

    }
}
