package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageOptions {

    @JBindingInclude
    public int color;

    @JBindingInclude
    public String content;

    @JBindingInclude
    public int fontSize;

    @JBindingInclude
    public float radius;

    @JBindingInclude
    public double[] rgba;

    @JBindingInclude
    public int type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ShapeType {
        DEFAULT(0),
        CIRCLE(1),
        TEXT(2);

        private int index;

        public final int value() {
            return this.index;
        }

        ShapeType(int i6) {
            this.index = i6;
        }
    }

    @JBindingInclude
    public ImageOptions() {
    }
}
