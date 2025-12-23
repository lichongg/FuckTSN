package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import com.google.common.primitives.SignedBytes;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class a1 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f50277c = true;

    /* renamed from: d, reason: collision with root package name */
    public static String f50278d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile a1 f50279e;

    /* renamed from: a, reason: collision with root package name */
    private pblk f50280a;

    /* renamed from: b, reason: collision with root package name */
    private String f50281b = null;

    final class pgla implements pblk.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void j(String str) {
            a1.this.f50281b = str;
        }
    }

    public static a1 b(Context context) {
        if (f50279e == null) {
            synchronized (a1.class) {
                try {
                    if (f50279e == null) {
                        f50279e = new a1(context);
                    }
                } finally {
                }
            }
        }
        return f50279e;
    }

    public final String a() {
        String str = f50278d;
        return str != null ? str : this.f50281b;
    }

    private a1(Context context) {
        try {
            this.f50280a = new pblk(new pgla());
            if (f50277c && Build.VERSION.SDK_INT <= 32) {
                this.f50280a.c(context);
            }
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b802bc", new byte[]{124, 47, SignedBytes.MAX_POWER_OF_TWO});
        }
    }
}
