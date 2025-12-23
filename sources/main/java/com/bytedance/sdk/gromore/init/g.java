package com.bytedance.sdk.gromore.init;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private r.j f27336j;
    private r.j xt = com.bytedance.msdk.tl.cw.j.j.xt.j();

    private boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            return false;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        r.j jVar = this.f27336j;
        if (jVar != null) {
            jVar.injectContext(context);
        }
        r.j jVar2 = this.xt;
        if (jVar2 != null) {
            jVar2.injectContext(context);
        }
    }

    public g(r.j jVar) {
        this.f27336j = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        if (j(uri)) {
            return this.xt.delete(uri, str, strArr);
        }
        return this.f27336j.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        r.j jVar;
        if (j(uri)) {
            jVar = this.xt;
        } else {
            jVar = this.f27336j;
        }
        return jVar.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (j(uri)) {
            return this.xt.insert(uri, contentValues);
        }
        return this.f27336j.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (j(uri)) {
            return this.xt.query(uri, strArr, str, strArr2, str2);
        }
        return this.f27336j.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (j(uri)) {
            return this.xt.update(uri, contentValues, str, strArr);
        }
        return this.f27336j.update(uri, contentValues, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }
}
