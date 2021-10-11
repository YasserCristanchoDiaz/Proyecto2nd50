package presentation.proyecto2nd50;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.ManagementData;
import logic.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGestionProduct implements Initializable {

    private ManagementData mngData;

    @FXML
    private TextField searchRefTxt;
    @FXML
    private Button searchRefBtn;
    @FXML
    private Button addProductBtn;
    @FXML
    private TextField descrptionTxt;
    @FXML
    private TextField valueTxt;
    @FXML
    private Button editProductBtn;
    @FXML
    private Button newBtn;
    @FXML
    private Label searchRefAdvertLbl;
    @FXML
    private Label desAdvertLbl;
    @FXML
    private Label valueAdvertLbl;

    @FXML
    private TableView<Product> tableProducts;
    @FXML
    private TableColumn<Product, Integer> refColumn;
    @FXML
    private TableColumn<Product, String> descColumn;
    @FXML
    private TableColumn<Product, Double> valueColumn;

    public ControllerGestionProduct() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mngData = new ManagementData();

        refColumn.setCellValueFactory(new PropertyValueFactory<Product,Integer>("reference"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Product,Double>("value"));

        this.editProductBtn.setDisable(true);
        this.descrptionTxt.setDisable(true);
        this.valueTxt.setDisable(true);
        this.addProductBtn.setDisable(true);

    }

    private void loadArr() {
        tableProducts.getItems().clear();
        for (Product p : mngData.getProducts()) {
            tableProducts.getItems().add(p);
        }
    }

    @FXML
    void onAddProduct(ActionEvent event) {

        try {
            if ( descrptionTxt.getText().length() > 0 ) {
                this.desAdvertLbl.setText("");
                if ( valueTxt.getText().length() > 0 ) {
                    this.valueAdvertLbl.setText("");

                    String description = descrptionTxt.getText();
                    Double value = Double.parseDouble(valueTxt.getText());
                    this.valueAdvertLbl.setText("");

                    Product product = new Product((mngData.getProducts().size() + 1), description, value);
                    mngData.addProduct(product);

                    loadArr();

                    this.descrptionTxt.setText("");
                    this.valueTxt.setText("");

                } else {
                    this.valueAdvertLbl.setText("Asegurese de rellenar el espacio");
                }
            } else {
                this.desAdvertLbl.setText("Asegurese de rellenar el espacio");
            }
        } catch (NumberFormatException npe) {
            this.valueAdvertLbl.setText("Aseguse que sean digitos decimales");
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
            this.searchRefAdvertLbl.setText("No encontrado");
        } catch (Exception e) {
            //System.err.println(e.getMessage());
            this.searchRefAdvertLbl.setText("error: " + e.getMessage());
        }

    }

    @FXML
    void onEditProduct(ActionEvent event) {

        try {
            if ( descrptionTxt.getText().length() > 0 ) {
                this.desAdvertLbl.setText("");
                if ( valueTxt.getText().length() > 0 ) {
                    this.valueAdvertLbl.setText("");

                    int ref = Integer.parseInt(searchRefTxt.getText());
                    String description = descrptionTxt.getText();
                    Double value = Double.parseDouble(valueTxt.getText());
                    this.valueAdvertLbl.setText("");

                    mngData.getProducts().get( ref - 1 ).setDescription(description);
                    mngData.getProducts().get( ref - 1 ).setValue(value);

                    loadArr();

                    this.descrptionTxt.setText("");
                    this.valueTxt.setText("");
                    this.editProductBtn.setDisable(true);
                    this.descrptionTxt.setDisable(true);
                    this.valueTxt.setDisable(true);

                } else {
                    this.valueAdvertLbl.setText("Asegurese de rellenar el espacio");
                }
            } else {
                this.desAdvertLbl.setText("Asegurese de rellenar el espacio");
            }
        } catch (NumberFormatException npe) {
            this.valueAdvertLbl.setText("Aseguse que sean digitos decimales");
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
            this.searchRefAdvertLbl.setText("No encontrado");
        } catch (Exception e) {
            this.searchRefAdvertLbl.setText("error: " + e.getMessage());
        }

    }

    @FXML
    void onSearchRef(ActionEvent event) {
        this.searchRefTxt.setDisable(false);
        try {
            if ( searchRefTxt.getText().length() > 0 ) {
                this.searchRefAdvertLbl.setText("");
                int referance = Integer.parseInt(searchRefTxt.getText());
                this.searchRefAdvertLbl.setText("");

                Product product = mngData.findProduct(referance);
                this.descrptionTxt.setText(product.getDescription());
                this.valueTxt.setText(String.valueOf(product.getValue()));
                this.editProductBtn.setDisable(false);

                this.descrptionTxt.setDisable(false);
                this.valueTxt.setDisable(false);
                this.editProductBtn.setDisable(false);
                this.addProductBtn.setDisable(true);

            } else {
                this.searchRefAdvertLbl.setText("Asegurese de llenar el espacio");
            }
        } catch (NumberFormatException nfe) {
            this.searchRefAdvertLbl.setText("Aseguse que sean digitos numericos");
        } catch (NullPointerException npe) {
            this.searchRefAdvertLbl.setText("No encontrado");
        } catch (Exception e) {
            this.searchRefAdvertLbl.setText("error: " + e.getMessage());
        }
    }

    @FXML
    void onNew(ActionEvent event) {
        this.addProductBtn.setDisable(false);
        this.editProductBtn.setDisable(true);
        this.descrptionTxt.setDisable(false);
        this.valueTxt.setDisable(false);

    }
}
