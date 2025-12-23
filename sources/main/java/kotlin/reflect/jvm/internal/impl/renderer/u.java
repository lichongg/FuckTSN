package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface u {
    void a(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    boolean b();

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.c> c();

    boolean d();

    @NotNull
    AnnotationArgumentsRenderingPolicy e();

    void f(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set);

    void g(@NotNull Set<? extends DescriptorRendererModifier> set);

    void h(boolean z5);

    void i(boolean z5);

    void j(boolean z5);

    void k(boolean z5);

    void l(boolean z5);

    void m(boolean z5);

    void n(@NotNull RenderingFormat renderingFormat);

    void o(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    void p(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar);

    void q(boolean z5);

    void setVerbose(boolean z5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static boolean a(@NotNull u uVar) {
            return uVar.e().getIncludeAnnotationArguments();
        }

        public static boolean b(@NotNull u uVar) {
            return uVar.e().getIncludeEmptyAnnotationArguments();
        }
    }
}
