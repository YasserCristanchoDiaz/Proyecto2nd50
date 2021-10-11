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
//CONTROLADOR_PRINCIPAL---

    private ManagementAdmin mngAdmin;
    private ContrellerGestionDom contrellerGestionDom;
    private ControllerGestionProduct controllerGestionProduct;
    private ControllerCloseShop controllerCloseShop;

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
        try {
            loadCloseShop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCloseShop() throws IOException {
        Stage stageCloseShop = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane anchorPane = fxmlLoader.load(getClass().getResource("closeShop.fxml").openStream());
        this.controllerCloseShop = fxmlLoader.getController();
        Scene sceneCloseShop = new Scene(anchorPane);
        stageCloseShop.setScene(sceneCloseShop);
        stageCloseShop.alwaysOnTopProperty();
        stageCloseShop.initModality(Modality.APPLICATION_MODAL);
        stageCloseShop.showAndWait();
    }

    @FXML
    void onGesDom(ActionEvent event) {
        try {
            loadGesDom();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGesDom() throws IOException {
        Stage stageTableDom = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane anchorPane = fxmlLoader.load(getClass().getResource("gestionDomicilier.fxml").openStream());
        this.contrellerGestionDom = fxmlLoader.getController();
        Scene sceneTableDom = new Scene(anchorPane);
        stageTableDom.setScene(sceneTableDom);
        stageTableDom.alwaysOnTopProperty();
        stageTableDom.initModality(Modality.APPLICATION_MODAL);
        stageTableDom.showAndWait();
    }

    @FXML
    void onGesProd(ActionEvent event) {
        try {
            loadGesProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onListFecha(ActionEvent event) {

    }

    @FXML
    void onPedido(ActionEvent event) {

    }

    private void loadGesProduct() throws IOException {
        Stage stageGesProduct = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane anchorPane = fxmlLoader.load(getClass().getResource("gestionProduct.fxml").openStream());
        this.controllerGestionProduct = fxmlLoader.getController();
        Scene sceneGesProduct = new Scene(anchorPane);
        stageGesProduct.setScene(sceneGesProduct);
        stageGesProduct.alwaysOnTopProperty();
        stageGesProduct.initModality(Modality.APPLICATION_MODAL);
        stageGesProduct.showAndWait();
    }
}
