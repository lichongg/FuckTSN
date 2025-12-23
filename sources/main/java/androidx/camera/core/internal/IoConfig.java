package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface IoConfig extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_IO_EXECUTOR = Config.Option.create("camerax.core.io.ioExecutor", Executor.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<B> {
        @NonNull
        B setIoExecutor(@NonNull Executor executor);
    }

    @NonNull
    Executor getIoExecutor();

    @Nullable
    Executor getIoExecutor(@Nullable Executor executor);
}
