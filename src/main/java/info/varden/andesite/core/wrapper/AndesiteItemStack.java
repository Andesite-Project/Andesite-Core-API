/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.varden.andesite.core.wrapper;

import info.varden.andesite.io.AndesiteIO;
import info.varden.andesite.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Andesite Project's wrapper for Minecraft item stacks.
 * @author Marius
 */
public class AndesiteItemStack implements Serializable<AndesiteItemStack> {
    private String id;
    private int amount;
    private int meta;
    // TODO: NBT data
    
    public AndesiteItemStack create(String id, int amount, int meta) {
        AndesiteItemStack stack = new AndesiteItemStack();
        stack.setID(id);
        stack.setAmount(amount);
        stack.setMeta(meta);
        return stack;
    }
    
    public String getID() {
        return this.id;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getMeta() {
        return this.meta;
    }
    
    public void setMeta(int meta) {
        this.meta = meta;
    }

    @Override
    public AndesiteItemStack parse(byte[] data) {
        try {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
            String id = AndesiteIO.readString(dis);
            int amount = dis.readInt();
            int meta = dis.readInt();
            int nbtLength = dis.readInt();
            dis.skip(nbtLength); // TODO: Support this
            return create(id, amount, meta);
        } catch (IOException ex) {
            Logger.getLogger(AndesiteItemStack.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public byte[] toData() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            AndesiteIO.writeString(this.id, dos);
            dos.writeInt(this.amount);
            dos.writeInt(this.meta);
            dos.writeInt(0); // NBT length
            dos.close();
            return baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(AndesiteItemStack.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
