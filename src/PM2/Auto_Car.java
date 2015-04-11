
package PM2;

public class Auto_Car {
    public static void main(String[]args) {
        Car Porsche = new Car(1445.0,456.0,330.0);
               
        for(int i = 0; i < 3; i++) {
            Porsche.step(0.01,1.0); 
            System.out.println(
                    "Positon: " +  Porsche.getPos() + 
                    " Geschwindigkeit: " + Porsche.getSpeed() + 
                    " Zeit: " + Porsche.getTime() + 
                    " Pedal: " + Porsche.getProplevel());
     }
    }
}
