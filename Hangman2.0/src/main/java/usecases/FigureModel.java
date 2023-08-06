package usecases;
import entities.FigureStrategy;

/**This is a data transfer model that is used to transfer the figure that will be displayed to the presenter, so it
 * stores the FigureStrategy*/
public class FigureModel{
    private final FigureStrategy figure;
    public FigureModel(FigureStrategy figure){this.figure = figure;}

    /**This presents the figure that will be drawn based on the number of mistakes the user made
     * @param  tries this the number of mistakes the user made and will draw the figure*/
    public void getFigure(int tries){figure.drawFigure(tries);}}