package com.jmolsmobile.landscapevideocapture.camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PrepareCameraException extends Exception {
    private static final String LOG_PREFIX = "Unable to unlock camera - ";
    private static final String MESSAGE = "Unable to use camera for recording";
    private static final long serialVersionUID = 6305923762266448674L;

    @Override // java.lang.Throwable
    public String getMessage() {
        com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35594a, "Unable to unlock camera - Unable to use camera for recording");
        return MESSAGE;
    }
}
