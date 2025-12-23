package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.ki;

/* loaded from: D:\Downloads\app\classes3.dex */
public class yl extends ki.j {

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f24108j = false;

    @Override // com.bytedance.embedapplog.ki
    public void j(int i6, long j6, boolean z5, float f6, double d6, String str) {
    }

    @Override // com.bytedance.embedapplog.ki
    public void j(int i6, Bundle bundle) {
        if (i6 != 0 || bundle == null) {
            return;
        }
        this.f24108j = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean xt() {
        return this.f24108j;
    }
}
