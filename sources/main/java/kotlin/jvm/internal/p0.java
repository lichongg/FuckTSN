package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f44039a = "kotlin.jvm.functions.";

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public kotlin.reflect.r g(kotlin.reflect.r rVar) {
        x0 x0Var = (x0) rVar;
        return new x0(rVar.n(), rVar.getArguments(), x0Var.s(), x0Var.l() | 2);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public kotlin.reflect.r k(kotlin.reflect.r rVar) {
        x0 x0Var = (x0) rVar;
        return new x0(rVar.n(), rVar.getArguments(), x0Var.s(), x0Var.l() | 4);
    }

    public kotlin.reflect.d a(Class cls) {
        return new t(cls);
    }

    public kotlin.reflect.d b(Class cls, String str) {
        return new t(cls);
    }

    public kotlin.reflect.d d(Class cls) {
        return new t(cls);
    }

    public kotlin.reflect.d e(Class cls, String str) {
        return new t(cls);
    }

    public kotlin.reflect.h f(Class cls, String str) {
        return new m0(cls, str);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public kotlin.reflect.r l(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return new x0(rVar.n(), rVar.getArguments(), rVar2, ((x0) rVar).l());
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public void r(kotlin.reflect.s sVar, List<kotlin.reflect.r> list) {
        ((v0) sVar).b(list);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public kotlin.reflect.r s(kotlin.reflect.g gVar, List<kotlin.reflect.t> list, boolean z5) {
        return new x0(gVar, list, z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public kotlin.reflect.s t(Object obj, String str, KVariance kVariance, boolean z5) {
        return new v0(obj, str, kVariance, z5);
    }

    @SinceKotlin(version = "1.3")
    public String p(c0 c0Var) {
        String obj = c0Var.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith(f44039a)) {
            return obj.substring(21);
        }
        return obj;
    }

    @SinceKotlin(version = "1.1")
    public String q(Lambda lambda) {
        return p(lambda);
    }

    public kotlin.reflect.i c(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.k h(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.l i(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.m j(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public kotlin.reflect.o m(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.p n(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.q o(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }
}
