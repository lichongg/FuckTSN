package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class ResourceCallback {
    private long instance;

    public ResourceCallback() {
        this.instance = 0L;
    }

    @JBindingExclude
    private static native void nativeCallCancel();

    @JBindingExclude
    private static native void nativeCallFailed(long j6, String str);

    @JBindingExclude
    private static native void nativeCallSuccess(long j6, AMapAppResourceItem aMapAppResourceItem);

    @JBindingExclude
    public void callFailed(String str) {
        nativeCallFailed(this.instance, str);
    }

    @JBindingExclude
    public void callSuccess(AMapAppResourceItem aMapAppResourceItem) {
        nativeCallSuccess(this.instance, aMapAppResourceItem);
    }

    @JBindingExclude
    public long getInstance() {
        return this.instance;
    }

    @JBindingExclude
    public void setInstance(long j6) {
        this.instance = j6;
    }

    public ResourceCallback(long j6) {
        this.instance = j6;
    }

    @JBindingExclude
    public void callCancel() {
        nativeCallCancel();
    }
}
