package com.kwad.components.core.t;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n {
    public static final String TAG = "n";
    private static final String Ze = "com.kwad.components.core.t.n";
    private static volatile n Zf;
    private boolean Zg = false;
    private q.a Zh;

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        com.kwad.sdk.n.b.OQ().c(stackTrace);
        return a(list2, stackTrace);
    }

    private static void O(long j6) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j6));
    }

    private static boolean aI(String str) {
        return (str.startsWith(FaceEnvironment.OS) || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(Ze) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aJ(String str) {
        return !str.startsWith("com.kwad");
    }

    public static n tn() {
        if (Zf == null) {
            synchronized (n.class) {
                try {
                    if (Zf == null) {
                        Zf = new n();
                    }
                } finally {
                }
            }
        }
        return Zf;
    }

    private void tp() {
        q.a aVar = this.Zh;
        if (aVar == null) {
            return;
        }
        if (!this.Zg && aVar.aCv.size() > 0) {
            Iterator<String> it = this.Zh.aCv.iterator();
            while (it.hasNext()) {
                boolean aK = aK(it.next());
                this.Zg = aK;
                if (aK) {
                    break;
                }
            }
        }
        if (this.Zg) {
            ArrayList arrayList = new ArrayList();
            if (this.Zh.aCs.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Zh.aCs.entrySet()) {
                    if (aK(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            q.a aVar2 = this.Zh;
            com.kwad.components.core.p.a.se().a(a(aVar2.aCt, aVar2.aCu), arrayList);
        }
    }

    public final boolean b(SceneImpl sceneImpl, String str) {
        boolean z5;
        if (this.Zg) {
            q.a aVar = this.Zh;
            z5 = a(aVar.aCt, aVar.aCu);
        } else {
            z5 = false;
        }
        com.kwad.components.core.p.a.se().a(sceneImpl, z5, str);
        return z5;
    }

    public final void init() {
        q.a aVar = (q.a) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.azv);
        this.Zh = aVar;
        if (aVar != null) {
            tp();
        }
    }

    public final int to() {
        q.a aVar = this.Zh;
        if (aVar != null) {
            return aVar.aCw;
        }
        return 0;
    }

    private n() {
    }

    private static boolean aK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aI(className) && aJ(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            O(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            O(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            O(elapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i6 = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i6++;
            if (i6 >= 4) {
                break;
            }
        }
        return false;
    }
}
