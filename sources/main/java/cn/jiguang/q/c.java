package cn.jiguang.q;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.j;
import cn.jiguang.bz.l;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.h.e;
import cn.jiguang.internal.JConstants;
import cn.jiguang.m.c;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.http.HttpConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static final String f3184h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f3185i;

    /* renamed from: j, reason: collision with root package name */
    private static LinkedList<String> f3186j;

    /* renamed from: c, reason: collision with root package name */
    private Context f3187c;

    /* renamed from: d, reason: collision with root package name */
    private int f3188d;

    /* renamed from: e, reason: collision with root package name */
    private String f3189e;

    /* renamed from: f, reason: collision with root package name */
    private String f3190f;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3182b = l.b(new byte[]{107, 125, 122, 116, 111, 70, 112, 100, 115, 78, 93, 68, HttpConstants.COMMA});

    /* renamed from: a, reason: collision with root package name */
    public static String f3181a = "";

    /* renamed from: g, reason: collision with root package name */
    private static final Object f3183g = new Object();

    private class a implements Callable<Integer> {

        /* renamed from: b, reason: collision with root package name */
        private Context f3195b;

        public a(Context context) {
            this.f3195b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            c.this.b(this.f3195b);
            return 0;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f3196a = new c();
    }

    private c() {
        this.f3188d = 0;
        this.f3189e = "";
        this.f3190f = "";
    }

    private int a(Context context, String str) {
        synchronized (f3183g) {
            try {
                if (TextUtils.isEmpty(str)) {
                    f.c("JDataConfigManager", "[refreshConfig] data config is null");
                } else {
                    try {
                        String str2 = new String(v.a(str, c.a.f3104h, c.a.f3105i), "UTF-8");
                        a("JDataConfigManager", "serverConfig:" + str2);
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
                        if (optInt == 2000) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                cn.jiguang.g.a.a().c();
                                int optInt2 = optJSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                                this.f3189e = optJSONObject.optString("sign");
                                if (optInt2 == 0) {
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("rt");
                                    if (optJSONArray != null) {
                                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                            String optString2 = optJSONArray.optString(i6);
                                            if (!TextUtils.isEmpty(optString2)) {
                                                String[] split = optString2.split("-");
                                                cn.jiguang.g.a.a().f2948b.add(new String[]{split[0], split[1]});
                                            }
                                        }
                                    }
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(bi.aC);
                                    if (optJSONArray2 != null) {
                                        for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i7);
                                            if (optJSONObject2 != null) {
                                                cn.jiguang.q.a aVar = new cn.jiguang.q.a();
                                                aVar.a(true);
                                                aVar.a(optJSONObject2.optInt("ci"));
                                                aVar.b(optJSONObject2.optInt("sc"));
                                                aVar.c(optJSONObject2.optInt("rp"));
                                                aVar.e(optJSONObject2.optInt("bc"));
                                                aVar.d(optJSONObject2.optInt("sr"));
                                                aVar.f(optJSONObject2.optInt("br"));
                                                aVar.g(optJSONObject2.optInt("bg"));
                                                aVar.h(optJSONObject2.optInt(LiveConfigKey.MEDIUM));
                                                cn.jiguang.g.a.a().a(aVar);
                                            }
                                        }
                                    }
                                } else {
                                    f.c("JDataConfigManager", "parse data config , config status is no");
                                }
                                JSONObject optJSONObject3 = optJSONObject.optJSONObject("in_app");
                                if (optJSONObject3 != null) {
                                    String optString3 = optJSONObject3.optString(f3182b);
                                    f.c("JDataConfigManager", "recv inapp file hash: " + optString3);
                                    if (!TextUtils.isEmpty(optString3) && !"null".equals(optString3) && JConstants.SDK_VERSION_INT > 284) {
                                        cn.jiguang.bi.b.a().a(context, IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM, 0, optString3);
                                    }
                                }
                                a(context, optJSONObject.optJSONObject(JThirdPlatFormInterface.KEY_EXTRA));
                            }
                        } else {
                            f.c("JDataConfigManager", "[refreshConfig] data config code:" + optInt + " msg:" + optString);
                        }
                        return optInt;
                    } catch (Throwable th) {
                        f.i("JDataConfigManager", "[refreshConfig] refreshConfig failed, errMsg: " + th.getMessage());
                    }
                }
                return 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static c b() {
        return b.f3196a;
    }

    static {
        String b6 = l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 126, SignedBytes.MAX_POWER_OF_TWO, 24, 115, 108, 99});
        f3184h = b6;
        String b7 = l.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 103, 102, 41, 90, 68, 108});
        f3185i = b7;
        LinkedList<String> linkedList = new LinkedList<>();
        f3186j = linkedList;
        linkedList.clear();
        f3186j.add(b6);
        f3186j.add(b7);
    }

    public Integer a() {
        return null;
    }

    public synchronized void b(Context context) {
        if (this.f3188d >= 3) {
            f.c("JDataConfigManager", "try more than 3 times,won't try again");
            cn.jiguang.m.b.e(context, "JDataConfigManager");
            this.f3188d = 0;
            return;
        }
        if (cn.jiguang.m.b.a(context, "JDataConfigManager")) {
            c(context);
            String a6 = a(this.f3189e);
            if (TextUtils.isEmpty(a6)) {
                this.f3188d++;
            } else {
                if (a(context, a6) == 2000) {
                    j.a("bac.catch", a6);
                }
                cn.jiguang.m.b.e(context, "JDataConfigManager");
                this.f3188d = 0;
            }
        } else {
            c(context);
        }
    }

    public void c(Context context) {
        synchronized (f3183g) {
            try {
                if (TextUtils.isEmpty(this.f3189e)) {
                    String e6 = j.e("bac.catch");
                    if (!TextUtils.isEmpty(e6)) {
                        a(context, e6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String a(String str) {
        String a6;
        try {
            a6 = cn.jiguang.ba.a.a(this.f3187c);
        } catch (Throwable th) {
            f.i("JDataConfigManager", "request data config exception:" + th.getMessage());
        }
        if (TextUtils.isEmpty(a6)) {
            f.i("JDataConfigManager", "request data config failed because can't get appKey");
            return null;
        }
        w.a(this.f3187c, f3186j);
        Iterator<String> it = f3186j.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, a6);
            jSONObject.put("p", "a");
            jSONObject.put("av", "4");
            jSONObject.put("sign", str);
            String m6 = cn.jiguang.d.a.m(this.f3187c);
            if (TextUtils.isEmpty(m6)) {
                m6 = "";
            }
            jSONObject.put("file_version", m6);
            jSONObject.put("manufacturer", cn.jiguang.bz.a.a().B(this.f3187c));
            jSONObject.put("rom", cn.jiguang.u.e.a(this.f3187c));
            jSONObject.put(bn.f10753i, cn.jiguang.bz.a.a().y(this.f3187c));
            String num = Integer.toString(Build.VERSION.SDK_INT);
            jSONObject.put("osversion", num);
            if (!TextUtils.isEmpty(num) && !num.equalsIgnoreCase((String) cn.jiguang.e.b.a(this.f3187c, cn.jiguang.e.a.aK()))) {
                cn.jiguang.v.d.a().a(this.f3187c, num);
            }
            String D = cn.jiguang.bz.a.a().D(this.f3187c);
            if (!TextUtils.isEmpty(D)) {
                jSONObject.put("android_ver", D);
            }
            String str2 = cn.jiguang.a.a.f1444b;
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("jcore_ver", str2);
            }
            String b6 = cn.jiguang.bi.b.a().b(0);
            if (!TextUtils.isEmpty(b6)) {
                jSONObject.put("jpush_ver", b6);
            }
            jSONObject.put("pb_sign", this.f3190f);
            f.c("JDataConfigManager", "url:" + next + ", param json:" + jSONObject.toString());
            HttpRequest httpRequest = new HttpRequest(next);
            httpRequest.setRequestProperty("Content-Type", "text/plain");
            httpRequest.setRequestProperty("Accept", "application/json");
            httpRequest.setRequestProperty("Charset", "UTF-8");
            String a7 = v.a(jSONObject.toString().getBytes(), c.a.f3104h, c.a.f3105i);
            f.c("JDataConfigManager", "encryptStr:" + a7 + ", paramJson: " + jSONObject);
            httpRequest.setBody(a7);
            HttpResponse httpPost = HttpUtils.httpPost(this.f3187c, httpRequest);
            int responseCode = httpPost.getResponseCode();
            f.c("JDataConfigManager", "responseCode:" + responseCode);
            String responseBody = httpPost.getResponseBody();
            f.c("JDataConfigManager", "request data config code:" + responseCode + ", body:" + responseBody);
            if (200 == responseCode && !TextUtils.isEmpty(responseBody)) {
                f.c("JDataConfigManager", "request data config success");
                return responseBody;
            }
        }
        return null;
    }

    private void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            f.c("JDataConfigManager", "it can't process probe list, because no extra data");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("pb");
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString("pb_sign"))) {
            f.c("JDataConfigManager", "it can't process probe list, because no pb data");
            return;
        }
        this.f3190f = optJSONObject.optString("pb_sign");
        String optString = optJSONObject.optString("list");
        if (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) {
            optString = "";
        }
        if (!TextUtils.isEmpty(optString)) {
            cn.jiguang.h.e.a().f(context, optString);
        }
        e.a b6 = cn.jiguang.h.e.a().b();
        if (b6 != null && TextUtils.equals(this.f3190f, b6.c())) {
            optString = cn.jiguang.h.e.a().b(context);
            f.c("JDataConfigManager", "probe list not change, use cache list data");
        }
        f.c("JDataConfigManager", "probe list : " + optString);
        cn.jiguang.h.e.a().a(new e.a().b(this.f3190f).a(optString).a(optJSONObject.optInt(IAdInterListener.AdReqParam.AP, 1) != 0));
    }

    public void a(Context context) {
        if (context == null) {
            f.i("JDataConfigManager", "updateImmediately failed: context is null");
            return;
        }
        if (!cn.jiguang.m.b.a(context, "JDataConfigManager")) {
            cn.jiguang.m.b.a(context, "JDataConfigManager", 0L);
            f.c("JDataConfigManager", "Reset business time for immediate update");
        }
        a(context, (cn.jiguang.q.b) null);
    }

    public void a(Context context, int i6) {
        try {
            this.f3187c = context;
            FutureTask futureTask = new FutureTask(new a(context));
            cn.jiguang.be.b.b(futureTask);
            futureTask.get(i6, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            f.c("JDataConfigManager", "requestConfigSync timeout");
        }
    }

    public void a(final Context context, final cn.jiguang.q.b bVar) {
        this.f3187c = context;
        cn.jiguang.be.b.b(new cn.jiguang.by.b() { // from class: cn.jiguang.q.c.1
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    c.this.b(context);
                } catch (Throwable th) {
                    f.c("JDataConfigManager", "request config error:" + th);
                }
                cn.jiguang.q.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        });
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            f.c("JDataConfigManager", "it can't process extra list, because no extra data");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("al");
        if (optJSONObject != null) {
            cn.jiguang.common.app.helper.b.f2885c = optJSONObject.optInt("priority", cn.jiguang.common.app.helper.b.f2884b);
        }
        b(context, jSONObject);
    }

    public static void a(String str, String str2) {
        int length = 4000 - str.length();
        while (str2.length() > length) {
            f.c(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        f.c(str, str2);
    }

    public static void a(LinkedList<String> linkedList) {
        if (!c.a.f3097a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        f.c("JDataConfigManager", "setTestUrls use data url :" + linkedList);
        f3186j.clear();
        f3186j.addAll(linkedList);
    }
}
