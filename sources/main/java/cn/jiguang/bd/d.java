package cn.jiguang.bd;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.n;
import cn.jiguang.internal.ActionManager;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f1991a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1992b;

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<File, Boolean> f1993c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f1994d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static boolean f1995e = false;

    private static int a(Context context, File file) {
        if (((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue() == 0) {
            cn.jiguang.bb.f.c("ReportHistory", "can't get uid, skip upload history");
            return -2;
        }
        File[] a6 = j.a(file, j.a.f2757a);
        if (a6 != null && a6.length != 0) {
            LinkedList<File> linkedList = new LinkedList();
            for (File file2 : a6) {
                if (!Boolean.TRUE.equals(f1993c.get(file2))) {
                    linkedList.add(file2);
                }
            }
            if (linkedList.isEmpty()) {
                return 0;
            }
            cn.jiguang.bb.f.c("ReportHistory", "process space=" + e(file) + " history[" + linkedList.size() + "]");
            Collections.sort(linkedList, new Comparator<File>() { // from class: cn.jiguang.bd.d.4
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file3, File file4) {
                    long lastModified = file3.lastModified() - file4.lastModified();
                    if (lastModified < 0) {
                        return 1;
                    }
                    if (lastModified == 0) {
                        return 0;
                    }
                    return -1;
                }
            });
            for (File file3 : linkedList) {
                try {
                    JSONObject a7 = c.a(file3);
                    if (a7 == null) {
                        j.b(file3);
                    } else {
                        b(file3);
                        Set<String> a8 = f.a(a7);
                        cn.jiguang.bb.f.c("ReportHistory", "report history types=" + a8);
                        int a9 = f.a(context, a8, a7, file3, null);
                        if (a9 != 0 && a9 != 1) {
                            return a9;
                        }
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.i("ReportHistory", "upload e:" + th);
                }
            }
        }
        return 0;
    }

    public static void b(final Context context) {
        if (f1994d.get()) {
            cn.jiguang.bb.f.c("ReportHistory", "isRunning, no need report");
            return;
        }
        a(false);
        String str = "ReportHistory#submitReportAll";
        if (TextUtils.isEmpty(cn.jiguang.ba.d.b(context)) || !context.getPackageName().equals(cn.jiguang.bz.a.a(context))) {
            cn.jiguang.by.d.a("NORMAL_TASK", new cn.jiguang.by.b(str) { // from class: cn.jiguang.bd.d.3
                @Override // cn.jiguang.by.b
                public void a() {
                    d.f(context);
                }
            });
        } else {
            cn.jiguang.by.d.a("MAJOR_TASK", new cn.jiguang.by.b(str) { // from class: cn.jiguang.bd.d.2
                @Override // cn.jiguang.by.b
                public void a() {
                    d.f(context);
                }
            });
        }
    }

    private static int c(Context context, File file) {
        cn.jiguang.bb.f.c("ReportHistory", "upload space=" + e(file));
        b(context, file);
        d(file);
        int a6 = a(context, file);
        c(file);
        return a6;
    }

    private static synchronized String d(Context context) {
        String str;
        String replaceFirst;
        synchronized (d.class) {
            if (!TextUtils.isEmpty(f1992b)) {
                return f1992b;
            }
            if (f1991a == null) {
                String a6 = cn.jiguang.bz.a.a(context);
                if (!TextUtils.isEmpty(a6)) {
                    if (a6.equals(context.getPackageName())) {
                        replaceFirst = "";
                    } else {
                        replaceFirst = a6.replaceFirst(context.getPackageName() + ":", "_");
                    }
                    f1991a = replaceFirst;
                }
            }
            if (f1991a != null) {
                str = "jpush_stat_history" + f1991a;
            } else {
                str = "jpush_stat_history";
            }
            File c6 = j.c(str);
            if (c6 != null) {
                String absolutePath = c6.getAbsolutePath();
                f1992b = absolutePath;
                return absolutePath;
            }
            return "jpush_stat_history" + f1991a;
        }
    }

    private static String e(Context context) {
        String e6 = cn.jiguang.d.a.e(context);
        if (TextUtils.isEmpty(e6)) {
            e6 = "0";
        }
        return d(context) + File.separator + e6;
    }

    public static File a(Context context, String str) {
        return new File(e(context) + str + File.separator + UUID.randomUUID().toString());
    }

    private static void b(Context context, File file) {
        try {
            JSONObject a6 = f.a(context);
            if (n.c(a6)) {
                return;
            }
            File[] a7 = j.a(new File(file, "nowrap"), j.a.f2757a);
            if (a7 != null && a7.length != 0) {
                cn.jiguang.bb.f.c("ReportHistory", "process space=" + e(file) + " nowrap[" + a7.length + "]");
                File file2 = new File(file, "tmp");
                c a8 = c.a(a7[0], a6);
                for (int i6 = 1; i6 < a7.length; i6++) {
                    c a9 = c.a(a7[i6], a6);
                    if (a9 != null) {
                        if (a8 != null && a8.a(a9, file2)) {
                        }
                        a8 = a9;
                    }
                }
                if (a8 != null) {
                    a8.a((c) null, file2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReportHistory", "processNowrap e:" + th);
        }
    }

    private static Set<String> c() {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add("app_key");
        hashSet.add(Constants.PARAM_SDK_VER);
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static void d(File file) {
        try {
            File[] a6 = j.a(new File(file, "tmp"), j.a.f2757a);
            if (a6 != null && a6.length != 0) {
                LinkedList linkedList = new LinkedList();
                for (File file2 : a6) {
                    if (!Boolean.TRUE.equals(f1993c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                cn.jiguang.bb.f.c("ReportHistory", "process space=" + e(file) + " tmp[" + linkedList.size() + "]");
                Set<String> c6 = c();
                HashMap hashMap = new HashMap();
                c a7 = c.a(j.a(j.a(file, j.a.f2757a)), c6);
                if (a7 != null) {
                    hashMap.put(String.valueOf(a7.f1986b), a7);
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c a8 = c.a((File) it.next(), c6);
                    if (a8 != null) {
                        String valueOf = String.valueOf(a8.f1986b);
                        c cVar = (c) hashMap.get(valueOf);
                        if (cVar != null && cVar.a(a8, file)) {
                        }
                        hashMap.put(valueOf, a8);
                    }
                }
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).a((c) null, file);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReportHistory", "processTmp e:" + th);
        }
    }

    private static String e(File file) {
        try {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            sb.append(parentFile.getParentFile().getName());
            String str = File.separator;
            sb.append(str);
            sb.append(parentFile.getName());
            sb.append(str);
            sb.append(file.getName());
            return sb.toString();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        File[] a6;
        String str;
        try {
            f1994d.set(true);
            a6 = j.a(e(context), j.a.f2758b);
        } finally {
            try {
            } finally {
            }
        }
        if (a6 != null) {
            for (File file : a6) {
                if (!b()) {
                    int c6 = c(context, file);
                    if (c6 != 0 && c6 != 1) {
                        break;
                    }
                } else {
                    str = "history, report is Tcp and http Fail";
                }
            }
        }
        str = "no history, no report";
        cn.jiguang.bb.f.c("ReportHistory", str);
    }

    public static File a(Context context, String str, JSONObject jSONObject, boolean z5) {
        File a6 = a(context, str);
        if (z5) {
            b(a6);
        }
        j.b(a6, jSONObject.toString());
        return a6;
    }

    private static void b(File file) {
        if (file != null) {
            f1993c.put(file, Boolean.TRUE);
        }
    }

    public static FileFilter a() {
        return new FileFilter() { // from class: cn.jiguang.bd.d.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().length() != 24 && !file.getName().equals("0")) {
                    return true;
                }
                return false;
            }
        };
    }

    private static boolean b() {
        return f1995e;
    }

    private static void c(File file) {
        int i6 = 0;
        File[] a6 = j.a(file, j.a.f2757a);
        if (a6 == null || a6.length <= 1) {
            return;
        }
        List<File> asList = Arrays.asList(a6);
        Collections.sort(asList, new Comparator<File>() { // from class: cn.jiguang.bd.d.5
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified() - file3.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                if (lastModified == 0) {
                    return 0;
                }
                return -1;
            }
        });
        for (File file2 : asList) {
            i6 = (int) (i6 + file2.length());
            if (i6 > 1048576) {
                j.b(file2);
            }
        }
        if (asList.size() < a6.length) {
            cn.jiguang.bb.f.c("ReportHistory", "trim space history=" + e(file) + "," + a6.length + " to " + asList.size());
        }
    }

    public static void a(Context context) {
        j.a aVar = new j.a(false, true, "jpush_stat_history", 1);
        String e6 = cn.jiguang.d.a.e(context);
        File[] a6 = j.a(context.getFilesDir(), aVar, a());
        if (a6 != null) {
            for (File file : a6) {
                try {
                    j.b(new File(file, "nowrap"));
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getParent());
                    String str = File.separator;
                    sb.append(str);
                    sb.append(e6);
                    sb.append(str);
                    sb.append(file.getName());
                    File file2 = new File(sb.toString());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    cn.jiguang.bb.f.c("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    public static void a(Context context, String... strArr) {
        FileFilter[] fileFilterArr;
        if (strArr == null || strArr.length == 0) {
            fileFilterArr = new FileFilter[1];
        } else {
            fileFilterArr = new FileFilter[strArr.length + 1];
            int i6 = 0;
            while (i6 < strArr.length) {
                int i7 = i6 + 1;
                fileFilterArr[i7] = j.a.a(strArr[i6]);
                i6 = i7;
            }
        }
        fileFilterArr[0] = new j.a(false, true, "jpush_stat_history", 1);
        File[] a6 = j.a(context.getFilesDir(), fileFilterArr);
        if (a6 != null) {
            for (File file : a6) {
                j.b(file);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            f1993c.remove(file);
        }
    }

    public static void a(boolean z5) {
        f1995e = z5;
    }
}
