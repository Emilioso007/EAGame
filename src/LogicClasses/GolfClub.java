package LogicClasses;

public class GolfClub {
    
    Ball ball;

    int swings = 0;

    public GolfClub(Ball ball) {
        this.ball = ball;
    }

    public void swing(float angle, float power) {
        ball.velocity.x = (float) (Math.cos(angle) * power);
        ball.velocity.y = (float) (Math.sin(angle) * power);
        swings++;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public int getSwings() {
        return swings;
    }

}
