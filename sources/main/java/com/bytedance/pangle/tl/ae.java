package com.bytedance.pangle.tl;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
abstract class ae {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f25513j = new byte[8];

    /* renamed from: com.bytedance.pangle.tl.ae$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class xt implements oq {
        private final MessageDigest cw;

        /* renamed from: j, reason: collision with root package name */
        private int f25515j;

        /* renamed from: r, reason: collision with root package name */
        private final byte[] f25516r;
        private final byte[] up;
        private final ByteBuffer xt;

        /* synthetic */ xt(byte[] bArr, ByteBuffer byteBuffer, AnonymousClass1 anonymousClass1) throws NoSuchAlgorithmException {
            this(bArr, byteBuffer);
        }

        private xt(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.f25516r = new byte[32];
            this.up = bArr;
            this.xt = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.cw = messageDigest;
            messageDigest.update(bArr);
            this.f25515j = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xt() {
            int position = this.xt.position() % 4096;
            if (position == 0) {
                return;
            }
            this.xt.put(ByteBuffer.allocate(4096 - position));
        }

        @Override // com.bytedance.pangle.tl.oq
        public void j(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.f25515j);
                byteBuffer.limit(byteBuffer.position() + min);
                this.cw.update(byteBuffer);
                remaining -= min;
                int i6 = this.f25515j + min;
                this.f25515j = i6;
                if (i6 == 4096) {
                    MessageDigest messageDigest = this.cw;
                    byte[] bArr = this.f25516r;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.xt.put(this.f25516r);
                    this.cw.update(this.up);
                    this.f25515j = 0;
                }
            }
        }

        public void j() throws DigestException {
            if (this.f25515j == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f25515j);
        }
    }

    static j j(RandomAccessFile randomAccessFile, jy jyVar, g gVar) throws IOException, SecurityException, NoSuchAlgorithmException, DigestException {
        int i6 = xt(randomAccessFile.length() - (jyVar.cw - jyVar.xt))[r0.length - 1];
        int i7 = i6 + 4096;
        ByteBuffer j6 = gVar.j(i7);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        j6.order(byteOrder);
        ByteBuffer j7 = j(j6, 0, i6);
        int i8 = i6 + 64;
        ByteBuffer j8 = j(j6, i6, i8);
        ByteBuffer j9 = j(j6, i8, i7);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        j(randomAccessFile, jyVar, j7, wrap, j8, j9);
        j6.position(i8 + j9.limit());
        j6.putInt(j9.limit() + 68);
        j6.flip();
        return new j(j6, bArr);
    }

    static class j {

        /* renamed from: j, reason: collision with root package name */
        public final ByteBuffer f25514j;
        public final byte[] xt;

        j(ByteBuffer byteBuffer, byte[] bArr) {
            this.f25514j = byteBuffer;
            this.xt = bArr;
        }
    }

    private static int[] xt(long j6) {
        ArrayList arrayList = new ArrayList();
        do {
            j6 = j(j6, 4096L) * 32;
            arrayList.add(Long.valueOf(j(j6, 4096L) * 4096));
        } while (j6 > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i6 = 0;
        iArr[0] = 0;
        while (i6 < arrayList.size()) {
            int i7 = i6 + 1;
            iArr[i7] = iArr[i6] + j(((Long) arrayList.get((arrayList.size() - i6) - 1)).longValue());
            i6 = i7;
        }
        return iArr;
    }

    private static void j(RandomAccessFile randomAccessFile, jy jyVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws IOException, NoSuchAlgorithmException, DigestException {
        j(jyVar);
        long j6 = jyVar.cw - jyVar.xt;
        int[] xt2 = xt(randomAccessFile.length() - j6);
        if (byteBuffer != null) {
            byte[] j7 = j(randomAccessFile, jyVar, f25513j, xt2, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(j7);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            j(byteBuffer3, randomAccessFile.length(), xt2.length - 1, f25513j);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            j(byteBuffer4, jyVar.xt, j6, jyVar.f25527r);
        }
    }

    private static void j(oq oqVar, qv qvVar, int i6) throws IOException, DigestException {
        long j6 = qvVar.j();
        long j7 = 0;
        while (j6 > 0) {
            int min = (int) Math.min(j6, i6);
            qvVar.j(oqVar, j7, min);
            long j8 = min;
            j7 += j8;
            j6 -= j8;
        }
    }

    private static void j(RandomAccessFile randomAccessFile, jy jyVar, byte[] bArr, ByteBuffer byteBuffer) throws IOException, NoSuchAlgorithmException, DigestException {
        xt xtVar = new xt(bArr, byteBuffer, null);
        j(xtVar, new vl(randomAccessFile.getFD(), 0L, jyVar.xt), 1048576);
        long j6 = jyVar.f25527r;
        FileDescriptor fd = randomAccessFile.getFD();
        long j7 = jyVar.cw;
        j(xtVar, new vl(fd, j7, (16 + j6) - j7), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(j(jyVar.xt));
        order.flip();
        xtVar.j(order);
        long j8 = j6 + 20;
        j(xtVar, new vl(randomAccessFile.getFD(), j8, randomAccessFile.length() - j8), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            xtVar.j(ByteBuffer.allocate(4096 - length));
        }
        xtVar.j();
        xtVar.xt();
    }

    private static byte[] j(RandomAccessFile randomAccessFile, jy jyVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws IOException, NoSuchAlgorithmException, DigestException {
        j(randomAccessFile, jyVar, bArr, j(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            AnonymousClass1 anonymousClass1 = null;
            if (length >= 0) {
                int i6 = length + 1;
                ByteBuffer j6 = j(byteBuffer, iArr[i6], iArr[length + 2]);
                ByteBuffer j7 = j(byteBuffer, iArr[length], iArr[i6]);
                tl tlVar = new tl(j6);
                xt xtVar = new xt(bArr, j7, anonymousClass1);
                j(xtVar, tlVar, 4096);
                xtVar.j();
                xtVar.xt();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                xt xtVar2 = new xt(bArr, ByteBuffer.wrap(bArr2), anonymousClass1);
                xtVar2.j(j(byteBuffer, 0, 4096));
                xtVar2.j();
                return bArr2;
            }
        }
    }

    private static ByteBuffer j(ByteBuffer byteBuffer, long j6, int i6, byte[] bArr) {
        if (bArr.length == 8) {
            byteBuffer.put("TrueBrew".getBytes());
            byteBuffer.put((byte) 1);
            byteBuffer.put((byte) 0);
            byteBuffer.put((byte) 12);
            byteBuffer.put((byte) 7);
            byteBuffer.putShort((short) 1);
            byteBuffer.putShort((short) 1);
            byteBuffer.putInt(0);
            byteBuffer.putInt(0);
            byteBuffer.putLong(j6);
            byteBuffer.put((byte) 2);
            byteBuffer.put((byte) 0);
            byteBuffer.put(bArr);
            j(byteBuffer, 22);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static ByteBuffer j(ByteBuffer byteBuffer, long j6, long j7, long j8) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        j(byteBuffer, 2);
        byteBuffer.putLong(j6);
        byteBuffer.putLong(j7);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        j(byteBuffer, 2);
        byteBuffer.putLong(j8 + 16);
        byteBuffer.putInt(j(j6));
        j(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void j(jy jyVar) {
        long j6 = jyVar.xt;
        if (j6 % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + jyVar.xt);
        }
        if ((jyVar.cw - j6) % 4096 == 0) {
            return;
        }
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (jyVar.cw - jyVar.xt));
    }

    private static ByteBuffer j(ByteBuffer byteBuffer, int i6, int i7) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i7);
        duplicate.position(i6);
        return duplicate.slice();
    }

    private static void j(ByteBuffer byteBuffer, int i6) {
        byteBuffer.position(byteBuffer.position() + i6);
    }

    private static long j(long j6, long j7) {
        return ((j6 + j7) - 1) / j7;
    }

    public static int j(long j6) {
        int i6 = (int) j6;
        if (i6 == j6) {
            return i6;
        }
        throw new ArithmeticException("integer overflow");
    }
}
