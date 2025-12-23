package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class SystemUtil {
    private static long baQ;
    private static long baR;
    private static int baS;
    private static LEVEL baT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        public final int getValue() {
            return this.value;
        }

        LEVEL(int i6) {
            this.value = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public long baU;
        public long baV;
        public long baW;
        public long baX;
        public long baY;
        public int mThreadsCount;
    }

    public static long RN() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i6 = 0; i6 <= 0; i6++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static a RO() {
        String az;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", com.kuaishou.weapon.p0.t.f36150k);
            while (true) {
                try {
                    String readLine = randomAccessFile2.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                        return aVar;
                    }
                    if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                            String az2 = az(readLine, "VmSize");
                            if (az2 != null) {
                                aVar.baV = Long.valueOf(az2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String az3 = az(readLine, "VmRSS:");
                            if (az3 != null) {
                                aVar.baW = Long.valueOf(az3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (az = az(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(az).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean dN(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, com.kuaishou.weapon.p0.g.f36043c);
    }

    public static long dO(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static float dP(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        try {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0) {
                return 0.0f;
            }
            return streamVolume / streamMaxVolume;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    private static String az(String str, String str2) {
        int length = str2.length();
        int i6 = -1;
        while (true) {
            if (length < str.length()) {
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    if (i6 == -1) {
                        i6 = length;
                    }
                } else if (i6 != -1) {
                    break;
                }
                length++;
            } else {
                length = -1;
                break;
            }
        }
        if (i6 == -1) {
            return null;
        }
        if (length == -1) {
            return str.substring(i6);
        }
        return str.substring(i6, length);
    }

    public static int dQ(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean eX(int i6) {
        if (getApiLevel() >= i6) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return ay.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return ay.isInMainProcess(context);
    }

    public static void checkUiThread() {
    }
}
