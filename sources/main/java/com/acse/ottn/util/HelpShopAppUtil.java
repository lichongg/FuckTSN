package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.acse.ottn.R;
import com.acse.ottn.c2;
import com.acse.ottn.e3;
import com.acse.ottn.i1;
import com.acse.ottn.j1;
import com.acse.ottn.j3;
import com.baidu.mobads.sdk.internal.by;
import com.tencent.mmkv.MMKV;
import java.io.ObjectStreamException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HelpShopAppUtil {
    private static char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static HelpShopAppUtil instance;
    private static Context mContext;

    private static String getAppIdFromMainfest(String str) {
        Bundle bundle;
        try {
            Context context = mContext;
            if (context == null) {
                return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static String getSessionId(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = MessageDigest.getInstance(by.f10823a).digest(str.getBytes());
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
        }
        return printHexBinary(bArr);
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getHmKey() {
        try {
            if (j3.a() == null) {
                return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
            }
            String e6 = j3.a().e("APP_KEY");
            if (TextUtils.isEmpty(e6) || e6 == null) {
                e6 = getAppIdFromMainfest("APP_KEY");
                j3.a().b("APP_KEY", e6);
            }
            c2.a("HelpShopAppUtil", "APP_KEY =" + e6);
            return e6;
        } catch (Exception e7) {
            c2.a("TAG", e7.getMessage());
            return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
        }
    }

    public static HelpShopAppUtil getInstance() {
        if (instance == null) {
            synchronized (HelpShopAppUtil.class) {
                try {
                    if (instance == null) {
                        instance = new HelpShopAppUtil();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private static void getWindowInfo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        if (j3.a() != null) {
            j3.a().a("screenWidth", i6);
            j3.a().a("screenHight", i7);
        }
    }

    public static void init(Context context) {
        mContext = context;
        MMKV.initialize(context);
        getWindowInfo();
        getHmKey();
    }

    public static void playVideo(Context context) {
        MediaPlayer create = MediaPlayer.create(context, R.raw.lucky_money);
        create.setVolume(0.3f, 0.3f);
        create.start();
    }

    private static String printHexBinary(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            sb.append(hexCode[(b6 >> 4) & 15]);
            sb.append(hexCode[b6 & 15]);
        }
        return sb.toString();
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    private HelpShopAppUtil() {
    }

    public static String randomSessionExID() {
        if (j3.a() == null) {
            return "";
        }
        String e6 = j3.a().e("sessionID");
        if (e6 != null && !"".equals(e6)) {
            return e6;
        }
        String substring = e3.c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
        String replace = String.format("%32s", "0" + Long.toHexString(new Long(System.currentTimeMillis()).longValue()) + substring).replace(' ', 'f');
        j3.a().b("sessionID", replace);
        return replace;
    }

    public static String randomSessionNewID() {
        if (j3.a() == null) {
            return "";
        }
        String d6 = i1.a().d("sessionID");
        if (d6 != null && !"".equals(d6)) {
            return d6;
        }
        String substring = e3.c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
        String replace = String.format("%32s", "0" + Long.toHexString(new Long(System.currentTimeMillis()).longValue()) + substring).replace(' ', 'f');
        i1.a().b("sessionID", replace);
        return replace;
    }

    public static String sessionExID() {
        if (j3.a() == null || i1.a() == null) {
            return "";
        }
        String d6 = i1.a().d("sessionID");
        if (!TextUtils.isEmpty(d6)) {
            j3.a().b("sessionID", d6);
            i1.a().b("sessionID", "");
            return d6;
        }
        String e6 = j3.a().e("sessionID");
        if (TextUtils.isEmpty(e6)) {
            return randomSessionExID();
        }
        return e6;
    }

    public static String sessionID() {
        String d6 = i1.a().d("sessionID");
        if (TextUtils.isEmpty(d6)) {
            return randomSessionNewID();
        }
        return d6;
    }

    public Long createRandomNumber() {
        if (j3.a() == null) {
            return 14400L;
        }
        if (j3.a().d("random_num") == 0) {
            j3.a().a("random_num", new Random().nextInt(7200) + 10800);
        }
        return Long.valueOf(j3.a().d("random_num"));
    }

    public String getAppName() {
        return j1.c().b();
    }
}
