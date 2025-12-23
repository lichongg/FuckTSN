package com.tencent.open.utils;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final n f40637a = new n(101010256);

    /* renamed from: b, reason: collision with root package name */
    private static final o f40638b = new o(38651);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.utils.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        Properties f40639a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f40640b;

        private a() {
            this.f40639a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.f40638b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!b.f40638b.equals(new o(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b6 = new o(bArr3).b();
            if ((bArr.length - length) - 2 < b6) {
                return;
            }
            byte[] bArr4 = new byte[b6];
            wrap.get(bArr4);
            this.f40639a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b6) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.f40640b = bArr5;
                wrap.get(bArr5);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f40639a + ", otherData=" + Arrays.toString(this.f40640b) + "]";
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        byte b6 = 0;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36150k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a6 = a(randomAccessFile);
            if (a6 == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a(b6 == true ? 1 : 0);
            aVar.a(a6);
            String property = aVar.f40639a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a6 = f40637a.a();
        int read = randomAccessFile.read();
        while (read != -1) {
            if (read == a6[0] && randomAccessFile.read() == a6[1] && randomAccessFile.read() == a6[2] && randomAccessFile.read() == a6[3]) {
                randomAccessFile.seek(length + 20);
                byte[] bArr = new byte[2];
                randomAccessFile.readFully(bArr);
                int b6 = new o(bArr).b();
                if (b6 == 0) {
                    return null;
                }
                byte[] bArr2 = new byte[b6];
                randomAccessFile.read(bArr2);
                return bArr2;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
