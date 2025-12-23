package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.umeng.analytics.pro.bi;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import w2.q;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<Activity> f37708a;

    class a implements a.e.InterfaceC0732a<Boolean, Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f37709a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37710b;

        a(long j6, long j7) {
            this.f37709a = j6;
            this.f37710b = j7;
        }

        @Override // com.ss.android.downloadlib.a.e.InterfaceC0732a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object j(Boolean bool) {
            if (bool.booleanValue()) {
                f.this.b(o.j.b(this.f37709a, this.f37710b));
                com.ss.android.downloadlib.addownload.compliance.a.f("lp_app_dialog_try_show", this.f37710b);
                return null;
            }
            f.this.i(this.f37710b);
            return null;
        }
    }

    class b implements a.e.InterfaceC0732a<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f37712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37713b;

        class a implements q {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean[] f37715a;

            @Override // w2.q
            public void j(String str) {
                boolean[] zArr = this.f37715a;
                b bVar = b.this;
                zArr[0] = f.this.d(bVar.f37712a, bVar.f37713b, str);
            }

            a(boolean[] zArr) {
                this.f37715a = zArr;
            }

            @Override // w2.q
            public void j(Throwable th) {
                com.ss.android.downloadlib.addownload.compliance.a.a(2, b.this.f37713b);
                this.f37715a[0] = false;
            }
        }

        @Override // com.ss.android.downloadlib.a.e.InterfaceC0732a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean j(String str) {
            boolean[] zArr = {false};
            m.B().j("GET", str, new HashMap(), new a(zArr));
            return Boolean.valueOf(zArr[0]);
        }

        b(long j6, long j7) {
            this.f37712a = j6;
            this.f37713b = j7;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static f f37717a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(long j6, long j7, String str) {
        long j8;
        Exception exc;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(WiseOpenHianalyticsData.UNION_PACKAGE);
            try {
                if (optJSONObject == null || optJSONObject.length() == 0) {
                    com.ss.android.downloadlib.addownload.compliance.a.a(7, j7);
                    return false;
                }
                o.j jVar = new o.j();
                jVar.f37965a = j6;
                jVar.f37966b = j7;
                jVar.f37968d = optJSONObject.optString("icon_url");
                jVar.f37969e = optJSONObject.optString("app_name");
                jVar.f37967c = optJSONObject.optString(bi.f40972o);
                jVar.f37970f = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                jVar.f37971g = optJSONObject.optString("developer_name");
                jVar.f37973i = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i6);
                            jVar.f37972h.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                        } catch (Exception e6) {
                            exc = e6;
                            j8 = j7;
                            com.ss.android.downloadlib.up.a.a().j(exc, "AdLpComplianceManager parseResponse");
                            com.ss.android.downloadlib.addownload.compliance.a.a(7, j8);
                            return false;
                        }
                    }
                }
                cw.j().j(jVar);
                r.j().j(jVar.a(), j7, jVar.f37968d);
                return true;
            } catch (Exception e7) {
                e = e7;
                exc = e;
                com.ss.android.downloadlib.up.a.a().j(exc, "AdLpComplianceManager parseResponse");
                com.ss.android.downloadlib.addownload.compliance.a.a(7, j8);
                return false;
            }
        } catch (Exception e8) {
            e = e8;
            j8 = j7;
        }
    }

    private f() {
    }

    public void c(Activity activity) {
        this.f37708a = new SoftReference<>(activity);
    }

    public boolean f(@NonNull o.i iVar) {
        long j6;
        long j7;
        if (TextUtils.isEmpty(iVar.f37961b.ch())) {
            com.ss.android.downloadlib.addownload.compliance.a.b(9, iVar);
            com.ss.android.downloadlib.up.a.a().c("requestAppInfo getLogExtra null");
            j7 = 0;
        } else {
            try {
                j6 = a.h.j(new JSONObject(iVar.f37961b.ch()), "convert_id");
            } catch (Exception e6) {
                vl.j(e6);
                j6 = 0;
            }
            if (j6 <= 0) {
                com.ss.android.downloadlib.addownload.compliance.a.b(3, iVar);
            }
            j7 = j6;
        }
        long j8 = iVar.f37960a;
        o.j j9 = cw.j().j(j7, j8);
        if (j9 != null) {
            r.j().j(j9.a(), j8, j9.f37968d);
            b(j9.a());
            com.ss.android.downloadlib.addownload.compliance.a.d("lp_app_dialog_try_show", iVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j7 > 0) {
            sb.append("convert_id=");
            sb.append(j7);
        }
        if (!TextUtils.isEmpty(iVar.f37961b.s())) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append("package_name=");
            sb.append(iVar.f37961b.s());
        }
        if (sb.length() <= 0) {
            com.ss.android.downloadlib.addownload.compliance.a.b(6, iVar);
            return false;
        }
        a.e.c(new b(j7, j8), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).b(new a(j7, j8)).d();
        return true;
    }

    public Activity h() {
        Activity activity = this.f37708a.get();
        this.f37708a = null;
        return activity;
    }

    public static f a() {
        return c.f37717a;
    }

    public void b(long j6) {
        TTDelegateActivity.e(j6);
    }

    public boolean g(com.ss.android.j.j.cw.b bVar) {
        String b6;
        if (!bVar.x() || m.f().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        if (bVar.l() == null) {
            b6 = null;
        } else {
            b6 = bVar.l().b();
        }
        if (TextUtils.isEmpty(b6) || Pattern.compile(m.f().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(b6).matches()) {
            return false;
        }
        return true;
    }

    public void i(long j6) {
        l c6 = com.ss.android.downloadlib.c.d().c(o.f.c().r(j6).f37961b.j());
        if (c6 != null) {
            c6.E(true, true);
        } else {
            com.ss.android.downloadlib.addownload.compliance.a.a(11, j6);
            com.ss.android.downloadlib.up.a.a().f("startDownload handler null");
        }
    }
}
