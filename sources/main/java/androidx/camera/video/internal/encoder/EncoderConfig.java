package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncoderConfig {
    public static final int CODEC_PROFILE_NONE = -1;

    @NonNull
    Timebase getInputTimebase();

    @NonNull
    String getMimeType();

    int getProfile();

    @NonNull
    MediaFormat toMediaFormat() throws InvalidConfigException;
}
