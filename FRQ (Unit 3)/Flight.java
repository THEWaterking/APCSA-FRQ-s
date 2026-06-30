
public class Flight {
    private double mass;
    private double velocity;
    private double dragCo;

    public Flight(double mass, double velocity, double dragCo){
        this.mass = mass;
        this.velocity = velocity;
        this.dragCo= dragCo;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getMass(){
        return mass;
    }
    public double getdragCo(){
        return dragCo;
    }
    public double calcKin(){
        return 0.5 * mass*Math.pow(velocity,2);
    }
    public void applyDrag(double airDensity){
        //this.airDensity = airDensity;
        double DF = 0.5 * dragCo *airDensity*Math.pow(velocity,2);
        double deAlc = DF / mass;
        velocity -= deAlc * 0.05;
        if (velocity <=0.0){
            velocity = 0.0;
        }
        
    }

}
