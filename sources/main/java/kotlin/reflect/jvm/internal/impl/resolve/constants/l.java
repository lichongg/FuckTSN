package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class l extends g<n1> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f46670b = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final l a(@NotNull String message) {
            g0.p(message, "message");
            return new b(message);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends l {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f46671c;

        public b(@NotNull String message) {
            g0.p(message, "message");
            this.f46671c = message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.error.g getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
            g0.p(module, "module");
            return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.ERROR_CONSTANT_VALUE, this.f46671c);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        @NotNull
        public String toString() {
            return this.f46671c;
        }
    }

    public l() {
        super(n1.f44123a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n1 a() {
        throw new UnsupportedOperationException();
    }
}
