package LogicClasses;

import LogicClasses.Utilities.AABB;

public class Cell extends AABB{
    
    public int state;

    public Cell(float x, float y, float w, float h, int state){
        super(x, y, w, h);
        this.state = state;
    }

}
