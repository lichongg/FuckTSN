package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c {
    @NotNull
    Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a();

    @Nullable
    kotlin.reflect.jvm.internal.impl.name.c d();

    @NotNull
    e1 getSource();

    @NotNull
    t0 getType();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAnnotationDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationDescriptor.kt\norg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
    public static final class a {
        @Nullable
        public static kotlin.reflect.jvm.internal.impl.name.c a(@NotNull c cVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.d l6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(cVar);
            if (l6 != null) {
                if (kotlin.reflect.jvm.internal.impl.types.error.i.m(l6)) {
                    l6 = null;
                }
                if (l6 != null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.k(l6);
                }
            }
            return null;
        }
    }
}
