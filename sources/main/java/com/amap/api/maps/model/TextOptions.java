package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class TextOptions implements Parcelable, Cloneable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    String f8985a;
    private Object object;
    private LatLng position;
    private float rotate;
    private String text;
    private Typeface typeface = Typeface.DEFAULT;
    private int alignX = 4;
    private int alignY = 32;
    private int backgroundColor = -1;
    private int fontColor = ViewCompat.MEASURED_STATE_MASK;
    private int fontSize = 20;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TextOptions align(int i6, int i7) {
        this.alignX = i6;
        this.alignY = i7;
        return this;
    }

    public final TextOptions backgroundColor(int i6) {
        this.backgroundColor = i6;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final TextOptions m58clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
        }
        TextOptions textOptions = new TextOptions();
        textOptions.f8985a = this.f8985a;
        textOptions.position = this.position;
        textOptions.text = this.text;
        textOptions.typeface = this.typeface;
        textOptions.rotate = this.rotate;
        textOptions.alignX = this.alignX;
        textOptions.alignY = this.alignY;
        textOptions.backgroundColor = this.backgroundColor;
        textOptions.fontColor = this.fontColor;
        textOptions.object = this.object;
        textOptions.fontSize = this.fontSize;
        textOptions.zIndex = this.zIndex;
        textOptions.isVisible = this.isVisible;
        return textOptions;
    }

    public final TextOptions fontColor(int i6) {
        this.fontColor = i6;
        return this;
    }

    public final TextOptions fontSize(int i6) {
        this.fontSize = i6;
        return this;
    }

    public final int getAlignX() {
        return this.alignX;
    }

    public final int getAlignY() {
        return this.alignY;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final Object getObject() {
        return this.object;
    }

    public final LatLng getPosition() {
        return this.position;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final String getText() {
        return this.text;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final TextOptions position(LatLng latLng) {
        this.position = latLng;
        return this;
    }

    public final TextOptions rotate(float f6) {
        this.rotate = f6;
        return this;
    }

    public final TextOptions setObject(Object obj) {
        this.object = obj;
        return this;
    }

    public final TextOptions text(String str) {
        this.text = str;
        return this;
    }

    public final TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
        }
        return this;
    }

    public final TextOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f8985a);
        Bundle bundle = new Bundle();
        LatLng latLng = this.position;
        if (latLng != null) {
            bundle.putDouble(d.C, latLng.latitude);
            bundle.putDouble(d.D, this.position.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.text);
        parcel.writeInt(this.typeface.getStyle());
        parcel.writeFloat(this.rotate);
        parcel.writeInt(this.alignX);
        parcel.writeInt(this.alignY);
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.fontColor);
        parcel.writeInt(this.fontSize);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        if (this.object instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.object);
            parcel.writeBundle(bundle2);
        }
    }

    public final TextOptions zIndex(float f6) {
        this.zIndex = f6;
        return this;
    }
}
