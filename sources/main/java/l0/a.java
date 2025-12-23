package l0;

import androidx.camera.camera2.internal.compat.params.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f49683a;

    /* renamed from: b, reason: collision with root package name */
    private final long f49684b;

    /* renamed from: c, reason: collision with root package name */
    private final long f49685c;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f49683a == aVar.f49683a && this.f49684b == aVar.f49684b && this.f49685c == aVar.f49685c;
    }

    public static /* synthetic */ a e(a aVar, long j6, long j7, long j8, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = aVar.f49683a;
        }
        long j9 = j6;
        if ((i6 & 2) != 0) {
            j7 = aVar.f49684b;
        }
        long j10 = j7;
        if ((i6 & 4) != 0) {
            j8 = aVar.f49685c;
        }
        return aVar.d(j9, j10, j8);
    }

    public final long a() {
        return this.f49683a;
    }

    public final long b() {
        return this.f49684b;
    }

    public final long c() {
        return this.f49685c;
    }

    @NotNull
    public final a d(long j6, long j7, long j8) {
        return new a(j6, j7, j8);
    }

    public final long f() {
        return this.f49683a;
    }

    public final long g() {
        return this.f49684b;
    }

    public final long h() {
        return this.f49685c;
    }

    public int hashCode() {
        return (((e.a(this.f49683a) * 31) + e.a(this.f49684b)) * 31) + e.a(this.f49685c);
    }

    @NotNull
    public String toString() {
        return "CountDistanceTime(count=" + this.f49683a + ", distance=" + this.f49684b + ", time=" + this.f49685c + ")";
    }

    public a(long j6, long j7, long j8) {
        this.f49683a = j6;
        this.f49684b = j7;
        this.f49685c = j8;
    }
}
