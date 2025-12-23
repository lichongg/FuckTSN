package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f9974a = null;

    /* renamed from: b, reason: collision with root package name */
    long f9975b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f9976c = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9981h = true;

    /* renamed from: d, reason: collision with root package name */
    int f9977d = 0;

    /* renamed from: e, reason: collision with root package name */
    long f9978e = 0;

    /* renamed from: f, reason: collision with root package name */
    AMapLocation f9979f = null;

    /* renamed from: g, reason: collision with root package name */
    long f9980g = 0;

    public final void a() {
        this.f9974a = null;
        this.f9975b = 0L;
        this.f9976c = 0L;
        this.f9979f = null;
        this.f9980g = 0L;
    }

    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            if (this.f9981h && com.autonavi.aps.amapapi.utils.a.a(aVar.getTime())) {
                if (aVar.getLocationType() == 5 || aVar.getLocationType() == 6) {
                    aVar.setLocationType(4);
                    return aVar;
                }
            } else {
                aVar.setLocationType(this.f9977d);
            }
        }
        return aVar;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.b() - this.f9978e > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            this.f9974a = aVar;
            this.f9978e = j.b();
            return this.f9974a;
        }
        this.f9978e = j.b();
        if (!j.a(this.f9974a) || !j.a(aVar)) {
            this.f9975b = j.b();
            this.f9974a = aVar;
            return aVar;
        }
        if (aVar.getTime() == this.f9974a.getTime() && aVar.getAccuracy() < 300.0f) {
            return aVar;
        }
        if (GeocodeSearch.GPS.equals(aVar.getProvider())) {
            this.f9975b = j.b();
            this.f9974a = aVar;
            return aVar;
        }
        if (aVar.c() != this.f9974a.c()) {
            this.f9975b = j.b();
            this.f9974a = aVar;
            return aVar;
        }
        if (aVar.getBuildingId() != null && !aVar.getBuildingId().equals(this.f9974a.getBuildingId()) && !TextUtils.isEmpty(aVar.getBuildingId())) {
            this.f9975b = j.b();
            this.f9974a = aVar;
            return aVar;
        }
        this.f9977d = aVar.getLocationType();
        float a6 = j.a(aVar, this.f9974a);
        float accuracy = this.f9974a.getAccuracy();
        float accuracy2 = aVar.getAccuracy();
        float f6 = accuracy2 - accuracy;
        long b6 = j.b();
        long j6 = b6 - this.f9975b;
        boolean z5 = false;
        boolean z6 = accuracy <= 100.0f && accuracy2 > 299.0f;
        if (accuracy > 299.0f && accuracy2 > 299.0f) {
            z5 = true;
        }
        if (z6 || z5) {
            long j7 = this.f9976c;
            if (j7 == 0) {
                this.f9976c = b6;
            } else if (b6 - j7 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                this.f9975b = b6;
                this.f9974a = aVar;
                this.f9976c = 0L;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a b7 = b(this.f9974a);
            this.f9974a = b7;
            return b7;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.f9975b = b6;
            this.f9974a = aVar;
            this.f9976c = 0L;
            return aVar;
        }
        if (accuracy2 <= 299.0f) {
            this.f9976c = 0L;
        }
        if (a6 >= 10.0f || a6 <= 0.1d || accuracy2 <= 5.0f) {
            if (f6 < 300.0f) {
                this.f9975b = j.b();
                this.f9974a = aVar;
                return aVar;
            }
            if (j6 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                this.f9975b = j.b();
                this.f9974a = aVar;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a b8 = b(this.f9974a);
            this.f9974a = b8;
            return b8;
        }
        if (f6 >= -300.0f) {
            com.autonavi.aps.amapapi.model.a b9 = b(this.f9974a);
            this.f9974a = b9;
            return b9;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.f9975b = b6;
            this.f9974a = aVar;
            return aVar;
        }
        com.autonavi.aps.amapapi.model.a b10 = b(this.f9974a);
        this.f9974a = b10;
        return b10;
    }

    public final void a(boolean z5) {
        this.f9981h = z5;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            long b6 = j.b() - this.f9980g;
            this.f9980g = j.b();
            if (b6 <= 5000) {
                AMapLocation aMapLocation2 = this.f9979f;
                if (aMapLocation2 == null) {
                    this.f9979f = aMapLocation;
                    return aMapLocation;
                }
                if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f9979f.getProvider())) {
                    this.f9979f = aMapLocation;
                    return aMapLocation;
                }
                if (this.f9979f.getAltitude() == aMapLocation.getAltitude() && this.f9979f.getLongitude() == aMapLocation.getLongitude()) {
                    this.f9979f = aMapLocation;
                    return aMapLocation;
                }
                long abs = Math.abs(aMapLocation.getTime() - this.f9979f.getTime());
                if (WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS < abs) {
                    this.f9979f = aMapLocation;
                    return aMapLocation;
                }
                if (j.a(aMapLocation, this.f9979f) > (((this.f9979f.getSpeed() + aMapLocation.getSpeed()) * abs) / 2000.0f) + ((this.f9979f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.f9979f;
                }
                this.f9979f = aMapLocation;
                return aMapLocation;
            }
        }
        return aMapLocation;
    }
}
