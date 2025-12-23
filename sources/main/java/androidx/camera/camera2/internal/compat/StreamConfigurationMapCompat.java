package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class StreamConfigurationMapCompat {
    private static final String TAG = "StreamConfigurationMapCompat";
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes = new HashMap();
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes = new HashMap();
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface StreamConfigurationMapCompatImpl {
        @Nullable
        Size[] getHighResolutionOutputSizes(int i6);

        @Nullable
        Size[] getOutputSizes(int i6);

        @Nullable
        <T> Size[] getOutputSizes(@NonNull Class<T> cls);

        @NonNull
        StreamConfigurationMap unwrap();
    }

    @Nullable
    public Size[] getOutputSizes(int i6) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(i6))) {
            if (this.mCachedFormatOutputSizes.get(Integer.valueOf(i6)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i6)).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(i6);
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] applyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, i6);
            this.mCachedFormatOutputSizes.put(Integer.valueOf(i6), applyQuirks);
            return (Size[]) applyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for format " + i6);
        return outputSizes;
    }

    @NonNull
    static StreamConfigurationMapCompat toStreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap, @NonNull OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }

    @Nullable
    public Size[] getHighResolutionOutputSizes(int i6) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(i6))) {
            if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i6)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i6)).clone();
        }
        Size[] highResolutionOutputSizes = this.mImpl.getHighResolutionOutputSizes(i6);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
            highResolutionOutputSizes = this.mOutputSizesCorrector.applyQuirks(highResolutionOutputSizes, i6);
        }
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(i6), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    @NonNull
    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }

    private StreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap, @NonNull OutputSizesCorrector outputSizesCorrector) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
        } else {
            this.mImpl = new StreamConfigurationMapCompatBaseImpl(streamConfigurationMap);
        }
        this.mOutputSizesCorrector = outputSizesCorrector;
    }

    @Nullable
    public <T> Size[] getOutputSizes(@NonNull Class<T> cls) {
        if (this.mCachedClassOutputSizes.containsKey(cls)) {
            if (this.mCachedClassOutputSizes.get(cls) == null) {
                return null;
            }
            return (Size[]) this.mCachedClassOutputSizes.get(cls).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(cls);
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] applyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, cls);
            this.mCachedClassOutputSizes.put(cls, applyQuirks);
            return (Size[]) applyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for class " + cls);
        return outputSizes;
    }
}
