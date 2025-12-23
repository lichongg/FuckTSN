package com.bytedance.msdk.tl.cw.j.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f25211j;
    private j xt = new j();

    public static xt j() {
        if (f25211j == null) {
            synchronized (xt.class) {
                try {
                    if (f25211j == null) {
                        f25211j = new xt();
                    }
                } finally {
                }
            }
        }
        return f25211j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        return this.xt.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        return this.xt.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.xt.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.xt.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.xt.update(uri, contentValues, str, strArr);
    }

    private xt() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
    }
}
