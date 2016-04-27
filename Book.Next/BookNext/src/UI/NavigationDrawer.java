/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Pages.BookDescriptionPage;
import Pages.EditProfile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleNode;
import de.jensd.fx.fontawesome.Icon;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author jcdur
 */
public class NavigationDrawer extends JFXDrawersStack{
    
    private double width;
    private JFXDrawer leftDrawer;
    private StackPane leftDrawerPane;
    private Pane content;
    
    public NavigationDrawer(double width)
    {
        this.content = new Pane();
        this.width = width;
        this.leftDrawer = new JFXDrawer();
        this.leftDrawerPane = new StackPane();
    }
    
    public Pane getContent()
    {
        return content;
    }
    
    public void refreshContent(Pane newContent)
    {
        this.setContent(content);
    }
    public void createNavDrawer()
    {
        JFXToggleNode node2 = new JFXToggleNode();
//        
//        Icon value2 = new Icon("KEY", "2em", ";", "icon");
//        node2.setGraphic(value2);
//        node2.setStyle("-fx-background-radius: 4em; -fx-background-color:TRANSPARENT;");
        
        content = new Pane();
        content.setStyle("-fx-background-color: -fx-background-color: WHITE;");

        
        leftDrawer.setSidePane(leftDrawerPane);
        leftDrawer.setDefaultDrawerSize(220);
        leftDrawer.setId("LEFT");
        leftDrawer.setOverLayVisible(true);
        setNavDrawerList();
        this.setContent(content);
    }
    
    private void createHeader()
    {
        String book = "Book";
        String next = "Next";
    }
    
    private void setNavDrawerList()
    {
        // <editor-fold defaultstate="collapsed" desc="Mouse event creation">
        EventHandler<MouseEvent> goToHome = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                BookDescriptionPage bookDescript = new BookDescriptionPage(); //Creating new Stage
                bookDescript.setSize(1100, 700); //Resizing
                content = bookDescript.getContent();
                //Stage bookDescriptStage = bookDescript.getStage(); //Getting Stage
                //bookDescriptStage.show(); //Showing Stage
                //stage.getScene().getWindow().hide(); //Hiding old Stage
            }
        };
        
        EventHandler<MouseEvent> goToProfile = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                    BookDescriptionPage bookDescript = new BookDescriptionPage(); //Creating new Stage
                bookDescript.setSize(1100, 700); //Resizing
                content = bookDescript.getContent();
                //Stage bookDescriptStage = bookDescript.getStage(); //Getting Stage
                //bookDescriptStage.show(); //Showing Stage
                //stage.getScene().getWindow().hide(); //Hiding old Stage
            }
        };
        // </editor-fold>
        
        JFXListView<Label> menuList = new JFXListView<Label>();
        menuList.setStyle("-fx-padding: 10 10 10 10;");
        
        Label lblHome = new Label("    Home");
        lblHome.setStyle("-fx-font-size: 14; -fx-font-weight: LIGHT;");
        Image imgUser = new Image("/Icons/home.png");
        lblHome.setGraphic(new ImageView(imgUser));
        lblHome.setTextAlignment(TextAlignment.CENTER);
        menuList.getItems().add(lblHome);
        lblHome.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			BookDescriptionPage bookDescript = new BookDescriptionPage(); //Creating new Stage
                        bookDescript.setSize(1100, 700); //Resizing
                        content = bookDescript.getContent();
                        this.setContent(content);
		});
        //lblHome.setOnMouseClicked(goToHome);
        
        Label lblProfile = new Label("    Profile");
        lblProfile.setStyle("-fx-font-size: 14;");
        imgUser = new Image("/Icons/profile.png");
        lblProfile.setGraphic(new ImageView(imgUser));
        lblProfile.setTextAlignment(TextAlignment.CENTER);
        menuList.getItems().add(lblProfile);
        lblProfile.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			EditProfile profile = new EditProfile();
                        profile.setSize(1100, 700); //Resizing
                        content = profile.getContent();
                        this.setContent(content);
		});
        
        this.leftDrawerPane.getChildren().add(menuList);
    }
    
    public JFXDrawer getSideMenu()
    {
        return leftDrawer;
    }
    
}