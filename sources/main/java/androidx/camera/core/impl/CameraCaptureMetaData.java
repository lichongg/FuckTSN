package androidx.camera.core.impl;

import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraCaptureMetaData {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AeState {
        UNKNOWN,
        INACTIVE,
        SEARCHING,
        FLASH_REQUIRED,
        CONVERGED,
        LOCKED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AfMode {
        UNKNOWN,
        OFF,
        ON_MANUAL_AUTO,
        ON_CONTINUOUS_AUTO
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AfState {
        UNKNOWN,
        INACTIVE,
        SCANNING,
        PASSIVE_FOCUSED,
        PASSIVE_NOT_FOCUSED,
        LOCKED_FOCUSED,
        LOCKED_NOT_FOCUSED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AwbState {
        UNKNOWN,
        INACTIVE,
        METERING,
        CONVERGED,
        LOCKED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum FlashState {
        UNKNOWN,
        NONE,
        READY,
        FIRED
    }

    private CameraCaptureMetaData() {
    }
}
