package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncoderFactory {
    @NonNull
    Encoder createEncoder(@NonNull Executor executor, @NonNull EncoderConfig encoderConfig) throws InvalidConfigException;
}
