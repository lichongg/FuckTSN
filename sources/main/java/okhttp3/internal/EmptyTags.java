package okhttp3.internal;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class EmptyTags extends Tags {

    @NotNull
    public static final EmptyTags INSTANCE = new EmptyTags();

    private EmptyTags() {
        super(null);
    }

    @Override // okhttp3.internal.Tags
    @Nullable
    public <T> T get(@NotNull kotlin.reflect.d<T> key) {
        g0.p(key, "key");
        return null;
    }

    @Override // okhttp3.internal.Tags
    @NotNull
    public <T> Tags plus(@NotNull kotlin.reflect.d<T> key, @Nullable T t5) {
        g0.p(key, "key");
        return t5 != null ? new LinkedTags(key, t5, this) : this;
    }

    @NotNull
    public String toString() {
        return "{}";
    }
}
