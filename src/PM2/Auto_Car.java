
package PM2;

public class Auto_Car {
    public static void main(String[]args) {
        Window window = Window.valueOf(800, 600);
        Porsche porsche = new Porsche();
               
        for(int i = 0; i < 10; i++) {
            porsche.step(10,1.0); 
            System.out.println(porsche.toString());
     }
    }
}
