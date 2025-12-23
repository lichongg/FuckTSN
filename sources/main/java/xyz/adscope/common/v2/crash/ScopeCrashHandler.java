package xyz.adscope.common.v2.crash;

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
import xyz.adscope.common.v2.persistent.sp.CommonSpHelper;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class ScopeCrashHandler implements Thread.UncaughtExceptionHandler, IScopeCrashHandler {
    static final String AMPS_CRASH_ATTENTION = "xyz.adscope.amps";
    static final String ASNP_CRASH_ATTENTION = "xyz.adscope.ad";
    private static final String CRASH_FILE_DIR = "/AdScope/crash/log/";
    private static final String CRASH_FILE_PATTERN = "scope_crash_%d.trace";
    private static final String CRASH_FILE_SUFFIX = ".trace";
    static final String FOUNDATION_CRASH_ATTENTION = "xyz.adscope.common";
    private static final String SP_FILE_CRASH = "ScopeCrash_%s";
    private static final String SP_KEY_ASNP_CAUSE = "ScopeCause";
    private static final String TAG = "ASNPCrashHandler";
    private boolean hasCallRegister = false;
    private final Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private final IBaseThreadPool mThreadPool;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CrashWriteTask implements Runnable {
        private final Context mContext;
        private final Throwable mException;
        private final HandleFinished mHandleCallback;

        private CrashWriteTask(Context context, Throwable th, HandleFinished handleFinished) {
            this.mContext = context;
            this.mException = th;
            this.mHandleCallback = handleFinished;
        }

        private String dumpStackTrace(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            return stringWriter.toString();
        }

        private String generateCrashFilePathFormat() {
            File appRootDir = FileUtils.getAppRootDir(this.mContext);
            if (appRootDir == null) {
                return "";
            }
            String str = appRootDir.getPath() + ScopeCrashHandler.CRASH_FILE_DIR;
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception unused) {
                    return "";
                }
            }
            return str + ScopeCrashHandler.CRASH_FILE_PATTERN;
        }

        private boolean isCrashBySDK(String str) {
            return str.contains(ScopeCrashHandler.ASNP_CRASH_ATTENTION) || str.contains(ScopeCrashHandler.FOUNDATION_CRASH_ATTENTION);
        }

        @Override // java.lang.Runnable
        public void run() {
            String dumpStackTrace = dumpStackTrace(this.mException);
            updateAsnpCauseCrashTag(dumpStackTrace);
            long currentTimeMillis = System.currentTimeMillis();
            String generateCrashFilePathFormat = generateCrashFilePathFormat();
            try {
                if (!TextUtils.isEmpty(generateCrashFilePathFormat)) {
                    storeCrashFile(String.format(generateCrashFilePathFormat, Long.valueOf(currentTimeMillis)), currentTimeMillis, dumpStackTrace);
                }
            } catch (IOException e6) {
                SDKLog.stack(e6);
            }
            this.mHandleCallback.handleFinish();
        }

        private void storeCrashFile(String str, long j6, String str2) {
            FileUtils.storeCrashFormatFile(str, j6, str2);
        }

        private void updateAsnpCauseCrashTag(String str) {
            if (!TextUtils.isEmpty(str) && isCrashBySDK(str)) {
                CommonSpHelper.putBoolean(this.mContext, ScopeCrashHandler.getCrashSpFileName("v2"), ScopeCrashHandler.SP_KEY_ASNP_CAUSE, true);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class HandleFinished {
        private final Throwable mEx;
        private final Thread mThread;

        abstract void onFinished(Thread thread, Throwable th);

        private HandleFinished(Thread thread, Throwable th) {
            this.mThread = thread;
            this.mEx = th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleFinish() {
            onFinished(this.mThread, this.mEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCrashSpFileName(String str) {
        return String.format(SP_FILE_CRASH, str);
    }

    private void asyncWriteException(Throwable th, HandleFinished handleFinished) {
        CrashWriteTask crashWriteTask = new CrashWriteTask(this.mContext, th, handleFinished);
        IBaseThreadPool iBaseThreadPool = this.mThreadPool;
        if (iBaseThreadPool != null) {
            iBaseThreadPool.executeLocalAsyncTask(crashWriteTask);
        }
    }

    private void scopeHandleUncaughtException(Throwable th, HandleFinished handleFinished) {
        SDKLog.e(TAG, "handle uncaught exception..." + th.getMessage());
        asyncWriteException(th, handleFinished);
    }

    @Override // xyz.adscope.common.v2.crash.IScopeCrashHandler
    public void registerCrashHandler(boolean z5) {
        if (this.hasCallRegister) {
            return;
        }
        this.hasCallRegister = true;
        if (z5) {
            this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull final Throwable th) {
        scopeHandleUncaughtException(th, new HandleFinished(thread, th) { // from class: xyz.adscope.common.v2.crash.ScopeCrashHandler.1
            @Override // xyz.adscope.common.v2.crash.ScopeCrashHandler.HandleFinished
            void onFinished(Thread thread2, Throwable th2) {
                if (ScopeCrashHandler.this.mDefaultHandler != null) {
                    ScopeCrashHandler.this.mDefaultHandler.uncaughtException(thread2, th);
                } else {
                    Process.killProcess(Process.myPid());
                }
            }
        });
    }

    ScopeCrashHandler(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mThreadPool = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
    }

    public static /* synthetic */ boolean a(File file) {
        String name = file.getName();
        if (!TextUtils.isEmpty(name) && name.endsWith(CRASH_FILE_SUFFIX)) {
            return true;
        }
        return false;
    }

    public static File getCrashFileDir(Context context) {
        File appRootDir = FileUtils.getAppRootDir(context);
        if (appRootDir != null) {
            File file = new File(appRootDir.getPath() + CRASH_FILE_DIR);
            if (file.exists() && file.isDirectory()) {
                return file;
            }
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.common.v2.crash.IScopeCrashHandler
    public List<ScopeCrashLog> getUnReportCrash(Context context, String str) {
        File[] listFiles;
        final File crashFileDir = getCrashFileDir(context);
        if (crashFileDir == null || !crashFileDir.exists() || (listFiles = crashFileDir.listFiles(new FileFilter() { // from class: xyz.adscope.common.v2.crash.a
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return ScopeCrashHandler.a(file);
            }
        })) == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.exists()) {
                String readFileContent = FileUtils.readFileContent(file);
                long lastModified = file.lastModified();
                if (!TextUtils.isEmpty(readFileContent)) {
                    arrayList.add(new ScopeCrashLog(null, readFileContent, lastModified));
                }
            }
        }
        Runnable runnable = new Runnable() { // from class: xyz.adscope.common.v2.crash.b
            @Override // java.lang.Runnable
            public final void run() {
                FileUtils.deleteDirWithIgnore(crashFileDir, null);
            }
        };
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
        if (orCreateImplement != null) {
            orCreateImplement.executeLocalAsyncTask(runnable);
        }
        return arrayList;
    }

    @Override // xyz.adscope.common.v2.crash.IScopeCrashHandler
    public boolean hasASNPCausedCrash(Context context, String str) {
        return CommonSpHelper.getBoolean(context, getCrashSpFileName(str), SP_KEY_ASNP_CAUSE);
    }
}
