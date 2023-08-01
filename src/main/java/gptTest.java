import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class gptTest {
  public static void main(String[] args) {
    // Create an IntegerProperty with an initial value of 10
    IntegerProperty observableInteger = new SimpleIntegerProperty(10);

    // Add a ChangeListener to observe changes in the IntegerProperty
    observableInteger.addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println("Value changed from " + oldValue + " to " + newValue);
      }
    });

    // Change the value of the IntegerProperty
    observableInteger.set(20);

    // Output:
    // Value changed from 10 to 20
  }
}
