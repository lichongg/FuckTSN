package androidx.camera.video.internal.compat;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(24)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api24Impl {
    private Api24Impl() {
    }

    @DoNotInline
    public static int getClientAudioSessionId(@NonNull AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.getClientAudioSessionId();
    }

    @DoNotInline
    public static int getTimestamp(@NonNull AudioRecord audioRecord, @NonNull AudioTimestamp audioTimestamp, int i6) {
        return audioRecord.getTimestamp(audioTimestamp, i6);
    }
}
