package com.bytedance.sdk.component.tl.xt.j.j.j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.tl.j.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements m {

    /* renamed from: j, reason: collision with root package name */
    public static final xt f26768j = new xt();
    private volatile SQLiteDatabase xt;

    @Override // com.bytedance.sdk.component.tl.j.m
    public String cw() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.m
    public SQLiteDatabase j(Context context) {
        if (this.xt == null) {
            synchronized (this) {
                try {
                    if (this.xt == null) {
                        this.xt = new j(context, this).getWritableDatabase();
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
