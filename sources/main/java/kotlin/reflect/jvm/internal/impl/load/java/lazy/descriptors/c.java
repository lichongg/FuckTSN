package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f45539a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @Nullable
        public y3.n c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @Nullable
        public y3.w f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @NotNull
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<y3.r> e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return kotlin.collections.f0.J();
        }

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> a() {
            return u1.k();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return u1.k();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return u1.k();
        }
    }

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> a();

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> b();

    @Nullable
    y3.n c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> d();

    @NotNull
    Collection<y3.r> e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    y3.w f(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);
}
