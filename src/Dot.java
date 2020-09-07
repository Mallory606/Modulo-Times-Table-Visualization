/******************************************************************************
 * Ashley Krattiger                                                           *
 *                                                                            *
 * Dot                                                                        *
 *                                                                            *
 * Class contains all information for a single dot in the Visualization and   *
 * provides access to that information.                                       *
 *****************************************************************************/
public class Dot{
    /**************************************************************************
     * Global Variables:                                                      *
     *                                                                        *
     * x - holds the position of the Dot on the x-axis                        *
     * y - holds the position of the Dot on the y-axis                        *
     *************************************************************************/
    private double x;
    private double y;

    /**************************************************************************
     * Constructor                                                            *
     *                                                                        *
     * Initializes Dot with no arguments                                      *
     *************************************************************************/
    public Dot(){}

    /**************************************************************************
     * Constructor                                                            *
     *                                                                        *
     * Initializes Dot with given x and y values                              *
     *                                                                        *
     * Arguments:                                                             *
     * newX - position on the x-axis                                          *
     * newY - position on the y-axis                                          *
     *************************************************************************/
    public Dot(double newX, double newY){
        x = newX;
        y = newY;
    }

    /**************************************************************************
     * setX()                                                                 *
     *                                                                        *
     * Setter. Updates value of global variable x with given arg x            *
     *************************************************************************/
    public void setX(double x) { this.x = x; }

    /**************************************************************************
     * getX()                                                                 *
     *                                                                        *
     * Getter. Returns value of global variable x                             *
     *************************************************************************/
    public double getX(){ return x; }

    /**************************************************************************
     * setY()                                                                 *
     *                                                                        *
     * Setter. Updates value of global variable y with given arg y            *
     *************************************************************************/
    public void setY(double y) { this.y = y; }

    /**************************************************************************
     * getY()                                                                 *
     *                                                                        *
     * Getter. Returns value of global variable y                             *
     *************************************************************************/
    public double getY(){ return y; }
}
