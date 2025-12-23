package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface ImageInfo {
    int getRotationDegrees();

    @NonNull
    Matrix getSensorToBufferTransformMatrix();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    TagBundle getTagBundle();

    long getTimestamp();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void populateExifData(@NonNull ExifData.Builder builder);
}
