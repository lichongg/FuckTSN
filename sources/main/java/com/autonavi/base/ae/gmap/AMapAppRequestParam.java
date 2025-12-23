package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapAppRequestParam {

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

    @JBindingExclude
    private ResourceCallback callback;
    private String url;
    private int resourceType = 0;
    private long contextId = 0;
    private int expectWidth = 0;
    private int expectHeight = 0;

    @JBindingInclude
    public void generateCallback(long j6) {
        this.callback = new ResourceCallback(j6);
    }

    @JBindingExclude
    public ResourceCallback getCallback() {
        return this.callback;
    }

    @JBindingExclude
    public long getContextId() {
        return this.contextId;
    }

    @JBindingExclude
    public int getExpectHeight() {
        return this.expectHeight;
    }

    @JBindingExclude
    public int getExpectWidth() {
        return this.expectWidth;
    }

    @JBindingExclude
    public int getResourceType() {
        return this.resourceType;
    }

    @JBindingExclude
    public String getUrl() {
        return this.url;
    }

    @JBindingExclude
    public void setCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }

    @JBindingExclude
    public void setContextId(long j6) {
        this.contextId = j6;
    }

    @JBindingExclude
    public void setExpectHeight(int i6) {
        this.expectHeight = i6;
    }

    @JBindingExclude
    public void setExpectWidth(int i6) {
        this.expectWidth = i6;
    }

    @JBindingExclude
    public void setResourceType(int i6) {
        this.resourceType = i6;
    }

    @JBindingExclude
    public void setUrl(String str) {
        this.url = str;
    }
}
