package xyz.adscope.amps.control.preload;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.preload.AMPSPreloadManagerInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSPreLoad {
    private static AMPSPreLoad instance;
    private static Map<String, AMPSPreloadManagerInfo> mPreloadAdData = new HashMap();

    public static synchronized AMPSPreLoad getInstance() {
        AMPSPreLoad aMPSPreLoad;
        synchronized (AMPSPreLoad.class) {
            try {
                if (instance == null) {
                    synchronized (AMPSPreLoad.class) {
                        instance = new AMPSPreLoad();
                    }
                }
                aMPSPreLoad = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aMPSPreLoad;
    }

    public void addPreLoadAdInfo(String str, AMPSBaseOpenApiManager aMPSBaseOpenApiManager) {
        long j6;
        if (!TextUtils.isEmpty(str) && aMPSBaseOpenApiManager != null) {
            if (mPreloadAdData.containsKey(str)) {
                mPreloadAdData.remove(str);
            }
            AMPSPreloadManagerInfo aMPSPreloadManagerInfo = new AMPSPreloadManagerInfo();
            aMPSPreloadManagerInfo.setSpaceId(str);
            aMPSPreloadManagerInfo.setBaseOpenApiManager(aMPSBaseOpenApiManager);
            aMPSPreloadManagerInfo.setCachedTime(System.currentTimeMillis());
            AdSourceModel winAdSourceModel = aMPSBaseOpenApiManager.getWinAdSourceModel();
            if (winAdSourceModel != null) {
                j6 = winAdSourceModel.getCachedOffersTimeout();
            } else {
                j6 = 0;
            }
            if (j6 == 0) {
                j6 = aMPSBaseOpenApiManager.getSpaceCachedOffersTimeout();
            }
            if (j6 != 0) {
                aMPSPreloadManagerInfo.setCachedOffersTimeout(j6);
                mPreloadAdData.put(str, aMPSPreloadManagerInfo);
            }
        }
    }

    public AMPSPreloadManagerInfo getAMPSPreloadManagerInfo(String str) {
        AMPSPreloadManagerInfo aMPSPreloadManagerInfo;
        if (TextUtils.isEmpty(str) || !mPreloadAdData.containsKey(str) || (aMPSPreloadManagerInfo = mPreloadAdData.get(str)) == null) {
            return null;
        }
        if (System.currentTimeMillis() - aMPSPreloadManagerInfo.getCachedTime() > aMPSPreloadManagerInfo.getCachedOffersTimeout()) {
            removePreLoadAdInfo(str);
            return null;
        }
        AMPSBaseOpenApiManager baseOpenApiManager = aMPSPreloadManagerInfo.getBaseOpenApiManager();
        if (baseOpenApiManager == null) {
            removePreLoadAdInfo(str);
            return null;
        }
        AMPSBaseAdapter winAdSourceAdapter = baseOpenApiManager.getWinAdSourceAdapter();
        if (winAdSourceAdapter == null) {
            removePreLoadAdInfo(str);
            return null;
        }
        if (!winAdSourceAdapter.isValid()) {
            removePreLoadAdInfo(str);
            return null;
        }
        removePreLoadAdInfo(str);
        return aMPSPreloadManagerInfo;
    }

    public void removePreLoadAdInfo(String str) {
        if (!TextUtils.isEmpty(str) && mPreloadAdData.containsKey(str)) {
            mPreloadAdData.remove(str);
        }
    }
}
