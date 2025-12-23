package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class MapConfig implements IMapConfig, Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_MAINTHREAD_TRIGGER = 30;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private String customTextureResourcePath;
    private boolean isSetLimitZoomLevel;
    MapConfig lastMapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;

    @JBindingInclude
    private int mapHeight;

    @JBindingInclude
    private float mapPerPixelUnitLength;

    @JBindingInclude
    private int mapWidth;
    private float skyHeight;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    private FPoint[] mapRect = null;

    @JBindingInclude
    private Rectangle geoRectangle = new Rectangle();
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isCustomStyleEnabled = false;

    @JBindingInclude
    private double sX = 2.21010267E8d;

    @JBindingInclude
    private double sY = 1.01697799E8d;
    private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);

    @JBindingInclude
    private float sZ = 10.0f;

    @JBindingInclude
    private float sC = 0.0f;

    @JBindingInclude
    private float sR = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private int mMapStyleMode = 0;
    private int mMapStyleTime = 0;
    private int anchorX = 0;
    private String mMapLanguage = "zh_cn";
    private boolean isHideLogoEnable = false;
    private boolean isWorldMapEnable = false;
    private boolean isTouchPoiEnable = true;
    private int abroadState = 1;
    private boolean isAbroadEnable = false;
    private boolean isTerrainEnable = false;

    @JBindingInclude
    float[] viewMatrix = new float[16];

    @JBindingInclude
    float[] projectionMatrix = new float[16];

    @JBindingInclude
    float[] mvpMatrix = new float[16];

    @JBindingInclude
    private int[] tilsIDs = new int[100];
    private boolean mapEnable = true;
    private int anchorY = 0;
    private boolean isProFunctionAuthEnable = true;
    private boolean isUseProFunction = false;
    private int customBackgroundColor = -1;
    private float mapZoomScale = 1.0f;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int gridX = 0;
    private int gridY = 0;

    private void changeRatio() {
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sX - sx) + Math.abs(this.sY - sy);
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.sZ ? 1.0d : Math.abs(sz - r11));
        float f6 = this.sC;
        float abs = sc == f6 ? 1.0f : Math.abs(sc - f6);
        float f7 = this.sR;
        float abs2 = sr != f7 ? Math.abs(sr - f7) : 1.0f;
        double d6 = abs;
        this.changeRatio *= d6;
        double d7 = abs2;
        this.changeRatio *= d7;
        this.changeGridRatio = Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        this.changeGridRatio = this.changeGridRatio != 0.0d ? this.changeGridRatio * 2.0d : 1.0d;
        this.changeGridRatio *= d6;
        this.changeGridRatio *= d7;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    protected int getGridX() {
        return this.gridX;
    }

    protected int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig == null) {
            return false;
        }
        double sx = mapConfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        double d6 = this.sX;
        boolean z5 = true;
        boolean z6 = sx != d6;
        this.isCenterChanged = z6;
        double d7 = this.sY;
        if (sy != d7) {
            z6 = true;
        }
        this.isCenterChanged = z6;
        float f6 = this.sZ;
        boolean z7 = sz != f6;
        this.isZoomChanged = z7;
        if (z7) {
            float f7 = this.minZoomLevel;
            if (sz > f7 && f6 > f7) {
                float f8 = this.maxZoomLevel;
                if (sz < f8 && f6 < f8) {
                    this.isNeedUpdateZoomControllerState = false;
                }
            }
            this.isNeedUpdateZoomControllerState = true;
        }
        boolean z8 = sc != this.sC;
        this.isTiltChanged = z8;
        boolean z9 = sr != this.sR;
        this.isBearingChanged = z9;
        if (!z6 && !z7 && !z8 && !z9 && !this.isNeedUpdateMapRectNextFrame) {
            z5 = false;
        }
        if (z5) {
            this.isNeedUpdateMapRectNextFrame = false;
            int i6 = 28 - ((int) f6);
            setGridXY(((int) d6) >> i6, ((int) d7) >> i6);
            changeRatio();
        }
        return z5;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean z5) {
        this.isAbroadEnable = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i6) {
        this.abroadState = i6;
    }

    public void setAnchorX(int i6) {
        this.anchorX = i6;
    }

    public void setAnchorY(int i6) {
        this.anchorY = i6;
    }

    public void setBuildingEnable(boolean z5) {
        this.isBuildingEnable = z5;
    }

    public void setCustomBackgroundColor(int i6) {
        this.customBackgroundColor = i6;
    }

    public void setCustomStyleEnable(boolean z5) {
        this.isCustomStyleEnabled = z5;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    protected void setGridXY(int i6, int i7) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i6;
        this.gridY = i7;
    }

    public void setHideLogoEnble(boolean z5) {
        this.isHideLogoEnable = z5;
    }

    public void setIndoorEnable(boolean z5) {
        this.isIndoorEnable = z5;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z5) {
        this.mapEnable = z5;
    }

    public void setMapHeight(int i6) {
        this.mapHeight = i6;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i6) {
        this.mMapStyleMode = i6;
    }

    public void setMapStyleTime(int i6) {
        this.mMapStyleTime = i6;
    }

    public void setMapTextEnable(boolean z5) {
        this.isMapTextEnable = z5;
    }

    public void setMapWidth(int i6) {
        this.mapWidth = i6;
    }

    public void setMapZoomScale(float f6) {
        this.mapZoomScale = f6;
    }

    public void setMaxZoomLevel(float f6) {
        if (f6 > 20.0f) {
            f6 = 20.0f;
        }
        if (f6 < 3.0f) {
            f6 = 3.0f;
        }
        if (f6 < getMinZoomLevel()) {
            f6 = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f6;
    }

    public void setMinZoomLevel(float f6) {
        if (f6 < 3.0f) {
            f6 = 3.0f;
        }
        if (f6 > 20.0f) {
            f6 = 20.0f;
        }
        if (f6 > getMaxZoomLevel()) {
            f6 = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f6;
    }

    public void setProFunctionAuthEnable(boolean z5) {
        this.isProFunctionAuthEnable = z5;
    }

    public void setSC(float f6) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f6;
    }

    public void setSR(float f6) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f6;
    }

    public void setSX(double d6) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d6;
        this.mapGeoCenter.f9903x = d6;
    }

    public void setSY(double d6) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d6;
        this.mapGeoCenter.f9903x = d6;
    }

    public void setSZ(float f6) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f6;
    }

    public void setSkyHeight(float f6) {
        this.skyHeight = f6;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z5) {
        this.isTerrainEnable = z5;
    }

    public void setTouchPoiEnable(boolean z5) {
        this.isTouchPoiEnable = z5;
    }

    public void setTrafficEnabled(boolean z5) {
        this.isTrafficEnabled = z5;
    }

    public void setUseProFunction(boolean z5) {
        this.isUseProFunction = z5;
    }

    public void setWorldMapEnable(boolean z5) {
        this.isWorldMapEnable = z5;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z5) {
        this.isNeedUpdateMapRectNextFrame = z5;
    }

    public MapConfig(boolean z5) {
        this.lastMapconfig = null;
        if (z5) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0.0d);
            this.lastMapconfig.setSY(0.0d);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }
}
