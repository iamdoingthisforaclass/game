/**
 * 
 */
public class Sound {
    java.applet.AudioClip clip;
    public Sound() {
        try {
            clip = java.applet.Applet.newAudioClip(
                new java.net.URL("file://E:/game/game/sounds/title.wav"));
                //new java.net.URL(address));
        } catch (java.net.MalformedURLException murle) {
            System.out.println(murle);
            System.out.println("test");
        }
    }

    public void playOnce()
    {
        clip.play();
    }

    public void beginLoop() {
        clip.loop();
    }

    public void stop(){
        clip.stop();
    }
}
/*
 * http://www.cs.cmu.edu/~illah/CLASSDOCS/javasound.pdf
 * http://freemusicarchive.org/search/?quicksearch=hydroxytryptophan
 */