package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class c {
    @NonNull
    public static Executor a(IoConfig ioConfig) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    @Nullable
    public static Executor b(IoConfig ioConfig, @Nullable Executor executor) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }
}
