package com.bykv.vk.openvk.component.video.j.j.xt;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.up.j;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, xt> f22993j = new ConcurrentHashMap<>();

    public static synchronized void j(Context context, r rVar, j.InterfaceC0307j interfaceC0307j) {
        synchronized (cw.class) {
            if (rVar == null) {
                com.bykv.vk.openvk.component.video.api.m.cw.j(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                ConcurrentHashMap<String, xt> concurrentHashMap = f22993j;
                xt xtVar = concurrentHashMap.get(rVar.i());
                if (xtVar == null) {
                    xtVar = new xt(context, rVar);
                    concurrentHashMap.put(rVar.i(), xtVar);
                    rVar.m();
                    rVar.i();
                }
                xtVar.j(interfaceC0307j);
            }
            rVar.m();
            rVar.i();
        }
    }

    public static synchronized void j(r rVar) {
        synchronized (cw.class) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    xt remove = f22993j.remove(rVar.i());
                    if (remove != null) {
                        remove.j(true);
                    }
                    rVar.m();
                    rVar.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
