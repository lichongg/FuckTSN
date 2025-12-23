package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.resolve.jvm.c f45695a;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull y3.g javaClass) {
        g0.p(javaClass, "javaClass");
        return b().b(javaClass);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.c b() {
        kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar = this.f45695a;
        if (cVar != null) {
            return cVar;
        }
        g0.S("resolver");
        return null;
    }

    public final void c(@NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar) {
        g0.p(cVar, "<set-?>");
        this.f45695a = cVar;
    }
}
