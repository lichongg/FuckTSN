package com.autonavi.base.amap.mapcore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i6) {
        this.colorIndex = i6;
    }

    public FPoint3(float f6, float f7, int i6) {
        super(f6, f7);
        this.colorIndex = i6;
    }
}
