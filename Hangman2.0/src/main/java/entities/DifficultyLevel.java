package entities;
import java.util.*;

/**This class stores the different difficulty levels that the user can choose and can be updated in the future and the
 *difficulty levels contain the word lists the user can use and the figure that will be drawn*/
public enum DifficultyLevel {
    EASY(new DefaultFigureStrategy(), Arrays.asList("apple", "banana", "orange", "grape", "pear")),
    HARD(new DefaultFigureStrategy(),Arrays.asList("cardiovascular", "trachea", "psychedelic", "mitochondria",
            "intravascular", "glandular"));
    private final FigureStrategy figureStrategy;
    private final List<String> wordList;
    private final int maxTries;
    /**The difficulty level contains the word lists that the game chooses from and draw the figure as well as the number
     * of tries they can take.
     * @param figureStrategy this is the figure that can be drawn
     * @param wordList this is the words that can be chosen from in the difficulty level*/
    DifficultyLevel(FigureStrategy figureStrategy, List<String> wordList) {
        this.figureStrategy = figureStrategy;
        this.wordList = wordList;
        this.maxTries = figureStrategy.getMaxAttempts();}

    /**Gets the figure that will be drawn
     * @return  FigureStrategy which is the figure that gets drawn*/
    public FigureStrategy getFigureStrategy() {return figureStrategy;}

    /**This retrieves the word options from the difficulty level
     * @return a list of words that are chosen from*/
    public List<String> getWordList() {return wordList;}

    /**Gets the number of mistakes the user can make in this difficulty level
     * @return returns the number of mistakes the user is allowed to make in this level*/
    public int getMaxTries() {return maxTries;}}

