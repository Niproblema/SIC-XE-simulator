
import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jan
 */
public class Memory {

    byte[] field;

    public Memory(int k) {
        field = new byte[k];
    }

    public int getByte(int addr) {
        System.out.println("Getting byte: "+ field[addr]);
        return (int) field[addr];
    }

    public void setByte(int addr, int val) throws IllegalAccessException {
        if (addr < 0 || addr >= field.length) {
            throw new IllegalAccessException();
        }
        field[addr] = (byte) val;
        System.out.println("Setting byte: " + Integer.toHexString((byte) val));
    }

    public int getWord(int addr) {
        byte[] temp = new byte[]{field[addr + 2], field[addr + 1], field[addr]};
        ByteBuffer wrap = ByteBuffer.wrap(temp);
        System.out.println("Getting word: " + wrap.getInt());
        return wrap.getInt();
    }

    public void setWord(int addr, int value) throws IllegalAccessException {
        if (addr < 0 || addr >= field.length - 3) {
            throw new IllegalAccessException();
        }
        byte[] inp = ByteBuffer.allocate(3).putInt(value).array();
        field[addr] = inp[0];
        field[addr + 1] = inp[1];
        field[addr + 2] = inp[2];
        System.out.println("Setting word: " + inp.toString()); //https://stackoverflow.com/questions/31750160/get-unsigned-integer-from-byte-array-in-java
    }
    
    //TODO:float
    
}
