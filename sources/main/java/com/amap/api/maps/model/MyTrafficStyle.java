package com.amap.api.maps.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MyTrafficStyle {
    private int extremelySmoothColor = -15229099;
    private int smoothColor = -16735735;
    private int slowColor = -35576;
    private int congestedColor = -1441006;
    private int seriousCongestedColor = -7208950;
    private float ratio = 0.8f;
    private int trafficRoadBackgroundColor = -1;

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public int getExtremelySmoothColor() {
        return this.extremelySmoothColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int i6) {
        this.congestedColor = i6;
    }

    public void setExtremelySmoothColor(int i6) {
        this.extremelySmoothColor = i6;
    }

    public void setRatio(float f6) {
        this.ratio = f6;
    }

    public void setSeriousCongestedColor(int i6) {
        this.seriousCongestedColor = i6;
    }

    public void setSlowColor(int i6) {
        this.slowColor = i6;
    }

    public void setSmoothColor(int i6) {
        this.smoothColor = i6;
    }

    public void setTrafficRoadBackgroundColor(int i6) {
        this.trafficRoadBackgroundColor = i6;
    }
}
