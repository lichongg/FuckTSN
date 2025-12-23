package com.bytedance.msdk.tl.cw.j.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.wq.j.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.multipro.j f25210j = new com.bytedance.sdk.openadsdk.core.multipro.j(new com.bytedance.sdk.component.tl.xt.xt.xt.j("csj_mediation"));
    private r.j xt;

    private r.j j(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "uri is error3");
            return null;
        }
        if (this.xt == null) {
            cw cwVar = new cw();
            this.xt = cwVar;
            cwVar.init();
        }
        if (str.equals(this.xt.getTableName())) {
            return this.xt;
        }
        if (str.equals(this.f25210j.getTableName())) {
            return this.f25210j;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "uri is error4");
        return null;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        r.j j6 = j(uri);
        if (j6 != null) {
            return j6.delete(uri, str, strArr);
        }
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        r.j j6 = j(uri);
        if (j6 != null) {
            return j6.getType(uri);
        }
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        r.j j6 = j(uri);
        if (j6 != null) {
            return j6.insert(uri, contentValues);
        }
        return null;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        r.j j6 = j(uri);
        if (j6 != null) {
            return j6.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        r.j j6 = j(uri);
        if (j6 != null) {
            return j6.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
