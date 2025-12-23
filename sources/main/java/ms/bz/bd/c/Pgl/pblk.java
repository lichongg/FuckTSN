package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.r.cw;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblk {

    /* renamed from: a, reason: collision with root package name */
    private final pblb f50337a;

    public interface pblb {
        void j(String str);
    }

    final class pgla implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f50338a;

        pgla(Context context) {
            this.f50338a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            pbls pblsVar;
            b1 b1Var;
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b94f7c", new byte[]{82, 8, 114, BinaryMemcacheOpcodes.SASL_AUTH})).equals(pblk.b(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.f50338a).a(pblk.this.f50337a);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1b423b", new byte[]{8, 85, 102, 113, 41, 92})).equals(pblk.b(pblk.this).toUpperCase())) {
                    new pblo(this.f50338a).a(pblk.this.f50337a);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ceb2eb", new byte[]{93, 87, BinaryMemcacheOpcodes.SASL_AUTH, 105})).equals(pblk.b(pblk.this).toUpperCase())) {
                    b1Var = new b1(this.f50338a);
                } else {
                    if (!((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "652279", new byte[]{8, 25, 100, 118, BinaryMemcacheOpcodes.GATKQ, Ascii.ESC, 6})).equals(pblk.b(pblk.this).toUpperCase())) {
                        if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e50fbb", new byte[]{78, 3, 102})).equals(pblk.b(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8661bd", new byte[]{15, 17, 119, 119, 112, 86, 20, BinaryMemcacheOpcodes.GATKQ})).equals(pblk.b(pblk.this).toUpperCase())) {
                            return;
                        }
                        pblk.this.getClass();
                        if (pblk.d() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa8dcf", new byte[]{68, 80, 126, 57})).equals(pblk.b(pblk.this).toUpperCase())) {
                            return;
                        }
                        pblk.this.getClass();
                        if (pblk.g() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22b542", new byte[]{16, 17, 60, 114, 62, 11, 22})).equals(pblk.b(pblk.this).toUpperCase())) {
                            return;
                        }
                        if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f871ad", new byte[]{91, Ascii.US, 106, 106, 104, 92})).equals(pblk.b(pblk.this).toUpperCase())) {
                            pblsVar = new pbls(this.f50338a);
                        } else if (!((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "601731", new byte[]{10, 29, 118, 108, 32, 9, 7, 48})).equals(pblk.b(pblk.this).toUpperCase())) {
                            return;
                        } else {
                            pblsVar = new pbls(this.f50338a);
                        }
                        pblsVar.a(pblk.this.f50337a);
                        return;
                    }
                    b1Var = new b1(this.f50338a);
                }
                b1Var.c(pblk.this.f50337a);
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "efe468", new byte[]{117, 106, 18, 82, 6, 38, 98, 9, HttpConstants.SEMICOLON, 119, HttpConstants.COLON, 87, 15, 83, 29, 42, 107, 119, 38, 107, 100, 97, 4, 84, 0, 42, 117}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "051d61", new byte[]{38, 50, 86}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dc923d", new byte[]{96, 111, 65, 72, 3, 100, 105}));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x023c, code lost:
    
        if (g() == false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblk.c(android.content.Context):void");
    }

    public static boolean d() {
        String a6 = a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "945b58", new byte[]{HttpConstants.COLON, 57, 8, 20, Ascii.US, 38, 54, 17, 42, 52, HttpConstants.COLON, 51, 67, Ascii.ESC, 15, 97, 54, 20, 102, 55, BinaryMemcacheOpcodes.GATKQ}));
        return !TextUtils.isEmpty(a6) && a6.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb5fb1", new byte[]{81, 82, 99, 55, 112, 3, 74, 112}));
    }

    private void f(Context context) {
        new cw(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    public static boolean g() {
        String a6 = a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7a200", new byte[]{103, HttpConstants.COLON, 92, 85, 28, 50, 110, 88, 32, 112, 122, 49, 7, 69, Ascii.ESC}));
        return (TextUtils.isEmpty(a6) || a6.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "338385", new byte[]{55, Utf8.REPLACEMENT_BYTE, SignedBytes.MAX_POWER_OF_TWO, 73, 8, 53, 62}))) ? false : true;
    }

    public pblk(pblb pblbVar) {
        this.f50337a = pblbVar;
    }

    static String b(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }
}
