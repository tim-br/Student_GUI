package StudentGUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
 
public class Student extends Application {
 

 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student GUI");
        //DescriptionPane dp = new DescriptionPane();
        GridPane gp = new GridPane();
        TextArea ta = new TextArea();
        ta.setPrefSize(1100, 200);
        GridPane rightPane = new GridPane();
        RadioButton compSci = new RadioButton("Computer Science");
        RadioButton business = new RadioButton("Business");
        ToggleGroup tg = new ToggleGroup();
        compSci.setToggleGroup(tg);
        business.setToggleGroup(tg);
        rightPane.add(compSci, 1, 0);
        rightPane.add(business, 2, 0);
        
        FlowPane fp = new FlowPane(Orientation.VERTICAL);
        fp.setVgap(30);
        //fp.setPrefWrapLength(50);
        
        CheckBox cb1 = new CheckBox("Athletics");
        CheckBox cb2 = new CheckBox("Volunteer Work");
        CheckBox cb3 = new CheckBox("Chess Club");
        CheckBox cb4 = new CheckBox("Student Union");

        
        fp.setAlignment(Pos.CENTER);
       
        ArrayList<CheckBox> cbList =  new ArrayList<CheckBox>();
        
        
        fp.getChildren().addAll(cb1, cb2, cb3, cb4);
                
        cbList.add(cb1);
        cbList.add(cb2);
        cbList.add(cb3);
        cbList.add(cb4);




        
        
        
        ComboBox cb = new ComboBox();
        ArrayList<String> compCourses = new ArrayList<String>();
        compCourses.add("C++");
        compCourses.add("Design Patterns");
        compCourses.add("Advanced Lisp");
        compCourses.add("Introduction to Parsing");
        ArrayList<String> busCourses = new ArrayList<String>();
        busCourses.add("Introduction to Finance");
        busCourses.add("Accounting");
        busCourses.add("Investments");
        busCourses.add("Financial Mathematics");
        
       
        
        TextArea courseList = new TextArea();
        courseList.autosize();
        courseList.setMaxWidth(300);
        
      

        //cb.setItems((ObservableList) compCourses);
        HashSet<String> hs = new HashSet<String>();
        cb.setOnAction( e ->{
        	if(hs.contains((String) cb.getValue())){
        		
        	}
        	else{
        		
        	courseList.appendText((String) cb.getValue()+ "\n");
        	hs.add((String) cb.getValue());
        	}
        }      
        );
        
        compSci.setOnAction(e -> {
        	courseList.clear();
        	hs.clear();
        	cb.getItems().clear();
        	cb.getItems().addAll(compCourses);
        	});
        
        business.setOnAction(e -> {
        	courseList.clear();
        	hs.clear();

        	cb.getItems().clear();
        	cb.getItems().addAll(busCourses);
        	});
        


        cb.setMinWidth(250);
        rightPane.add(cb, 1, 3);
        
        rightPane.add(courseList, 1, 4);



        
        
        
        
        gp.setPadding(new Insets(40, 0, 0, 50));
        gp.setHgap(5); 
        gp.setVgap(5);
    
    Label lab1 = new Label("Name");
    GridPane.setHalignment(lab1, HPos.RIGHT);
    TextField tfName = new TextField();
    
    Label lab2 = new Label("Adress");
    GridPane.setHalignment(lab2, HPos.RIGHT);
    TextField tfAdress = new TextField();
    
    Label lab3 = new Label("Province");
    GridPane.setHalignment(lab3, HPos.RIGHT);
    TextField tfProvince = new TextField();
    Label lab4 = new Label("City");
    GridPane.setHalignment(lab4, HPos.RIGHT);
    TextField tfCity = new TextField();
    Label lab5 = new Label("Postal Code");
    GridPane.setHalignment(lab5, HPos.RIGHT);
    TextField tfPostalCode = new TextField();
    Label lab6 = new Label("Phone Number");
    GridPane.setHalignment(lab6, HPos.RIGHT);
    TextField tfPhoneNumber = new TextField();
    Label lab7 = new Label("Email");
    GridPane.setHalignment(lab7, HPos.RIGHT);
    TextField tfEmail = new TextField();
    
    ArrayList<TextField> textfieldlist = new ArrayList<TextField>();
    
    textfieldlist.add(tfName);
    textfieldlist.add(tfAdress);
    textfieldlist.add(tfProvince);
    textfieldlist.add(tfCity);
    textfieldlist.add(tfPostalCode);
    textfieldlist.add(tfPhoneNumber);
    textfieldlist.add(tfEmail);


    
    

    Button btDisplay = new Button("Display");
    GridPane.setMargin(btDisplay, new Insets(10, 0, 0, 0));
    
   btDisplay.setOnAction(e-> setDisplay(ta, textfieldlist, hs, cbList));
    
    gp.add(lab1, 0, 0);
    gp.add(tfName, 1, 0);
    gp.add(lab2, 0, 1);
    gp.add(tfAdress, 1, 1); 
    gp.add(lab3, 0, 2);
    gp.add(tfProvince, 1, 2);
    gp.add(lab4, 0, 3);
    gp.add(tfCity, 1, 3);
    gp.add(lab5, 0, 4);
    gp.add(tfPostalCode, 1, 4); 
    gp.add(lab6, 0, 5);
    gp.add(tfPhoneNumber, 1, 5);
    gp.add(lab7, 0, 6);
    gp.add(tfEmail, 1, 6);
    gp.add(btDisplay, 1, 7);
    

        
        Group root = new Group();
        final Scene scene = new Scene(root);
        
        BorderPane bp = new BorderPane();
        bp.setPrefSize(1100, 500);
        
        bp.setLeft(gp);
        bp.setBottom(ta);
        bp.setRight(rightPane);
        bp.setCenter(fp);
       
        root.getChildren().add(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void setDisplay(TextArea ta, ArrayList<TextField> al, HashSet<String> hs, ArrayList<CheckBox> al2){
    		ta.clear();
        	for(TextField tf : al){
    		ta.appendText(tf.getText() + "\n");

        	}
        	
        	for(String s : hs){
        		ta.appendText(s + "   ");
        	}
        	
        	ta.appendText("\n");
        	
        	for(CheckBox c : al2){
        		if(c.isSelected()){
        			ta.appendText(c.getText() + "  ");
        		}
        	}
    
    }



    
    public static void main(String[] args) {
        launch(args);
    }
}
