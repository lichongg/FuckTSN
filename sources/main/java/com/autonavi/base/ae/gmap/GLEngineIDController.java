package com.autonavi.base.ae.gmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = 10000;

    public synchronized int generate() {
        int i6;
        i6 = this.engineIDIndex + 1;
        this.engineIDIndex = i6;
        return i6;
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    private GLEngineIDController() {
    }
}
