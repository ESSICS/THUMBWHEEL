# THUMBWHEEL

[![Maven Central](https://img.shields.io/maven-central/v/se.europeanspallationsource/javafx.control.thumbwheel.svg)](https://repo1.maven.org/maven2/se/europeanspallationsource/javafx.control.thumbwheel)
[![javadoc](https://www.javadoc.io/badge/se.europeanspallationsource/javafx.control.thumbwheel.svg)](https://www.javadoc.io/doc/se.europeanspallationsource/javafx.control.thumbwheel)
[![Apache License](https://img.shields.io/badge/license-Apache%20License%202.0-yellow.svg)](http://www.apache.org/licenses/LICENSE-2.0)

A JavaFX thumb-wheel component reproducing the behavior of a mechanical one, where:

- Arrow keys will navigate through the INC/DEC buttons;
- Scroll (mouse wheel or trackpad scroll) when enabled allows to put the cursor over a digit and start scrolling up/down;
- Increment (on top) and decrement (at the bottom) buttons can be coloured differently (e.g. slightly red for increment and slightly blue for decrement);
- Font can be set (e.g. digital one);
- The sign area appears only if minimum is negative. The dash sign when the current value is negative;
- If the current value cannot be represented (e.g. 3 integer digits, maximum equals to 10000, current value set to 1234), `×` is displayed with a different color.

![Thumbwheel Switch](https://github.com/ESSICS/THUMBWHEEL/blob/master/doc/thumbwheel-switch.jpg)

![Thumb Wheel Evaluator](https://github.com/ESSICS/THUMBWHEEL/blob/master/doc/thumbwheel-evaluator.png)

## Maven

To add a dependency on THUMBWHEEL using Maven, use the following:

```xml
<dependency>
    <groupId>se.europeanspallationsource</groupId>
    <artifactId>javafx.control.thumbwheel</artifactId>
    <version>1.0.3</version>
    <scope>compile</scope>
</dependency>
```

