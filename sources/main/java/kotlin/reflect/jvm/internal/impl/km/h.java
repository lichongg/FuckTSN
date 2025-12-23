package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends h {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45157a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && g0.g(this.f45157a, ((a) obj).f45157a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String name) {
            super(null);
            g0.p(name, "name");
            this.f45157a = name;
        }

        @NotNull
        public final String a() {
            return this.f45157a;
        }

        public int hashCode() {
            return this.f45157a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Class(name=" + this.f45157a + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends h {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45158a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && g0.g(this.f45158a, ((b) obj).f45158a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String name) {
            super(null);
            g0.p(name, "name");
            this.f45158a = name;
        }

        @NotNull
        public final String a() {
            return this.f45158a;
        }

        public int hashCode() {
            return this.f45158a.hashCode();
        }

        @NotNull
        public String toString() {
            return "TypeAlias(name=" + this.f45158a + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends h {

        /* renamed from: a, reason: collision with root package name */
        private final int f45159a;

        public c(int i6) {
            super(null);
            this.f45159a = i6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f45159a == ((c) obj).f45159a;
        }

        public final int a() {
            return this.f45159a;
        }

        public int hashCode() {
            return this.f45159a;
        }

        @NotNull
        public String toString() {
            return "TypeParameter(id=" + this.f45159a + ')';
        }
    }

    public /* synthetic */ h(kotlin.jvm.internal.v vVar) {
        this();
    }

    private h() {
    }
}
