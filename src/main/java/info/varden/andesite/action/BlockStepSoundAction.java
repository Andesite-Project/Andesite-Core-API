/*
 * The MIT License
 *
 * Copyright 2015 Marius.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package info.varden.andesite.action;

import info.varden.andesite.action.base.DataStreamActionWrapper;
import info.varden.andesite.core.Action;
import info.varden.andesite.core.ActionData;
import info.varden.andesite.core.ActionExecutionContext;
import info.varden.andesite.core.BlockAction;
import info.varden.andesite.core.wrapper.StepSoundWrapper;
import info.varden.andesite.io.AndesiteIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Action that sets the sounds when stepping on and breaking blocks.
 * @author Marius
 */
@ActionData(id = 1, version = 1)
public class BlockStepSoundAction extends DataStreamActionWrapper implements Action, BlockAction {
    
    /**
     * The block ID this action applies to.
     */
    private String blockId;
    /**
     * The sound configuration for this block.
     */
    private StepSoundWrapper sound;

    /**
     * Executes the action.
     */
    @Override
    public void execute(ActionExecutionContext context) {
        context.getBlockWrapperFor(blockId).setStepSound(this.sound);
    }

    /**
     * Creates an instance of BlockStepSoundAction from an input stream.
     * @param input The input stream to read from
     * @return An instance of BlockStepSoundAction
     * @throws IOException I/O fails when reading from input
     */
    @Override
    public Action parse(DataInputStream input) throws IOException {
        this.blockId = AndesiteIO.readString(input);
        String soundName = AndesiteIO.readString(input);
        String breakSound = AndesiteIO.readString(input);
        String placeSound = AndesiteIO.readString(input);
        float volume = input.readFloat();
        float freq = input.readFloat();
        this.sound = new StepSoundWrapper(soundName, breakSound, placeSound, volume, freq);
        return this;
    }

    /**
     * Writes this action instance to an output stream.
     * @param output The output stream to write to
     * @throws IOException I/O fails when writing to output
     */
    @Override
    public void write(DataOutputStream output) throws IOException {
        AndesiteIO.writeString(this.blockId, output);
        AndesiteIO.writeString(this.sound.getSoundName(), output);
        AndesiteIO.writeString(this.sound.getBreakSound(), output);
        AndesiteIO.writeString(this.sound.getPlaceSound(), output);
        output.writeFloat(this.sound.getVolume());
        output.writeFloat(this.sound.getFrequency());
    }
    
    /**
     * Creates an instance of BlockStepSoundAction with given parameters.
     * @param blockId The block ID this action should apply to
     * @param soundName The name of the sound to play when stepped on
     * @param volume The volume of the sounds
     * @param freq The frequency of the sounds
     * @return An instance of BlockStepSoundAction
     */
    public static BlockStepSoundAction create(String blockId, String soundName, float volume, float freq) {
        return create(blockId, soundName, soundName, volume, freq);
    }
    
    /**
     * Creates an instance of BlockStepSoundAction with given parameters.
     * @param blockId The block ID this action should apply to
     * @param soundName The name of the sound to play when stepped on
     * @param breakSound The name of the sound to play when broken
     * @param volume The volume of the sounds
     * @param freq The frequency of the sounds
     * @return An instance of BlockStepSoundAction
     */
    public static BlockStepSoundAction create(String blockId, String soundName, String breakSound, float volume, float freq) {
        return create(blockId, soundName, breakSound, breakSound, volume, freq);
    }
    
    /**
     * Creates an instance of BlockStepSoundAction with given parameters.
     * @param blockId The block ID this action should apply to
     * @param soundName The name of the sound to play when stepped on
     * @param breakSound The name of the sound to play when broken
     * @param placeSound The name of the sound to play when placed
     * @param volume The volume of the sounds
     * @param freq The frequency of the sounds
     * @return An instance of BlockStepSoundAction
     */
    public static BlockStepSoundAction create(String blockId, String soundName, String breakSound, String placeSound, float volume, float freq) {
        return create(blockId, new StepSoundWrapper(soundName, breakSound, placeSound, volume, freq));
    }
    
    /**
     * Creates an instance of BlockStepSoundAction with given parameters.
     * @param blockId The block ID this action should apply to
     * @param sound The sound of the block
     * @return 
     */
    public static BlockStepSoundAction create(String blockId, StepSoundWrapper sound) {
        BlockStepSoundAction a = new BlockStepSoundAction();
        a.setBlockId(blockId);
        a.setSound(sound);
        return a;
    }
    
    /**
     * Sets the block ID this action should apply to.
     * @param blockId The block ID to set
     */
    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }
    
    /**
     * Gets the block ID this action applies to.
     * @return The block ID
     */
    @Override
    public String getBlockId() {
        return this.blockId;
    }
    
    /**
     * Sets the sound of the block.
     * @param sound The sound to set
     */
    public void setSound(StepSoundWrapper sound) {
        this.sound = sound;
    }
    
    /**
     * Gets the sound of the block.
     * @return The sound
     */
    public StepSoundWrapper getSound() {
        return this.sound;
    }

}
