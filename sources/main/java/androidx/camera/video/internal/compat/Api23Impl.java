package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(23)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api23Impl {
    @NonNull
    @DoNotInline
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    private Api23Impl() {
    }

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    @DoNotInline
    public static AudioRecord build(@NonNull AudioRecord.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    public static void setAudioFormat(@NonNull AudioRecord.Builder builder, @NonNull AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    @DoNotInline
    public static void setAudioSource(@NonNull AudioRecord.Builder builder, int i6) {
        builder.setAudioSource(i6);
    }

    @DoNotInline
    public static void setBufferSizeInBytes(@NonNull AudioRecord.Builder builder, int i6) {
        builder.setBufferSizeInBytes(i6);
    }
}
