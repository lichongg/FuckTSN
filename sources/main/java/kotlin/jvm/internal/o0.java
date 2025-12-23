package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Arrays;
import java.util.Collections;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.g3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    private static final p0 f44035a;

    /* renamed from: b, reason: collision with root package name */
    static final String f44036b = " (Kotlin reflection is not available)";

    /* renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.d[] f44037c;

    static {
        p0 p0Var = null;
        try {
            p0Var = (p0) g3.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (p0Var == null) {
            p0Var = new p0();
        }
        f44035a = p0Var;
        f44037c = new kotlin.reflect.d[0];
    }

    public static kotlin.reflect.d[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f44037c;
        }
        kotlin.reflect.d[] dVarArr = new kotlin.reflect.d[length];
        for (int i6 = 0; i6 < length; i6++) {
            dVarArr[i6] = d(clsArr[i6]);
        }
        return dVarArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r A(Class cls) {
        return f44035a.s(d(cls), Collections.EMPTY_LIST, false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r B(Class cls, kotlin.reflect.t tVar) {
        return f44035a.s(d(cls), Collections.singletonList(tVar), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r C(Class cls, kotlin.reflect.t tVar, kotlin.reflect.t tVar2) {
        return f44035a.s(d(cls), Arrays.asList(tVar, tVar2), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r D(Class cls, kotlin.reflect.t... tVarArr) {
        return f44035a.s(d(cls), kotlin.collections.n.dz(tVarArr), false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r E(kotlin.reflect.g gVar) {
        return f44035a.s(gVar, Collections.EMPTY_LIST, false);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.s F(Object obj, String str, KVariance kVariance, boolean z5) {
        return f44035a.t(obj, str, kVariance, z5);
    }

    public static kotlin.reflect.d a(Class cls) {
        return f44035a.a(cls);
    }

    public static kotlin.reflect.d b(Class cls, String str) {
        return f44035a.b(cls, str);
    }

    public static kotlin.reflect.i c(FunctionReference functionReference) {
        return f44035a.c(functionReference);
    }

    public static kotlin.reflect.d d(Class cls) {
        return f44035a.d(cls);
    }

    public static kotlin.reflect.d e(Class cls, String str) {
        return f44035a.e(cls, str);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.h g(Class cls) {
        return f44035a.f(cls, "");
    }

    public static kotlin.reflect.h h(Class cls, String str) {
        return f44035a.f(cls, str);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static kotlin.reflect.r i(kotlin.reflect.r rVar) {
        return f44035a.g(rVar);
    }

    public static kotlin.reflect.k j(MutablePropertyReference0 mutablePropertyReference0) {
        return f44035a.h(mutablePropertyReference0);
    }

    public static kotlin.reflect.l k(MutablePropertyReference1 mutablePropertyReference1) {
        return f44035a.i(mutablePropertyReference1);
    }

    public static kotlin.reflect.m l(MutablePropertyReference2 mutablePropertyReference2) {
        return f44035a.j(mutablePropertyReference2);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static kotlin.reflect.r m(kotlin.reflect.r rVar) {
        return f44035a.k(rVar);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r n(Class cls) {
        return f44035a.s(d(cls), Collections.EMPTY_LIST, true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r o(Class cls, kotlin.reflect.t tVar) {
        return f44035a.s(d(cls), Collections.singletonList(tVar), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r p(Class cls, kotlin.reflect.t tVar, kotlin.reflect.t tVar2) {
        return f44035a.s(d(cls), Arrays.asList(tVar, tVar2), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r q(Class cls, kotlin.reflect.t... tVarArr) {
        return f44035a.s(d(cls), kotlin.collections.n.dz(tVarArr), true);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static kotlin.reflect.r r(kotlin.reflect.g gVar) {
        return f44035a.s(gVar, Collections.EMPTY_LIST, true);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static kotlin.reflect.r s(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return f44035a.l(rVar, rVar2);
    }

    public static kotlin.reflect.o t(PropertyReference0 propertyReference0) {
        return f44035a.m(propertyReference0);
    }

    public static kotlin.reflect.p u(PropertyReference1 propertyReference1) {
        return f44035a.n(propertyReference1);
    }

    public static kotlin.reflect.q v(PropertyReference2 propertyReference2) {
        return f44035a.o(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    public static String w(c0 c0Var) {
        return f44035a.p(c0Var);
    }

    @SinceKotlin(version = "1.1")
    public static String x(Lambda lambda) {
        return f44035a.q(lambda);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void y(kotlin.reflect.s sVar, kotlin.reflect.r rVar) {
        f44035a.r(sVar, Collections.singletonList(rVar));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void z(kotlin.reflect.s sVar, kotlin.reflect.r... rVarArr) {
        f44035a.r(sVar, kotlin.collections.n.dz(rVarArr));
    }
}
