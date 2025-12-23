package com.bykv.vk.openvk.component.video.j.xt;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bykv.vk.openvk.component.video.j.xt.j.cw;
import com.stub.StubApp;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {

    /* renamed from: g, reason: collision with root package name */
    public static volatile Integer f23102g;

    /* renamed from: j, reason: collision with root package name */
    static volatile com.bykv.vk.openvk.component.video.j.xt.j.xt f23103j;

    /* renamed from: m, reason: collision with root package name */
    static volatile boolean f23104m;
    private static volatile com.bykv.vk.openvk.component.video.j.xt.xt.cw oq;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context qv;

    /* renamed from: r, reason: collision with root package name */
    public static volatile boolean f23105r;
    static volatile com.bykv.vk.openvk.component.video.j.xt.j.cw xt;
    public static final boolean cw = com.bytedance.sdk.component.utils.vl.cw();
    static volatile boolean up = true;
    static volatile int ae = 0;
    public static volatile int tl = 3;

    public static void j(boolean z5) {
        up = z5;
    }

    public static void xt(boolean z5) {
        f23104m = z5;
    }

    public static Context getContext() {
        return qv;
    }

    public static void j(int i6) {
        ae = i6;
    }

    public static com.bykv.vk.openvk.component.video.j.xt.j.xt xt() {
        return f23103j;
    }

    public static void j(com.bykv.vk.openvk.component.video.j.xt.j.cw cwVar, Context context) {
        if (cwVar != null && context != null) {
            qv = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (xt != null) {
                return;
            }
            com.bykv.vk.openvk.component.video.j.xt.j.xt xtVar = f23103j;
            if (xtVar != null && xtVar.f23068j.getAbsolutePath().equals(cwVar.f23058j.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            xt = cwVar;
            oq = com.bykv.vk.openvk.component.video.j.xt.xt.cw.j(context);
            xt.j(new cw.j() { // from class: com.bykv.vk.openvk.component.video.j.xt.up.1
                @Override // com.bykv.vk.openvk.component.video.j.xt.j.cw.j
                public void j(String str) {
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.j.xt.j.cw.j
                public void j(Set<String> set) {
                    up.oq.j(set, 0);
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                    }
                }
            });
            m j6 = m.j();
            j6.j(cwVar);
            j6.j(oq);
            r cw2 = r.cw();
            cw2.j(cwVar);
            cw2.j(oq);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }

    public static com.bykv.vk.openvk.component.video.j.xt.j.cw j() {
        return xt;
    }
}
