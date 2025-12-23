package androidx.camera.core.impl;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class DeviceProperties {
    @NonNull
    public static DeviceProperties create() {
        return create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    @NonNull
    public abstract String manufacturer();

    @NonNull
    public abstract String model();

    public abstract int sdkVersion();

    @NonNull
    public static DeviceProperties create(@NonNull String str, @NonNull String str2, int i6) {
        return new AutoValue_DeviceProperties(str, str2, i6);
    }
}
