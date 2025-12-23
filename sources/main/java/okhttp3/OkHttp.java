package okhttp3;

import android.content.Context;
import com.stub.StubApp;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import okhttp3.internal._InternalVersionKt;
import okhttp3.internal.platform.PlatformRegistry;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class OkHttp {

    @NotNull
    public static final OkHttp INSTANCE = new OkHttp();

    @JvmField
    @NotNull
    public static final String VERSION = _InternalVersionKt.CONST_VERSION;

    public final void initialize(@NotNull Context applicationContext) {
        g0.p(applicationContext, "applicationContext");
        PlatformRegistry platformRegistry = PlatformRegistry.INSTANCE;
        if (StubApp.getOrigApplicationContext(platformRegistry.getApplicationContext()) == null) {
            platformRegistry.setApplicationContext(StubApp.getOrigApplicationContext(applicationContext.getApplicationContext()));
        }
    }

    private OkHttp() {
    }
}
