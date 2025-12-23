package cn.jiguang.r;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3224a;

    /* renamed from: b, reason: collision with root package name */
    private String f3225b;

    /* renamed from: c, reason: collision with root package name */
    private String f3226c;

    /* renamed from: d, reason: collision with root package name */
    private String f3227d;

    /* renamed from: e, reason: collision with root package name */
    private cn.jiguang.ak.b f3228e;

    /* renamed from: cn.jiguang.r.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f3229a = new g(null);
    }

    private g() {
        this.f3225b = "";
        this.f3226c = "";
        this.f3227d = "";
        this.f3228e = null;
    }

    public static g a() {
        return a.f3229a;
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return true;
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3224a = context;
        return "JDeviceMac";
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            return super.a(context, str);
        }
        cn.jiguang.bb.f.c("JDeviceMac", "it need not business, because os version less than 29, current is " + i6);
        return false;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        cn.jiguang.ak.b bVar;
        if (cn.jiguang.g.a.a().e(2700)) {
            String b6 = cn.jiguang.bz.a.a().b(context, "", false);
            cn.jiguang.bb.f.c("JDeviceMac", "get mac: " + b6);
            if (TextUtils.isEmpty(b6)) {
                cn.jiguang.bb.f.c("JDeviceMac", "l mac is empty");
                return;
            }
            if (TextUtils.equals(this.f3225b, b6)) {
                cn.jiguang.bb.f.c("JDeviceMac", "last mac is same as l mac, mac: " + b6);
                return;
            }
            List<cn.jiguang.ak.b> b7 = cn.jiguang.aj.a.a().b(context, Integer.MAX_VALUE);
            if (b7 == null) {
                cn.jiguang.bb.f.c("JDeviceMac", "it need not report, because wifi info is null");
                return;
            }
            Iterator<cn.jiguang.ak.b> it = b7.iterator();
            cn.jiguang.ak.b bVar2 = null;
            while (true) {
                if (it.hasNext()) {
                    bVar = it.next();
                    if (TextUtils.equals(bVar.f1558c, "connect")) {
                        cn.jiguang.bb.f.c("JDeviceMac", "connect wifi: " + bVar.toString());
                        break;
                    }
                    if (TextUtils.equals(bVar.f1558c, "strongest")) {
                        cn.jiguang.bb.f.c("JDeviceMac", "strongest wifi: " + bVar.toString());
                        bVar2 = bVar;
                    }
                } else {
                    bVar = null;
                    break;
                }
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f1557b) && !TextUtils.equals(bVar.f1557b, "<unknown ssid>") && !TextUtils.equals(bVar.f1557b, "unknownssid")) {
                cn.jiguang.bb.f.f("JDeviceMac", "use connect wifi, ssid: " + bVar.f1557b);
                this.f3228e = bVar;
            } else if (bVar2 != null && !TextUtils.isEmpty(bVar2.f1557b) && !TextUtils.equals(bVar2.f1557b, "<unknown ssid>") && !TextUtils.equals(bVar2.f1557b, "unknownssid")) {
                cn.jiguang.bb.f.f("JDeviceMac", "use strongest wifi, ssid: " + bVar2.f1557b);
                this.f3228e = bVar2;
            }
            super.c(context, str);
            if (this.f3228e != null) {
                if (!TextUtils.isEmpty(this.f3227d) && TextUtils.equals(this.f3227d, this.f3228e.f1557b)) {
                    cn.jiguang.bb.f.c("JDeviceMac", "ssid not update, drop it, ssid: " + this.f3228e.f1557b);
                    this.f3228e = null;
                    return;
                }
                this.f3226c = b6;
            }
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (!cn.jiguang.g.a.a().e(1600)) {
            return;
        }
        if (this.f3228e != null && !TextUtils.isEmpty(this.f3226c)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("itime", cn.jiguang.d.b.b(context));
                jSONObject.put("type", "ssid_mac_info");
                jSONObject.put(CommonNetImpl.TAG, this.f3228e.f1558c);
                jSONObject.put("l_mac_address", this.f3226c);
                jSONObject.put("ssid", this.f3228e.f1557b);
                cn.jiguang.bd.f.a(context, jSONObject);
                this.f3227d = this.f3228e.f1557b;
                this.f3225b = this.f3226c;
                this.f3228e = null;
                this.f3226c = "";
                super.d(context, str);
                return;
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JDeviceMac", "ssid mac report failed, " + th.getMessage());
                return;
            }
        }
        cn.jiguang.bb.f.c("JDeviceMac", "it need not report, because no wifi info or mac, mac: " + this.f3226c);
    }
}
