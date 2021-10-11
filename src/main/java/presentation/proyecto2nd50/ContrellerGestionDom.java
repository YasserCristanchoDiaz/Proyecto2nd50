package presentation.proyecto2nd50;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.ManagementData;
import logic.model.Domicilier;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContrellerGestionDom implements Initializable {

    @FXML
    private TextField idSearchTxt;
    @FXML
    private Button buscarBtn;
    @FXML
    private Label searchAlertLbl;
    @FXML
    private TextField nameTxt;
    @FXML
    private Label nameAlertLbl;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField idTxt;
    @FXML
    private TextField nPhoneTxt;
    @FXML
    private Label nPhoneAlertLbl;
    @FXML
    private Label idAlertLbl;
    @FXML
    private Label lastNameAlertLbl;
    @FXML
    private Button editDomBtn;
    @FXML
    private Button deleteDomBtn;
    @FXML
    private Button addDomBtn;
    @FXML
    private Button newDomBtn;

    @FXML
    private TableView<Domicilier> tableDomiciliers;
    @FXML
    private TableColumn<Domicilier, String> nameColumn;
    @FXML
    private TableColumn<Domicilier, String> lastNameColumn;
    @FXML
    private TableColumn<Domicilier, Integer> idColumn;
    @FXML
    private TableColumn<Domicilier, Integer> nPhoneColumn;

    private ManagementData mngData;

    public ContrellerGestionDom() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mngData = new ManagementData();

        nameColumn.setCellValueFactory(new PropertyValueFactory<Domicilier, String>("name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Domicilier, String>("lastName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Domicilier, Integer>("id"));
        nPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));

        //tableDomiciliers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        this.addDomBtn.setDisable(true);
        this.editDomBtn.setDisable(true);
        this.deleteDomBtn.setDisable(true);
        this.nameTxt.setDisable(true);
        this.lastNameTxt.setDisable(true);
        this.idTxt.setDisable(true);
        this.nPhoneTxt.setDisable(true);

    }

    private void loadTableDomiciliers() {
        tableDomiciliers.getItems().clear();
        for (int i = 0; i < mngData.getDomiciliers().size(); i++) {
            tableDomiciliers.getItems().add(mngData.getDomiciliers().get(i));
        }
    }

    @FXML
    void onAddDom(ActionEvent event) {
        try {
            if (nameTxt.getText().length() > 0) {
                this.nameAlertLbl.setText("");
                if (lastNameTxt.getText().length() > 0) {
                    this.lastNameAlertLbl.setText("");
                    if (nPhoneTxt.getText().length() > 0) {
                        this.nPhoneAlertLbl.setText("");
                        int numberPhone = Integer.parseInt(nPhoneTxt.getText());
                        this.nPhoneAlertLbl.setText("");
                        this.idTxt.setText(String.valueOf(mngData.getDomiciliers().size() + 1));
                        int id = Integer.parseInt(idTxt.getText());
                        String name = nameTxt.getText();
                        String lastName = lastNameTxt.getText();
                        Domicilier domicilier = new Domicilier(name, lastName, numberPhone, id);
                        mngData.addDomicilier(domicilier);

                        loadTableDomiciliers();

                        this.nameTxt.setText("");
                        this.lastNameTxt.setText("");
                        this.nPhoneTxt.setText("");
                    } else {
                        this.nPhoneAlertLbl.setText("Asegurese de llenar el espacio");
                    }
                } else {
                    this.lastNameAlertLbl.setText("Asegurese de llenar el espacio");
                }
            } else {
                this.nameAlertLbl.setText("Asegurese de llenar el espacio");
            }
        } catch (NumberFormatException nfe) {
            this.nPhoneAlertLbl.setText("Asegurese que sean solo digitos numericos");
        } catch (NullPointerException npe) {
            this.nPhoneAlertLbl.setText("No encontrado");
        } catch (Exception e) {
            this.nPhoneAlertLbl.setText("error: " + e.getMessage());
        }

    }

    @FXML
    void onBuscar(ActionEvent event) {
        try {
            int id = Integer.parseInt(idSearchTxt.getText());

            Domicilier domicilier = mngData.findDomicilier(id);
            this.nameTxt.setText(domicilier.getName());
            this.lastNameTxt.setText(domicilier.getLastName());
            this.nPhoneTxt.setText(String.valueOf(domicilier.getNumberPhone()));
            this.idTxt.setText(String.valueOf(domicilier.getId()));

            this.deleteDomBtn.setDisable(false);
            this.editDomBtn.setDisable(false);
            this.nameTxt.setDisable(false);
            this.lastNameTxt.setDisable(false);
            this.nPhoneTxt.setDisable(false);

        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
            this.searchAlertLbl.setText("Asegurese que sean solo digitos numericos");
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
            this.searchAlertLbl.setText("No encontrado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            this.searchAlertLbl.setText("error");
        }

    }

    @FXML
    void onDeleteDom(ActionEvent event) {
        int id = Integer.parseInt(idTxt.getText());
        mngData.getDomiciliers().remove(mngData.findDomicilier(id));

        loadTableDomiciliers();

        this.nameTxt.setText("");
        this.lastNameTxt.setText("");
        this.nPhoneTxt.setText("");
        this.nameTxt.setDisable(true);
        this.lastNameTxt.setDisable(true);
        this.nPhoneTxt.setDisable(true);
        this.deleteDomBtn.setDisable(true);
        this.editDomBtn.setDisable(true);
    }

    @FXML
    void onEditDom(ActionEvent event) {
        try {
            if (nameTxt.getText().length() > 0) {
                this.nameAlertLbl.setText("");
                if (lastNameTxt.getText().length() > 0) {
                    this.lastNameAlertLbl.setText("");
                    if (nPhoneTxt.getText().length() > 0) {
                        this.nPhoneAlertLbl.setText("");
                        int numberPhone = Integer.parseInt(nPhoneTxt.getText());
                        this.nPhoneAlertLbl.setText("");
                        int id = Integer.parseInt(idTxt.getText());
                        String name = nameTxt.getText();
                        String lastName = lastNameTxt.getText();

                        mngData.getDomiciliers().get(id - 1).setName(name);
                        mngData.getDomiciliers().get(id - 1).setLastName(lastName);
                        mngData.getDomiciliers().get(id - 1).setNumberPhone(numberPhone);

                        loadTableDomiciliers();

                        this.nameTxt.setText("");
                        this.lastNameTxt.setText("");
                        this.nPhoneTxt.setText("");
                        this.nameTxt.setDisable(true);
                        this.lastNameTxt.setDisable(true);
                        this.nPhoneTxt.setDisable(true);
                        this.editDomBtn.setDisable(true);
                        this.deleteDomBtn.setDisable(true);

                    } else {
                        this.nPhoneAlertLbl.setText("Asegurese de llenar el espacio");
                    }
                } else {
                    this.lastNameAlertLbl.setText("Asegurese de llenar el espacio");
                }
            } else {
                this.nameAlertLbl.setText("Asegurese de llenar el espacio");
            }
        } catch (NumberFormatException nfe) {
            this.nPhoneAlertLbl.setText("Asegurese que sean solo digitos numericos");
        } catch (NullPointerException npe) {
            this.nPhoneAlertLbl.setText("No encontrado");
        } catch (Exception e) {
            this.nPhoneAlertLbl.setText("error: " + e.getMessage());
        }

    }

    @FXML
    void onNewDom(ActionEvent event) {
        this.nameTxt.setDisable(false);
        this.lastNameTxt.setDisable(false);
        this.nPhoneTxt.setDisable(false);
        this.idTxt.setText(String.valueOf(mngData.getDomiciliers().size() + 1));
        this.addDomBtn.setDisable(false);
    }
}
