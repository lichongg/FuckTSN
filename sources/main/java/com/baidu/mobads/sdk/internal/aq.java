package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.api.PromoteInstallManager;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10626a = z.f11223m;

    /* renamed from: b, reason: collision with root package name */
    private static final String f10627b = "__sdk_remote_dl_no_install";

    /* renamed from: c, reason: collision with root package name */
    private static final long f10628c = 3600000;

    /* renamed from: d, reason: collision with root package name */
    private Context f10629d;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f10630e;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferences.Editor f10631f;

    /* renamed from: g, reason: collision with root package name */
    private au f10632g;

    /* renamed from: h, reason: collision with root package name */
    private PromoteInstallManager.PromoteInstallListener f10633h;

    /* renamed from: i, reason: collision with root package name */
    private int f10634i;

    /* renamed from: j, reason: collision with root package name */
    private long f10635j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final aq f10636a = new aq(null);

        private a() {
        }
    }

    /* synthetic */ aq(ar arVar) {
        this();
    }

    public static aq a(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        a.f10636a.b(context, promoteInstallListener);
        return a.f10636a;
    }

    private void b(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.f10629d = context;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f10627b, 0);
        this.f10630e = sharedPreferences;
        this.f10631f = sharedPreferences.edit();
        this.f10632g = au.a(context, f10626a);
        this.f10633h = promoteInstallListener;
    }

    private aq() {
        this.f10634i = 0;
        this.f10635j = 0L;
    }

    public int c() {
        Object b6 = this.f10632g.b(null, "getInstallPopType", new Object[0]);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a() {
        Map<String, ?> all;
        List<String> a6;
        try {
            all = this.f10630e.getAll();
            a6 = a((Map<String, Long>) all);
        } catch (Throwable unused) {
        }
        if (a6 == null) {
            return false;
        }
        for (int i6 = 0; i6 < a6.size(); i6++) {
            String str = a6.get(i6);
            Object b6 = this.f10632g.b(null, "getAdDownLoadInfo", this.f10629d, str);
            if ((b6 instanceof JSONObject) && ((JSONObject) b6).length() > 0) {
                Long l6 = (Long) all.get(str);
                if (a((JSONObject) b6) && System.currentTimeMillis() - l6.longValue() < 3600000 && !bv.a(this.f10629d, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b() {
        Object b6 = this.f10632g.b(null, "isInstallPopSwitch", new Object[0]);
        if (b6 instanceof Boolean) {
            return ((Boolean) b6).booleanValue();
        }
        return false;
    }

    private List<String> a(Map<String, Long> map) {
        if (map != null && map.size() > 0) {
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new ar(this));
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it.next()).getKey());
            }
            if (map.get(arrayList2.get(0)).longValue() > this.f10635j || this.f10634i < 3) {
                return arrayList2;
            }
            PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.f10633h;
            if (promoteInstallListener != null) {
                promoteInstallListener.onFail("暂无可用物料，请稍后再试");
            }
            return null;
        }
        PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.f10633h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onFail("暂无可用物料，请稍后再试");
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        r3 = new com.baidu.mobads.sdk.internal.ap(r7, r16.f10629d, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (r17 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        r0 = new org.json.JSONObject(r7.toString());
        r0.put("install_ts", r8);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0080, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo a(boolean r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = 0
            android.content.SharedPreferences r0 = r1.f10630e     // Catch: java.lang.Throwable -> Ld0
            java.util.Map r0 = r0.getAll()     // Catch: java.lang.Throwable -> Ld0
            java.util.List r3 = r1.a(r0)     // Catch: java.lang.Throwable -> Ld0
            if (r3 != 0) goto L10
            return r2
        L10:
            r4 = 0
            r5 = 0
        L12:
            int r6 = r3.size()     // Catch: java.lang.Throwable -> Ld0
            if (r5 >= r6) goto Ld1
            java.lang.Object r6 = r3.get(r5)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Ld0
            com.baidu.mobads.sdk.internal.au r7 = r1.f10632g     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r8 = "getAdDownLoadInfo"
            android.content.Context r9 = r1.f10629d     // Catch: java.lang.Throwable -> Ld0
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> Ld0
            r11[r4] = r9     // Catch: java.lang.Throwable -> Ld0
            r9 = 1
            r11[r9] = r6     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r7 = r7.b(r2, r8, r11)     // Catch: java.lang.Throwable -> Ld0
            boolean r8 = r7 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Ld0
            if (r8 == 0) goto Lc2
            r8 = r7
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Throwable -> Ld0
            int r8 = r8.length()     // Catch: java.lang.Throwable -> Ld0
            if (r8 <= 0) goto Lc2
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r8 = r0.get(r6)     // Catch: java.lang.Throwable -> Ld0
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> Ld0
            boolean r11 = r1.a(r7)     // Catch: java.lang.Throwable -> Ld0
            if (r11 == 0) goto Lb7
            long r11 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld0
            long r13 = r8.longValue()     // Catch: java.lang.Throwable -> Ld0
            long r11 = r11 - r13
            r13 = 3600000(0x36ee80, double:1.7786363E-317)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto Lb7
            android.content.Context r11 = r1.f10629d     // Catch: java.lang.Throwable -> Ld0
            boolean r11 = com.baidu.mobads.sdk.internal.bv.a(r11, r6)     // Catch: java.lang.Throwable -> Ld0
            if (r11 == 0) goto L64
            goto Lb7
        L64:
            com.baidu.mobads.sdk.internal.ap r3 = new com.baidu.mobads.sdk.internal.ap     // Catch: java.lang.Throwable -> Ld0
            android.content.Context r0 = r1.f10629d     // Catch: java.lang.Throwable -> Ld0
            r3.<init>(r7, r0, r1)     // Catch: java.lang.Throwable -> Ld0
            if (r17 == 0) goto L97
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L80 org.json.JSONException -> L83
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L80 org.json.JSONException -> L83
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L80 org.json.JSONException -> L83
            java.lang.String r5 = "install_ts"
            r0.put(r5, r8)     // Catch: java.lang.Throwable -> L80 org.json.JSONException -> L83
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L80 org.json.JSONException -> L83
            goto L88
        L80:
            r2 = r3
            goto Ld1
        L83:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L80
            r0 = r2
        L88:
            com.baidu.mobads.sdk.internal.au r5 = r1.f10632g     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = "startInstallDialogActivity"
            android.content.Context r11 = r1.f10629d     // Catch: java.lang.Throwable -> L80
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L80
            r10[r4] = r11     // Catch: java.lang.Throwable -> L80
            r10[r9] = r0     // Catch: java.lang.Throwable -> L80
            r5.b(r2, r7, r10)     // Catch: java.lang.Throwable -> L80
        L97:
            int r0 = r1.f10634i     // Catch: java.lang.Throwable -> L80
            int r0 = r0 + r9
            r1.f10634i = r0     // Catch: java.lang.Throwable -> L80
            r2 = 3
            if (r0 > r2) goto La5
            long r4 = r8.longValue()     // Catch: java.lang.Throwable -> L80
            r1.f10635j = r4     // Catch: java.lang.Throwable -> L80
        La5:
            android.content.SharedPreferences$Editor r0 = r1.f10631f     // Catch: java.lang.Throwable -> L80
            r0.remove(r6)     // Catch: java.lang.Throwable -> L80
            android.content.SharedPreferences$Editor r0 = r1.f10631f     // Catch: java.lang.Throwable -> L80
            r0.commit()     // Catch: java.lang.Throwable -> L80
            com.baidu.mobads.sdk.api.PromoteInstallManager$PromoteInstallListener r0 = r1.f10633h     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto Lb6
            r0.onSuccess()     // Catch: java.lang.Throwable -> L80
        Lb6:
            return r3
        Lb7:
            android.content.SharedPreferences$Editor r7 = r1.f10631f     // Catch: java.lang.Throwable -> Ld0
            r7.remove(r6)     // Catch: java.lang.Throwable -> Ld0
            android.content.SharedPreferences$Editor r6 = r1.f10631f     // Catch: java.lang.Throwable -> Ld0
            r6.commit()     // Catch: java.lang.Throwable -> Ld0
            goto Lcc
        Lc2:
            android.content.SharedPreferences$Editor r7 = r1.f10631f     // Catch: java.lang.Throwable -> Ld0
            r7.remove(r6)     // Catch: java.lang.Throwable -> Ld0
            android.content.SharedPreferences$Editor r6 = r1.f10631f     // Catch: java.lang.Throwable -> Ld0
            r6.commit()     // Catch: java.lang.Throwable -> Ld0
        Lcc:
            int r5 = r5 + 1
            goto L12
        Ld0:
        Ld1:
            com.baidu.mobads.sdk.api.PromoteInstallManager$PromoteInstallListener r0 = r1.f10633h
            if (r0 == 0) goto Lda
            java.lang.String r3 = "暂无可用物料，请稍后再试"
            r0.onFail(r3)
        Lda:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.a(boolean):com.baidu.mobads.sdk.api.IPromoteInstallAdInfo");
    }

    private boolean a(JSONObject jSONObject) {
        File file = new File(jSONObject.optString("folder") + jSONObject.optString("filename"));
        return file.exists() && file.length() > 0;
    }

    public void a(Context context, String str) {
        this.f10632g.b(null, "handleAdInstall", context, str);
    }
}
