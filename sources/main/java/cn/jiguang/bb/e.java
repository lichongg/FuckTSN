package cn.jiguang.bb;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import com.huawei.hms.common.util.Logger;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f1970a = "jpush_log";

    /* renamed from: b, reason: collision with root package name */
    public static String f1971b = "internal_debug_log.txt";

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f1972c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);

    /* renamed from: d, reason: collision with root package name */
    private static final Object f1973d = new Object();

    public static void a() {
        try {
            Context a6 = cn.jiguang.bz.d.a(null);
            if (a6 != null && !d.c(a6)) {
                f.c(Logger.f33115b, "Skip clearing log files due to active references");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a6.getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append(f1970a);
            sb.append(str);
            j.d(sb.toString());
        } catch (Throwable th) {
            f.i(Logger.f33115b, "clearLogFiles error is " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file) {
        try {
            if (!file.exists() || file.length() <= 10485760) {
                return;
            }
            synchronized (f1973d) {
                try {
                    if (file.exists() && file.length() > 10485760) {
                        j.b(file);
                        file.createNewFile();
                        f.c(Logger.f33115b, "Log file exceeded max size, rotated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e6) {
            e6.getMessage();
        }
    }

    private static void a(final String str) {
        try {
            cn.jiguang.by.d.a("ONCE_TASK", new Runnable() { // from class: cn.jiguang.bb.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (e.f1973d) {
                            try {
                                Context a6 = cn.jiguang.bz.d.a(null);
                                if (a6 != null) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(a6.getFilesDir());
                                    String str2 = File.separator;
                                    sb.append(str2);
                                    sb.append(e.f1970a);
                                    sb.append(str2);
                                    File file = new File(sb.toString() + e.f1971b);
                                    File parentFile = file.getParentFile();
                                    if (!parentFile.exists()) {
                                        parentFile.mkdirs();
                                    }
                                    if (!file.exists()) {
                                        file.createNewFile();
                                        f.a(Logger.f33115b, "create log file: " + file.getName());
                                    }
                                    e.b(file);
                                    j.a(file, str + com.snail.antifake.deviceid.e.f37542d);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        f.i(Logger.f33115b, "write logs to file error is " + th2.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            f.i(Logger.f33115b, "saveLogs error is " + th.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, String str4, Throwable th) {
        String str5 = (str3 == null || str3.trim().equals("")) ? Logger.f33115b : str3;
        if (str4 == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String format = f1972c.format(new Date());
            String a6 = cn.jiguang.bz.a.a(cn.jiguang.bz.d.a());
            int myPid = Process.myPid();
            long id = Thread.currentThread().getId();
            String[] split = str4.split(com.snail.antifake.deviceid.e.f37542d);
            boolean z5 = true;
            int i6 = 0;
            while (i6 < split.length) {
                String str6 = split[i6];
                if (!z5) {
                    sb.append(com.snail.antifake.deviceid.e.f37542d);
                }
                sb.append((CharSequence) format);
                sb.append(" ");
                sb.append(myPid);
                sb.append("-");
                sb.append(id);
                sb.append(" ");
                sb.append(a6);
                sb.append(" ");
                sb.append(str2);
                sb.append(" ");
                sb.append(str);
                sb.append(" ");
                sb.append("[");
                sb.append(str5);
                sb.append("] ");
                sb.append(str6);
                i6++;
                z5 = false;
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.close();
                    String stringWriter2 = stringWriter.toString();
                    sb.append(com.snail.antifake.deviceid.e.f37542d);
                    sb.append(stringWriter2);
                } finally {
                }
            }
            if (TextUtils.isEmpty(sb)) {
                return;
            }
            a(sb.toString().trim());
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }
}
