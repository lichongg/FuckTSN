package com.bytedance.msdk.api.r.j.xt.cw;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.i.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private final String ae;
    private final String cw;

    /* renamed from: g, reason: collision with root package name */
    private final String f24370g;

    /* renamed from: j, reason: collision with root package name */
    private final String f24371j;

    /* renamed from: m, reason: collision with root package name */
    private final String f24372m;
    private final String oq;
    private final String qv;

    /* renamed from: r, reason: collision with root package name */
    private final String f24373r;
    private final String tl;
    private final String up;
    private final String vl;
    private final String xt;

    public xt() {
        this.cw = "";
        this.f24371j = "";
        this.xt = "";
        this.f24373r = "";
        this.up = "";
        this.f24372m = "";
        this.ae = "";
        this.tl = "";
        this.f24370g = "";
        this.oq = "";
        this.qv = "";
        this.vl = "";
    }

    public SparseArray<Object> j() {
        r j6 = r.j();
        j6.j(8003, this.cw);
        j6.j(8534, this.f24371j);
        j6.j(8535, this.xt);
        j6.j(8536, this.f24373r);
        j6.j(8537, this.up);
        j6.j(8538, this.f24372m);
        j6.j(8539, this.ae);
        j6.j(8540, this.tl);
        j6.j(8541, this.f24370g);
        j6.j(8542, this.oq);
        j6.j(8543, this.qv);
        j6.j(8544, this.vl);
        return j6.xt();
    }

    @Nullable
    public String cw() {
        return this.f24373r;
    }

    public boolean r() {
        return TextUtils.equals(this.vl, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.f24371j + "', mAppKey='" + this.xt + "', mADNName='" + this.cw + "', mAdnInitClassName='" + this.f24373r + "', mBannerClassName='" + this.up + "', mInterstitialClassName='" + this.f24372m + "', mRewardClassName='" + this.ae + "', mFullVideoClassName='" + this.tl + "', mSplashClassName='" + this.f24370g + "', mDrawClassName='" + this.qv + "', mFeedClassName='" + this.oq + "'}";
    }

    @Nullable
    public String xt() {
        return this.cw;
    }

    public xt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.cw = str;
        this.f24371j = str2;
        this.xt = str3;
        this.f24373r = str4;
        this.up = str5;
        this.f24372m = str6;
        this.ae = str7;
        this.tl = str8;
        this.f24370g = str9;
        this.oq = str10;
        this.qv = str11;
        this.vl = str12;
    }

    @Nullable
    public j j(int i6, int i7) {
        switch (i6) {
            case 1:
                return new j(this.up, com.bytedance.msdk.api.r.j.xt.j.j.class);
            case 2:
                return new j(this.f24372m, com.bytedance.msdk.api.r.j.xt.ae.j.class);
            case 3:
                return new j(this.f24370g, com.bytedance.msdk.api.r.j.xt.oq.j.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i7 == 4) {
                    return new j(this.oq, com.bytedance.msdk.api.r.j.xt.tl.j.class);
                }
                if (i7 == 5) {
                    return new j(this.qv, com.bytedance.msdk.api.r.j.xt.r.j.class);
                }
                if (i7 == 3) {
                    return new j(this.up, com.bytedance.msdk.api.r.j.xt.j.j.class);
                }
                return new j(this.oq, com.bytedance.msdk.api.r.j.xt.tl.j.class);
            case 7:
                if (i7 == 6) {
                    return new j(this.ae, com.bytedance.msdk.api.r.j.xt.g.j.class);
                }
                if (i7 == 7) {
                    return new j(this.tl, com.bytedance.msdk.api.r.j.xt.up.j.class);
                }
                return new j(this.ae, com.bytedance.msdk.api.r.j.xt.g.j.class);
            case 8:
                return new j(this.tl, com.bytedance.msdk.api.r.j.xt.up.j.class);
            case 9:
                break;
            case 10:
                if (i7 == 1) {
                    return new j(this.f24372m, com.bytedance.msdk.api.r.j.xt.ae.j.class);
                }
                if (i7 == 2) {
                    return new j(this.tl, com.bytedance.msdk.api.r.j.xt.up.j.class);
                }
                break;
        }
        return new j(this.qv, com.bytedance.msdk.api.r.j.xt.r.j.class);
    }
}
