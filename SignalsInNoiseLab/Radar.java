
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    // volocity and number of times it occurs
    private int[][] accumulator;
    private int[][] newAccumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;
    private int currentLocationRow;
    private int currentLocationCol;
    
    // how much the monster moves
    private int monsterDX;
    private int monsterDY;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        newAccumulator = new int[11][11]; // elements will be set to 0
        accumulator = new int[11][11]; // this holds the totals

        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = (int)(Math.random() * rows);
        monsterLocationCol = (int)(Math.random() * cols);
        currentLocationRow = monsterLocationRow;
        currentLocationCol = monsterLocationCol;
        
        noiseFraction = 0.05;
        numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        //adds the old accumulator to the total
        for(int row = 0; row<currentScan.length;row++)
        {
            for(int col = 0; col<currentScan[0].length;col++)
            {
                accumulator[row][col] += newAccumulator[row][col];
            }
        }
        
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        // detect the monster
        currentLocationRow += monsterDX;
        currentLocationCol += monsterDY;
        currentScan[currentLocationRow][currentLocationCol] = true;
        
        // inject noise into the grid
        injectNoise();
        
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                for(int r = 0; r<currentScan.length;r++)
                {
                    for(int c = 0; c<currentScan[0].length;c++)
                    {
                        if(currentScan[row][col] == true)
                        {
                            accumulator[row][col]++;
                        }
                    }
                }
            }
        }

        // keep track of the total number of scans
        numScans++;
    }
    
    

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int slope()
    {
        int biggestSlope = 0;
        int[] mSlope;
        mSlope = new int[2];
        for(int row = 0; row < accumulator.length; row++)
        {
            for(int col = 0; col < accumulator[0].length; col++)
            {
                if(accumulator[row][col] > biggestSlope)
                {
                    biggestSlope = accumulator[row][col];
                    mSlope[0] = (row -5);
                    mSlope[1] = (col - 5);
                }
            }
        }
        System.out.println(mSlope[0]);
        System.out.println(mSlope[1]);
        return mSlope[];
    }

}
    
