package com.acse.ottn;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class q4 {

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, q4> f5028a = new WeakHashMap<>(0);

    public static q4 a(View view) {
        WeakHashMap<View, q4> weakHashMap = f5028a;
        q4 q4Var = weakHashMap.get(view);
        if (q4Var == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            q4Var = intValue >= 14 ? new s4(view) : intValue >= 11 ? new r4(view) : new t4(view);
            weakHashMap.put(view, q4Var);
        }
        return q4Var;
    }

    public abstract q4 a(float f6);

    public abstract q4 a(long j6);

    public abstract q4 a(Interpolator interpolator);

    public abstract q4 a(i.a aVar);

    public abstract void a();

    public abstract long b();

    public abstract q4 b(float f6);

    public abstract q4 b(long j6);

    public abstract long c();

    public abstract q4 c(float f6);

    public abstract q4 d(float f6);

    public abstract void d();

    public abstract q4 e(float f6);

    public abstract q4 f(float f6);

    public abstract q4 g(float f6);

    public abstract q4 h(float f6);

    public abstract q4 i(float f6);

    public abstract q4 j(float f6);

    public abstract q4 k(float f6);

    public abstract q4 l(float f6);

    public abstract q4 m(float f6);

    public abstract q4 n(float f6);

    public abstract q4 o(float f6);

    public abstract q4 p(float f6);

    public abstract q4 q(float f6);

    public abstract q4 r(float f6);

    public abstract q4 s(float f6);

    public abstract q4 t(float f6);
}
