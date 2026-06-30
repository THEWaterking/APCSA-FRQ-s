
public class Telemetry {
    public static double maxEnergy;
    private String hardwareID;
    private Flight activeProf;
    private boolean signalLost;

    public Telemetry(String hardwareID, Flight object){
        this.hardwareID = hardwareID;
        this.activeProf = object;
        signalLost = false;
    }

    public Flight getProfile(){
        return activeProf;
    }

    public boolean isLost(){
        if (signalLost){
            return true;
        }
        return false;
    }

    public void processFlightStep(double localAirDensity){
        if(signalLost){
            return;
        }
        activeProf.applyDrag(localAirDensity);
        double currentEng = activeProf.calcKin();
        if(currentEng > maxEnergy){
            maxEnergy = currentEng;
        }

        if ((activeProf.getVelocity() > 343) && (currentEng > 1000000)){
            signalLost = true;
        }
    }
    }


    