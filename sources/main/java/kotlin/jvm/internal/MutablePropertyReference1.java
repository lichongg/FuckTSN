package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.reflect.l;
import kotlin.reflect.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.l {
    public MutablePropertyReference1() {
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    /* renamed from: getGetter */
    public p.a n0() {
        return ((kotlin.reflect.l) getReflected()).n0();
    }

    @Override // kotlin.reflect.j
    public l.a getSetter() {
        return ((kotlin.reflect.l) getReflected()).getSetter();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.c computeReflected() {
        return o0.k(this);
    }

    @Override // kotlin.reflect.p
    @SinceKotlin(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.l) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }
}
