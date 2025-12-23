package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate = false;

        public void reset() {
            this.zIndexUpdate = false;
        }
    }

    protected BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    protected Object method1(Object... objArr) {
        return null;
    }

    protected Object method2(Object... objArr) {
        return null;
    }

    @JBindingExclude
    public void resetUpdateFlags() {
    }
}
