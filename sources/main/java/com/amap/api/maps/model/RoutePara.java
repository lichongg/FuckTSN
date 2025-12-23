package com.amap.api.maps.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePara {
    private String endName;
    private LatLng endPoint;
    private String startName;
    private LatLng startPoint;
    private int drivingRouteStyle = 0;
    private int transitRouteStyle = 0;

    public int getDrivingRouteStyle() {
        return this.drivingRouteStyle;
    }

    public String getEndName() {
        return this.endName;
    }

    public LatLng getEndPoint() {
        return this.endPoint;
    }

    public String getStartName() {
        return this.startName;
    }

    public LatLng getStartPoint() {
        return this.startPoint;
    }

    public int getTransitRouteStyle() {
        return this.transitRouteStyle;
    }

    public void setDrivingRouteStyle(int i6) {
        if (i6 < 0 || i6 >= 9) {
            return;
        }
        this.drivingRouteStyle = i6;
    }

    public void setEndName(String str) {
        this.endName = str;
    }

    public void setEndPoint(LatLng latLng) {
        this.endPoint = latLng;
    }

    public void setStartName(String str) {
        this.startName = str;
    }

    public void setStartPoint(LatLng latLng) {
        this.startPoint = latLng;
    }

    public void setTransitRouteStyle(int i6) {
        if (i6 < 0 || i6 >= 6) {
            return;
        }
        this.transitRouteStyle = i6;
    }
}
