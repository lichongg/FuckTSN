package com.beizi.fusion.c;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AdPlusConfig;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f13366a;

    public static void a(Context context, String str) {
        try {
            b(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void b(final Context context, String str) {
        if (f13366a) {
            return;
        }
        try {
            a(context);
            com.beizi.ad.f.a(context, str, new com.beizi.ad.g() { // from class: com.beizi.fusion.c.l.1
                @Override // com.beizi.ad.g
                public String d() {
                    try {
                        if (RequestInfo.getInstance(context).getDevInfo() != null) {
                            String oaid = RequestInfo.getInstance(context).getDevInfo().getOaid();
                            if (!TextUtils.isEmpty(oaid)) {
                                return oaid;
                            }
                            String customOaid = RequestInfo.getInstance(context).getCustomOaid();
                            if (!TextUtils.isEmpty(customOaid)) {
                                return customOaid;
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    return super.d();
                }

                @Override // com.beizi.ad.g
                public boolean a() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().isCanUseLocation();
                    }
                    return super.a();
                }

                @Override // com.beizi.ad.g
                public BeiZiLocation b() {
                    if (BeiZis.getCustomController() != null) {
                        return BeiZis.getCustomController().getLocation();
                    }
                    return super.b();
                }

                @Override // com.beizi.ad.g
                public boolean c() {
                    if (BeiZis.getCustomController() != null) {
                        if (!ae.a() && BeiZis.getCustomController().isCanUseOaid()) {
                            return true;
                        }
                        return false;
                    }
                    return super.c();
                }
            });
            com.beizi.ad.f.b(x.a().a(StubApp.getOrigApplicationContext(context.getApplicationContext())));
            f13366a = true;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void a(Context context) {
        String a6;
        try {
            AdPlusConfig adPlusConfig = ResponseInfo.getInstance(context).getAdPlusConfig();
            if (adPlusConfig != null) {
                List<String> h5RedirectBlackList = adPlusConfig.getH5RedirectBlackList();
                if (h5RedirectBlackList == null || h5RedirectBlackList.size() <= 0) {
                    h5RedirectBlackList = new ArrayList<>();
                    h5RedirectBlackList.add("market://");
                }
                com.beizi.ad.f.a(h5RedirectBlackList);
            }
            if (adPlusConfig != null && !TextUtils.isEmpty(adPlusConfig.getAdUrl()) && adPlusConfig.getAdUrl().startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                a6 = adPlusConfig.getAdUrl();
            } else {
                a6 = com.beizi.fusion.tool.d.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGswL2pzb24=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3NkazAvanNvbg==");
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(a6)) {
                return;
            }
            com.beizi.ad.f.a(a6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(context, str);
            return com.beizi.ad.f.c(str2);
        }
        com.beizi.ad.internal.h.a().a(context);
        return new com.beizi.ad.v2.e.b().a(ao.a(), false);
    }
}
