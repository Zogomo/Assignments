import java.text.DecimalFormat;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

public class Controller 
{
    private static final String numPattern = "\\d*(\\.\\d*)?";
    ObservableList<String> unitList = FXCollections
        .observableArrayList("Kilograms", "Grams", "Milligrams", "Pounds", "Ounces"); //Weight units: KILOGRAMS, POUNDS, GRAMS, MILLIGRAMS, OUNCES

    @FXML
    private TextField quanTextField;
    @FXML
    private ChoiceBox unitInBox;
    @FXML
    private ChoiceBox unitOutBox;
    @FXML
    private Label quantOutLabel;

    @FXML
    private void initialize()
    {
        unitInBox.setValue("Grams");
        unitOutBox.setValue("Kilograms");

        unitInBox.setItems(unitList);
        unitOutBox.setItems(unitList);

        UnaryOperator<Change> numberFilter = change ->
        {
            String newText = change.getControlNewText();

            if(newText.matches(numPattern))
            {
                return change;
            }
            else
            {
                return null;
            }
        };

        TextFormatter<String> numberFormatter = new TextFormatter<>(numberFilter);
        quanTextField.setTextFormatter(numberFormatter);
    }

    @FXML
    private void calculateConversion()
    {
        double quantIn = Double.parseDouble(quanTextField.getText());
        String unitInEnu = (String) unitInBox.getValue();
        String unitOutEnu = (String) unitOutBox.getValue();
        double quantOut = WeightConversion.weightConv(quantIn, unitInEnu, unitOutEnu);

        DecimalFormat format = new DecimalFormat("#.#####");
        
        quantOutLabel.setText(format.format(quantIn) + " " + unitInEnu +  " is " + format.format(quantOut) + " " + unitOutEnu + ".");
    }
}
