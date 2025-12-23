package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(26)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api26Impl {
    @NonNull
    @DoNotInline
    public static MediaMuxer createMediaMuxer(@NonNull FileDescriptor fileDescriptor, int i6) throws IOException {
        return new MediaMuxer(fileDescriptor, i6);
    }

    private Api26Impl() {
    }
}
