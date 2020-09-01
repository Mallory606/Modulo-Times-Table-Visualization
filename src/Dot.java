public class Dot{
    private int num;
    private int x;
    private int y;

    public Dot(int newNum){ num = newNum; }

    public Dot(int newNum, int newX, int newY){
        num = newNum;
        x = newX;
        y = newY;
    }

    public int getNum() { return num; }

    public void setX(int x) { this.x = x; }

    public int getX(){ return x; }

    public void setY(int y) { this.y = y; }

    public int getY(){ return y; }
}
