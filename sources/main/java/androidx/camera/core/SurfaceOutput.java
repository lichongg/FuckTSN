package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import com.google.auto.value.AutoValue;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface SurfaceOutput extends Closeable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface EventCode {
        }

        public abstract int getEventCode();

        @NonNull
        public abstract SurfaceOutput getSurfaceOutput();

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Event of(int i6, @NonNull SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i6, surfaceOutput);
        }

        Event() {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getFormat();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Matrix getSensorToBufferTransform();

    @NonNull
    Size getSize();

    @NonNull
    Surface getSurface(@NonNull Executor executor, @NonNull Consumer<Event> consumer);

    int getTargets();

    void updateTransformMatrix(@NonNull float[] fArr, @NonNull float[] fArr2);
}
