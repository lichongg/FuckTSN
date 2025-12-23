package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i6, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    void onMapBlandClick(double d6, double d7);

    void onMapPOIClick(MapPoi mapPoi);

    void onMapRender(int i6, int i7);

    void reloadMapResource(int i6, String str, int i7);

    byte[] requireCharBitmap(int i6, int i7, int i8);

    byte[] requireCharsWidths(int i6, int[] iArr, int i7, int i8);

    void requireMapRender(int i6, int i7, int i8);

    byte[] requireMapResource(int i6, String str);
}
