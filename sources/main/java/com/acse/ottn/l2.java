package com.acse.ottn;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l2 {

    /* renamed from: a, reason: collision with root package name */
    public static l2 f4730a;

    /* renamed from: b, reason: collision with root package name */
    public static Activity f4731b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4732a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f4733b;

        public a(String str, c cVar) {
            this.f4732a = str;
            this.f4733b = cVar;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            c2.a("MobclickAgentUtil", "统计发送成功 ==" + this.f4732a);
            if ("heart_beat".equals(this.f4732a)) {
                JSONObject jSONObject = new JSONObject(str);
                k0.f4669e = true;
                j3.a().b("appHeartbeat", r0.d().a());
                j3.a().b(LiteEncryptUtils.KEY_AES, jSONObject.getString(LiteEncryptUtils.KEY_AES));
                j3.a().b("show_ad_activity", str);
                c2.a("MobclickAgentUtilsamon", "s= ==" + str);
                j3.a().b("ocr_screen_scroll", jSONObject.getString("ocr_screen_scroll"));
                j3.a().b("statistic_view", jSONObject.getString("statistic_view"));
                j3.a().b("applet_data", jSONObject.getString("local_toast_info"));
                j3.a().a("local_toast_status", jSONObject.getInt("local_toast_status"));
                j3.a().b("view_gather", jSONObject.getString("view_gather"));
                j3.a().b("popup_state", jSONObject.getString("popup_state"));
                l2.this.c();
                d.d().f4346r = false;
                if (jSONObject.getString("app_list").equals("1")) {
                    j3.a().a("click_state", Boolean.TRUE);
                    try {
                        if (!"honor".equals(j4.b())) {
                            n.c().b();
                        }
                    } catch (Throwable unused) {
                    }
                }
                c cVar = this.f4733b;
                if (cVar != null) {
                    cVar.a();
                }
                c2.a("MobclickAgentUtil", "appStatistics s= " + str);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.a("MobclickAgentUtil", "统计发送失败 throwable =" + th.getMessage());
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a();
    }

    public static l2 b() {
        if (f4730a == null) {
            synchronized (l2.class) {
                try {
                    if (f4730a == null) {
                        f4730a = new l2();
                    }
                } finally {
                }
            }
        }
        return f4730a;
    }

    public void a(Activity activity) {
        f4731b = activity;
    }

    public void a(String str) {
        if (j3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, null, null);
    }

    public final Object e() throws ObjectStreamException {
        return f4730a;
    }

    public static boolean d() {
        if (!c3.a().d()) {
            return true;
        }
        if (com.acse.ottn.b.c().e() && com.acse.ottn.b.c().a() && x4.a().b(k0.f4687w)) {
            return true;
        }
        return false;
    }

    public void c() {
        int i6;
        String string;
        int i7 = 0;
        j3.a().a("accession_size", 0);
        try {
            i6 = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e6) {
            c2.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e6.getMessage());
            i6 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i6 == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().contains(".service.ShopHelperService")) {
                    i7++;
                    j3.a().a("accession_size", i7);
                }
            }
        }
    }

    public static Map<String, String> a(String str, String str2) {
        if (j3.a() == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put("open_all_permission", d() ? "1" : "0");
        treeMap.put("flow_permission", com.acse.ottn.b.c().a() ? "1" : "0");
        treeMap.put("accessiblity_permission", com.acse.ottn.b.c().e() ? "1" : "0");
        treeMap.put("battery_permission", x4.a().b(k0.f4687w) ? "1" : "0");
        treeMap.put("statistics_type", str);
        treeMap.put("mobile_id", j4.o());
        if ("heart_beat".equals(str)) {
            treeMap.put("is_snt", "3");
        } else {
            treeMap.put("is_snt", "0");
        }
        if (!TextUtils.isEmpty(str2)) {
            treeMap.put("accessiblity_list", str2);
        }
        treeMap.put("maven_version", e0.f4495f);
        treeMap.put("mobile", j4.b());
        treeMap.put("mobile_version_release", k0.f4689y);
        treeMap.put("app_versione", k0.f4688x);
        treeMap.put("app_system_model", j4.d());
        treeMap.put("time", System.currentTimeMillis() + "");
        treeMap.put("system_model", j4.p());
        treeMap.put("new_version", k0.f4675k);
        return treeMap;
    }

    public void b(String str, String str2) {
        if (j3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, str2, null);
    }

    public void b(String str, String str2, c cVar) {
        if (j3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, str2, cVar);
    }

    public final void a(String str, String str2, c cVar) {
        c2.a("MobclickAgentUtil", "埋点");
        if (j3.a() == null) {
            return;
        }
        new f0().a(s0.a().a(a(str, str2), str)).w5(Schedulers.newThread()).I3(h.a()).u5(new a(str, cVar), new b());
    }

    public void a() {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) HelpShopAppUtil.getContext().getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String str = accessibilityServiceInfo.getResolveInfo().serviceInfo.name;
            String str2 = accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName;
            arrayList.add("应用名称：" + accessibilityServiceInfo.getResolveInfo().loadLabel(HelpShopAppUtil.getContext().getPackageManager()).toString() + "--->app包名：" + str2 + "---->service路径：" + str);
        }
        b().b("accessiblity_list", JSON.toJSONString(arrayList));
    }
}
