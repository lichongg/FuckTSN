package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.acse.ottn.j3;
import com.acse.ottn.r0;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HomeKeyReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final String f5063a = MediationConstant.KEY_REASON;

    /* renamed from: b, reason: collision with root package name */
    public final String f5064b = "recentapps";

    /* renamed from: c, reason: collision with root package name */
    public final String f5065c = "homekey";

    /* renamed from: d, reason: collision with root package name */
    public boolean f5066d = false;

    /* renamed from: e, reason: collision with root package name */
    public Handler f5067e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    public Runnable f5068f = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeKeyReceiver.this.f5066d = false;
        }
    }

    public final void a(Context context, String str, String str2) {
    }

    public final void a(Context context) {
        if ((j3.a() == null && j3.a().a("setting_day")) || this.f5066d) {
            return;
        }
        this.f5066d = true;
        this.f5067e.postDelayed(this.f5068f, 3000L);
        String a6 = r0.d().a();
        String e6 = j3.a().e("am_show_seed_dialog");
        String e7 = j3.a().e("pm_show_seed_dialog");
        int b6 = r0.d().b();
        if (b6 >= 1400) {
            if (a6.equals(e7) || b6 < 1400 || b6 >= 2100) {
                return;
            }
            a(context, "pm_show_seed_dialog", a6);
            return;
        }
        if (a6.equals(e6) || b6 < 800 || b6 >= 1400) {
            return;
        }
        a(context, "am_show_seed_dialog", a6);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) != null) {
            if (stringExtra.equals("homekey")) {
                a(context);
            } else if (!stringExtra.equals("recentapps")) {
                a(context);
            }
        }
    }
}
