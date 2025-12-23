package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.v0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.bxkj.competition.score.teacher.ScoreMenu;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* renamed from: a, reason: collision with root package name */
    private IShareSearch f9845a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i6);

        void onDrivingRouteShareUrlSearched(String str, int i6);

        void onLocationShareUrlSearched(String str, int i6);

        void onNaviShareUrlSearched(String str, int i6);

        void onPoiShareUrlSearched(String str, int i6);

        void onWalkRouteShareUrlSearched(String str, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShareBusRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9846a;

        /* renamed from: b, reason: collision with root package name */
        private int f9847b;

        public int getBusMode() {
            return this.f9847b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9846a;
        }

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i6) {
            this.f9846a = shareFromAndTo;
            this.f9847b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShareDrivingRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9848a;

        /* renamed from: b, reason: collision with root package name */
        private int f9849b;

        public int getDrivingMode() {
            return this.f9849b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9848a;
        }

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i6) {
            this.f9848a = shareFromAndTo;
            this.f9849b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShareFromAndTo {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9850a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9851b;

        /* renamed from: c, reason: collision with root package name */
        private String f9852c = ScoreMenu.START;

        /* renamed from: d, reason: collision with root package name */
        private String f9853d = "终点";

        public LatLonPoint getFrom() {
            return this.f9850a;
        }

        public String getFromName() {
            return this.f9852c;
        }

        public LatLonPoint getTo() {
            return this.f9851b;
        }

        public String getToName() {
            return this.f9853d;
        }

        public void setFromName(String str) {
            this.f9852c = str;
        }

        public void setToName(String str) {
            this.f9853d = str;
        }

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9850a = latLonPoint;
            this.f9851b = latLonPoint2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShareNaviQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9854a;

        /* renamed from: b, reason: collision with root package name */
        private int f9855b;

        public ShareFromAndTo getFromAndTo() {
            return this.f9854a;
        }

        public int getNaviMode() {
            return this.f9855b;
        }

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i6) {
            this.f9854a = shareFromAndTo;
            this.f9855b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShareWalkRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f9856a;

        /* renamed from: b, reason: collision with root package name */
        private int f9857b;

        public ShareFromAndTo getShareFromAndTo() {
            return this.f9856a;
        }

        public int getWalkMode() {
            return this.f9857b;
        }

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i6) {
            this.f9856a = shareFromAndTo;
            this.f9857b = i6;
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f9845a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f9845a == null) {
            try {
                this.f9845a = new v0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
