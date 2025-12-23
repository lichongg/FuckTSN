package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45861b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f45862a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final a0 a(@NotNull String name, @NotNull String desc) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(desc, "desc");
            return new a0(name + '#' + desc, null);
        }

        @JvmStatic
        @NotNull
        public final a0 b(@NotNull kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d signature) {
            kotlin.jvm.internal.g0.p(signature, "signature");
            if (signature instanceof d.b) {
                d.b bVar = (d.b) signature;
                return d(bVar.e(), bVar.d());
            }
            if (!(signature instanceof d.a)) {
                throw new NoWhenBranchMatchedException();
            }
            d.a aVar = (d.a) signature;
            return a(aVar.e(), aVar.d());
        }

        @JvmStatic
        @NotNull
        public final a0 c(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature signature) {
            kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
            kotlin.jvm.internal.g0.p(signature, "signature");
            return d(nameResolver.getString(signature.getName()), nameResolver.getString(signature.getDesc()));
        }

        @JvmStatic
        @NotNull
        public final a0 d(@NotNull String name, @NotNull String desc) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(desc, "desc");
            return new a0(name + desc, null);
        }

        @JvmStatic
        @NotNull
        public final a0 e(@NotNull a0 signature, int i6) {
            kotlin.jvm.internal.g0.p(signature, "signature");
            return new a0(signature.a() + '@' + i6, null);
        }
    }

    public /* synthetic */ a0(String str, kotlin.jvm.internal.v vVar) {
        this(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && kotlin.jvm.internal.g0.g(this.f45862a, ((a0) obj).f45862a);
    }

    private a0(String str) {
        this.f45862a = str;
    }

    @NotNull
    public final String a() {
        return this.f45862a;
    }

    public int hashCode() {
        return this.f45862a.hashCode();
    }

    @NotNull
    public String toString() {
        return "MemberSignature(signature=" + this.f45862a + ')';
    }
}
