package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    private static final cw f25471j;

    /* renamed from: com.bytedance.pangle.receiver.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface cw {
        boolean j(Context context) throws Throwable;
    }

    /* renamed from: com.bytedance.pangle.receiver.j$j, reason: collision with other inner class name */
    private static class C0389j implements cw {
        private C0389j() {
        }

        @Override // com.bytedance.pangle.receiver.j.cw
        public boolean j(Context context) throws Throwable {
            Object xt = xt(context);
            Object j6 = j(xt, "mWhiteList");
            if (!(j6 instanceof String[])) {
                if (xt == null) {
                    return false;
                }
                FieldUtils.writeField(xt, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) j6);
            FieldUtils.writeField(xt, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        /* synthetic */ C0389j(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Object xt(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable unused) {
                return null;
            }
        }

        Object j(Context context, String str) {
            return j(xt(context), str);
        }

        private Object j(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private static class r extends C0389j {
        private r() {
            super(null);
        }

        /* synthetic */ r(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.j.C0389j, com.bytedance.pangle.receiver.j.cw
        public boolean j(Context context) throws Throwable {
            Object j6 = j(context, "mWhiteList");
            if (!(j6 instanceof List)) {
                return false;
            }
            ((List) j6).add(context.getPackageName());
            return true;
        }
    }

    private static class up extends C0389j {
        private up() {
            super(null);
        }

        @Override // com.bytedance.pangle.receiver.j.C0389j, com.bytedance.pangle.receiver.j.cw
        public boolean j(Context context) throws Throwable {
            Object j6 = j(context, "mWhiteListMap");
            if (!(j6 instanceof Map)) {
                return false;
            }
            Map map = (Map) j6;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }

        /* synthetic */ up(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class xt extends up {
        private xt() {
            super(null);
        }

        @Override // com.bytedance.pangle.receiver.j.up, com.bytedance.pangle.receiver.j.C0389j, com.bytedance.pangle.receiver.j.cw
        public boolean j(Context context) throws Throwable {
            return false;
        }

        /* synthetic */ xt(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        AnonymousClass1 anonymousClass1 = null;
        if (i6 < 24) {
            f25471j = new C0389j(anonymousClass1);
            return;
        }
        if (i6 < 26) {
            f25471j = new r(anonymousClass1);
        } else if (i6 < 28) {
            f25471j = new up(anonymousClass1);
        } else {
            f25471j = new xt(anonymousClass1);
        }
    }

    public static void j(Application application) {
        if (application != null) {
            try {
                if (g.kt()) {
                    f25471j.j(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
