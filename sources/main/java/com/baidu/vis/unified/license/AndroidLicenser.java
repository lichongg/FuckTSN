package com.baidu.vis.unified.license;

import android.content.Context;
import android.util.Pair;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AndroidLicenser {
    private static String deviceID = "";
    private static ReentrantLock lock_instance = new ReentrantLock();
    private static boolean mAgree = false;
    private static String mIdFlag = "1";
    private static AndroidLicenser mInstance;
    private static boolean mOnline;
    private ReentrantLock lock = new ReentrantLock();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ErrorCode {
        SUCCESS,
        LICENSE_NOT_INIT_ERROR,
        LICENSE_DECRYPT_ERROR,
        LICENSE_INFO_FORMAT_ERROR,
        LICENSE_KEY_CHECK_ERROR,
        LICENSE_ALGORITHM_CHECK_ERROR,
        LICENSE_MD5_CHECK_ERROR,
        LICENSE_DEVICE_ID_CHECK_ERROR,
        LICENSE_PACKAGE_NAME_CHECK_ERROR,
        LICENSE_EXPIRED_TIME_CHECK_ERROR,
        LICENSE_FUNCTION_CHECK_ERROR,
        LICENSE_TIME_EXPIRED,
        LICENSE_LOCAL_FILE_ERROR,
        LICENSE_REMOTE_DATA_ERROR,
        LICENSE_LOCAL_TIME_ERROR,
        LICENSE_PARAM_ERROR,
        LICENSE_KEY_FILE_ERROR,
        OTHER_ERROR
    }

    private native void nativeDisableDeviceId(int i6);

    private native int nativeFaceAuthFromFile(Context context, String str, String str2, boolean z5, int i6);

    private native int nativeFaceAuthFromFolder(Context context, String str, boolean z5, int i6);

    private native int nativeFaceAuthFromMemory(Context context, String str, String[] strArr, String str2, int i6);

    private native BDLicenseAuthInfo nativeFaceAuthGetAuthInfo(Context context, int i6);

    private native BDLicenseLocalInfo nativeFaceAuthGetLocalInfo(Context context, int i6);

    private native int nativeFaceGetAuthStatus(int i6);

    private native String nativeFaceGetErrorMsg(int i6);

    private native int nativeFaceIsFunctionAvailable(String str, int i6);

    private native void nativeReleaseAuth(int i6);

    public static synchronized String getDeviceId(Context context) {
        Object obj;
        String str;
        synchronized (AndroidLicenser.class) {
            if ("".equals(deviceID)) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.baidu.liantian.ac.LH");
                    Class<?> cls = Boolean.TYPE;
                    loadClass.getDeclaredMethod("init", Context.class, cls).invoke(loadClass, context, Boolean.valueOf(mOnline));
                    loadClass.getDeclaredMethod("setAgreePolicy", Context.class, cls).invoke(loadClass, context, Boolean.valueOf(mAgree));
                    Pair pair = (Pair) loadClass.getDeclaredMethod("getId", Context.class, String.class).invoke(loadClass, context, mIdFlag);
                    if (pair != null && (obj = pair.second) != null) {
                        deviceID = ((String) obj).toUpperCase();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            str = deviceID;
        }
        return str;
    }

    public static synchronized AndroidLicenser getInstance() {
        AndroidLicenser androidLicenser;
        synchronized (AndroidLicenser.class) {
            lock_instance.lock();
            if (mInstance == null) {
                mInstance = new AndroidLicenser();
                try {
                    System.loadLibrary("bd_unifylicense");
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            lock_instance.unlock();
            androidLicenser = mInstance;
        }
        return androidLicenser;
    }

    public static void setAgree(boolean z5) {
        mAgree = z5;
    }

    public static void setIdFlag(String str) {
        mIdFlag = str;
    }

    public static void setOnline(boolean z5) {
        mOnline = z5;
    }

    public ErrorCode authFromFile(Context context, String str, String str2, boolean z5, int i6) {
        AndroidLicenser androidLicenser;
        int i7;
        this.lock.lock();
        try {
            i7 = nativeFaceAuthFromFile(context, str, str2, z5, i6);
            androidLicenser = this;
        } catch (Exception e6) {
            androidLicenser = this;
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e6.printStackTrace();
            i7 = ordinal;
        }
        androidLicenser.lock.unlock();
        return ErrorCode.values()[i7];
    }

    public ErrorCode authFromFolder(Context context, String str, boolean z5, int i6) {
        int i7;
        this.lock.lock();
        try {
            i7 = nativeFaceAuthFromFolder(context, str, z5, i6);
        } catch (Exception e6) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e6.printStackTrace();
            i7 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i7];
    }

    public ErrorCode authFromMemory(Context context, String str, String[] strArr, String str2, int i6) {
        AndroidLicenser androidLicenser;
        int i7;
        this.lock.lock();
        try {
            i7 = nativeFaceAuthFromMemory(context, str, strArr, str2, i6);
            androidLicenser = this;
        } catch (Exception e6) {
            androidLicenser = this;
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e6.printStackTrace();
            i7 = ordinal;
        }
        androidLicenser.lock.unlock();
        return ErrorCode.values()[i7];
    }

    public BDLicenseAuthInfo authGetAuthInfo(Context context, int i6) {
        BDLicenseAuthInfo bDLicenseAuthInfo;
        this.lock.lock();
        try {
            bDLicenseAuthInfo = nativeFaceAuthGetAuthInfo(context, i6);
        } catch (Exception e6) {
            BDLicenseAuthInfo bDLicenseAuthInfo2 = new BDLicenseAuthInfo("", -1, "", "", "", 0L, "");
            e6.printStackTrace();
            bDLicenseAuthInfo = bDLicenseAuthInfo2;
        }
        this.lock.unlock();
        return bDLicenseAuthInfo;
    }

    public BDLicenseLocalInfo authGetLocalInfo(Context context, int i6) {
        BDLicenseLocalInfo bDLicenseLocalInfo;
        this.lock.lock();
        try {
            bDLicenseLocalInfo = nativeFaceAuthGetLocalInfo(context, i6);
        } catch (Exception e6) {
            BDLicenseLocalInfo bDLicenseLocalInfo2 = new BDLicenseLocalInfo("", -1, "", "", "", "", "");
            e6.printStackTrace();
            bDLicenseLocalInfo = bDLicenseLocalInfo2;
        }
        this.lock.unlock();
        return bDLicenseLocalInfo;
    }

    private AndroidLicenser() {
    }

    public void authDisableDeviceId(int i6) {
        try {
            nativeDisableDeviceId(i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public ErrorCode authIsFuncAvailable(String str, int i6) {
        int i7;
        try {
            i7 = nativeFaceIsFunctionAvailable(str, i6);
        } catch (Exception e6) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e6.printStackTrace();
            i7 = ordinal;
        }
        return ErrorCode.values()[i7];
    }

    public void authReleaseAuth(int i6) {
        try {
            nativeReleaseAuth(i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public ErrorCode getAuthStatus(int i6) {
        int i7;
        try {
            i7 = nativeFaceGetAuthStatus(i6);
        } catch (Exception e6) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e6.printStackTrace();
            i7 = ordinal;
        }
        return ErrorCode.values()[i7];
    }

    public String getErrorMsg(int i6) {
        try {
            return nativeFaceGetErrorMsg(i6);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
