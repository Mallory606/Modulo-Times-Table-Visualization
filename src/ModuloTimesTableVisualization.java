/******************************************************************************
 * Ashley Krattiger                                                           *
 *                                                                            *
 * ModuloTimesTableVisualization                                              *
 *                                                                            *
 * Class contains main, initializes the Display window, and uses a safe exit  *
 * at the end of the program so all threads will be stopped properly.         *
 *****************************************************************************/

public class ModuloTimesTableVisualization{
    /**************************************************************************
     * Main                                                                   *
     *                                                                        *
     * Function initializes Display and closes safely when done.              *
     * Takes command line arguments, returns nothing.                         *
     *                                                                        *
     * Variable:                                                              *
     * window - Display which creates the window in which the visualization   *
     *          runs                                                          *
     *************************************************************************/
    public static void main(String[] args){
        Display window = new Display();
        window.startWindow(args);
        System.exit(0);
    }
}
