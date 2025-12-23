package cn.jiguang.p;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import cn.jiguang.bb.f;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.internal.ViewUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.umeng.socialize.common.SocializeConstants;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static int a(BluetoothDevice bluetoothDevice) {
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass != null) {
            int majorDeviceClass = bluetoothClass.getMajorDeviceClass();
            if (majorDeviceClass == 256) {
                return 1;
            }
            if (majorDeviceClass == 512) {
                return 2;
            }
            if (majorDeviceClass == 1280) {
                return 3;
            }
            if (majorDeviceClass == 1536) {
                return 4;
            }
            if (majorDeviceClass == 1792) {
                return 5;
            }
            if (majorDeviceClass == 2048) {
                return 6;
            }
            if (majorDeviceClass == 2304) {
                return 7;
            }
        }
        if (bluetoothClass != null) {
            if (a(bluetoothClass, 0)) {
                return 8;
            }
            if (a(bluetoothClass, 1) || a(bluetoothClass, 6)) {
                return 9;
            }
            if (a(bluetoothClass, 2)) {
                return 10;
            }
            if (a(bluetoothClass, 3)) {
                return 11;
            }
            if (a(bluetoothClass, 4) || a(bluetoothClass, 5)) {
                return 12;
            }
        }
        return bluetoothClass.getDeviceClass();
    }

    public static boolean b(Context context) {
        LocationManager locationManager;
        boolean z5;
        try {
            locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Throwable unused) {
        }
        if (!locationManager.isProviderEnabled(GeocodeSearch.GPS) && !locationManager.isProviderEnabled("passive")) {
            z5 = false;
            return !z5 || locationManager.isProviderEnabled("network");
        }
        z5 = true;
        if (z5) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 23 || i6 > 26) {
                return defaultAdapter.getAddress();
            }
            Field declaredField = defaultAdapter.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            return obj != null ? (String) obj.getClass().getMethod("getAddress", null).invoke(obj, null) : "02:00:00:00:00:00";
        } catch (Throwable th) {
            f.i("JBtHelper", "get bt ma fail. error is " + th.getMessage());
            return "02:00:00:00:00:00";
        }
    }

    public static boolean a(BluetoothClass bluetoothClass, int i6) {
        int deviceClass;
        int deviceClass2;
        int deviceClass3;
        if (i6 == 1) {
            return bluetoothClass.hasService(262144) || (deviceClass3 = bluetoothClass.getDeviceClass()) == 1044 || deviceClass3 == 1048 || deviceClass3 == 1056 || deviceClass3 == 1064;
        }
        if (i6 == 6) {
            return bluetoothClass.hasService(524288) || (deviceClass2 = bluetoothClass.getDeviceClass()) == 1060 || deviceClass2 == 1064 || deviceClass2 == 1068;
        }
        if (i6 == 0) {
            return bluetoothClass.hasService(262144) || (deviceClass = bluetoothClass.getDeviceClass()) == 1028 || deviceClass == 1032 || deviceClass == 1056;
        }
        if (i6 == 2) {
            if (bluetoothClass.hasService(1048576)) {
                return true;
            }
            switch (bluetoothClass.getDeviceClass()) {
                case 256:
                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME /* 264 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME /* 268 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME /* 272 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE /* 276 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
                case 512:
                case MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT /* 516 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX /* 520 */:
                case 524:
                case 528:
                case 532:
                    return true;
                default:
                    return false;
            }
        }
        if (i6 == 3) {
            return (bluetoothClass.getDeviceClass() & PredefinedCaptureConfigurations.f35648o) == 1280;
        }
        if (i6 == 4 || i6 == 5) {
            return bluetoothClass.hasService(131072) || (bluetoothClass.getDeviceClass() & ViewUtils.EDGE_TO_EDGE_FLAGS) == 768;
        }
        return false;
    }
}
