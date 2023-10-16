package com.mycompany.javafx_db_example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class DB_GUI_Controller implements Initializable {

    private final ObservableList<Person2> data =
            FXCollections.observableArrayList(
                    new Person2("Jacob", "917", "CPIS", "99", "@nyc", 50),
                    new Person2("Jacob2", "929", "CPIS1", "98", "@nyc", 40)

            );



    @FXML
    TextField first_name, last_name, department, major, salary;
    @FXML
    private TableView<Person2> tv;
    @FXML
    private TableColumn<Person2, Integer> tv_id;
    @FXML
    private TableColumn<Person2, String> tv_fn, tv_ln, tv_dept, tv_major, tv_salary;

    @FXML
    ImageView img_view;


    private Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("salary"));


        tv.setItems(data);

    }



    public void setScene(Scene scene) {
        this.scene = scene;

        // Set an event handler to listen for key presses
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.DELETE) {
                deleteRecord();
            }
        });

        // Request focus for the TableView
        tv.requestFocus();
    }






    @FXML
    protected void addNewRecord() {


        data.add(new Person(
                data.size()+1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText()
        ));
    }

    @FXML
    protected void clearForm() {
        first_name.clear();
        last_name.setText("");
        department.setText("");
        major.setText("");
    }

    @FXML
    protected void emptyTable()
    {
        data.clear();
    }


    @FXML
    protected void closeApplication() {
        System.exit(0);
    }


    @FXML
    protected void editRecord() {
        Person2 p= tv.getSelectionModel().getSelectedItem();
        int c=data.indexOf(p);
        Person2 p2= new Person2();
        p2.setId(c+1);
        p2.setName(first_name.getText());
        p2.setName(last_name.getText());
        //p2.setDept(department.getText());
        //p2.setMajor(major.getText());
        data.remove(c);
        data.add(c,p2);
        tv.getSelectionModel().select(c);
    }

    @FXML
    protected void deleteRecord() {
        System.out.println("deleteRecord() method called");
        Person2 p= tv.getSelectionModel().getSelectedItem();
        data.remove(p);
    }

    @FXML
    protected void showImage() {
        File file= (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file!=null){
            img_view.setImage(new Image(file.toURI().toString()));

        }
    }





    @FXML
    protected void selectedItemTV(MouseEvent mouseEvent) {
        Person2 p= tv.getSelectionModel().getSelectedItem();
        first_name.setText(p.getName());
        last_name.setText(p.getName());
       // department.setText(p.getDept());
       // major.setText(p.getMajor());


    }
}