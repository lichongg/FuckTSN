package com.bytedance.sdk.openadsdk.p;

import a1.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.openadsdk.ITTProvider;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements ITTProvider {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31810j;

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        Object apply;
        if (this.f31810j != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -7999906);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            apply = this.f31810j.apply(sparseArray);
            Integer num = (Integer) apply;
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        Object apply;
        if (this.f31810j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -7999901);
        sparseArray.put(-99999985, String.class);
        apply = this.f31810j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        Object apply;
        if (this.f31810j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -7999903);
        sparseArray.put(-99999985, String.class);
        sparseArray.put(-7999921, uri);
        apply = this.f31810j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
        if (this.f31810j != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -7999902);
            sparseArray.put(-99999985, Void.class);
            this.f31810j.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        if (this.f31810j != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -7999900);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-7999920, context);
            this.f31810j.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        Object apply;
        if (this.f31810j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -7999905);
        sparseArray.put(-99999985, Uri.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, contentValues);
        apply = this.f31810j.apply(sparseArray);
        return (Uri) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object apply;
        if (this.f31810j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -7999904);
        sparseArray.put(-99999985, Cursor.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, strArr);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr2);
        sparseArray.put(-7999925, str2);
        apply = this.f31810j.apply(sparseArray);
        return (Cursor) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Object apply;
        if (this.f31810j != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -7999907);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999922, contentValues);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            apply = this.f31810j.apply(sparseArray);
            Integer num = (Integer) apply;
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    public j(Object obj) {
        if (f.a(obj)) {
            this.f31810j = b.a(obj);
        }
    }
}
