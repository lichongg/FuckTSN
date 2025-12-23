package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public class MethodCallsLogger {

    @NotNull
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(@NotNull String name, int i6) {
        g0.p(name, "name");
        Integer num = this.calledMethods.get(name);
        int intValue = num != null ? num.intValue() : 0;
        boolean z5 = (intValue & i6) != 0;
        this.calledMethods.put(name, Integer.valueOf(i6 | intValue));
        return !z5;
    }
}
