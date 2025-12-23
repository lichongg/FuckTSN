package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f37734a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f37735b;

    static /* synthetic */ class a {
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static g f37736a = new g(null);
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    private String a(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals(master.flame.danmaku.danmaku.parser.b.f50155b, scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.f37734a.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    private g() {
        this.f37734a = new ConcurrentHashMap<>();
        this.f37735b = new ConcurrentHashMap<>();
    }

    public void f(String str) {
        Iterator<Map.Entry<String, String>> it = this.f37735b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f37734a.remove(next.getKey());
            }
        }
    }

    public static g b() {
        return b.f37736a;
    }

    public String c(com.ss.android.j.j.cw.b bVar) {
        String a6 = a(bVar.j());
        if (a6 != null && !TextUtils.isEmpty(a6)) {
            String up = com.ss.android.socialbase.downloader.az.m.up(a6 + bVar.s());
            this.f37735b.put(bVar.j(), up);
            return up;
        }
        return null;
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str) || this.f37735b.isEmpty() || !this.f37735b.containsKey(str)) {
            return null;
        }
        String a6 = a(str);
        if (this.f37734a.containsValue(a6)) {
            for (Map.Entry<String, String> entry : this.f37734a.entrySet()) {
                if (TextUtils.equals(entry.getValue(), a6)) {
                    String str2 = this.f37735b.get(entry.getKey());
                    this.f37735b.put(str, str2);
                    if (!this.f37734a.containsKey(str)) {
                        this.f37734a.put(str, a6);
                    }
                    return str2;
                }
            }
        }
        return this.f37735b.get(str);
    }

    public void e(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !this.f37735b.containsKey(str2)) {
            this.f37735b.put(str2, str);
        }
    }
}
