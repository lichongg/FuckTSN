package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((s) hVar).c(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    public Object get(Object obj) {
        return n0().call(obj);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference1Impl(Class cls, String str, String str2, int i6) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }
}
