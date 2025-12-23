package kotlin;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p implements Comparable<p> {

    /* renamed from: f, reason: collision with root package name */
    public static final int f44125f = 255;

    /* renamed from: a, reason: collision with root package name */
    private final int f44127a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44128b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44129c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44130d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44124e = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final p f44126g = q.a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public p(int i6, int i7, int i8) {
        this.f44127a = i6;
        this.f44128b = i7;
        this.f44129c = i8;
        this.f44130d = j(i6, i7, i8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        p pVar = obj instanceof p ? (p) obj : null;
        return pVar != null && this.f44130d == pVar.f44130d;
    }

    private final int j(int i6, int i7, int i8) {
        if (i6 >= 0 && i6 < 256 && i7 >= 0 && i7 < 256 && i8 >= 0 && i8 < 256) {
            return (i6 << 16) + (i7 << 8) + i8;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i6 + '.' + i7 + '.' + i8).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull p other) {
        kotlin.jvm.internal.g0.p(other, "other");
        return this.f44130d - other.f44130d;
    }

    public final int b() {
        return this.f44127a;
    }

    public final int c() {
        return this.f44128b;
    }

    public final int d() {
        return this.f44129c;
    }

    public final boolean h(int i6, int i7) {
        int i8 = this.f44127a;
        if (i8 <= i6) {
            return i8 == i6 && this.f44128b >= i7;
        }
        return true;
    }

    public int hashCode() {
        return this.f44130d;
    }

    public final boolean i(int i6, int i7, int i8) {
        int i9 = this.f44127a;
        if (i9 > i6) {
            return true;
        }
        if (i9 != i6) {
            return false;
        }
        int i10 = this.f44128b;
        if (i10 <= i7) {
            return i10 == i7 && this.f44129c >= i8;
        }
        return true;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f44127a);
        sb.append('.');
        sb.append(this.f44128b);
        sb.append('.');
        sb.append(this.f44129c);
        return sb.toString();
    }

    public p(int i6, int i7) {
        this(i6, i7, 0);
    }
}
