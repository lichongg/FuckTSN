package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static volatile boolean aPA;
    private static String aPB;
    private static List<String> aPC;
    private static List<String> aPD;
    private static volatile boolean aPE;
    private static volatile boolean aPF;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aPC = aVar.aPY;
        aPD = aVar.aPZ;
    }

    public static boolean LK() {
        if (aPA) {
            return false;
        }
        try {
            return ((Printer) z.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e6);
            aPA = true;
            return false;
        }
    }

    public static boolean LL() {
        if (aPF) {
            return aPE;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.Hh().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aPE = false;
            aPF = true;
            return aPE;
        }
    }

    public static boolean bH(boolean z5) {
        List<String> list = aPC;
        return (list == null || list.isEmpty()) ? g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true) : a(aPC, true);
    }

    public static boolean bI(boolean z5) {
        List<String> list = aPD;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aPD, false);
    }

    private static boolean g(String str, boolean z5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z5);
    }

    private static boolean a(List<String> list, boolean z5) {
        if (aPA) {
            return false;
        }
        try {
            Printer printer = (Printer) z.getField(Looper.getMainLooper(), "mLogging");
            if (printer == null) {
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer not hook");
            } else {
                aPB = printer.getClass().getName();
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z5) {
                    f.fL(aPB);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.Hh().decode(it.next()));
                    com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e6);
            aPA = true;
        }
        return false;
    }
}
