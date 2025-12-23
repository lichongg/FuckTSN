package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq.j.r;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements r.j {
    private static List<r.j> cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile m f29577j;
    private static WeakReference<Context> xt;

    public static m j(Context context) {
        if (context != null) {
            xt = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (f29577j == null) {
            synchronized (m.class) {
                try {
                    if (f29577j == null) {
                        f29577j = new m();
                    }
                } finally {
                }
            }
        }
        return f29577j;
    }

    private boolean xt(Uri uri) {
        return true;
    }

    static {
        List<r.j> synchronizedList = Collections.synchronizedList(new ArrayList());
        cw = synchronizedList;
        synchronizedList.add(new cw());
        cw.add(new com.bytedance.sdk.openadsdk.core.multipro.j.xt());
        cw.add(new com.bytedance.sdk.openadsdk.core.multipro.cw.j());
        cw.add(new j(new com.bytedance.sdk.component.tl.xt.xt.xt.j("csj")));
        Iterator<r.j> it = cw.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    private Context getContext() {
        WeakReference<Context> weakReference = xt;
        return (weakReference == null || weakReference.get() == null) ? v.getContext() : xt.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        Iterator<r.j> it = cw.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    private m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            r.j j6 = j(uri);
            if (j6 != null) {
                return j6.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        try {
            r.j j6 = j(uri);
            if (j6 != null) {
                return j6.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            r.j j6 = j(uri);
            if (j6 != null) {
                return j6.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            r.j j6 = j(uri);
            if (j6 != null) {
                return j6.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            r.j j6 = j(uri);
            if (j6 != null) {
                return j6.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private r.j j(Uri uri) {
        if (uri == null || !xt(uri)) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (r.j jVar : cw) {
            if (str.equals(jVar.getTableName())) {
                return jVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }
}
