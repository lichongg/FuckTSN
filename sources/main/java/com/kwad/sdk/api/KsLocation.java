package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsLocation {
    private double mLatitude;
    private double mLongitude;
    private double mAltitude = 0.0d;
    private float mSpeed = 0.0f;
    private float mBearing = 0.0f;

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public void setAltitude(double d6) {
        this.mAltitude = d6;
    }

    public void setBearing(float f6) {
        this.mBearing = f6;
    }

    public void setLatitude(double d6) {
        this.mLatitude = d6;
    }

    public void setLongitude(double d6) {
        this.mLongitude = d6;
    }

    public void setSpeed(float f6) {
        this.mSpeed = f6;
    }

    public KsLocation(double d6, double d7) {
        this.mLatitude = d6;
        this.mLongitude = d7;
    }
}
