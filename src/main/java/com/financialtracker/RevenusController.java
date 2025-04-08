package com.financialtracker;

import com.financialtracker.db.RevenusDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RevenusController {
    @FXML
    private TableView<Revenus> revenusTable;

    private ObservableList<Revenus> revenusData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        revenusData.addAll(RevenusDAO.getRevenus());
        revenusTable.setItems(revenusData);
    }

    @FXML
    public void openAddRevenusView(ActionEvent event) throws IOException, IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-revenus-view.fxml"));
        Parent parent = fxmlLoader.load();

        AddRevenusView controller = fxmlLoader.getController();
        controller.setMainController(this);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(parent));
        stage.showAndWait();
    }

    public void addRevenus(Revenus revenus) {
        revenusData.add(revenus);
    }
}
