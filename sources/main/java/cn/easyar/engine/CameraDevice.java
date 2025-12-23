package cn.easyar.engine;

import cn.easyar.CameraParameters;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
interface CameraDevice {
    boolean autoFocus();

    void close();

    int getBufferCapacity();

    int getCameraOrientation();

    CameraParameters getCameraParameters();

    int getFrameRateRange();

    int getIndex();

    int getNumSupportedFrameRateRange();

    int getNumSupportedSize();

    int getSizeHeight();

    int getSizeWidth();

    float getSupportedFrameRateRangeLower(int index);

    float getSupportedFrameRateRangeUpper(int index);

    int getSupportedSizeHeight(int index);

    int getSupportedSizeWidth(int index);

    int getType();

    boolean openWithIndex(int index);

    boolean openWithSpecificType(int type);

    void setBufferCapacity(int capacity);

    void setCameraParameters(CameraParameters cameraParameters);

    boolean setFlashTorchMode(boolean on);

    boolean setFocusMode(int focusMode);

    boolean setFrameRateRange(int index);

    boolean setSize(int width, int height);

    boolean start();

    void stop();
}
