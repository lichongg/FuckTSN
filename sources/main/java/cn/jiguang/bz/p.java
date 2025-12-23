package cn.jiguang.bz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bv;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static PackageInfo f2775a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, HashMap<Integer, PackageInfo>> f2776b;

    /* renamed from: c, reason: collision with root package name */
    private static String f2777c;

    /* renamed from: d, reason: collision with root package name */
    private static int f2778d;

    /* renamed from: e, reason: collision with root package name */
    private static Object f2779e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<Integer, PackageInfo> f2780f;

    /* renamed from: g, reason: collision with root package name */
    private static int f2781g;

    private static int a() {
        int i6 = f2778d;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        try {
            Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
            Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
            f2778d = intValue;
            return intValue;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static synchronized PackageInfo b(Context context, int i6) {
        PackageInfo packageInfo;
        int i7;
        String str;
        StringBuilder sb;
        synchronized (p.class) {
            String a6 = a(context);
            try {
                packageInfo = a(i6);
            } catch (Throwable th) {
                th = th;
                packageInfo = null;
            }
            if (packageInfo != null) {
                return packageInfo;
            }
            try {
                cn.jiguang.bb.f.c(bv.f10809a, "no l p info cache, call sys api");
                if (f2781g == 0) {
                    i7 = i6 | 4303;
                    if (Build.VERSION.SDK_INT >= 28) {
                        i7 = 134222031 | i6;
                    }
                } else {
                    i7 = i6;
                }
                f2781g = i7 | f2781g;
                packageInfo = context.getPackageManager().getPackageInfo(a6, f2781g);
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.bb.f.i(bv.f10809a, "get l p info failed, error: " + th.getMessage());
                try {
                    cn.jiguang.bb.f.c(bv.f10809a, "get l p info again");
                    packageInfo = context.getPackageManager().getPackageInfo(a6, i6);
                    if (packageInfo == null) {
                        cn.jiguang.bb.f.i(bv.f10809a, "g l p info again failed, p info is null");
                    } else {
                        f2780f.put(Integer.valueOf(i6), packageInfo);
                        cn.jiguang.bb.f.c(bv.f10809a, "get l p info again success, flag: " + i6);
                    }
                } catch (Throwable th3) {
                    cn.jiguang.bb.f.i(bv.f10809a, "get l p again failed, error: " + th3.getMessage());
                }
                return packageInfo;
            }
            if (packageInfo == null) {
                cn.jiguang.bb.f.i(bv.f10809a, "g l p info failed, p info is null");
                packageInfo = context.getPackageManager().getPackageInfo(a6, i6);
                if (packageInfo != null) {
                    f2780f.put(Integer.valueOf(i6), packageInfo);
                    str = bv.f10809a;
                    sb = new StringBuilder();
                    sb.append("get l p info again success for l p is null, flag: ");
                    sb.append(i6);
                }
                return packageInfo;
            }
            f2775a = packageInfo;
            str = bv.f10809a;
            sb = new StringBuilder();
            sb.append("get l p info success, flag: ");
            sb.append(i6);
            sb.append(", flags: ");
            sb.append(f2781g);
            cn.jiguang.bb.f.c(str, sb.toString());
            return packageInfo;
        }
    }

    static {
        HashMap<String, HashMap<Integer, PackageInfo>> hashMap = new HashMap<>();
        f2776b = hashMap;
        hashMap.put("com.huawei.hwid", null);
        f2777c = "";
        f2778d = Integer.MIN_VALUE;
        f2780f = new HashMap<>();
        f2781g = 0;
    }

    private static PackageInfo a(int i6) {
        PackageInfo packageInfo = f2775a;
        if (packageInfo != null && (i6 == 0 || (f2781g & i6) != 0)) {
            return packageInfo;
        }
        HashMap<Integer, PackageInfo> hashMap = f2780f;
        if (hashMap.containsKey(Integer.valueOf(i6)) && hashMap.get(Integer.valueOf(i6)) != null) {
            return hashMap.get(Integer.valueOf(i6));
        }
        if (i6 != 0 || hashMap.size() <= 0) {
            return null;
        }
        for (Integer num : hashMap.keySet()) {
            num.intValue();
            PackageInfo packageInfo2 = f2780f.get(num);
            if (packageInfo2 != null) {
                return packageInfo2;
            }
        }
        return null;
    }

    public static PackageInfo b(Context context, String str, int i6) {
        String str2;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || i6 < 0) {
            str2 = "get third p info failed, because param is illegal";
        } else {
            try {
                int indexOf = str.indexOf(":");
                if (indexOf > 0) {
                    String substring = str.substring(0, indexOf);
                    cn.jiguang.bb.f.i(bv.f10809a, "get p info has p name, origin: " + str + ", new: " + substring);
                    str = substring;
                }
                if (TextUtils.equals(a(context), str)) {
                    return b(context, i6);
                }
                if (a(context, 1105, true) && a(context, 1100, true)) {
                    HashMap<Integer, PackageInfo> hashMap = f2776b.get(str);
                    if (hashMap != null) {
                        packageInfo = hashMap.get(Integer.valueOf(i6));
                        if (packageInfo != null) {
                            if (TextUtils.isEmpty(packageInfo.packageName)) {
                                packageInfo = null;
                            }
                            cn.jiguang.bb.f.c(bv.f10809a, "get third p info by mem-cache, p name: " + str + ", flag: " + i6 + ", pinfo: " + packageInfo);
                            return packageInfo;
                        }
                    } else {
                        packageInfo = null;
                    }
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i6);
                    } catch (Throwable unused) {
                    }
                    if (f2776b.containsKey(str)) {
                        HashMap<Integer, PackageInfo> hashMap2 = new HashMap<>();
                        hashMap2.put(Integer.valueOf(i6), packageInfo == null ? new PackageInfo() : packageInfo);
                        f2776b.put(str, hashMap2);
                        cn.jiguang.bb.f.c(bv.f10809a, "cache third p info, p name: " + str + ", flag: " + i6);
                    }
                    return packageInfo;
                }
                return null;
            } catch (Throwable th) {
                str2 = "get p info failed, error: " + th.getMessage();
            }
        }
        cn.jiguang.bb.f.i(bv.f10809a, str2);
        return null;
    }

    public static PackageInfo a(Context context, int i6) {
        return a(context, a(context), i6);
    }

    public static PackageInfo a(Context context, String str, int i6) {
        return a(context, str, i6, false);
    }

    public static PackageInfo a(Context context, String str, int i6, boolean z5) {
        PackageInfo a6 = (z5 || (a(context, 1109, true) && Build.VERSION.SDK_INT >= 33)) ? a(str, i6) : null;
        return a6 == null ? b(context, str, i6) : a6;
    }

    public static PackageInfo a(String str, int i6) {
        try {
            if (f2779e == null) {
                f2779e = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), null).invoke(null, null);
            }
            IBinder asBinder = ((IInterface) f2779e).asBinder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(asBinder.getInterfaceDescriptor());
            obtain.writeString(str);
            obtain.writeLong(i6);
            obtain.writeInt(a());
            asBinder.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            r0 = obtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable unused) {
        }
        return r0;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f2777c)) {
            return f2777c;
        }
        String packageName = context.getPackageName();
        f2777c = packageName;
        return packageName;
    }

    public static boolean a(Context context, int i6, boolean z5) {
        return cn.jiguang.g.a.a().b(i6, z5);
    }
}
