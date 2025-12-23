package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> Fm;
    private List<String> Fn;
    private volatile SharedPreferences Fo;
    private final Object mLock;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public int materialType;
        public String preloadId;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final SplashPreloadManager Fp = new SplashPreloadManager(0);
    }

    /* synthetic */ SplashPreloadManager(byte b6) {
        this();
    }

    @AnyThread
    public static boolean i(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public final void a(long j6, int i6) {
        int i7;
        int i8;
        int i9;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        int size2 = this.Fn.size();
        synchronized (this.mLock) {
            try {
                ArrayList<String> arrayList = new ArrayList();
                i8 = 0;
                i9 = 0;
                for (String str : this.Fm.keySet()) {
                    PreLoadItem preLoadItem = this.Fm.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                        int i10 = preLoadItem.materialType;
                        if (i10 == 2) {
                            i8++;
                        } else if (i10 == 1) {
                            i9++;
                        }
                    }
                }
                SharedPreferences.Editor edit = this.Fo.edit();
                for (String str2 : arrayList) {
                    this.Fn.remove(str2);
                    this.Fm.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.b.a.GP().remove(str2);
                }
                edit.apply();
                size = this.Fn.size();
            } finally {
            }
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i11 = size - 15;
            for (i7 = 0; i7 < i11; i7++) {
                String str3 = "";
                synchronized (this.mLock) {
                    try {
                        long j7 = Long.MAX_VALUE;
                        for (PreLoadItem preLoadItem2 : this.Fm.values()) {
                            long j8 = j7;
                            long j9 = preLoadItem2.expiredTime;
                            if (j9 < j8) {
                                str3 = preLoadItem2.preloadId;
                                j7 = j9;
                            } else {
                                j7 = j8;
                            }
                        }
                        long j10 = j7;
                        if (!TextUtils.isEmpty(str3)) {
                            PreLoadItem preLoadItem3 = this.Fm.get(str3);
                            if (preLoadItem3 != null) {
                                int i12 = preLoadItem3.materialType;
                                if (i12 == 2) {
                                    i8++;
                                } else {
                                    if (i12 == 1) {
                                        i9++;
                                    }
                                    this.Fn.remove(str3);
                                    this.Fm.remove(str3);
                                    this.Fo.edit().remove(str3).apply();
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j10);
                                }
                            }
                            this.Fn.remove(str3);
                            this.Fm.remove(str3);
                            this.Fo.edit().remove(str3).apply();
                            com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j10);
                        }
                    } finally {
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.GP().remove(str3);
                }
            }
        }
        int i13 = i8;
        List<String> lE = lE();
        int size3 = size2 - lE.size();
        List<Integer> i14 = i(lE);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(j6, lE, i14, i6, size3, i9, i13);
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Fm = new HashMap<>();
        this.Fn = new ArrayList();
        init();
    }

    public static File aa(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
        if (cf == null || !cf.exists()) {
            return null;
        }
        return cf;
    }

    private void initData() {
        Map<String, ?> all = this.Fo.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(preLoadItem.preloadId);
                            if (cf == null || !cf.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    try {
                                        this.Fm.put(str, preLoadItem);
                                        if (!this.Fn.contains(str)) {
                                            this.Fn.add(str);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        SharedPreferences.Editor edit = this.Fo.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        preLoadItem.materialType = com.kwad.sdk.core.response.b.a.bc(adInfo) ? 2 : 1;
        synchronized (this.mLock) {
            try {
                this.Fm.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.Fn.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.Fn.add(adInfo.adPreloadInfo.preloadId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.Fo != null) {
            SharedPreferences.Editor edit = this.Fo.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    public final List<String> S() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
                for (int i6 = 0; i6 < this.Fn.size(); i6++) {
                    String str = this.Fn.get(i6);
                    File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
                    if (cf != null && cf.exists()) {
                        arrayList.add(str);
                    }
                }
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
            } catch (Throwable th) {
                throw th;
            }
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.Fn.size());
        return arrayList;
    }

    public final List<String> lE() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean start ");
            arrayList = new ArrayList(this.Fn);
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean " + this.Fn.size());
        return arrayList;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Fo = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    @AnyThread
    public static boolean j(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static SplashPreloadManager lD() {
        SplashPreloadManager splashPreloadManager = a.Fp;
        if (splashPreloadManager.Fo == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        Object valueOf;
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            if (cf == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(cf.exists());
            }
            sb.append(valueOf);
            com.kwad.sdk.core.d.c.d("PreloadManager", sb.toString());
            if (cf != null && cf.exists()) {
                return true;
            }
        }
        return false;
    }

    @AnyThread
    public final boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    public final List<Integer> i(List<String> list) {
        PreLoadItem preLoadItem;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList start ");
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str = list.get(i6);
                    if (this.Fm.containsKey(str) && (preLoadItem = this.Fm.get(str)) != null) {
                        arrayList.add(Integer.valueOf(preLoadItem.materialType));
                    }
                }
                com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList end ");
            } catch (Throwable th) {
                throw th;
            }
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList " + arrayList.size());
        return arrayList;
    }

    @AnyThread
    public final int a(AdResultData adResultData, boolean z5, int i6) {
        Iterator<AdInfo> it;
        String str;
        boolean a6;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.k(adResultData);
        int i7 = 0;
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            if (adTemplate != null) {
                Iterator<AdInfo> it2 = adTemplate.adInfoList.iterator();
                while (it2.hasNext()) {
                    AdInfo next = it2.next();
                    if (next.adPreloadInfo != null && this.Fo != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(next)) {
                            if (com.kwad.sdk.core.response.b.a.bc(next)) {
                                str = com.kwad.sdk.core.response.b.a.K(next);
                            } else {
                                str = com.kwad.sdk.core.response.b.a.bd(next) ? com.kwad.sdk.core.response.b.a.aU(next).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String aZ = com.kwad.sdk.core.response.b.a.aZ(next);
                                if (next.adPreloadInfo.preloadType == 1 && !ao.isWifiConnected(ServiceProvider.getContext()) && !z5) {
                                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                    it = it2;
                                } else {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + aZ + " true url " + str);
                                    it = it2;
                                    a(adResultData.getPosId(), 1);
                                    a.C0688a c0688a = new a.C0688a();
                                    if (p(next)) {
                                        a6 = KSImageLoader.loadImageSync(str) != null;
                                    } else {
                                        a6 = k.a(str, aZ, c0688a);
                                    }
                                    if (a6) {
                                        o(next);
                                        i7++;
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - elapsedRealtime, 1, i6);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 4, c0688a.msg);
                                        com.kwad.components.core.p.a.se().f(adTemplate, 1, c0688a.msg);
                                    }
                                }
                            } else {
                                it = it2;
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            it = it2;
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - elapsedRealtime, 2, i6);
                            o(next);
                            i7++;
                        }
                    } else {
                        it = it2;
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                    it2 = it;
                }
            }
        }
        AdTemplate adTemplate2 = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i7 > 0) {
            com.kwad.sdk.utils.k.aq("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.p.a.se().e(adTemplate2, i7);
            return i7;
        }
        com.kwad.sdk.utils.k.aq("splashAd_", "onSplashVideoAdCacheFailed");
        return i7;
    }
}
