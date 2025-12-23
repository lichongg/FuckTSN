package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface v extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.z {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.v$a$a, reason: collision with other inner class name */
        public static final class C0900a extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final byte[] f46005a;

            @NotNull
            public final byte[] b() {
                return this.f46005a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final x f46006a;

            /* renamed from: b, reason: collision with root package name */
            @Nullable
            private final byte[] f46007b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull x kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                kotlin.jvm.internal.g0.p(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f46006a = kotlinJvmBinaryClass;
                this.f46007b = bArr;
            }

            public /* synthetic */ b(x xVar, byte[] bArr, int i6, kotlin.jvm.internal.v vVar) {
                this(xVar, (i6 & 2) != 0 ? null : bArr);
            }

            @NotNull
            public final x b() {
                return this.f46006a;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @Nullable
        public final x a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }
    }

    @Nullable
    a a(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar);

    @Nullable
    a b(@NotNull y3.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar);
}
