public class Rectangle implements Shape {
    public double width, height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double i) {
        this.width = i;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double i) {
        this.height = i;
    }

    @Override
    public double computeArea() {
        return this.width*this.height;
    }
}
