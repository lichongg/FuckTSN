package com.bytedance.pangle.res.j;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: m, reason: collision with root package name */
    private static final Logger f25478m = Logger.getLogger(j.class.getName());
    private final ae cw;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f25479j;

    /* renamed from: r, reason: collision with root package name */
    private final up f25480r;
    private C0390j up;
    private final tl xt;

    private void cw() throws IOException {
        xt(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int readInt = this.cw.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            this.cw.readInt();
            this.cw.skipBytes(256);
        }
        while (qv().f25481j == 513) {
            r();
        }
    }

    private void xt() throws IOException {
        xt(512);
        this.cw.readInt();
        this.cw.skipBytes(256);
        this.cw.j();
        this.cw.j();
        this.cw.j();
        this.cw.j();
        if (this.up.xt == 288 && this.cw.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        vl.j(this.cw);
        vl.j(this.cw);
        qv();
        boolean z5 = true;
        while (z5) {
            short s5 = this.up.f25481j;
            if (s5 == 514) {
                r();
            } else if (s5 != 515) {
                z5 = false;
            } else {
                cw();
            }
        }
    }

    public void j() throws IOException {
        cw(2);
        int readInt = this.cw.readInt();
        vl.j(this.cw);
        qv();
        for (int i6 = 0; i6 < readInt; i6++) {
            xt();
        }
    }

    /* renamed from: com.bytedance.pangle.res.j.j$j, reason: collision with other inner class name */
    public static class C0390j {
        public final int cw;

        /* renamed from: j, reason: collision with root package name */
        public final short f25481j;

        /* renamed from: r, reason: collision with root package name */
        public final int f25482r;
        public final int up;
        public final int xt;

        public C0390j(short s5, int i6, int i7, int i8) {
            this.f25481j = s5;
            this.xt = i6;
            this.cw = i7;
            this.f25482r = i8;
            this.up = i8 + i7;
        }

        public static C0390j j(ae aeVar, up upVar) throws IOException {
            int j6 = upVar.j();
            try {
                return new C0390j(aeVar.readShort(), aeVar.readShort(), aeVar.readInt(), j6);
            } catch (EOFException unused) {
                return new C0390j((short) -1, 0, 0, upVar.j());
            }
        }
    }

    private void ae() throws IOException {
        if (this.cw.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.cw.readShort();
        this.cw.readInt();
        if ((readShort & 1) == 0) {
            g();
        } else {
            tl();
        }
    }

    private void g() throws IOException {
        this.cw.j((short) 8);
        this.cw.j((byte) 0);
        byte readByte = this.cw.readByte();
        int j6 = qv.j(this.cw);
        int readInt = this.cw.readInt();
        if (readByte == 1) {
            qv.j(this.f25479j, readInt, j6, this.xt);
        }
        if (readByte == 2) {
            qv.j(this.f25479j, readInt, j6, this.xt);
        }
    }

    private void m() throws IOException {
        xt(513);
        this.cw.readUnsignedByte();
        this.cw.readByte();
        this.cw.skipBytes(2);
        int readInt = this.cw.readInt();
        int readInt2 = this.cw.readInt();
        oq();
        int i6 = (this.up.f25482r + readInt2) - (readInt * 4);
        if (i6 != this.f25480r.j()) {
            f25478m.warning("Invalid data detected. Skipping: " + (i6 - this.f25480r.j()) + " byte(s)");
            this.cw.skipBytes(i6 - this.f25480r.j());
        }
        int[] j6 = this.cw.j(readInt);
        HashSet hashSet = new HashSet();
        for (int i7 : j6) {
            if (i7 != -1 && !hashSet.contains(Integer.valueOf(i7))) {
                ae();
                hashSet.add(Integer.valueOf(i7));
            }
        }
    }

    private void oq() throws IOException {
        int i6 = 56;
        int readInt = this.cw.readInt();
        int i7 = 28;
        if (readInt < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.cw.readShort();
        this.cw.readShort();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readUnsignedShort();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.readByte();
        this.cw.skipBytes(1);
        this.cw.readShort();
        this.cw.readShort();
        this.cw.readShort();
        this.cw.skipBytes(2);
        if (readInt >= 32) {
            this.cw.readByte();
            this.cw.readByte();
            this.cw.readShort();
            i7 = 32;
        }
        if (readInt >= 36) {
            this.cw.readShort();
            this.cw.readShort();
            i7 = 36;
        }
        if (readInt >= 48) {
            j(4).toCharArray();
            j(8).toCharArray();
            i7 = 48;
        }
        if (readInt >= 52) {
            this.cw.readByte();
            this.cw.readByte();
            this.cw.skipBytes(2);
            i7 = 52;
        }
        if (readInt >= 56) {
            this.cw.skipBytes(4);
        } else {
            i6 = i7;
        }
        int i8 = readInt - 56;
        if (i8 > 0) {
            byte[] bArr = new byte[i8];
            i6 += i8;
            this.cw.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f25478m.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f25478m.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
            }
        }
        int i9 = readInt - i6;
        if (i9 > 0) {
            this.cw.skipBytes(i9);
        }
    }

    private C0390j qv() throws IOException {
        C0390j j6 = C0390j.j(this.cw, this.f25480r);
        this.up = j6;
        return j6;
    }

    private void tl() throws IOException {
        int j6 = qv.j(this.cw);
        qv.j(this.f25479j, this.cw.readInt(), j6, this.xt);
        int readInt = this.cw.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            int j7 = qv.j(this.cw);
            qv.j(this.f25479j, this.cw.readInt(), j7, this.xt);
            g();
        }
    }

    private void up() throws IOException {
        xt(514);
        this.cw.readUnsignedByte();
        this.cw.skipBytes(3);
        this.cw.skipBytes(this.cw.readInt() * 4);
    }

    public j(byte[] bArr, tl tlVar) {
        up upVar = new up(new ByteArrayInputStream(bArr));
        this.f25480r = upVar;
        this.cw = new ae(new g(upVar));
        this.f25479j = bArr;
        this.xt = tlVar;
    }

    private void r() throws IOException {
        up();
        short s5 = qv().f25481j;
        while (s5 == 514) {
            up();
            s5 = qv().f25481j;
        }
        while (s5 == 513) {
            m();
            if (this.f25480r.j() < this.up.up) {
                f25478m.warning("Unknown data detected. Skipping: " + (this.up.up - this.f25480r.j()) + " byte(s)");
                up upVar = this.f25480r;
                upVar.skip((long) (this.up.up - upVar.j()));
            }
            s5 = qv().f25481j;
        }
    }

    private String j(int i6) throws IOException {
        int i7;
        short s5;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i7 = i6 - 1;
            if (i6 == 0 || this.cw.readByte() == 0) {
                break;
            }
            sb.append((char) s5);
            i6 = i7;
        }
        this.cw.skipBytes(i7);
        return sb.toString();
    }

    private void cw(int i6) throws IOException {
        qv();
        xt(i6);
    }

    private void xt(int i6) {
        if (this.up.f25481j != i6) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i6), Short.valueOf(this.up.f25481j)));
        }
    }
}
