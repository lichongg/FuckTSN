package com.bytedance.sdk.openadsdk.i.j.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private Function<SparseArray<Object>, Object> f31484j;

        public IMediationAdSlot j() {
            Object apply;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8260031);
            apply = this.f31484j.apply(sparseArray);
            if (apply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) apply;
            }
            return null;
        }

        public j(Function<SparseArray<Object>, Object> function) {
            this.f31484j = function;
        }
    }

    public static final SparseArray<Object> j(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        a a6 = a.a();
        a6.h(260001, adSlot.getAdId());
        a6.h(260002, adSlot.getCreativeId());
        a6.h(260003, adSlot.getExt());
        a6.h(260004, adSlot.getCodeId());
        a6.i(260005, adSlot.isAutoPlay());
        a6.e(260006, adSlot.getImgAcceptedWidth());
        a6.e(260007, adSlot.getImgAcceptedHeight());
        a6.d(260008, adSlot.getExpressViewAcceptedWidth());
        a6.d(260009, adSlot.getExpressViewAcceptedHeight());
        a6.i(260010, adSlot.isSupportDeepLink());
        a6.i(260011, adSlot.isSupportRenderConrol());
        a6.e(2600012, adSlot.getAdCount());
        a6.h(260013, adSlot.getMediaExtra());
        a6.h(260014, adSlot.getUserID());
        a6.e(260015, adSlot.getOrientation());
        a6.e(260016, adSlot.getNativeAdType());
        a6.g(260017, adSlot.getExternalABVid());
        a6.e(260018, adSlot.getAdloadSeq());
        a6.h(260019, adSlot.getPrimeRit());
        a6.e(260020, adSlot.getAdType());
        a6.h(260021, adSlot.getBidAdm());
        a6.h(260022, adSlot.getUserData());
        a6.g(260023, j(adSlot.getAdLoadType()));
        a6.g(260024, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.xt.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        a6.g(260025, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.xt.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        a6.g(260026, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.i.j.cw.xt.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            a6.g(8260028, new com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.j(adSlot.getMediationAdSlot()));
        }
        return a6.k().sparseArray();
    }

    public static AdSlot j(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet k6 = a.j(sparseArray).k();
        if (k6 != null) {
            builder.setAdId(k6.stringValue(260001)).setCodeId(k6.stringValue(260002)).setExt(k6.stringValue(260003)).setCodeId(k6.stringValue(260004)).setIsAutoPlay(k6.booleanValue(260005)).setImageAcceptedSize(k6.intValue(260006), k6.intValue(260007)).setExpressViewAcceptedSize(k6.floatValue(260008), k6.floatValue(260009)).setSupportDeepLink(k6.booleanValue(260010)).setAdCount(k6.intValue(2600012)).setMediaExtra(k6.stringValue(260013)).setUserID(k6.stringValue(260014)).setExternalABVid((int[]) k6.objectValue(260017, int[].class)).setAdloadSeq(k6.intValue(260018)).setPrimeRit(k6.stringValue(260019)).setAdType(k6.intValue(260020)).withBid(k6.stringValue(260021)).setUserData(k6.stringValue(260022)).setAdLoadType(j(k6.intValue(260023))).setMediationAdSlot(new j(az.j(k6.objectValue(8260028, Object.class))).j()).setOrientation(k6.intValue(260015)).setRewardName((String) k6.objectValue(260024, String.class)).setRewardAmount(k6.intValue(260025));
            if (k6.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer j(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType j(int i6) {
        if (i6 == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i6 == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }
}
