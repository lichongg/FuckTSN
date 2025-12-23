package androidx.camera.view.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AudioConfig {

    @NonNull
    public static final AudioConfig AUDIO_DISABLED = new AudioConfig(false);
    private final boolean mIsAudioEnabled;

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    public static AudioConfig create(boolean z5) {
        return new AudioConfig(z5);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }

    AudioConfig(boolean z5) {
        this.mIsAudioEnabled = z5;
    }
}
