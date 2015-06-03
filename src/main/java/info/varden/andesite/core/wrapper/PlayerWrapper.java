/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.varden.andesite.core.wrapper;

/**
 * The Andesite Project's wrapper for Minecraft players.
 * @author Marius
 */
public interface PlayerWrapper {
    /**
     * Gets the absorption amount of the player.
     * @return Absorption amount.
     */
    public float getAbsorptionAmount();
    
    /**
     * Sets the absorption amount for the player.
     * @param amount The absorption amount to set.
     * @return The PlayerWrapper instance.
     */
    public PlayerWrapper setAbsorptionAmount(float amount);
}
