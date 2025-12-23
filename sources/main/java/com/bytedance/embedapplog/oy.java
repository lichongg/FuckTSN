package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.ki;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oy extends ki.j {

    /* renamed from: j, reason: collision with root package name */
    private volatile String f24029j = "";

    @Override // com.bytedance.embedapplog.ki
    public void j(int i6, long j6, boolean z5, float f6, double d6, String str) {
    }

    @Override // com.bytedance.embedapplog.ki
    public void j(int i6, Bundle bundle) {
        if (i6 != 0 || bundle == null) {
            return;
        }
        this.f24029j = bundle.getString("oa_id_flag");
    }

    public String xt() {
        return this.f24029j;
    }
}
