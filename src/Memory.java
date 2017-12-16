
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
        System.out.println("Getting byte: " + field[addr]);
        return (int) field[addr] & 0xFF;
    }

    public int getByte(int addr, int niFlag) {
        switch (niFlag) {
            case 1:
                return addr & 0xFF;
            case 2:
                return getByte(getWord(addr)) & 0xFF;
            case 3:
                return getByte(addr) & 0xFF;
            default:
                System.out.println("Error parsing ni in memory");
                return -1;
        }
    }

    public void setByte(int addr, int val) {
        if (addr < 0 || addr >= field.length) {
            System.out.println("Address out of range!");
            return;
        }
        field[addr] = (byte) (val & 0xFF);
        System.out.println("Setting byte: " + Integer.toHexString((byte) val));
    }

    public void setByte(int addr, int value, int niFlag) {
        switch (niFlag) {
            case 1:
                System.out.println("Seting value to direct value?");
                return;
            case 2:
                addr = getWord(addr);
                break;
            case 3:
                addr = addr;
                break;
            default:
                System.out.println("Error parsing ni in memory");
        }
        setByte(addr, value);
    }

    public int getWord(int addr) {
        byte[] temp = new byte[]{field[addr + 2], field[addr + 1], field[addr]};
        ByteBuffer wrap = ByteBuffer.wrap(temp);
        System.out.println("Getting word: " + wrap.getInt());
        return wrap.getInt();
    }

    public int getWord(int addr, int niFlag) {
        switch (niFlag) {
            case 1:
                return addr;
            case 2:
                return getWord(getWord(addr));
            case 3:
                return getWord(addr);
            default:
                System.out.println("Error parsing ni in memory");
                return -1;
        }
    }

    public void setWord(int addr, int value) {
        value = value & 0xFFFFFF;
        if (addr < 0 || addr >= field.length - 3) {
            System.out.println("Address out of range!");
            return;
        }
        byte[] inp = ByteBuffer.allocate(3).putInt(value).array();
        field[addr] = inp[0];
        field[addr + 1] = inp[1];
        field[addr + 2] = inp[2];
        System.out.println("Setting word: " + inp.toString()); //https://stackoverflow.com/questions/31750160/get-unsigned-integer-from-byte-array-in-java
    }

    public void setWord(int addr, int value, int niFlag) {
        switch (niFlag) {
            case 1:
                System.out.println("Seting value to direct value?");
                return;
            case 2:
                addr = getWord(addr);
                break;
            case 3:
                addr = addr;
                break;
            default:
                System.out.println("Error parsing ni in memory");
        }
        setWord(addr, value);
    }

    //TODO:float
}
