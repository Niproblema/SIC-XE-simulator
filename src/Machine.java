
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 *
 * @author jan
 */
public class Machine {

    Register A, X, L, B, S, T, F, SW;
    PCRegister PC;
    Register[] indexReg;
    final int MAX_ADDRESS;
    Memory mem;
    Device[] dev;

    public Machine() {
        resetRegisters();
        indexReg = new Register[]{A, X, L, B, S, T, F};

        MAX_ADDRESS = (int) Math.pow(2, 15);
        resetMemory();

        dev = new Device[256];
        dev[0] = new InputDevice(System.in);
        dev[1] = new OutputDevice(System.out);
        dev[2] = new OutputDevice(System.err);

    }

    public void resetRegisters() {
        A = new Register(0);
        X = new Register(0);
        L = new Register(0);
        B = new Register(0);
        S = new Register(0);
        T = new Register(0);
        F = new Register(0.0);
        PC = new PCRegister(0);
        SW = new SWRegister(0);
    }

    public void resetMemory() {
        mem = new Memory(MAX_ADDRESS);
    }

    public Register getReg(int i) {
        if (i >= 0 && i < indexReg.length) {
            return indexReg[i];
        } else {
            return null;
        }
    }

    public Device getDevice(int i) {
        if (i < 0 || i >= dev.length) {
            invalidAddressing();
            return null;
        }
        if (dev[i] == null) {
            dev[i] = new FileDevice(Integer.valueOf(String.valueOf(i), 16) + ".dev");
        }
        return dev[i];
    }

    public void setReg(int i, int val) {
        if (i >= 0 && i < indexReg.length) {
            if (indexReg[i] != null) {
                indexReg[i].setValue(val);
            } else {
                indexReg[i] = new Register(val);
            }
        }
    }

    public void notImplemented(String mnemonic) {
        System.out.println(mnemonic + " not implemented.");
    }

    public void invalidOpcode(int opcode) {
        System.out.println("Op code " + opcode + " not valid");
    }

    public void invalidAddressing() {
        System.out.println("Invalid Addressing");
    }

    public int fetch() {
        int rtn = mem.getByte(PC.getValue().intValue());
        PC.increment();
        return rtn;
    }

    public void setSpeed(int k) {
        mClockSpeed = k;
        Long rate = (long) Math.pow(10, 9) / mClockSpeed;
        System.out.println("Clock time = " + rate);
    }
    public int getSpeed(){
        return mClockSpeed;
    }

    private boolean mKeepRunning = true;
    private int mStep = 0;
    private int mClockSpeed = 100;

    public void start() {
        start(-1);
    }
    Thread th;

    public void start(final int n) {
        mKeepRunning = true;
        Thread th = new Thread("Sic/XE simulation") {
            public void run() {
                for (; mStep != mStep + n && mKeepRunning; mStep++) {
                    Long rate = (long) Math.pow(10, 9) / mClockSpeed;
                    Long cStart = System.nanoTime();
                    execute();
                    Long cEnd = System.nanoTime();
                    Long toWait = rate - (cEnd - cStart) / 1000000;
                    toWait = toWait < 0 ? 0 : toWait;
                    try {
                        Thread.sleep(toWait);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        th.start();
    }

    public void stop() {
        mKeepRunning = false;
    }

    public void execute() {
        int opcode = fetch();
        if (execF1(opcode)) {
            return;
        }
        int operand = fetch();
        if (execF2(opcode, operand)) {
            return;
        }
        int op = opcode >> 2;
        int n = (opcode >> 1) & 1;
        int i = opcode & 1;
        int ni = (n << 1) + i;

        if (execSICF3F4(op, ni, operand)) {
            return;
        }
        invalidAddressing();
    }

    private boolean execF1(int op) {
        switch (op) {
            case Opcode.FIX:
                A.setValue(Math.round(F.getValue().doubleValue()));
                break;
            case Opcode.FLOAT:
                F.setValue(A.getValue().doubleValue());
                break;
            case Opcode.HIO:
                notImplemented("HIO");
                break;
            case Opcode.NORM:
                notImplemented("NORM"); //TODO?
                //F.setValue(Math. F.getValue().doubleValue());
                break;
            case Opcode.SIO:
                notImplemented("SIO");
                break;
            case Opcode.TIO:
                notImplemented("TIO");
                break;

            default:
                return false;
        }
        return true;
    }

    private boolean execF2(int op, int operand) {
        byte[] ops = ByteBuffer.allocate(2).putInt(operand).array();
        Register r1, r2;
        int one, two;
        switch (op) {
            case Opcode.ADDR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                r2.setValue(r2.getValue().intValue() + r1.getValue().intValue());
                break;
            case Opcode.CLEAR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                r1.setValue(0);
                break;
            case Opcode.COMPR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                one = r1.getValue().intValue();
                two = r2.getValue().intValue();

                SW.setValue(one - two);

                break;
            case Opcode.DIVR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                one = r1.getValue().intValue();
                two = r2.getValue().intValue();
                r2.setValue((int) (two / one));
                break;
            case Opcode.MULR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                one = r1.getValue().intValue();
                two = r2.getValue().intValue();
                r2.setValue((int) (two * one));
                break;
            case Opcode.RMO:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                one = r1.getValue().intValue();
                two = r2.getValue().intValue();
                r2.setValue(one);
                r1.setValue(two);
                break;
            case Opcode.SHIFTL:
                r1 = getReg(ops[0]);
                one = r1.getValue().intValue();
                two = ops[1];
                r1.setValue(one << two);

                break;
            case Opcode.SHIFTR:
                r1 = getReg(ops[0]);
                one = r1.getValue().intValue();
                two = ops[1];
                r1.setValue(one >> two);

                break;
            case Opcode.SUBR:
                r1 = getReg(ops[0]);
                r2 = getReg(ops[1]);
                one = r1.getValue().intValue();
                two = r2.getValue().intValue();
                r2.setValue((int) (two - one));

                break;
            case Opcode.SVC:
                notImplemented("SVC"); //TODO

                break;
            case Opcode.TIXR:
                r1 = getReg(ops[0]);
                two = r1.getValue().intValue();
                one = X.getValue().intValue();
                one++;
                X.setValue(one);

                if (one < two) {
                    SW.setValue(-1);
                } else if (one > two) {
                    SW.setValue(1);
                } else {
                    SW.setValue(0);
                }
                break;

            default:
                return false;
        }
        return true;
    }

    private boolean execSICF3F4(int op, int ni, int B2) {
        int x = (B2 >> 7) & 1;
        if (ni == 0) {
            int B3 = fetch();
            int address = ((B2 & 128) << 8) + B3;

            switch (op) {
                case Opcode.ADD:
                    A.setValue(x == 0 ? A.getValue().intValue() + mem.getWord(address) : A.getValue().intValue() + mem.getWord(address + X.getValue().intValue()));
                    break;
                case Opcode.AND:
                    A.setValue((int) (x == 0 ? A.getValue().intValue() & mem.getWord(address) : A.getValue().intValue() & mem.getWord(address + X.getValue().intValue())));
                    break;
                case Opcode.COMP:
                    SW.setValue((int) (x == 0 ? A.getValue().intValue() - mem.getWord(address) : A.getValue().intValue() - mem.getWord(address + X.getValue().intValue())));
                    break;
                case Opcode.DIV:
                    A.setValue((int) (x == 0 ? A.getValue().intValue() / mem.getWord(address) : A.getValue().intValue() / mem.getWord(address + X.getValue().intValue())));
                    break;
                case Opcode.J:
                    PC.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.JEQ:
                    if (SW.getValue().intValue() == 0) {
                        PC.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));
                    }
                    break;
                case Opcode.JGT:
                    if (SW.getValue().intValue() > 0) {
                        PC.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));
                    }

                    break;
                case Opcode.JLT:
                    if (SW.getValue().intValue() < 0) {
                        PC.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));
                    }

                    break;
                case Opcode.JSUB:
                    L.setValue(PC.getValue().intValue());
                    PC.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.LDA:
                    A.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));
                    break;
                case Opcode.LDCH:
                    A.setValue(((A.getValue().intValue() >> 8) << 8) + ((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())) & 0xFF));
                    break;

                case Opcode.LDL:
                    L.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));

                    break;

                case Opcode.LDX:
                    X.setValue((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.MUL:
                    A.setValue((int) (x == 0 ? A.getValue().intValue() * mem.getWord(address) : A.getValue().intValue() * mem.getWord(address + X.getValue().intValue())));

                    break;

                case Opcode.OR:
                    A.setValue((int) (x == 0 ? A.getValue().intValue() | mem.getWord(address) : A.getValue().intValue() | mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.RD:
                    int dev = (int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue()));
                    Device d = getDevice(dev);
                    A.setValue(((A.getValue().intValue() >> 8) << 8) + d.readDevice() & 0xFF);
                    break;
                case Opcode.RSUB:
                    PC.setValue(L.getValue().intValue());
                    break;
                case Opcode.STA:
                    mem.setWord((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())), A.getValue().intValue());
                    break;
                case Opcode.STCH:
                    mem.setByte((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())) + 2, A.getValue().intValue() & 0xFF);

                    break;
                case Opcode.STL:
                    mem.setWord((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())), L.getValue().intValue());

                    break;
                case Opcode.STSW:
                    mem.setWord((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())), SW.getValue().intValue());
                    break;
                case Opcode.STX:
                    mem.setWord((int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue())), X.getValue().intValue());

                    break;
                case Opcode.SUB:
                    A.setValue((int) (x == 0 ? A.getValue().intValue() - mem.getWord(address) : A.getValue().intValue() * mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.TD:
                    int devI = (int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue()));
                    Device dd = getDevice(devI);
                    SW.setValue(dd.test() ? 1 : 0);
                    break;
                case Opcode.TIX:
                    X.setValue(X.getValue().intValue() + 1);
                    SW.setValue((int) (x == 0 ? X.getValue().intValue() - mem.getWord(address) : X.getValue().intValue() - mem.getWord(address + X.getValue().intValue())));

                    break;
                case Opcode.WD:
                    int devic = (int) (x == 0 ? mem.getWord(address) : mem.getWord(address + X.getValue().intValue()));
                    Device ddd = getDevice(devic);
                    ddd.writeDevice((byte) (A.getValue().intValue() & 0xFF));
                    break;
                default:
                    return false;
            }
            return true;

        } else {
            int b = (B2 >> 6) & 1;
            int p = (B2 >> 5) & 1;
            int e = (B2 >> 4) & 1;
            int B3 = fetch();
            int address = ((B2 & 16) << 8) + B3;
            if (e == 1) {
                int B4 = fetch();
                address = (address << 8) + B4;
            }
            if (x == 1) {
                address += X.getValue().intValue();
            }
            if (b == 1 && p == 1) {
                System.out.println("Invalid instruction, wrong b or p bits.");
                return false;
            }
            if (b == 1) {
                address += B.getValue().intValue();
            }
            if (p == 1) {
                address = PC.getValue().intValue() + address;
            }

            switch (op) {
                case Opcode.ADD:
                    A.setValue(mem.getWord(address, ni) + A.getValue().intValue());
                    break;
                case Opcode.ADDF:
                    F.setValue((double) (F.getValue().doubleValue() + mem.getWord(address, ni)));
                    break;
                case Opcode.AND:
                    A.setValue(mem.getWord(address, ni) & A.getValue().intValue());
                    break;
                case Opcode.COMP:
                    SW.setValue((int) (A.getValue().intValue() - mem.getWord(address, ni)));
                    break;
                case Opcode.COMPF:
                    SW.setValue((int) (F.getValue().doubleValue() - mem.getWord(address, ni)));
                    break;
                case Opcode.DIV:
                    A.setValue((int) (A.getValue().intValue() / mem.getWord(address, ni)));
                    break;
                case Opcode.DIVF:
                    F.setValue((double) (F.getValue().doubleValue() / mem.getWord(address, ni)));
                    break;
                case Opcode.J:
                    PC.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.JEQ:
                    if (SW.getValue().intValue() == 0) {
                        PC.setValue(mem.getWord(address, ni));
                    }
                    break;
                case Opcode.JGT:
                    if (SW.getValue().intValue() > 0) {
                        PC.setValue(mem.getWord(address, ni));
                    }
                    break;
                case Opcode.JLT:
                    if (SW.getValue().intValue() < 0) {
                        PC.setValue(mem.getWord(address, ni));
                    }
                    break;
                case Opcode.JSUB:
                    L.setValue(PC.getValue().intValue());
                    PC.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDA:
                    A.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDB:
                    B.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDCH:
                    A.setValue(((A.getValue().intValue() >> 8) << 8) + mem.getWord(address, ni) & 256);
                    break;
                case Opcode.LDF:
                    F.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDL:
                    L.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDS:
                    S.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDT:
                    T.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LDX:
                    X.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.LPS:
                    S.setValue(mem.getWord(address, ni));
                    break;
                case Opcode.MUL:
                    A.setValue((int) (A.getValue().intValue() * mem.getWord(address, ni)));
                    break;
                case Opcode.MULF:
                    F.setValue((double) (F.getValue().doubleValue() * mem.getWord(address, ni)));
                    break;
                case Opcode.OR:
                    A.setValue((int) (A.getValue().intValue() | mem.getWord(address, ni)));
                    break;
                case Opcode.RD:
                    Device d = getDevice(mem.getWord(address, ni));
                    A.setValue(((A.getValue().intValue() >> 8) << 8) + d.readDevice() & 0xFF);
                    break;
                case Opcode.RSUB:
                    PC.setValue(L.getValue().intValue());
                    break;
                case Opcode.SSK:
                    notImplemented("SSK");
                    return false;
                case Opcode.STA:
                    mem.setWord(address, A.getValue().intValue(), ni);
                    break;
                case Opcode.STB:
                    mem.setWord(address, B.getValue().intValue(), ni);
                    break;
                case Opcode.STCH:
                    mem.setByte(mem.getWord(address, ni) + 2, A.getValue().intValue() & 0xFF);
                    break;
                case Opcode.STF:
                    //mem.setWord(address, F.getValue().doubleValue(), ni);
                    //TODO?
                    notImplemented("STF");
                    return false;
                case Opcode.STI:
                    notImplemented("STI");
                    return false;
                case Opcode.STL:
                    mem.setWord(address, L.getValue().intValue(), ni);
                    break;
                case Opcode.STS:
                    mem.setWord(address, S.getValue().intValue(), ni);
                    break;
                case Opcode.STSW:
                    mem.setWord(address, SW.getValue().intValue(), ni);
                    break;
                case Opcode.STT:
                    mem.setWord(address, T.getValue().intValue(), ni);
                    break;
                case Opcode.STX:
                    mem.setWord(address, X.getValue().intValue(), ni);
                    break;
                case Opcode.SUB:
                    A.setValue((int) (A.getValue().intValue() - mem.getWord(address, ni)));
                    break;
                case Opcode.SUBF:
                    F.setValue((double) (F.getValue().doubleValue() - mem.getWord(address, ni)));
                    break;
                case Opcode.TD:
                    Device dd = getDevice(mem.getWord(address, ni));
                    SW.setValue(dd.test() ? 1 : 0);
                    break;
                case Opcode.TIX:
                    T.setValue(T.getValue().intValue() + 1);
                    SW.setValue((int) (T.getValue().intValue() - mem.getWord(address, ni)));
                    break;
                case Opcode.WD:
                    Device ddd = getDevice(mem.getWord(address, ni));
                    ddd.writeDevice((byte) (A.getValue().intValue() & 0xFF));
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

}
