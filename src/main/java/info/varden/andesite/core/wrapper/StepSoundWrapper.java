/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.varden.andesite.core.wrapper;

/**
 *
 * @author Marius
 */
public class StepSoundWrapper {
    private String soundName;
    private String breakSound;
    private String placeSound;
    private float volume;
    private float freq;
    
    public StepSoundWrapper(String soundName, String breakSound, String placeSound, float volume, float frequency) {
        this.soundName = soundName;
        this.breakSound = breakSound;
        this.placeSound = placeSound;
        this.volume = volume;
        this.freq = frequency;
    }
    
    public String getSoundName() {
        return this.soundName;
    }
    
    public void setSoundName(String sound) {
        this.soundName = sound;
    }
    
    public String getBreakSound() {
        return this.breakSound;
    }
    
    public void setBreakSound(String sound) {
        this.breakSound = sound;
    }
    
    public String getPlaceSound() {
        return this.placeSound;
    }
    
    public void setPlaceSound(String sound) {
        this.placeSound = sound;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    public void setVolume(float volume) {
        this.volume = volume;
    }
    
    public float getFrequency() {
        return this.freq;
    }
    
    public void setFrequency(float freq) {
        this.freq = freq;
    }
}
