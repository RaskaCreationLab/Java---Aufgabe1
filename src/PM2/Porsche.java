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
public class Porsche extends Car{
    
    private static final double mass_kg = 1445.0;
    private static final double speedMax_kmh = 330.0 / meterSec;
    private static final double powerPropMax_kw = 456.0 * kwH;
    
    public Porsche(){
        super();
    }
    
    @Override
    public double mass(){
        return mass_kg;
    }
    
    @Override
    public double powerPropMax(){
        return powerPropMax_kw;
    }
    
    @Override
    public double speedMax(){
        return speedMax_kmh;
    }
}
