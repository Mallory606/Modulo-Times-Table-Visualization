public class Dot{
    private int num;
    private double x;
    private double y;

    public Dot(int newNum){ num = newNum; }

    public Dot(int newNum, double newX, double newY){
        num = newNum;
        x = newX;
        y = newY;
    }

    public int getNum() { return num; }

    public void setX(double x) { this.x = x; }

    public double getX(){ return x; }

    public void setY(double y) { this.y = y; }

    public double getY(){ return y; }
}
