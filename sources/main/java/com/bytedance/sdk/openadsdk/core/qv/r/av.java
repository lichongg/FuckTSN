package com.bytedance.sdk.openadsdk.core.qv.r;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.i;
import com.ss.android.j.j.cw.e;
import com.ss.android.j.j.up.c;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.xt.j.j.a;
import com.ss.android.xt.j.j.b;
import com.ss.android.xt.j.j.c;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONObject;
import w2.d;
import w2.h;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class av extends com.bytedance.sdk.openadsdk.core.wq.r {

    /* renamed from: j, reason: collision with root package name */
    private static volatile av f29954j;

    /* renamed from: g, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f29955g;
    private final Context xt;
    private Map<Integer, a.C0804a> cw = new ConcurrentHashMap();

    /* renamed from: r, reason: collision with root package name */
    private Map<Integer, a> f29957r = new ConcurrentHashMap();
    private Map<Integer, b.a> up = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    private Map<Integer, b> f29956m = new ConcurrentHashMap();
    private Map<Integer, c.a> ae = new ConcurrentHashMap();
    private Map<Integer, c> tl = new ConcurrentHashMap();

    private w2.r ae(Object obj) {
        if (obj instanceof w2.r) {
            return (w2.r) obj;
        }
        return null;
    }

    private static boolean cw() {
        Field declaredField;
        try {
            try {
                declaredField = i.class.getDeclaredField("b");
                declaredField.setAccessible(true);
            } catch (Exception unused) {
                Field declaredField2 = i.class.getDeclaredField("a");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(null);
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    return intValue > 107000925 || (intValue <= 4061200 && intValue > 3000000);
                }
            }
        } catch (Exception unused2) {
        }
        return declaredField.get(null) instanceof Integer;
    }

    private h g(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        return null;
    }

    public static av j(Context context) {
        if (f29954j == null) {
            synchronized (av.class) {
                try {
                    if (f29954j == null) {
                        f29954j = new av(context);
                    }
                } finally {
                }
            }
        }
        return f29954j;
    }

    private com.bytedance.sdk.openadsdk.i.cw.j.j m(Object obj) {
        if (f.a(obj)) {
            return new com.bytedance.sdk.openadsdk.i.cw.j.j(obj);
        }
        return null;
    }

    private com.ss.android.j.j.cw.g r(Object obj) {
        if (obj instanceof com.ss.android.j.j.cw.g) {
            return (com.ss.android.j.j.cw.g) obj;
        }
        return null;
    }

    private d tl(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        return null;
    }

    private com.ss.android.j.j.cw.c up(Object obj) {
        if (obj instanceof com.ss.android.j.j.cw.c) {
            return (com.ss.android.j.j.cw.c) obj;
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> xt() {
        Function<SparseArray<Object>, Object> function = this.f29955g;
        if (function != null) {
            return function;
        }
        if (!com.bytedance.sdk.openadsdk.i.cw.r.xt(com.bytedance.sdk.openadsdk.core.h.xt)) {
            return null;
        }
        this.f29955g = com.bytedance.sdk.openadsdk.core.oq.i().m(3);
        HashMap hashMap = new HashMap();
        hashMap.put("n", com.bytedance.sdk.openadsdk.core.oq.i().gx());
        this.f29955g.apply(com.bytedance.sdk.openadsdk.i.r.j().j(159).j(Map.class).j(0, hashMap).xt());
        return this.f29955g;
    }

    public boolean av(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.b();
    }

    public boolean az(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.av();
    }

    public String i(int i6) {
        c qo = qo(i6);
        return qo == null ? "" : qo.j();
    }

    public boolean jy(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.ws();
    }

    public Object oq(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return null;
        }
        return wo.qv();
    }

    public boolean qv(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.vl();
    }

    public boolean vl(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.jy();
    }

    public boolean ws(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.az();
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private void ik(int i6) {
        this.cw.remove(Integer.valueOf(i6));
        this.f29957r.remove(Integer.valueOf(i6));
        this.up.remove(Integer.valueOf(i6));
        this.f29956m.remove(Integer.valueOf(i6));
        this.ae.remove(Integer.valueOf(i6));
        this.tl.remove(Integer.valueOf(i6));
    }

    private a.C0804a ka(int i6) {
        return this.cw.get(Integer.valueOf(i6));
    }

    private int ll(int i6) {
        return i6 + 1;
    }

    private c qo(int i6) {
        return this.tl.get(Integer.valueOf(i6));
    }

    private a u(int i6) {
        return this.f29957r.get(Integer.valueOf(i6));
    }

    private b wo(int i6) {
        return this.f29956m.get(Integer.valueOf(i6));
    }

    public <T> T call(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 != 20) {
            return (T) j(cls, i6, (pluginValueSet == null || pluginValueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) pluginValueSet.objectValue(0, Map.class));
        }
        j((Bundle) pluginValueSet.objectValue(0, Bundle.class));
        return null;
    }

    private av(Context context) {
        this.xt = context;
    }

    private void m(int i6, int i7) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.j(i7);
    }

    private int oy(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return 0;
        }
        return wo.xt();
    }

    private void r(int i6, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        c.a c6 = new c.a().g(str).p(str2).m(str3).k(str4).o(str5).d(str6).a(str7).i(booleanValue).c(booleanValue2);
        this.ae.put(Integer.valueOf(i6), c6);
        if (jSONObject != null) {
            c6.f(jSONObject);
        }
        this.tl.put(Integer.valueOf(i6), c6.j());
    }

    private void up(int i6, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickLabel");
        int intValue = ((Integer) map.get("downloadScene")).intValue();
        String str4 = (String) map.get("refer");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
        String str5 = (String) map.get("clickStartLabel");
        String str6 = (String) map.get("clickContinueLabel");
        String str7 = (String) map.get("clickPauseLabel");
        String str8 = (String) map.get("storageDenyLabel");
        String str9 = (String) map.get("clickInstallLabel");
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
        c.a q5 = new c.a().g(str).p(str2).b(str3).m(str5).k(str6).o(str7).d(str8).a(str9).i(booleanValue).e(intValue).c(booleanValue2).l(str4).h(jSONObject).q(jSONObject2);
        this.ae.put(Integer.valueOf(i6), q5);
        if (jSONObject3 != null) {
            q5.f(jSONObject3);
        }
        this.tl.put(Integer.valueOf(i6), q5.j());
    }

    public int a(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return 0;
        }
        return qo.qv();
    }

    public boolean ae(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.tl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == -99999986) {
            return (T) j().sparseArray();
        }
        return (T) call(i6, pluginValueSet, cls);
    }

    public String aq(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.s();
    }

    public a av(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.D(str);
    }

    public a az(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.j(str);
    }

    public boolean b(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.ws();
    }

    public List<String> c(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.xt();
    }

    public String ch(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.g();
    }

    public String e(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.az();
    }

    public String ed(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.j();
    }

    public String f(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.m();
    }

    public int ff(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 0;
        }
        return u5.f();
    }

    public JSONObject g(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return null;
        }
        return wo.oq();
    }

    public long gq(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 0L;
        }
        return u5.r();
    }

    public String gx(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.cw();
    }

    public JSONObject h(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return null;
        }
        return qo.ws();
    }

    public boolean hh(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return true;
        }
        return u5.vl();
    }

    public boolean hl(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.ws();
    }

    public boolean im(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return u2.b.f(com.ss.android.socialbase.downloader.jy.j.j(ya(i6)), nd(i6));
        }
        return u5.uf();
    }

    public a jy(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.w(str);
    }

    public boolean k(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.tj();
    }

    public String kc(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.ch();
    }

    public boolean ki(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return true;
        }
        return u5.nd();
    }

    public String kt(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.r();
    }

    public boolean l(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return true;
        }
        return qo.vl();
    }

    public JSONObject la(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return null;
        }
        return qo.az();
    }

    public com.ss.android.j.j.up.c ln(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.gq();
    }

    public String mi(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.cw();
    }

    public String n(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.tl();
    }

    public String nd(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.g();
    }

    public int nt(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 1;
        }
        return u5.c();
    }

    public boolean ol(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return true;
        }
        return u5.qv();
    }

    public a oq(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.z(str);
    }

    public boolean p(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return false;
        }
        return qo.jy();
    }

    public List<String> pz(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.p();
    }

    public String q(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.av();
    }

    public JSONObject qa(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.h();
    }

    public void qb(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.i();
    }

    public a qv(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.i(str);
    }

    public Map<String, String> rh(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.oq();
    }

    public String ri(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.gx();
    }

    public String rn(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.up();
    }

    public String rr(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.a();
    }

    public String ry(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.v();
    }

    public Object s(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return null;
        }
        return qo.oq();
    }

    public void sm(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.mi();
    }

    public com.ss.android.j.j.up.f st(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.l();
    }

    public boolean t(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.rh();
    }

    public String tj(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.up();
    }

    public int tl(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return 0;
        }
        return wo.g();
    }

    public String uc(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return "";
        }
        return u5.gx();
    }

    public long uf(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 0L;
        }
        return u5.ae();
    }

    public boolean uq(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return true;
        }
        return u5.b();
    }

    public String v(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.m();
    }

    public a vl(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.v(str);
    }

    public String w(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.xt();
    }

    public int wf(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 0;
        }
        return u5.la();
    }

    public long wq(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 0L;
        }
        return u5.m();
    }

    public a ws(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.C(str);
    }

    public String x(int i6) {
        c qo = qo(i6);
        if (qo == null) {
            return "";
        }
        return qo.tl();
    }

    public boolean xp(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.rn();
    }

    public void xq(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.kt();
    }

    public int y(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return 2;
        }
        return u5.ed();
    }

    public JSONObject ya(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.w();
    }

    public boolean z(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return false;
        }
        return u5.jy();
    }

    public boolean zz(int i6) {
        a u5 = u(i6);
        if (u5 == null) {
            return true;
        }
        return u5.x();
    }

    public a i(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.d(str);
    }

    public void ae(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.y(str);
    }

    public a g(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.c(str);
    }

    public int m(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return 1;
        }
        return wo.m();
    }

    public void tl(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.B(str);
    }

    private void m(int i6, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get(TKDownloadReason.KSAD_TK_MD5);
        long longValue2 = ((Long) map.get("extraValue")).longValue();
        boolean booleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int intValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean booleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.ss.android.j.j.up.c b6 = new c.a().a(str6).d((String) map.get("quickAppModelExtraData")).b();
        int intValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean booleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get("appIcon");
        boolean booleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get("downloadUrl");
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        boolean booleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        a.C0804a m6 = new a.C0804a().j(longValue).n(str).d(longValue3).y(longValue2).r(booleanValue).i(intValue).J(str10).z(str9).K(list2).u(str2).o(list).B(str3).p(map2).M(booleanValue2).f(booleanValue7).A(booleanValue3).w(str4).H(intValue2).x(str5).k(b6).v(booleanValue8).c(intValue3).F(str7).t(str8).b(booleanValue4).C(booleanValue5).h(booleanValue6).q(jSONObject).m(new tj() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.av.2
            @Override // com.ss.android.socialbase.downloader.r.tj
            public Uri j(String str18, String str19) {
                return av.this.j(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            m6.L(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            m6.g(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            m6.D(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            m6.a(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            m6.e(str14);
        }
        m6.E(booleanValue9);
        m6.l(j(longValue3, str15, str16, str17));
        this.cw.put(Integer.valueOf(i6), m6);
        this.f29957r.put(Integer.valueOf(i6), m6.s());
    }

    public a ae(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.x(z5);
    }

    public a g(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.t(z5);
    }

    public <T> T j(Class<T> cls, int i6, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        a u5 = u(intValue);
        switch (i6) {
            case 3:
                az.j(((Integer) map.get("hid")).intValue());
                break;
            case 4:
                az.xt().i(u5 == null ? (String) map.get("downloadUrl") : u5.j(), intValue);
                ik(intValue);
                break;
            case 5:
                az.xt().h(this.xt, intValue, xt(map.get("downloadStatusChangeListener")), u5 == null ? cw(map.get("downloadModel")) : u5);
                break;
            case 6:
                break;
            case 7:
                az.cw();
                break;
            case 8:
                az.xt().m(u5 == null ? (String) map.get("downloadUrl") : u5.j(), ((Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                az.j(((Integer) map.get("hid")).intValue(), (cw.j) map.get("onEventLogHandler"));
                break;
            case 10:
                az.j((String) map.get("downloadPath"));
                break;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                a cw = u5 == null ? cw(map.get("downloadModel")) : u5;
                com.ss.android.j.j.cw.g qo = qo(intValue);
                if (qo == null) {
                    qo = r(map.get("downloadEventConfig"));
                }
                com.ss.android.j.j.cw.g gVar = qo;
                com.ss.android.j.j.cw.c wo = wo(intValue);
                if (wo == null) {
                    wo = up(map.get("downloadController"));
                }
                com.ss.android.j.j.cw.c cVar = wo;
                h g6 = g(map.get("downloadButtonClickListener"));
                if (!j(g6)) {
                    break;
                } else {
                    break;
                }
            case 13:
                boolean booleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                com.ss.android.j.j.cw.b cw2 = u5 == null ? cw(map.get("downloadModel")) : u5;
                com.ss.android.j.j.cw.g qo2 = qo(intValue);
                if (qo2 == null) {
                    qo2 = r(map.get("downloadEventConfig"));
                }
                com.ss.android.j.j.cw.c wo2 = wo(intValue);
                if (wo2 == null) {
                    wo2 = up(map.get("downloadController"));
                }
                com.ss.android.j.j.cw.c cVar2 = wo2;
                e xt = xt(map.get("downloadStatusChangeListener"));
                h g7 = g(map.get("downloadButtonClickListener"));
                if (j(g7)) {
                    az.xt().r().b(this.xt, str, booleanValue, cw2, qo2, cVar2, xt, intValue, g7);
                    break;
                } else {
                    az.xt().r().c(this.xt, str, booleanValue, cw2, qo2, cVar2, xt, intValue);
                    break;
                }
            case 14:
                break;
            case 16:
                String j6 = u5 == null ? (String) map.get("downloadUrl") : u5.j();
                long longValue = u5 == null ? ((Long) map.get("id")).longValue() : u5.r();
                int intValue2 = ((Integer) map.get("action_type_button")).intValue();
                com.ss.android.j.j.cw.g qo3 = qo(intValue);
                if (qo3 == null) {
                    qo3 = r(map.get("downloadEventConfig"));
                }
                com.ss.android.j.j.cw.g gVar2 = qo3;
                com.ss.android.j.j.cw.c wo3 = wo(intValue);
                if (wo3 == null) {
                    wo3 = up(map.get("downloadController"));
                }
                az.xt().j(j6, longValue, intValue2, gVar2, wo3);
                break;
            case 17:
                String j7 = u5 == null ? (String) map.get("downloadUrl") : u5.j();
                long longValue2 = ((Long) map.get("id")).longValue();
                int intValue3 = ((Integer) map.get("action_type_button")).intValue();
                com.ss.android.j.j.cw.g qo4 = qo(intValue);
                if (qo4 == null) {
                    qo4 = r(map.get("downloadEventConfig"));
                }
                com.ss.android.j.j.cw.g gVar3 = qo4;
                com.ss.android.j.j.cw.c wo4 = wo(intValue);
                if (wo4 == null) {
                    wo4 = up(map.get("downloadController"));
                }
                az.xt().k(j7, longValue2, intValue3, gVar3, wo4, tl(map.get("itemClickListener")), g(map.get("downloadButtonClickListener")));
                break;
            case 18:
                T t5 = (T) Boolean.valueOf(az.xt().r().j(u5 == null ? ((Long) map.get("id")).longValue() : u5.r(), intValue));
                ik(intValue);
                break;
            case 19:
                break;
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    a.C0804a c0804a = new a.C0804a();
                    this.cw.put(Integer.valueOf(intValue), c0804a);
                    this.f29957r.put(Integer.valueOf(intValue), c0804a.s());
                    break;
                } else {
                    xt(intValue, map);
                    break;
                }
            case 24:
                j(intValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME));
                break;
            case 25:
                j(intValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                break;
            case 26:
                m(intValue, ((Integer) map.get("downloadMode")).intValue());
                break;
            case 28:
                j(intValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), ae(map.get("downloadMarketInterceptor")));
                break;
            case 29:
                r(intValue, map);
                break;
            case 30:
                xt(intValue, ((Integer) map.get("downloadScene")).intValue());
                break;
            case 31:
                up(intValue, ((Boolean) map.get("isShowToast")).booleanValue());
                break;
            case 32:
                cw(intValue, map);
                break;
            case 44:
                j(intValue, ((Integer) map.get("linkMode")).intValue());
                break;
            case 46:
                j(intValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                break;
            case 49:
                xt(intValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                break;
            case 50:
                cw(intValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                break;
            case 53:
                j(intValue, map.get("extraObject"));
                break;
            case 54:
                j(intValue, (JSONObject) map.get("extraJson"));
                break;
            case 56:
                up(intValue, map);
                break;
            case 72:
                xt(intValue, map.get("extraEventObject"));
                break;
            case 73:
                j(intValue, (String) map.get("clickButtonTag"));
                break;
            case 74:
                xt(intValue, (JSONObject) map.get("eventConfigExtraJson"));
                break;
            case 75:
                cw(intValue, (JSONObject) map.get("paramsJson"));
                break;
            case 76:
                xt(intValue, (String) map.get("clickItemTag"));
                break;
            case 78:
                cw(intValue, (String) map.get("refer"));
                break;
            case 79:
                r(intValue, (String) map.get("quickAppEventTag"));
                break;
            case 80:
                m(intValue, map);
                break;
            case 98:
                qb(intValue);
                break;
            case 100:
                sm(intValue);
                break;
            case 101:
                xq(intValue);
                break;
            case 123:
                up(intValue, (String) map.get(TKDownloadReason.KSAD_TK_MD5));
                break;
            case 124:
                j(intValue, ((Long) map.get("expectFileLength")).longValue());
                break;
            case 125:
                r(intValue, ((Boolean) map.get("needWifi")).booleanValue());
                break;
            case 127:
                xt(intValue, ((Long) map.get("extraValue")).longValue());
                break;
            case 128:
                m(intValue, (String) map.get("appName"));
                break;
            case 129:
                r(intValue, (JSONObject) map.get("extraJson"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                ae(intValue, (String) map.get("startToast"));
                break;
            case 131:
                tl(intValue, (String) map.get("sdkMonitorScene"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                cw(intValue, ((Long) map.get("id")).longValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                m(intValue, ((Boolean) map.get("isAd")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS /* 134 */:
                cw(intValue, ((Integer) map.get("modelType")).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET /* 135 */:
                g(intValue, (String) map.get("logExtra"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                oq(intValue, (String) map.get(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                qv(intValue, (String) map.get("appIcon"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE /* 139 */:
                j(intValue, (List<String>) map.get("clickTrackUrl"));
                break;
            case 140:
                vl(intValue, (String) map.get("downloadUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                xt(intValue, (List<String>) map.get("backupUrls"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                jy(intValue, (String) map.get("notificationJumpUrl"));
                break;
            case 143:
                ws(intValue, (String) map.get("mimeType"));
                break;
            case 144:
                j(intValue, (Map<String, String>) map.get("headers"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES /* 145 */:
                ae(intValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                az(intValue, (String) map.get("filePath"));
                break;
            case 147:
                av(intValue, (String) map.get("fileName"));
                break;
            case 148:
                tl(intValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                break;
            case Opcodes.FCMPL /* 149 */:
                r(intValue, ((Integer) map.get("versionCode")).intValue());
                break;
            case 150:
                i(intValue, (String) map.get("versionName"));
                break;
            case 151:
                j(intValue, new c.a().a((String) map.get("quickAppModelOpenUrl")).d((String) map.get("quickAppModelExtraData")).b());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                g(intValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                break;
            case 153:
                up(intValue, ((Integer) map.get("funnelType")).intValue());
                break;
            case 154:
                j(intValue, ae(map.get("downloadMarketInterceptor")));
                break;
            case 157:
                Object obj2 = map.get("s");
                if (obj2 instanceof Service) {
                    com.ss.android.socialbase.downloader.downloader.cw.j((Context) obj2);
                    break;
                }
                break;
            case 158:
                Object obj3 = map.get("i");
                map.get("c");
                if (obj3 instanceof Intent) {
                    Intent intent = (Intent) obj3;
                    if (TextUtils.equals(intent.getAction(), "com.csj.install")) {
                        j(intent);
                        break;
                    } else {
                        intent.setComponent(new ComponentName(com.ss.android.socialbase.downloader.downloader.cw.nd(), (Class<?>) DownloadHandlerService.class));
                        com.ss.android.socialbase.downloader.downloader.cw.nd().startService(intent);
                        break;
                    }
                }
                break;
            case 160:
                j(map);
                break;
            case 162:
                Object obj4 = map.get(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                if (obj4 instanceof TTAdInteractionListener) {
                    az.j((TTAdInteractionListener) obj4);
                    break;
                }
                break;
        }
        return null;
    }

    public a tl(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.A(z5);
    }

    private com.ss.android.j.j.cw.b cw(Object obj) {
        if (obj instanceof com.ss.android.j.j.cw.b) {
            return (com.ss.android.j.j.cw.b) obj;
        }
        return null;
    }

    private void cw(int i6, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get("linkMode")).intValue();
        int intValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean booleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean booleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int intValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean booleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        b.a k6 = new b.a().e(intValue).o(intValue2).h(booleanValue).p(booleanValue2).l(booleanValue3).b(intValue3).g(jSONObject).f(obj).n(booleanValue4).j(booleanValue5).a(booleanValue6).m(booleanValue7).d(booleanValue8).k(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.up.put(Integer.valueOf(i6), k6);
        this.f29956m.put(Integer.valueOf(i6), k6.i());
    }

    private e xt(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        return null;
    }

    private void xt(int i6, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        a.C0804a j6 = j(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.cw.put(Integer.valueOf(i6), j6);
        this.f29957r.put(Integer.valueOf(i6), j6.s());
    }

    public Object r(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return null;
        }
        return wo.ae();
    }

    public void r(int i6, String str) {
        qo(i6);
    }

    public void r(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.r(z5);
    }

    public void r(int i6, JSONObject jSONObject) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.q(jSONObject);
    }

    public boolean xt(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.cw();
    }

    public a r(int i6, int i7) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.E(i7);
    }

    public void xt(int i6, boolean z5) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.a(z5);
    }

    public boolean up(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.up();
    }

    public void xt(int i6, Object obj) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.b(obj);
    }

    public void up(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.H(str);
    }

    public void xt(int i6, JSONObject jSONObject) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.c(jSONObject);
    }

    public void up(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.I(z5);
    }

    public void xt(int i6, String str) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.a(str);
    }

    public a up(int i6, int i7) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.e(i7);
    }

    public void xt(int i6, int i7) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.j(i7);
    }

    public boolean cw(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return false;
        }
        return wo.r();
    }

    public void xt(int i6, long j6) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.G(j6);
    }

    public void cw(int i6, boolean z5) {
        b wo = wo(i6);
        if (this.f29956m == null) {
            return;
        }
        wo.xt(z5);
    }

    public a xt(int i6, List<String> list) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.F(list);
    }

    public void cw(int i6, JSONObject jSONObject) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.e(jSONObject);
    }

    public void cw(int i6, String str) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.j(str);
    }

    public a cw(int i6, long j6) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.f(j6);
    }

    public a cw(int i6, int i7) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.l(i7);
    }

    public void m(int i6, String str) {
        a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.h(str);
    }

    public a m(int i6, boolean z5) {
        a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.g(z5);
    }

    private void j(Intent intent) {
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean cw = uf.cw(this.xt, stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.xt.getSystemService("notification");
        com.bytedance.sdk.openadsdk.core.qv.up.j("notification", stringExtra, stringExtra2, cw ? "open" : "install", stringExtra3, "click_other", (String) null, (String) null);
        if (cw) {
            a.f.g(stringExtra3);
            notificationManager.cancel(ll(intExtra));
        } else {
            com.ss.android.socialbase.appdownloader.f.F(this.xt, intExtra);
            notificationManager.cancel(ll(intExtra));
        }
    }

    private void j(int i6, w2.r rVar) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.e(rVar);
    }

    private static boolean j(h hVar) {
        if (hVar == null) {
            return false;
        }
        if (TextUtils.equals("main", UMModuleRegister.INNER)) {
            return cw();
        }
        return true;
    }

    public void j(Bundle bundle) {
        az.j(this.xt);
        xt();
    }

    private a.C0804a j(long j6, String str, boolean z5, boolean z6, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z7, String str7, String str8, String str9) {
        a.C0804a m6 = new a.C0804a().I(j6).z(str).f(z5).v(z6).J(str2).q(jSONObject).C(true).r(true).m(new tj() { // from class: com.bytedance.sdk.openadsdk.core.qv.r.av.1
            @Override // com.ss.android.socialbase.downloader.r.tj
            public Uri j(String str10, String str11) {
                return av.this.j(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            m6.L(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            m6.g(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            m6.D(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            m6.a(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            m6.e(str6);
        }
        m6.E(z7);
        m6.l(j(j6, str7, str8, str9));
        return m6;
    }

    private void j(Map<String, Object> map) {
        Object apply;
        Function<SparseArray<Object>, Object> xt = xt();
        if (xt != null) {
            apply = xt.apply(com.bytedance.sdk.openadsdk.i.r.j().j(161).j(Map.class).j(0, map).xt());
            Map map2 = (Map) apply;
            if (map2 != null) {
                Notification notification = (Notification) map2.get("notification");
                NotificationManager notificationManager = (NotificationManager) v.getContext().getSystemService("notification");
                Object obj = map.get("install_download_id");
                notificationManager.notify(ll(obj != null ? ((Integer) obj).intValue() : 0), notification);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.utils.vl.r("xgc_dl", "false");
    }

    protected Map<String, Object> j(Object obj) {
        Object apply;
        HashMap hashMap = new HashMap();
        hashMap.put("params", obj);
        Function<SparseArray<Object>, Object> xt = xt();
        if (xt == null) {
            return null;
        }
        apply = xt.apply(com.bytedance.sdk.openadsdk.i.r.j().j(156).j(Map.class).j(0, hashMap).xt());
        return (Map) apply;
    }

    protected Uri j(String str, String str2) {
        Object apply;
        HashMap hashMap = new HashMap();
        hashMap.put("custom_authority", str);
        hashMap.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> xt = xt();
        if (xt == null) {
            return null;
        }
        apply = xt.apply(com.bytedance.sdk.openadsdk.i.r.j().j(155).j(Uri.class).j(0, hashMap).xt());
        return (Uri) apply;
    }

    private com.ss.android.j.j.up.f j(long j6, String str, String str2, String str3) {
        com.ss.android.j.j.up.f fVar = new com.ss.android.j.j.up.f();
        fVar.c(j6);
        fVar.g(str);
        fVar.a(str2);
        fVar.d(str3);
        return fVar;
    }

    private void j(int i6, String str, String str2, String str3) {
        a.C0804a ka = ka(i6);
        if (ka == null) {
            return;
        }
        this.f29957r.put(Integer.valueOf(i6), ka.z(str).a(str2).e(str3).s());
    }

    private void j(int i6, int i7, int i8, boolean z5, boolean z6, boolean z7) {
        b.a p5 = new b.a().e(i7).o(i8).h(true).p(false);
        this.up.put(Integer.valueOf(i6), p5);
        if (z5) {
            p5.m(z6);
            p5.d(z7);
        }
        this.f29956m.put(Integer.valueOf(i6), p5.i());
    }

    public int j(int i6) {
        b wo = wo(i6);
        if (wo == null) {
            return 0;
        }
        return wo.j();
    }

    public void j(int i6, int i7) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.xt(i7);
    }

    public void j(int i6, boolean z5) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.j(z5);
    }

    public void j(int i6, Object obj) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.c(obj);
    }

    public void j(int i6, JSONObject jSONObject) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        wo.d(jSONObject);
    }

    private void j(int i6, boolean z5, w2.r rVar) {
        b wo = wo(i6);
        if (wo == null) {
            return;
        }
        try {
            wo.e(rVar);
            wo.f(z5);
        } catch (Throwable unused) {
        }
    }

    public void j(int i6, String str) {
        com.ss.android.xt.j.j.c qo = qo(i6);
        if (qo == null) {
            return;
        }
        qo.d(str);
    }

    public void j(int i6, long j6) {
        com.ss.android.xt.j.j.a u5 = u(i6);
        if (u5 == null) {
            return;
        }
        u5.p(j6);
    }

    public com.ss.android.xt.j.j.a j(int i6, List<String> list) {
        com.ss.android.xt.j.j.a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.n(list);
    }

    public com.ss.android.xt.j.j.a j(int i6, Map<String, String> map) {
        com.ss.android.xt.j.j.a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.o(map);
    }

    public com.ss.android.xt.j.j.a j(int i6, com.ss.android.j.j.up.c cVar) {
        com.ss.android.xt.j.j.a u5 = u(i6);
        if (u5 == null) {
            return null;
        }
        return u5.m(cVar);
    }

    public PluginValueSet j() {
        return com.bykv.j.j.j.j.e.a().g(0, az.f29961j).f(1, Boolean.valueOf(az.xt)).e(10000, 3).k();
    }
}
