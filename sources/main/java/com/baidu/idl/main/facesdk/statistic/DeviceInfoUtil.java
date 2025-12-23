package com.baidu.idl.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DeviceInfoUtil {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.idl.main.facesdk.statistic.DeviceInfoUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i6 = 3; i6 < name.length(); i6++) {
                if (name.charAt(i6) < '0' || name.charAt(i6) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String CurPath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    public static Integer getCPUBit() {
        String str;
        try {
            str = getFieldFromCpuinfo("Processor");
        } catch (IOException e6) {
            e6.printStackTrace();
            str = null;
        }
        if (str != null) {
            return str.contains("aarch64") ? 64 : 32;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (r2 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005e, code lost:
    
        if (r2 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getDeviceBasicFrequency() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47 java.io.FileNotFoundException -> L4c
            java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47 java.io.FileNotFoundException -> L4c
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L38 java.io.FileNotFoundException -> L3d
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L38 java.io.FileNotFoundException -> L3d
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2f java.io.FileNotFoundException -> L31
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2f java.io.FileNotFoundException -> L31
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2f java.io.FileNotFoundException -> L31
            r1.close()     // Catch: java.io.IOException -> L1d
            goto L21
        L1d:
            r1 = move-exception
            r1.printStackTrace()
        L21:
            r2.close()     // Catch: java.io.IOException -> L26
            goto L7a
        L26:
            r1 = move-exception
            r1.printStackTrace()
            goto L7a
        L2c:
            r0 = move-exception
            goto L7b
        L2f:
            r0 = move-exception
            goto L51
        L31:
            r0 = move-exception
            goto L69
        L33:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L7b
        L38:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L51
        L3d:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L69
        L42:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L7b
        L47:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L51
        L4c:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L69
        L51:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r0 = move-exception
            r0.printStackTrace()
        L5e:
            if (r2 == 0) goto L79
        L60:
            r2.close()     // Catch: java.io.IOException -> L64
            goto L79
        L64:
            r0 = move-exception
            r0.printStackTrace()
            goto L79
        L69:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L76
            r1.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r0 = move-exception
            r0.printStackTrace()
        L76:
            if (r2 == 0) goto L79
            goto L60
        L79:
            r0 = 0
        L7a:
            return r0
        L7b:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L81
            goto L85
        L81:
            r1 = move-exception
            r1.printStackTrace()
        L85:
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.io.IOException -> L8b
            goto L8f
        L8b:
            r1 = move-exception
            r1.printStackTrace()
        L8f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.statistic.DeviceInfoUtil.getDeviceBasicFrequency():int");
    }

    public static String getDeviceBoard() {
        return Build.BOARD;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceProcessor() {
        try {
            String[] split = new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2);
            for (int i6 = 0; i6 < split.length; i6++) {
            }
            return split[1];
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        } catch (IOException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static String getDeviceProduct() {
        return Build.PRODUCT;
    }

    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getFieldFromCpuinfo(String str) throws IOException {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                }
                matcher = compile.matcher(readLine);
            } finally {
                bufferedReader.close();
            }
        } while (!matcher.matches());
        return matcher.group(1);
    }

    public static int getNumberOfCPUCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return 0;
        }
    }

    public static long getRamInfo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String getStoragePath(Context context, int i6) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", null).invoke(storageManager, null);
            if (i6 == 0) {
                return strArr[i6];
            }
            if (i6 == 1 && strArr.length > 1) {
                return strArr[i6];
            }
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return null;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getStorageInfo(Context context, int i6) {
        String storagePath = getStoragePath(context, i6);
        if (isSDCardMount() && storagePath != null && !storagePath.toString().equals("")) {
            StatFs statFs = new StatFs(new File(storagePath).getPath());
            long blockCountLong = statFs.getBlockCountLong();
            long blockSizeLong = statFs.getBlockSizeLong();
            long j6 = blockCountLong * blockSizeLong;
            return "可用/总共：" + Long.toString(statFs.getAvailableBlocksLong() * blockSizeLong) + "/" + Long.toString(j6);
        }
        return "无外置SD卡";
    }

    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
