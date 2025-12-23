package okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PlatformInitializer implements Initializer<Platform> {
    @Override // androidx.startup.Initializer
    @NotNull
    public Platform create(@NotNull Context context) {
        g0.p(context, "context");
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.Companion.get();
    }

    @Override // androidx.startup.Initializer
    @NotNull
    public List<Class<Initializer<?>>> dependencies() {
        return f0.J();
    }
}
