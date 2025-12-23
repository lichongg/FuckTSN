package com.amap.api.maps.model;

import android.util.Pair;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.snail.antifake.deviceid.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class GL3DModelOptions extends BaseOptions {

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    private LatLng latLng;

    @JBindingInclude
    private String modelData;

    @JBindingInclude
    private float rotate;

    @JBindingInclude
    private String snippet;

    @JBindingInclude
    private String title;
    private List<Float> vertextList = new ArrayList();
    private List<Float> textrueList = new ArrayList();

    @JBindingInclude
    private boolean isModeltUpdate = false;

    @JBindingInclude
    private int fixedLength = 50;

    @JBindingInclude
    private double altitude = 0.0d;

    @JBindingInclude
    private boolean fixedDisplaySizeEnabled = true;

    @JBindingInclude
    private double fixedDisplaySizeX = -1.0d;

    @JBindingInclude
    private double fixedDisplaySizeY = -1.0d;

    @JBindingInclude
    private boolean visibile = true;

    @JBindingInclude
    private int zIndex = 0;

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions angle(float f6) {
        this.rotate = f6;
        return this;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public Pair<Double, Double> getFixDisplaySize() {
        return Pair.create(Double.valueOf(this.fixedDisplaySizeX), Double.valueOf(this.fixedDisplaySizeY));
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isFixedDisplaySizeEnabled() {
        return this.fixedDisplaySizeEnabled;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GL3DModelOptions setAltitude(double d6) {
        this.altitude = d6;
        return this;
    }

    public GL3DModelOptions setFixDisplaySize(double d6, double d7) {
        this.fixedDisplaySizeX = d6;
        this.fixedDisplaySizeY = d7;
        return this;
    }

    public GL3DModelOptions setFixedDisplaySizeEnabled(boolean z5) {
        this.fixedDisplaySizeEnabled = z5;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i6) {
        this.fixedLength = i6;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z5) {
        this.visibile = z5;
        return this;
    }

    public GL3DModelOptions setzIndex(int i6) {
        this.zIndex = i6;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb = new StringBuilder();
        if (this.vertextList != null) {
            for (int i6 = 0; i6 < this.vertextList.size() - 3; i6 += 3) {
                sb.append("v ");
                sb.append(this.vertextList.get(i6));
                sb.append(" ");
                sb.append(this.vertextList.get(i6 + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i6 + 2));
                sb.append(e.f37542d);
            }
        }
        if (this.textrueList != null) {
            for (int i7 = 0; i7 < this.textrueList.size() - 2; i7 += 2) {
                sb.append("vt ");
                sb.append(this.textrueList.get(i7));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i7 + 1).floatValue());
                sb.append(e.f37542d);
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
