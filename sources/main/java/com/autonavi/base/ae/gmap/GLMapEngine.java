package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.l3;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.z2;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback {
    private Context context;
    private int mEngineID;
    private IAMapDelegate mGlMapView;
    private IAMapListener mMapListener;
    boolean mRequestDestroy;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private long mNativeMapengineInstance = 0;
    private final List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
    private final List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
    private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
    boolean isMoveCameraStep = false;
    boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private GLMapState copyGLMapState = null;
    private Lock mLock = new ReentrantLock();
    private Object mutLock = new Object();
    private NetworkState mNetworkState = null;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    boolean isNetworkConnected = false;
    private AtomicInteger mRequestID = new AtomicInteger(1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class InitParam {
        public String mRootPath = "";
        public String mConfigPath = "";
        public String mConfigContent = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mIntersectionResPath = "";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f10280x;

        /* renamed from: y, reason: collision with root package name */
        public int f10281y;
    }

    public static native void nativeAddGestureSingleTapMessage(int i6, long j6, float f6, float f7);

    protected static native String nativeAddNativeOverlay(int i6, long j6, int i7, int i8);

    private static native boolean nativeAddOverlayTexture(int i6, long j6, int i7, int i8, float f6, float f7, Bitmap bitmap, boolean z5, boolean z6);

    private static native void nativeCancelDownLoad(long j6);

    private static native boolean nativeCheckCustomStyleData(int i6, long j6, byte[] bArr);

    private static native void nativeCreateAMapEngineWithFrame(long j6, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f6, float f7, float f8, int i13);

    private static native long nativeCreateAMapInstance(float f6, float f7, float f8, int i6);

    protected static native long nativeCreateOverlay(int i6, long j6, int i7);

    private static native int nativeCreateTextureFromImage(int i6, long j6, Bitmap bitmap);

    private static native void nativeDestroy(long j6);

    private static native void nativeDestroyCurrentState(long j6, long j7);

    protected static native void nativeDestroyOverlay(int i6, long j6);

    private static native void nativeFailedDownLoad(long j6, int i6);

    private static native void nativeFinishDownLoad(long j6);

    private static native void nativeGetCurTileIDs(int i6, long j6, int[] iArr, int i7);

    private static native long nativeGetCurrentMapState(int i6, long j6);

    private static native long nativeGetGlOverlayMgrPtr(int i6, long j6);

    public static native String nativeGetMapEngineVersion(int i6);

    private static native int[] nativeGetMapModeState(int i6, long j6, boolean z5);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i6, long j6);

    public static native int[] nativeGetScreenShot(int i6, long j6, int i7, int i8, int i9, int i10);

    private static native boolean nativeGetSrvViewStateBoolValue(int i6, long j6, int i7);

    public static native int nativeHideBuildings(int i6, long j6, LatLng[] latLngArr);

    private static native void nativeInitAMapEngineCallback(long j6, Object obj);

    private static native void nativeInitContourLineOptions(long j6, boolean z5);

    private static native void nativeInitOpenLayer(int i6, long j6, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4, String str5, String str6, int i6);

    private static native boolean nativeIsEngineCreated(long j6, int i6);

    public static native void nativeMainThreadTrigger(int i6, long j6);

    private static native void nativePopRenderState(int i6, long j6);

    private static native void nativePostRenderAMap(long j6, int i6);

    private static native void nativePushRendererState(int i6, long j6);

    private static native void nativeReceiveNetData(byte[] bArr, long j6, int i6);

    protected static native void nativeRemoveNativeAllOverlay(int i6, long j6);

    protected static native void nativeRemoveNativeOverlay(int i6, long j6, String str);

    private static native void nativeRenderAMap(long j6, int i6);

    private static native void nativeSetAllContentEnable(int i6, long j6, boolean z5);

    private static native void nativeSetBuildingEnable(int i6, long j6, boolean z5);

    private static native void nativeSetBuildingTextureEnable(int i6, long j6, boolean z5);

    private static native void nativeSetCustomStyleData(int i6, long j6, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i6, long j6, byte[] bArr);

    private static native void nativeSetCustomThirdLayerStyle(int i6, long j6, String str);

    private static native void nativeSetHighlightSubwayEnable(int i6, long j6, boolean z5);

    private static native void nativeSetIndoorBuildingToBeActive(int i6, long j6, String str, int i7, String str2);

    private static native void nativeSetIndoorEnable(int i6, long j6, boolean z5);

    private static native void nativeSetLabelEnable(int i6, long j6, boolean z5);

    private static native boolean nativeSetMapModeAndStyle(int i6, long j6, int[] iArr);

    private static native void nativeSetNaviLabelEnable(int i6, long j6, boolean z5, int i7, int i8);

    private static native void nativeSetNetStatus(long j6, int i6);

    private static native void nativeSetOfflineDataEnable(int i6, long j6, boolean z5);

    private static native void nativeSetOpenLayerEnable(int i6, long j6, boolean z5);

    private static native void nativeSetParameter(int i6, long j6, int i7, int i8, int i9, int i10, int i11);

    private static native void nativeSetProjectionCenter(int i6, long j6, float f6, float f7);

    private static native void nativeSetRenderListenerStatus(int i6, long j6);

    private static native void nativeSetRoadArrowEnable(int i6, long j6, boolean z5);

    private static native void nativeSetServiceViewRect(int i6, long j6, int i7, int i8, int i9, int i10, int i11, int i12);

    private static native void nativeSetSetBackgroundTexture(int i6, long j6, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i6, long j6, boolean z5);

    private static native void nativeSetSkyTexture(int i6, long j6, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i6, long j6, int i7, boolean z5);

    private static native void nativeSetStyleChangeGradualEnable(int i6, long j6, boolean z5);

    public static native void nativeSetTerrainAuth(int i6, long j6, boolean z5);

    private static native void nativeSetTrafficEnable(int i6, long j6, boolean z5);

    private static native void nativeSetTrafficTexture(int i6, long j6, byte[] bArr, long j7, int i7, int i8, int i9, int i10, int i11);

    private static native void nativeSetTrafficTextureAllInOne(int i6, long j6, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i6, long j6, String str);

    public static native void nativeShowHideBuildings(int i6, long j6, int i7);

    protected static native void nativeUpdateNativeArrowOverlay(int i6, long j6, String str, int[] iArr, int[] iArr2, int i7, int i8, int i9, float f6, boolean z5, int i10, int i11, int i12);

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        r1.setCameraDegree(com.amap.api.col.p0003l.b3.i(r6.mGlMapView.getMapConfig(), r1.getCameraDegree(), r1.getMapZoomer()));
        setMapState(r6.mEngineID, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processMessage() {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.mEngineID     // Catch: java.lang.Exception -> L21
            com.autonavi.amap.api.mapcore.IGLMapState r1 = r6.getNewMapState(r1)     // Catch: java.lang.Exception -> L21
            com.autonavi.base.ae.gmap.GLMapState r1 = (com.autonavi.base.ae.gmap.GLMapState) r1     // Catch: java.lang.Exception -> L21
            boolean r2 = r6.processGestureMessage(r1)     // Catch: java.lang.Exception -> L21
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r6.mGestureMessageList     // Catch: java.lang.Exception -> L21
            int r3 = r3.size()     // Catch: java.lang.Exception -> L21
            r4 = 1
            if (r3 > 0) goto L25
            if (r2 != 0) goto L23
            boolean r2 = r6.processStateMapMessage(r1)     // Catch: java.lang.Exception -> L21
            if (r2 == 0) goto L1f
            goto L23
        L1f:
            r2 = 0
            goto L39
        L21:
            r1 = move-exception
            goto L65
        L23:
            r2 = 1
            goto L39
        L25:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r3 = r6.mStateMessageList     // Catch: java.lang.Exception -> L21
            monitor-enter(r3)     // Catch: java.lang.Exception -> L21
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L36
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L36
            if (r5 <= 0) goto L38
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L36
            r5.clear()     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r1 = move-exception
            goto L63
        L38:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
        L39:
            if (r2 != 0) goto L43
            boolean r2 = r6.processAnimations(r1)     // Catch: java.lang.Exception -> L21
            if (r2 == 0) goto L42
            goto L43
        L42:
            r4 = 0
        L43:
            if (r4 == 0) goto L5f
            float r2 = r1.getCameraDegree()     // Catch: java.lang.Exception -> L21
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r6.mGlMapView     // Catch: java.lang.Exception -> L21
            com.autonavi.base.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch: java.lang.Exception -> L21
            float r5 = r1.getMapZoomer()     // Catch: java.lang.Exception -> L21
            float r2 = com.amap.api.col.p0003l.b3.i(r3, r2, r5)     // Catch: java.lang.Exception -> L21
            r1.setCameraDegree(r2)     // Catch: java.lang.Exception -> L21
            int r2 = r6.mEngineID     // Catch: java.lang.Exception -> L21
            r6.setMapState(r2, r1)     // Catch: java.lang.Exception -> L21
        L5f:
            r1.recycle()     // Catch: java.lang.Exception -> L21
            return r4
        L63:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r1     // Catch: java.lang.Exception -> L21
        L65:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    public void addOverlayTexture(int i6, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i6, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public boolean checkCustomStyleData(int i6, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return false;
        }
        return nativeCheckCustomStyleData(i6, j6, bArr);
    }

    public void clearAnimations(int i6, boolean z5) {
        this.mapAnimationMgr.clearAnimations();
    }

    public boolean createAMapInstance(InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            try {
                DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                int i6 = displayMetrics.densityDpi;
                float f6 = displayMetrics.density;
                float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i6);
                this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
                boolean isTerrainEnable = MapsInitializer.isTerrainEnable();
                nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath, "http://mpsapi.amap.com/", "http://m5.amap.com/", i6);
                InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
                long nativeCreateAMapInstance = nativeCreateAMapInstance(i6, f6, adapterDpiScale, isTerrainEnable ? 1 : 0);
                this.mNativeMapengineInstance = nativeCreateAMapInstance;
                if (nativeCreateAMapInstance == 0) {
                    return false;
                }
                if (MapsInitializer.isTerrainEnable()) {
                    nativeInitContourLineOptions(this.mNativeMapengineInstance, MapsInitializer.isContourLineEnable());
                }
                nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
                if (!NetworkProxyManager.getInstance().isReady()) {
                    NetworkProxyManager.getInstance().initContext(this.context);
                    NetworkProxyManager.getInstance().init();
                }
                NetworkProxyManager.getInstance().notifyMapEngineCreated(this.mEngineID, this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            synchronized (this.mutLock) {
                try {
                    if (this.mNativeMapengineInstance != 0) {
                        this.mLock.lock();
                        try {
                            GLMapState gLMapState = this.copyGLMapState;
                            if (gLMapState != null) {
                                gLMapState.recycle();
                            }
                            this.mLock.unlock();
                            nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                            nativeDestroy(this.mNativeMapengineInstance);
                        } catch (Throwable th) {
                            this.mLock.unlock();
                            throw th;
                        }
                    }
                    this.mNativeMapengineInstance = 0L;
                    NetworkProxyManager.getInstance().notifyMapEngineDestroyed(this.mEngineID);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            z2.c();
        } catch (Throwable th3) {
            th3.printStackTrace();
            b3.D(th3);
        }
    }

    public boolean getIsProcessBuildingMark(int i6) {
        return false;
    }

    public boolean isInMapAction(int i6) {
        return false;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapRender(int i6, int i7) {
        try {
            if (i7 == 5) {
                IAMapListener iAMapListener = this.mMapListener;
                if (iAMapListener != null) {
                    iAMapListener.beforeDrawLabel(i6, getMapState(i6));
                    return;
                }
                return;
            }
            if (i7 == 6) {
                IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.afterDrawLabel(i6, getMapState(i6));
                    return;
                }
                return;
            }
            if (i7 != 7) {
                if (i7 != 13) {
                    return;
                }
                this.isEngineRenderComplete = true;
            } else {
                IAMapListener iAMapListener3 = this.mMapListener;
                if (iAMapListener3 != null) {
                    iAMapListener3.afterRendererOver(i6, getMapState(i6));
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireMapResource(int i6, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String concat = "map_assets/".concat(str);
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    bArr = this.mGlMapView.getCustomStyleManager().i(str);
                    if (bArr != null) {
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, concat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = b3.S(bArr, customBackgroundColor);
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, concat);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    public void setMapState(int i6, GLMapState gLMapState) {
        setMapState(i6, gLMapState, true);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:12|(2:13|14)|16|17|(2:18|19)|(4:24|(1:26)|27|(1:31)(2:29|30))(1:23)) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0051, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0058, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004f, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0055, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float adapterDpiScale(android.util.DisplayMetrics r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.Class<android.util.DisplayMetrics> r0 = android.util.DisplayMetrics.class
            java.lang.String r1 = getEMUI()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L89
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L89
            java.lang.String r3 = "EmotionUI_8"
            int r3 = r1.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L21
            java.lang.String r3 = "EmotionUI_9"
            int r1 = r1.indexOf(r3)
            if (r1 == r4) goto L89
        L21:
            if (r11 <= 0) goto L89
            r1 = 1
            r3 = 0
            java.lang.String r4 = "noncompatWidthPixels"
            java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            r4.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            int r4 = r4.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            goto L3f
        L33:
            r4 = move-exception
            goto L37
        L35:
            r4 = move-exception
            goto L3b
        L37:
            r4.printStackTrace()
            goto L3e
        L3b:
            r4.printStackTrace()
        L3e:
            r4 = 0
        L3f:
            java.lang.String r5 = "noncompatHeightPixels"
            java.lang.reflect.Field r5 = r0.getDeclaredField(r5)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            r5.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            int r5 = r5.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            goto L59
        L4d:
            r5 = move-exception
            goto L51
        L4f:
            r5 = move-exception
            goto L55
        L51:
            r5.printStackTrace()
            goto L58
        L55:
            r5.printStackTrace()
        L58:
            r5 = 0
        L59:
            java.lang.String r6 = "noncompatDensityDpi"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            r0.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            int r3 = r0.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            goto L72
        L67:
            r8 = move-exception
            goto L6b
        L69:
            r8 = move-exception
            goto L6f
        L6b:
            r8.printStackTrace()
            goto L72
        L6f:
            r8.printStackTrace()
        L72:
            if (r3 > r11) goto L78
            if (r4 > r9) goto L78
            if (r5 <= r10) goto L89
        L78:
            float r8 = (float) r3
            float r9 = (float) r11
            float r8 = r8 / r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L83
            r8 = 1073741824(0x40000000, float:2.0)
        L83:
            int r9 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r9 >= 0) goto L88
            goto L89
        L88:
            r2 = r8
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.adapterDpiScale(android.util.DisplayMetrics, int, int, int):float");
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onCancel();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onFinish();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i6 = this.mapGestureCount - 1;
        this.mapGestureCount = i6;
        if (i6 == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            try {
                remove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (remove != null) {
            remove.generateMapAnimation(this);
        }
    }

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r3.width != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r3.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r3.height != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r3.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r2 = r3.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r2 != 100) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r2 != 101) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        r3.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r2 != 102) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r0 = r5.mGestureMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L10
            boolean r6 = r5.isGestureStep
            if (r6 == 0) goto Lf
            r5.isGestureStep = r1
        Lf:
            return r1
        L10:
            r0 = 1
            r5.isGestureStep = r0
            if (r6 != 0) goto L16
            return r1
        L16:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureMessageList
            monitor-enter(r2)
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L2a
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L2a
            if (r3 <= 0) goto L2c
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r3 = r3.remove(r1)     // Catch: java.lang.Throwable -> L2a
            com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage r3 = (com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage) r3     // Catch: java.lang.Throwable -> L2a
            goto L2d
        L2a:
            r6 = move-exception
            goto L76
        L2c:
            r3 = 0
        L2d:
            if (r3 != 0) goto L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r6 = r5.mGestureEndMessageList
            int r6 = r6.size()
            if (r6 <= 0) goto L3b
            r5.recycleMessage()
        L3b:
            return r0
        L3c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            int r2 = r3.width
            if (r2 != 0) goto L49
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r2 = r5.mGlMapView
            int r2 = r2.getMapWidth()
            r3.width = r2
        L49:
            int r2 = r3.height
            if (r2 != 0) goto L55
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r2 = r5.mGlMapView
            int r2 = r2.getMapHeight()
            r3.height = r2
        L55:
            int r2 = r3.getMapGestureState()
            r4 = 100
            if (r2 != r4) goto L61
            r5.gestureBegin()
            goto L70
        L61:
            r4 = 101(0x65, float:1.42E-43)
            if (r2 != r4) goto L69
            r3.runCameraUpdate(r6)
            goto L70
        L69:
            r4 = 102(0x66, float:1.43E-43)
            if (r2 != r4) goto L70
            r5.gestureEnd()
        L70:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureEndMessageList
            r2.add(r3)
            goto L16
        L76:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processGestureMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                try {
                    remove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                    if (remove == null) {
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void OnIndoorBuildingActivity(int i6, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i6, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i6, AbstractGestureMapMessage abstractGestureMapMessage, boolean z5, int i7, int i8) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z5;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGestureSingleTapMessage(float f6, float f7) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, f6, f7);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i6, int i7, float f6, int i8, int i9, int i10, int i11, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i7);
        adglMapAnimGroup.setToCameraDegree(i9, 0);
        adglMapAnimGroup.setToMapAngle(i8, 0);
        adglMapAnimGroup.setToMapLevel(f6, 0);
        adglMapAnimGroup.setToMapCenterGeo(i10, i11, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z5) {
        if (!z5) {
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.add(abstractCameraUpdateMessage);
            }
        } else {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
        }
    }

    public String addNativeOverlay(int i6, int i7, int i8) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i6, j6, i7, i8);
        if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public boolean canStopMapRender(int i6) {
        return this.isEngineRenderComplete;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void cancelRequireMapData(Object obj) {
        if (obj == null || !(obj instanceof AMapLoader)) {
            return;
        }
        ((AMapLoader) obj).doCancel();
    }

    public void clearAnimations(int i6, boolean z5, int i7) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.f10280x, mapViewInitParam.f10281y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, FileUtil.uncompressToByteArray(FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public long createOverlay(int i6, int i7) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return nativeCreateOverlay(i6, j6, i7);
        }
        return 0L;
    }

    public int createOverlayTexture(int i6, Bitmap bitmap) {
        if (this.mNativeMapengineInstance == 0 || bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return nativeCreateTextureFromImage(i6, this.mNativeMapengineInstance, bitmap);
    }

    public void destroyOverlay(int i6, long j6) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i6, j6);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(this.mEngineID, j6);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i6, int[] iArr) {
        if (iArr != null) {
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr[i7] = 0;
            }
            nativeGetCurTileIDs(i6, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i6) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i6) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return nativeGetGlOverlayMgrPtr(i6, j6);
        }
        return 0L;
    }

    public int[] getMapModeState(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return null;
        }
        nativeGetMapModeState(i6, j6, z5);
        return null;
    }

    public GLMapState getMapState(int i6) {
        this.mLock.lock();
        try {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i6, j6);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(i6, this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i6) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i6) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return nativeGetNativeMapController(i6, j6);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i6) {
        this.mLock.lock();
        try {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0) {
                return new GLMapState(i6, j6);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i6) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i6, int i7, int i8, int i9, int i10) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return b3.p(nativeGetScreenShot(i6, j6, i7, i8, i9, i10), i9 - i7, i10 - i8, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i6, int i7) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return nativeGetSrvViewStateBoolValue(i6, j6, i7);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            try {
                if (this.mStateMessageList.size() == 0) {
                    return null;
                }
                return this.mStateMessageList.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public int hideBuildings(List<LatLng> list) {
        if (this.mNativeMapengineInstance == 0) {
            return -1;
        }
        LatLng[] latLngArr = new LatLng[list.size()];
        list.toArray(latLngArr);
        return nativeHideBuildings(this.mEngineID, this.mNativeMapengineInstance, latLngArr);
    }

    public void initMapOpenLayer(String str) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j6, str.getBytes());
    }

    public void initNativeTexture(int i6) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap2 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            Bitmap bitmap3 = fromAsset3 != null ? fromAsset3.getBitmap() : null;
            addOverlayTexture(i6, bitmap, 111, 4);
            addOverlayTexture(i6, bitmap2, 222, 4);
            addOverlayTexture(i6, bitmap3, 333, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (Throwable th) {
                v5.p(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i6) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            return nativeIsEngineCreated(j6, i6);
        }
        return false;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.onAMapAppResourceRequest(aMapAppRequestParam);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapBlandClick(double d6, double d7) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapBlankClick(d6, d7);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapPOIClick(MapPoi mapPoi) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapPOIClick(mapPoi);
        }
    }

    public void popRendererState() {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativePopRenderState(this.mEngineID, j6);
        }
    }

    public void pushRendererState() {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativePushRendererState(this.mEngineID, j6);
        }
    }

    public void removeNativeAllOverlay(int i6) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeRemoveNativeAllOverlay(i6, j6);
        }
    }

    public void removeNativeOverlay(int i6, String str) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i6, j6, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharBitmap(int i6, int i7, int i8) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i7, i8);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharsWidths(int i6, int[] iArr, int i7, int i8) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    public void setAllContentEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            if (z5) {
                nativeSetAllContentEnable(i6, j6, true);
            } else {
                nativeSetAllContentEnable(i6, j6, false);
            }
            setSimple3DEnable(i6, false);
        }
    }

    public void setBackgroundTexture(int i6, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetSetBackgroundTexture(i6, j6, bArr);
        }
    }

    public void setBuildingEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetBuildingEnable(i6, j6, z5);
        }
    }

    public void setBuildingTextureEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetBuildingTextureEnable(i6, j6, z5);
        }
    }

    public void setCustomStyleData(int i6, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetCustomStyleData(i6, j6, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i6, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetCustomStyleTexture(i6, j6, bArr);
        }
    }

    public void setHighlightSubwayEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetHighlightSubwayEnable(i6, j6, z5);
        }
    }

    public void setIndoorEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetIndoorEnable(i6, j6, z5);
        }
    }

    public void setLabelEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetLabelEnable(i6, j6, z5);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public boolean setMapModeAndStyle(int i6, int i7, int i8, boolean z5, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i6, i7, i8);
        if (styleItemArr != null && z5) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                setBackgroundTexture(i6, b3.S(FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i6, FileUtil.readFileContents(customTextureResourcePath));
                return nativeMapModeAndStyle;
            }
        } else if (i7 == 0 && i8 == 0) {
            Context context = this.context;
            StringBuilder sb = new StringBuilder(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            String str = File.separator;
            sb.append(str);
            sb.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i6, FileUtil.readFileContentsFromAssets(context, sb.toString()));
            setCustomStyleTexture(i6, FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j6, z5);
        }
    }

    public void setMapState(int i6, GLMapState gLMapState, boolean z5) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z5 && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i6, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public boolean setNativeMapModeAndStyle(int i6, int i7, int i8) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i6, j6, new int[]{i7, i8});
    }

    public void setNaviLabelEnable(int i6, boolean z5, int i7, int i8) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetNaviLabelEnable(i6, j6, z5, i7, i8);
        }
    }

    public void setNetStatus(boolean z5) {
        if (this.mRequestDestroy) {
            return;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetNetStatus(j6, z5 ? 1 : 0);
    }

    public void setOfflineDataEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetOfflineDataEnable(i6, j6, z5);
        }
    }

    public void setOvelayBundle(int i6, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mLock.lock();
        try {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0) {
                nativeSetParameter(i6, j6, i7, i8, i9, i10, i11);
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setProjectionCenter(int i6, int i7, int i8) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetProjectionCenter(i6, j6, i7, i8);
        }
    }

    public void setRoadArrowEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetRoadArrowEnable(i6, j6, z5);
        }
    }

    public void setServiceViewRect(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        nativeSetServiceViewRect(i6, this.mNativeMapengineInstance, i7, i8, i9, i10, i11, i12);
    }

    public void setSimple3DEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetSimple3DEnable(i6, j6, z5);
        }
    }

    public void setSkyTexture(int i6, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetSkyTexture(i6, j6, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i6, int i7, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetSrvViewStateBoolValue(i6, j6, i7, z5);
        }
    }

    public void setStyleChangeGradualEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetStyleChangeGradualEnable(i6, j6, z5);
        }
    }

    public void setTerrainAuth(boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetTerrainAuth(this.mEngineID, j6, z5);
    }

    public void setTrafficEnable(int i6, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 != 0) {
            nativeSetTrafficEnable(i6, j6, z5);
        }
    }

    public void setTrafficStyleWithTexture(int i6, byte[] bArr, MyTrafficStyle myTrafficStyle) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0 || myTrafficStyle == null) {
            return;
        }
        nativeSetTrafficTexture(i6, j6, bArr, bArr.length, myTrafficStyle.getExtremelySmoothColor(), myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
    }

    public void setTrafficStyleWithTextureData(int i6, byte[] bArr) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i6, j6, bArr);
    }

    public void setVectorOverlayPath(String str) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j6, str);
    }

    public void showHideBuildings(int i6) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0) {
            return;
        }
        nativeShowHideBuildings(this.mEngineID, j6, i6);
    }

    public void startMapSlidAnim(int i6, Point point, float f6, float f7) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i6, true);
            GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float abs = Math.abs(f6);
            float abs2 = Math.abs(f7);
            if ((abs > abs2 ? abs : abs2) > 12000.0f) {
                if (abs > abs2) {
                    f6 = f6 > 0.0f ? 12000.0f : -12000.0f;
                    f7 = (12000.0f / abs) * f7;
                } else {
                    float f8 = (12000.0f / abs2) * f6;
                    if (f7 > 0.0f) {
                        f6 = f8;
                        f7 = 12000.0f;
                    } else {
                        f6 = f8;
                        f7 = -12000.0f;
                    }
                }
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                AdglMapAnimFlingP20 adglMapAnimFlingP20 = new AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f6, f7);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f6, f7);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void triggerMainThread() {
        nativeMainThreadTrigger(this.mEngineID, this.mNativeMapengineInstance);
    }

    public void updateNativeArrowOverlay(int i6, String str, int[] iArr, int[] iArr2, int i7, int i8, int i9, float f6, int i10, int i11, int i12, boolean z5) {
        long j6 = this.mNativeMapengineInstance;
        if (j6 == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i6, j6, str, iArr, iArr2, i7, i8, i9, f6, z5, i10, i11, i12);
    }

    public GLMapEngine(Context context, IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.3
            @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
            public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
            }
        });
        this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        this.mEngineID = GLEngineIDController.getController().generate();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    public boolean isInMapAnimation(int i6) {
        if (getAnimateionsCount() > 0) {
            return true;
        }
        return false;
    }

    public void setCustomThirdLayerStyle(int i6, String str) {
        if (!TextUtils.isEmpty(str)) {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0) {
                nativeSetCustomThirdLayerStyle(this.mEngineID, j6, str);
            }
        }
    }

    public void setIndoorBuildingToBeActive(int i6, String str, int i7, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long j6 = this.mNativeMapengineInstance;
            if (j6 != 0) {
                nativeSetIndoorBuildingToBeActive(i6, j6, str, i7, str2);
            }
        }
    }

    public void addOverlayTexture(int i6, Bitmap bitmap, int i7, int i8) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i7;
        gLTextureProperty.mAnchor = i8;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i6, gLTextureProperty);
    }

    public void clearAllMessages(int i6) {
    }

    public void onClearCache(int i6) {
    }

    public void changeSurface(int i6, int i7) {
    }

    public void putResourceData(int i6, byte[] bArr) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i6, String str, int i7) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i6, int i7, int i8) {
    }

    public void startPivotZoomRotateAnim(int i6, Point point, float f6, int i7, int i8) {
    }
}
