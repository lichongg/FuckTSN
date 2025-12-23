package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static Set<String> aOW;

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Ls = e.Lr().Ls();
        if (Ls == null || Ls.length == 0) {
            return true;
        }
        boolean z5 = false;
        for (String str : Ls) {
            z5 = a(stackTraceElementArr, str);
            if (z5) {
                break;
            }
        }
        if (z5) {
            for (String str2 : e.Lr().Lt()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z5;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    static {
        HashSet hashSet = new HashSet();
        aOW = hashSet;
        hashSet.add("commonHT");
        aOW.add("reportHT");
        aOW.add("IpDirectHelper");
        aOW.add("filedownloader serial thread");
        aOW.add("RemitHandoverToDB");
        aOW.add("source-status-callback");
        aOW.add("ObiwanMMAPTracer");
        aOW.add("FrameSequence decoding thread");
    }

    public static boolean o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i6 = 0; i6 < 5; i6++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return I(arrayList);
    }

    private static boolean I(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean fA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!fB(str) && !str.startsWith("ksad-") && !str.startsWith("filedownloader serial thread")) {
            return false;
        }
        return true;
    }

    private static boolean fB(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:" + str);
        return true;
    }

    public static boolean fC(String str) {
        if (fA(str) || i.bR(str)) {
            return true;
        }
        Set<String> set = aOW;
        if (set != null && set.contains(str)) {
            c.d("CrashFilter", "needReportByThreadName:" + str);
            return true;
        }
        return false;
    }

    public static boolean fD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] Ls = e.Lr().Ls();
        if (Ls != null && Ls.length != 0) {
            boolean z5 = false;
            for (String str2 : Ls) {
                z5 = str.contains(str2);
                if (z5) {
                    break;
                }
            }
            if (z5) {
                for (String str3 : e.Lr().Lt()) {
                    if (str.contains(str3)) {
                        return false;
                    }
                }
            }
            return z5;
        }
        return true;
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
