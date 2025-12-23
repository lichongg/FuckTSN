package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b implements e1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Annotation f44964b;

    public b(@NotNull Annotation annotation) {
        g0.p(annotation, "annotation");
        this.f44964b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    @NotNull
    public f1 b() {
        f1 NO_SOURCE_FILE = f1.f44684a;
        g0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final Annotation d() {
        return this.f44964b;
    }
}
