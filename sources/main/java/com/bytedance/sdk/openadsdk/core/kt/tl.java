package com.bytedance.sdk.openadsdk.core.kt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.tl;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements com.bytedance.sdk.component.tl.j.m {

    /* renamed from: j, reason: collision with root package name */
    public static final tl f29349j = new tl();
    private volatile SQLiteDatabase xt;

    @Override // com.bytedance.sdk.component.tl.j.m
    public String cw() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public SQLiteDatabase j(Context context) {
        if (this.xt == null) {
            synchronized (tl.class) {
                try {
                    if (this.xt == null) {
                        tl.cw j6 = com.bytedance.sdk.openadsdk.core.ae.j(v.getContext()).j();
                        j6.j();
                        this.xt = j6.xt();
                    }
                } finally {
                }
            }
        }
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String m() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String r() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String up() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String xt() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String j() {
        return "loghighpriority";
    }
}
