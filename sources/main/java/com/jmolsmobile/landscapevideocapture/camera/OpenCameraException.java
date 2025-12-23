package com.jmolsmobile.landscapevideocapture.camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class OpenCameraException extends Exception {
    private static final String LOG_PREFIX = "Unable to open camera - ";
    private static final long serialVersionUID = -7340415176385044242L;
    private final OpenType mType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum OpenType {
        INUSE("Camera disabled or in use by other process"),
        NOCAMERA("Device does not have camera");

        private String mMessage;

        public String getMessage() {
            return this.mMessage;
        }

        OpenType(String str) {
            this.mMessage = str;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35594a, LOG_PREFIX + this.mType.getMessage());
        super.printStackTrace();
    }

    public OpenCameraException(OpenType openType) {
        super(openType.getMessage());
        this.mType = openType;
    }
}
