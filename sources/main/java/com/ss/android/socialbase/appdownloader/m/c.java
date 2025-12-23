package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.acse.ottn.l3;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.az.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f38484a;

    private static int h() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(l3.f4736f, String.class).invoke(null, c("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    public static boolean i(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    public static boolean m(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @WorkerThread
    public static boolean a() {
        try {
            InetAddress.getByName(c("3132372e302e302e31"));
            new Socket(c("3132372e302e302e31"), Integer.parseInt(c("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    @WorkerThread
    public static synchronized void d(@NonNull Context context) {
        synchronized (c.class) {
            try {
                if (f38484a == null) {
                    f38484a = Boolean.valueOf((l() || m(context) || b(context) || !i(context) || a() || k(context)) ? false : true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean e() {
        Boolean bool = f38484a;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static boolean f() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(c("636f6d2e73617572696b2e737562737472617465")) || str.contains(c("58706f7365644272696467652e6a6172")) || str.contains(c("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean g(Context context) {
        List asList = Arrays.asList(c("64652e726f62762e616e64726f69642e78706f736564"), c("636f6d2e746f706a6f686e77752e6d616769736b"), c("696f2e76612e6578706f736564"), c("636f6d2e77696e642e636f74746572"), c("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), c("6d652e7765697368752e657870"), c("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e6) {
                vl.j(e6);
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean j() {
        String[] strArr = {c("2f7362696e2f7375"), c("2f73797374656d2f62696e2f7375"), c("2f73797374656d2f7862696e2f7375"), c("2f646174612f6c6f63616c2f7862696e2f7375"), c("2f646174612f6c6f63616c2f62696e2f7375"), c("2f73797374656d2f73642f7862696e2f7375"), c("2f73797374656d2f62696e2f6661696c736166652f7375"), c("2f646174612f6c6f63616c2f7375")};
        for (int i6 = 0; i6 < 8; i6++) {
            if (new File(strArr[i6]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static String c(@NonNull String str) {
        return m.j(str);
    }

    @WorkerThread
    public static boolean k(Context context) {
        if (!f() && !g(context)) {
            return false;
        }
        return true;
    }

    public static boolean l() {
        if (h() == 0) {
            return true;
        }
        return j();
    }
}
