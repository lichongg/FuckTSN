package com.bytedance.msdk.core.vl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {

    /* renamed from: r, reason: collision with root package name */
    private static up f24774r;

    /* renamed from: j, reason: collision with root package name */
    private final Set<String> f24775j = new HashSet(1);
    private final List<m> xt = new ArrayList(1);
    private final List<WeakReference<m>> cw = new ArrayList(1);

    public static up j() {
        if (f24774r == null) {
            f24774r = new up();
        }
        return f24774r;
    }

    private void xt() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.bytedance.msdk.core.xt.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (!TextUtils.isEmpty(strArr[i6])) {
                        this.f24775j.add(strArr[i6]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @NonNull
    private List<String> cw(@NonNull Activity activity, @NonNull String[] strArr, @Nullable m mVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f24775j.contains(str)) {
                if (!j(activity, str)) {
                    arrayList.add(str);
                } else if (mVar != null) {
                    mVar.j(str, r.GRANTED);
                }
            } else if (mVar != null) {
                mVar.j(str, r.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private up() {
        xt();
    }

    private synchronized void j(@NonNull String[] strArr, @Nullable m mVar) {
        if (mVar != null) {
            mVar.j(strArr);
            this.xt.add(mVar);
            this.cw.add(new WeakReference<>(mVar));
        }
    }

    private synchronized void j(@Nullable m mVar) {
        try {
            Iterator<WeakReference<m>> it = this.cw.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                if (next.get() != mVar && next.get() != null) {
                }
                it.remove();
            }
            Iterator<m> it2 = this.xt.iterator();
            while (it2.hasNext()) {
                if (it2.next() == mVar) {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void xt(@NonNull Activity activity, @NonNull String[] strArr, @Nullable m mVar) {
        boolean j6;
        for (String str : strArr) {
            if (mVar != null) {
                try {
                    if (!this.f24775j.contains(str)) {
                        j6 = mVar.j(str, r.NOT_FOUND);
                    } else if (cw.j(activity, str) != 0) {
                        j6 = mVar.j(str, r.DENIED);
                    } else {
                        j6 = mVar.j(str, r.GRANTED);
                    }
                    if (j6) {
                        break;
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
        j(mVar);
    }

    public synchronized boolean j(@Nullable Context context, @NonNull String str) {
        if (context != null) {
            return com.bytedance.msdk.tl.a.up() ? xt.j(context, str) && (cw.j(context, str) == 0 || !this.f24775j.contains(str)) : cw.j(context, str) == 0 || !this.f24775j.contains(str);
        }
        return false;
    }

    public synchronized void j(@Nullable Activity activity, @NonNull String[] strArr, @Nullable m mVar) {
        if (activity != null) {
            try {
                j(strArr, mVar);
                if (Build.VERSION.SDK_INT < 23) {
                    xt(activity, strArr, mVar);
                    return;
                }
                List<String> cw = cw(activity, strArr, mVar);
                if (cw.isEmpty()) {
                    j(mVar);
                } else {
                    cw.requestPermissions(activity, (String[]) cw.toArray(new String[cw.size()]), 1);
                }
            } finally {
            }
        }
    }

    public synchronized void j(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                String str = strArr[i6];
                if (iArr[i6] != -1) {
                    if (com.bytedance.msdk.tl.a.up() && !xt.j(activity, str)) {
                    }
                }
                if (iArr[i6] != -1) {
                    iArr[i6] = -1;
                }
            }
            j(strArr, iArr);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void j(@NonNull String[] strArr, @NonNull int[] iArr) {
        int i6;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<m>> it = this.cw.iterator();
            while (it.hasNext()) {
                m mVar = it.next().get();
                while (i6 < length) {
                    i6 = (mVar == null || mVar.j(strArr[i6], iArr[i6])) ? 0 : i6 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<m> it2 = this.xt.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
