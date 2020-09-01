import java.util.ArrayList;
import java.util.List;

public class Visualization{
    private int timesTable;
    private List<Dot> dotList;
    private int numDots;

    public Visualization(int times, int dots){
        timesTable = times;
        numDots = dots;
        setDotList();
    }

    private void setDotList(){
        dotList = new ArrayList<>();
        int degree;
        int tempDeg = 0;
        int quarter = 1;
        double tempX, tempY;

        degree = 180/(numDots/2);
        dotList.add(new Dot(1, 0, 200));
        for(int i = 2; i <= numDots; i++){
            if(i == (numDots/2)+1){
                dotList.add(new Dot(i, 400, 200));
                tempDeg = 0;
                quarter++;
            }
            else{
                tempDeg += degree;
                dotList.add(new Dot(i));
                if(tempDeg > 90){
                    tempDeg -= 90;
                    quarter++;
                }
                tempX = 200*Math.cos(Math.toRadians(tempDeg));
                tempY = 200*Math.sin(Math.toRadians(tempDeg));
                if(quarter == 1){
                    dotList.get(i-1).setX(200 - tempX);
                    dotList.get(i-1).setY(200 - tempY);
                } else if (quarter == 2){
                    dotList.get(i-1).setX(200 + tempY);
                    dotList.get(i-1).setY(200 - tempX);
                } else if (quarter == 3){
                    dotList.get(i-1).setX(200 + tempX);
                    dotList.get(i-1).setY(200 + tempY);
                } else{
                    dotList.get(i-1).setX(200 - tempY);
                    dotList.get(i-1).setY(200 + tempX);
                }
            }
        }
    }

    public double[] getDot(int i){
        return new double[] { dotList.get(i).getX(), dotList.get(i).getY() };
    }
}
