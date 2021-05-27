package animations;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HighlightCell extends AnimationTimer {

    private double opacity = 0;
    private double opacityDirection = 1; // 1 - прибавлять непрозрачность; -1 - убавлять непрозрачность

    private final Rectangle theRectangle;

    private long lastUpdate = 0;

    private final int cellColorR;
    private final int cellColorG;
    private final int cellColorB;

    public HighlightCell(Rectangle rect, int R, int G, int B) {

        this.theRectangle = rect;
        this.cellColorR = R;
        this.cellColorG = G;
        this.cellColorB = B;
    }

    @Override
    public void handle(long now) {

        if (now - lastUpdate >= 1000000) {
            doHandle();
            lastUpdate = now;
        }
    }

    private void doHandle() {

        opacity += 0.1 * opacityDirection;

        // Если непрозрачность увеличивается, но находится в рамках допустимого диапазона (0 <= opacity <= 1)
        if (opacity >= 0 && opacity <= 1 && opacityDirection > 0) {
            theRectangle.setFill(Color.rgb(cellColorR, cellColorG, cellColorB, opacity));
        } else {
            // Если непрозрачность увеличивается, но выходит за рамки допустимого диапазона (opacity >= 1)
            if (opacity >= 1 && opacityDirection > 0) {
                opacity = 1;
                theRectangle.setFill(Color.rgb(cellColorR, cellColorG, cellColorB, opacity));
                opacityDirection = -1; // Теперь мы уменьшаем непрозрачность
            } else {
                // Если непрозрачность уменьшается, но выходит за рамки допустимого диапазона (opacity <= 0)
                if (opacity <= 0 && opacityDirection < 0) {
                    stop();
                    opacity = 1;
                    theRectangle.setFill(Color.rgb(255, 255, 255, opacity));
                }
            }
        }
    }
}
