package entities;

/**This interface is for the figure that gets drawn in the game, and it is strategy design pattern that can have
 * different ways the figure can be drawn*/
public interface FigureStrategy {

    /**This draws the figure using the number of mistakes they've made
     * @param incorrectGuesses this the number of mistakes the user has made and a portion of picture will get drawn*/
    void drawFigure(int incorrectGuesses);

    /**This returns the number of mistakes needed to draw the full figure
     * @return the number of mistakes that takes to draw the full figure*/
    int getMaxAttempts();}
