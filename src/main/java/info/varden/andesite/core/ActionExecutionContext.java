/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.varden.andesite.core;

import info.varden.andesite.core.wrapper.BlockWrapper;

/**
 * Mod loader specific context for executing actions.
 * @author Marius
 */
public interface ActionExecutionContext {
    public BlockWrapper getBlockWrapperFor(String block);
}
