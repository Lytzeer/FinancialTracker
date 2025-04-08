package com.financialtracker;

import com.financialtracker.db.RevenusDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRevenusView {
    @FXML
    private TextField periodField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField helpersField;
    @FXML
    private TextField selfEnterpriseField;
    @FXML
    private TextField passiveIncomeField;
    @FXML
    private TextField otherField;

    private RevenusController mainController;

    public void setMainController(RevenusController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void addRevenus() {
        Revenus newRevenus = new Revenus();
        newRevenus.setPeriod(periodField.getText());
        newRevenus.setSalary(Float.parseFloat(salaryField.getText()));
        newRevenus.setHelpers(Float.parseFloat(helpersField.getText()));
        newRevenus.setSelf_enterprise(Float.parseFloat(selfEnterpriseField.getText()));
        newRevenus.setPassive_income(Float.parseFloat(passiveIncomeField.getText()));
        newRevenus.setOther(Float.parseFloat(otherField.getText()));

        mainController.addRevenus(newRevenus);

        RevenusDAO.insertRevenus(newRevenus);

        Stage stage = (Stage) periodField.getScene().getWindow();
        stage.close();
    }
}
