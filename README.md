# Array Sorting Visualizer

## Description
Given an input array of user-determined length and randomly generated integers and a user-chosen sorting algorithm, the program will visually display the progress of the algorithm and then output various attributes of the chosen algorithm, such as time to completion or steps taken.

## Requirements
* JDK version >=17
* JavaFX >=21.0.1
* (Ensure the JDK and JavaFX versions you use are compatible with each other)
* Note that this project was last tested with JDK v17 and JavaFX v21.0.1.

## Setup & Execution
To compile:
```
javac --module-path "Path_to_javafx_lib_folder" --add-modules javafx.controls,javafx.fxml *.java
```

To run:
```
java --module-path "Path_to_javafx_lib_folder" --add-modules javafx.controls,javafx.fxml gui
```