package xyz.adscope.common.v2.dev.info;

import android.os.Build;
import android.text.TextUtils;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class OEMSystemInfo {
    private OEMInfo mInfo;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.info.OEMSystemInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static OEMSystemInfo instance = new OEMSystemInfo(null);

        private InstanceHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum OEM {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        OPPO("ColorOS", "ro.build.version.oplusrom"),
        MIUI("MIUI", "ro.miui.ui.version.name"),
        HYPER("HyperOS", "ro.mi.os.version.incremental"),
        REDMI("MIUI", "ro.miui.ui.version.name"),
        HARMONY("HarmonyOS", "hw_sc.build.platform.version"),
        MAGICUI("MagicUI", "ro.build.version.magic"),
        EMUI("EMUI", "ro.build.version.emui"),
        MEIZU("Flyme", "ro.build.display.id"),
        ONEPLUS("HydrogenOS", "ro.rom.version"),
        VIVO("Funtouch", "ro.vivo.os.version"),
        NUBIA("ro.build.nubia.rom.name", "ro.build.nubia.rom.code");

        private final String ROM;
        private final String propVersion;

        OEM(String str, String str2) {
            this.ROM = str;
            this.propVersion = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class OEMInfo {
        private final String ROM;
        private final String VER;

        /* synthetic */ OEMInfo(String str, String str2, AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        private OEMInfo(String str, String str2) {
            this.ROM = str;
            this.VER = str2;
        }
    }

    /* synthetic */ OEMSystemInfo(AnonymousClass1 anonymousClass1) {
        this();
    }

    private OEMSystemInfo() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private String getSystemPropValue(String str) {
        return SystemPropertiesUtil.get(str, "");
    }

    private void initXiaoMiSeries(String str) {
        try {
            if (Integer.parseInt(SystemPropertiesUtil.get("ro.miui.ui.version.code", "0")) >= 816) {
                initByOEM(str, OEM.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        initByOEM(str, OEM.MIUI);
    }

    private boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return false;
        }
    }

    public String getROM() {
        OEMInfo oEMInfo = this.mInfo;
        return oEMInfo != null ? oEMInfo.ROM : "";
    }

    public String getRomVersion() {
        OEMInfo oEMInfo = this.mInfo;
        return oEMInfo != null ? oEMInfo.VER : "";
    }

    public void initializeOEMInfo() {
        OEM oem;
        if (this.mInfo != null) {
            return;
        }
        String shrinkBoard = shrinkBoard(Build.BRAND);
        if (TextUtils.isEmpty(shrinkBoard)) {
            return;
        }
        try {
            oem = OEM.valueOf(shrinkBoard);
        } catch (IllegalArgumentException unused) {
            oem = null;
        }
        if (oem != null) {
            initByOEM(shrinkBoard, oem);
            return;
        }
        shrinkBoard.getClass();
        switch (shrinkBoard) {
            case "XIAOMI":
                initXiaoMiSeries(shrinkBoard);
                break;
            case "HONOR":
                initHonorSeries(shrinkBoard);
                break;
            case "HUAWEI":
                initHuaweiSeries(shrinkBoard);
                break;
        }
    }

    public static OEMSystemInfo getInstance() {
        return InstanceHolder.instance;
    }

    private void initByOEM(String str, OEM oem) {
        String str2;
        if (!TextUtils.isEmpty(oem.ROM)) {
            if (!oem.ROM.contains(".")) {
                str2 = oem.ROM;
            } else {
                str2 = getSystemPropValue(oem.ROM);
            }
            this.mInfo = new OEMInfo(str2, getSystemPropValue(oem.propVersion), null);
        }
    }

    private void initHonorSeries(String str) {
        if (isHarmonyOS()) {
            initByOEM(str, OEM.HARMONY);
            return;
        }
        OEM oem = OEM.MAGICUI;
        if (!TextUtils.isEmpty(getSystemPropValue(oem.propVersion))) {
            initByOEM(str, oem);
        } else {
            initByOEM(str, OEM.EMUI);
        }
    }

    private void initHuaweiSeries(String str) {
        if (isHarmonyOS()) {
            initByOEM(str, OEM.HARMONY);
        } else {
            initByOEM(str, OEM.EMUI);
        }
    }

    private String shrinkBoard(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll(" ", "").toUpperCase();
    }
}
