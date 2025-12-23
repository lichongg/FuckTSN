package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.u0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import com.beizi.fusion.widget.ScrollClickView;
import com.huawei.hms.common.util.Logger;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearchV2 f9691a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class BusMode {
        public static final int BUS_COMFORTABLE = 4;
        public static final int BUS_DEFAULT = 0;
        public static final int BUS_LEASE_CHANGE = 2;
        public static final int BUS_LEASE_WALK = 3;
        public static final int BUS_NO_SUBWAY = 5;
        public static final int BUS_SAVE_MONEY = 1;
        public static final int BUS_SUBWAY = 6;
        public static final int BUS_SUBWAY_FIRST = 7;
        public static final int BUS_WASTE_LESS = 8;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.BusRouteQuery.1
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
        private FromAndTo f9693a;

        /* renamed from: b, reason: collision with root package name */
        private int f9694b;

        /* renamed from: c, reason: collision with root package name */
        private String f9695c;

        /* renamed from: d, reason: collision with root package name */
        private String f9696d;

        /* renamed from: e, reason: collision with root package name */
        private String f9697e;

        /* renamed from: f, reason: collision with root package name */
        private String f9698f;

        /* renamed from: g, reason: collision with root package name */
        private int f9699g;

        /* renamed from: h, reason: collision with root package name */
        private String f9700h;

        /* renamed from: i, reason: collision with root package name */
        private String f9701i;

        /* renamed from: j, reason: collision with root package name */
        private String f9702j;

        /* renamed from: k, reason: collision with root package name */
        private String f9703k;

        /* renamed from: l, reason: collision with root package name */
        private int f9704l;

        /* renamed from: m, reason: collision with root package name */
        private int f9705m;

        /* renamed from: n, reason: collision with root package name */
        private int f9706n;

        /* renamed from: o, reason: collision with root package name */
        private int f9707o;

        public BusRouteQuery(FromAndTo fromAndTo, int i6, String str, int i7) {
            this.f9704l = 5;
            this.f9705m = 0;
            this.f9706n = 4;
            this.f9707o = 1;
            this.f9693a = fromAndTo;
            this.f9694b = i6;
            this.f9695c = str;
            this.f9699g = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m78clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f9693a, this.f9694b, this.f9695c, this.f9699g);
            busRouteQuery.setCityd(this.f9696d);
            busRouteQuery.setShowFields(this.f9707o);
            busRouteQuery.setDate(this.f9697e);
            busRouteQuery.setTime(this.f9698f);
            busRouteQuery.setAd1(this.f9702j);
            busRouteQuery.setAd2(this.f9703k);
            busRouteQuery.setOriginPoiId(this.f9700h);
            busRouteQuery.setDestinationPoiId(this.f9701i);
            busRouteQuery.setMaxTrans(this.f9706n);
            busRouteQuery.setMultiExport(this.f9705m);
            busRouteQuery.setAlternativeRoute(this.f9704l);
            return busRouteQuery;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.f9694b == busRouteQuery.f9694b && this.f9699g == busRouteQuery.f9699g && this.f9700h.equals(busRouteQuery.f9700h) && this.f9701i.equals(busRouteQuery.f9701i) && this.f9704l == busRouteQuery.f9704l && this.f9705m == busRouteQuery.f9705m && this.f9706n == busRouteQuery.f9706n && this.f9707o == busRouteQuery.f9707o && this.f9693a.equals(busRouteQuery.f9693a) && this.f9695c.equals(busRouteQuery.f9695c) && this.f9696d.equals(busRouteQuery.f9696d) && this.f9697e.equals(busRouteQuery.f9697e) && this.f9698f.equals(busRouteQuery.f9698f) && this.f9702j.equals(busRouteQuery.f9702j)) {
                return this.f9703k.equals(busRouteQuery.f9703k);
            }
            return false;
        }

        public String getAd1() {
            return this.f9702j;
        }

        public String getAd2() {
            return this.f9703k;
        }

        public int getAlternativeRoute() {
            return this.f9704l;
        }

        public String getCity() {
            return this.f9695c;
        }

        public String getCityd() {
            return this.f9696d;
        }

        public String getDate() {
            return this.f9697e;
        }

        public String getDestinationPoiId() {
            return this.f9701i;
        }

        public FromAndTo getFromAndTo() {
            return this.f9693a;
        }

        public int getMaxTrans() {
            return this.f9706n;
        }

        public int getMode() {
            return this.f9694b;
        }

        public int getMultiExport() {
            return this.f9705m;
        }

        public int getNightFlag() {
            return this.f9699g;
        }

        public String getOriginPoiId() {
            return this.f9700h;
        }

        public int getShowFields() {
            return this.f9707o;
        }

        public String getTime() {
            return this.f9698f;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.f9693a.hashCode() * 31) + this.f9694b) * 31) + this.f9695c.hashCode()) * 31) + this.f9696d.hashCode()) * 31) + this.f9697e.hashCode()) * 31) + this.f9698f.hashCode()) * 31) + this.f9699g) * 31) + this.f9700h.hashCode()) * 31) + this.f9701i.hashCode()) * 31) + this.f9702j.hashCode()) * 31) + this.f9703k.hashCode()) * 31) + this.f9704l) * 31) + this.f9705m) * 31) + this.f9706n) * 31) + this.f9707o;
        }

        public void setAd1(String str) {
            this.f9702j = str;
        }

        public void setAd2(String str) {
            this.f9703k = str;
        }

        public void setAlternativeRoute(int i6) {
            this.f9704l = i6;
        }

        public void setCityd(String str) {
            this.f9696d = str;
        }

        public void setDate(String str) {
            this.f9697e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f9701i = str;
        }

        public void setMaxTrans(int i6) {
            this.f9706n = i6;
        }

        public void setMultiExport(int i6) {
            this.f9705m = i6;
        }

        public void setOriginPoiId(String str) {
            this.f9700h = str;
        }

        public void setShowFields(int i6) {
            this.f9707o = i6;
        }

        public void setTime(String str) {
            this.f9698f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9693a, i6);
            parcel.writeInt(this.f9694b);
            parcel.writeString(this.f9695c);
            parcel.writeInt(this.f9699g);
            parcel.writeString(this.f9696d);
            parcel.writeInt(this.f9707o);
            parcel.writeString(this.f9700h);
            parcel.writeString(this.f9701i);
            parcel.writeString(this.f9702j);
            parcel.writeString(this.f9703k);
            parcel.writeInt(this.f9704l);
            parcel.writeInt(this.f9706n);
            parcel.writeInt(this.f9705m);
            parcel.writeString(this.f9697e);
            parcel.writeString(this.f9698f);
        }

        public BusRouteQuery(Parcel parcel) {
            this.f9694b = 0;
            this.f9699g = 0;
            this.f9704l = 5;
            this.f9705m = 0;
            this.f9706n = 4;
            this.f9707o = 1;
            this.f9693a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9694b = parcel.readInt();
            this.f9695c = parcel.readString();
            this.f9699g = parcel.readInt();
            this.f9696d = parcel.readString();
            this.f9707o = parcel.readInt();
            this.f9700h = parcel.readString();
            this.f9701i = parcel.readString();
            this.f9697e = parcel.readString();
            this.f9698f = parcel.readString();
            this.f9706n = parcel.readInt();
            this.f9705m = parcel.readInt();
            this.f9704l = parcel.readInt();
            this.f9702j = parcel.readString();
            this.f9703k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f9694b = 0;
            this.f9699g = 0;
            this.f9704l = 5;
            this.f9705m = 0;
            this.f9706n = 4;
            this.f9707o = 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CurveCost {

        /* renamed from: a, reason: collision with root package name */
        private float f9708a;

        /* renamed from: b, reason: collision with root package name */
        private float f9709b;

        public float getAccess() {
            return this.f9708a;
        }

        public float getValue() {
            return this.f9709b;
        }

        public void setAccess(float f6) {
            this.f9708a = f6;
        }

        public void setValue(float f6) {
            this.f9709b = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CustomCostMode {

        /* renamed from: a, reason: collision with root package name */
        private List<SpeedCost> f9710a;

        /* renamed from: b, reason: collision with root package name */
        private CurveCost f9711b;

        /* renamed from: c, reason: collision with root package name */
        private SlopeCost f9712c;

        /* renamed from: d, reason: collision with root package name */
        private float f9713d;

        /* renamed from: e, reason: collision with root package name */
        private TransCost f9714e;

        /* renamed from: f, reason: collision with root package name */
        private float f9715f;

        /* renamed from: g, reason: collision with root package name */
        private PowerTrainLoss f9716g;

        public float getAuxCost() {
            return this.f9713d;
        }

        public CurveCost getCurveCost() {
            return this.f9711b;
        }

        public float getFerryCost() {
            return this.f9715f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f9716g;
        }

        public SlopeCost getSlopeCost() {
            return this.f9712c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f9710a;
        }

        public TransCost getTransCost() {
            return this.f9714e;
        }

        public void setAuxCost(float f6) {
            this.f9713d = f6;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f9711b = curveCost;
        }

        public void setFerryCost(float f6) {
            this.f9715f = f6;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f9716g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f9712c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f9710a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.f9714e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f9710a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put("value", speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f9711b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(bi.Q, this.f9711b.getAccess());
                    jSONObject3.put("value", this.f9711b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f9712c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f9712c.getUp());
                    jSONObject4.put(ScrollClickView.DIR_DOWN, this.f9712c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f9713d);
                if (this.f9714e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(bi.Q, this.f9714e.getAccess());
                    jSONObject5.put("decess", this.f9714e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f9715f);
                if (this.f9716g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f9716g.getPowerDemand());
                    jSONObject6.put("value", this.f9716g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.f9716g.getSpeed());
                    jSONObject7.put("value", this.f9716g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
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
        private FromAndTo f9717a;

        /* renamed from: b, reason: collision with root package name */
        private NewEnergy f9718b;

        /* renamed from: c, reason: collision with root package name */
        private int f9719c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f9720d;

        /* renamed from: e, reason: collision with root package name */
        private List<List<LatLonPoint>> f9721e;

        /* renamed from: f, reason: collision with root package name */
        private String f9722f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f9723g;

        /* renamed from: h, reason: collision with root package name */
        private int f9724h;

        /* renamed from: i, reason: collision with root package name */
        private String f9725i;

        /* renamed from: j, reason: collision with root package name */
        private int f9726j;

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f9719c = DrivingStrategy.DEFAULT.getValue();
            this.f9723g = true;
            this.f9724h = 0;
            this.f9725i = null;
            this.f9726j = 1;
            this.f9717a = fromAndTo;
            this.f9719c = drivingStrategy.getValue();
            this.f9720d = list;
            this.f9721e = list2;
            this.f9722f = str;
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
            String str = this.f9722f;
            if (str == null) {
                if (driveRouteQuery.f9722f != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f9722f)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f9721e;
            if (list == null) {
                if (driveRouteQuery.f9721e != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f9721e)) {
                return false;
            }
            FromAndTo fromAndTo = this.f9717a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f9717a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f9717a)) {
                return false;
            }
            if (this.f9719c != driveRouteQuery.f9719c) {
                return false;
            }
            List<LatLonPoint> list2 = this.f9720d;
            if (list2 == null) {
                if (driveRouteQuery.f9720d != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f9720d) || this.f9723g != driveRouteQuery.isUseFerry() || this.f9724h != driveRouteQuery.f9724h || this.f9726j != driveRouteQuery.f9726j) {
                return false;
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m79clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f9717a, DrivingStrategy.fromValue(this.f9719c), this.f9720d, this.f9721e, this.f9722f);
            driveRouteQuery.setUseFerry(this.f9723g);
            driveRouteQuery.setCarType(this.f9724h);
            driveRouteQuery.setExclude(this.f9725i);
            driveRouteQuery.setShowFields(this.f9726j);
            driveRouteQuery.setNewEnergy(this.f9718b);
            return driveRouteQuery;
        }

        public String getAvoidRoad() {
            return this.f9722f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f9721e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f9721e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f9721e.size(); i6++) {
                List<LatLonPoint> list2 = this.f9721e.get(i6);
                for (int i7 = 0; i7 < list2.size(); i7++) {
                    LatLonPoint latLonPoint = list2.get(i7);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i7 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i6 < this.f9721e.size() - 1) {
                    stringBuffer.append(Logger.f33116c);
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f9724h;
        }

        public String getExclude() {
            return this.f9725i;
        }

        public FromAndTo getFromAndTo() {
            return this.f9717a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f9719c);
        }

        public NewEnergy getNewEnergy() {
            return this.f9718b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f9720d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f9720d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i6 = 0; i6 < this.f9720d.size(); i6++) {
                LatLonPoint latLonPoint = this.f9720d.get(i6);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i6 < this.f9720d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f9726j;
        }

        public int hashCode() {
            String str = this.f9722f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f9721e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f9717a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f9719c) * 31;
            List<LatLonPoint> list2 = this.f9720d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f9724h;
        }

        public boolean isUseFerry() {
            return this.f9723g;
        }

        public void setCarType(int i6) {
            this.f9724h = i6;
        }

        public void setExclude(String str) {
            this.f9725i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f9718b = newEnergy;
        }

        public void setShowFields(int i6) {
            this.f9726j = i6;
        }

        public void setUseFerry(boolean z5) {
            this.f9723g = z5;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9717a, i6);
            parcel.writeInt(this.f9719c);
            parcel.writeTypedList(this.f9720d);
            List<List<LatLonPoint>> list = this.f9721e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.f9721e.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.f9722f);
            parcel.writeInt(this.f9723g ? 1 : 0);
            parcel.writeInt(this.f9724h);
            parcel.writeString(this.f9725i);
            parcel.writeInt(this.f9726j);
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
            this.f9719c = DrivingStrategy.DEFAULT.getValue();
            this.f9723g = true;
            this.f9724h = 0;
            this.f9725i = null;
            this.f9726j = 1;
            this.f9717a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f9719c = parcel.readInt();
            this.f9720d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f9721e = null;
            } else {
                this.f9721e = new ArrayList();
            }
            for (int i6 = 0; i6 < readInt; i6++) {
                this.f9721e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f9722f = parcel.readString();
            this.f9723g = parcel.readInt() == 1;
            this.f9724h = parcel.readInt();
            this.f9725i = parcel.readString();
            this.f9726j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f9719c = DrivingStrategy.DEFAULT.getValue();
            this.f9723g = true;
            this.f9724h = 0;
            this.f9725i = null;
            this.f9726j = 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);


        /* renamed from: a, reason: collision with root package name */
        int f9728a;

        public final int getValue() {
            return this.f9728a;
        }

        DrivingStrategy(int i6) {
            this.f9728a = i6;
        }

        public static DrivingStrategy fromValue(int i6) {
            return values()[i6 - 32];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
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
        private LatLonPoint f9729a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9730b;

        /* renamed from: c, reason: collision with root package name */
        private String f9731c;

        /* renamed from: d, reason: collision with root package name */
        private String f9732d;

        /* renamed from: e, reason: collision with root package name */
        private String f9733e;

        /* renamed from: f, reason: collision with root package name */
        private String f9734f;

        /* renamed from: g, reason: collision with root package name */
        private String f9735g;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9729a = latLonPoint;
            this.f9730b = latLonPoint2;
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
            String str = this.f9732d;
            if (str == null) {
                if (fromAndTo.f9732d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f9732d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f9729a;
            if (latLonPoint == null) {
                if (fromAndTo.f9729a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f9729a)) {
                return false;
            }
            String str2 = this.f9731c;
            if (str2 == null) {
                if (fromAndTo.f9731c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f9731c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f9730b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f9730b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f9730b)) {
                return false;
            }
            String str3 = this.f9733e;
            if (str3 == null) {
                if (fromAndTo.f9733e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f9733e)) {
                return false;
            }
            String str4 = this.f9734f;
            if (str4 == null) {
                if (fromAndTo.f9734f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f9734f)) {
                return false;
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m80clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f9729a, this.f9730b);
            fromAndTo.setStartPoiID(this.f9731c);
            fromAndTo.setDestinationPoiID(this.f9732d);
            fromAndTo.setOriginType(this.f9733e);
            fromAndTo.setDestinationType(this.f9734f);
            return fromAndTo;
        }

        public String getDestinationPoiID() {
            return this.f9732d;
        }

        public String getDestinationType() {
            return this.f9734f;
        }

        public LatLonPoint getFrom() {
            return this.f9729a;
        }

        public String getOriginType() {
            return this.f9733e;
        }

        public String getPlateNumber() {
            return this.f9735g;
        }

        public String getStartPoiID() {
            return this.f9731c;
        }

        public LatLonPoint getTo() {
            return this.f9730b;
        }

        public int hashCode() {
            String str = this.f9732d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f9729a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f9731c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f9730b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f9733e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9734f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f9732d = str;
        }

        public void setDestinationType(String str) {
            this.f9734f = str;
        }

        public void setOriginType(String str) {
            this.f9733e = str;
        }

        public void setPlateNumber(String str) {
            this.f9735g = str;
        }

        public void setStartPoiID(String str) {
            this.f9731c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9729a, i6);
            parcel.writeParcelable(this.f9730b, i6);
            parcel.writeString(this.f9731c);
            parcel.writeString(this.f9732d);
            parcel.writeString(this.f9733e);
            parcel.writeString(this.f9734f);
        }

        public FromAndTo(Parcel parcel) {
            this.f9729a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9730b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9731c = parcel.readString();
            this.f9732d = parcel.readString();
            this.f9733e = parcel.readString();
            this.f9734f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NewEnergy {

        /* renamed from: a, reason: collision with root package name */
        private String f9736a;

        /* renamed from: b, reason: collision with root package name */
        private CustomCostMode f9737b;

        /* renamed from: h, reason: collision with root package name */
        private String f9743h;

        /* renamed from: c, reason: collision with root package name */
        private float f9738c = -1.0f;

        /* renamed from: d, reason: collision with root package name */
        private float f9739d = -1.0f;

        /* renamed from: e, reason: collision with root package name */
        private float f9740e = 1.5f;

        /* renamed from: f, reason: collision with root package name */
        private float f9741f = 100.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f9742g = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        private int f9744i = 0;

        public String buildParam() {
            StringBuilder sb = new StringBuilder();
            if (this.f9736a != null) {
                sb.append("&key=");
                sb.append(this.f9736a);
            }
            if (this.f9737b != null) {
                sb.append("&custom_cost_mode=");
                sb.append(this.f9737b.toJson());
            }
            if (this.f9738c > 0.0f) {
                sb.append("&max_vehicle_charge=");
                sb.append(this.f9738c);
            }
            if (this.f9739d > 0.0f) {
                sb.append("&vehicle_charge=");
                sb.append(this.f9739d);
            }
            sb.append("&load=");
            sb.append(this.f9740e);
            sb.append("&leaving_percent=");
            sb.append(this.f9741f);
            sb.append("&arriving_percent=");
            sb.append(this.f9742g);
            if (this.f9743h != null) {
                sb.append("&custom_charging_arguments=");
                sb.append(this.f9743h);
            }
            if (this.f9744i > 0) {
                sb.append("&waypoints_arriving_percent=");
                sb.append(this.f9744i);
            }
            return sb.toString();
        }

        public float getArrivingPercent() {
            return this.f9742g;
        }

        public String getCustomChargingArguments() {
            return this.f9743h;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f9737b;
        }

        public String getKey() {
            return this.f9736a;
        }

        public float getLeavingPercent() {
            return this.f9741f;
        }

        public float getLoad() {
            return this.f9740e;
        }

        public float getMaxVehicleCharge() {
            return this.f9738c;
        }

        public float getVehicleCharge() {
            return this.f9739d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f9744i;
        }

        public void setArrivingPercent(float f6) {
            this.f9742g = f6;
        }

        public void setCustomChargingArguments(String str) {
            this.f9743h = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f9737b = customCostMode;
        }

        public void setKey(String str) {
            this.f9736a = str;
        }

        public void setLeavingPercent(float f6) {
            this.f9741f = f6;
        }

        public void setLoad(float f6) {
            this.f9740e = f6;
        }

        public void setMaxVehicleCharge(float f6) {
            this.f9738c = f6;
        }

        public void setVehicleCharge(float f6) {
            this.f9739d = f6;
        }

        public void setWaypointsArrivingPercent(int i6) {
            this.f9744i = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i6);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i6);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i6);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class PowerTrainLoss {

        /* renamed from: a, reason: collision with root package name */
        private int f9745a;

        /* renamed from: b, reason: collision with root package name */
        private float f9746b;

        /* renamed from: c, reason: collision with root package name */
        private int f9747c;

        /* renamed from: d, reason: collision with root package name */
        private int f9748d;

        public int getPowerDemand() {
            return this.f9745a;
        }

        public float getPowerDemandValue() {
            return this.f9746b;
        }

        public int getSpeed() {
            return this.f9747c;
        }

        public int getSpeedValue() {
            return this.f9748d;
        }

        public void setPowerDemand(int i6) {
            this.f9745a = i6;
        }

        public void setPowerDemandValue(float f6) {
            this.f9746b = f6;
        }

        public void setSpeed(int i6) {
            this.f9747c = i6;
        }

        public void setSpeedValue(int i6) {
            this.f9748d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.RideRouteQuery.1
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
        private FromAndTo f9749a;

        /* renamed from: b, reason: collision with root package name */
        private int f9750b;

        /* renamed from: c, reason: collision with root package name */
        private int f9751c;

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f9750b = 1;
            this.f9751c = 1;
            this.f9749a = fromAndTo;
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
            FromAndTo fromAndTo = this.f9749a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f9749a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f9749a)) {
                return false;
            }
            return this.f9750b == rideRouteQuery.f9750b && this.f9751c == rideRouteQuery.f9751c;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m81clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f9749a);
            rideRouteQuery.setShowFields(this.f9750b);
            rideRouteQuery.setAlternativeRoute(this.f9751c);
            return rideRouteQuery;
        }

        public int getAlternativeRoute() {
            return this.f9751c;
        }

        public FromAndTo getFromAndTo() {
            return this.f9749a;
        }

        public int getShowFields() {
            return this.f9750b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f9749a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f9750b) * 31) + this.f9751c;
        }

        public void setAlternativeRoute(int i6) {
            this.f9751c = i6;
        }

        public void setShowFields(int i6) {
            this.f9750b = i6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9749a, i6);
            parcel.writeInt(this.f9751c);
            parcel.writeInt(this.f9750b);
        }

        public RideRouteQuery(Parcel parcel) {
            this.f9750b = 1;
            this.f9751c = 1;
            this.f9749a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f9751c = parcel.readInt();
            this.f9750b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f9750b = 1;
            this.f9751c = 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SlopeCost {

        /* renamed from: a, reason: collision with root package name */
        private float f9752a;

        /* renamed from: b, reason: collision with root package name */
        private float f9753b;

        public float getDown() {
            return this.f9753b;
        }

        public float getUp() {
            return this.f9752a;
        }

        public void setDown(float f6) {
            this.f9753b = f6;
        }

        public void setUp(float f6) {
            this.f9752a = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SpeedCost {

        /* renamed from: a, reason: collision with root package name */
        private int f9754a;

        /* renamed from: b, reason: collision with root package name */
        private float f9755b;

        public int getSpeed() {
            return this.f9754a;
        }

        public float getValue() {
            return this.f9755b;
        }

        public void setSpeed(int i6) {
            this.f9754a = i6;
        }

        public void setValue(float f6) {
            this.f9755b = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class TransCost {

        /* renamed from: a, reason: collision with root package name */
        private float f9756a;

        /* renamed from: b, reason: collision with root package name */
        private float f9757b;

        public float getAccess() {
            return this.f9756a;
        }

        public float getDecess() {
            return this.f9757b;
        }

        public void setAccess(float f6) {
            this.f9756a = f6;
        }

        public void setDecess(float f6) {
            this.f9757b = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.WalkRouteQuery.1
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
        private FromAndTo f9758a;

        /* renamed from: b, reason: collision with root package name */
        private int f9759b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9760c;

        /* renamed from: d, reason: collision with root package name */
        private int f9761d;

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f9759b = 1;
            this.f9760c = false;
            this.f9761d = 1;
            this.f9758a = fromAndTo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m82clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f9758a);
            walkRouteQuery.setShowFields(this.f9759b);
            walkRouteQuery.setIndoor(this.f9760c);
            walkRouteQuery.setAlternativeRoute(this.f9761d);
            return walkRouteQuery;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.f9759b == walkRouteQuery.f9759b && this.f9760c == walkRouteQuery.f9760c && this.f9761d == walkRouteQuery.f9761d) {
                return this.f9758a.equals(walkRouteQuery.f9758a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f9761d;
        }

        public FromAndTo getFromAndTo() {
            return this.f9758a;
        }

        public int getShowFields() {
            return this.f9759b;
        }

        public int hashCode() {
            return (((((this.f9758a.hashCode() * 31) + this.f9759b) * 31) + (this.f9760c ? 1 : 0)) * 31) + this.f9761d;
        }

        public boolean isIndoor() {
            return this.f9760c;
        }

        public void setAlternativeRoute(int i6) {
            this.f9761d = i6;
        }

        public void setIndoor(boolean z5) {
            this.f9760c = z5;
        }

        public void setShowFields(int i6) {
            this.f9759b = i6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeParcelable(this.f9758a, i6);
            parcel.writeBooleanArray(new boolean[]{this.f9760c});
            parcel.writeInt(this.f9761d);
            parcel.writeInt(this.f9759b);
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f9759b = 1;
            this.f9760c = false;
            this.f9761d = 1;
            this.f9758a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f9760c = zArr[0];
            this.f9761d = parcel.readInt();
            this.f9759b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f9759b = 1;
            this.f9760c = false;
            this.f9761d = 1;
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f9691a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f9691a == null) {
            try {
                this.f9691a = new u0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
