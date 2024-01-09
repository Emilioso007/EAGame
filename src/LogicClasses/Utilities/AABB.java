package LogicClasses.Utilities;

import processing.core.PVector;

public class AABB {
    
    public PVector position;
    public float x;
    public float y;
    public float width;
    public float height;
    
    public AABB(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public boolean contains(float x, float y) {
        
        return (x > this.x && x < this.x + this.width &&
                y > this.y && y < this.y + this.height);

    }
    
    public boolean intersects(AABB other) {
        return (Math.abs(x - other.x) < this.width + other.width &&
                Math.abs(y - other.y) < this.height + other.height);
    }
    
}
