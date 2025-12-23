package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapAppResourceItem {

    @JBindingExclude
    public static final int RESOURCE_TYPE_ABSPATH = 4;

    @JBindingExclude
    public static final int RESOURCE_TYPE_BINARY = 3;

    @JBindingExclude
    public static final int RESOURCE_TYPE_IMAGE = 1;

    @JBindingExclude
    public static final int RESOURCE_TYPE_NONE = 0;

    @JBindingExclude
    public static final int RESOURCE_TYPE_SVG = 2;
    private byte[] data;
    private long size;
    private int resourceType = 0;
    private boolean preAlpha = false;
    private int imageWidth = 0;
    private int imageHeight = 0;
    private float imageScale = 1.0f;

    @JBindingExclude
    public byte[] getData() {
        return this.data;
    }

    @JBindingExclude
    public int getImageHeight() {
        return this.imageHeight;
    }

    @JBindingExclude
    public float getImageScale() {
        return this.imageScale;
    }

    @JBindingExclude
    public int getImageWidth() {
        return this.imageWidth;
    }

    @JBindingExclude
    public int getResourceType() {
        return this.resourceType;
    }

    @JBindingExclude
    public long getSize() {
        return this.size;
    }

    @JBindingExclude
    public boolean isPreAlpha() {
        return this.preAlpha;
    }

    @JBindingExclude
    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    @JBindingExclude
    public void setImageHeight(int i6) {
        this.imageHeight = i6;
    }

    @JBindingExclude
    public void setImageScale(float f6) {
        this.imageScale = f6;
    }

    @JBindingExclude
    public void setImageWidth(int i6) {
        this.imageWidth = i6;
    }

    @JBindingExclude
    public void setPreAlpha(boolean z5) {
        this.preAlpha = z5;
    }

    @JBindingExclude
    public void setResourceType(int i6) {
        this.resourceType = i6;
    }

    @JBindingExclude
    public void setSize(long j6) {
        this.size = j6;
    }
}
