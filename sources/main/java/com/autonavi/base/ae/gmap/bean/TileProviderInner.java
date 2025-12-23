package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.z2;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class TileProviderInner {

    @JBindingExclude
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;

    @JBindingInclude
    private List<TileOverlaySource> mTileSource;

    @JBindingExclude
    private String overlayName;

    @JBindingExclude
    private final HashMap<String, b8> reqTaskHandleHashMap = new HashMap<>();

    @JBindingExclude
    private final TileProvider tileProvider;

    /* JADX INFO: Access modifiers changed from: private */
    @JBindingExclude
    public Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @JBindingExclude
    private String createKey(int i6, int i7, int i8, long j6) {
        return i6 + " " + i7 + " " + i8 + "-" + j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(final Tile tile, final TileReqTaskHandle tileReqTaskHandle, final String str) {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.getMap().queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z5;
                synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                    try {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                            if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                                TileProviderInner.this.reqTaskHandleHashMap.remove(str);
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                tileReqTaskHandle.finish(tile);
                                TileProviderInner.this.callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @JBindingInclude
    public void cancelTile(TileSourceReq tileSourceReq, TileReqTaskHandle tileReqTaskHandle) {
        String createKey = createKey(tileSourceReq.f10283x, tileSourceReq.f10284y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            try {
                if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                    b8 b8Var = this.reqTaskHandleHashMap.get(createKey);
                    if (b8Var != null) {
                        z2.a();
                        z2.d(b8Var);
                    }
                    tileReqTaskHandle.status = 1;
                    finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    try {
                        TileProvider tileProvider = this.tileProvider;
                        if (tileProvider instanceof TileSourceProvider) {
                            ((TileSourceProvider) tileProvider).cancel(tileSourceReq);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JBindingInclude
    public void getTile(final TileSourceReq tileSourceReq, final TileReqTaskHandle tileReqTaskHandle) {
        final String createKey = createKey(tileSourceReq.f10283x, tileSourceReq.f10284y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        b8 b8Var = new b8() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.1
            @Override // com.amap.api.col.p0003l.b8
            public void runTask() {
                try {
                    synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                        try {
                            if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(createKey)) {
                                if (TileProviderInner.this.tileProvider != null) {
                                    Tile tile = TileProvider.NO_TILE;
                                    try {
                                        if (TileProviderInner.this.tileProvider instanceof TileSourceProvider) {
                                            tile = ((TileSourceProvider) TileProviderInner.this.tileProvider).getTile(tileSourceReq);
                                        } else {
                                            TileProvider tileProvider = TileProviderInner.this.tileProvider;
                                            TileSourceReq tileSourceReq2 = tileSourceReq;
                                            tile = tileProvider.getTile(tileSourceReq2.f10283x, tileSourceReq2.f10284y, tileSourceReq2.zoom);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    TileProviderInner.this.finishDownload(tile, tileReqTaskHandle, createKey);
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    TileProviderInner.this.finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    th.printStackTrace();
                }
            }
        };
        synchronized (this.reqTaskHandleHashMap) {
            try {
                if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                    return;
                }
                this.reqTaskHandleHashMap.put(createKey, b8Var);
                z2.a().b(b8Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JBindingInclude
    public int getTileHeight() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @JBindingInclude
    public int getTileWidth() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @JBindingExclude
    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }

    @JBindingExclude
    public TileProviderInner(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }
}
