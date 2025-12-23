package androidx.camera.core.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CameraThreadConfig {
    @NonNull
    public abstract Executor getCameraExecutor();

    @NonNull
    public abstract Handler getSchedulerHandler();

    @NonNull
    public static CameraThreadConfig create(@NonNull Executor executor, @NonNull Handler handler) {
        return new AutoValue_CameraThreadConfig(executor, handler);
    }
}
