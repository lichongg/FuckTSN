package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h3 {

    /* renamed from: a, reason: collision with root package name */
    static boolean f8123a = false;

    /* renamed from: b, reason: collision with root package name */
    static int f8124b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static int f8125c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<c3> f8126d;

    /* renamed from: e, reason: collision with root package name */
    private static int f8127e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends z3 {

        /* renamed from: f, reason: collision with root package name */
        static int f8128f = 1;

        /* renamed from: g, reason: collision with root package name */
        static int f8129g = 2;

        /* renamed from: h, reason: collision with root package name */
        static int f8130h = 3;

        /* renamed from: b, reason: collision with root package name */
        private Context f8131b;

        /* renamed from: c, reason: collision with root package name */
        private g3 f8132c;

        /* renamed from: d, reason: collision with root package name */
        private int f8133d;

        /* renamed from: e, reason: collision with root package name */
        private List<g3> f8134e;

        a(Context context, int i6) {
            this.f8131b = context;
            this.f8133d = i6;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            g3 g3Var;
            ByteArrayOutputStream byteArrayOutputStream;
            int i6 = this.f8133d;
            if (i6 == 1) {
                try {
                    if (this.f8131b != null && this.f8132c != null) {
                        synchronized (h3.class) {
                            try {
                                Context context = this.f8131b;
                                if (context != null && (g3Var = this.f8132c) != null) {
                                    h3.c(context, g3Var.b());
                                    return;
                                }
                                return;
                            } finally {
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    g2.o(th, ConstantHelper.LOG_STM, CommonNetImpl.AS);
                    return;
                }
            }
            if (i6 != 2) {
                if (i6 == 3) {
                    try {
                        if (this.f8131b == null) {
                            return;
                        }
                        c3 a6 = i3.a(h3.f8126d);
                        i3.e(this.f8131b, a6, e2.f8057h, 1000, 307200, "2");
                        if (a6.f7937g == null) {
                            a6.f7937g = new j3(new n3(this.f8131b, new k3(new o3(new q3()))));
                        }
                        a6.f7938h = 3600000;
                        if (TextUtils.isEmpty(a6.f7939i)) {
                            a6.f7939i = "cKey";
                        }
                        if (a6.f7936f == null) {
                            Context context2 = this.f8131b;
                            a6.f7936f = new u3(context2, a6.f7938h, a6.f7939i, new r3(a6.f7931a, new s3(context2, h3.f8123a, h3.f8125c * 1024, h3.f8124b * 1024, "staticUpdate", h3.f8127e * 1024)));
                        }
                        d3.a(a6);
                        return;
                    } catch (Throwable th2) {
                        g2.o(th2, ConstantHelper.LOG_STM, "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (h3.class) {
                    if (this.f8134e != null && this.f8131b != null) {
                        byte[] bArr = new byte[0];
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        try {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                for (g3 g3Var2 : this.f8134e) {
                                    if (g3Var2 != null) {
                                        byteArrayOutputStream.write(g3Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    g2.o(th, ConstantHelper.LOG_STM, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    h3.c(this.f8131b, bArr);
                                } finally {
                                }
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        h3.c(this.f8131b, bArr);
                    }
                }
            } catch (Throwable th6) {
                g2.o(th6, ConstantHelper.LOG_STM, "apb");
            }
        }

        a(Context context, int i6, List<g3> list) {
            this(context, i6);
            this.f8134e = list;
        }

        a(Context context, int i6, g3 g3Var) {
            this(context, i6);
            this.f8132c = g3Var;
        }
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        c3 a6 = i3.a(f8126d);
        i3.e(context, a6, e2.f8057h, 1000, 307200, "2");
        if (a6.f7935e == null) {
            a6.f7935e = new k2();
        }
        try {
            d3.c(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, a6);
        } catch (Throwable th) {
            g2.o(th, ConstantHelper.LOG_STM, "wts");
        }
    }

    public static synchronized void d(g3 g3Var, Context context) {
        synchronized (h3.class) {
            y3.e().c(new a(context, a.f8128f, g3Var));
        }
    }

    public static synchronized void e(List<g3> list, Context context) {
        synchronized (h3.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        y3.e().c(new a(context, a.f8129g, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void b(Context context) {
        y3.e().c(new a(context, a.f8130h));
    }
}
