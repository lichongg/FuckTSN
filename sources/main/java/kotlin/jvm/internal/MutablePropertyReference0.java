package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.k;
import kotlin.reflect.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.k {
    public MutablePropertyReference0() {
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public o.a getGetter() {
        return ((kotlin.reflect.k) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.j
    public k.a getSetter() {
        return ((kotlin.reflect.k) getReflected()).getSetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return o0.j(this);
    }

    @Override // kotlin.reflect.o
    @SinceKotlin(version = "1.1")
    public Object getDelegate() {
        return ((kotlin.reflect.k) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
