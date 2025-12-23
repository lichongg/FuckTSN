package com.google.mlkit.vision.pose;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.interfaces.Detector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface PoseDetector extends Detector<Pose> {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    @KeepForSdk
    Task<Void> closeWithTask();

    @NonNull
    Task<Void> getInitTask();

    @NonNull
    Task<Pose> process(@NonNull MlImage mlImage);

    @NonNull
    Task<Pose> process(@NonNull InputImage inputImage);
}
