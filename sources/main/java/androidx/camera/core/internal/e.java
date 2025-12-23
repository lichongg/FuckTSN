package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class e {
    @NonNull
    public static Executor a(ThreadConfig threadConfig) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    @Nullable
    public static Executor b(ThreadConfig threadConfig, @Nullable Executor executor) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }
}
