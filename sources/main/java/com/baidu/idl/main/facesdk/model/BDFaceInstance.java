package com.baidu.idl.main.facesdk.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDFaceInstance {
    private long index = 0;

    private native long nativeCreateInstance();

    private native long nativeGetDefautlInstance();

    public native int destory();

    private void setIndex(long j6) {
        this.index = j6;
    }

    public long getIndex() {
        return this.index;
    }

    public void creatInstance() {
        long nativeCreateInstance = nativeCreateInstance();
        this.index = nativeCreateInstance;
        setIndex(nativeCreateInstance);
    }

    public void getDefautlInstance() {
        setIndex(nativeGetDefautlInstance());
    }
}
