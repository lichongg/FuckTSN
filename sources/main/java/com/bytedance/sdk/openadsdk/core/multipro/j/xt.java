package com.bytedance.sdk.openadsdk.core.multipro.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ae;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private Context f29576j;

    private Context getContext() {
        Context context = this.f29576j;
        return context == null ? v.getContext() : context;
    }

    private boolean j(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        this.f29576j = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        String[] split;
        if (!j(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            if ("ttopensdk.db".equals(str2)) {
                return ae.j(getContext()).j().delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        String[] split;
        if (!j(uri) && (split = uri.getPath().split("/")) != null && split.length >= 5) {
            String str = split[2];
            String str2 = split[4];
            if ("ttopensdk.db".equals(str)) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        ae.j(getContext()).j().j(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    ae.j(getContext()).j().cw();
                } else if ("transactionSetSuccess".equals(str2)) {
                    ae.j(getContext()).j().r();
                } else if ("transactionEnd".equals(str2)) {
                    ae.j(getContext()).j().up();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        String[] split;
        if (!j(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str = split[2];
            String str2 = split[3];
            if ("ttopensdk.db".equals(str)) {
                ae.j(getContext()).j().insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] split;
        if (!j(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str3 = split[2];
            String str4 = split[3];
            if ("ttopensdk.db".equals(str3)) {
                return ae.j(getContext()).j().query(str4, strArr, str, strArr2, null, null, str2);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String[] split;
        if (!j(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            if ("ttopensdk.db".equals(str2)) {
                return ae.j(getContext()).j().update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }
}
