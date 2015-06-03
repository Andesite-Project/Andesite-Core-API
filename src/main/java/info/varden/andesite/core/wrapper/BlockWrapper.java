/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.varden.andesite.core.wrapper;

import info.varden.andesite.core.BlockBreakSource;
import info.varden.andesite.core.PlayerRequirements;
import info.varden.andesite.core.SilkTouchMode;
import java.util.List;

/**
 * The Andesite Project's wrapper for Minecraft blocks.
 * @author Marius
 */
public interface BlockWrapper {
    public BlockWrapper getFor(String name);
    
    /**
     * Gets the block light level.
     * @return The light level
     */
    public float getLightLevel();
    
    /**
     * Sets the block light level.
     * @param value The light level to set
     * @return The BlockWrapper instance
     */
    public BlockWrapper setLightLevel(float value);
    
    /**
     * Gets the block step sound.
     * @return The step sound
     */
    public StepSoundWrapper getStepSound();
    
    /**
     * Sets the block step sound.
     * @param sound The step sound to set
     * @return The BlockWrapper instance
     */
    public BlockWrapper setStepSound(StepSoundWrapper sound);
    
    /**
     * Gets the block resistance value.
     * @return The resistance value
     */
    public float getResistance();
    
    /**
     * Sets the block resistance value.
     * @param resistance The resistance value to set
     * @return The BlockWrapper instance
     */
    public BlockWrapper setResistance(float resistance);
    
    /**
     * Gets the block hardness.
     * @return The hardness value
     */
    public float getHardness();
    
    /**
     * Sets the block hardness.
     * @param hardness The hardness value
     * @return The BlockWrapper instance
     */
    public BlockWrapper setHardness(float hardness);
    
    /**
     * Gets the block slipperiness.
     * @return The slipperiness value
     */
    public float getSlipperiness();
    
    /**
     * Sets the block slipperiness.
     * @param value The slipperiness value
     * @return The BlockWrapper instance
     */
    public BlockWrapper setSlipperiness(float value);
    
    /**
     * Gets the block particle gravity.
     * @return Particle gravitational force in meters per square second
     */
    public float getParticleGravity();
    
    /**
     * Sets the block particle gravity.
     * @param value Particle gravitational force to set in meters per square second
     * @return The BlockWrapper instance
     */
    public BlockWrapper setParticleGravity(float value);
    
    /**
     * Removes default drops for the block.
     * @return The BlockWrapper instance
     */
    public BlockWrapper removeDefaultDrops();
    
    /**
     * Adds conditional drops to the block.
     * @param mode Required silk touch mode
     * @param source Required block breaking source
     * @param fortuneLevel Required fortune level, or -1 for any level
     * @param items List of item stacks to drop
     * @param dropChance Chance of dropping each item stack
     * @param overrideDrops Whether or not to override existing drops when the given conditions are met
     * @param conditions Requirements for the player if a player broke the block
     * @return The BlockWrapper instance
     */
    public BlockWrapper setConditionalDrops(final SilkTouchMode mode, final BlockBreakSource source, final int fortuneLevel, final List<AndesiteItemStack> items, final float dropChance, final boolean overrideDrops, final PlayerRequirements conditions);
}
