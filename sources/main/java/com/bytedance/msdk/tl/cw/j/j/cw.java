package com.bytedance.msdk.tl.cw.j.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.tl.j.j f25209j;

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.msdk.tl.j.j jVar = this.f25209j;
        if (jVar == null) {
            return 0;
        }
        jVar.xt(str, strArr);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.msdk.tl.j.j jVar = this.f25209j;
        if (jVar == null) {
            return null;
        }
        jVar.j(contentValues);
        return uri;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, @Nullable String str, @Nullable String[] strArr2, String str2) {
        com.bytedance.msdk.tl.j.j jVar = this.f25209j;
        if (jVar != null) {
            return jVar.j(str, strArr2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
        if (com.bytedance.msdk.core.xt.getContext() != null) {
            this.f25209j = new com.bytedance.msdk.tl.j.j(com.bytedance.msdk.core.xt.getContext());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
    }
}
