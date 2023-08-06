package entities;

/**This is a FigureStrategy that allows the presenter to draw the classic hangman figure */
public class DefaultFigureStrategy implements FigureStrategy {
    int MAXTRIES = 6;
    private final int maxTries; // The maximum number of incorrect guesses to display the hangman figure

    public DefaultFigureStrategy() {this.maxTries = MAXTRIES;}

    /**This method draws the figure based on the number of mistake they have made with a limb being
     * drawn per mistake
     * @param incorrectGuesses this is the number of mistakes they have made*/
    @Override
    public void drawFigure(int incorrectGuesses) {
        int remainingAttempts = maxTries - incorrectGuesses;
        StringBuilder hangmanFigure = new StringBuilder();
        hangmanFigure.append(" _______     \n");
        hangmanFigure.append("|       |    \n");
        switch (remainingAttempts) {
            case 5:
                hangmanFigure.append("|       O    \n");
                break;
            case 4:
                hangmanFigure.append("|       O    \n");
                hangmanFigure.append("|       |    \n");
                break;
            case 3:
                hangmanFigure.append("|       O    \n");
                hangmanFigure.append("|      /|    \n");
                break;
            case 2:
                hangmanFigure.append("|       O    \n");
                hangmanFigure.append("|      /|\\  \n");
                break;
            case 1:
                hangmanFigure.append("|       O    \n");
                hangmanFigure.append("|      /|\\  \n");
                hangmanFigure.append("|      /     \n");
                break;
            case 0:
                hangmanFigure.append("|       O    \n");
                hangmanFigure.append("|      /|\\  \n");
                hangmanFigure.append("|      / \\  \n");
                break;
            default:
                hangmanFigure.append("|            \n");
                break;}
        hangmanFigure.append("|            \n");
        hangmanFigure.append("=============\n");
        System.out.println(hangmanFigure);}

    /**This method returns the number of mistakes the user can make (so the number of mistakes need to draw the full
     * figure
     * @return int number of mistakes user can make*/
    @Override
    public int getMaxAttempts() {return maxTries;}}

