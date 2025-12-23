package com.bytedance.sdk.openadsdk.core.x;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static final String f31316j = "up";
    private static volatile up up;
    private final CopyOnWriteArraySet<String> xt = new CopyOnWriteArraySet<>();
    private final List<WeakReference<m>> cw = new ArrayList(1);

    /* renamed from: r, reason: collision with root package name */
    private final List<m> f31317r = new ArrayList(1);

    private void cw() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = v.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (!TextUtils.isEmpty(strArr[i6])) {
                        this.xt.add(strArr[i6]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static up j() {
        if (up == null) {
            synchronized (up.class) {
                try {
                    if (up == null) {
                        up = new up();
                    }
                } finally {
                }
            }
        }
        return up;
    }

    private void xt() {
        cw();
    }

    public boolean xt(Context context, String str) {
        if (context == null) {
            return false;
        }
        return ch.av() ? cw.j(context, str) && xt.j(context, str) == 0 : xt.j(context, str) == 0;
    }

    private up() {
        xt();
    }

    private void xt(Activity activity, String[] strArr, m mVar) {
        boolean j6;
        for (String str : strArr) {
            if (mVar != null) {
                try {
                    if (!this.xt.contains(str)) {
                        j6 = mVar.j(str, r.NOT_FOUND);
                    } else if (xt.j(activity, str) != 0) {
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

    private synchronized void j(String[] strArr, m mVar) {
        if (mVar == null) {
            return;
        }
        mVar.j(strArr);
        this.f31317r.add(mVar);
        this.cw.add(new WeakReference<>(mVar));
    }

    private List<String> cw(Activity activity, String[] strArr, m mVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.xt.contains(str)) {
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

    private synchronized void j(m mVar) {
        try {
            Iterator<WeakReference<m>> it = this.cw.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                if (next.get() != mVar && next.get() != null) {
                }
                it.remove();
            }
            Iterator<m> it2 = this.f31317r.iterator();
            while (it2.hasNext()) {
                if (it2.next() == mVar) {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean j(Context context, String str) {
        if (context == null) {
            return false;
        }
        return ch.av() ? cw.j(context, str) && xt.j(context, str) == 0 : xt.j(context, str) == 0;
    }

    public synchronized void j(Activity activity, String[] strArr, m mVar) {
        if (activity == null) {
            return;
        }
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
                xt.requestPermissions(activity, (String[]) cw.toArray(new String[cw.size()]), 1);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public synchronized void j(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                String str = strArr[i6];
                if (iArr[i6] != -1) {
                    if (ch.av() && !cw.j(activity, str)) {
                    }
                }
                if (iArr[i6] != -1) {
                    iArr[i6] = -1;
                }
            }
            j(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void j(String[] strArr, int[] iArr, String[] strArr2) {
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
            Iterator<m> it2 = this.f31317r.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
