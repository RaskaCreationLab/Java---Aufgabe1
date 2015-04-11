/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PM2;

/**
 *
 * @author Zujiry
 */
public class Car {
    
    //VARIABLES//
    
    private final double mass;            //kg
    private final double powerPropMax;    //KW
    private final double speedMax;        //km/h
    private final double accEarth = 9.81;
    
    private double pos = 0;             
    private double time;            
    private double speed;
    private double proplevel;
    
    public static Car Porsche() {
        return new Car(1445.0,365.0,420.0);
    }
    
 
    //CONSTRUCTOR//
    
    public Car(double mass_kg, double powerPropMax_kw, double speedMax_kmh) {
        this.mass = mass_kg;
        this.powerPropMax = powerPropMax_kw;
        this.speedMax = speedMax_kmh / 3.6;
    }       
    
    //VOIDS//
    
    public void set(double time, double pos, double speed, double proplevel){
        this.time = time;
        this.pos = pos;
        this.speed = speed;
        this.proplevel = proplevel;
    }
    
    public void step(double deltaTime, double propLevel) {
        speed = speed + (acc() * deltaTime);
        pos = pos + (speed * deltaTime);
        time = time + deltaTime;
        proplevel = propLevel;
    }
    
    public void reset(){
        set(0.0,0.0,0.0,0.0);
    }

    //GETTER//
    
    public double getMass() {
        return mass;
    }

    public double getPowerPropMax() {
        return powerPropMax;
    }

    public double getSpeedMax() {
        return speedMax;
    }

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
        
    public double powerProp() {
        return proplevel * powerPropMax;
    }
    
    public double forcePropMax() {
        return mass * accEarth;
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
        return Math.abs(forcePropMax() / Math.pow(speedMax,3));
    }
    
    public double forceDrag() {
        return dragConst() * Math.pow(speed,2) * -1;
    }
    
    public double force() {
        return forceProp() + forceDrag();
    }
    
    public double acc() {
        return force() / mass;
    }

    
}
