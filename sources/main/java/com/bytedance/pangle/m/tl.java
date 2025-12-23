package com.bytedance.pangle.m;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl implements Closeable {
    private xt[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final FileInputStream f25400j;

    /* renamed from: r, reason: collision with root package name */
    private cw[] f25401r;
    private final Map<String, cw> up = new HashMap();
    private j xt;

    /* renamed from: com.bytedance.pangle.m.tl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class cw {
        public final int ae;
        public final long cw;

        /* renamed from: g, reason: collision with root package name */
        public final long f25402g;

        /* renamed from: j, reason: collision with root package name */
        public final int f25403j;

        /* renamed from: m, reason: collision with root package name */
        public final long f25404m;
        public final long oq;
        public String qv;

        /* renamed from: r, reason: collision with root package name */
        public final long f25405r;
        public final int tl;
        public final long up;
        public final int xt;

        /* synthetic */ cw(ByteBuffer byteBuffer, int i6, AnonymousClass1 anonymousClass1) throws IOException {
            this(byteBuffer, i6);
        }

        private cw(ByteBuffer byteBuffer, int i6) throws IOException {
            if (i6 == 1) {
                this.f25403j = byteBuffer.getInt();
                this.xt = byteBuffer.getInt();
                this.cw = byteBuffer.getInt();
                this.f25405r = byteBuffer.getInt();
                this.up = byteBuffer.getInt();
                this.f25404m = byteBuffer.getInt();
                this.ae = byteBuffer.getInt();
                this.tl = byteBuffer.getInt();
                this.f25402g = byteBuffer.getInt();
                this.oq = byteBuffer.getInt();
            } else {
                if (i6 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i6)));
                }
                this.f25403j = byteBuffer.getInt();
                this.xt = byteBuffer.getInt();
                this.cw = byteBuffer.getLong();
                this.f25405r = byteBuffer.getLong();
                this.up = byteBuffer.getLong();
                this.f25404m = byteBuffer.getLong();
                this.ae = byteBuffer.getInt();
                this.tl = byteBuffer.getInt();
                this.f25402g = byteBuffer.getLong();
                this.oq = byteBuffer.getLong();
            }
            this.qv = null;
        }
    }

    private static class j {
        public final long ae;
        public final short cw;

        /* renamed from: g, reason: collision with root package name */
        public final short f25406g;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f25407j;
        public final short jy;

        /* renamed from: m, reason: collision with root package name */
        public final long f25408m;
        public final short oq;
        public final short qv;

        /* renamed from: r, reason: collision with root package name */
        public final int f25409r;
        public final int tl;
        public final long up;
        public final short vl;
        public final short ws;
        public final short xt;

        /* synthetic */ j(FileChannel fileChannel, AnonymousClass1 anonymousClass1) throws IOException {
            this(fileChannel);
        }

        private j(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.f25407j = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] != Byte.MAX_VALUE || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            tl.xt(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
            tl.xt(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
            ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            tl.xt(fileChannel, allocate, "failed to read rest part of ehdr.");
            this.xt = allocate.getShort();
            this.cw = allocate.getShort();
            int i6 = allocate.getInt();
            this.f25409r = i6;
            tl.xt(i6, 1, 1, "bad elf version: " + i6);
            byte b6 = bArr[4];
            if (b6 == 1) {
                this.up = allocate.getInt();
                this.f25408m = allocate.getInt();
                this.ae = allocate.getInt();
            } else {
                if (b6 != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.up = allocate.getLong();
                this.f25408m = allocate.getLong();
                this.ae = allocate.getLong();
            }
            this.tl = allocate.getInt();
            this.f25406g = allocate.getShort();
            this.oq = allocate.getShort();
            this.qv = allocate.getShort();
            this.vl = allocate.getShort();
            this.jy = allocate.getShort();
            this.ws = allocate.getShort();
        }
    }

    private static class xt {
        public final long ae;
        public final long cw;

        /* renamed from: j, reason: collision with root package name */
        public final int f25410j;

        /* renamed from: m, reason: collision with root package name */
        public final long f25411m;

        /* renamed from: r, reason: collision with root package name */
        public final long f25412r;
        public final long tl;
        public final long up;
        public final int xt;

        /* synthetic */ xt(ByteBuffer byteBuffer, int i6, AnonymousClass1 anonymousClass1) throws IOException {
            this(byteBuffer, i6);
        }

        private xt(ByteBuffer byteBuffer, int i6) throws IOException {
            if (i6 == 1) {
                this.f25410j = byteBuffer.getInt();
                this.cw = byteBuffer.getInt();
                this.f25412r = byteBuffer.getInt();
                this.up = byteBuffer.getInt();
                this.f25411m = byteBuffer.getInt();
                this.ae = byteBuffer.getInt();
                this.xt = byteBuffer.getInt();
                this.tl = byteBuffer.getInt();
                return;
            }
            if (i6 != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i6)));
            }
            this.f25410j = byteBuffer.getInt();
            this.xt = byteBuffer.getInt();
            this.cw = byteBuffer.getLong();
            this.f25412r = byteBuffer.getLong();
            this.up = byteBuffer.getLong();
            this.f25411m = byteBuffer.getLong();
            this.ae = byteBuffer.getLong();
            this.tl = byteBuffer.getLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25400j.close();
        this.up.clear();
        this.cw = null;
        this.f25401r = null;
    }

    private tl(File file) throws IOException {
        ByteOrder byteOrder;
        cw[] cwVarArr;
        AnonymousClass1 anonymousClass1 = null;
        this.xt = null;
        this.cw = null;
        this.f25401r = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f25400j = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.xt = new j(channel, anonymousClass1);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.xt.oq);
        if (this.xt.f25407j[5] == 1) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        allocate.order(byteOrder);
        channel.position(this.xt.f25408m);
        this.cw = new xt[this.xt.qv];
        for (int i6 = 0; i6 < this.cw.length; i6++) {
            xt(channel, allocate, "failed to read phdr.");
            this.cw[i6] = new xt(allocate, this.xt.f25407j[4], anonymousClass1);
        }
        channel.position(this.xt.ae);
        allocate.limit(this.xt.vl);
        this.f25401r = new cw[this.xt.jy];
        int i7 = 0;
        while (true) {
            cwVarArr = this.f25401r;
            if (i7 >= cwVarArr.length) {
                break;
            }
            xt(channel, allocate, "failed to read shdr.");
            this.f25401r[i7] = new cw(allocate, this.xt.f25407j[4], anonymousClass1);
            i7++;
        }
        short s5 = this.xt.ws;
        if (s5 > 0) {
            ByteBuffer j6 = j(cwVarArr[s5]);
            for (cw cwVar : this.f25401r) {
                j6.position(cwVar.f25403j);
                String j7 = j(j6);
                cwVar.qv = j7;
                this.up.put(j7, cwVar);
            }
        }
    }

    public static boolean j(File file) {
        try {
            com.bytedance.pangle.util.ae.j(new tl(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.ae.j((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.ae.j((Closeable) null);
            throw th;
        }
    }

    private static String j(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(int i6, int i7, int i8, String str) throws IOException {
        if (i6 < i7 || i6 > i8) {
            throw new IOException(str);
        }
    }

    private ByteBuffer j(cw cwVar) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) cwVar.f25404m);
        this.f25400j.getChannel().position(cwVar.up);
        xt(this.f25400j.getChannel(), allocate, "failed to read section: " + cwVar.qv);
        return allocate;
    }
}
