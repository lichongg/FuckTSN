package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = au.b().b(au.f40896a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    private static boolean checkPermission(Context context, String str) {
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(origApplicationContext, th);
                }
            } else {
                try {
                    if (origApplicationContext.getPackageManager().checkPermission(str, origApplicationContext.getPackageName()) == 0) {
                        return true;
                    }
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(origApplicationContext, th2);
                }
            }
        }
        return false;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    try {
                        if (file.isDirectory() && (list = file.list()) != null) {
                            return list.length;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file2, File file3) {
                            long lastModified = file2.lastModified() - file3.lastModified();
                            if (lastModified > 0) {
                                return 1;
                            }
                            if (lastModified == 0) {
                                return 0;
                            }
                            return -1;
                        }
                    });
                    return listFiles[0];
                }
                return null;
            } finally {
            }
        }
    }

    private static String getProcessName(int i6) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i6 + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return readLine;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    int myPid = Process.myPid();
                    String processName2 = getProcessName(myPid);
                    if (TextUtils.isEmpty(processName2)) {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    sCurrentProcessName = next.processName;
                                    break;
                                }
                            }
                        }
                    } else {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j6, long j7) {
        return (j6 < j7 ? j7 - j6 : j6 - j7) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } finally {
                return mDefaultEnvelopeDirPath;
            }
        }
        return mDefaultEnvelopeDirPath;
    }

    public static long getLastInstantBuildTime(Context context) {
        long j6;
        synchronized (mEnvelopeBuildTimeLock) {
            j6 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j6;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j6;
        synchronized (mEnvelopeBuildTimeLock) {
            j6 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j6;
    }

    public static String getSubProcessName(Context context) {
        String str;
        str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            str = indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
            if (indexOf >= 0) {
                return str;
            }
            String packageName = context.getPackageName();
            return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
            return str;
        }
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] listFiles;
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? "i" : "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = bi.aG;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = "h";
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            } finally {
            }
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().startsWith(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, g.f36042b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(StubApp.getOrigApplicationContext(context.getApplicationContext()), th);
            return false;
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i6) {
        File[] listFiles;
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            } finally {
            }
            if (listFiles != null && listFiles.length > i6) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long lastModified = file2.lastModified() - file3.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        if (lastModified == 0) {
                            return 0;
                        }
                        return -1;
                    }
                });
                if (listFiles.length > i6) {
                    for (int i7 = 0; i7 < listFiles.length - i6; i7++) {
                        if (!listFiles[i7].delete()) {
                            ULog.d("--->>> remove [" + i7 + "] file fail.");
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                            boolean a6 = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                            boolean b6 = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                            if (a6) {
                                updateLastSuccessfulBuildTime(context);
                            }
                            if (b6) {
                                updateLastInstantBuildTime(context);
                            }
                            return 0;
                        } catch (IOException e6) {
                            e = e6;
                            fileOutputStream = fileOutputStream2;
                            UMCrashManager.reportCrash(context, e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th) {
                                    UMCrashManager.reportCrash(context, th);
                                }
                            }
                            return 101;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    UMCrashManager.reportCrash(context, th3);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (!TextUtils.isEmpty(legacyEnvelopeDir) && !legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            File file = new File(context.getFilesDir().getAbsolutePath() + com.kuaishou.weapon.p0.bi.f35777j + legacyEnvelopeDir);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    try {
                        if (file.isDirectory()) {
                            file.delete();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        UMCrashManager.reportCrash(context, th2);
                        return;
                    }
                }
                try {
                    String envelopeDirPath = getEnvelopeDirPath(context);
                    for (int i6 = 0; i6 < listFiles.length; i6++) {
                        listFiles[i6].renameTo(new File(envelopeDirPath + File.separator + listFiles[i6].getName()));
                    }
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    UMCrashManager.reportCrash(context, th3);
                    return;
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String b6 = au.b().b(au.B);
                String replace = currentProcessName.replace(':', '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return b6 + replace;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                if (file != null) {
                    try {
                        if (file.exists()) {
                            return file.delete();
                        }
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(appContext, th);
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        Throwable th;
        IOException iOException;
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel fileChannel = null;
            try {
                try {
                    FileChannel channel = new RandomAccessFile(str, t.f36150k).getChannel();
                    try {
                        MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                        bArr = new byte[(int) channel.size()];
                        if (load.remaining() > 0) {
                            load.get(bArr, 0, load.remaining());
                        }
                        try {
                            channel.close();
                        } catch (Throwable th2) {
                            UMCrashManager.reportCrash(appContext, th2);
                        }
                    } catch (IOException e6) {
                        iOException = e6;
                        fileChannel = channel;
                        UMCrashManager.reportCrash(appContext, iOException);
                        throw iOException;
                    } catch (Throwable th3) {
                        th = th3;
                        fileChannel = channel;
                        try {
                            fileChannel.close();
                            throw th;
                        } catch (Throwable th4) {
                            UMCrashManager.reportCrash(appContext, th4);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (IOException e7) {
                iOException = e7;
            }
        }
        return bArr;
    }
}
