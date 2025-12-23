package cn.jiguang.j;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.be.b;
import cn.jiguang.bz.k;
import com.stub.StubApp;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3057a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f3058b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3059c;

    /* renamed from: d, reason: collision with root package name */
    private int f3060d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3061e;

    /* renamed from: f, reason: collision with root package name */
    private DhcpInfo f3062f;

    /* renamed from: cn.jiguang.j.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.j.a$a, reason: collision with other inner class name */
    private static final class C0047a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f3063a = new a(null);
    }

    private a() {
    }

    public static a a() {
        return C0047a.f3063a;
    }

    private DhcpInfo b(Context context) {
        WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
        if (wifiManager == null) {
            f.c("JArp", "collect arp failed because get wifiManager failed");
            return this.f3062f;
        }
        int d6 = cn.jiguang.g.a.a().d(1600);
        if (d6 <= 0) {
            d6 = 600000;
        }
        if (!k.a("getDhcpInfo", d6, 3)) {
            try {
                this.f3062f = wifiManager.getDhcpInfo();
                f.c("JArp", "get dhcp by api, value is: " + this.f3062f.toString());
            } catch (Throwable unused) {
            }
        }
        return this.f3062f;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3057a = context;
        return "JArp";
    }

    @Override // cn.jiguang.m.a
    protected boolean a_() {
        if (this.f3059c) {
            return true;
        }
        return super.a_();
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        if (this.f3059c) {
            return true;
        }
        return super.b(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0138, code lost:
    
        if (android.text.TextUtils.equals(r9, "0.0.0.0") != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00f8, code lost:
    
        if (android.text.TextUtils.equals(r6, "0.0.0.0") != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018e, code lost:
    
        if (android.text.TextUtils.equals(r13, "0.0.0.0") != false) goto L89;
     */
    @Override // cn.jiguang.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void c(android.content.Context r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.j.a.c(android.content.Context, java.lang.String):void");
    }

    public void a(int i6) {
        this.f3060d = i6;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        cn.jiguang.bw.a.a().g(2084);
        this.f3059c = false;
        JSONObject jSONObject = this.f3058b;
        if (jSONObject == null) {
            f.c("JArp", "there are no data to report");
            cn.jiguang.bw.a.a().g(2069);
        } else {
            b.a(context, jSONObject, "mac_list");
            cn.jiguang.bw.a.a().g(2064);
            this.f3058b = null;
            super.d(context, str);
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<cn.jiguang.k.a> list) {
        try {
            if (this.f3058b == null) {
                this.f3058b = new JSONObject();
            }
            this.f3058b.put("ssid", str);
            this.f3058b.put("bssid", str2);
            this.f3058b.put(bi.S, str3);
            this.f3058b.put("local_mac", str4);
            this.f3058b.put("netmask", str5);
            this.f3058b.put("gateway", str8);
            this.f3058b.put("dhcp", str9);
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str6)) {
                jSONArray.put(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONArray.put(str7);
            }
            this.f3058b.put("dns", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cn.jiguang.k.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, aVar.f3064a);
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, aVar.f3067d);
                jSONArray2.put(jSONObject);
            }
            this.f3058b.put(SocialConstants.PARAM_SOURCE, this.f3060d);
            this.f3058b.put("data", jSONArray2);
        } catch (JSONException e6) {
            f.i("JArp", "packageJson exception: " + e6.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected void a(String str, JSONObject jSONObject) {
        if (jSONObject.optJSONObject("content").optBoolean("disable")) {
            return;
        }
        this.f3059c = true;
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (this.f3059c) {
            return true;
        }
        return super.a(context, str);
    }
}
