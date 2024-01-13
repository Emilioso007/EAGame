package LogicClasses.Utilities;

public class AABB {
    
    private float x;
    private float y;
    private float width;
    private float height;
    
    public AABB(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(float x, float y) {
        
        return (x > this.x && x < this.x + width &&
                y > this.y && y < this.y + height);

    }
    
    public boolean intersects(AABB other) {
        return (Math.abs(x - other.getX()) < width + other.getWidth() &&
                Math.abs(y - other.getY()) < height + other.getHeight());
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public float getWidth() {
        return width;
    }
    
    public float getHeight() {
        return height;
    }

}
