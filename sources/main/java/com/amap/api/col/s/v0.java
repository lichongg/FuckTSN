package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v0 implements IShareSearch {

    /* renamed from: c, reason: collision with root package name */
    private static String f8549c = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";

    /* renamed from: d, reason: collision with root package name */
    private static String f8550d = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";

    /* renamed from: e, reason: collision with root package name */
    private static String f8551e = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";

    /* renamed from: f, reason: collision with root package name */
    private static String f8552f = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";

    /* renamed from: g, reason: collision with root package name */
    private static final String f8553g = "";

    /* renamed from: a, reason: collision with root package name */
    private Context f8554a;

    /* renamed from: b, reason: collision with root package name */
    private ShareSearch.OnShareSearchListener f8555b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoiItem f8556a;

        a(PoiItem poiItem) {
            this.f8556a = poiItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1100;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchPoiShareUrl = v0.this.searchPoiShareUrl(this.f8556a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchPoiShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareBusRouteQuery f8558a;

        b(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.f8558a = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchBusRouteShareUrl = v0.this.searchBusRouteShareUrl(this.f8558a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchBusRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareWalkRouteQuery f8560a;

        c(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.f8560a = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1105;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchWalkRouteShareUrl = v0.this.searchWalkRouteShareUrl(this.f8560a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareDrivingRouteQuery f8562a;

        d(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.f8562a = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1104;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchDrivingRouteShareUrl = v0.this.searchDrivingRouteShareUrl(this.f8562a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareNaviQuery f8564a;

        e(ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.f8564a = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchNaviShareUrl = v0.this.searchNaviShareUrl(this.f8564a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchNaviShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLonSharePoint f8566a;

        f(LatLonSharePoint latLonSharePoint) {
            this.f8566a = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f8555b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            obtainMessage.obj = v0.this.f8555b;
            try {
                try {
                    String searchLocationShareUrl = v0.this.searchLocationShareUrl(this.f8566a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchLocationShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int drivingMode = shareDrivingRouteQuery.getDrivingMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = f8549c;
            Double valueOf = Double.valueOf(from.getLatitude());
            Double valueOf2 = Double.valueOf(from.getLongitude());
            Double valueOf3 = Double.valueOf(to.getLatitude());
            Double valueOf4 = Double.valueOf(to.getLongitude());
            Integer valueOf5 = Integer.valueOf(drivingMode);
            String str2 = f8553g;
            return new v(this.f8554a, String.format(str, valueOf, valueOf2, fromName, valueOf3, valueOf4, toName, valueOf5, 0, 0, str2, str2, str2)).O();
        } catch (AMapException e6) {
            j4.i(e6, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int busMode = shareBusRouteQuery.getBusMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = f8549c;
            Double valueOf = Double.valueOf(from.getLatitude());
            Double valueOf2 = Double.valueOf(from.getLongitude());
            Double valueOf3 = Double.valueOf(to.getLatitude());
            Double valueOf4 = Double.valueOf(to.getLongitude());
            Integer valueOf5 = Integer.valueOf(busMode);
            String str2 = f8553g;
            return new v(this.f8554a, String.format(str, valueOf, valueOf2, fromName, valueOf3, valueOf4, toName, valueOf5, 1, 0, str2, str2, str2)).O();
        } catch (AMapException e6) {
            j4.i(e6, "ShareSearch", "searchBusRouteShareUrl");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new v(this.f8554a, String.format(f8550d, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e6) {
            j4.i(e6, "ShareSearch", "searchLocationShareUrl");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        try {
            if (shareNaviQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            return new v(this.f8554a, fromAndTo.getFrom() == null ? String.format(f8551e, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)) : String.format(f8551e, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode))).O();
        } catch (AMapException e6) {
            j4.i(e6, "ShareSearch", "searchNaviShareUrl");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new v(this.f8554a, String.format(f8552f, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).O();
                }
            } catch (AMapException e6) {
                j4.i(e6, "ShareSearch", "searchPoiShareUrl");
                throw e6;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int walkMode = shareWalkRouteQuery.getWalkMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = f8549c;
            Double valueOf = Double.valueOf(from.getLatitude());
            Double valueOf2 = Double.valueOf(from.getLongitude());
            Double valueOf3 = Double.valueOf(to.getLatitude());
            Double valueOf4 = Double.valueOf(to.getLongitude());
            Integer valueOf5 = Integer.valueOf(walkMode);
            String str2 = f8553g;
            return new v(this.f8554a, String.format(str, valueOf, valueOf2, fromName, valueOf3, valueOf4, toName, valueOf5, 2, 0, str2, str2, str2)).O();
        } catch (AMapException e6) {
            j4.i(e6, "ShareSearch", "searchWalkRouteShareUrl");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f8555b = onShareSearchListener;
    }

    public v0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8554a = context;
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            y.a().b(new b(shareBusRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            y.a().b(new d(shareDrivingRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        try {
            y.a().b(new f(latLonSharePoint));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            y.a().b(new e(shareNaviQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(PoiItem poiItem) {
        try {
            y.a().b(new a(poiItem));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            y.a().b(new c(shareWalkRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
