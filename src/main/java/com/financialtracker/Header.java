package com.financialtracker;


import javafx.fxml.FXML;

import java.io.IOException;

public class Header {
    @FXML
    private void showMain() throws IOException {
        HelloApplication.changeScene("main-view.fxml");
    }

    @FXML
    private void showDashbord() throws IOException {
        HelloApplication.changeScene("dashboard-view.fxml");
    }

    @FXML
    private void showRevenus() throws IOException {
        HelloApplication.changeScene("revenus-view.fxml");
    }
}