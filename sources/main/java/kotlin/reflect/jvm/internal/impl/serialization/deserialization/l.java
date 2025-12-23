package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f46991a = a.f46992a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f46992a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final l f46993b = new C0917a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.l$a$a, reason: collision with other inner class name */
        public static final class C0917a implements l {
            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.l
            public Pair a(ProtoBuf.Function proto, kotlin.reflect.jvm.internal.impl.descriptors.y ownerFunction, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, v0 typeDeserializer) {
                kotlin.jvm.internal.g0.p(proto, "proto");
                kotlin.jvm.internal.g0.p(ownerFunction, "ownerFunction");
                kotlin.jvm.internal.g0.p(typeTable, "typeTable");
                kotlin.jvm.internal.g0.p(typeDeserializer, "typeDeserializer");
                return null;
            }

            C0917a() {
            }
        }

        @NotNull
        public final l a() {
            return f46993b;
        }

        private a() {
        }
    }

    @Nullable
    Pair<a.InterfaceC0876a<?>, Object> a(@NotNull ProtoBuf.Function function, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, @NotNull v0 v0Var);
}
