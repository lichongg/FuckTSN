package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.m;
import kotlin.reflect.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements kotlin.reflect.m {
    public MutablePropertyReference2() {
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference2(Class cls, String str, String str2, int i6) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i6);
    }

    @Override // kotlin.reflect.n
    /* renamed from: getGetter */
    public q.a n0() {
        return ((kotlin.reflect.m) getReflected()).n0();
    }

    @Override // kotlin.reflect.j
    public m.a getSetter() {
        return ((kotlin.reflect.m) getReflected()).getSetter();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return o0.l(this);
    }

    @Override // kotlin.reflect.q
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }
}
