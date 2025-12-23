package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncoderCallback {
    public static final EncoderCallback EMPTY = new EncoderCallback() { // from class: androidx.camera.video.internal.encoder.EncoderCallback.1
        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public /* synthetic */ void onEncodePaused() {
            c.a(this);
        }

        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public void onEncodeStart() {
        }

        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public void onEncodeStop() {
        }

        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public void onEncodeError(@NonNull EncodeException encodeException) {
        }

        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public void onEncodedData(@NonNull EncodedData encodedData) {
        }

        @Override // androidx.camera.video.internal.encoder.EncoderCallback
        public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
        }
    };

    void onEncodeError(@NonNull EncodeException encodeException);

    void onEncodePaused();

    void onEncodeStart();

    void onEncodeStop();

    void onEncodedData(@NonNull EncodedData encodedData);

    void onOutputConfigUpdate(@NonNull OutputConfig outputConfig);
}
