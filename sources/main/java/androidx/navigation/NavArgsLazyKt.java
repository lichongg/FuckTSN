package androidx.navigation;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavArgsLazyKt {

    @NotNull
    private static final Class<Bundle>[] methodSignature = {Bundle.class};

    @NotNull
    private static final ArrayMap<d<? extends NavArgs>, Method> methodMap = new ArrayMap<>();

    @NotNull
    public static final ArrayMap<d<? extends NavArgs>, Method> getMethodMap() {
        return methodMap;
    }

    @NotNull
    public static final Class<Bundle>[] getMethodSignature() {
        return methodSignature;
    }
}
