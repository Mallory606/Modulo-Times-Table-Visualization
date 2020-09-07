import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 * Ashley Krattiger                                                           *
 *                                                                            *
 * Visualization                                                              *
 *                                                                            *
 * Class holds the information for the current simulation and sets up the     *
 * position of the dots.                                                      *
 *****************************************************************************/
public class Visualization{
    /**************************************************************************
     * Global Variables:                                                      *
     *                                                                        *
     * dotList - List which holds each Dot needed for the simulation          *
     * numDots - total number of Dots in the simulation. Final because it     *
     *           never changes the value                                      *
     *************************************************************************/
    private List<Dot> dotList;
    private final int numDots;

    /**************************************************************************
     * Constructor                                                            *
     *                                                                        *
     * Initializes global variable numDots and calls setDotList()             *
     *                                                                        *
     * Argument: dots - number of dots in the simulation                      *
     *************************************************************************/
    public Visualization(int dots){
        numDots = dots;
        setDotList();
    }

    /**************************************************************************
     * setDotList()                                                           *
     *                                                                        *
     * Function initializes the dotList and fills with Dots spaced evenly     *
     * around the circle using the trigonometric functions to determine the   *
     * positions. Raw sin and cos results are adjusted manually to match how  *
     * the position will appear on the Display.                               *
     *                                                                        *
     * Takes no arguments, returns nothing.                                   *
     *                                                                        *
     * Variables:                                                             *
     * degree - holds the distance between each point in degrees              *
     * tempDeg - holds the current angle that the point is at with respect to *
     *           the x-axis. If value goes over 90 degrees, it is reduced by  *
     *           90 so all quadrants are treated the same by the sin/cos      *
     *           functions.                                                   *
     * quarter - keeps track of which quadrant of the circle the current Dot  *
     *           is in                                                        *
     * tempX - holds the result of the cos function                           *
     * tempY - holds the result of the sin function                           *
     *************************************************************************/
    private void setDotList(){
        dotList = new ArrayList<>();
        double degree;
        double tempDeg = 0;
        int quarter = 1;
        double tempX, tempY;

        degree = 180/(((double)numDots)/2);
        dotList.add(new Dot(0, 200));
        for(int i = 2; i <= numDots; i++){
            if(i == (numDots/2)+1){
                dotList.add(new Dot(400, 200));
                tempDeg = 0;
                quarter++;
            }
            else{
                tempDeg += degree;
                dotList.add(new Dot());
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

    /**************************************************************************
     * getDot()                                                               *
     *                                                                        *
     * Getter. Returns coordinates stored in Dot from dotList specified by    *
     * arg i.                                                                 *
     **************************************************************************/
    public double[] getDot(int i){
        return new double[] { dotList.get(i).getX(), dotList.get(i).getY() };
    }
}
