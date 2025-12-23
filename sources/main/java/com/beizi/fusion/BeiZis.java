package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.x;
import com.kuaishou.weapon.p0.g;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZis {

    /* renamed from: a, reason: collision with root package name */
    private static BeiZiCustomController f13272a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f13273b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f13274c = "1.0.25";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f13275d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f13276e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f13277f;

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str) {
        f13275d = false;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInitWithDomain(Context context, String str, String str2) {
        f13275d = false;
        if (TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        }
    }

    public static void closeShakeAd() {
        f13277f = true;
    }

    @RequiresPermission(g.f36041a)
    public static void init(Context context, String str) {
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    public static BeiZiCustomController getCustomController() {
        return f13272a;
    }

    public static String getOaidVersion() {
        return f13274c;
    }

    public static String getSdkVersion() {
        return "5.2.1.20";
    }

    public static boolean getTransferProtocol() {
        return f13276e;
    }

    @RequiresPermission(g.f36041a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f13272a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    public static boolean isCloseShakeAd() {
        return f13277f;
    }

    public static boolean isIsSyncInit() {
        return f13275d;
    }

    public static boolean isLimitPersonalAds() {
        return f13273b;
    }

    public static void setLimitPersonalAds(boolean z5) {
        f13273b = z5;
    }

    public static void setOaidVersion(String str) {
        f13274c = str;
    }

    public static void setTransferProtocol(boolean z5) {
        f13276e = z5;
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiInitCallBack beiZiInitCallBack) {
        f13275d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    public static String getBidToken(String str) {
        return com.beizi.fusion.c.b.a().b(str);
    }

    @RequiresPermission(g.f36041a)
    public static void initWithDomain(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        }
    }

    public static void setAnyCustomExt(Map<String, Object> map) {
        com.beizi.fusion.c.b.a().a(map);
    }

    public static void setSupportPersonalized(boolean z5) {
        ae.a(z5);
    }

    public static void setUserAgent(String str) {
        x.a().a(str);
    }

    @RequiresPermission(g.f36041a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f13272a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInitWithDomain(Context context, String str, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        f13275d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        if (!TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        }
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f36041a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f13272a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, BeiZiInitCallBack beiZiInitCallBack) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }

    @RequiresPermission(g.f36041a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3, BeiZiInitCallBack beiZiInitCallBack) {
        f13272a = beiZiCustomController;
        f13275d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }
}
