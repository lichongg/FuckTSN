package kotlin.reflect.jvm.internal.impl.km;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private final int f45332a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45333b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45334c;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f45332a == zVar.f45332a && this.f45333b == zVar.f45333b && this.f45334c == zVar.f45334c;
    }

    public final int a() {
        return this.f45332a;
    }

    public final int b() {
        return this.f45333b;
    }

    public final int c() {
        return this.f45334c;
    }

    public int hashCode() {
        return (((this.f45332a * 31) + this.f45333b) * 31) + this.f45334c;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f45332a);
        sb.append('.');
        sb.append(this.f45333b);
        sb.append('.');
        sb.append(this.f45334c);
        return sb.toString();
    }

    public z(int i6, int i7, int i8) {
        this.f45332a = i6;
        this.f45333b = i7;
        this.f45334c = i8;
    }
}
