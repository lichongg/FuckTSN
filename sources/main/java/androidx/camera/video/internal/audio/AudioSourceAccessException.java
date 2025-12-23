package androidx.camera.video.internal.audio;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AudioSourceAccessException extends Exception {
    public AudioSourceAccessException(@Nullable String str) {
        super(str);
    }

    public AudioSourceAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public AudioSourceAccessException(@Nullable Throwable th) {
        super(th);
    }
}
