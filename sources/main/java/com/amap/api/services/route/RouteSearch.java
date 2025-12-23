package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.t0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearch f9643a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.BusRouteQuery.1
            private static BusRouteQuery a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            private static BusRouteQuery[] a(int i6) {
                return new BusRouteQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9644a;

        /* renamed from: b, reason: collision with root package name */
        private int f9645b;

        /* renamed from: c, reason: collision with root package name */
        private String f9646c;

        /* renamed from: d, reason: collision with root package name */
        private String f9647d;

        /* renamed from: e, reason: collision with root package name */
        private int f9648e;

        /* renamed from: f, reason: collision with root package name */
        private String f9649f;

        public BusRouteQuery(FromAndTo fromAndTo, int i6, String str, int i7) {
            this.f9649f = "base";
            this.f9644a = fromAndTo;
            this.f9645b = i6;
            this.f9646c = str;
            this.f9648e = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.f9646c;
            if (str == null) {
                if (busRouteQuery.f9646c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.f9646c)) {
                return false;
            }
            String str2 = this.f9647d;
            if (str2 == null) {
                if (busRouteQuery.f9647d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.f9647d)) {
                return false;
            }
            String str3 = this.f9649f;
            if (str3 == null) {
                if (busRouteQuery.f9649f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f9649f)) {
                return false;
            }
            FromAndTo fromAndTo = this.f9644a;
            if (fromAndTo == null) {
                if (busRouteQuery.f9644a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.f9644a)) {
                return false;
            }
            return this.f9645b == busRouteQuery.f9645b && this.f9648e == busRouteQuery.f9648e;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m71clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f9644a, this.f9645b, this.f9646c, this.f9648e);
            busRouteQuery.setCityd(this.f9647d);
            busRouteQuery.setExtensions(this.f9649f);
            return busRouteQuery;
        }

        public String getCity() {
            return this.f9646c;
        }

        public String getCityd() {
            return this.f9647d;
        }

        public String getExtensions() {
            return this.f9649f;
        }

        public FromAndTo getFromAndTo() {
            return this.f9644a;
        }

        public int getMode() {
            return this.f9645b;
        }

        public int getNightFlag() {
            return this.f9648e;
        }

        public int hashCode() {
            String str = this.f9646c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f9644a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f9645b) * 31) + this.f9648e) * 31;
            String str2 = this.f9647d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f9647d = str;
        }

        public void setExtensions(String str) {
            this.f9649f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9644a, i6);
            parcel.writeInt(this.f9645b);
            parcel.writeString(this.f9646c);
            parcel.writeInt(this.f9648e);
            parcel.writeString(this.f9647d);
            parcel.writeString(this.f9649f);
        }

        public BusRouteQuery(Parcel parcel) {
            this.f9649f = "base";
            this.f9644a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9645b = parcel.readInt();
            this.f9646c = parcel.readString();
            this.f9648e = parcel.readInt();
            this.f9647d = parcel.readString();
            this.f9649f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f9649f = "base";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() { // from class: com.amap.api.services.route.RouteSearch.DrivePlanQuery.1
            private static DrivePlanQuery a(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            private static DrivePlanQuery[] a(int i6) {
                return new DrivePlanQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9650a;

        /* renamed from: b, reason: collision with root package name */
        private String f9651b;

        /* renamed from: c, reason: collision with root package name */
        private int f9652c;

        /* renamed from: d, reason: collision with root package name */
        private int f9653d;

        /* renamed from: e, reason: collision with root package name */
        private int f9654e;

        /* renamed from: f, reason: collision with root package name */
        private int f9655f;

        /* renamed from: g, reason: collision with root package name */
        private int f9656g;

        public DrivePlanQuery(FromAndTo fromAndTo, int i6, int i7, int i8) {
            this.f9652c = 1;
            this.f9653d = 0;
            this.f9650a = fromAndTo;
            this.f9654e = i6;
            this.f9655f = i7;
            this.f9656g = i8;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.f9650a;
            if (fromAndTo == null) {
                if (drivePlanQuery.f9650a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.f9650a)) {
                return false;
            }
            String str = this.f9651b;
            if (str == null) {
                if (drivePlanQuery.f9651b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.f9651b)) {
                return false;
            }
            return this.f9652c == drivePlanQuery.f9652c && this.f9653d == drivePlanQuery.f9653d && this.f9654e == drivePlanQuery.f9654e && this.f9655f == drivePlanQuery.f9655f && this.f9656g == drivePlanQuery.f9656g;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DrivePlanQuery m72clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f9650a, this.f9654e, this.f9655f, this.f9656g);
            drivePlanQuery.setDestParentPoiID(this.f9651b);
            drivePlanQuery.setMode(this.f9652c);
            drivePlanQuery.setCarType(this.f9653d);
            return drivePlanQuery;
        }

        public int getCarType() {
            return this.f9653d;
        }

        public int getCount() {
            return this.f9656g;
        }

        public String getDestParentPoiID() {
            return this.f9651b;
        }

        public int getFirstTime() {
            return this.f9654e;
        }

        public FromAndTo getFromAndTo() {
            return this.f9650a;
        }

        public int getInterval() {
            return this.f9655f;
        }

        public int getMode() {
            return this.f9652c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f9650a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f9651b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f9652c) * 31) + this.f9653d) * 31) + this.f9654e) * 31) + this.f9655f) * 31) + this.f9656g;
        }

        public void setCarType(int i6) {
            this.f9653d = i6;
        }

        public void setDestParentPoiID(String str) {
            this.f9651b = str;
        }

        public void setMode(int i6) {
            this.f9652c = i6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9650a, i6);
            parcel.writeString(this.f9651b);
            parcel.writeInt(this.f9652c);
            parcel.writeInt(this.f9653d);
            parcel.writeInt(this.f9654e);
            parcel.writeInt(this.f9655f);
            parcel.writeInt(this.f9656g);
        }

        public DrivePlanQuery() {
            this.f9652c = 1;
            this.f9653d = 0;
            this.f9654e = 0;
            this.f9655f = 0;
            this.f9656g = 48;
        }

        protected DrivePlanQuery(Parcel parcel) {
            this.f9652c = 1;
            this.f9653d = 0;
            this.f9654e = 0;
            this.f9655f = 0;
            this.f9656g = 48;
            this.f9650a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9651b = parcel.readString();
            this.f9652c = parcel.readInt();
            this.f9653d = parcel.readInt();
            this.f9654e = parcel.readInt();
            this.f9655f = parcel.readInt();
            this.f9656g = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.DriveRouteQuery.1
            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            private static DriveRouteQuery[] a(int i6) {
                return new DriveRouteQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9657a;

        /* renamed from: b, reason: collision with root package name */
        private int f9658b;

        /* renamed from: c, reason: collision with root package name */
        private List<LatLonPoint> f9659c;

        /* renamed from: d, reason: collision with root package name */
        private List<List<LatLonPoint>> f9660d;

        /* renamed from: e, reason: collision with root package name */
        private String f9661e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9662f;

        /* renamed from: g, reason: collision with root package name */
        private int f9663g;

        /* renamed from: h, reason: collision with root package name */
        private String f9664h;

        /* renamed from: i, reason: collision with root package name */
        private String f9665i;

        public DriveRouteQuery(FromAndTo fromAndTo, int i6, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f9662f = true;
            this.f9663g = 0;
            this.f9664h = null;
            this.f9665i = "base";
            this.f9657a = fromAndTo;
            this.f9658b = i6;
            this.f9659c = list;
            this.f9660d = list2;
            this.f9661e = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.f9661e;
            if (str == null) {
                if (driveRouteQuery.f9661e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f9661e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f9660d;
            if (list == null) {
                if (driveRouteQuery.f9660d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f9660d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f9657a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f9657a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f9657a)) {
                return false;
            }
            if (this.f9658b != driveRouteQuery.f9658b) {
                return false;
            }
            List<LatLonPoint> list2 = this.f9659c;
            if (list2 == null) {
                if (driveRouteQuery.f9659c != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f9659c) || this.f9662f != driveRouteQuery.isUseFerry() || this.f9663g != driveRouteQuery.f9663g) {
                return false;
            }
            String str2 = this.f9665i;
            if (str2 == null) {
                if (driveRouteQuery.f9665i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.f9665i)) {
                return false;
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m73clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f9657a, this.f9658b, this.f9659c, this.f9660d, this.f9661e);
            driveRouteQuery.setUseFerry(this.f9662f);
            driveRouteQuery.setCarType(this.f9663g);
            driveRouteQuery.setExclude(this.f9664h);
            driveRouteQuery.setExtensions(this.f9665i);
            return driveRouteQuery;
        }

        public String getAvoidRoad() {
            return this.f9661e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f9660d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f9660d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f9660d.size(); i6++) {
                List<LatLonPoint> list2 = this.f9660d.get(i6);
                for (int i7 = 0; i7 < list2.size(); i7++) {
                    LatLonPoint latLonPoint = list2.get(i7);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i7 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i6 < this.f9660d.size() - 1) {
                    stringBuffer.append(Logger.f33116c);
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f9663g;
        }

        public String getExclude() {
            return this.f9664h;
        }

        public String getExtensions() {
            return this.f9665i;
        }

        public FromAndTo getFromAndTo() {
            return this.f9657a;
        }

        public int getMode() {
            return this.f9658b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f9659c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f9659c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f9659c.size(); i6++) {
                LatLonPoint latLonPoint = this.f9659c.get(i6);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i6 < this.f9659c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int hashCode() {
            String str = this.f9661e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f9660d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f9657a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f9658b) * 31;
            List<LatLonPoint> list2 = this.f9659c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f9663g;
        }

        public boolean isUseFerry() {
            return this.f9662f;
        }

        public void setCarType(int i6) {
            this.f9663g = i6;
        }

        public void setExclude(String str) {
            this.f9664h = str;
        }

        public void setExtensions(String str) {
            this.f9665i = str;
        }

        public void setUseFerry(boolean z5) {
            this.f9662f = z5;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9657a, i6);
            parcel.writeInt(this.f9658b);
            parcel.writeTypedList(this.f9659c);
            List<List<LatLonPoint>> list = this.f9660d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.f9660d.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.f9661e);
            parcel.writeInt(this.f9662f ? 1 : 0);
            parcel.writeInt(this.f9663g);
            parcel.writeString(this.f9664h);
            parcel.writeString(this.f9665i);
        }

        public boolean hasAvoidRoad() {
            if (j4.j(getAvoidRoad())) {
                return false;
            }
            return true;
        }

        public boolean hasAvoidpolygons() {
            if (j4.j(getAvoidpolygonsStr())) {
                return false;
            }
            return true;
        }

        public boolean hasPassPoint() {
            if (j4.j(getPassedPointStr())) {
                return false;
            }
            return true;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f9662f = true;
            this.f9663g = 0;
            this.f9664h = null;
            this.f9665i = "base";
            this.f9657a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9658b = parcel.readInt();
            this.f9659c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f9660d = null;
            } else {
                this.f9660d = new ArrayList();
            }
            for (int i6 = 0; i6 < readInt; i6++) {
                this.f9660d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f9661e = parcel.readString();
            this.f9662f = parcel.readInt() == 1;
            this.f9663g = parcel.readInt();
            this.f9664h = parcel.readString();
            this.f9665i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f9662f = true;
            this.f9663g = 0;
            this.f9664h = null;
            this.f9665i = "base";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearch.FromAndTo.1
            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            private static FromAndTo[] a(int i6) {
                return new FromAndTo[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9666a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9667b;

        /* renamed from: c, reason: collision with root package name */
        private String f9668c;

        /* renamed from: d, reason: collision with root package name */
        private String f9669d;

        /* renamed from: e, reason: collision with root package name */
        private String f9670e;

        /* renamed from: f, reason: collision with root package name */
        private String f9671f;

        /* renamed from: g, reason: collision with root package name */
        private String f9672g;

        /* renamed from: h, reason: collision with root package name */
        private String f9673h;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9666a = latLonPoint;
            this.f9667b = latLonPoint2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.f9669d;
            if (str == null) {
                if (fromAndTo.f9669d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f9669d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f9666a;
            if (latLonPoint == null) {
                if (fromAndTo.f9666a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f9666a)) {
                return false;
            }
            String str2 = this.f9668c;
            if (str2 == null) {
                if (fromAndTo.f9668c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f9668c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f9667b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f9667b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f9667b)) {
                return false;
            }
            String str3 = this.f9670e;
            if (str3 == null) {
                if (fromAndTo.f9670e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f9670e)) {
                return false;
            }
            String str4 = this.f9671f;
            if (str4 == null) {
                if (fromAndTo.f9671f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f9671f)) {
                return false;
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m74clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f9666a, this.f9667b);
            fromAndTo.setStartPoiID(this.f9668c);
            fromAndTo.setDestinationPoiID(this.f9669d);
            fromAndTo.setOriginType(this.f9670e);
            fromAndTo.setDestinationType(this.f9671f);
            return fromAndTo;
        }

        public String getDestinationPoiID() {
            return this.f9669d;
        }

        public String getDestinationType() {
            return this.f9671f;
        }

        public LatLonPoint getFrom() {
            return this.f9666a;
        }

        public String getOriginType() {
            return this.f9670e;
        }

        public String getPlateNumber() {
            return this.f9673h;
        }

        public String getPlateProvince() {
            return this.f9672g;
        }

        public String getStartPoiID() {
            return this.f9668c;
        }

        public LatLonPoint getTo() {
            return this.f9667b;
        }

        public int hashCode() {
            String str = this.f9669d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f9666a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f9668c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f9667b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f9670e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9671f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f9669d = str;
        }

        public void setDestinationType(String str) {
            this.f9671f = str;
        }

        public void setOriginType(String str) {
            this.f9670e = str;
        }

        public void setPlateNumber(String str) {
            this.f9673h = str;
        }

        public void setPlateProvince(String str) {
            this.f9672g = str;
        }

        public void setStartPoiID(String str) {
            this.f9668c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9666a, i6);
            parcel.writeParcelable(this.f9667b, i6);
            parcel.writeString(this.f9668c);
            parcel.writeString(this.f9669d);
            parcel.writeString(this.f9670e);
            parcel.writeString(this.f9671f);
        }

        public FromAndTo(Parcel parcel) {
            this.f9666a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9667b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9668c = parcel.readString();
            this.f9669d = parcel.readString();
            this.f9670e = parcel.readString();
            this.f9671f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i6);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i6);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i6);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.RideRouteQuery.1
            private static RideRouteQuery a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            private static RideRouteQuery[] a(int i6) {
                return new RideRouteQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9674a;

        /* renamed from: b, reason: collision with root package name */
        private int f9675b;

        /* renamed from: c, reason: collision with root package name */
        private String f9676c;

        public RideRouteQuery(FromAndTo fromAndTo, int i6) {
            this.f9676c = "base";
            this.f9674a = fromAndTo;
            this.f9675b = i6;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
            FromAndTo fromAndTo = this.f9674a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f9674a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f9674a)) {
                return false;
            }
            return this.f9675b == rideRouteQuery.f9675b;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m75clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f9674a);
            rideRouteQuery.setExtensions(this.f9676c);
            return rideRouteQuery;
        }

        public String getExtensions() {
            return this.f9676c;
        }

        public FromAndTo getFromAndTo() {
            return this.f9674a;
        }

        public int getMode() {
            return this.f9675b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f9674a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f9675b;
        }

        public void setExtensions(String str) {
            this.f9676c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9674a, i6);
            parcel.writeInt(this.f9675b);
            parcel.writeString(this.f9676c);
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f9676c = "base";
            this.f9674a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f9676c = "base";
            this.f9674a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9675b = parcel.readInt();
            this.f9676c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f9676c = "base";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.TruckRouteQuery.1
            private static TruckRouteQuery a(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            private static TruckRouteQuery[] a(int i6) {
                return new TruckRouteQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9677a;

        /* renamed from: b, reason: collision with root package name */
        private int f9678b;

        /* renamed from: c, reason: collision with root package name */
        private int f9679c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f9680d;

        /* renamed from: e, reason: collision with root package name */
        private float f9681e;

        /* renamed from: f, reason: collision with root package name */
        private float f9682f;

        /* renamed from: g, reason: collision with root package name */
        private float f9683g;

        /* renamed from: h, reason: collision with root package name */
        private float f9684h;

        /* renamed from: i, reason: collision with root package name */
        private float f9685i;

        /* renamed from: j, reason: collision with root package name */
        private String f9686j;

        public TruckRouteQuery(FromAndTo fromAndTo, int i6, List<LatLonPoint> list, int i7) {
            this.f9686j = "base";
            this.f9677a = fromAndTo;
            this.f9679c = i6;
            this.f9680d = list;
            this.f9678b = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public TruckRouteQuery m76clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f9677a, this.f9679c, this.f9680d, this.f9678b);
            truckRouteQuery.setExtensions(this.f9686j);
            return truckRouteQuery;
        }

        public String getExtensions() {
            return this.f9686j;
        }

        public FromAndTo getFromAndTo() {
            return this.f9677a;
        }

        public int getMode() {
            return this.f9679c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f9680d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f9680d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f9680d.size(); i6++) {
                LatLonPoint latLonPoint = this.f9680d.get(i6);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i6 < this.f9680d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f9685i;
        }

        public float getTruckHeight() {
            return this.f9681e;
        }

        public float getTruckLoad() {
            return this.f9683g;
        }

        public int getTruckSize() {
            return this.f9678b;
        }

        public float getTruckWeight() {
            return this.f9684h;
        }

        public float getTruckWidth() {
            return this.f9682f;
        }

        public void setExtensions(String str) {
            this.f9686j = str;
        }

        public void setMode(int i6) {
            this.f9679c = i6;
        }

        public void setTruckAxis(float f6) {
            this.f9685i = f6;
        }

        public void setTruckHeight(float f6) {
            this.f9681e = f6;
        }

        public void setTruckLoad(float f6) {
            this.f9683g = f6;
        }

        public void setTruckSize(int i6) {
            this.f9678b = i6;
        }

        public void setTruckWeight(float f6) {
            this.f9684h = f6;
        }

        public void setTruckWidth(float f6) {
            this.f9682f = f6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9677a, i6);
            parcel.writeInt(this.f9678b);
            parcel.writeInt(this.f9679c);
            parcel.writeTypedList(this.f9680d);
            parcel.writeFloat(this.f9681e);
            parcel.writeFloat(this.f9682f);
            parcel.writeFloat(this.f9683g);
            parcel.writeFloat(this.f9684h);
            parcel.writeFloat(this.f9685i);
            parcel.writeString(this.f9686j);
        }

        public boolean hasPassPoint() {
            if (j4.j(getPassedPointStr())) {
                return false;
            }
            return true;
        }

        protected TruckRouteQuery(Parcel parcel) {
            this.f9678b = 2;
            this.f9686j = "base";
            this.f9677a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9678b = parcel.readInt();
            this.f9679c = parcel.readInt();
            this.f9680d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f9681e = parcel.readFloat();
            this.f9682f = parcel.readFloat();
            this.f9683g = parcel.readFloat();
            this.f9684h = parcel.readFloat();
            this.f9685i = parcel.readFloat();
            this.f9686j = parcel.readString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.WalkRouteQuery.1
            private static WalkRouteQuery a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            private static WalkRouteQuery[] a(int i6) {
                return new WalkRouteQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f9687a;

        /* renamed from: b, reason: collision with root package name */
        private int f9688b;

        /* renamed from: c, reason: collision with root package name */
        private String f9689c;

        public WalkRouteQuery(FromAndTo fromAndTo, int i6) {
            this.f9689c = "base";
            this.f9687a = fromAndTo;
            this.f9688b = i6;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f9687a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f9687a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f9687a)) {
                return false;
            }
            String str = this.f9689c;
            if (str == null) {
                if (walkRouteQuery.f9689c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.f9689c)) {
                return false;
            }
            return this.f9688b == walkRouteQuery.f9688b;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m77clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f9687a);
            walkRouteQuery.setExtensions(this.f9689c);
            return walkRouteQuery;
        }

        public String getExtensions() {
            return this.f9689c;
        }

        public FromAndTo getFromAndTo() {
            return this.f9687a;
        }

        public int getMode() {
            return this.f9688b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f9687a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f9688b;
        }

        public void setExtensions(String str) {
            this.f9689c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9687a, i6);
            parcel.writeInt(this.f9688b);
            parcel.writeString(this.f9689c);
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f9689c = "base";
            this.f9687a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f9689c = "base";
            this.f9687a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9688b = parcel.readInt();
            this.f9689c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f9689c = "base";
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f9643a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f9643a == null) {
            try {
                this.f9643a = new t0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
