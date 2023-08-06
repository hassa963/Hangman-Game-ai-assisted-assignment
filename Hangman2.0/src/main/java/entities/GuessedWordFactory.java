package entities;

/** This class creates GuessedWord entity class it can potentially be expanded in the future so that different
 * GuessedWord subclasses can be created */
public class GuessedWordFactory {

    /**This method creates an instance of the GuessedWord class
     * @return returns an instance of the GuessedWord class*/
    public GuessedWord createWord(String word){ return new GuessedWord(word);}}
