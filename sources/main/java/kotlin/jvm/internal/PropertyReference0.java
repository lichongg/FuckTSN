package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.o {
    public PropertyReference0() {
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public o.a getGetter() {
        return ((kotlin.reflect.o) getReflected()).getGetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return o0.t(this);
    }

    @Override // kotlin.reflect.o
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.o) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
