package com.acse.ottn;

import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.model.WxClickDataModel;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static s0 f5080a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f5081b = "s0";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, int i6, String str2, String str3);
    }

    public static s0 a() {
        if (f5080a == null) {
            synchronized (s0.class) {
                try {
                    if (f5080a == null) {
                        f5080a = new s0();
                    }
                } finally {
                }
            }
        }
        return f5080a;
    }

    public boolean b(List<String> list) {
        if (list == null || list.size() == 0) {
            c2.a(f5081b, "getPrice lists = null");
            return false;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6) != null && (list.get(i6).contains("￥") || list.get(i6).contains("¥"))) {
                return true;
            }
        }
        return false;
    }

    public final Object c() throws ObjectStreamException {
        return f5080a;
    }

    public boolean d(List<String> list) {
        if (list == null || list.size() == 0) {
            c2.a(f5081b, "getPrice lists = null");
            return false;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6) != null && list.get(i6).replace("0", "").length() > 17) {
                return true;
            }
        }
        return false;
    }

    public boolean h(String str) {
        AdPackageModel b6;
        try {
            if (j3.a() != null && (b6 = a().b()) != null) {
                for (int i6 = 0; i6 < b6.getKeywords_names().size(); i6++) {
                    if (str.toLowerCase().contains(b6.getKeywords_names().get(i6))) {
                        return true;
                    }
                }
            }
        } catch (Exception e6) {
            c2.a(f5081b, "isAccordType Exception e =" + e6.getMessage());
        }
        return false;
    }

    public boolean i(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (Character.isDigit(str.charAt(i6))) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str, int i6) {
        return str.split("，").length < i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: Exception -> 0x0025, all -> 0x0060, TRY_LEAVE, TryCatch #1 {Exception -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x001c, B:10:0x0028, B:14:0x0037), top: B:2:0x0004, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String g(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "com.taobao.tao.welcome.Welcome"
            java.lang.String r1 = "tag_homepage_info"
            com.acse.ottn.j3 r2 = com.acse.ottn.j3.a()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            if (r2 == 0) goto L60
            com.acse.ottn.j3 r2 = com.acse.ottn.j3.a()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            java.lang.String r2 = r2.e(r1)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            java.util.Map r2 = com.acse.ottn.v1.b(r2)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            boolean r3 = r5.equals(r0)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            if (r3 != 0) goto L27
            java.lang.String r3 = "com.taobao.tao.TBMainActivity"
            boolean r3 = r5.equals(r3)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            if (r3 == 0) goto L28
            goto L27
        L25:
            r5 = move-exception
            goto L46
        L27:
            r5 = r0
        L28:
            java.lang.Object r0 = r2.get(r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            if (r3 == 0) goto L37
            java.lang.String r5 = ""
            return r5
        L37:
            r2.remove(r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            com.acse.ottn.j3 r5 = com.acse.ottn.j3.a()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r2)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            r5.b(r1, r2)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L60
            return r0
        L46:
            java.lang.String r0 = com.acse.ottn.s0.f5081b     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r1.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "getShowAdActivityPackageName Exception e ="
            r1.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L60
            r1.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L60
            com.acse.ottn.c2.a(r0, r5)     // Catch: java.lang.Throwable -> L60
        L60:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.s0.g(java.lang.String):java.lang.String");
    }

    public String j(String str) {
        String str2;
        String str3 = str + "pic_type";
        c2.a(f5081b + "--samon", "isShowBigPicture ");
        if (str3.equals(n.c().f4858l)) {
            str3 = n.c().J;
        }
        c2.a(f5081b + "--samon", "pageName= " + str3);
        if (j3.a() != null) {
            c2.a(f5081b + "--samon", "QuickPreference.getInstance() is not null= ");
            str2 = j3.a().e(str3);
        } else {
            str2 = "";
        }
        c2.a(f5081b + "--samon", "pageName= " + str2);
        ShowWindowModel showWindowModel = (TextUtils.isEmpty(str2) || str2 == null) ? new ShowWindowModel() : (ShowWindowModel) JSON.parseObject(str2, ShowWindowModel.class);
        showWindowModel.setAppName(str3);
        String a6 = r0.d().a();
        c2.a(f5081b + "--samon", "date= " + a6);
        c2.a(f5081b + "--samon", "label.getShowBigWindowData()= " + showWindowModel.getShowBigWindowData());
        return !showWindowModel.getShowBigWindowData().equals(a6) ? "1" : "0";
    }

    public WxClickDataModel e(String str) {
        try {
            if (j3.a() != null) {
                String e6 = j3.a().e("applet_data");
                c2.a(f5081b, "getShowWxAppletData applet_data =" + e6);
                return c(v1.b(e6).get(str));
            }
            c2.a(f5081b, "getShowWxAppletData adPackageModel is null ");
            return null;
        } catch (Exception e7) {
            c2.a(f5081b, "getShowWxAppletData Exception e =" + e7.getMessage());
            return null;
        }
    }

    public void f(String str) {
        c2.a("samon-->", str.length() + "b");
    }

    public String c(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6) != null) {
                    stringBuffer.append(list.get(i6));
                    stringBuffer.append(",");
                }
            }
            return stringBuffer.toString();
        }
        c2.a(f5081b, " getTbTitle lists = null");
        return "";
    }

    public int b(int i6) {
        if (AcseHelpManager.mIsDebug) {
            c2.a(f5081b, "setReadTime is debug");
            return i6;
        }
        c2.a(f5081b, "setReadTime is release");
        return i6;
    }

    public PageSettingTypeModel d(String str) {
        try {
            if (j3.a() != null) {
                AdPackageModel b6 = a().b();
                if (b6 != null) {
                    c2.a(f5081b, "getShowAdActivityPackageName adPackageModel is not null ");
                    j3.a().b("read_timeout", b6.getRead_timeout());
                    j3.a().a("delay_read_time", b6.getDelay_readpage_time());
                    if (TextUtils.isEmpty(b6.getNew_package_setting())) {
                        c2.a(f5081b, "getShowAdActivityPackageName getNew_package_setting is not null ");
                        return null;
                    }
                    c2.a(f5081b, "getShowAdActivityPackageName =" + v1.b(b6.getNew_package_setting()));
                    return b(v1.b(b6.getNew_package_setting()).get(str));
                }
                c2.a(f5081b, "getShowAdActivityPackageName adPackageModel is null ");
            }
        } catch (Exception e6) {
            c2.a(f5081b, "getShowAdActivityPackageName Exception e =" + e6.getMessage());
        }
        return null;
    }

    public boolean a(List<String> list, int i6) {
        if (list != null && list.size() != 0) {
            if (!d(list)) {
                return false;
            }
            for (int i7 = 0; i7 < list.size(); i7++) {
                if (list.get(i7) != null && (list.get(i7).trim().contains("￥") || list.get(i7).trim().contains("¥"))) {
                    return list.size() >= i6;
                }
            }
            return false;
        }
        c2.a(f5081b, "judgeData lists = null");
        return false;
    }

    public PageSettingTypeModel b(String str) {
        c2.a(f5081b, "getCurrentPageSettingData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PageSettingTypeModel) JSON.parseObject(str, PageSettingTypeModel.class);
    }

    public AdPackageModel b() {
        if (j3.a() == null) {
            c2.a(f5081b, "parserHeardBeatData samon parserHeardBeatData is null");
            return new AdPackageModel();
        }
        String e6 = j3.a().e("show_ad_activity");
        if (TextUtils.isEmpty(e6)) {
            c2.a(f5081b, "show_ad_activity = null");
            return new AdPackageModel();
        }
        c2.a(f5081b, "show_ad_activity = " + e6);
        AdPackageModel adPackageModel = (AdPackageModel) JSON.parseObject(e6, AdPackageModel.class);
        if (adPackageModel == null) {
            return new AdPackageModel();
        }
        c2.a(f5081b, "adPackageModel = " + adPackageModel.toString());
        return adPackageModel;
    }

    public WxClickDataModel c(String str) {
        c2.a(f5081b, "getCurrentWxAppletData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (WxClickDataModel) JSON.parseObject(str, WxClickDataModel.class);
    }

    public RequestBody a(Map map, String str) {
        String jSONString = JSON.toJSONString(map);
        c2.a(f5081b, "内容  getTitle=" + jSONString);
        c2.a(m3.f4828e, "samon importantData =" + jSONString);
        TreeMap treeMap = new TreeMap();
        if ("heart_beat".equals(str)) {
            treeMap.put("heart_beat", "1");
            String replaceAll = f.a().b(jSONString, true).replaceAll("\\n", "");
            treeMap.put("sdk_version", k0.f4676l);
            treeMap.put("content", replaceAll);
            String jSONString2 = JSON.toJSONString(treeMap);
            c2.a(m3.f4828e, "samon all request data = " + jSONString2);
            return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString2);
        }
        String replaceAll2 = f.a().b(jSONString, false).replaceAll("\\n", "");
        if (TextUtils.isEmpty(k0.a(false))) {
            return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString);
        }
        treeMap.put("sdk_version", k0.f4676l);
        treeMap.put("content", replaceAll2);
        String jSONString3 = JSON.toJSONString(treeMap);
        c2.a(m3.f4828e, "samon all request data = " + jSONString3);
        return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString3);
    }

    public boolean b(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("月销") || str.contains("已售") || str.matches("[1-9]\\d*\\.?\\d*") || str.contains("￥") || str.contains("¥")) {
            return true;
        }
        if (str.length() > i6 || a(str)) {
            return c(str, 2);
        }
        return false;
    }

    public int a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return i6;
        }
        int length = str.length();
        return length < 2048 ? length + i6 : length;
    }

    public boolean a(int i6) {
        if (i6 <= 8192) {
            return true;
        }
        j3.a().b("scroll_state", k0.f4680p);
        return false;
    }

    public final boolean a(String str) {
        return str.matches(".*\\d+.*");
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6) != null && (list.get(i6).contains(master.flame.danmaku.danmaku.parser.b.f50155b) || !list.get(i6).contains("匿名") || list.get(i6).length() > 17)) {
                    return true;
                }
            }
            return false;
        }
        c2.a(f5081b, "getGoodsTitle lists = null");
        return false;
    }

    public void a(List<String> list, List<String> list2, a aVar) {
        if (list2.size() == 0 || list.size() == 0) {
            return;
        }
        for (int i6 = 0; i6 < list2.size(); i6++) {
            String[] split = list2.get(i6).split("\\|");
            if (split.length < 0) {
                return;
            }
            for (int i7 = 0; i7 < list.size(); i7++) {
                if (!TextUtils.isEmpty(split[0]) && list.get(i7).contains(split[0])) {
                    if (split[1].equals("0")) {
                        aVar.a(split[1], Integer.parseInt(split[2]), "", "");
                        return;
                    }
                    if (split[1].equals("1")) {
                        aVar.a(split[1], Integer.parseInt(split[2]), list.get(i7), "");
                        return;
                    }
                    if (split[1].equals("2")) {
                        aVar.a(split[1], Integer.parseInt(split[2]), "", "");
                        return;
                    }
                    if (split[1].equals("3")) {
                        aVar.a(split[1], Integer.parseInt(split[2]), split[3], split[4]);
                        return;
                    } else if (split[1].equals("4")) {
                        aVar.a(split[1], Integer.parseInt(split[2]), split[3], split[4]);
                        return;
                    } else if (split[1].equals("5")) {
                        aVar.a(split[1], 0, "", "");
                        return;
                    }
                }
            }
        }
    }

    public boolean a(List<String> list, String str, String str2) {
        boolean z5 = false;
        boolean z6 = false;
        for (String str3 : list) {
            if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                z5 = true;
            }
            if (!TextUtils.isEmpty(str3) && str2.equals(str3)) {
                z6 = true;
            }
        }
        return z5 && z6;
    }

    public void a(String str, WxClickDataModel wxClickDataModel) {
        try {
            if (j3.a() != null) {
                String e6 = j3.a().e("applet_data");
                c2.a(f5081b, "changeHeartAppletData applet_data =" + e6);
                if (TextUtils.isEmpty(e6)) {
                    return;
                }
                Map<String, String> b6 = v1.b(e6);
                if (wxClickDataModel.getToast_times() == 0) {
                    b6.remove(str);
                } else {
                    b6.put(str, JSON.toJSONString(wxClickDataModel));
                }
                j3.a().b("applet_data", JSON.toJSONString(b6));
            }
            c2.a(f5081b, "changeHeartAppletData adPackageModel is null ");
        } catch (Exception e7) {
            c2.a(f5081b, "changeHeartAppletData Exception e =" + e7.getMessage());
        }
    }
}
