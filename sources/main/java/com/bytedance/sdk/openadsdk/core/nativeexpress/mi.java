package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi extends com.bytedance.sdk.component.adexpress.xt.j<BackupView> {
    private ThemeStatusBroadcastReceiver cw;

    /* renamed from: j, reason: collision with root package name */
    private BackupView f29686j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.jy f29687m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.xt.cw f29688r;
    private com.bytedance.sdk.component.adexpress.xt.ae up;
    private View xt;

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        com.bytedance.sdk.component.adexpress.xt.cw cwVar = this.f29688r;
        if (cwVar == null || !cwVar.j((NativeExpressView) this.xt, 0)) {
            this.up.j(107, (String) null);
            return;
        }
        this.f29687m.ae().oq();
        BackupView backupView = (BackupView) this.xt.findViewWithTag("tt_express_backup_fl_tag_26");
        this.f29686j = backupView;
        if (backupView == null) {
            this.up.j(107, (String) null);
            return;
        }
        backupView.setThemeChangeReceiver(this.cw);
        com.bytedance.sdk.component.adexpress.xt.ws wsVar = new com.bytedance.sdk.component.adexpress.xt.ws();
        BackupView backupView2 = this.f29686j;
        float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
        BackupView backupView3 = this.f29686j;
        float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
        wsVar.j(true);
        wsVar.j(realWidth);
        wsVar.xt(realHeight);
        this.up.j(this.f29686j, wsVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    public void j(com.bytedance.sdk.component.adexpress.xt.ae aeVar) {
        this.up = aeVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt();
        } else {
            com.bytedance.sdk.openadsdk.core.tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mi.1
                @Override // java.lang.Runnable
                public void run() {
                    mi.this.xt();
                }
            });
        }
    }

    public mi(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.xt.jy jyVar) {
        this.xt = view;
        this.cw = themeStatusBroadcastReceiver;
        this.f29687m = jyVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.r
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public BackupView ae() {
        return this.f29686j;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.j
    public void j(com.bytedance.sdk.component.adexpress.xt.cw cwVar) {
        this.f29688r = cwVar;
    }
}
