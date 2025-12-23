package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ax extends az.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10652a = "local";

    /* renamed from: b, reason: collision with root package name */
    private static final int f10653b = 4000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10654c = 23;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10655d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f10656e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f, reason: collision with root package name */
    private static final char f10657f = 9556;

    /* renamed from: g, reason: collision with root package name */
    private static final char f10658g = 9562;

    /* renamed from: h, reason: collision with root package name */
    private static final char f10659h = 9567;

    /* renamed from: i, reason: collision with root package name */
    private static final char f10660i = 9553;

    /* renamed from: j, reason: collision with root package name */
    private static final String f10661j = "════════════════════════════════════════════";

    /* renamed from: k, reason: collision with root package name */
    private static final String f10662k = "------------------------------------------";

    /* renamed from: l, reason: collision with root package name */
    private static final String f10663l = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m, reason: collision with root package name */
    private static final String f10664m = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: n, reason: collision with root package name */
    private static final String f10665n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return "local";
    }

    protected String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f10656e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    final String b() {
        String b6 = super.b();
        if (b6 != null) {
            return b6;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= 5) {
            return "";
        }
        return a(stackTrace[5]);
    }

    protected String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z5 = false;
        int i6 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f10656e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(az.class.getName()) && !className.equals(bu.class.getName())) {
                if (z5) {
                    break;
                }
            } else {
                z5 = true;
            }
            i6++;
        }
        return "   (" + stackTrace[i6].getFileName() + ":" + stackTrace[i6].getLineNumber() + ")# " + stackTrace[i6].getMethodName();
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i6, String str, String str2, Throwable th) {
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i7 = 0;
                while (i7 < length) {
                    int indexOf = str2.indexOf(10, i7);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i7 + 4000);
                        arrayList.add(str2.substring(i7, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i7 = min;
                        }
                    }
                    i7 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i6, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            a(i6, str, sb.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i6, String str, String str2) {
        if (i6 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i6, str, str2);
        }
    }
}
