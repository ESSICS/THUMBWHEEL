/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.ess.thumbwheel;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanProperty;


/**
 * @author Claudio Rosati, European Spallation Source ERIC
 */
public class ThumbWheelController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(ThumbWheelController.class.getName());

    @FXML private PropertySheet propertySheet;
    @FXML private FlowPane thumbwheelContainer;

    @Override
    public void initialize( URL url, ResourceBundle rb ) {

        long beforeTime = System.currentTimeMillis();

        ThumbWheel thumbwheel = new ThumbWheel();

        thumbwheel.setMinSize(50, 20);
        thumbwheel.setPrefSize(112, 42);

        long afterTime = System.currentTimeMillis();

        LOGGER.log(Level.INFO, "Construction time: {0,number,#########0}ms", afterTime - beforeTime);

        thumbwheelContainer.getChildren().add(thumbwheel);

        Map<Class<?>, String> categories = new HashMap<>(5);

        categories.put(ThumbWheel.class, "\u200BKnob");
        categories.put(    Region.class, "\u200B\u200BRegion");
        categories.put(    Parent.class, "\u200B\u200B\u200BParent");
        categories.put(      Node.class, "\u200B\u200B\u200B\u200BNode");
        categories.put(    Object.class, "\u200B\u200B\u200B\u200B\u200BObject");

        try {

            BeanInfo beanInfo = Introspector.getBeanInfo(ThumbWheel.class, Object.class);

            for ( PropertyDescriptor p : beanInfo.getPropertyDescriptors() ) {
                try {
                    if ( p.getReadMethod() != null && p.getWriteMethod() != null ) {
                        p.setValue(BeanProperty.CATEGORY_LABEL_KEY, categories.get(p.getReadMethod().getDeclaringClass()));
                        propertySheet.getItems().add(new BeanProperty(thumbwheel, p));
                    }
                } catch ( Exception iex ) {
                    LOGGER.log(Level.SEVERE, MessageFormat.format("Unable to handle property \"{0}\" [{1}].", p.getName(), iex.getMessage()));
                }
            }

        } catch ( IntrospectionException ex ) {
            LOGGER.log(Level.SEVERE, "Unable to initialize the controller.", ex);
        }

        propertySheet.setMode(PropertySheet.Mode.CATEGORY);

    }

}
