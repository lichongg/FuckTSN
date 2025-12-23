package com.bytedance.pangle.tl;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
final class m {

    /* renamed from: j, reason: collision with root package name */
    static final HashMap<String, SparseArray<jy>> f25528j = new HashMap<>();

    static String cw(int i6) {
        if (i6 == 513 || i6 == 514) {
            return "EC";
        }
        if (i6 == 769) {
            return "DSA";
        }
        if (i6 == 1057) {
            return "RSA";
        }
        if (i6 == 1059) {
            return "EC";
        }
        if (i6 == 1061) {
            return "DSA";
        }
        switch (i6) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i6));
        }
    }

    @RequiresApi(api = 21)
    static void j(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, jy jyVar) throws SecurityException {
        boolean z5 = true;
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z6 = false;
        if (!arrayMap.isEmpty()) {
            try {
                j(arrayMap, randomAccessFile.getFD(), jyVar);
                z5 = false;
            } catch (IOException e6) {
                throw new SecurityException("Cannot get FD", e6);
            }
        }
        if (map.containsKey(3)) {
            j(map.get(3), randomAccessFile, jyVar);
        } else {
            z6 = z5;
        }
        if (z6) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static int up(int i6) {
        if (i6 == 1) {
            return 32;
        }
        if (i6 == 2) {
            return 64;
        }
        if (i6 == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i6)));
    }

    private static int xt(int i6, int i7) {
        if (i6 == 1) {
            if (i7 == 1) {
                return 0;
            }
            if (i7 == 2 || i7 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i7)));
        }
        if (i6 == 2) {
            if (i7 != 1) {
                if (i7 == 2) {
                    return 0;
                }
                if (i7 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i7)));
                }
            }
            return 1;
        }
        if (i6 != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i6)));
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            return -1;
        }
        if (i7 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i7)));
    }

    private static class j implements oq {

        /* renamed from: j, reason: collision with root package name */
        private final MessageDigest[] f25529j;

        j(MessageDigest[] messageDigestArr) {
            this.f25529j = messageDigestArr;
        }

        @Override // com.bytedance.pangle.tl.oq
        public void j(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.f25529j) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> r(int i6) {
        if (i6 != 513) {
            if (i6 == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i6 != 769) {
                if (i6 != 1057) {
                    if (i6 != 1059) {
                        if (i6 != 1061) {
                            switch (i6) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i6));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static void cw(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static String xt(int i6) {
        if (i6 == 1) {
            return "SHA-256";
        }
        if (i6 == 2) {
            return "SHA-512";
        }
        if (i6 != 3) {
            throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i6)));
        }
        return "SHA-256";
    }

    static byte[] xt(ByteBuffer byteBuffer) throws IOException {
        int i6 = byteBuffer.getInt();
        if (i6 >= 0) {
            if (i6 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i6];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i6 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void j(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, jy jyVar) throws SecurityException {
        vl vlVar = new vl(fileDescriptor, 0L, jyVar.xt);
        long j6 = jyVar.cw;
        vl vlVar2 = new vl(fileDescriptor, j6, jyVar.f25527r - j6);
        ByteBuffer duplicate = jyVar.up.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        mi.j(duplicate, jyVar.xt);
        tl tlVar = new tl(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        try {
            byte[][] j7 = j(iArr, new qv[]{vlVar, vlVar2, tlVar});
            for (int i7 = 0; i7 < size; i7++) {
                int i8 = iArr[i7];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i8)), j7[i7])) {
                    throw new SecurityException(xt(i8) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e6) {
            throw new SecurityException("Failed to compute digest(s) of contents", e6);
        }
    }

    private static byte[][] j(int[] iArr, qv[] qvVarArr) throws DigestException {
        qv[] qvVarArr2 = qvVarArr;
        long j6 = 0;
        for (qv qvVar : qvVarArr2) {
            j6 += j(qvVar.j());
        }
        if (j6 < 2097151) {
            int i6 = (int) j6;
            byte[][] bArr = new byte[iArr.length][];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                byte[] bArr2 = new byte[(up(iArr[i7]) * i6) + 5];
                bArr2[0] = 90;
                j(i6, bArr2, 1);
                bArr[i7] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i8 = 0; i8 < iArr.length; i8++) {
                String xt = xt(iArr[i8]);
                try {
                    messageDigestArr[i8] = MessageDigest.getInstance(xt);
                } catch (NoSuchAlgorithmException e6) {
                    throw new RuntimeException(xt + " digest not supported", e6);
                }
            }
            j jVar = new j(messageDigestArr);
            int length2 = qvVarArr2.length;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i9 < length2) {
                qv qvVar2 = qvVarArr2[i9];
                byte[][] bArr4 = bArr;
                long j7 = qvVar2.j();
                int i12 = i11;
                long j8 = 0;
                while (j7 > 0) {
                    int min = (int) Math.min(j7, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                    j(min, bArr3, 1);
                    for (int i13 = 0; i13 < length; i13++) {
                        messageDigestArr[i13].update(bArr3);
                    }
                    byte[] bArr5 = bArr3;
                    long j9 = j8;
                    try {
                        qvVar2.j(jVar, j9, min);
                        int i14 = 0;
                        while (i14 < iArr.length) {
                            int i15 = iArr[i14];
                            byte[] bArr6 = bArr4[i14];
                            int up = up(i15);
                            qv qvVar3 = qvVar2;
                            MessageDigest messageDigest = messageDigestArr[i14];
                            long j10 = j7;
                            int digest = messageDigest.digest(bArr6, (i12 * up) + 5, up);
                            if (digest != up) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i14++;
                            qvVar2 = qvVar3;
                            j7 = j10;
                        }
                        long j11 = min;
                        j8 = j9 + j11;
                        j7 -= j11;
                        i12++;
                        bArr3 = bArr5;
                    } catch (IOException e7) {
                        throw new DigestException("Failed to digest chunk #" + i12 + " of section #" + i10, e7);
                    }
                }
                i10++;
                i9++;
                qvVarArr2 = qvVarArr;
                i11 = i12;
                bArr = bArr4;
            }
            byte[][] bArr7 = bArr;
            byte[][] bArr8 = new byte[iArr.length][];
            for (int i16 = 0; i16 < iArr.length; i16++) {
                int i17 = iArr[i16];
                byte[] bArr9 = bArr7[i16];
                String xt2 = xt(i17);
                try {
                    bArr8[i16] = MessageDigest.getInstance(xt2).digest(bArr9);
                } catch (NoSuchAlgorithmException e8) {
                    throw new RuntimeException(xt2 + " digest not supported", e8);
                }
            }
            return bArr8;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(j6)));
    }

    static byte[] j(byte[] bArr, long j6, jy jyVar) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j6 - (jyVar.cw - jyVar.xt)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    private static void j(byte[] bArr, RandomAccessFile randomAccessFile, jy jyVar) throws SecurityException {
        try {
            if (Arrays.equals(j(bArr, randomAccessFile.length(), jyVar), ae.j(randomAccessFile, jyVar, new g() { // from class: com.bytedance.pangle.tl.m.1
                @Override // com.bytedance.pangle.tl.g
                public ByteBuffer j(int i6) {
                    return ByteBuffer.allocate(i6);
                }
            }).xt)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e6) {
            throw new SecurityException("Error during verification", e6);
        }
    }

    static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile) throws IOException, ws {
        Pair<ByteBuffer, Long> j6 = mi.j(randomAccessFile);
        if (j6 != null) {
            return j6;
        }
        throw new ws("Not an APK file: ZIP End of Central Directory record not found");
    }

    static long j(ByteBuffer byteBuffer, long j6) throws ws {
        long j7 = mi.j(byteBuffer);
        if (j7 <= j6) {
            if (mi.xt(byteBuffer) + j7 == j6) {
                return j7;
            }
            throw new ws("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new ws("ZIP Central Directory offset out of range: " + j7 + ". ZIP End of Central Directory offset: " + j6);
    }

    private static long j(long j6) {
        return (j6 + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    static int j(int i6, int i7) {
        return xt(j(i6), j(i7));
    }

    static int j(int i6) {
        if (i6 == 513) {
            return 1;
        }
        if (i6 == 514) {
            return 2;
        }
        if (i6 == 769) {
            return 1;
        }
        if (i6 == 1057 || i6 == 1059 || i6 == 1061) {
            return 3;
        }
        switch (i6) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i6));
        }
    }

    static ByteBuffer j(ByteBuffer byteBuffer, int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            int capacity = byteBuffer.capacity();
            if (i7 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i7);
                    byteBuffer.position(i6);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i7 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i7 + " < " + i6);
    }

    static ByteBuffer j(ByteBuffer byteBuffer, int i6) throws BufferUnderflowException {
        if (i6 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i7 = i6 + position;
            if (i7 >= position && i7 <= limit) {
                byteBuffer.limit(i7);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i7);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i6)));
    }

    static ByteBuffer j(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i6 = byteBuffer.getInt();
            if (i6 >= 0) {
                if (i6 <= byteBuffer.remaining()) {
                    return j(byteBuffer, i6);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i6 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    static void j(int i6, byte[] bArr, int i7) {
        bArr[i7] = (byte) (i6 & 255);
        bArr[i7 + 1] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 2] = (byte) ((i6 >>> 16) & 255);
        bArr[i7 + 3] = (byte) ((i6 >>> 24) & 255);
    }

    static Pair<ByteBuffer, Long> j(RandomAccessFile randomAccessFile, long j6) throws IOException, ws {
        if (j6 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j6 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
                return null;
            }
            long j7 = allocate.getLong(0);
            if (j7 < allocate.capacity() || j7 > 2147483639) {
                throw new ws("APK Signing Block size out of range: ".concat(String.valueOf(j7)));
            }
            int i6 = (int) (8 + j7);
            long j8 = j6 - i6;
            if (j8 >= 0) {
                ByteBuffer allocate2 = ByteBuffer.allocate(i6);
                allocate2.order(byteOrder);
                randomAccessFile.seek(j8);
                randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                long j9 = allocate2.getLong(0);
                if (j9 == j7) {
                    return Pair.create(allocate2, Long.valueOf(j8));
                }
                throw new ws("APK Signing Block sizes in header and footer do not match: " + j9 + " vs " + j7);
            }
            throw new ws("APK Signing Block offset out of range: ".concat(String.valueOf(j8)));
        }
        throw new ws("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j6)));
    }

    static void j(String str, RandomAccessFile randomAccessFile, int... iArr) throws ws, IOException {
        f25528j.put(str, new SparseArray<>());
        Pair<ByteBuffer, Long> j6 = j(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) j6.first;
        long longValue = ((Long) j6.second).longValue();
        if (!mi.j(randomAccessFile, longValue)) {
            long j7 = j(byteBuffer, longValue);
            Pair<ByteBuffer, Long> j8 = j(randomAccessFile, j7);
            if (j8 == null) {
                return;
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) j8.first;
            long longValue2 = ((Long) j8.second).longValue();
            cw(byteBuffer2);
            ByteBuffer j9 = j(byteBuffer2, 8, byteBuffer2.capacity() - 24);
            HashSet hashSet = new HashSet();
            for (int i6 : iArr) {
                hashSet.add(Integer.valueOf(i6));
            }
            while (j9.hasRemaining() && j9.remaining() >= 8) {
                long j10 = j9.getLong();
                if (j10 < 4 || j10 > 2147483647L) {
                    return;
                }
                int i7 = (int) j10;
                int position = j9.position() + i7;
                if (i7 > j9.remaining()) {
                    return;
                }
                int i8 = j9.getInt();
                if (hashSet.contains(Integer.valueOf(i8))) {
                    f25528j.get(str).put(i8, new jy(j(j9, i7 - 4), longValue2, j7, longValue, byteBuffer));
                }
                j9.position(position);
            }
            return;
        }
        throw new ws("ZIP64 APK not supported");
    }
}
