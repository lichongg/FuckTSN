package com.bytedance.j.xt.tl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class o {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f24241a;

        Object a() {
            return this.f24241a;
        }

        void b(Object obj) {
            this.f24241a.println(obj);
        }

        a(PrintWriter printWriter) {
            this.f24241a = printWriter;
        }
    }

    private static boolean a(Throwable th) {
        int i6 = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i6 > 20) {
                return false;
            }
            th = th.getCause();
            i6++;
        }
        return false;
    }

    public static boolean i(Throwable th) {
        if (th == null) {
            return false;
        }
        int i6 = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i6 > 20) {
                return false;
            }
            i6++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @NonNull
    public static String b(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (a(th)) {
                g(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Exception unused) {
            printWriter.close();
            return "";
        } catch (Throwable th2) {
            printWriter.close();
            throw th2;
        }
    }

    public static String c(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            d(stackTraceElement, sb);
        }
        return sb.toString();
    }

    @Nullable
    public static JSONObject e(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!h(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put(CrashHianalyticsData.THREAD_NAME, key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() > 0) {
                        }
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void g(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        a aVar = new a(printWriter);
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.a()) {
            try {
                aVar.b(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i6];
                    if (i7 > 256) {
                        aVar.b("\t... skip " + (stackTrace.length - i7) + " lines");
                        break;
                    }
                    aVar.b("\tat " + stackTraceElement);
                    i7++;
                    i6++;
                }
                for (Throwable th2 : th.getSuppressed()) {
                    f(th2, aVar, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    f(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static StringBuilder d(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    private static void f(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.b("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i6 = min - 1;
        int i7 = i6;
        for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i7 >= 0 && min2 >= 0 && stackTrace[i7].equals(stackTraceElementArr[min2]); min2--) {
            i7--;
        }
        int i8 = i6 - i7;
        aVar.b(str2 + str + th);
        for (int i9 = 0; i9 <= i7; i9++) {
            aVar.b(str2 + "\tat " + stackTrace[i9]);
        }
        if (min < stackTrace.length) {
            aVar.b("\t... skip " + (stackTrace.length - min) + " lines");
        }
        if (i8 != 0) {
            aVar.b(str2 + "\t... " + i8 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            f(th2, aVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            f(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean h(String str) {
        Set<String> a6 = m.a();
        if (a6.contains(str)) {
            return true;
        }
        for (String str2 : a6) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
