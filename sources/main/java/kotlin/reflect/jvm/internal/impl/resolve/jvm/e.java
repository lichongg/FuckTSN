package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f46718a = a.f46719a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f46719a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final kotlin.reflect.jvm.internal.impl.resolve.jvm.a f46720b = new kotlin.reflect.jvm.internal.impl.resolve.jvm.a(f0.J());

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.jvm.a a() {
            return f46720b;
        }

        private a() {
        }
    }

    void a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.c> list, @NotNull k kVar);

    @NotNull
    k0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull k0 k0Var, @NotNull k kVar);

    @NotNull
    List<f> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull k kVar);

    @NotNull
    List<f> d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull k kVar);

    void e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f fVar, @NotNull Collection<d1> collection, @NotNull k kVar);

    void f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f fVar, @NotNull Collection<d1> collection, @NotNull k kVar);

    @NotNull
    List<f> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull k kVar);

    void h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f fVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.d> list, @NotNull k kVar);
}
