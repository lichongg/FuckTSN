package com.bytedance.sdk.openadsdk.core.wq.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    private static class cw implements ITTProvider, j {

        /* renamed from: j, reason: collision with root package name */
        private j f31294j;

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public int delete(Uri uri, String str, String[] strArr) {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public String getTableName() {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public String getType(Uri uri) {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public void init() {
            j jVar = this.f31294j;
            if (jVar != null) {
                jVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public void injectContext(Context context) {
            j jVar = this.f31294j;
            if (jVar != null) {
                jVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public Uri insert(Uri uri, ContentValues contentValues) {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            j jVar = this.f31294j;
            if (jVar != null) {
                return jVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }

        public cw(j jVar) {
            this.f31294j = jVar;
        }
    }

    public interface j {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    private static class xt extends com.bytedance.sdk.openadsdk.core.wq.r implements j {

        /* renamed from: j, reason: collision with root package name */
        private j f31295j;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.bytedance.sdk.openadsdk.core.wq.r
        public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
            T t5 = (T) 0;
            switch (i6) {
                case -7999907:
                    return this.f31295j != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t5;
                case -7999906:
                    return this.f31295j != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t5;
                case -7999905:
                    if (this.f31295j != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.f31295j != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.f31295j != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.f31295j != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public int delete(Uri uri, String str, String[] strArr) {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public String getTableName() {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public String getType(Uri uri) {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public void init() {
            j jVar = this.f31295j;
            if (jVar != null) {
                jVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public void injectContext(Context context) {
            j jVar = this.f31295j;
            if (jVar != null) {
                jVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public Uri insert(Uri uri, ContentValues contentValues) {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            j jVar = this.f31295j;
            if (jVar != null) {
                return jVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }

        public xt(j jVar) {
            this.f31295j = jVar;
        }
    }

    public static Object j(j jVar, Class cls, Bundle bundle) {
        if (j(bundle)) {
            return new xt(jVar);
        }
        if (j(cls)) {
            return new cw(jVar);
        }
        return null;
    }

    public static boolean j(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return j(cls) || j(bundle);
    }

    private static boolean j(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean j(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }
}
