package com.bxkj.student.v2.common.utils.safe;

import android.os.Build;
import android.provider.Settings;
import com.bxkj.student.App;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.Locale;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f20939a = new d();

    private final boolean b() {
        String FINGERPRINT = Build.FINGERPRINT;
        g0.o(FINGERPRINT, "FINGERPRINT");
        if (u.H2(FINGERPRINT, "generic", false, 2, null)) {
            return true;
        }
        g0.o(FINGERPRINT, "FINGERPRINT");
        Locale locale = Locale.getDefault();
        g0.o(locale, "getDefault(...)");
        String lowerCase = FINGERPRINT.toLowerCase(locale);
        g0.o(lowerCase, "toLowerCase(...)");
        if (u.l3(lowerCase, "vbox", false, 2, null)) {
            return true;
        }
        g0.o(FINGERPRINT, "FINGERPRINT");
        Locale locale2 = Locale.getDefault();
        g0.o(locale2, "getDefault(...)");
        String lowerCase2 = FINGERPRINT.toLowerCase(locale2);
        g0.o(lowerCase2, "toLowerCase(...)");
        if (u.l3(lowerCase2, "test-keys", false, 2, null)) {
            return true;
        }
        String MODEL = Build.MODEL;
        g0.o(MODEL, "MODEL");
        if (u.l3(MODEL, "Emulator", false, 2, null)) {
            return true;
        }
        g0.o(MODEL, "MODEL");
        if (u.l3(MODEL, "Android SDK built for x86", false, 2, null)) {
            return true;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        g0.o(MANUFACTURER, "MANUFACTURER");
        if (u.l3(MANUFACTURER, "Genymotion", false, 2, null)) {
            return true;
        }
        String BRAND = Build.BRAND;
        g0.o(BRAND, "BRAND");
        if (u.H2(BRAND, "generic", false, 2, null)) {
            String DEVICE = Build.DEVICE;
            g0.o(DEVICE, "DEVICE");
            if (u.H2(DEVICE, "generic", false, 2, null)) {
                return true;
            }
        }
        String PRODUCT = Build.PRODUCT;
        if (g0.g("google_sdk", PRODUCT)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        g0.o(HARDWARE, "HARDWARE");
        if (u.l3(HARDWARE, "goldfish", false, 2, null)) {
            return true;
        }
        g0.o(HARDWARE, "HARDWARE");
        if (u.l3(HARDWARE, "ranchu", false, 2, null)) {
            return true;
        }
        g0.o(HARDWARE, "HARDWARE");
        if (u.l3(HARDWARE, "vbox86", false, 2, null)) {
            return true;
        }
        g0.o(PRODUCT, "PRODUCT");
        if (u.l3(PRODUCT, "sdk", false, 2, null)) {
            return true;
        }
        g0.o(PRODUCT, "PRODUCT");
        if (u.l3(PRODUCT, "google_sdk", false, 2, null)) {
            return true;
        }
        g0.o(PRODUCT, "PRODUCT");
        if (u.l3(PRODUCT, "sdk_x86", false, 2, null)) {
            return true;
        }
        g0.o(PRODUCT, "PRODUCT");
        if (u.l3(PRODUCT, "vbox86p", false, 2, null)) {
            return true;
        }
        String BOARD = Build.BOARD;
        g0.o(BOARD, "BOARD");
        Locale locale3 = Locale.getDefault();
        g0.o(locale3, "getDefault(...)");
        String lowerCase3 = BOARD.toLowerCase(locale3);
        g0.o(lowerCase3, "toLowerCase(...)");
        if (u.l3(lowerCase3, "nox", false, 2, null)) {
            return true;
        }
        String BOOTLOADER = Build.BOOTLOADER;
        g0.o(BOOTLOADER, "BOOTLOADER");
        Locale locale4 = Locale.getDefault();
        g0.o(locale4, "getDefault(...)");
        String lowerCase4 = BOOTLOADER.toLowerCase(locale4);
        g0.o(lowerCase4, "toLowerCase(...)");
        if (u.l3(lowerCase4, "nox", false, 2, null)) {
            return true;
        }
        g0.o(HARDWARE, "HARDWARE");
        Locale locale5 = Locale.getDefault();
        g0.o(locale5, "getDefault(...)");
        String lowerCase5 = HARDWARE.toLowerCase(locale5);
        g0.o(lowerCase5, "toLowerCase(...)");
        if (u.l3(lowerCase5, "nox", false, 2, null)) {
            return true;
        }
        g0.o(PRODUCT, "PRODUCT");
        Locale locale6 = Locale.getDefault();
        g0.o(locale6, "getDefault(...)");
        String lowerCase6 = PRODUCT.toLowerCase(locale6);
        g0.o(lowerCase6, "toLowerCase(...)");
        if (u.l3(lowerCase6, "nox", false, 2, null)) {
            return true;
        }
        String SERIAL = Build.SERIAL;
        g0.o(SERIAL, "SERIAL");
        Locale locale7 = Locale.getDefault();
        g0.o(locale7, "getDefault(...)");
        String lowerCase7 = SERIAL.toLowerCase(locale7);
        g0.o(lowerCase7, "toLowerCase(...)");
        if (u.l3(lowerCase7, "nox", false, 2, null)) {
            return true;
        }
        g0.o(BRAND, "BRAND");
        if (u.H2(BRAND, "generic", false, 2, null)) {
            String DEVICE2 = Build.DEVICE;
            g0.o(DEVICE2, "DEVICE");
            if (u.H2(DEVICE2, "generic", false, 2, null)) {
                return true;
            }
        }
        return g0.g("google_sdk", PRODUCT) || Settings.Secure.getString(App.f17573d.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) == null || new File("/init.goldfish.rc").exists() || new File("/sys/qemu_trace").exists() || new File("/system/bin/qemu_props").exists() || new File("/dev/socket/qemud").exists() || new File("/dev/qemu_pipe").exists();
    }

    public final boolean a() {
        return EmulatorDetectUtil.b(App.f17573d.a()) || b();
    }

    private d() {
    }
}
