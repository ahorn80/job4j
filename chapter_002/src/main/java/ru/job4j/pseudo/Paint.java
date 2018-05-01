package ru.job4j.pseudo;

public class Paint {
    /**
     * method draws text representation for given shape object
     * @param shape shape to draw
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * mein method
     * @param args args
     */
    public static void main(String[] args) {
        Shape[] figures = new Shape[] {new Triangle(), new Square()};
        for (Shape current: figures) {
            new Paint().draw(current);
        }
    }
}
