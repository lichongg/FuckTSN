package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.http.HttpConstants;
import java.io.BufferedInputStream;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblm {

    /* renamed from: a, reason: collision with root package name */
    private static final String f50341a;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c20335", new byte[]{73, 108, 2, 25, 49});
        f50341a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fdcd86", new byte[]{99, 114, 47, 30, 3});
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c5, code lost:
    
        if (r3 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblm.c(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f4 A[Catch: all -> 0x00fb, TryCatch #0 {all -> 0x00fb, blocks: (B:23:0x00f4, B:28:0x00fe, B:37:0x00df, B:4:0x0003, B:6:0x0040, B:8:0x0046, B:13:0x004e, B:14:0x0063, B:16:0x006a, B:18:0x006e, B:20:0x00aa, B:30:0x00b0), top: B:3:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String a(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblm.a(android.content.Context):java.lang.String");
    }

    private static String b(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89a04e", new byte[]{HttpConstants.COMMA, 50, 17});
            }
        } while (read >= 4096);
        return sb.toString();
    }
}
