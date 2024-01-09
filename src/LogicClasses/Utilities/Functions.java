package LogicClasses.Utilities;

import processing.core.PApplet;
import processing.core.PVector;

public class Functions {

    private Functions() {
    }

    public static boolean intersects(Circle circle, AABB rect) {

        PVector distance = new PVector();
        PVector circ = circle.position;
        PVector rectPos = new PVector(rect.x + rect.width/2, rect.y + rect.height/2);

        distance.x = Math.abs(circ.x - rectPos.x);
        distance.y = Math.abs(circ.y - rectPos.y);
        if (distance.x > (rect.width/2 + circle.radius)) { return false; }
        if (distance.y > (rect.height/2 + circle.radius)) { return false; }
        if (distance.x <= (rect.width/2)) { return true; } 
        if (distance.y <= (rect.height/2)) { return true; }
        float cDist_sq = (float)(Math.pow((distance.x - rect.width/2),2) + Math.pow((distance.y - rect.height/2),2));
     
        return (cDist_sq <= Math.pow(circle.radius,2));
    }

}
