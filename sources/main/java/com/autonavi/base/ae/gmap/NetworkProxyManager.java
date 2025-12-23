package com.autonavi.base.ae.gmap;

import android.content.Context;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.z2;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class NetworkProxyManager {
    private static NetworkProxyManager sInstance;
    private Context context;
    private NetworkProxy networkProxy;
    private NetworkState networkState;
    private String userAgent;
    private boolean isNetworkConnected = false;
    private Map<Long, AMapLoader> aMapLoaderHashtable = new ConcurrentHashMap();
    private Map<Long, GLMapEngine> engines = new ConcurrentHashMap();
    private NetworkState.NetworkChangeListener networkChangeListener = new NetworkState.NetworkChangeListener() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.1
        @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
        public void networkStateChanged(Context context) {
            NetworkProxyManager.this.isNetworkConnected = NetworkState.isNetworkConnected(context);
            Iterator it = NetworkProxyManager.this.engines.entrySet().iterator();
            while (it.hasNext()) {
                ((GLMapEngine) ((Map.Entry) it.next()).getValue()).setNetStatus(NetworkProxyManager.this.isNetworkConnected);
            }
        }
    };

    private synchronized void cancelAllAMapDownload() {
        try {
            Iterator it = new ConcurrentHashMap(this.aMapLoaderHashtable).entrySet().iterator();
            while (it.hasNext()) {
                ((AMapLoader) ((Map.Entry) it.next()).getValue()).doCancelAndNotify();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static native void nativeCancelDownLoad(long j6);

    private static native long nativeCreateNetworkProxy(Object obj);

    private static native void nativeDestroyNetworkProxy(long j6);

    private static native void nativeFailedDownLoad(long j6, int i6);

    private static native void nativeFinishDownLoad(long j6);

    private static native void nativeInitNetworkProxy(long j6);

    private static native void nativeReceiveNetData(byte[] bArr, long j6, int i6);

    public synchronized void finishDownLoad(long j6) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j6))) {
            nativeFinishDownLoad(j6);
            this.aMapLoaderHashtable.remove(Long.valueOf(j6));
        }
    }

    public synchronized void netCancel(long j6, int i6) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j6))) {
            nativeFailedDownLoad(j6, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j6));
        }
    }

    public synchronized void netError(long j6, int i6, int i7) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j6))) {
            nativeFailedDownLoad(j6, i7);
            this.aMapLoaderHashtable.remove(Long.valueOf(j6));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i6, i7);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(long j6, int i6) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j6))) {
            nativeFailedDownLoad(j6, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j6));
        }
    }

    public synchronized void receiveNetData(long j6, byte[] bArr, int i6) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j6))) {
            nativeReceiveNetData(bArr, j6, i6);
        }
    }

    @JBindingInclude
    public synchronized int requireMapDataAsyn(int i6, byte[] bArr) {
        if (bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i7 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i7);
            int i8 = GLConvertUtil.getInt(bArr, i7 + 4);
            int i9 = i7 + 8;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i9, i8);
            int i10 = i9 + i8;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i10);
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i10 + 8);
            int i11 = GLConvertUtil.getInt(bArr, i10 + 12);
            int i12 = i10 + 16;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i12, i11);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i12 + i11);
            final AMapLoader aMapLoader = new AMapLoader(this.context, aDataRequestParam);
            this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            try {
                z2.a().b(new b8() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.2
                    @Override // com.amap.api.col.p0003l.b8
                    public void runTask() {
                        try {
                            aMapLoader.doRequest();
                        } catch (Throwable th) {
                            v5.p(th, "download Thread", "AMapLoader doRequest");
                            b3.D(th);
                        }
                    }
                });
            } catch (Throwable th) {
                v5.p(th, "download Thread", "requireMapData");
                b3.D(th);
            }
        }
        return 0;
    }

    public static NetworkProxyManager getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkProxyManager();
        }
        return sInstance;
    }

    private void initNetworkState() {
        this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(this.context);
        NetworkState networkState = new NetworkState();
        this.networkState = networkState;
        networkState.setNetworkListener(this.networkChangeListener);
        this.networkState.registerNetChangeReceiver(StubApp.getOrigApplicationContext(this.context.getApplicationContext()), true);
        this.isNetworkConnected = NetworkState.isNetworkConnected(StubApp.getOrigApplicationContext(this.context.getApplicationContext()));
    }

    private void releaseNetworkState() {
        NetworkState networkState = this.networkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(StubApp.getOrigApplicationContext(this.context.getApplicationContext()), false);
            this.networkState.setNetworkListener(null);
            this.networkState = null;
        }
    }

    public void destroy() {
        NetworkProxy networkProxy = this.networkProxy;
        if (networkProxy != null) {
            destroyNetworkProxy(networkProxy);
            this.networkProxy = null;
        }
        releaseNetworkState();
        this.context = null;
    }

    public void destroyNetworkProxy(NetworkProxy networkProxy) {
        nativeDestroyNetworkProxy(networkProxy.networkProxyInstance);
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initContext(Context context) {
        if (context == null) {
            return;
        }
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void initNetworkProxy(NetworkProxy networkProxy) {
        nativeInitNetworkProxy(networkProxy.networkProxyInstance);
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public boolean isReady() {
        return (this.context == null || this.networkProxy == null || this.networkState == null) ? false : true;
    }

    public void notifyMapEngineCreated(long j6, GLMapEngine gLMapEngine) {
        this.engines.put(Long.valueOf(j6), gLMapEngine);
    }

    public void notifyMapEngineDestroyed(long j6) {
        this.engines.remove(Long.valueOf(j6));
        cancelAllAMapDownload();
    }

    private NetworkProxyManager() {
    }

    public NetworkProxy createNetworkProxy() {
        return new NetworkProxy(nativeCreateNetworkProxy(this));
    }

    public void init() {
        NetworkProxy createNetworkProxy = createNetworkProxy();
        this.networkProxy = createNetworkProxy;
        initNetworkProxy(createNetworkProxy);
        initNetworkState();
    }
}
