package com.bykv.vk.openvk.component.video.j.xt.j;

import android.content.Context;
import com.bykv.vk.openvk.component.video.j.xt.r;
import com.bykv.vk.openvk.component.video.j.xt.up;
import com.bytedance.sdk.component.oq.g;
import java.io.File;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends j {

    /* renamed from: j, reason: collision with root package name */
    public final File f23068j;

    public void j() {
        com.bykv.vk.openvk.component.video.j.cw.j.j(new g("clear") { // from class: com.bykv.vk.openvk.component.video.j.xt.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                xt.this.xt();
            }
        });
    }

    File up(String str) {
        return new File(this.f23068j, str);
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public File cw(String str) {
        return up(str);
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public File r(String str) {
        return up(str);
    }

    public void xt() {
        r.cw().r();
        Context context = up.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.j.xt.xt.cw.j(context).j(1);
        }
        for (File file : this.f23068j.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }
}
