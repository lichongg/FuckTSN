package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(((s) hVar).c(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.q
    public Object get(Object obj, Object obj2) {
        return n0().call(obj, obj2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference2Impl(Class cls, String str, String str2, int i6) {
        super(cls, str, str2, i6);
    }
}
