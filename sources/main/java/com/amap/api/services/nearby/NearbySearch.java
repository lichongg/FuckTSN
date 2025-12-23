package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.p0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.tencent.mmkv.MMKV;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: a, reason: collision with root package name */
    private static NearbySearch f9351a;

    /* renamed from: b, reason: collision with root package name */
    private INearbySearch f9352b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i6);

        void onNearbyInfoUploaded(int i6);

        void onUserInfoCleared(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NearbyQuery {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9354a;

        /* renamed from: b, reason: collision with root package name */
        private NearbySearchFunctionType f9355b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c, reason: collision with root package name */
        private int f9356c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private int f9357d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;

        /* renamed from: e, reason: collision with root package name */
        private int f9358e = 1;

        public void setTimeRange(int i6) {
            if (i6 < 5) {
                i6 = 5;
            } else if (i6 > 86400) {
                i6 = MMKV.ExpireInDay;
            }
            this.f9357d = i6;
        }

        public LatLonPoint getCenterPoint() {
            return this.f9354a;
        }

        public int getCoordType() {
            return this.f9358e;
        }

        public int getRadius() {
            return this.f9356c;
        }

        public int getTimeRange() {
            return this.f9357d;
        }

        public int getType() {
            int i6 = AnonymousClass1.f9353a[this.f9355b.ordinal()];
            return (i6 == 1 || i6 != 2) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f9354a = latLonPoint;
        }

        public void setCoordType(int i6) {
            if (i6 == 0 || i6 == 1) {
                this.f9358e = i6;
            } else {
                this.f9358e = 1;
            }
        }

        public void setRadius(int i6) {
            if (i6 > 10000) {
                i6 = 10000;
            }
            this.f9356c = i6;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f9355b = nearbySearchFunctionType;
        }
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i6) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i6);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.services.nearby.NearbySearch$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9353a;

        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            f9353a = iArr;
            try {
                iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9353a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.f9352b = null;
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            try {
                NearbySearch nearbySearch = f9351a;
                if (nearbySearch != null) {
                    try {
                        nearbySearch.a();
                    } catch (Throwable th) {
                        j4.i(th, "NearbySearch", "destryoy");
                    }
                }
                f9351a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f9351a == null) {
                try {
                    f9351a = new NearbySearch(context);
                } catch (AMapException e6) {
                    throw e6;
                }
            }
            nearbySearch = f9351a;
        }
        return nearbySearch;
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f9352b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f9352b == null) {
            try {
                this.f9352b = new p0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
