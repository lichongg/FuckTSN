package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface x {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2);

        @Nullable
        a b(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

        void c(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2);

        void d(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable Object obj);

        @Nullable
        b e(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar);

        void visitEnd();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(@Nullable Object obj);

        @Nullable
        a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

        void c(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        void d(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar);

        void visitEnd();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        @Nullable
        a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull e1 e1Var);

        void visitEnd();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        @Nullable
        e a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull String str);

        @Nullable
        c b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull String str, @Nullable Object obj);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e extends c {
        @Nullable
        a a(int i6, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull e1 e1Var);
    }

    @NotNull
    kotlin.reflect.jvm.internal.impl.name.b c();

    void d(@NotNull d dVar, @Nullable byte[] bArr);

    @NotNull
    KotlinClassHeader e();

    void f(@NotNull c cVar, @Nullable byte[] bArr);

    @NotNull
    String getLocation();
}
