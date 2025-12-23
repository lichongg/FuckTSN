package kotlin;

import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class v extends u {
    @InlineOnly
    private static final <T> T d(s<? extends T> sVar, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.g0.p(sVar, "<this>");
        kotlin.jvm.internal.g0.p(property, "property");
        return sVar.getValue();
    }

    @NotNull
    public static <T> s<T> e(T t5) {
        return new InitializedLazyImpl(t5);
    }
}
