package androidx.camera.video.internal.compat;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(31)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api31Impl {
    private Api31Impl() {
    }

    @NonNull
    @DoNotInline
    public static Range<Integer>[] getInputChannelCountRanges(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getInputChannelCountRanges();
    }

    @DoNotInline
    public static int getMinInputChannelCount(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getMinInputChannelCount();
    }

    @DoNotInline
    public static void setContext(@NonNull AudioRecord.Builder builder, @NonNull Context context) {
        builder.setContext(context);
    }
}
