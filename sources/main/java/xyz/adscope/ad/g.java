package xyz.adscope.ad;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.file.FileUtils;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55150a;

    /* renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f55151b;

    /* renamed from: c, reason: collision with root package name */
    private final IBaseThreadPool f55152c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends c {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f55153c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Thread thread, Throwable th, Throwable th2) {
            super(thread, th, null);
            this.f55153c = th2;
        }

        @Override // xyz.adscope.ad.g.c
        void a(Thread thread, Throwable th) {
            if (g.this.f55151b != null) {
                g.this.f55151b.uncaughtException(thread, this.f55153c);
            } else {
                Process.killProcess(Process.myPid());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Throwable f55155a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f55156b;

        /* renamed from: c, reason: collision with root package name */
        private final c f55157c;

        /* synthetic */ b(Context context, Throwable th, c cVar, a aVar) {
            this(context, th, cVar);
        }

        private boolean a(String str) {
            return str.contains("xyz.adscope.ad") || str.contains("xyz.adscope.common");
        }

        private b(Context context, Throwable th, c cVar) {
            this.f55156b = context;
            this.f55155a = th;
            this.f55157c = cVar;
        }

        private String a() {
            File appRootDir = FileUtils.getAppRootDir(this.f55156b);
            if (appRootDir == null) {
                return "";
            }
            String str = appRootDir.getPath() + "/AdScope/crash/log/";
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception unused) {
                    return "";
                }
            }
            return str + "asnp_crash_%d.trace";
        }

        @Override // java.lang.Runnable
        public void run() {
            String a6 = a(this.f55155a);
            b(a6);
            long currentTimeMillis = System.currentTimeMillis();
            String a7 = a();
            try {
                if (!TextUtils.isEmpty(a7)) {
                    a(String.format(a7, Long.valueOf(currentTimeMillis)), currentTimeMillis, a6);
                }
            } catch (IOException e6) {
                SDKLog.stack(e6);
            }
            this.f55157c.a();
        }

        private void b(String str) {
            if (!TextUtils.isEmpty(str) && a(str)) {
                i0.a(this.f55156b, g.b(f0.a()), "asnpCause", true);
            }
        }

        private String a(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            return stringWriter.toString();
        }

        private void a(String str, long j6, String str2) {
            FileUtils.storeCrashFormatFile(str, j6, str2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        private final Thread f55158a;

        /* renamed from: b, reason: collision with root package name */
        private final Throwable f55159b;

        /* synthetic */ c(Thread thread, Throwable th, a aVar) {
            this(thread, th);
        }

        abstract void a(Thread thread, Throwable th);

        private c(Thread thread, Throwable th) {
            this.f55158a = thread;
            this.f55159b = th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            a(this.f55158a, this.f55159b);
        }
    }

    private void b(Throwable th, c cVar) {
        SDKLog.e("ASNPCrashHandler", "handle uncaught exception..." + th.getMessage());
        a(th, cVar);
    }

    public static boolean c(Context context) {
        return i0.b(context, b(f0.a()), "asnpCause");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        b(th, new a(thread, th, th));
    }

    public g(Context context) {
        this.f55150a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f55152c = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        return String.format("asnpCrash_%s", str);
    }

    public void a() {
        this.f55151b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static List<m1> b(Context context) {
        File[] listFiles;
        final File a6 = a(context);
        if (a6 == null || !a6.exists() || (listFiles = a6.listFiles(new FileFilter() { // from class: xyz.adscope.ad.i7
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                boolean a7;
                a7 = g.a(file);
                return a7;
            }
        })) == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.exists()) {
                String readFileContent = FileUtils.readFileContent(file);
                if (!TextUtils.isEmpty(readFileContent)) {
                    arrayList.add(new m1(readFileContent));
                }
            }
        }
        Runnable runnable = new Runnable() { // from class: xyz.adscope.ad.j7
            @Override // java.lang.Runnable
            public final void run() {
                FileUtils.deleteDirWithIgnore(a6, null);
            }
        };
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
        if (orCreateImplement != null) {
            orCreateImplement.executeLocalAsyncTask(runnable);
        }
        return arrayList;
    }

    private void a(Throwable th, c cVar) {
        b bVar = new b(this.f55150a, th, cVar, null);
        IBaseThreadPool iBaseThreadPool = this.f55152c;
        if (iBaseThreadPool != null) {
            iBaseThreadPool.executeLocalAsyncTask(bVar);
        }
    }

    private static File a(Context context) {
        File appRootDir = FileUtils.getAppRootDir(context);
        if (appRootDir == null) {
            return null;
        }
        File file = new File(appRootDir.getPath() + "/AdScope/crash/log/");
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.endsWith(".trace");
    }
}
