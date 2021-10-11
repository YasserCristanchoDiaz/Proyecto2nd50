package presentation.proyecto2nd50;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.ManagementData;
import logic.model.Domicilier;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCloseShop implements Initializable {

    //--TABLA_Domiciliarios_del_dia------------------------------
    @FXML private TableView<Domicilier> domiciliersTable;
    @FXML private TableColumn<Domicilier, String> nameColumn;
    @FXML private TableColumn<Domicilier, String> lastNameColumn;
    @FXML private TableColumn<Domicilier, Integer> idColumn;
    @FXML private TableColumn<Domicilier, Integer> nPhoneColumn;
    @FXML private TableColumn<Domicilier, Integer> nOrdersColumn;
    @FXML private TableColumn<Domicilier, Boolean> bonoColumn;
    @FXML private TableColumn<Domicilier, Double> salaryColumn;

    @FXML private TextField todayTxt;
    @FXML private TextField prMasVenTxt;
    @FXML private TextField clientPrTxt;
    @FXML private TextField nOrdersTodayTxt;
    @FXML private TextField ganTotalTxt;

    private ManagementData mngData;

    public ControllerCloseShop() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mngData = new ManagementData();

        initializeDomTable();

        this.todayTxt.setDisable(true);
        this.prMasVenTxt.setDisable(true);
        this.clientPrTxt.setDisable(true);
        this.nOrdersTodayTxt.setDisable(true);
        this.ganTotalTxt.setDisable(true);
    }

    private void initializeDomTable() {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,String>("name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,String>("lastName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,Integer>("id"));
        nPhoneColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,Integer>("numberPhone"));
        nOrdersColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,Integer>("nOrders"));
        //bonoColumn.setCellValueFactory(new PropertyValueFactory<Domicilier, Boolean>("bono"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Domicilier,Double>("salary"));

    }

}
