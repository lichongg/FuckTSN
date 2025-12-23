package com.bykv.vk.component.ttvideo.log;

import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public long f22913a = -2147483648L;

    /* renamed from: b, reason: collision with root package name */
    public long f22914b = -2147483648L;

    /* renamed from: c, reason: collision with root package name */
    public long f22915c = -2147483648L;

    /* renamed from: d, reason: collision with root package name */
    public long f22916d = -2147483648L;

    /* renamed from: e, reason: collision with root package name */
    public long f22917e = -2147483648L;

    /* renamed from: f, reason: collision with root package name */
    public long f22918f = -2147483648L;

    /* renamed from: g, reason: collision with root package name */
    public int f22919g = Integer.MIN_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public int f22920h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f22921i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f22922j = Integer.MIN_VALUE;

    /* renamed from: k, reason: collision with root package name */
    public String f22923k = "";

    /* renamed from: l, reason: collision with root package name */
    public String f22924l = "";

    /* renamed from: m, reason: collision with root package name */
    public int f22925m = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public String f22926n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f22927o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f22928p = "";

    public JSONObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        a(hashMap, "player_sessionid", this.f22926n);
        a(hashMap, "log_type", "video_playq");
        a(hashMap, "sdk_version", cVar.f22890e);
        a(hashMap, "sv", cVar.f22889d);
        a(hashMap, t.f36163x, cVar.f22888c);
        a(hashMap, "pt", this.f22915c);
        a(hashMap, "vt", this.f22916d);
        a(hashMap, "et", this.f22917e);
        a(hashMap, "lt", this.f22918f);
        a((Map) hashMap, "bc", this.f22919g);
        a((Map) hashMap, "br", this.f22920h);
        a((Map) hashMap, "vd", cVar.f22893h);
        a(hashMap, "initial_url", this.f22923k);
        a(hashMap, "init_audio_url", this.f22924l);
        a((Map) hashMap, "watch_dur", this.f22925m);
        a((Map) hashMap, "errt", this.f22921i);
        a((Map) hashMap, "errc", this.f22922j);
        a(hashMap, "ps_t", this.f22913a);
        a(hashMap, "pt_new", this.f22914b);
        a(hashMap, "play_log_id", this.f22927o);
        a(hashMap, "last_sessionid", this.f22928p);
        return new JSONObject(hashMap);
    }

    public static void a(Map map, String str, int i6) {
        if (i6 != Integer.MIN_VALUE) {
            map.put(str, Integer.valueOf(i6));
        }
    }

    public static void a(Map map, String str, long j6) {
        if (j6 != -2147483648L) {
            map.put(str, Long.valueOf(j6));
        }
    }

    public static void a(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }
}
