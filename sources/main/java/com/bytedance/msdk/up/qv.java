package com.bytedance.msdk.up;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv implements com.bytedance.sdk.component.tl.j.m {

    /* renamed from: j, reason: collision with root package name */
    public static final qv f25309j = new qv();
    private volatile SQLiteDatabase xt;

    @Override // com.bytedance.sdk.component.tl.j.m
    public String j() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String m() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String r() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String up() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String cw() {
        return "adevent_applog";
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public SQLiteDatabase j(Context context) {
        if (this.xt == null) {
            synchronized (this) {
                try {
                    if (this.xt == null) {
                        this.xt = com.bytedance.msdk.up.j.m.j(context).j().j();
                        com.bytedance.msdk.j.up.cw.j("---------------DB CREATE  SUCCESS new------------");
                    }
                } finally {
                }
            }
        }
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public String xt() {
        return "adevent";
    }
}
