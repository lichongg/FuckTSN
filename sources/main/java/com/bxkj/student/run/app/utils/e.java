package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f20210a = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f20211b = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f20212c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    public static boolean d(Context paramContext) {
        try {
            new ArrayList();
            List a6 = a(paramContext);
            if (a6.size() == 0) {
                int i6 = 0;
                while (true) {
                    String[] strArr = f20211b;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    if (i6 == 0) {
                        if (!new File(strArr[i6]).exists()) {
                            a6.add(Integer.valueOf(i6));
                        }
                    } else if (new File(strArr[i6]).exists()) {
                        a6.add(Integer.valueOf(i6));
                    }
                    i6++;
                }
            }
            if (a6.size() == 0) {
                a6 = e(paramContext);
            }
            return (a6.size() == 0 ? null : a6.toString()) != null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private static List a(Context context) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            try {
                String[] strArr = f20210a;
                if (i7 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i7], 1);
                    arrayList.add(strArr[i7]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i7++;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = f20212c;
                if (i6 >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i6]).exists()) {
                    arrayList.add(strArr2[i6]);
                }
                i6++;
            }
        }
        return arrayList;
    }

    public static List c(Context paramContext) {
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        try {
            String b6 = b(a(paramContext));
            if (!TextUtils.isEmpty(b6)) {
                arrayList.add(b6);
                return arrayList;
            }
            List e6 = e(paramContext);
            if (e6.size() <= 0) {
                return arrayList;
            }
            arrayList.add(e6.get(0));
            return arrayList;
        } catch (Exception e7) {
            e7.printStackTrace();
            return arrayList;
        }
    }

    public static List e(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        for (int i6 = 0; i6 < queryIntentActivities.size(); i6++) {
            ActivityInfo activityInfo = queryIntentActivities.get(i6).activityInfo;
            String str = activityInfo.packageName;
            String str2 = activityInfo.name;
            activityInfo.loadLabel(context.getPackageManager());
            if (!TextUtils.isEmpty(str) && str.contains("bluestacks")) {
                arrayList.add("蓝叠");
                return arrayList;
            }
        }
        return arrayList;
    }

    private static String b(List<String> list) {
        if (list.size() == 0) {
            return "";
        }
        String str = list.get(0);
        if (str.contains("mumu")) {
            return "mumu";
        }
        if (str.contains("ami")) {
            return "AMIDuOS";
        }
        if (str.contains("bluestacks")) {
            return "蓝叠";
        }
        if (!str.contains("kaopu001") && !str.contains("tiantian")) {
            if (str.contains("kpzs")) {
                return "靠谱助手";
            }
            if (str.contains("genymotion")) {
                String str2 = Build.MODEL;
                if (str2.contains("iTools")) {
                    return "iTools";
                }
                if (!str2.contains("ChangWan")) {
                    return "genymotion";
                }
                return "畅玩";
            }
            if (str.contains("uc")) {
                return "uc";
            }
            if (str.contains("blue")) {
                return "blue";
            }
            if (str.contains("microvirt")) {
                return "逍遥";
            }
            if (str.contains("itools")) {
                return "itools";
            }
            if (str.contains("syd")) {
                return "手游岛";
            }
            if (str.contains("bignox")) {
                return "夜神";
            }
            if (str.contains("haimawan")) {
                return "海马玩";
            }
            if (str.contains("windroy")) {
                return "windroy";
            }
            if (str.contains("flysilkworm")) {
                return "雷电";
            }
            if (str.contains("emu")) {
                return "emu";
            }
            if (str.contains("le8")) {
                return "le8";
            }
            if (str.contains("vphone")) {
                return "vphone";
            }
            if (!str.contains("duoyi")) {
                return "";
            }
            return "多益";
        }
        return "天天";
    }
}
