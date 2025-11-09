package assignments.figures.v2;

import assignments.iface.v2.Stretchable;

class Ellipse extends Figure implements Stretchable{
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        if (xAxis <= 0 || yAxis <= 0) throw new IllegalArgumentException("Axes must be positive");
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse() {
        this(1, 1);
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        if (xAxis <= 0) throw new IllegalArgumentException("XAxis must be positive");
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        if (yAxis <= 0) throw new IllegalArgumentException("YAxis must be positive");
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveRel(int dx, int dy) {
        moveTo(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        if (ratio <= 0) throw new IllegalArgumentException("Ratio must be positive");
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        if (xRatio <= 0 || yRatio <= 0) throw new IllegalArgumentException("Ratios must be positive");
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }

    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) / 8);
    }

    public boolean isInside(int x, int y) {
        double normalizedX = (double) (x - center.getX()) / (xAxis / 2.0);
        double normalizedY = (double) (y - center.getY()) / (yAxis / 2.0);
        return (normalizedX * normalizedX + normalizedY * normalizedY) <= 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ellipse ellipse = (Ellipse) obj;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                center.equals(ellipse.center);
    }

    @Override
    public int hashCode() {
        int result = center.hashCode();
        result = 31 * result + xAxis;
        result = 31 * result + yAxis;
        return result;
    }
}
