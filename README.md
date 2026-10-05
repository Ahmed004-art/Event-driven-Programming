# Java Swing First Individual Assignment

**Student Name:** Ahmed Junior Kamara  
**Class:** DIT1101F
**ID:** 905005337
**Application:** Java Swing Assignment  
**Main Class:** `ClassAssignment`

## Project Description

A simple, interactive Java Swing desktop application created to demonstrate basic GUI components and user interaction, fulfilling the requirements for the first individual Java Swing assignment.

The application perfectly replicates the approved Figma design featuring a clean, professional, academic interface without unnecessary clutter or external frameworks.

## Features

- **Professional UI Layout**: Uses `GridBagLayout` and `BoxLayout` to perfectly center a white content card on a light neutral blue/gray background.
- **Dynamic Interaction**: 
  - **[ Change Text ]**: Changes the main welcome text to "Java Swing Made Simple!"
  - **[ Change Background ]**: Changes the primary window background to a subtle professional peach/orange.
  - **[ Reset ]**: Restores the application to its exact default state.
- **Custom Assets**: Meaningful use of `ImageIcon` for both the application window icon and the centered visual graphic.

## Project Structure

```
project/
├── src/
│   └── ClassAssignment.java
├── assets/
│   └── app_icon.png
├── Wireframes/
│   ├── High Fedelity.png
│   └── Low Fedelity.png
└── README.md
```

## Wireframes
The application was designed based on the approved Figma wireframes included in the `Wireframes/` directory:

- **Low Fidelity Wireframe**: Displays the initial concept and layout structure of the application.
- **High Fidelity Wireframe**: Displays the final approved design, colors, and typography that were meticulously implemented in Java Swing.

## How to Run

1. Open your terminal or command prompt and navigate to this `project` directory.
2. Compile the Java source code:
   ```bash
   javac -d bin src/ClassAssignment.java
   ```
3. Run the application (ensuring `assets` is accessible):
   ```bash
   java -cp bin ClassAssignment
   ```

## Development Requirements Addressed

- Uses core Swing components (`JFrame`, `JPanel`, `JLabel`, `JButton`, `ImageIcon`).
- Single-screen design exactly `800 x 800` pixels.
- Code is heavily documented, intentionally kept simple, and perfectly understandable for a beginner without unnecessary abstraction or helper classes.
