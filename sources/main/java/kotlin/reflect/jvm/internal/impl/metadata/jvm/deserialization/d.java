package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f46304a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f46305b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return g0.g(this.f46304a, aVar.f46304a) && g0.g(this.f46305b, aVar.f46305b);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String name, @NotNull String desc) {
            super(null);
            g0.p(name, "name");
            g0.p(desc, "desc");
            this.f46304a = name;
            this.f46305b = desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String a() {
            return e() + ':' + d();
        }

        @NotNull
        public final String b() {
            return this.f46304a;
        }

        @NotNull
        public final String c() {
            return this.f46305b;
        }

        @NotNull
        public String d() {
            return this.f46305b;
        }

        @NotNull
        public String e() {
            return this.f46304a;
        }

        public int hashCode() {
            return (this.f46304a.hashCode() * 31) + this.f46305b.hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f46306a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f46307b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return g0.g(this.f46306a, bVar.f46306a) && g0.g(this.f46307b, bVar.f46307b);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String name, @NotNull String desc) {
            super(null);
            g0.p(name, "name");
            g0.p(desc, "desc");
            this.f46306a = name;
            this.f46307b = desc;
        }

        public static /* synthetic */ b c(b bVar, String str, String str2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = bVar.f46306a;
            }
            if ((i6 & 2) != 0) {
                str2 = bVar.f46307b;
            }
            return bVar.b(str, str2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d
        @NotNull
        public String a() {
            return e() + d();
        }

        @NotNull
        public final b b(@NotNull String name, @NotNull String desc) {
            g0.p(name, "name");
            g0.p(desc, "desc");
            return new b(name, desc);
        }

        @NotNull
        public String d() {
            return this.f46307b;
        }

        @NotNull
        public String e() {
            return this.f46306a;
        }

        public int hashCode() {
            return (this.f46306a.hashCode() * 31) + this.f46307b.hashCode();
        }
    }

    public /* synthetic */ d(v vVar) {
        this();
    }

    @NotNull
    public abstract String a();

    private d() {
    }

    @NotNull
    public final String toString() {
        return a();
    }
}
