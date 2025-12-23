package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private String liveStartTime;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String sW;
    private String sX;
    private String title;
    private List<String> uQ;
    private String uR;
    private String uS;
    private String uT;
    private boolean uU;
    private String uV;
    private String uW = "查看详情";
    private String uX = "立即预约";
    private List<String> uY;

    @Nullable
    private AdTemplate uZ;

    @Nullable
    public static a S(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo dt = com.kwad.sdk.core.response.b.b.dt(adTemplate);
        a aVar = new a();
        aVar.sW = dt.userHeadUrl;
        aVar.liveStartTime = dt.liveStartTime;
        aVar.title = dt.title;
        aVar.uU = dt.needShowSubscriberCount();
        aVar.uV = dt.getFormattedLiveSubscribeCount();
        aVar.uY = dt.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = dt.playEndCard;
        aVar.uW = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.uX = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.uZ = adTemplate;
        return aVar;
    }

    @Nullable
    public static a a(r rVar, boolean z5) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo el = e.el(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cl(el);
        aVar.sW = com.kwad.sdk.core.response.b.a.co(el);
        aVar.sX = com.kwad.sdk.core.response.b.a.au(el);
        aVar.uQ = com.kwad.sdk.core.response.b.d.ec(adTemplate);
        aVar.uR = com.kwad.sdk.core.response.b.a.aE(el);
        aVar.playableStyle = e.l(adTemplate, z5);
        aVar.uZ = adTemplate;
        aVar.mApkDownloadHelper = rVar.ij();
        return aVar;
    }

    @Nullable
    public static a R(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo el = e.el(adTemplate);
        AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(el);
        a aVar = new a();
        String name = cV.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ax(el);
        }
        aVar.sW = cV.getIcon();
        aVar.sX = com.kwad.sdk.core.response.b.a.au(el);
        aVar.price = cV.getPrice();
        aVar.originPrice = cV.getOriginPrice();
        if (!cV.isCouponListEmpty() && (firstCouponList = cV.getFirstCouponList()) != null) {
            aVar.T(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.S(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    private void T(String str) {
        this.uT = str;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String ho() {
        return this.sW;
    }

    public final String hp() {
        return this.sX;
    }

    public final String ig() {
        return this.uT;
    }

    public final String ih() {
        return this.uS;
    }

    @Nullable
    public final AdTemplate ii() {
        return this.uZ;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c ij() {
        return this.mApkDownloadHelper;
    }

    public final List<String> ik() {
        return this.uQ;
    }

    public final boolean il() {
        List<String> list = this.uQ;
        return list == null || list.size() == 0;
    }

    public final int im() {
        return this.playableStyle;
    }

    public final String in() {
        return this.uV;
    }

    public final String io() {
        return this.uX;
    }

    public final boolean ip() {
        return this.uU;
    }

    public final List<String> iq() {
        return this.uY;
    }

    public final String ir() {
        return this.liveStartTime;
    }

    private void S(String str) {
        this.uS = str;
    }
}
