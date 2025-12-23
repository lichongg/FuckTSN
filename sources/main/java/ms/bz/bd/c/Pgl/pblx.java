package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class pblx extends pbly.pgla {
    public abstract Object[] e(String str, String str2, String str3);

    public abstract Object[] f(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] g(String str, String str2, String str3);

    protected static void c(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b250a5", new byte[]{126, 51, 121, 71, 87});
            }
        }
    }

    protected static void d(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "983f9c", new byte[]{37, 57, Byte.MAX_VALUE, 17, 9});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object a(int i6, int i7, long j6, String str, Object obj) throws Throwable {
        if (!d1.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "939559", new byte[]{41, Utf8.REPLACEMENT_BYTE, 78, 83, 5, 39, 62, 92, 120, 96, HttpConstants.COLON, 60, 67, 82, 25, 39, 53, 28, 38, 76, 6, 5, 111, 115, BinaryMemcacheOpcodes.GATKQ, 11, 14}))) {
            return null;
        }
        switch (i6) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return f(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return e(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return g(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.a(i6, i7, j6, str, obj);
        }
    }
}
