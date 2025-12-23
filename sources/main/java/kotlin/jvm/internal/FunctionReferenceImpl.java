package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i6, kotlin.reflect.h hVar, String str, String str2) {
        super(i6, CallableReference.NO_RECEIVER, ((s) hVar).c(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public FunctionReferenceImpl(int i6, Class cls, String str, String str2, int i7) {
        super(i6, CallableReference.NO_RECEIVER, cls, str, str2, i7);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public FunctionReferenceImpl(int i6, Object obj, Class cls, String str, String str2, int i7) {
        super(i6, obj, cls, str, str2, i7);
    }
}
