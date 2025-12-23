package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.C;
import com.google.common.primitives.SignedBytes;
import com.kwad.sdk.utils.a.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] bbW = {0, 1, 4, 4, 8, 8};
    private static final byte[] bbX = new byte[0];
    private static final int bbY;
    private static final int bbZ;
    private static final int bca;
    private final String aca;
    private final Map<String, b> bcb;
    private FileChannel bcd;
    private FileChannel bce;
    private RandomAccessFile bcf;
    private RandomAccessFile bcg;
    private MappedByteBuffer bch;
    private MappedByteBuffer bci;
    private com.kwad.sdk.utils.a.b bcj;
    private int bck;
    private long bcl;
    private int bco;
    private int bcp;
    private int bcq;
    private boolean bcr;
    private String bcs;
    private int bct;
    private int bcv;
    private final String name;
    private final d bcc = com.kwad.sdk.utils.a.d.bcG;
    private final Map<String, a.b> bcm = new HashMap();
    private boolean bcn = false;
    private final ArrayList<e> bcu = new ArrayList<>();
    private boolean bcw = true;
    private final Executor bcx = new f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        static final C0711c bcA = new C0711c(11);
        static int bcz = 11;
        private final String aca;
        private b[] bcB;
        private int bcv = 0;
        private final String name;

        public final c SJ() {
            String str = this.aca + this.name;
            c hI = C0711c.hI(str);
            if (hI == null) {
                synchronized (a.class) {
                    try {
                        hI = C0711c.hI(str);
                        if (hI == null) {
                            hI = new c(this.aca, this.name, this.bcB, this.bcv);
                            C0711c.b(str, hI);
                        }
                    } finally {
                    }
                }
            }
            Integer num = C0711c.bcF.get(str);
            if (num != null) {
                C0711c.bcF.put(str, Integer.valueOf(num.intValue() + 1));
                return hI;
            }
            C0711c.bcF.put(str, 1);
            return hI;
        }

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + '/';
                    }
                    this.aca = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T> {
        String SK();

        T f(byte[] bArr, int i6, int i7);

        byte[] p(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    static class C0711c {
        private static Map<String, c> bcC;
        private static List<String> bcD;
        private static int bcE;
        public static Map<String, Integer> bcF;

        private static int getSize(int i6) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }

        public static void b(String str, c cVar) {
            if (bcC == null) {
                bcC = new ConcurrentHashMap(getSize(bcE));
            }
            if (bcD == null) {
                bcD = new CopyOnWriteArrayList();
            }
            if (bcC.containsKey(str)) {
                bcD.remove(str);
                bcD.add(str);
            } else {
                bcD.add(str);
            }
            bcC.put(str, cVar);
            if (bcC.size() > bcE) {
                Integer num = bcF.get(bcD.get(0));
                if (num != null && num.intValue() != 2) {
                    fj(bcE + 1);
                    return;
                }
                c cVar2 = bcC.get(bcD.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                bcC.remove(bcD.get(0));
                bcD.remove(0);
            }
        }

        private static void fj(int i6) {
            com.kwad.sdk.utils.a.d.bcG.i("Ks_UnionKv", "reSize:" + i6);
            bcE = i6;
        }

        public static c hI(String str) {
            if (bcC == null) {
                bcC = new ConcurrentHashMap(getSize(bcE));
            }
            if (bcD == null) {
                bcD = new CopyOnWriteArrayList();
            }
            c cVar = bcC.get(str);
            if (cVar == null) {
                return null;
            }
            bcD.remove(str);
            bcD.add(str);
            return cVar;
        }

        public static void remove(String str) {
            List<String> list = bcD;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = bcC;
            if (map != null) {
                map.remove(str);
            }
        }

        public C0711c(int i6) {
            int size = getSize(i6);
            bcC = new ConcurrentHashMap(size);
            bcF = new HashMap(size);
            bcD = new CopyOnWriteArrayList();
            bcE = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements Comparable<e> {
        int end;
        int start;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }

        e(int i6, int i7) {
            this.start = i6;
            this.end = i7;
        }
    }

    static {
        int SM = h.SM();
        PAGE_SIZE = SM;
        bbY = SM - 192;
        int max = Math.max(SM << 1, 16384);
        bbZ = max;
        bca = max << 1;
    }

    private void SA() {
        this.bcv = 1;
        h.closeQuietly(this.bcd);
        h.closeQuietly(this.bce);
        this.bcd = null;
        this.bce = null;
        this.bch = null;
        this.bci = null;
    }

    private void SI() {
        this.bct = 0;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sr() {
        try {
            synchronized (this.bcm) {
                this.bcn = true;
                this.bcm.notify();
            }
            long nanoTime = System.nanoTime();
            if (!Su() && this.bcv == 0) {
                Ss();
            }
            if (this.bcj == null) {
                this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
            }
            if (this.bcc != null) {
                info("loading finish, data len:" + this.bck + ", get keys:" + this.bcm.size() + ", use time:" + ((System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND) + " ms");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean Sy() {
        try {
            try {
                File file = new File(this.aca, this.name + ".tmp");
                if (h.ae(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.bck);
                    randomAccessFile.write(this.bcj.bbV, 0, this.bck);
                    randomAccessFile.close();
                    File file2 = new File(this.aca, this.name + ".kvc");
                    if (file2.exists()) {
                        if (file2.delete()) {
                        }
                    }
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            } catch (Exception e6) {
                t(e6);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static long g(long j6, int i6) {
        int i7 = (i6 & 7) << 3;
        return (j6 >>> (64 - i7)) | (j6 << i7);
    }

    private synchronized void putDouble(String str, double d6) {
        Throwable th;
        try {
            try {
                hG(str);
                a.d dVar = (a.d) this.bcm.get(str);
                if (dVar != null) {
                    if (dVar.value != d6) {
                        long doubleToRawLongBits = Double.doubleToRawLongBits(d6);
                        long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits;
                        dVar.value = d6;
                        b(doubleToRawLongBits, doubleToRawLongBits2, dVar.offset);
                        Sw();
                    }
                    return;
                }
                try {
                    a(str, (byte) 5);
                    com.kwad.sdk.utils.a.b bVar = this.bcj;
                    if (bVar != null) {
                        int i6 = bVar.position;
                        bVar.bb(Double.doubleToRawLongBits(d6));
                        SD();
                        Map<String, a.b> map = this.bcm;
                        if (map != null) {
                            map.put(str, new a.d(i6, d6));
                        }
                    }
                    Sw();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    private synchronized void putFloat(String str, float f6) {
        try {
            hG(str);
            a.e eVar = (a.e) this.bcm.get(str);
            if (eVar != null) {
                if (eVar.value != f6) {
                    eVar.value = f6;
                    a(Float.floatToRawIntBits(f6), (Float.floatToRawIntBits(eVar.value) ^ r6) & 4294967295L, eVar.offset);
                    Sw();
                }
                return;
            }
            a(str, (byte) 3);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                int i6 = bVar.position;
                bVar.eY(Float.floatToRawIntBits(f6));
                SD();
                Map<String, a.b> map = this.bcm;
                if (map != null) {
                    map.put(str, new a.e(i6, f6));
                }
            }
            Sw();
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.bcN);
        }
    }

    private void t(String str, int i6) {
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i6);
        if (i6 != str.length()) {
            this.bcj.hC(str);
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        a(str, 0, i6, bVar2.bbV, bVar2.position);
        this.bcj.position += i6;
    }

    private void updateBytes(int i6, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            this.bcl ^= bVar.F(i6, length);
            com.kwad.sdk.utils.a.b bVar2 = this.bcj;
            bVar2.position = i6;
            bVar2.k(bArr);
            this.bcl ^= this.bcj.F(i6, length);
        }
        if (this.bcv != 0) {
            com.kwad.sdk.utils.a.b bVar3 = this.bcj;
            if (bVar3 != null) {
                bVar3.f(4, this.bcl);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.bch;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.bch.putLong(4, this.bcl);
            this.bch.position(i6);
            this.bch.put(bArr);
            this.bch.putInt(0, this.bck - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.bci;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.bcl);
            this.bci.position(i6);
            this.bci.put(bArr);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.bcm.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.bcm.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.bcm.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            switch (value.Sp()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.bbT) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0710a c0710a = (a.C0710a) value;
                    if (c0710a.bbT) {
                        valueOf = a(c0710a);
                        break;
                    } else {
                        valueOf = c0710a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.bbT) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z5) {
        a.c cVar = (a.c) this.bcm.get(str);
        if (cVar == null) {
            return z5;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i6) {
        a.f fVar = (a.f) this.bcm.get(str);
        if (fVar == null) {
            return i6;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j6) {
        a.g gVar = (a.g) this.bcm.get(str);
        if (gVar == null) {
            return j6;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.bcm.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.bbT) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z5) {
        try {
            hG(str);
            a.c cVar = (a.c) this.bcm.get(str);
            if (cVar != null) {
                if (cVar.value != z5) {
                    cVar.value = z5;
                    a(z5 ? (byte) 1 : (byte) 0, cVar.offset);
                    Sw();
                }
                return;
            }
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                int i6 = bVar.position;
                bVar.e(z5 ? (byte) 1 : (byte) 0);
                SD();
                Map<String, a.b> map = this.bcm;
                if (map != null) {
                    map.put(str, new a.c(i6, z5));
                }
            }
            Sw();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void putInt(String str, int i6) {
        try {
            hG(str);
            a.f fVar = (a.f) this.bcm.get(str);
            if (fVar != null) {
                if (fVar.value != i6) {
                    fVar.value = i6;
                    a(i6, (r6 ^ i6) & 4294967295L, fVar.offset);
                    Sw();
                }
                return;
            }
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                int i7 = bVar.position;
                bVar.eY(i6);
                SD();
                Map<String, a.b> map = this.bcm;
                if (map != null) {
                    map.put(str, new a.f(i7, i6));
                }
            }
            Sw();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void putLong(String str, long j6) {
        Throwable th;
        try {
            try {
                hG(str);
                a.g gVar = (a.g) this.bcm.get(str);
                if (gVar != null) {
                    long j7 = gVar.value;
                    if (j7 != j6) {
                        long j8 = j6 ^ j7;
                        gVar.value = j6;
                        b(j6, j8, gVar.offset);
                        Sw();
                    }
                    return;
                }
                try {
                    a(str, (byte) 4);
                    com.kwad.sdk.utils.a.b bVar = this.bcj;
                    if (bVar != null) {
                        int i6 = bVar.position;
                        bVar.bb(j6);
                        SD();
                        Map<String, a.b> map = this.bcm;
                        if (map != null) {
                            map.put(str, new a.g(i6, j6));
                        }
                    }
                    Sw();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void putString(String str, String str2) {
        Throwable th;
        byte[] hF;
        byte[] bArr;
        byte[] bArr2;
        try {
            try {
                hG(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
            try {
                if (str2 == null) {
                    remove(str);
                    return;
                }
                a.i iVar = (a.i) this.bcm.get(str);
                if (str2.length() * 3 < 2048) {
                    a(str, str2, iVar);
                    return;
                }
                if (!str2.isEmpty()) {
                    if (iVar == null && str2.length() < 2048) {
                        int hD = com.kwad.sdk.utils.a.b.hD(str2);
                        bArr = new byte[hD];
                        if (hD == str2.length()) {
                            a(str2, 0, hD, bArr, 0);
                            bArr2 = bArr;
                        } else {
                            hF = com.kwad.sdk.utils.a.b.hF(str2);
                        }
                    } else if (iVar == null || iVar.bbT) {
                        hF = com.kwad.sdk.utils.a.b.hF(str2);
                    } else {
                        int hD2 = com.kwad.sdk.utils.a.b.hD(str2);
                        bArr = new byte[hD2];
                        if (hD2 == str2.length()) {
                            a(str2, 0, hD2, bArr, 0);
                            bArr2 = bArr;
                        } else {
                            hF = com.kwad.sdk.utils.a.b.hF(str2);
                        }
                    }
                    a(str, str2, bArr2, iVar, (byte) 6);
                }
                hF = bbX;
                bArr2 = hF;
                a(str, str2, bArr2, iVar, (byte) 6);
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void remove(String str) {
        try {
            a.b bVar = this.bcm.get(str);
            if (bVar != null) {
                this.bcm.remove(str);
                byte Sp = bVar.Sp();
                String str2 = null;
                if (Sp <= 5) {
                    int hD = com.kwad.sdk.utils.a.b.hD(str);
                    int i6 = bVar.offset;
                    a(Sp, i6 - (hD + 2), i6 + bbW[Sp]);
                } else {
                    a.j jVar = (a.j) bVar;
                    a(Sp, jVar.start, jVar.offset + jVar.bbS);
                    if (jVar.bbT) {
                        str2 = (String) jVar.value;
                    }
                }
                byte b6 = (byte) (Sp | Byte.MIN_VALUE);
                if (this.bcv == 0) {
                    MappedByteBuffer mappedByteBuffer = this.bch;
                    if (mappedByteBuffer != null) {
                        mappedByteBuffer.putLong(4, this.bcl);
                        this.bch.put(this.bcq, b6);
                    }
                    MappedByteBuffer mappedByteBuffer2 = this.bci;
                    if (mappedByteBuffer2 != null) {
                        mappedByteBuffer2.putLong(4, this.bcl);
                        this.bci.put(this.bcq, b6);
                    }
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.bcj;
                    if (bVar2 != null) {
                        bVar2.f(4, this.bcl);
                    }
                }
                this.bcq = 0;
                if (str2 != null) {
                    h.h(new File(this.aca + this.name, str2));
                }
                SG();
                Sw();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.aca + " name:" + this.name;
    }

    private int G(int i6, int i7) {
        if (i7 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.oz.booleanValue()) {
                throw illegalStateException;
            }
            t(illegalStateException);
        }
        int i8 = PAGE_SIZE;
        if (i7 <= i8) {
            return i8;
        }
        while (i6 < i7) {
            int i9 = bbZ;
            i6 = i6 <= i9 ? i6 << 1 : i6 + i9;
        }
        return i6;
    }

    private void H(int i6, int i7) {
        this.bct += i7 - i6;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList != null) {
            arrayList.add(new e(i6, i7));
        }
    }

    private void SB() {
        if (this.bcv == 0) {
            try {
                a(this.bch);
                a(this.bci);
            } catch (Throwable unused) {
                SA();
            }
        }
        SC();
        h.h(new File(this.aca + this.name));
    }

    private void SC() {
        this.bck = 12;
        this.bcl = 0L;
        SI();
        this.bcm.clear();
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null || bVar.bbV.length != PAGE_SIZE) {
            this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            bVar.D(0, 0);
            this.bcj.f(4, 0L);
        }
    }

    private void SD() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            this.bcl ^= bVar2.F(this.bco, this.bcp);
        }
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.bch);
                this.bch.putInt(0, this.bck - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.bcr && (bVar = this.bcj) != null) {
                bVar.D(0, this.bck - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.bcj;
            if (bVar3 != null) {
                bVar3.f(4, this.bcl);
            }
        }
        this.bcr = false;
        this.bcq = 0;
        this.bcp = 0;
    }

    private int SE() {
        int i6 = this.bck;
        if (i6 <= 16384) {
            return 4096;
        }
        return i6 <= 65536 ? 8192 : 16384;
    }

    private void SF() {
        fg(this.bcp);
        int i6 = this.bck;
        this.bco = i6;
        this.bck = this.bcp + i6;
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            bVar.position = i6;
        }
        this.bcr = true;
    }

    private void SG() {
        if (this.bct < (SE() << 1)) {
            if (this.bcu.size() < (this.bck < 16384 ? 80 : 160)) {
                return;
            }
        }
        fh(0);
    }

    private void SH() {
        ArrayList<e> arrayList = this.bcu;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.bcu.get(size);
        while (size > 0) {
            int i6 = size - 1;
            e eVar2 = this.bcu.get(i6);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.bcu.remove(size);
            }
            eVar = eVar2;
            size = i6;
        }
    }

    private void Ss() {
        long j6;
        File file = new File(this.aca, this.name + ".kva");
        File file2 = new File(this.aca, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                this.bcf = new RandomAccessFile(file, "rw");
                this.bcg = new RandomAccessFile(file2, "rw");
                long length = this.bcf.length();
                long length2 = this.bcg.length();
                this.bcd = this.bcf.getChannel();
                this.bce = this.bcg.getChannel();
                try {
                    FileChannel fileChannel = this.bcd;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : PAGE_SIZE);
                    this.bch = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bce.map(mapMode, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bci = map2;
                    map2.order(byteOrder);
                    this.bcj = new com.kwad.sdk.utils.a.b(this.bch.capacity());
                    if (length == 0 && length2 == 0) {
                        this.bck = 12;
                        return;
                    }
                    int i6 = this.bch.getInt();
                    long j7 = this.bch.getLong();
                    int i7 = this.bci.getInt();
                    long j8 = this.bci.getLong();
                    if (i6 < 0) {
                        j6 = 12;
                    } else if (i6 <= length - 12) {
                        this.bck = i6 + 12;
                        this.bch.rewind();
                        j6 = 12;
                        this.bch.get(this.bcj.bbV, 0, this.bck);
                        if (j7 == this.bcj.F(12, i6) && Sv() == 0) {
                            this.bcl = j7;
                            if (length == length2 && St()) {
                                return;
                            }
                            g(new Exception("B file error"));
                            a(this.bch, this.bci, this.bck);
                            return;
                        }
                    } else {
                        j6 = 12;
                    }
                    if (i7 >= 0 && i7 <= length2 - j6) {
                        this.bcm.clear();
                        SI();
                        this.bck = i7 + 12;
                        if (this.bcj.bbV.length != this.bci.capacity()) {
                            this.bcj = new com.kwad.sdk.utils.a.b(this.bci.capacity());
                        }
                        this.bci.rewind();
                        this.bci.get(this.bcj.bbV, 0, this.bck);
                        if (j8 == this.bcj.F(12, i7) && Sv() == 0) {
                            g(new Exception("A file error"));
                            a(this.bci, this.bch, this.bck);
                            this.bcl = j8;
                            return;
                        }
                    }
                    hH("both files error");
                    SB();
                    return;
                } catch (IOException e6) {
                    t(e6);
                    SA();
                    h(file, file2);
                    return;
                }
            }
            t(new Exception("open file failed"));
            SA();
        } catch (Throwable th) {
            t(th);
            SC();
            SA();
        }
    }

    private boolean St() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.bck);
        MappedByteBuffer mappedByteBuffer = this.bci;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.bci.get(bVar.bbV, 0, this.bck);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.bbV;
        byte[] bArr2 = bVar.bbV;
        for (int i6 = 0; i6 < this.bck; i6++) {
            if (bArr[i6] != bArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private boolean Su() {
        File file = new File(this.aca, this.name + ".kvc");
        File file2 = new File(this.aca, this.name + ".tmp");
        boolean z5 = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!ad(file)) {
                    SC();
                    Sz();
                    return false;
                }
                if (this.bcv == 0) {
                    if (!a(this.bcj)) {
                        this.bcv = 1;
                        return false;
                    }
                    info("recover from c file");
                    try {
                        Sz();
                        return true;
                    } catch (Exception e6) {
                        e = e6;
                        z5 = true;
                        t(e);
                        return z5;
                    }
                }
            } else if (this.bcv != 0) {
                File file3 = new File(this.aca, this.name + ".kva");
                File file4 = new File(this.aca, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    h(file3, file4);
                }
            }
            return false;
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0173, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Sv() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Sv():int");
    }

    private void Sw() {
        if (this.bcv == 0 || !this.bcw) {
            return;
        }
        Sx();
    }

    private boolean Sx() {
        int i6 = this.bcv;
        if (i6 == 1) {
            Executor executor = this.bcx;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Sy();
                    }
                });
            }
        } else if (i6 == 2) {
            return Sy();
        }
        return true;
    }

    private void Sz() {
        try {
            h.h(new File(this.aca, this.name + ".kvc"));
            h.h(new File(this.aca, this.name + ".tmp"));
        } catch (Exception e6) {
            t(e6);
        }
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.bbV.length;
        File file = new File(this.aca, this.name + ".kva");
        File file2 = new File(this.aca, this.name + ".kvb");
        try {
            if (!h.ae(file) || !h.ae(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j6 = length;
            randomAccessFile.setLength(j6);
            randomAccessFile2.setLength(j6);
            this.bcd = randomAccessFile.getChannel();
            this.bce = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.bcd;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j6);
            this.bch = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bce.map(mapMode, 0L, j6);
            this.bci = map2;
            map2.order(byteOrder);
            this.bch.put(bVar.bbV, 0, this.bck);
            this.bci.put(bVar.bbV, 0, this.bck);
            return true;
        } catch (Exception e6) {
            t(e6);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        Throwable th;
        try {
            try {
                hG(str);
                if (bArr != null) {
                    a(str, bArr, bArr, (a.C0710a) this.bcm.get(str), (byte) 7);
                    return;
                }
                try {
                    remove(str);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    private static void e(int i6, boolean z5) {
        if (z5) {
            if (i6 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i6 < 0 || i6 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private static void ff(int i6) {
        if (i6 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void fg(int i6) {
        if (this.bcj == null) {
            this.bcj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.bcj.bbV.length;
        int i7 = this.bck + i6;
        if (i7 >= length) {
            int i8 = this.bct;
            if (i8 > i6 && i8 > SE()) {
                fh(i6);
                return;
            }
            int G = G(length, i7);
            byte[] bArr = new byte[G];
            System.arraycopy(this.bcj.bbV, 0, bArr, 0, this.bck);
            this.bcj.bbV = bArr;
            if (this.bcv == 0) {
                try {
                    FileChannel fileChannel = this.bcd;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j6 = G;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j6);
                    this.bch = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bce.map(mapMode, 0L, j6);
                    this.bci = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    t(new Exception("map failed", th));
                    this.bcj.D(0, this.bck - 12);
                    this.bcj.f(4, this.bcl);
                    SA();
                }
            }
        }
    }

    private void fh(int i6) {
        int i7;
        ArrayList<e> arrayList = this.bcu;
        if (arrayList == null || this.bcj == null) {
            return;
        }
        Collections.sort(arrayList);
        SH();
        e eVar = this.bcu.get(0);
        int i8 = eVar.start;
        int i9 = this.bck;
        int i10 = i9 - this.bct;
        int i11 = i10 - 12;
        int i12 = i10 - i8;
        int i13 = i9 - i8;
        boolean z5 = i11 < i13 + i12;
        if (!z5) {
            this.bcl ^= this.bcj.F(i8, i13);
        }
        int size = this.bcu.size();
        int i14 = size - 1;
        int i15 = this.bck - this.bcu.get(i14).end;
        int[] iArr = new int[(i15 > 0 ? size : i14) << 1];
        int i16 = eVar.start;
        int i17 = eVar.end;
        for (int i18 = 1; i18 < size; i18++) {
            e eVar2 = this.bcu.get(i18);
            int i19 = eVar2.start - i17;
            byte[] bArr = this.bcj.bbV;
            System.arraycopy(bArr, i17, bArr, i16, i19);
            int i20 = (i18 - 1) << 1;
            iArr[i20] = i17;
            iArr[i20 + 1] = i17 - i16;
            i16 += i19;
            i17 = eVar2.end;
        }
        if (i15 > 0) {
            byte[] bArr2 = this.bcj.bbV;
            System.arraycopy(bArr2, i17, bArr2, i16, i15);
            int i21 = i14 << 1;
            iArr[i21] = i17;
            iArr[i21 + 1] = i17 - i16;
        }
        SI();
        if (z5) {
            this.bcl = this.bcj.F(12, i11);
        } else {
            this.bcl ^= this.bcj.F(i8, i12);
        }
        this.bck = i10;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                i7 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.bch.putLong(4, this.bcl);
                this.bch.position(i8);
                this.bch.put(this.bcj.bbV, i8, i12);
                this.bch.putInt(0, i11);
            } else {
                i7 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i7, i11);
                this.bci.putLong(4, this.bcl);
                this.bci.position(i8);
                this.bci.put(this.bcj.bbV, i8, i12);
            }
        } else {
            this.bcj.D(0, i11);
            this.bcj.f(4, this.bcl);
        }
        a(i8, iArr);
        int i22 = i10 + i6;
        if (this.bcj.bbV.length - i22 > bca) {
            fi(i22);
        }
        info("gc finish");
    }

    private void fi(int i6) {
        int i7 = PAGE_SIZE;
        int G = G(i7, i6 + i7);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            byte[] bArr = bVar.bbV;
            if (G >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[G];
            System.arraycopy(bArr, 0, bArr2, 0, this.bck);
            this.bcj.bbV = bArr2;
        }
        if (this.bcv == 0) {
            try {
                long j6 = G;
                this.bcd.truncate(j6);
                FileChannel fileChannel = this.bcd;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j6);
                this.bch = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bce.truncate(j6);
                MappedByteBuffer map2 = this.bce.map(mapMode, 0L, j6);
                this.bci = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                t(new Exception("map failed", th));
                SA();
            }
        }
        info("truncate finish");
    }

    private void g(Exception exc) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private static void hG(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hH(String str) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void u(String str, int i6) {
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i6);
        if (i6 != str.length()) {
            this.bcj.hC(str);
        } else {
            com.kwad.sdk.utils.a.b bVar2 = this.bcj;
            a(str, 0, i6, bVar2.bbV, bVar2.position);
        }
    }

    public final void release() {
        h.closeQuietly(this.bcf);
        h.closeQuietly(this.bcg);
        h.closeQuietly(this.bcd);
        h.closeQuietly(this.bce);
        this.bcd = null;
        this.bce = null;
        this.bch = null;
        this.bci = null;
        String str = this.aca + this.name;
        C0711c c0711c = a.bcA;
        C0711c.remove(str);
    }

    c(String str, String str2, b[] bVarArr, int i6) {
        this.aca = str;
        this.name = str2;
        this.bcv = i6;
        HashMap hashMap = new HashMap();
        g gVar = g.bcN;
        hashMap.put(gVar.SK(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String SK = bVar.SK();
                if (hashMap.containsKey(SK)) {
                    hH("duplicate encoder tag:" + SK);
                } else {
                    hashMap.put(SK, bVar);
                }
            }
        }
        this.bcb = hashMap;
        synchronized (this.bcm) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Sr();
                }
            });
            while (!this.bcn) {
                try {
                    this.bcm.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= IjkMediaMeta.AV_CH_STEREO_LEFT) {
            int i6 = (int) length;
            int G = G(PAGE_SIZE, i6);
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null && bVar.bbV.length == G) {
                bVar.position = 0;
            } else {
                bVar = new com.kwad.sdk.utils.a.b(new byte[G]);
                this.bcj = bVar;
            }
            h.a(file, bVar.bbV, i6);
            int i7 = bVar.getInt();
            long j6 = bVar.getLong();
            this.bck = i7 + 12;
            if (i7 >= 0 && i7 <= i6 - 12 && j6 == bVar.F(12, i7) && Sv() == 0) {
                this.bcl = j6;
                return true;
            }
        }
        return false;
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e6) {
            g(e6);
        }
        SC();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e7) {
            g(e7);
        }
        SC();
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.bcr && mappedByteBuffer != this.bch) {
            mappedByteBuffer.putInt(0, this.bck - 12);
        }
        mappedByteBuffer.putLong(4, this.bcl);
        int i6 = this.bcq;
        if (i6 != 0) {
            mappedByteBuffer.put(i6, this.bcj.bbV[i6]);
        }
        if (this.bcp != 0) {
            mappedByteBuffer.position(this.bco);
            mappedByteBuffer.put(this.bcj.bbV, this.bco, this.bcp);
        }
    }

    private void t(Throwable th) {
        d dVar = this.bcc;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void b(long j6, long j7, int i6) {
        long g6 = g(j7, i6) ^ this.bcl;
        this.bcl = g6;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, g6);
                this.bch.putLong(i6, j6);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.putLong(i6, j6);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, g6);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.f(i6, j6);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i6) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bci ? this.bce : this.bcd).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bci) {
                    this.bci = map;
                } else {
                    this.bch = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e6) {
                t(e6);
                SA();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i6);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b6) {
        a(str, b6, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        int i6 = bVar2.position;
        bVar2.k(bArr);
        return i6;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] af = h.af(new File(this.aca + this.name, (String) iVar.value));
            String str = new String(af);
            return (af == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(af, com.kwad.sdk.utils.a.b.hD(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e6) {
            t(e6);
        }
        return "";
    }

    private byte[] a(a.C0710a c0710a) {
        try {
            byte[] af = h.af(new File(this.aca + this.name, (String) c0710a.value));
            return af != null ? af : bbX;
        } catch (Exception e6) {
            t(e6);
            return bbX;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] af = h.af(new File(this.aca + this.name, (String) hVar.value));
            if (af != null) {
                int i6 = af[0] & 255;
                String str = new String(af, 1, i6, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.bcb.get(str);
                if (bVar != null) {
                    int i7 = i6 + 1;
                    return bVar.f(af, i7, af.length - i7);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e6) {
            t(e6);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t5, b<T> bVar) {
        Throwable th;
        byte[] bArr;
        try {
            try {
                hG(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
            try {
                if (bVar == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
                    if (!com.kwad.library.a.a.oz.booleanValue()) {
                        t(illegalArgumentException);
                        return;
                    }
                    throw illegalArgumentException;
                }
                String SK = bVar.SK();
                if (!SK.isEmpty() && SK.length() <= 50) {
                    if (!this.bcb.containsKey(SK)) {
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                        if (!com.kwad.library.a.a.oz.booleanValue()) {
                            t(illegalArgumentException2);
                            return;
                        }
                        throw illegalArgumentException2;
                    }
                    if (t5 == null) {
                        remove(str);
                        return;
                    }
                    try {
                        bArr = bVar.p(t5);
                    } catch (Exception e6) {
                        t(e6);
                        bArr = null;
                    }
                    if (bArr == null) {
                        remove(str);
                        return;
                    }
                    int hD = com.kwad.sdk.utils.a.b.hD(SK);
                    com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(hD + 1 + bArr.length);
                    bVar2.e((byte) hD);
                    bVar2.hC(SK);
                    bVar2.k(bArr);
                    a(str, t5, bVar2.bbV, (a.h) this.bcm.get(str), (byte) 8);
                    return;
                }
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + SK);
                if (!com.kwad.library.a.a.oz.booleanValue()) {
                    t(illegalArgumentException3);
                    return;
                }
                throw illegalArgumentException3;
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        b(key, (byte[]) value);
                    } else {
                        g(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i6 = PAGE_SIZE;
        if (capacity != i6) {
            FileChannel fileChannel = mappedByteBuffer == this.bch ? this.bcd : this.bce;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i6);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i6);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.bch) {
                this.bch = map;
            } else {
                this.bci = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b6) {
        a(str, b6, bbW[b6]);
    }

    private void a(String str, byte b6, int i6) {
        int hD = com.kwad.sdk.utils.a.b.hD(str);
        ff(hD);
        this.bcp = hD + 2 + i6;
        SF();
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null) {
            bVar.e(b6);
        }
        t(str, hD);
    }

    private void a(byte b6, int i6) {
        long g6 = this.bcl ^ g(1L, i6);
        this.bcl = g6;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, g6);
                this.bch.put(i6, b6);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.put(i6, b6);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, g6);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.bbV[i6] = b6;
        }
    }

    private void a(int i6, long j6, int i7) {
        long g6 = g(j6, i7) ^ this.bcl;
        this.bcl = g6;
        if (this.bcv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bch;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, g6);
                this.bch.putInt(i7, i6);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bci;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bcl);
                this.bci.putInt(i7, i6);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.f(4, g6);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bcj;
        if (bVar2 != null) {
            bVar2.D(i7, i6);
        }
    }

    private static void a(String str, int i6, int i7, byte[] bArr, int i8) {
        int i9;
        if (i7 <= str.length() && i7 >= 0) {
            int i10 = 0;
            while (i10 < i7) {
                int i11 = i10 + 1;
                char charAt = str.charAt(i10);
                if (charAt < 128) {
                    i9 = i8 + 1;
                    bArr[i8] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i9 = i8 + 1;
                    bArr[i8] = (byte) charAt;
                }
                i10 = i11;
                i8 = i9;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int hD = com.kwad.sdk.utils.a.b.hD(str2);
        if (iVar == null) {
            int hD2 = com.kwad.sdk.utils.a.b.hD(str);
            ff(hD2);
            int i6 = hD2 + 4;
            this.bcp = i6 + hD;
            SF();
            com.kwad.sdk.utils.a.b bVar = this.bcj;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            t(str, hD2);
            u(str2, hD);
            Map<String, a.b> map = this.bcm;
            int i7 = this.bco;
            map.put(str, new a.i(i7, i6 + i7, str2, hD, false));
            SD();
        } else {
            int i8 = iVar.offset;
            int i9 = i8 - iVar.start;
            int i10 = iVar.bbS;
            boolean z5 = false;
            if (i10 == hD) {
                this.bcl = this.bcj.F(i8, i10) ^ this.bcl;
                if (hD == str2.length()) {
                    a(str2, 0, hD, this.bcj.bbV, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.bcj;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hC(str2);
                    }
                }
                this.bco = iVar.offset;
                this.bcp = hD;
            } else {
                this.bcp = i9 + hD;
                SF();
                com.kwad.sdk.utils.a.b bVar3 = this.bcj;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i11 = i9 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.bcj;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.bbV;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i11);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.bcj;
                if (bVar5 != null) {
                    bVar5.position += i11;
                }
                u(str2, hD);
                a((byte) 6, iVar.start, iVar.offset + iVar.bbS);
                r5 = iVar.bbT ? (String) iVar.value : null;
                iVar.bbT = false;
                int i12 = this.bco;
                iVar.start = i12;
                iVar.offset = i12 + i9;
                iVar.bbS = hD;
                z5 = true;
            }
            iVar.value = str2;
            SD();
            if (z5) {
                SG();
            }
            if (r5 != null) {
                h.h(new File(this.aca + this.name, r5));
            }
        }
        Sw();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b6) {
        if (jVar == null) {
            a(str, obj, bArr, b6);
        } else if (!jVar.bbT && jVar.bbS == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Sw();
    }

    private void a(String str, Object obj, byte[] bArr, byte b6) {
        Object obj2;
        int length;
        a.b hVar;
        int a6 = a(str, bArr, b6);
        if (a6 != 0) {
            String str2 = this.bcs;
            boolean z5 = str2 != null;
            if (z5) {
                this.bcs = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b6 == 6) {
                hVar = new a.i(this.bco, a6, (String) obj2, length, z5);
            } else if (b6 == 7) {
                hVar = new a.C0710a(this.bco, a6, obj2, length, z5);
            } else {
                hVar = new a.h(this.bco, a6, obj2, length, z5);
            }
            this.bcm.put(str, hVar);
            SD();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a6 = a(str, bArr, jVar.Sp());
        if (a6 != 0) {
            String str2 = jVar.bbT ? (String) jVar.value : null;
            a(jVar.Sp(), jVar.start, jVar.offset + jVar.bbS);
            String str3 = this.bcs;
            boolean z5 = str3 != null;
            jVar.start = this.bco;
            jVar.offset = a6;
            jVar.bbT = z5;
            if (z5) {
                jVar.value = str3;
                jVar.bbS = 32;
                this.bcs = null;
            } else {
                jVar.value = obj;
                jVar.bbS = bArr.length;
            }
            SD();
            SG();
            if (str2 != null) {
                h.h(new File(this.aca + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b6) {
        this.bcs = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b6);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String SL = h.SL();
        if (h.a(new File(this.aca + this.name, SL), bArr)) {
            this.bcs = SL;
            byte[] bArr2 = new byte[32];
            SL.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b6 | SignedBytes.MAX_POWER_OF_TWO));
        }
        hH("save large value failed");
        return 0;
    }

    private void a(byte b6, int i6, int i7) {
        byte[] bArr;
        H(i6, i7);
        byte b7 = (byte) (b6 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.bcj;
        if (bVar != null && (bArr = bVar.bbV) != null) {
            this.bcl = (((bArr[i6] ^ b7) & 255) << ((i6 & 7) << 3)) ^ this.bcl;
            bArr[i6] = b7;
        }
        this.bcq = i6;
    }

    private void a(int i6, int[] iArr) {
        Map<String, a.b> map = this.bcm;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i7 = bVar.offset;
            if (i7 > i6) {
                int i8 = iArr[(h.binarySearch(iArr, i7) << 1) + 1];
                bVar.offset -= i8;
                if (bVar.Sp() >= 6) {
                    ((a.j) bVar).start -= i8;
                }
            }
        }
    }
}
