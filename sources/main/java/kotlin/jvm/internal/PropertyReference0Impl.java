package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((s) hVar).c(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.o
    public Object get() {
        return n0().call(new Object[0]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference0Impl(Class cls, String str, String str2, int i6) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }
}
