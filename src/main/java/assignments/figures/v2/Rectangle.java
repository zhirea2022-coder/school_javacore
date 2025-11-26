package assignments.figures.v2;

import assignments.iface.v2.Stretchable;

class Rectangle extends Figure implements Stretchable {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this.topLeft = new Point(0, -20);
        this.bottomRight = new Point(10, 0);
    }

    public Rectangle() {
        this.topLeft = new Point(0, -1);
        this.bottomRight = new Point(1, 0);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.topLeft = new Point(x, y);
        this.bottomRight = new Point(x + length, y + width);
    }

    public void moveRel(int dx, int dy) {
        moveTo(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        int length = (int) (getLength() * ratio);
        int width = (int) (getWidth() * ratio);
        this.bottomRight = new Point(topLeft.getX() + length, topLeft.getY() + width);
    }

    public void stretch(double xRatio, double yRatio) {
        int length = (int) (getLength() * xRatio);
        int width = (int) (getWidth() * yRatio);
        this.bottomRight = new Point(topLeft.getX() + length, topLeft.getY() + width);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return (x >= topLeft.getX() && x <= bottomRight.getX() && y >= topLeft.getY() && y <= bottomRight.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return !(bottomRight.getX() < rectangle.topLeft.getX() ||
                topLeft.getX() > rectangle.bottomRight.getX() ||
                bottomRight.getY() < rectangle.topLeft.getY() ||
                topLeft.getY() > rectangle.bottomRight.getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.topLeft) && isInside(rectangle.bottomRight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return topLeft.equals(rectangle.topLeft) && bottomRight.equals(rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        int result = topLeft.hashCode();
        result = 31 * result + bottomRight.hashCode();
        return result;
    }
}
