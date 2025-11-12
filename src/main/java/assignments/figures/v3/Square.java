package assignments.figures.v3;

class Square extends Figure {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        this.topLeft = new Point(0, -10);
        this.size = size;
    }

    public Square() {
        this.topLeft = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        this.topLeft = new Point(x, y);
    }

    public void moveRel(int dx, int dy) {
        moveTo(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        return (x >= topLeft.getX() && x <= topLeft.getX() + size &&
                y >= topLeft.getY() && y <= topLeft.getY() + size);
    }

    public boolean isIntersects(Square square) {
        return !(getBottomRight().getX() < square.topLeft.getX() ||
                topLeft.getX() > square.getBottomRight().getX() ||
                getBottomRight().getY() < square.topLeft.getY() ||
                topLeft.getY() > square.getBottomRight().getY());
    }

    public boolean isInside(Square square) {
        return isInside(square.topLeft) &&
                isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Square square = (Square) obj;
        return size == square.size && topLeft.equals(square.topLeft);
    }

    @Override
    public int hashCode() {
        int result = topLeft.hashCode();
        result = 31 * result + size;
        return result;
    }
}
