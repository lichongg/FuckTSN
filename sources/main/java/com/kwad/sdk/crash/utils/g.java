package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private static final String TAG = "g";
    private static final File aQX = new File("/proc/self/fd");
    private static final File aQY = new File("/proc/self/task");

    public static void a(ExceptionMessage exceptionMessage, int i6) {
        com.kwad.sdk.crash.h Lx = com.kwad.sdk.crash.e.Lr().Lx();
        if (Lx == null) {
            com.kwad.sdk.core.d.c.d(CommonNetImpl.TAG, "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = Lx.oH().toString();
        }
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    public static void F(File file) {
        try {
            d.a(SystemUtil.eX(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", ConstantHelper.LOG_OS, "-b", com.umeng.analytics.pro.d.ax, "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", ConstantHelper.LOG_OS, "-b", com.umeng.analytics.pro.d.ax, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    public static void G(File file) {
        if (file == null) {
            return;
        }
        try {
            w.N(file);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    public static void I(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object field = z.getField(z.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 1006632960);
            FileDescriptor fileDescriptor = open;
            if (!SystemUtil.eX(26)) {
                fileDescriptor = open.getFileDescriptor();
            }
            if (SystemUtil.eX(24)) {
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                z.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool, bool2, bool2, bool, bool, new String[0]);
            } else if (SystemUtil.eX(23)) {
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                z.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, bool3, bool4, bool4, bool3, new String[0]);
            } else if (SystemUtil.eX(19)) {
                Boolean bool5 = Boolean.TRUE;
                z.callMethod(field, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, bool5, bool5, new String[0]);
            }
            ParcelFileDescriptor open2 = ParcelFileDescriptor.open(file, 973078528);
            FileDescriptor fileDescriptor2 = open2;
            if (!SystemUtil.eX(26)) {
                fileDescriptor2 = open2.getFileDescriptor();
            }
            z.callMethod(field, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.Lr().getContext())});
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    private static int Mb() {
        File[] listFiles;
        File file = aQX;
        ax.checkNotNull(file);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return listFiles.length;
        }
        return 0;
    }

    private static double aN(long j6) {
        return BigDecimal.valueOf((j6 >> 20) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String cd(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStream)).getString("task_id");
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return "";
        } catch (JSONException e7) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStream);
        }
    }

    private static String ce(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.Lr().getSdkVersion() + com.snail.antifake.deviceid.e.f37542d);
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + com.snail.antifake.deviceid.e.f37542d);
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + com.snail.antifake.deviceid.e.f37542d);
            sb.append("DexPath: " + cf(context) + com.snail.antifake.deviceid.e.f37542d);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
        return sb.toString();
    }

    private static String cf(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String obj = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i6 = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(obj);
            sb.append(sb2.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                i6++;
                sb.append("\nClassLoader " + i6 + " : " + classLoader.toString());
            }
            if (obj != null) {
                String[] split = obj.split("\"");
                if (split.length >= 2) {
                    sb.append("\n====path: " + split[1] + ", length: " + fW(split[1]));
                }
            }
        }
        return sb.toString();
    }

    public static String fU(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String fV(String str) {
        return (str.contains("(") && str.contains(")")) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long fW(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String fX(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split(com.snail.antifake.deviceid.e.f37542d)) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        return sb.substring(0);
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean q(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    private g() {
    }

    public static void H(File file) {
        try {
            w.S(file);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                    try {
                        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                            String b6 = b(entry.getValue());
                            if (b6.isEmpty()) {
                                b6 = "(no managed stack frames)\n";
                            }
                            bufferedWriter2.write(entry.getKey().getName());
                            bufferedWriter2.newLine();
                            bufferedWriter2.write(b6);
                            bufferedWriter2.newLine();
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (IOException e7) {
                        e = e7;
                        bufferedWriter = bufferedWriter2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        b.closeQuietly(bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        b.closeQuietly(bufferedWriter);
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    private static String aj(@NonNull String str, String str2) {
        ax.hh(str);
        if (!str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.lastIndexOf(str2));
    }

    public static void d(File file, File file2) {
        BufferedReader bufferedReader;
        try {
            w.S(file);
            w.S(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                bufferedWriter2.write(readLine);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (IOException e7) {
                                e = e7;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e8) {
                        e = e8;
                    } catch (IOException e9) {
                        e = e9;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    bufferedReader = null;
                } catch (IOException e11) {
                    e = e11;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e12) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e12);
        }
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.Lr().Lu();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.Lr().getSdkVersion();
    }

    public static String r(Throwable th) {
        String th2 = th.toString();
        StringWriter stringWriter = null;
        try {
            try {
                StringWriter stringWriter2 = new StringWriter();
                try {
                    f.a(th, new PrintWriter(stringWriter2));
                    String stringWriter3 = stringWriter2.toString();
                    b.closeQuietly(stringWriter2);
                    return stringWriter3;
                } catch (Exception e6) {
                    e = e6;
                    stringWriter = stringWriter2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    b.closeQuietly(stringWriter);
                    return th2;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                    b.closeQuietly(stringWriter);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.Lr().Ly();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.Lr().Lv()));
        exceptionMessage.mBuildConfigInfo = ce(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = cd(context);
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) {
        String r5 = r(th);
        if (th instanceof StackOverflowError) {
            r5 = fX(r5);
        }
        exceptionMessage.mCrashDetail = r5.replaceAll("[\n\t]", "#");
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (!com.kwad.sdk.crash.d.aOJ.matcher(absolutePath).matches() && !com.kwad.sdk.crash.d.aOK.matcher(absolutePath).matches()) {
            Matcher matcher = com.kwad.sdk.crash.d.aOL.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aOM.matcher(absolutePath);
            if (matcher.matches()) {
                exceptionMessage.mVirtualApp = matcher.group(1);
                return;
            } else if (matcher2.matches()) {
                exceptionMessage.mVirtualApp = matcher2.group(1);
                return;
            } else {
                exceptionMessage.mVirtualApp = absolutePath;
                return;
            }
        }
        exceptionMessage.mVirtualApp = context.getPackageName();
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (q(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) {
        SystemUtil.a RO = SystemUtil.RO();
        RO.baY = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        RO.baU = SystemUtil.RN();
        long pss = Debug.getPss();
        RO.baX = pss;
        memoryInfo.mTotalMB = (int) (RO.baU / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aOI / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (RO.baY / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        memoryInfo.mVssMB = (int) (RO.baV / 1024);
        memoryInfo.mRssMB = (int) (RO.baW / 1024);
        memoryInfo.mPssMB = (int) (pss / 1024);
        memoryInfo.mThreadsCount = RO.mThreadsCount;
        memoryInfo.mFdCount = Mb();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.dO(context) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] listFiles = aQX.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        memoryInfo.mFds.add(Os.readlink(file.getPath()));
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (RO.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    public static boolean b(com.kwad.sdk.crash.model.b bVar) {
        boolean z5 = (bVar.aPm & 2) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isNativeOpen:" + z5);
        return z5;
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] listFiles = aQY.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.J(new File(file, "comm"));
            } catch (IOException e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = aj(threadInfo.mName, com.snail.antifake.deviceid.e.f37542d);
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = aN(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
                diskInfo.mDataAvailableGB = aN(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && !bc.useStoragePermissionDisable() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = aN(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = aN(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) {
        String readLine;
        try {
            w.S(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e7) {
                                e = e7;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!readLine.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void a(File file, CharSequence charSequence, boolean z5) {
        a(file, charSequence, Charset.defaultCharset(), z5);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z5) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z5);
    }

    private static void a(File file, String str, Charset charset, boolean z5) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = w.a(file, z5);
            h.a(str, fileOutputStream, charset);
            a(fileOutputStream);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        } finally {
            b.closeQuietly(fileOutputStream);
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return false;
        }
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i6) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static boolean a(com.kwad.sdk.crash.model.b bVar) {
        boolean z5 = (bVar.aPm & 1) != 0;
        com.kwad.sdk.core.d.c.d(TAG, "isAnrOpen:" + z5);
        return z5;
    }
}
