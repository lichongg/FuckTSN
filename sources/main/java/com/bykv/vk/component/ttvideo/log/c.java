package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import com.kuaishou.weapon.p0.t;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public a f22886a;

    /* renamed from: b, reason: collision with root package name */
    public String f22887b;

    /* renamed from: g, reason: collision with root package name */
    public String f22892g;

    /* renamed from: c, reason: collision with root package name */
    public String f22888c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f22889d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f22890e = "";

    /* renamed from: h, reason: collision with root package name */
    public int f22893h = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public String f22891f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    public void a() {
        b();
    }

    public void b() {
        Map versionInfo;
        a aVar = this.f22886a;
        if (aVar == null || (versionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.f22888c = (String) versionInfo.get(t.f36163x);
        this.f22889d = (String) versionInfo.get("sv");
        this.f22890e = (String) versionInfo.get("sdk_version");
    }

    public void a(String str) {
        this.f22887b = str;
        this.f22891f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b(String str) {
    }

    c(a aVar, Context context) {
        this.f22886a = aVar;
    }
}
