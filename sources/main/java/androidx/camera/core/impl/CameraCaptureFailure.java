package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CameraCaptureFailure {
    private final Reason mReason;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Reason {
        ERROR
    }

    @NonNull
    public Reason getReason() {
        return this.mReason;
    }

    public CameraCaptureFailure(@NonNull Reason reason) {
        this.mReason = reason;
    }
}
