package okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import okhttp3.internal.platform.android.AndroidLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PlatformRegistry {

    @NotNull
    public static final PlatformRegistry INSTANCE = new PlatformRegistry();

    public final boolean isAndroid() {
        return true;
    }

    @NotNull
    public final Platform findPlatform() {
        AndroidLog.INSTANCE.enable();
        Platform buildIfSupported = Android10Platform.Companion.buildIfSupported();
        if (buildIfSupported == null) {
            buildIfSupported = AndroidPlatform.Companion.buildIfSupported();
        }
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
    }

    @Nullable
    public final Context getApplicationContext() {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            return contextAwarePlatform.getApplicationContext();
        }
        return null;
    }

    public final void setApplicationContext(@Nullable Context context) {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(context);
        }
    }

    private PlatformRegistry() {
    }
}
