package assignments.figures.v1;

class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        moveTo(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        radius = (int) (radius * ratio);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        return (dx * dx + dy * dy) <= (radius * radius);
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return radius == circle.radius && center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        int result = center.hashCode();
        result = 31 * result + radius;
        return result;
    }
}
