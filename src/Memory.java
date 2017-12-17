
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
        if (addr < 0 || addr >= field.length) {
            System.out.println("Address out of range!");
            return -1;
        }
        //System.out.println("Getting byte: " + field[addr]);
        return ((int) field[addr]) & 0xFF;
    }

    public int getByte(int addr, int niFlag) {
        switch (niFlag) {
            case 1:
                return addr;
            case 2:
                return getByte(getWord(addr));
            case 3:
                return getByte(addr);
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
        //System.out.println("Setting byte: " + Integer.toHexString((byte) val));
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
        if (addr < 0 || addr >= field.length) {
            System.out.println("Address out of range!");
            return -1;
        }        
        return (((int)field[addr] & 0xFF)<<16) |((((int)field[addr+1]) & 0xFF)<<8)| (((int) field[addr+2]) & 0xFF);
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

        setByte(addr, value >> 16);
        setByte(addr + 1, (value & 0x00FF00) >> 8);
        setByte(addr + 2, (value & 0x0000FF ));
        //System.out.println("Setting word: " + Integer.toString(value)); //https://stackoverflow.com/questions/31750160/get-unsigned-integer-from-byte-array-in-java
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
