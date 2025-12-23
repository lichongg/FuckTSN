package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface g<M extends Member> {
    boolean a();

    @NotNull
    List<Type> b();

    M c();

    @Nullable
    Object call(@NotNull Object[] objArr);

    @NotNull
    Type getReturnType();
}
