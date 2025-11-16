package assignments.boxes.v3;

import assignments.figures.v3.Figure;
import assignments.iface.v3.HasArea;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {

    private static final double DOUBLE_EPS = 1E-6;

    private T contentFirst;

    private V contentSecond;

    public PairBox(T contentFirst, V contentSecond) {
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public V getContentSecond() {
        return contentSecond;
    }

    public void setContentSecond(V contentSecond) {
        this.contentSecond = contentSecond;
    }

    public double getArea() {
        return contentFirst.getArea() + contentSecond.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox) {
        return Math.abs(this.getArea() - pairBox.getArea()) < DOUBLE_EPS;
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBoxOne, PairBox<? extends Figure, ? extends Figure> pairBoxTwo) {
        return Math.abs(pairBoxOne.getArea() - pairBoxTwo.getArea()) < DOUBLE_EPS;
    }
}
