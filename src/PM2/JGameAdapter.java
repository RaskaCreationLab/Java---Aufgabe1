package PM2;

import java.util.HashSet;
import java.util.Set;
import jgame.JGPoint;

/**
 * JGameAdapter simplifies access to the JGame engine
 * @author Marvin
 */
public class JGameAdapter {

    private static Set particles = new HashSet<ParticleInterface>();

    private static Engine engine;

    /** Utility class */
    private JGameAdapter() {}

    /** Add particle to simulation - shall be done before starting simulation
     * @param particle Particle to be added
     */
    public static void registerPartikle(ParticleInterface particle){
        particles.add(particle);
    }

    /**
     * Starts JGameEngine
     * @param width in pixels
     * @param height in pixels
     */
    public static void startEngine(int width, int height){
        engine = new Engine(new JGPoint(width, height));
        engine.setParticles(particles);
    }

    public String foo(String bar){
        return null;
    }


}
