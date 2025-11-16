package assignments.boxes.v3;

import assignments.figures.v3.Figure;
import assignments.iface.v3.HasArea;

public class Box<T extends Figure> implements HasArea {

    private static final double DOUBLE_EPS = 1E-6;

    private T content;

    public Box(T content) {
        super();
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public double getArea() {
        return content.getArea();
    }

    public boolean isAreaEqual(Box<? extends Figure> box) {
        return Math.abs(content.getArea() - box.getArea()) < DOUBLE_EPS;
    }

    public static boolean isAreaEqual(Box<? extends Figure> boxOne, Box<? extends Figure> boxTwo) {
        return Math.abs(boxOne.getArea() - boxTwo.getArea()) < DOUBLE_EPS;
    }

}