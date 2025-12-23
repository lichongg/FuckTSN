package com.amap.api.col.s;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusPathV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.BusStepV2;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TaxiItemV2;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class r4 {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f8420a = {"010", "021", "022", "023", "1852", "1853"};

    private static boolean E0(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : f8420a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static LatLonPoint I0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static int K(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    private static int L0(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e6) {
                j4.i(e6, "JSONHelper", "str2int");
            }
        }
        return 0;
    }

    private static float N0(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e6) {
                j4.i(e6, "JSONHelper", "str2float");
            }
        }
        return 0.0f;
    }

    private static BusStep O0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(S0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(V0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(m(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    private static BusStepV2 Q0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStepV2 busStepV2 = new BusStepV2();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStepV2.setWalk(T0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStepV2.setBusLines(W0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStepV2.setEntrance(X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStepV2.setExit(X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStepV2.setRailway(g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStepV2.setTaxi(n(optJSONObject6));
        }
        if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
            return null;
        }
        return busStepV2;
    }

    private static LatLonPoint S(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return I0(jSONObject.optString(str));
        }
        return null;
    }

    private static boolean U0(String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    private static RouteRailwayItem g(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has(CommonNetImpl.NAME)) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(v(jSONObject, "id"));
        routeRailwayItem.setName(v(jSONObject, CommonNetImpl.NAME));
        routeRailwayItem.setTime(v(jSONObject, "time"));
        routeRailwayItem.setTrip(v(jSONObject, "trip"));
        routeRailwayItem.setDistance(N0(v(jSONObject, "distance")));
        routeRailwayItem.setType(v(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(h(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(h(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(i(jSONObject));
        routeRailwayItem.setAlters(j(jSONObject));
        routeRailwayItem.setSpaces(k(jSONObject));
        return routeRailwayItem;
    }

    public static TruckRouteRestult A0(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(S(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
            if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    TruckPath truckPath = new TruckPath();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                    truckPath.setDistance(N0(v(jSONObject2, "distance")));
                    truckPath.setDuration(R0(v(jSONObject2, "duration")));
                    truckPath.setStrategy(v(jSONObject2, "strategy"));
                    truckPath.setTolls(N0(v(jSONObject2, "tolls")));
                    truckPath.setTollDistance(N0(v(jSONObject2, "toll_distance")));
                    truckPath.setTotalTrafficlights(L0(v(jSONObject2, "traffic_lights")));
                    truckPath.setRestriction(L0(v(jSONObject2, "restriction")));
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                            TruckStep truckStep = new TruckStep();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i7);
                            if (optJSONObject2 != null) {
                                truckStep.setInstruction(v(optJSONObject2, "instruction"));
                                truckStep.setOrientation(v(optJSONObject2, "orientation"));
                                truckStep.setRoad(v(optJSONObject2, "road"));
                                truckStep.setDistance(N0(v(optJSONObject2, "distance")));
                                truckStep.setTolls(N0(v(optJSONObject2, "tolls")));
                                truckStep.setTollDistance(N0(v(optJSONObject2, "toll_distance")));
                                truckStep.setTollRoad(v(optJSONObject2, "toll_road"));
                                truckStep.setDuration(N0(v(optJSONObject2, "duration")));
                                truckStep.setPolyline(a0(optJSONObject2, "polyline"));
                                truckStep.setAction(v(optJSONObject2, com.umeng.ccg.a.f41544t));
                                truckStep.setAssistantAction(v(optJSONObject2, "assistant_action"));
                                G(truckStep, optJSONObject2);
                                Q(truckStep, optJSONObject2);
                                arrayList2.add(truckStep);
                            }
                        }
                        truckPath.setSteps(arrayList2);
                        arrayList.add(truckPath);
                    }
                }
                truckRouteRestult.setPaths(arrayList);
                return truckRouteRestult;
            }
            return truckRouteRestult;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void C(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(N0(v(jSONObject, "tolls")));
            cost.setTollDistance(N0(v(jSONObject, "toll_distance")));
            cost.setTollRoad(v(jSONObject, "toll_road"));
            cost.setDuration(N0(v(jSONObject, "duration")));
            cost.setTrafficLights(L0(v(jSONObject, "traffic_lights")));
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01aa A[Catch: all -> 0x0029, JSONException -> 0x002c, TryCatch #2 {JSONException -> 0x002c, all -> 0x0029, blocks: (B:3:0x000e, B:5:0x001b, B:6:0x002f, B:10:0x0037, B:14:0x0044, B:17:0x004c, B:20:0x0054, B:21:0x005a, B:24:0x0064, B:26:0x006f, B:28:0x008f, B:29:0x0095, B:31:0x009b, B:33:0x00a8, B:36:0x00d9, B:38:0x00ec, B:43:0x00f3, B:45:0x0102, B:49:0x0108, B:52:0x0113, B:55:0x011a, B:56:0x0120, B:58:0x0126, B:60:0x0131, B:62:0x0138, B:64:0x014b, B:65:0x0151, B:67:0x0157, B:69:0x0162, B:75:0x019f, B:77:0x01aa, B:78:0x01b2, B:80:0x01b8, B:82:0x01c5, B:84:0x01e8, B:88:0x01ef, B:90:0x0200, B:96:0x020b, B:98:0x021e, B:103:0x0227), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.services.route.DriveRoutePlanResult C0(java.lang.String r20) throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r4.C0(java.lang.String):com.amap.api.services.route.DriveRoutePlanResult");
    }

    private static void D(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "distance")));
                    tmc.setStatus(v(optJSONObject, NotificationCompat.CATEGORY_STATUS));
                    tmc.setPolyline(a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static BusStationItem D0(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(v(jSONObject, "id"));
        busStationItem.setLatLonPoint(S(jSONObject, SocializeConstants.KEY_LOCATION));
        busStationItem.setBusStationName(v(jSONObject, CommonNetImpl.NAME));
        return busStationItem;
    }

    private static void F(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        district.setDistrictName(v(optJSONObject, CommonNetImpl.NAME));
                        district.setDistrictAdcode(v(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e6) {
                j4.i(e6, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    private static BusLineItem F0(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(v(jSONObject, "id"));
        busLineItem.setBusLineType(v(jSONObject, "type"));
        busLineItem.setBusLineName(v(jSONObject, CommonNetImpl.NAME));
        busLineItem.setDirectionsCoordinates(a0(jSONObject, "polyline"));
        busLineItem.setCityCode(v(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(v(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(v(jSONObject, "end_stop"));
        return busLineItem;
    }

    private static void G(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, CommonNetImpl.NAME));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> G0(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(I0(str2));
        }
        return arrayList;
    }

    public static void H(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                crossroad.setId(v(optJSONObject, "id"));
                crossroad.setDirection(v(optJSONObject, "direction"));
                crossroad.setDistance(N0(v(optJSONObject, "distance")));
                crossroad.setCenterPoint(S(optJSONObject, SocializeConstants.KEY_LOCATION));
                crossroad.setFirstRoadId(v(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(v(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(v(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(v(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void I(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                arrayList.add(J0(optJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    public static void J(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(v(jSONObject, "country"));
        regeocodeAddress.setCountryCode(v(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(v(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(v(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(v(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(v(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(v(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(v(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(v(jSONObject.optJSONObject("neighborhood"), CommonNetImpl.NAME));
        regeocodeAddress.setBuilding(v(jSONObject.optJSONObject("building"), CommonNetImpl.NAME));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(v(optJSONObject, "street"));
        streetNumber.setNumber(v(optJSONObject, "number"));
        streetNumber.setLatLonPoint(S(optJSONObject, SocializeConstants.KEY_LOCATION));
        streetNumber.setDirection(v(optJSONObject, "direction"));
        streetNumber.setDistance(N0(v(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(M0(jSONObject));
        regeocodeAddress.setTowncode(v(jSONObject, "towncode"));
        B(regeocodeAddress);
    }

    private static DistrictItem J0(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(v(jSONObject, "citycode"));
        districtItem.setAdcode(v(jSONObject, "adcode"));
        districtItem.setName(v(jSONObject, CommonNetImpl.NAME));
        districtItem.setLevel(v(jSONObject, "level"));
        districtItem.setCenter(S(jSONObject, AutoScrollViewPager.f4187g));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        I(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    private static boolean K0(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    public static BusRouteResultV2 L(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                busRouteResultV2.setStartPos(S(optJSONObject, "origin"));
                busRouteResultV2.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
                busRouteResultV2.setDistance(N0(v(optJSONObject, "distance")));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busRouteResultV2.setTaxiCost(N0(v(optJSONObject2, "taxi_fee")));
                }
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResultV2.setPaths(N(optJSONArray));
                    return busRouteResultV2;
                }
            }
            return busRouteResultV2;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<String> M(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                arrayList.add(optJSONArray.optString(i6));
            }
        }
        return arrayList;
    }

    private static List<BusinessArea> M0(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(S(optJSONObject, SocializeConstants.KEY_LOCATION));
                    businessArea.setName(v(optJSONObject, CommonNetImpl.NAME));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    private static List<BusPathV2> N(JSONArray jSONArray) throws JSONException {
        BusStepV2 Q0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                BusPathV2 busPathV2 = new BusPathV2();
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                    if (optJSONObject2 != null) {
                        busPathV2.setDuration(R0(v(optJSONObject2, "duration")));
                        busPathV2.setCost(N0(v(optJSONObject2, "transit_fee")));
                    }
                    busPathV2.setDistance(N0(v(optJSONObject, "distance")));
                    busPathV2.setNightBus(U0(v(optJSONObject, "nightflag")));
                    busPathV2.setWalkDistance(N0(v(optJSONObject, "walking_distance")));
                    JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                    if (optJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i7);
                            if (optJSONObject3 != null && (Q0 = Q0(optJSONObject3)) != null) {
                                arrayList2.add(Q0);
                                if (Q0.getWalk() != null) {
                                    f7 += Q0.getWalk().getDistance();
                                }
                                if (Q0.getBusLines() != null && Q0.getBusLines().size() > 0) {
                                    f6 += Q0.getBusLines().get(0).getDistance();
                                }
                            }
                        }
                        busPathV2.setSteps(arrayList2);
                        busPathV2.setBusDistance(f6);
                        busPathV2.setWalkDistance(f7);
                        arrayList.add(busPathV2);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void O(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, CommonNetImpl.NAME));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static double P0(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e6) {
                j4.i(e6, "JSONHelper", "str2float");
            }
        }
        return 0.0d;
    }

    private static void Q(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "distance")));
                    tmc.setStatus(v(optJSONObject, NotificationCompat.CATEGORY_STATUS));
                    tmc.setPolyline(a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void R(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                regeocodeRoad.setId(v(optJSONObject, "id"));
                regeocodeRoad.setName(v(optJSONObject, CommonNetImpl.NAME));
                regeocodeRoad.setLatLngPoint(S(optJSONObject, SocializeConstants.KEY_LOCATION));
                regeocodeRoad.setDirection(v(optJSONObject, "direction"));
                regeocodeRoad.setDistance(N0(v(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    private static long R0(String str) {
        if (str != null && !str.equals("") && !str.equals("[]")) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e6) {
                j4.i(e6, "JSONHelper", "str2long");
            }
        }
        return 0L;
    }

    private static RouteBusWalkItem S0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(S(jSONObject, "origin"));
        routeBusWalkItem.setDestination(S(jSONObject, RtspHeaders.Values.DESTINATION));
        routeBusWalkItem.setDistance(N0(v(jSONObject, "distance")));
        routeBusWalkItem.setDuration(R0(v(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                arrayList.add(a(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        E(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    public static DriveRouteResult T(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                driveRouteResult.setStartPos(S(optJSONObject, "origin"));
                driveRouteResult.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
                driveRouteResult.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i6 = 0;
                    while (i6 < optJSONArray.length()) {
                        DrivePath drivePath = new DrivePath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                        if (optJSONObject2 != null) {
                            drivePath.setDistance(N0(v(optJSONObject2, "distance")));
                            drivePath.setDuration(R0(v(optJSONObject2, "duration")));
                            drivePath.setStrategy(v(optJSONObject2, "strategy"));
                            drivePath.setTolls(N0(v(optJSONObject2, "tolls")));
                            drivePath.setTollDistance(N0(v(optJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(L0(v(optJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(L0(v(optJSONObject2, "restriction")));
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i7 = 0;
                                while (i7 < optJSONArray2.length()) {
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i7);
                                    if (optJSONObject3 != null) {
                                        jSONArray2 = optJSONArray;
                                        driveStep.setInstruction(v(optJSONObject3, "instruction"));
                                        driveStep.setOrientation(v(optJSONObject3, "orientation"));
                                        driveStep.setRoad(v(optJSONObject3, "road"));
                                        driveStep.setDistance(N0(v(optJSONObject3, "distance")));
                                        driveStep.setTolls(N0(v(optJSONObject3, "tolls")));
                                        driveStep.setTollDistance(N0(v(optJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(v(optJSONObject3, "toll_road"));
                                        driveStep.setDuration(N0(v(optJSONObject3, "duration")));
                                        driveStep.setPolyline(a0(optJSONObject3, "polyline"));
                                        driveStep.setAction(v(optJSONObject3, com.umeng.ccg.a.f41544t));
                                        driveStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                                        O(driveStep, optJSONObject3);
                                        D(driveStep, optJSONObject3);
                                        arrayList2.add(driveStep);
                                    } else {
                                        jSONArray2 = optJSONArray;
                                    }
                                    i7++;
                                    optJSONArray = jSONArray2;
                                }
                                jSONArray = optJSONArray;
                                drivePath.setSteps(arrayList2);
                                P(drivePath, arrayList2);
                                arrayList.add(drivePath);
                                i6++;
                                optJSONArray = jSONArray;
                            }
                        }
                        jSONArray = optJSONArray;
                        i6++;
                        optJSONArray = jSONArray;
                    }
                    driveRouteResult.setPaths(arrayList);
                    return driveRouteResult;
                }
            }
            return driveRouteResult;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            j4.i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RouteBusWalkItem T0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(S(jSONObject, "origin"));
        routeBusWalkItem.setDestination(S(jSONObject, RtspHeaders.Values.DESTINATION));
        routeBusWalkItem.setDistance(N0(v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusWalkItem.setDuration(R0(v(optJSONObject, "duration")));
        }
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
            if (optJSONObject2 != null) {
                arrayList.add(b(optJSONObject2));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        E(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    public static ArrayList<PoiItem> U(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(d0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static List<ChargeStationInfo> V(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(v(jSONObject, CommonNetImpl.NAME));
                chargeStationInfo.setPoiId(v(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(v(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(S(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(S(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(K(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(K(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(K(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(K(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(K(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(K(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(K(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<RouteBusLineItem> V0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("buslines")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(c(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static List<RouteBusLineItem> W0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("buslines")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(d(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static void X(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                aoiItem.setId(v(optJSONObject, "id"));
                aoiItem.setName(v(optJSONObject, CommonNetImpl.NAME));
                aoiItem.setAdcode(v(optJSONObject, "adcode"));
                aoiItem.setLocation(S(optJSONObject, SocializeConstants.KEY_LOCATION));
                aoiItem.setArea(Float.valueOf(N0(v(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static Doorway X0(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(v(jSONObject, CommonNetImpl.NAME));
        doorway.setLatLonPoint(S(jSONObject, SocializeConstants.KEY_LOCATION));
        return doorway;
    }

    public static DriveRouteResultV2 Y(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                driveRouteResultV2.setStartPos(S(optJSONObject, "origin"));
                driveRouteResultV2.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
                driveRouteResultV2.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                        if (optJSONObject2 != null) {
                            drivePathV2.setDistance(N0(v(optJSONObject2, "distance")));
                            drivePathV2.setStrategy(v(optJSONObject2, "strategy"));
                            drivePathV2.setRestriction(L0(v(optJSONObject2, "restriction")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                Cost cost = new Cost();
                                C(cost, optJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                            if (optJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(o(optJSONObject4));
                            }
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                            if (optJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(V(optJSONArray2));
                            }
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i7 = 0; i7 < optJSONArray3.length(); i7++) {
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i7);
                                    if (optJSONObject5 != null) {
                                        driveStepV2.setInstruction(v(optJSONObject5, "instruction"));
                                        driveStepV2.setOrientation(v(optJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(L0(v(optJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(v(optJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(a0(optJSONObject5, "polyline"));
                                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                        if (optJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            C(cost2, optJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                        if (optJSONObject7 != null) {
                                            driveStepV2.setNavi(p(optJSONObject7));
                                        }
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                        if (optJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(g0(optJSONArray4));
                                        }
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray5 != null) {
                                            driveStepV2.setTMCs(b0(optJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                }
                                drivePathV2.setSteps(arrayList2);
                                W(drivePathV2, arrayList2);
                                arrayList.add(drivePathV2);
                            }
                        }
                    }
                    driveRouteResultV2.setPaths(arrayList);
                    return driveRouteResultV2;
                }
            }
            return driveRouteResultV2;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            j4.i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<PoiItemV2> Z(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(h0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static WalkStep a(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(v(jSONObject, "instruction"));
        walkStep.setOrientation(v(jSONObject, "orientation"));
        walkStep.setRoad(v(jSONObject, "road"));
        walkStep.setDistance(N0(v(jSONObject, "distance")));
        walkStep.setDuration(N0(v(jSONObject, "duration")));
        walkStep.setPolyline(a0(jSONObject, "polyline"));
        walkStep.setAction(v(jSONObject, com.umeng.ccg.a.f41544t));
        walkStep.setAssistantAction(v(jSONObject, "assistant_action"));
        return walkStep;
    }

    private static WalkStep b(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(v(jSONObject, "instruction"));
        walkStep.setOrientation(v(jSONObject, "orientation"));
        walkStep.setRoad(v(jSONObject, "road"));
        walkStep.setDistance(N0(v(jSONObject, "distance")));
        walkStep.setDuration(N0(v(jSONObject, "duration")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            walkStep.setPolyline(a0(optJSONObject, "polyline"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("navi");
        if (optJSONObject2 != null) {
            walkStep.setAction(v(optJSONObject2, com.umeng.ccg.a.f41544t));
            walkStep.setAssistantAction(v(optJSONObject2, "assistant_action"));
            walkStep.setRoadType(L0(v(optJSONObject2, "walk_type")));
        }
        return walkStep;
    }

    private static List<TMC> b0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "tmc_distance")));
                    tmc.setStatus(v(optJSONObject, "tmc_status"));
                    tmc.setPolyline(a0(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e6) {
                j4.i(e6, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static RouteBusLineItem c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(v(jSONObject, CommonNetImpl.NAME));
        routeBusLineItem.setBusLineId(v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(v(jSONObject, "type"));
        routeBusLineItem.setDistance(N0(v(jSONObject, "distance")));
        routeBusLineItem.setDuration(N0(v(jSONObject, "duration")));
        routeBusLineItem.setPolyline(a0(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41197p)));
        routeBusLineItem.setLastBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41198q)));
        routeBusLineItem.setPassStationNum(L0(v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(e(jSONObject));
        return routeBusLineItem;
    }

    private static RouteBusLineItem d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(v(jSONObject, CommonNetImpl.NAME));
        routeBusLineItem.setBusLineId(v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(v(jSONObject, "type"));
        routeBusLineItem.setDistance(N0(v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusLineItem.setDuration(N0(v(optJSONObject, "duration")));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("polyline");
        if (optJSONObject2 != null) {
            routeBusLineItem.setPolyline(a0(optJSONObject2, "polyline"));
        }
        routeBusLineItem.setFirstBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41197p)));
        routeBusLineItem.setLastBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41198q)));
        routeBusLineItem.setPassStationNum(L0(v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(e(jSONObject));
        return routeBusLineItem;
    }

    public static PoiItem d0(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(v(jSONObject, "id"), S(jSONObject, SocializeConstants.KEY_LOCATION), v(jSONObject, CommonNetImpl.NAME), v(jSONObject, "address"));
        poiItem.setAdCode(v(jSONObject, "adcode"));
        poiItem.setProvinceName(v(jSONObject, "pname"));
        poiItem.setCityName(v(jSONObject, "cityname"));
        poiItem.setAdName(v(jSONObject, "adname"));
        poiItem.setCityCode(v(jSONObject, "citycode"));
        poiItem.setProvinceCode(v(jSONObject, "pcode"));
        poiItem.setDirection(v(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String v5 = v(jSONObject, "distance");
            if (!s0(v5)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(v5));
                } catch (NumberFormatException e6) {
                    j4.i(e6, "JSONHelper", "parseBasePoi");
                } catch (Exception e7) {
                    j4.i(e7, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(v(jSONObject, "tel"));
        poiItem.setTypeDes(v(jSONObject, "type"));
        poiItem.setEnter(S(jSONObject, "entr_location"));
        poiItem.setExit(S(jSONObject, "exit_location"));
        poiItem.setWebsite(v(jSONObject, "website"));
        poiItem.setPostcode(v(jSONObject, "postcode"));
        String v6 = v(jSONObject, "business_area");
        if (s0(v6)) {
            v6 = v(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(v6);
        poiItem.setEmail(v(jSONObject, "email"));
        if (K0(v(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(v(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        arrayList.add(x0(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(e0(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(q0(jSONObject, "biz_ext"));
        poiItem.setTypeCode(v(jSONObject, "typecode"));
        poiItem.setShopID(v(jSONObject, "shopid"));
        z(poiItem, jSONObject);
        return poiItem;
    }

    private static List<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("via_stops")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(f(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static BusStationItem f(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(v(jSONObject, CommonNetImpl.NAME));
        busStationItem.setBusStationId(v(jSONObject, "id"));
        busStationItem.setLatLonPoint(S(jSONObject, SocializeConstants.KEY_LOCATION));
        return busStationItem;
    }

    public static WalkRouteResult f0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(S(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(N0(v(optJSONObject2, "distance")));
                    walkPath.setDuration(R0(v(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i7);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(v(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(v(optJSONObject3, "orientation"));
                                    walkStep.setRoad(v(optJSONObject3, "road"));
                                    walkStep.setDistance(N0(v(optJSONObject3, "distance")));
                                    walkStep.setDuration(N0(v(optJSONObject3, "duration")));
                                    walkStep.setPolyline(a0(optJSONObject3, "polyline"));
                                    walkStep.setAction(v(optJSONObject3, com.umeng.ccg.a.f41544t));
                                    walkStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            E(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<RouteSearchCity> g0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, CommonNetImpl.NAME));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e6) {
                j4.i(e6, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static RailwayStationItem h(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(v(jSONObject, "id"));
        railwayStationItem.setName(v(jSONObject, CommonNetImpl.NAME));
        railwayStationItem.setLocation(S(jSONObject, SocializeConstants.KEY_LOCATION));
        railwayStationItem.setAdcode(v(jSONObject, "adcode"));
        railwayStationItem.setTime(v(jSONObject, "time"));
        railwayStationItem.setisStart(U0(v(jSONObject, "start")));
        railwayStationItem.setisEnd(U0(v(jSONObject, "end")));
        railwayStationItem.setWait(N0(v(jSONObject, "wait")));
        return railwayStationItem;
    }

    public static PoiItemV2 h0(JSONObject jSONObject) throws JSONException {
        PoiItemV2 poiItemV2 = new PoiItemV2(v(jSONObject, "id"), S(jSONObject, SocializeConstants.KEY_LOCATION), v(jSONObject, CommonNetImpl.NAME), v(jSONObject, "address"));
        poiItemV2.setTypeDes(v(jSONObject, "type"));
        poiItemV2.setTypeCode(v(jSONObject, "typecode"));
        poiItemV2.setProvinceName(v(jSONObject, "pname"));
        poiItemV2.setCityName(v(jSONObject, "cityname"));
        poiItemV2.setAdName(v(jSONObject, "adname"));
        poiItemV2.setProvinceCode(v(jSONObject, "pcode"));
        poiItemV2.setAdCode(v(jSONObject, "adcode"));
        poiItemV2.setCityCode(v(jSONObject, "citycode"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        arrayList.add(z0(optJSONObject));
                    }
                }
            }
            poiItemV2.setSubPois(arrayList);
        }
        poiItemV2.setBusiness(k0(jSONObject, "business"));
        poiItemV2.setIndoorData(i0(jSONObject, "indoor"));
        poiItemV2.setPoiNavi(n0(jSONObject, "navi"));
        A(poiItemV2, jSONObject);
        return poiItemV2;
    }

    private static List<RailwayStationItem> i(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("via_stops")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(h(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static List<Railway> j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("alters")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    Railway railway = new Railway();
                    railway.setID(v(optJSONObject, "id"));
                    railway.setName(v(optJSONObject, CommonNetImpl.NAME));
                    arrayList.add(railway);
                }
            }
        }
        return arrayList;
    }

    public static WalkRouteResultV2 j0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResultV2.setStartPos(S(optJSONObject, "origin"));
            walkRouteResultV2.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
            if (!optJSONObject.has("paths")) {
                return walkRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResultV2.setPaths(arrayList);
                return walkRouteResultV2;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(N0(v(optJSONObject2, "distance")));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                    if (optJSONObject3 != null) {
                        walkPath.setDuration(R0(v(optJSONObject3, "duration")));
                    }
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i7);
                                if (optJSONObject4 != null) {
                                    walkStep.setInstruction(v(optJSONObject4, "instruction"));
                                    walkStep.setOrientation(v(optJSONObject4, "orientation"));
                                    walkStep.setRoad(v(optJSONObject4, "road_name"));
                                    walkStep.setDistance(N0(v(optJSONObject4, "step_distance")));
                                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                    if (optJSONObject5 != null) {
                                        walkStep.setDuration(N0(v(optJSONObject5, "duration")));
                                    }
                                    JSONObject optJSONObject6 = optJSONObject4.optJSONObject("navi");
                                    if (optJSONObject6 != null) {
                                        walkStep.setAction(v(optJSONObject6, com.umeng.ccg.a.f41544t));
                                        walkStep.setAssistantAction(v(optJSONObject6, "assistant_action"));
                                        walkStep.setRoadType(L0(v(optJSONObject6, "work_type")));
                                    }
                                    walkStep.setPolyline(a0(optJSONObject4, "polyline"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            E(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResultV2.setPaths(arrayList);
            return walkRouteResultV2;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<RailwaySpace> k(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("spaces")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(l(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static RailwaySpace l(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(v(jSONObject, "code"), N0(v(jSONObject, "cost")));
    }

    public static LocalWeatherLive l0(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                localWeatherLive.setAdCode(v(optJSONObject, "adcode"));
                localWeatherLive.setProvince(v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                localWeatherLive.setCity(v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                localWeatherLive.setWeather(v(optJSONObject, "weather"));
                localWeatherLive.setTemperature(v(optJSONObject, "temperature"));
                localWeatherLive.setWindDirection(v(optJSONObject, "winddirection"));
                localWeatherLive.setWindPower(v(optJSONObject, "windpower"));
                localWeatherLive.setHumidity(v(optJSONObject, "humidity"));
                localWeatherLive.setReportTime(v(optJSONObject, "reporttime"));
            }
            return localWeatherLive;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static TaxiItem m(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(S(jSONObject, "origin"));
        taxiItem.setDestination(S(jSONObject, RtspHeaders.Values.DESTINATION));
        taxiItem.setDistance(N0(v(jSONObject, "distance")));
        taxiItem.setDuration(N0(v(jSONObject, "duration")));
        taxiItem.setSname(v(jSONObject, "sname"));
        taxiItem.setTname(v(jSONObject, "tname"));
        return taxiItem;
    }

    public static ArrayList<BusStationItem> m0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(B0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static TaxiItemV2 n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItemV2 taxiItemV2 = new TaxiItemV2();
        taxiItemV2.setOrigin(S(jSONObject, "startpoint"));
        taxiItemV2.setDestination(S(jSONObject, "endpoint"));
        taxiItemV2.setDistance(N0(v(jSONObject, "distance")));
        taxiItemV2.setDuration(N0(v(jSONObject, "drivetime")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            taxiItemV2.setPolyline(a0(optJSONObject, "polyline"));
        }
        taxiItemV2.setSname(v(jSONObject, "startname"));
        taxiItemV2.setTname(v(jSONObject, "endname"));
        return taxiItemV2;
    }

    private static ElecConsumeInfo o(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(S(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(K(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(K(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i6)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherForecast o0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    localWeatherForecast.setCity(v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherForecast.setAdCode(v(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherForecast.setReportTime(v(optJSONObject, "reporttime"));
                    if (optJSONObject.has("casts")) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                                if (optJSONObject2 != null) {
                                    localDayWeatherForecast.setDate(v(optJSONObject2, "date"));
                                    localDayWeatherForecast.setWeek(v(optJSONObject2, "week"));
                                    localDayWeatherForecast.setDayWeather(v(optJSONObject2, "dayweather"));
                                    localDayWeatherForecast.setNightWeather(v(optJSONObject2, "nightweather"));
                                    localDayWeatherForecast.setDayTemp(v(optJSONObject2, "daytemp"));
                                    localDayWeatherForecast.setNightTemp(v(optJSONObject2, "nighttemp"));
                                    localDayWeatherForecast.setDayWindDirection(v(optJSONObject2, "daywind"));
                                    localDayWeatherForecast.setNightWindDirection(v(optJSONObject2, "nightwind"));
                                    localDayWeatherForecast.setDayWindPower(v(optJSONObject2, "daypower"));
                                    localDayWeatherForecast.setNightWindPower(v(optJSONObject2, "nightpower"));
                                    arrayList.add(localDayWeatherForecast);
                                }
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                            return localWeatherForecast;
                        }
                        localWeatherForecast.setWeatherForecast(arrayList);
                    }
                }
            }
            return localWeatherForecast;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static Navi p(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(v(jSONObject, com.umeng.ccg.a.f41544t));
            navi.setAssistantAction(v(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<BusLineItem> p0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(H0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static List<Photo> q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("photos");
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                Photo photo = new Photo();
                photo.setTitle(v(optJSONObject, "title"));
                photo.setUrl(v(optJSONObject, "url"));
                arrayList.add(photo);
            }
        }
        return arrayList;
    }

    private static RoutePOIItem r(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(v(jSONObject, "id"));
        routePOIItem.setTitle(v(jSONObject, CommonNetImpl.NAME));
        routePOIItem.setPoint(S(jSONObject, SocializeConstants.KEY_LOCATION));
        routePOIItem.setDistance(N0(v(jSONObject, "distance")));
        routePOIItem.setDuration(N0(v(jSONObject, "duration")));
        routePOIItem.setCPID(v(jSONObject, "cpid"));
        return routePOIItem;
    }

    public static ArrayList<GeocodeAddress> r0(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(v(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    geocodeAddress.setCity(v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    geocodeAddress.setDistrict(v(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                    geocodeAddress.setTownship(v(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(v(optJSONObject.optJSONObject("neighborhood"), CommonNetImpl.NAME));
                    geocodeAddress.setBuilding(v(optJSONObject.optJSONObject("building"), CommonNetImpl.NAME));
                    geocodeAddress.setAdcode(v(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(S(optJSONObject, SocializeConstants.KEY_LOCATION));
                    geocodeAddress.setLevel(v(optJSONObject, "level"));
                    geocodeAddress.setCountry(v(optJSONObject, "country"));
                    geocodeAddress.setPostcode(v(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    private static RidePath s(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(N0(v(jSONObject, "distance")));
            ridePath.setDuration(R0(v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(v(optJSONObject, "instruction"));
                        rideStep.setOrientation(v(optJSONObject, "orientation"));
                        rideStep.setRoad(v(optJSONObject, "road"));
                        rideStep.setDistance(N0(v(optJSONObject, "distance")));
                        rideStep.setDuration(N0(v(optJSONObject, "duration")));
                        rideStep.setPolyline(a0(optJSONObject, "polyline"));
                        rideStep.setAction(v(optJSONObject, com.umeng.ccg.a.f41544t));
                        rideStep.setAssistantAction(v(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static boolean s0(String str) {
        return str == null || str.equals("");
    }

    private static RidePath t(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(N0(v(jSONObject, "distance")));
            ridePath.setDuration(R0(v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(v(optJSONObject, "instruction"));
                        rideStep.setOrientation(v(optJSONObject, "orientation"));
                        rideStep.setRoad(v(optJSONObject, "road_name"));
                        rideStep.setDistance(N0(v(optJSONObject, "step_distance")));
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                        if (optJSONObject2 != null) {
                            rideStep.setDuration(N0(v(optJSONObject2, "duration")));
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("navi");
                        if (optJSONObject3 != null) {
                            rideStep.setAction(v(optJSONObject3, com.umeng.ccg.a.f41544t));
                            rideStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                            rideStep.setRoadType(L0(v(optJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(a0(optJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseRidePathV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static RideRouteResult t0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(S(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    RidePath s5 = s(optJSONArray.optJSONObject(i6));
                    if (s5 != null) {
                        arrayList.add(s5);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath s6 = s(optJSONObject2.optJSONObject("path"));
                if (s6 != null) {
                    arrayList.add(s6);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static BusRouteResult u(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                busRouteResult.setStartPos(S(optJSONObject, "origin"));
                busRouteResult.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
                busRouteResult.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(y(optJSONArray));
                    return busRouteResult;
                }
            }
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<Tip> u0(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                Tip tip = new Tip();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    tip.setName(v(optJSONObject, CommonNetImpl.NAME));
                    tip.setDistrict(v(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                    tip.setAdcode(v(optJSONObject, "adcode"));
                    tip.setID(v(optJSONObject, "id"));
                    tip.setAddress(v(optJSONObject, "address"));
                    tip.setTypeCode(v(optJSONObject, "typecode"));
                    String v5 = v(optJSONObject, SocializeConstants.KEY_LOCATION);
                    if (!TextUtils.isEmpty(v5)) {
                        String[] split = v5.split(",");
                        if (split.length == 2) {
                            tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                        }
                    }
                    arrayList.add(tip);
                }
            }
        }
        return arrayList;
    }

    public static String v(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals("[]")) ? "" : jSONObject.optString(str).trim();
    }

    public static RideRouteResultV2 v0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            rideRouteResultV2.setStartPos(S(optJSONObject, "origin"));
            rideRouteResultV2.setTargetPos(S(optJSONObject, RtspHeaders.Values.DESTINATION));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    RidePath t5 = t(optJSONArray.optJSONObject(i6));
                    if (t5 != null) {
                        arrayList.add(t5);
                    }
                }
            }
            rideRouteResultV2.setPaths(arrayList);
            return rideRouteResultV2;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<SuggestionCity> w(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(v(optJSONObject, CommonNetImpl.NAME), v(optJSONObject, "citycode"), v(optJSONObject, "adcode"), L0(v(optJSONObject, "num"))));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> w0(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        arrayList.add(r(optJSONObject));
                    }
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(r(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> x(org.json.JSONObject r13, boolean r14) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            org.json.JSONArray r13 = r13.optJSONArray(r0)
            if (r13 == 0) goto L81
            int r0 = r13.length()
            if (r0 != 0) goto L10
            goto L81
        L10:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r13.length()
            r2 = 0
            r3 = 0
        L1b:
            if (r3 >= r1) goto L80
            org.json.JSONObject r4 = r13.optJSONObject(r3)
            java.lang.String r5 = "userid"
            java.lang.String r5 = v(r4, r5)
            java.lang.String r6 = "location"
            java.lang.String r6 = v(r4, r6)
            if (r6 == 0) goto L47
            java.lang.String r7 = ","
            java.lang.String[] r6 = r6.split(r7)
            int r7 = r6.length
            r8 = 2
            if (r7 != r8) goto L47
            r7 = r6[r2]
            double r7 = P0(r7)
            r9 = 1
            r6 = r6[r9]
            double r9 = P0(r6)
            goto L4a
        L47:
            r7 = 0
            r9 = r7
        L4a:
            java.lang.String r6 = "distance"
            java.lang.String r6 = v(r4, r6)
            java.lang.String r11 = "updatetime"
            java.lang.String r4 = v(r4, r11)
            long r11 = R0(r4)
            int r4 = L0(r6)
            com.amap.api.services.core.LatLonPoint r6 = new com.amap.api.services.core.LatLonPoint
            r6.<init>(r9, r7)
            com.amap.api.services.nearby.NearbyInfo r7 = new com.amap.api.services.nearby.NearbyInfo
            r7.<init>()
            r7.setUserID(r5)
            r7.setTimeStamp(r11)
            r7.setPoint(r6)
            if (r14 == 0) goto L77
            r7.setDrivingDistance(r4)
            goto L7a
        L77:
            r7.setDistance(r4)
        L7a:
            r0.add(r7)
            int r3 = r3 + 1
            goto L1b
        L80:
            return r0
        L81:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r4.x(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    private static SubPoiItem x0(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(v(jSONObject, "id"), S(jSONObject, SocializeConstants.KEY_LOCATION), v(jSONObject, CommonNetImpl.NAME), v(jSONObject, "address"));
        subPoiItem.setSubName(v(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(v(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String v5 = v(jSONObject, "distance");
            if (!s0(v5)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(v5));
                    return subPoiItem;
                } catch (NumberFormatException e6) {
                    j4.i(e6, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e7) {
                    j4.i(e7, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    private static List<BusPath> y(JSONArray jSONArray) throws JSONException {
        BusStep O0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                BusPath busPath = new BusPath();
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    busPath.setCost(N0(v(optJSONObject, "cost")));
                    busPath.setDuration(R0(v(optJSONObject, "duration")));
                    busPath.setNightBus(U0(v(optJSONObject, "nightflag")));
                    busPath.setWalkDistance(N0(v(optJSONObject, "walking_distance")));
                    busPath.setDistance(N0(v(optJSONObject, "distance")));
                    JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                    if (optJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i7);
                            if (optJSONObject2 != null && (O0 = O0(optJSONObject2)) != null) {
                                arrayList2.add(O0);
                                if (O0.getWalk() != null) {
                                    f7 += O0.getWalk().getDistance();
                                }
                                if (O0.getBusLines() != null && O0.getBusLines().size() > 0) {
                                    f6 += O0.getBusLines().get(0).getDistance();
                                }
                            }
                        }
                        busPath.setSteps(arrayList2);
                        busPath.setBusDistance(f6);
                        busPath.setWalkDistance(f7);
                        arrayList.add(busPath);
                    }
                }
            }
        }
        return arrayList;
    }

    public static DistanceResult y0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                distanceItem.setOriginId(L0(v(jSONObject2, "origin_id")));
                distanceItem.setDestId(L0(v(jSONObject2, "dest_id")));
                distanceItem.setDistance(N0(v(jSONObject2, "distance")));
                distanceItem.setDuration(N0(v(jSONObject2, "duration")));
                String v5 = v(jSONObject2, "info");
                if (!TextUtils.isEmpty(v5)) {
                    distanceItem.setErrorInfo(v5);
                    distanceItem.setErrorCode(L0(v(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e6) {
            j4.i(e6, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void z(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> q5 = q(jSONObject.optJSONObject("deep_info"));
        if (q5.size() == 0) {
            q5 = q(jSONObject);
        }
        poiItem.setPhotos(q5);
    }

    private static SubPoiItemV2 z0(JSONObject jSONObject) throws JSONException {
        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(v(jSONObject, "id"), S(jSONObject, SocializeConstants.KEY_LOCATION), v(jSONObject, CommonNetImpl.NAME), v(jSONObject, "address"));
        subPoiItemV2.setSubTypeDes(v(jSONObject, "subtype"));
        subPoiItemV2.setTypeCode(v(jSONObject, "typecode"));
        return subPoiItemV2;
    }

    private static void A(PoiItemV2 poiItemV2, JSONObject jSONObject) throws JSONException {
        poiItemV2.setPhotos(q(jSONObject));
    }

    private static void B(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && E0(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static BusStationItem B0(JSONObject jSONObject) throws JSONException {
        BusStationItem D0 = D0(jSONObject);
        D0.setAdCode(v(jSONObject, "adcode"));
        D0.setCityCode(v(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            D0.setBusLineItems(arrayList);
            return D0;
        }
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                arrayList.add(F0(optJSONObject));
            }
        }
        D0.setBusLineItems(arrayList);
        return D0;
    }

    private static void E(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static BusLineItem H0(JSONObject jSONObject) throws JSONException {
        BusLineItem F0 = F0(jSONObject);
        F0.setFirstBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41197p)));
        F0.setLastBusTime(j4.n(v(jSONObject, com.umeng.analytics.pro.d.f41198q)));
        F0.setBusCompany(v(jSONObject, "company"));
        F0.setDistance(N0(v(jSONObject, "distance")));
        F0.setBasicPrice(N0(v(jSONObject, "basic_price")));
        F0.setTotalPrice(N0(v(jSONObject, "total_price")));
        F0.setBounds(a0(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            F0.setBusStations(arrayList);
            return F0;
        }
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                arrayList.add(D0(optJSONObject));
            }
        }
        F0.setBusStations(arrayList);
        return F0;
    }

    private static void P(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void W(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static ArrayList<LatLonPoint> a0(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return G0(jSONObject.optString(str));
        }
        return null;
    }

    private static void c0(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static IndoorData e0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        int i6;
        String str3;
        JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str2 = v(optJSONObject, "cpid");
            i6 = L0(v(optJSONObject, "floor"));
            str3 = v(optJSONObject, "truefloor");
        } else {
            str2 = "";
            i6 = 0;
            str3 = "";
        }
        return new IndoorData(str2, i6, str3);
    }

    private static IndoorDataV2 i0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        int i6;
        JSONObject optJSONObject;
        boolean z5 = false;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            if (L0(v(optJSONObject, "indoor_map")) == 1) {
                z5 = true;
            }
            str2 = v(optJSONObject, "cpid");
            i6 = L0(v(optJSONObject, "floor"));
            str3 = v(optJSONObject, "truefloor");
        } else {
            str2 = "";
            str3 = "";
            i6 = 0;
        }
        return new IndoorDataV2(z5, str2, i6, str3);
    }

    private static Business k0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            String v5 = v(optJSONObject, "business_area");
            String v6 = v(optJSONObject, "opentime_today");
            String v7 = v(optJSONObject, "opentime_week");
            String v8 = v(optJSONObject, "tel");
            String v9 = v(optJSONObject, CommonNetImpl.TAG);
            String v10 = v(optJSONObject, "rating");
            String v11 = v(optJSONObject, "cost");
            String v12 = v(optJSONObject, "parking_type");
            String v13 = v(optJSONObject, "alias");
            str2 = v(optJSONObject, "cpid");
            str10 = v12;
            str11 = v13;
            str8 = v10;
            str9 = v11;
            str6 = v8;
            str7 = v9;
            str4 = v6;
            str5 = v7;
            str3 = v5;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
            str11 = str10;
        }
        Business business = new Business(str3, str4, str5, str6, str7, str8, str9, str10, str11);
        business.setCPID(str2);
        return business;
    }

    private static PoiNavi n0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        LatLonPoint latLonPoint;
        String str3;
        LatLonPoint latLonPoint2;
        JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            str2 = v(optJSONObject, "navi_poiid");
            latLonPoint = S(optJSONObject, "entr_location");
            latLonPoint2 = S(optJSONObject, "exit_location");
            str3 = v(optJSONObject, "gridcode");
        } else {
            str2 = "";
            latLonPoint = null;
            str3 = "";
            latLonPoint2 = null;
        }
        return new PoiNavi(str2, latLonPoint, latLonPoint2, str3);
    }

    private static PoiItemExtension q0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            str2 = v(optJSONObject, "open_time");
            str3 = v(optJSONObject, "rating");
        } else {
            str2 = "";
            str3 = "";
        }
        return new PoiItemExtension(str2, str3);
    }
}
