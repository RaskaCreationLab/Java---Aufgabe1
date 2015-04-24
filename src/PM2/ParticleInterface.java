package PM2;

/**
 *
 * @author Marvin
 */
public interface ParticleInterface {

    /**
     * 
     * @param deltaTInSeconds
     */
    void simulateStep(float deltaTInSeconds);
    
    float getXInMeters();

    float getYInMeters();

    float getLevel();
}
