package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.oq;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements a.p.InterfaceC0739a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f37726c = "e";

    /* renamed from: d, reason: collision with root package name */
    private static e f37727d;

    /* renamed from: a, reason: collision with root package name */
    private a.p f37728a = new a.p(Looper.getMainLooper(), this);

    /* renamed from: b, reason: collision with root package name */
    private long f37729b;

    public static e a() {
        if (f37727d == null) {
            synchronized (e.class) {
                try {
                    if (f37727d == null) {
                        f37727d = new e();
                    }
                } finally {
                }
            }
        }
        return f37727d;
    }

    public void c(@NonNull cw cwVar, long j6, long j7, String str, String str2, String str3, String str4) {
        int i6;
        o.e eVar = new o.e(cwVar.ae(), j6, j7, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.m.e.j() || com.ss.android.socialbase.appdownloader.m.e.u()) && oq.j(m.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.az.m.j(cwVar.vm().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f37728a.obtainMessage(200, eVar);
                obtainMessage.arg1 = 2;
                this.f37728a.sendMessageDelayed(obtainMessage, r13.j("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.xt.j.xt.b q5 = o.f.c().q(eVar.f37936b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i6 = 5;
            } catch (Exception unused) {
                i6 = -1;
            }
            m.x().j(null, new com.ss.android.socialbase.downloader.up.j(i6, jSONObject.toString()), i6);
            com.ss.android.downloadlib.r.b.a().p("embeded_ad", "ah_result", jSONObject, q5);
        }
        if (a.n.e()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f37729b;
            long p5 = a.n.p();
            if (currentTimeMillis < a.n.s()) {
                long s5 = a.n.s() - currentTimeMillis;
                p5 += s5;
                this.f37729b = System.currentTimeMillis() + s5;
            } else {
                this.f37729b = System.currentTimeMillis();
            }
            a.p pVar = this.f37728a;
            pVar.sendMessageDelayed(pVar.obtainMessage(200, eVar), p5);
        }
    }

    @Override // com.ss.android.downloadlib.a.p.InterfaceC0739a
    public void j(Message message) {
        if (message.what != 200) {
            return;
        }
        b((o.e) message.obj, message.arg1);
    }

    private e() {
    }

    private void b(o.e eVar, int i6) {
        int i7;
        if (m.G() == null || m.G().j() || eVar == null) {
            return;
        }
        if (2 == i6) {
            com.ss.android.xt.j.xt.b q5 = o.f.c().q(eVar.f37936b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (a.h.G(m.getContext(), eVar.f37938d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i7 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i7 = 5;
                }
            } catch (Exception unused) {
                i7 = -1;
            }
            m.x().j(null, new com.ss.android.socialbase.downloader.up.j(i7, jSONObject.toString()), i7);
            com.ss.android.downloadlib.r.b.a().p("embeded_ad", "ah_result", jSONObject, q5);
        }
        if (a.h.G(m.getContext(), eVar.f37938d)) {
            com.ss.android.downloadlib.r.b.a().v("delayinstall_installed", eVar.f37936b);
            return;
        }
        if (!a.h.A(eVar.f37941g)) {
            com.ss.android.downloadlib.r.b.a().v("delayinstall_file_lost", eVar.f37936b);
        } else if (com.ss.android.downloadlib.addownload.j.b.a().i(eVar.f37938d)) {
            com.ss.android.downloadlib.r.b.a().v("delayinstall_conflict_with_back_dialog", eVar.f37936b);
        } else {
            com.ss.android.downloadlib.r.b.a().v("delayinstall_install_start", eVar.f37936b);
            com.ss.android.socialbase.appdownloader.f.F(m.getContext(), (int) eVar.f37935a);
        }
    }
}
