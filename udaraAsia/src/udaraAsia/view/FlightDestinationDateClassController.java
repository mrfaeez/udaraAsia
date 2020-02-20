package udaraAsia.view;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import udaraAsia.Main;

public class FlightDestinationDateClassController {
	
	ObservableList<String> list = FXCollections.observableArrayList("Jakarta","Bangkok","Kuala Lumpur","Hanoi");
	
	
	@FXML
	private ComboBox<String> from;
	
	@FXML
	private ComboBox<String> to;
	
	@FXML
	private RadioButton economy;
	
	@FXML
	private RadioButton business;
	
	@FXML
	private DatePicker dateOfDeparture;
	
	@FXML
	private ToggleGroup kelas;
	
	@FXML
	private void initialize() {
		from.setItems(list);
		to.setItems(list);
	}
	
	@FXML
	private void handleOkBtn(ActionEvent e) throws IOException, ParseException {
		Main.getMainViewData(from(), to(), getDay(), getFlightClass());
	}
	
	@FXML
	private void handleCancelBtn(ActionEvent e) {
		System.exit(0);
	}
	
	public String from() {
		return from.getValue().toString();
	}
	
	public String to() {
		return to.getValue().toString();
	}
	
	public String getFlightClass() {
		RadioButton selectedRadioButton = (RadioButton) kelas.getSelectedToggle();
		return selectedRadioButton.getText();
	}
	
	public Date getDay() {
		LocalDate localDate = dateOfDeparture.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		return date;
	}
	
}