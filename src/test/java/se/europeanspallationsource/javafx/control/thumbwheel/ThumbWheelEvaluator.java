/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright (C) 2017 by European Spallation Source ERIC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.europeanspallationsource.javafx.control.thumbwheel;


import java.io.IOException;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static javafx.stage.StageStyle.DECORATED;
import static org.testfx.util.WaitForAsyncUtils.waitForFxEvents;


/**
 * @author Claudio Rosati, European Spallation Source ERIC
 */
public class ThumbWheelEvaluator extends ApplicationTest {

    private static final Logger LOGGER = Logger.getLogger(ThumbWheelEvaluator.class.getName());

    @Override
    public void start( Stage stage ) throws Exception {

        try {

            Parent root = FXMLLoader.load(ThumbWheelEvaluator.class.getResource("/fxml/ThumbWheel.fxml"));
            Scene scene = new Scene(root);

            stage.initStyle(DECORATED);
            stage.setOnCloseRequest(e -> System.exit(0));
            stage.setTitle("Thumb Wheel Evaluator");
            stage.setScene(scene);
            stage.show();

        } catch ( IOException ex ) {
            LOGGER.throwing(getClass().getName(), "start", ex);
            throw ex;
        }

    }

    /**
     * Fake test made to avoid TestFX closing the test window at the end of the
     * tests. Window's close button is the only way to close the application.
     */
    @Test
    public void test() {
        while ( true ) {
            waitForFxEvents();
        }
    }

}
