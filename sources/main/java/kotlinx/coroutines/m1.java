package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m1 implements y1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f49382a;

    @Override // kotlinx.coroutines.y1
    @Nullable
    public q2 a() {
        return null;
    }

    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return this.f49382a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }

    public m1(boolean z5) {
        this.f49382a = z5;
    }
}
