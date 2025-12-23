package kotlinx.coroutines.internal;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final String f49313a;

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(@Nullable Object obj) {
        if (obj == this) {
            return null;
        }
        return obj;
    }

    @NotNull
    public String toString() {
        return kotlin.text.v0.f47961e + this.f49313a + kotlin.text.v0.f47962f;
    }

    public s0(@NotNull String str) {
        this.f49313a = str;
    }
}
