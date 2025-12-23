package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static boolean O(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo el = el(adTemplate);
        return (a.aF(el) || a.cX(el) || et(adTemplate) != 3) ? false : true;
    }

    public static boolean b(List<AdTemplate> list, long j6, int i6) {
        AdTemplate a6 = a(list, j6, i6);
        if (a6 == null) {
            return false;
        }
        long ev = ev(a6);
        return i6 > 0 ? ev == j6 && ef(a6) == i6 : ev == j6;
    }

    public static boolean ex(@NonNull AdTemplate adTemplate) {
        int l6 = l(adTemplate, true);
        return l6 == 1 || l6 == 2;
    }

    public static boolean ey(@NonNull AdTemplate adTemplate) {
        int l6 = l(adTemplate, false);
        return l6 == 1 || l6 == 2;
    }

    public static boolean k(AdTemplate adTemplate, boolean z5) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo el = el(adTemplate);
        return a.aF(el) && !a.cX(el) && !z5 && et(adTemplate) == 2;
    }

    @Nullable
    private static g IR() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.wp();
        }
        return null;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j6, int i6) {
        if (j6 >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j6, i6)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static int eB(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig != null) {
            return adVideoPreCacheConfig.adVideoPreCacheSize;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar != null) {
            return hVar.BQ();
        }
        return 800;
    }

    public static int eG(@NonNull AdTemplate adTemplate) {
        return adTemplate.type;
    }

    public static int eH(@NonNull AdTemplate adTemplate) {
        return adTemplate.defaultType;
    }

    public static boolean ed(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long ee(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int ef(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int eg(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0;
        }
        SceneImpl sceneImpl = adTemplate.mAdScene;
        return (sceneImpl == null || sceneImpl.adStyle == 0) ? ef(adTemplate) : sceneImpl.getAdStyle();
    }

    public static int eh(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long ei(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String ej(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String ek(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo el(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    @NonNull
    public static PhotoInfo em(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static int et(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return el(adTemplate).adBaseInfo.taskType;
    }

    public static long ev(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return el(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eA(@NonNull AdTemplate adTemplate) {
        AdInfo el = el(adTemplate);
        int ef = ef(adTemplate);
        if (el.adStyleConfInfo.adPushDownloadJumpType == 0 && ef == 17 && a.aF(el)) {
            return true;
        }
        return false;
    }

    public static KsLiveInfo eC(AdTemplate adTemplate) {
        AdInfo el = el(adTemplate);
        if (el.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(el.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        String str = el.advertiserInfo.userName;
        if (str != null) {
            ksLiveBaseInfo.setUserName(str);
        }
        String str2 = el.advertiserInfo.portraitUrl;
        if (str2 != null) {
            ksLiveBaseInfo.setPortraitUrl(str2);
        }
        long j6 = el.adBaseInfo.liveDisplayWatchingCount;
        if (j6 > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(j6);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = el.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        List<CouponInfo> list = adProductInfo.couponList;
        if (list != null && list.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int eD(@NonNull AdTemplate adTemplate) {
        return el(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean eE(@NonNull AdTemplate adTemplate) {
        int ef = ef(adTemplate);
        if (ef == 13) {
            return true;
        }
        if (ef == 23 && eD(adTemplate) == 2) {
            return true;
        }
        return false;
    }

    public static boolean eF(@NonNull AdTemplate adTemplate) {
        int ef = ef(adTemplate);
        if (ef == 3) {
            return true;
        }
        if (ef == 23 && eD(adTemplate) == 1) {
            return true;
        }
        return false;
    }

    public static String en(@NonNull AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.K(el(adTemplate));
        }
        return h.a(em(adTemplate));
    }

    public static String eo(@NonNull AdTemplate adTemplate) {
        return el(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String ep(@NonNull AdTemplate adTemplate) {
        String IV;
        g IR = IR();
        if (IR == null) {
            IV = "";
        } else {
            IV = IR.IV();
        }
        if (TextUtils.isEmpty(IV)) {
            return IV;
        }
        return a.Y(el(adTemplate));
    }

    public static String eq(@NonNull AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.co(el(adTemplate));
        }
        g IR = IR();
        if (IR == null) {
            return "";
        }
        return IR.IW();
    }

    public static long er(@NonNull AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.ab(el(adTemplate));
        }
        g IR = IR();
        if (IR == null) {
            return adTemplate.hashCode();
        }
        return IR.IX();
    }

    public static int es(@NonNull AdTemplate adTemplate) {
        g IR = IR();
        if (IR == null) {
            return 0;
        }
        return IR.IY();
    }

    public static String eu(@NonNull AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.cI(el(adTemplate));
        }
        return h.c(em(adTemplate));
    }

    public static boolean ew(AdTemplate adTemplate) {
        if (el(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow) {
            return true;
        }
        return false;
    }

    public static int ez(@NonNull AdTemplate adTemplate) {
        return el(adTemplate).adBaseInfo.ecpm;
    }

    public static int l(@NonNull AdTemplate adTemplate, boolean z5) {
        int i6;
        AdInfo el = el(adTemplate);
        if (eF(adTemplate)) {
            if (z5) {
                i6 = el.adMatrixInfo.adDataV2.actionBarInfo.cardType;
            } else {
                i6 = el.adMatrixInfo.adDataV2.endCardInfo.cardType;
            }
            if (i6 == 5) {
                return 1;
            }
            if (i6 == 6) {
                return 2;
            }
            return -1;
        }
        return el.adBaseInfo.mABParams.playableStyle;
    }

    public static boolean b(AdTemplate adTemplate, long j6, int i6) {
        long ev = ev(adTemplate);
        return i6 > 0 ? ev == j6 && ef(adTemplate) == i6 : ev == j6;
    }
}
