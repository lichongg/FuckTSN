package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h implements y3.b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45012b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.name.f f45013a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final h a(@NotNull Object value, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.jvm.internal.g0.p(value, "value");
            return f.l(value.getClass()) ? new v(fVar, (Enum) value) : value instanceof Annotation ? new i(fVar, (Annotation) value) : value instanceof Object[] ? new l(fVar, (Object[]) value) : value instanceof Class ? new r(fVar, (Class) value) : new x(fVar, value);
        }
    }

    public /* synthetic */ h(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.jvm.internal.v vVar) {
        this(fVar);
    }

    private h(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        this.f45013a = fVar;
    }

    @Override // y3.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        return this.f45013a;
    }
}
