package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.eX(21);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final AnrHandler aPc = new AnrHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dumpAnr(@Nullable String str, int i6) {
        boolean z5;
        com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i6);
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        File file = new File(this.mDumpDir.toString() + "-" + i6);
        File file2 = getInstance().mLogDir;
        try {
            if (file2.exists() || file2.mkdirs()) {
                z5 = true;
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file2.getPath() + " failed!\n";
                z5 = false;
            }
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + this.mDumpDir.getPath() + " failed!\n";
                z5 = false;
            }
            g.b(null, anrExceptionMessage, e.Lr().getContext());
            g.a(anrExceptionMessage, 3);
            File file3 = new File(file, "dump");
            if (str != null && z5) {
                w.f(new File(str), file3);
            }
            g.F(new File(file, "logcat"));
            try {
                final StringBuilder sb = new StringBuilder();
                Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.6
                    @Override // android.util.Printer
                    public final void println(String str2) {
                        StringBuilder sb2 = sb;
                        sb2.append(str2);
                        sb2.append(com.snail.antifake.deviceid.e.f37542d);
                    }
                }, "");
                anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            } catch (Exception e6) {
                anrExceptionMessage.mErrorMessage += Log.getStackTraceString(e6) + com.snail.antifake.deviceid.e.f37542d;
            }
            try {
                anrExceptionMessage.mLogUUID = g.fU(file3.getName());
                g.a(new File(file, CrashHianalyticsData.MESSAGE), anrExceptionMessage.toJson().toString());
                getInstance().backupLogFiles(file2);
                com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
                if (uploader != null) {
                    anrExceptionMessage.toString();
                }
                g.a(uploader, TAG, file3);
                g.I(new File(file, "meminfo"));
            } catch (Throwable unused) {
            }
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
            getInstance().uploadRemainingExceptions();
            notifyJavaDumpDone();
            getAnrReason(str, file);
        } catch (Throwable th) {
            anrExceptionMessage.mErrorMessage += th;
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static native boolean getStackTraceCrashOccured();

    public static native void install(String str, int i6);

    public static native void notifyJavaDumpDone();

    private boolean parseTraceFile(String str) {
        int i6;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            i6 = -1;
                            break;
                        }
                        if (PID_PATTERN.matcher(readLine).matches()) {
                            i6 = Integer.parseInt(readLine.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z5 = i6 == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z5;
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 3;
    }

    private AnrHandler() {
    }

    private static boolean checkErrorState() {
        try {
            com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] start");
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) com.kwad.sdk.core.c.b.Ho().getApplication().getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] procs == null");
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "maybe received other apps ANR signal");
                    return false;
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "error sate longMsg = " + processErrorStateInfo.longMsg);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "[checkErrorState] error : " + th.getMessage());
            return false;
        }
    }

    private static void getAnrReason(@Nullable String str, File file) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        com.kwad.sdk.core.d.c.d(TAG, "ANR getAnrReasonInner");
        getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < 10000) {
                    return;
                } else {
                    sLastTime = lastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.Lr().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return;
        }
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < TRY_TIMES; i6++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (Build.VERSION.SDK_INT > 33 && !z5 && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().pid == Process.myPid()) {
                            break;
                        }
                    } else {
                        com.kwad.sdk.core.d.c.i(TAG, "anr did happen on android14");
                        g.a(new File(file, "anr_happened"), (CharSequence) "anr did happen", false);
                        z5 = true;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(GET_REASON_INTERVAL);
        }
        if (processErrorStateInfo != null && processErrorStateInfo.pid == MY_PID) {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            File file2 = new File(file, "anr_reason");
            com.kwad.sdk.core.d.c.i(TAG, "anr reason: " + anrReason.toJson().toString());
            g.a(file2, anrReason.toJson().toString());
        }
    }

    @Keep
    public static synchronized String getMainThreadStackTrace() {
        String sb;
        synchronized (AnrHandler.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                    sb2.append("  at ");
                    sb2.append(stackTraceElement);
                    sb2.append(com.snail.antifake.deviceid.e.f37542d);
                }
                sb2.append(com.snail.antifake.deviceid.e.f37542d);
                sb = sb2.toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
                return "";
            }
        }
        return sb;
    }

    @Keep
    public static boolean isRealNotResponding(final int i6) {
        com.kwad.sdk.core.d.c.d(TAG, "judge isRealNotResponding");
        try {
            b.isExceptionHappened.set(true);
            b.sCrashingPid = String.valueOf(Process.myPid());
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.5
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, i6);
                }
            });
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.4
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, AnrHandler.this.mIndex.getAndIncrement());
                }
            });
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.c.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
            @Override // android.os.FileObserver
            public final void onEvent(int i6, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }

    public static AnrHandler getInstance() {
        return a.aPc;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        MessageQueue queue;
        super.init(file, fVar, eVar);
        if (!com.kwad.sdk.crash.b.La()) {
            return;
        }
        com.kwad.sdk.core.d.c.d(TAG, "ANR init ");
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        String str = b.FILE_NAME_BASE;
        sb.append(str);
        sb.append("-anr");
        this.mDumpDir = new File(file2, sb.toString());
        new File(this.mLogDir, str);
        if (!DUMP_FROM_SIG_QUIT) {
            watchTraceFile();
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                queue = Looper.getMainLooper().getQueue();
                queue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in Idle");
                        AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                        return false;
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in main:");
                        AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                    }
                });
            }
        } catch (Throwable unused) {
            getUploader();
        }
    }

    @Keep
    public static void onCallFromNative(int i6) {
    }
}
