package com.bxkj.base.runtimepermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f16530d = "b";

    /* renamed from: e, reason: collision with root package name */
    private static b f16531e;

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f16532a = new HashSet(1);

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f16533b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    private final List<WeakReference<c>> f16534c = new ArrayList(1);

    private synchronized void a(@NonNull String[] strArr, @Nullable c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.e(strArr);
        this.f16534c.add(new WeakReference<>(cVar));
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        for (String str : strArr) {
            if (cVar != null) {
                if (!this.f16533b.contains(str)) {
                    cVar.d(str, a.NOT_FOUND);
                } else if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    cVar.d(str, a.DENIED);
                } else {
                    cVar.d(str, a.GRANTED);
                }
            }
        }
    }

    @NonNull
    private synchronized String[] d(@NonNull Activity activity) {
        ArrayList arrayList;
        PackageInfo packageInfo;
        String[] strArr;
        arrayList = new ArrayList(1);
        try {
            activity.getPackageName();
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            for (String str : strArr) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private synchronized void h() {
        String str;
        for (Field field : Manifest.permission.class.getFields()) {
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException unused) {
                str = null;
            }
            this.f16533b.add(str);
        }
    }

    private synchronized void j(@Nullable c cVar) {
        try {
            Iterator<WeakReference<c>> it = this.f16534c.iterator();
            while (it.hasNext()) {
                WeakReference<c> next = it.next();
                if (next.get() != cVar && next.get() != null) {
                }
                it.remove();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean f(@Nullable Context context, @NonNull String[] strArr) {
        if (context == null) {
            return false;
        }
        boolean z5 = true;
        for (String str : strArr) {
            z5 &= g(context, str);
        }
        return z5;
    }

    public synchronized boolean g(@Nullable Context context, @NonNull String str) {
        boolean z5;
        if (context != null) {
            try {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    if (!this.f16533b.contains(str)) {
                    }
                }
                z5 = true;
            } finally {
            }
        }
        z5 = false;
        return z5;
    }

    public synchronized void i(@NonNull String[] strArr, @NonNull int[] iArr) {
        int i6;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<c>> it = this.f16534c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar = it.next().get();
                while (i6 < length) {
                    i6 = (cVar == null || cVar.c(strArr[i6], iArr[i6])) ? 0 : i6 + 1;
                    it.remove();
                    break;
                }
            }
            while (i6 < length) {
                this.f16532a.remove(strArr[i6]);
                i6++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void k(@Nullable Activity activity, @Nullable c cVar) {
        if (activity == null) {
            return;
        }
        l(activity, d(activity), cVar);
    }

    public synchronized void l(@Nullable Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        if (activity == null) {
            return;
        }
        try {
            a(strArr, cVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, cVar);
            } else {
                List<String> e6 = e(activity, strArr, cVar);
                if (e6.isEmpty()) {
                    j(cVar);
                } else {
                    String[] strArr2 = (String[]) e6.toArray(new String[e6.size()]);
                    this.f16532a.addAll(e6);
                    ActivityCompat.requestPermissions(activity, strArr2, 1);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable c cVar) {
        try {
            FragmentActivity activity = fragment.getActivity();
            if (activity == null) {
                return;
            }
            a(strArr, cVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, cVar);
            } else {
                List<String> e6 = e(activity, strArr, cVar);
                if (e6.isEmpty()) {
                    j(cVar);
                } else {
                    String[] strArr2 = (String[]) e6.toArray(new String[e6.size()]);
                    this.f16532a.addAll(e6);
                    fragment.requestPermissions(strArr2, 1);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static b c() {
        if (f16531e == null) {
            f16531e = new b();
        }
        return f16531e;
    }

    @NonNull
    private List<String> e(@NonNull Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f16533b.contains(str)) {
                if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    if (!this.f16532a.contains(str)) {
                        arrayList.add(str);
                    }
                } else if (cVar != null) {
                    cVar.d(str, a.GRANTED);
                }
            } else if (cVar != null) {
                cVar.d(str, a.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private b() {
        h();
    }
}
