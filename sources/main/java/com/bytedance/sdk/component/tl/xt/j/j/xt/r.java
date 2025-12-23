package com.bytedance.sdk.component.tl.xt.j.j.xt;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends m {
    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.m
    public byte cw() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.m, com.bytedance.sdk.component.tl.xt.j.j.xt.xt
    public String j() {
        com.bytedance.sdk.component.tl.j.m xt = ((m) this).xt.xt();
        if (xt != null) {
            return xt.j();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.m
    public byte xt() {
        return (byte) 1;
    }

    public static String cw(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    public static String xt(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public r(Context context, com.bytedance.sdk.component.tl.xt.r.xt.j jVar, com.bytedance.sdk.component.tl.j.up upVar) {
        super(context, jVar, upVar);
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.j.xt.m, com.bytedance.sdk.component.tl.xt.j.j
    public boolean j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return com.bytedance.sdk.component.tl.xt.cw.j.j(xtVar);
    }
}
