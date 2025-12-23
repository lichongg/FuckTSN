package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.dev.IDeviceInterface;
import xyz.adscope.common.v2.dev.oaid.OAIDHelper;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j1 implements p2 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55269a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55270b;

    private k1 a(Context context, String str) {
        k1 k1Var = new k1();
        k1Var.a(System.currentTimeMillis());
        k1Var.b(str);
        k1Var.a(f0.a());
        j orCreateImplement = k.a().getOrCreateImplement(context);
        IDeviceInterface b6 = orCreateImplement != null ? orCreateImplement.b() : null;
        if (b6 != null) {
            k1Var.w(b6.getUserAgent());
            k1Var.c(b6.getDeviceType());
            k1Var.k(b6.getManufacturer());
            k1Var.c(b6.getBrand());
            k1Var.l(b6.getModel());
            k1Var.e(b6.getOs());
            k1Var.n(b6.getAndroidRelease());
            k1Var.d(b6.getCarrier());
            k1Var.a(b6.getConnectType());
            k1Var.j(b6.getLanguage());
            k1Var.i(b6.getScreenWidthPX());
            k1Var.h(b6.getScreenHeightPX());
            k1Var.g(b6.getScreenWidthPX());
            k1Var.f(b6.getScreenHeightPX());
            k1Var.d(b6.getOrientation());
            k1Var.a(b6.getDensity());
            k1Var.b(b6.getDensityDpi());
            k1Var.u(b6.getDeviceUpdateMark());
            k1Var.o(b6.getPhysicalMemory());
            k1Var.i(b6.getHardDisk());
            k1Var.f(b6.getDeviceName());
            k1Var.e(b6.getCountryCode());
            k1Var.g(b6.getFileMark());
            k1Var.b(b6.getCountryCN());
            k1Var.r(f0.a(context));
            k1Var.q(f0.a(context));
        }
        e orCreateImplement2 = f.a().getOrCreateImplement(context);
        if (orCreateImplement2 != null) {
            ASNPInitConfig a6 = orCreateImplement2.a();
            if (a6 != null && a6.canUseOAIDInfo()) {
                k1Var.m(OAIDHelper.getInstance().getOAID(context));
                k1Var.h("");
            }
            ConfigResponseModel a7 = orCreateImplement2.a(false);
            if (a7 != null) {
                k1Var.v(a(a7, "update"));
                k1Var.p(a(a7, "requestUrl"));
                k1Var.t(a(a7, "strategy"));
                k1Var.s(a(a7, "statistics"));
            }
        }
        return k1Var;
    }

    public j1(Context context, String str) {
        this.f55269a = context;
        this.f55270b = str;
    }

    private String a(ConfigResponseModel configResponseModel, String str) {
        Object object;
        if (configResponseModel != null && (object = JsonUtil.getObject(configResponseModel.toJsonString(), str)) != null) {
            return MD5Util.md5(object.toString());
        }
        return "";
    }

    @Override // xyz.adscope.ad.p2
    public String a() {
        return a(this.f55269a, this.f55270b).toJsonString();
    }
}
