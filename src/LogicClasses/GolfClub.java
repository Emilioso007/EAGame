package LogicClasses;

public class GolfClub {
    
    Ball ball;

    public GolfClub(Ball ball) {
        this.ball = ball;
    }

    public void swing(float angle, float power) {
        ball.velocity.x = (float) (Math.cos(angle) * power);
        ball.velocity.y = (float) (Math.sin(angle) * power);
    }

}
