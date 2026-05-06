# Lab1 - Object-Oriented Programming

**Course:** EIE3320 Java Programming  
**Student:** Lau Wang Chun (21100151d)  
**Software:** BlueJ

## Overview

This lab demonstrates fundamental Object-Oriented Programming (OOP) concepts in Java:

- **Abstract classes** - Creating base classes with unimplemented methods
- **Interfaces** - Defining contracts for behavior
- **Inheritance** - Creating subclasses that extend parent classes
- **Polymorphism** - Treating different shape types uniformly
- **Collections** - Using ArrayList to store multiple objects

## Project Structure

```
lab1/
├── Drawable.java        - Interface with draw() method
├── Shape.java         - Abstract base class for all shapes
├── Circle.java        - Circle implementation
├── Square.java        - Square implementation
├── Rectangle.java    - Rectangle implementation
├── Picture.java      - Collection of shapes (polymorphism demo)
├── Canvas.java       - GUI for graphical drawing
├── ShapeTester.java  - Interactive shape testing program
└── PictureTester.java - Picture collection demo
```

## Classes

### Drawable Interface
- Defines `draw()` method that all drawable objects must implement

### Shape (Abstract Class)
- Base class with abstract methods:
  - `readShape()` - Read shape dimensions from user
  - `computeArea()` - Calculate area
  - `computePerimeter()` - Calculate perimeter
  - `displayShape()` - Display calculated results

### Circle, Square, Rectangle
- Concrete implementations of Shape
- Each has constructors, getters, and computes own area/perimeter
- Implement `draw()` to render on Canvas

### Picture
- Stores multiple shapes in an ArrayList
- `addShape(Shape s)` - Add a shape to the picture
- `computeShape()` - Compute area/perimeter for all shapes
- `listAllShapeTypes()` - Display all shapes
- `listSingleShapeType(String className)` - Display shapes of specific type

### Canvas
- Provides a simple GUI window (300x300) for drawing shapes
- Methods: `getCanvas()`, `draw()`, `setVisible()`

## Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- BlueJ (recommended) or any Java IDE

### Using BlueJ
1. Download BlueJ from https://www.bluej.org
2. Open BlueJ
3. Click **Project > Open Package**
4. Select the `lab1` folder
5. The classes will appear in the class diagram

### Using Command Line
```bash
cd lab1
javac *.java
```

## Running the Programs

### ShapeTester (Interactive)
1. In BlueJ: Right-click ShapeTester → void main(String[])
2. Or via terminal:
   ```bash
   java ShapeTester
   ```

**Menu Options:**
- `c` - Create a Circle (enter radius)
- `s` - Create a Square (enter length)
- `r` - Create a Rectangle (enter length and width)
- `x` - Exit

The program calculates and displays area/perimeter, then draws the shape.

### PictureTester
1. In BlueJ: Right-click PictureTester → void main(String[])
2. Or via terminal:
   ```bash
   java PictureTester
   ```

This creates 6 shapes (2 Squares, 2 Circles, 2 Rectangles), computes their area/perimeter, and lists all results.

## Sample Output (ShapeTester)

```
************************************
*Please choose one the followings: *
*Press 'c' - Circle                *
*Press 's' - Square                *
*Press 'r' - Rectangle             *
*Press 'x' - Exit                  *
************************************
c
Please input the radius:
5
Area of circle = 78.53982
Perimeter of circle = 31.41593

x
End!
```

## Sample Output (PictureTester)

```
Area of square = 4.0
Perimeter of square = 8.0
Area of square = 4.0
Perimeter of square = 8.0
Area of circle = 28.27433
Perimeter of circle = 18.84956
Area of circle = 50.26548
Perimeter of circle = 25.13274
Area of rectangle = 30.0
Perimeter of rectangle = 22.0
Area of rectangle = 56.0
Perimeter of rectangle = 30.0
```

## Key Concepts Demonstrated

| Concept | Example |
|---------|---------|
| Abstract Class | `Shape` |
| Interface | `Drawable` |
| Inheritance | `Circle extends Shape` |
| Polymorphism | `Picture` stores `Shape` objects |
| Encapsulation | Private fields with getters |