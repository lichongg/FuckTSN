package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i6 = 0;
        for (int i7 = 0; i7 < this.buildingLatlngs.size(); i7++) {
            LatLng latLng = this.buildingLatlngs.get(i7);
            if (latLng != null) {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i8 = i6 + 1;
                iArr[i6] = latLongToPixels.x;
                i6 += 2;
                iArr[i8] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                LatLng latLng = list.get(i7);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i8 = i6 + 1;
                iArr[i6] = latLongToPixels.x;
                i6 += 2;
                iArr[i8] = latLongToPixels.y;
            }
        }
        return this;
    }

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i6) {
        this.buildingHeight = i6;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i6) {
        this.buildingHeightScale = i6;
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i6) {
        this.buildingSideColor = i6;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i6) {
        this.buildingTopColor = i6;
        return this;
    }

    public void setVisible(boolean z5) {
        this.isVisible = z5;
    }

    public void setZIndex(float f6) {
        this.zindex = f6;
    }
}
