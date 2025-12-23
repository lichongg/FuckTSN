package com.kwad.components.core.o.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.webview.tachikoma.g;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j implements IOfflineHostApi {
    private IAsync RR;
    private IEnvironment RS;
    private IZipper RT;
    private INet RU;
    private IEncrypt RV;
    private IOfflineCompoLogcat RW;
    private ICrash RX;
    private ILoggerReporter RY;
    private IDownloader RZ;
    private IImageLoader Sa;
    private IVideo Sb;
    private ILive Sc;
    private ICache Sd;
    private IWebView Se;
    private IVibratorUtil Sf;
    private IIdc Sg;
    private IImagePlayer Sh;
    private ILifeCycle Si;
    private INetworkManager Sj;
    private ISystemProperties Sk;
    private IFlowUuid Sl;
    private ISensorManagerProxy Sm;
    private m Sn;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    /* renamed from: qF, reason: merged with bridge method [inline-methods] */
    public m deviceManager() {
        if (this.Sn == null) {
            this.Sn = new m();
        }
        return this.Sn;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.RR == null) {
            this.RR = new a();
        }
        return this.RR;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IBundleService bundleService() {
        return new IBundleService() { // from class: com.kwad.components.core.o.b.a.j.4
            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundle(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.uP().b(context, str, new g.b() { // from class: com.kwad.components.core.o.b.a.j.4.1
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundleWithString(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.uP().a(context, str, new g.b() { // from class: com.kwad.components.core.o.b.a.j.4.2
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void unloadBundle(String str) {
                com.kwad.components.core.webview.tachikoma.g.uP().unloadBundle(str);
            }
        };
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.Sd == null) {
            this.Sd = new b();
        }
        return this.Sd;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.RX == null) {
            this.RX = new ICrash() { // from class: com.kwad.components.core.o.b.a.j.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.d.gatherException(th);
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addCustomKeyValue(final ICrashCustomKeyValue iCrashCustomKeyValue) {
                    com.kwad.sdk.service.d.b(new com.kwad.sdk.service.a.c() { // from class: com.kwad.components.core.o.b.a.j.1.1
                        @Override // com.kwad.sdk.service.a.c
                        public final String getKey() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getKey();
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.service.a.c
                        public final JSONObject getValue() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getValue();
                            }
                            return null;
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addOnCrashListener(final ICrashOccurListener iCrashOccurListener) {
                    com.kwad.sdk.service.d.a(new com.kwad.sdk.service.a.g() { // from class: com.kwad.components.core.o.b.a.j.1.2
                        @Override // com.kwad.sdk.service.a.g
                        public final void l(int i6, String str) {
                            ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                            if (iCrashOccurListener2 != null) {
                                iCrashOccurListener2.onCrashOccur(i6, str);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
                    com.kwad.sdk.service.d.H(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
                }
            };
        }
        return this.RX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.RZ == null) {
            this.RZ = new IDownloader() { // from class: com.kwad.components.core.o.b.a.j.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.d(str, file);
                }
            };
        }
        return this.RZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.RV == null) {
            this.RV = new c();
        }
        return this.RV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.RS == null) {
            this.RS = new d();
        }
        return this.RS;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFlowUuid flowUuid() {
        if (this.Sl == null) {
            this.Sl = new e();
        }
        return this.Sl;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.Sg == null) {
            this.Sg = new n();
        }
        return this.Sg;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.Sa == null) {
            this.Sa = new f();
        }
        return this.Sa;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImagePlayer imagePlayer() {
        com.kwad.components.core.h.d dVar = new com.kwad.components.core.h.d();
        this.Sh = dVar;
        return dVar;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILifeCycle lifeCycle() {
        if (this.Si == null) {
            this.Si = new g();
        }
        return this.Si;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.Sc == null) {
            this.Sc = new com.kwad.components.core.o.b.b.a();
        }
        return this.Sc;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.RW == null) {
            this.RW = new k();
        }
        return this.RW;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.RY == null) {
            this.RY = new ILoggerReporter() { // from class: com.kwad.components.core.o.b.a.j.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(com.kwad.sdk.commercial.c cVar) {
                    com.kwad.sdk.commercial.b.d(cVar);
                }
            };
        }
        return this.RY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.RU == null) {
            this.RU = new h();
        }
        return this.RU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INetworkManager networkManager() {
        if (this.Sj == null) {
            this.Sj = new i();
        }
        return this.Sj;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISensorManagerProxy sensorManager() {
        if (this.Sm == null) {
            this.Sm = new p();
        }
        return this.Sm;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISystemProperties systemProperty() {
        if (this.Sk == null) {
            this.Sk = new o();
        }
        return this.Sk;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.Sf == null) {
            this.Sf = new q();
        }
        return this.Sf;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.Sb == null) {
            this.Sb = new com.kwad.components.core.o.b.c.e();
        }
        return this.Sb;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.Se == null) {
            this.Se = new com.kwad.components.core.o.b.d.b();
        }
        return this.Se;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.RT == null) {
            this.RT = new r();
        }
        return this.RT;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean canUseStorage() {
        if (!bc.useStoragePermissionDisable()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getAppIconId(Context context) {
        return ba.getAppIconId(context);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getDrawableId(Context context, String str) {
        return ba.aw(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getId(Context context, String str) {
        return ba.getId(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final PackageInfo getPackageInfo(Context context, String str, int i6) {
        return y.getPackageInfo(context, str, i6);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final long getSystemTimeInMs(Context context, boolean z5) {
        return bt.x(context, z5);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getTKErrorDetailCount() {
        return com.kwad.sdk.core.config.e.getTKErrorDetailCount();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final List<String> getTKPreloadMemCacheTemplates() {
        return com.kwad.sdk.core.config.e.getTKPreloadMemCacheTemplates();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final String getWaynePlayerPlayConfig() {
        return com.kwad.sdk.core.config.e.Gq();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean isOrientationPortrait() {
        return aq.isOrientationPortrait();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void saveTKTemplateCache(String str, int i6, String str2) {
        com.kwad.components.core.webview.tachikoma.h.uS().b(str, i6, str2);
    }
}
