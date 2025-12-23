package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectKotlinClassFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectKotlinClassFinder.kt\norg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClassFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g implements v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ClassLoader f44970a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.d f44971b;

    public g(@NotNull ClassLoader classLoader) {
        g0.p(classLoader, "classLoader");
        this.f44970a = classLoader;
        this.f44971b = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.d();
    }

    private final v.a d(String str) {
        f a6;
        Class<?> a7 = e.a(this.f44970a, str);
        if (a7 == null || (a6 = f.f44967c.a(a7)) == null) {
            return null;
        }
        return new v.a.b(a6, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.v
    @Nullable
    public v.a a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        String b6;
        g0.p(classId, "classId");
        g0.p(metadataVersion, "metadataVersion");
        b6 = h.b(classId);
        return d(b6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.v
    @Nullable
    public v.a b(@NotNull y3.g javaClass, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
        String a6;
        g0.p(javaClass, "javaClass");
        g0.p(metadataVersion, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.name.c d6 = javaClass.d();
        if (d6 == null || (a6 = d6.a()) == null) {
            return null;
        }
        return d(a6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.z
    @Nullable
    public InputStream c(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        g0.p(packageFqName, "packageFqName");
        if (packageFqName.h(o.A)) {
            return this.f44971b.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f46819r.r(packageFqName));
        }
        return null;
    }
}
