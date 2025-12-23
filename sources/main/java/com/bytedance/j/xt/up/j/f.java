package com.bytedance.j.xt.up.j;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.j.xt.cw;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile f f24284e;

    /* renamed from: a, reason: collision with root package name */
    private Context f24285a;

    /* renamed from: b, reason: collision with root package name */
    private Map<cw, b> f24286b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private h f24287c;

    /* renamed from: d, reason: collision with root package name */
    private e f24288d;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24289a;

        static {
            int[] iArr = new int[cw.values().length];
            f24289a = iArr;
            try {
                iArr[cw.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24289a[cw.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24289a[cw.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Nullable
    private b b(cw cwVar) {
        b bVar = this.f24286b.get(cwVar);
        if (bVar != null) {
            return bVar;
        }
        int i6 = a.f24289a[cwVar.ordinal()];
        if (i6 == 1) {
            bVar = new com.bytedance.j.xt.up.j.a(this.f24285a, this.f24287c, this.f24288d);
        } else if (i6 == 2) {
            bVar = new c(this.f24285a, this.f24287c, this.f24288d);
        } else if (i6 == 3) {
            bVar = new d(this.f24285a, this.f24287c, this.f24288d);
        }
        if (bVar != null) {
            this.f24286b.put(cwVar, bVar);
        }
        return bVar;
    }

    public static f c() {
        if (f24284e != null) {
            return f24284e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f24284e == null) {
            f24284e = new f(context);
        }
    }

    public com.bytedance.j.xt.cw.b a(cw cwVar, com.bytedance.j.xt.cw.b bVar) {
        b b6;
        return (cwVar == null || (b6 = b(cwVar)) == null) ? bVar : b6.b(bVar);
    }

    private f(@NonNull Context context) {
        this.f24285a = context;
        this.f24287c = new h(this.f24285a);
        this.f24288d = new e(this.f24285a);
    }
}
