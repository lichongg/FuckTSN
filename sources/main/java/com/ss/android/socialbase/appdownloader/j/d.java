package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d implements k {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f38464a;

    /* renamed from: b, reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.jy.j f38465b;

    /* renamed from: c, reason: collision with root package name */
    protected final String f38466c;

    public boolean a() {
        if (this.f38464a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                vl.cw("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return xt().resolveActivity(this.f38464a.getPackageManager()) != null;
    }

    public d(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str) {
        this.f38464a = context;
        this.f38465b = jVar;
        this.f38466c = str;
    }
}
