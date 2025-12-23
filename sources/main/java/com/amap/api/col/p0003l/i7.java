package com.amap.api.col.p0003l;

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
public class i7 {

    /* renamed from: a, reason: collision with root package name */
    static boolean f6509a = false;

    /* renamed from: b, reason: collision with root package name */
    static int f6510b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static int f6511c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<c7> f6512d;

    /* renamed from: e, reason: collision with root package name */
    private static int f6513e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends b8 {

        /* renamed from: i, reason: collision with root package name */
        static int f6514i = 1;

        /* renamed from: j, reason: collision with root package name */
        static int f6515j = 2;

        /* renamed from: k, reason: collision with root package name */
        static int f6516k = 3;

        /* renamed from: d, reason: collision with root package name */
        private Context f6517d;

        /* renamed from: e, reason: collision with root package name */
        private h7 f6518e;

        /* renamed from: g, reason: collision with root package name */
        private int f6519g;

        /* renamed from: h, reason: collision with root package name */
        private List<h7> f6520h;

        a(Context context, int i6) {
            this.f6517d = context;
            this.f6519g = i6;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            h7 h7Var;
            ByteArrayOutputStream byteArrayOutputStream;
            int i6 = this.f6519g;
            if (i6 == 1) {
                try {
                    if (this.f6517d != null && this.f6518e != null) {
                        synchronized (i7.class) {
                            try {
                                Context context = this.f6517d;
                                if (context != null && (h7Var = this.f6518e) != null) {
                                    i7.c(context, h7Var.b());
                                    return;
                                }
                                return;
                            } finally {
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    v5.p(th, ConstantHelper.LOG_STM, CommonNetImpl.AS);
                    return;
                }
            }
            if (i6 != 2) {
                if (i6 == 3) {
                    try {
                        if (this.f6517d == null) {
                            return;
                        }
                        c7 a6 = j7.a(i7.f6512d);
                        j7.f(this.f6517d, a6, s5.f7238h, 1000, 307200, "2");
                        if (a6.f5855g == null) {
                            a6.f5855g = new k7(new o7(this.f6517d, new l7(new p7(new r7()))));
                        }
                        a6.f5856h = 3600000;
                        if (TextUtils.isEmpty(a6.f5857i)) {
                            a6.f5857i = "cKey";
                        }
                        if (a6.f5854f == null) {
                            Context context2 = this.f6517d;
                            a6.f5854f = new w7(context2, a6.f5856h, a6.f5857i, new s7(a6.f5849a, new u7(context2, i7.f6509a, i7.f6511c * 1024, i7.f6510b * 1024, "staticUpdate", i7.f6513e * 1024)));
                        }
                        d7.a(a6);
                        return;
                    } catch (Throwable th2) {
                        v5.p(th2, ConstantHelper.LOG_STM, "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (i7.class) {
                    if (this.f6520h != null && this.f6517d != null) {
                        byte[] bArr = new byte[0];
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        try {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                for (h7 h7Var2 : this.f6520h) {
                                    if (h7Var2 != null) {
                                        byteArrayOutputStream.write(h7Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    v5.p(th, ConstantHelper.LOG_STM, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    i7.c(this.f6517d, bArr);
                                } finally {
                                }
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        i7.c(this.f6517d, bArr);
                    }
                }
            } catch (Throwable th6) {
                v5.p(th6, ConstantHelper.LOG_STM, "apb");
            }
        }

        a(Context context, int i6, List<h7> list) {
            this(context, i6);
            this.f6520h = list;
        }

        a(Context context, int i6, h7 h7Var) {
            this(context, i6);
            this.f6518e = h7Var;
        }
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        c7 a6 = j7.a(f6512d);
        j7.f(context, a6, s5.f7238h, 1000, 307200, "2");
        if (a6.f5853e == null) {
            a6.f5853e = new h6();
        }
        try {
            d7.c(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, a6);
        } catch (Throwable th) {
            v5.p(th, ConstantHelper.LOG_STM, "wts");
        }
    }

    public static synchronized void d(h7 h7Var, Context context) {
        synchronized (i7.class) {
            a8.h().b(new a(context, a.f6514i, h7Var));
        }
    }

    public static synchronized void e(List<h7> list, Context context) {
        synchronized (i7.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        a8.h().b(new a(context, a.f6515j, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void f(boolean z5, int i6) {
        synchronized (i7.class) {
            f6509a = z5;
            f6513e = Math.max(0, i6);
        }
    }

    public static synchronized void h(List<h7> list, Context context) {
        synchronized (i7.class) {
            try {
                List<h7> q5 = v6.q();
                if (q5 != null && q5.size() > 0) {
                    list.addAll(q5);
                }
            } catch (Throwable unused) {
            }
            e(list, context);
        }
    }

    public static void b(Context context) {
        a8.h().b(new a(context, a.f6516k));
    }
}
