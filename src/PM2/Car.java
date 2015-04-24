package PM2;

    //MIXIN//
    
    import java.text.*;
    import java.awt.event.KeyEvent;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import jgame.JGColor;
    import jgame.platform.JGEngine;



public abstract class Car {
    
    //VARIABLES//

    private final static double accEarth = 9.81;
    private final static double NULLLEVEL = 0.001;
    
    protected final static double meterSec = 3.6;
    protected final static double kwH = 1000;
    
    private double pos = 0;             
    private double time;            
    private double speed;
    private double proplevel;
    
 
    //CONSTRUCTOR//
    
    public Car() {
    } 
    
    //Automat//
    
    Automat automat;
    
    //VOIDS//
    
    public void set(double time, double pos, double speed, double proplevel){
        this.time = time;
        this.pos = pos;
        this.speed = speed;
        this.proplevel = proplevel;
    }
    
    public void step(double deltaTime, double propLevel) {
       // if (speed < NULLLEVEL && proplevel < NULLLEVEL){ 
       //       automat.STOPPED;
       // }else if
        
        speed = speed + (acc() * deltaTime);
        pos = pos + (speed * deltaTime);
        time = time + deltaTime;
        proplevel = propLevel;
    }
    
    public void reset(){
        set(0.0,0.0,0.0,0.0);
    }

    //ABSTRACT//
    
    public abstract double mass();
    public abstract double powerPropMax();
    public abstract double speedMax();

    //GETTER//
    
    public double getAccEarth() {
        return accEarth;
    }

    public double getPos() {
        return pos;
    }

    public double getTime() {
        return time;
    }

    public double getSpeed() {
        return speed;
    }

    public double getProplevel() {
        return proplevel;
    }

    //SETTER//
    
    public void setPos(double pos) {
        this.pos = pos;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setProplevel(double proplevel) {
        this.proplevel = proplevel;
    }
 
    
    //FUNCTIONS//
    @Override
    public String toString() {
      DecimalFormat f = new DecimalFormat("#0.00");
      String text = "Positon: " + f.format(getPos()) + "m" +
                    " Geschwindigkeit: " + f.format(getSpeed()) + "km/h" + 
                    " Zeit: " + f.format(getTime()) + "s" +
                    " Pedal: " + f.format(getProplevel());
      return text;
    }
        
    public double powerProp() {
        return proplevel * powerPropMax();
    }
    
    public double forcePropMax() {
        return mass() * accEarth;
    }
    
    public double forcePropAbs() {
        
       if (speed==0) {
           return forcePropMax();
       }
       return Math.min(forcePropMax(), powerProp() / speed);
    }
    
    public double forceProp() {
        return forcePropAbs() * Math.signum(proplevel);
    }
    
    public double dragConst() {            
        return Math.abs(forcePropMax() / Math.pow(speedMax(),3));
    }
    
    public double forceDrag() {
        return dragConst() * Math.pow(speed,2) * -1;
    }
    
    public double force() {
        return forceProp() + forceDrag();
    }
    
    public double acc() {
        return force() / mass();
    }

    
}
