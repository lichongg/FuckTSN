package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.d;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.r6;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isContourLineEnable = false;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    public static String sdcardDir = "";

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "10.0.600";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            d.f5883f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static boolean isContourLineEnable() {
        return isContourLineEnable;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldVectorMap(boolean z5) {
        isloadWorldVectorMap = z5;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        g4.l(d.f5883f, str);
    }

    public static void setContourLIneEnable(boolean z5) {
        isContourLineEnable = z5;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z5) {
        isNeedDownloadCoordinateConvertLibrary = z5;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setNetWorkEnable(boolean z5) {
        isNetWorkEnable = z5;
    }

    public static void setProtocol(int i6) {
        mProtocol = i6;
    }

    public static void setSupportRecycleView(boolean z5) {
        isSupportRecycleView = z5;
    }

    public static void setTerrainEnable(boolean z5) {
        isTerrainEnable = z5;
    }

    public static void setTextureDestroyedRender(boolean z5) {
        isTextureDestroyedRender = z5;
    }

    public static void setTextureSizeChangedInvoked(boolean z5) {
        isTextureSizeChangedInvoked = z5;
    }

    public static void setTextureViewDestorySync(boolean z5) {
        isTextureViewDestorySync = z5;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z5) {
        synchronized (MapsInitializer.class) {
            ft.i(context, z5, b3.s());
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        synchronized (MapsInitializer.class) {
            ft.j(context, z5, z6, b3.s());
        }
    }

    public static String getDeviceId(Context context) {
        return i4.a0(context);
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            r6.f7183a = -1;
            r6.f7184b = "";
        } else {
            r6.f7183a = 1;
            r6.f7184b = str;
        }
    }

    public static void disableCachedMapDataUpdate(boolean z5) {
    }

    public static void setBuildingHeight(int i6) {
    }

    public static void setPolyline2Enable(boolean z5) {
    }
}
