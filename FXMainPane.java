import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button Hello, Howdy, Chinese, Clear, Exit;
	Label Feedback;
	TextField textfield;
	
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	VBox vbox;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		Hello = new Button("Hello");
		Howdy = new Button("Howdy");
		Chinese = new Button("Chinese");
		Clear = new Button("Clear");
		Exit = new Button("Exit");
		
		Feedback = new Label("Feedback");
		textfield = new TextField();
		
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(Hello, new Insets(10));
		HBox.setMargin(Howdy, new Insets(10));
		HBox.setMargin(Chinese, new Insets(10));
		HBox.setMargin(Clear, new Insets(10));
		HBox.setMargin(Exit, new Insets(10));
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the buttons to one of the HBoxes
		hbox1.getChildren().addAll(Hello, Howdy, Chinese, Clear, Exit);
		//  add the label and textfield to the other HBox
		hbox2.getChildren().addAll(Feedback, textfield);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			if(e.getTarget() == Hello)
				textfield.setText(dataManager.getHello());
			else if(e.getTarget() == Howdy)
				textfield.setText(dataManager.getHowdy());
			else if(e.getTarget() == Chinese)
				textfield.setText(dataManager.getChinese());
			else if(e.getTarget() == Clear)
				textfield.setText("");
			else if(e.getTarget() == Exit)
			{
				Platform.exit();
				System.exit(0);
			}
				
		}
	}
}