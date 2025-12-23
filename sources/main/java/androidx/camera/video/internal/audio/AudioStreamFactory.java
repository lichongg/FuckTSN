package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.audio.AudioStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
interface AudioStreamFactory {
    @NonNull
    AudioStream create(@NonNull AudioSettings audioSettings, @Nullable Context context) throws AudioStream.AudioStreamException;
}
