package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.xt.xt.j f29575j;

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.j();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            jVar.j(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.tl.xt.xt.xt.j jVar = this.f29575j;
        if (jVar != null) {
            return jVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    public j(com.bytedance.sdk.component.tl.xt.xt.xt.j jVar) {
        this.f29575j = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }
}
