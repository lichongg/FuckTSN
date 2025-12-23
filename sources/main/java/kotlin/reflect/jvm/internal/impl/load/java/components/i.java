package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements i {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f45397a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.i
        @Nullable
        public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(@NotNull y3.n field, @NotNull w0 descriptor) {
            g0.p(field, "field");
            g0.p(descriptor, "descriptor");
            return null;
        }

        private a() {
        }
    }

    @Nullable
    kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(@NotNull y3.n nVar, @NotNull w0 w0Var);
}
