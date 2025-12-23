package com.bytedance.pangle.m;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.m.m;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements m.j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile IBinder f25413j;
    private static volatile Object xt;

    public interface j {
    }

    private static void cw(String str, String str2, String str3) {
        if (xt == null || str == null || str2 == null || str3 == null) {
            return;
        }
        j(xt, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static String[] j(String... strArr) {
        return strArr;
    }

    private static void xt(String str, int i6) {
        if (str == null) {
            return;
        }
        String xt2 = com.bytedance.pangle.up.cw.xt(str, i6);
        String up = com.bytedance.pangle.up.cw.up(str, i6);
        j(xt2, up);
        j(Zeus.getAppApplication().getPackageName(), up, com.bytedance.pangle.m.xt.j());
    }

    private static class xt extends ResultReceiver {

        /* renamed from: j, reason: collision with root package name */
        private j f25414j;

        public xt(j jVar) {
            super(null);
            this.f25414j = jVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i6, Bundle bundle) {
            super.onReceiveResult(i6, bundle);
        }
    }

    @Override // com.bytedance.pangle.m.m.j
    public boolean j(String str, int i6) {
        j();
        xt(str, i6);
        boolean j6 = j("speed", str, i6);
        cw(str, i6);
        return j6;
    }

    private static void cw(String str, int i6) {
        if (str == null) {
            return;
        }
        xt(com.bytedance.pangle.up.cw.ae(str, i6), com.bytedance.pangle.up.cw.m(str, i6));
        xt(com.bytedance.pangle.up.cw.up(str, i6));
        xt();
    }

    private static void j() {
        PackageManager packageManager;
        Field j6;
        IBinder asBinder;
        if (f25413j == null && (j6 = j((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object j7 = j(j6, packageManager);
            xt = j7;
            if ((j7 instanceof IInterface) && (asBinder = ((IInterface) xt).asBinder()) != null) {
                f25413j = asBinder;
            }
        }
    }

    private static void xt(String str, String str2, String str3) {
        if (xt == null || str == null || str2 == null || str3 == null) {
            return;
        }
        j(xt, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void xt() {
        j(cw(), (j) null);
    }

    private static String[] cw() {
        return j("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void xt(String str, String str2) {
        try {
            com.bytedance.pangle.util.ae.j(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void xt(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static boolean j(String str, String str2, int i6) {
        String up = com.bytedance.pangle.up.cw.up(str2, i6);
        String str3 = com.bytedance.pangle.up.cw.tl(str2, i6) + File.separator + com.bytedance.pangle.m.xt.j(up);
        for (int i7 = 1; i7 <= 3; i7++) {
            j(j(str), (j) null);
            if (com.bytedance.pangle.m.xt.j(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void j(String str, String str2, String str3) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 == 30) {
            xt(str, str2, str3);
        } else if (i6 == 29) {
            cw(str, str2, str3);
        }
    }

    private static void j(String[] strArr, j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new xt(jVar).writeToParcel(obtain, 0);
        try {
            f25413j.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static String[] j(String str) {
        return j("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static void j(String str, String str2) {
        try {
            com.bytedance.pangle.util.tl.j(str, str2);
        } catch (Exception unused) {
        }
    }

    public static Field j(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return j(obj.getClass(), str);
    }

    public static Field j(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object j(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object j(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
