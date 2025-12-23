package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BaseEntry {
    private Object mData;
    private Drawable mIcon;

    /* renamed from: y, reason: collision with root package name */
    private float f32558y;

    public BaseEntry() {
        this.f32558y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public Object getData() {
        return this.mData;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public float getY() {
        return this.f32558y;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setY(float f6) {
        this.f32558y = f6;
    }

    public BaseEntry(float f6) {
        this.mData = null;
        this.mIcon = null;
        this.f32558y = f6;
    }

    public BaseEntry(float f6, Object obj) {
        this(f6);
        this.mData = obj;
    }

    public BaseEntry(float f6, Drawable drawable) {
        this(f6);
        this.mIcon = drawable;
    }

    public BaseEntry(float f6, Drawable drawable, Object obj) {
        this(f6);
        this.mIcon = drawable;
        this.mData = obj;
    }
}
