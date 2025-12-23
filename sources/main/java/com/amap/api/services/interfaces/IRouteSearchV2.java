package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IRouteSearchV2 {
    BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException;

    void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery);

    DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery);

    RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException;

    void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery);

    WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException;

    void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery);

    void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener);
}
