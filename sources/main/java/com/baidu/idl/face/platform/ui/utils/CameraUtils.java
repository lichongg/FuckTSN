package com.baidu.idl.face.platform.ui.utils;

import android.hardware.Camera;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CameraUtils {
    public static final String TAG = "CameraUtils";

    public static void releaseCamera(Camera camera) {
        try {
            camera.release();
        } catch (RuntimeException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
