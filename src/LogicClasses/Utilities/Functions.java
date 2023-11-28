package LogicClasses.Utilities;

import processing.core.PApplet;
import processing.core.PVector;

public class Functions {

    private Functions() {
    }

    public static boolean intersects(Circle circle, AABB rect) {
        PVector circleDistance = new PVector();

        circleDistance.x = PApplet.abs(circle.getX() - rect.getX());
        circleDistance.y = PApplet.abs(circle.getY() - rect.getY());

        if (circleDistance.x > (rect.getWidth() / 2 + circle.getRadius())) {
            return false;
        }

        if (circleDistance.y > (rect.getHeight() / 2 + circle.getRadius())) {
            return false;
        }

        if (circleDistance.x <= (rect.getWidth() / 2)) {
            return true;
        }
        
        if (circleDistance.y <= (rect.getHeight() / 2)) {
            return true;
        }

        float cornerDistance_sq = PApplet.pow((circleDistance.x - rect.getWidth() / 2), 2) +
                PApplet.pow((circleDistance.y - rect.getHeight() / 2), 2);

        return (cornerDistance_sq <= PApplet.pow(circle.getRadius(), 2));
    }

}
