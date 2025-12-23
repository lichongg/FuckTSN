package androidx.camera.video.internal.compat;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api29Impl {
    private Api29Impl() {
    }

    @Nullable
    @DoNotInline
    public static AudioRecordingConfiguration getActiveRecordingConfiguration(@NonNull AudioRecord audioRecord) {
        return audioRecord.getActiveRecordingConfiguration();
    }

    @DoNotInline
    public static boolean isClientSilenced(@NonNull AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.isClientSilenced();
    }

    @DoNotInline
    public static void registerAudioRecordingCallback(@NonNull AudioRecord audioRecord, @NonNull Executor executor, @NonNull AudioManager.AudioRecordingCallback audioRecordingCallback) {
        audioRecord.registerAudioRecordingCallback(executor, audioRecordingCallback);
    }

    @DoNotInline
    public static void unregisterAudioRecordingCallback(@NonNull AudioRecord audioRecord, @NonNull AudioManager.AudioRecordingCallback audioRecordingCallback) {
        audioRecord.unregisterAudioRecordingCallback(audioRecordingCallback);
    }
}
