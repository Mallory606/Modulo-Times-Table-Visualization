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
        int degree = 180/(numDots/2);
        int tempDeg = 0;
        int quarter = 1;

        if(numDots%2 != 0){ numDots += 1; }

        dotList.add(new Dot(1, 0, 200));
        for(int i = 2; i <= numDots; i++){
            if(i == (numDots/2)+1){
                dotList.add(new Dot(i, 400, 200));
                tempDeg = 0;
                quarter++;
            }
            else{
                tempDeg += degree;
                if(tempDeg == 90){
                    if(quarter == 1){ dotList.add(new Dot(i, 200, 0)); }
                    else{ dotList.add(new Dot(i, 200, 400)); }
                }
                else{
                    dotList.add(new Dot(i));
                    if(tempDeg > 90){
                        tempDeg -= 90;
                        quarter++;
                    }
                    if(quarter == 1){
                        dotList.get(i-1).setX(200-(200*Math.cos(tempDeg)));
                        dotList.get(i-1).setY(200-(200*Math.sin(tempDeg)));
                    } else if (quarter == 2){
                        dotList.get(i-1).setX(200+(200*Math.cos(tempDeg)));
                        dotList.get(i-1).setY(200-(200*Math.sin(tempDeg)));
                    } else if (quarter == 3){
                        dotList.get(i-1).setX(200+(200*Math.cos(tempDeg)));
                        dotList.get(i-1).setY(200+(200*Math.sin(tempDeg)));
                    } else{
                        dotList.get(i-1).setX(200-(200*Math.cos(tempDeg)));
                        dotList.get(i-1).setY(200+(200*Math.sin(tempDeg)));
                    }
                }
                System.out.println("Dot #" + i);
                System.out.println("Degree = " + tempDeg);
                System.out.println("x = " + dotList.get(i-1).getX());
                System.out.println("y = " + dotList.get(i-1).getY());
            }
        }
    }

    public double[] getDot(int i){
        return new double[] { dotList.get(i).getX(), dotList.get(i).getY() };
    }
}
