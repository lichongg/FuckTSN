package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import net.sqlcipher.database.SQLiteDatabase;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {4000, AVMDLDataLoader.KeyIsLiveSetLoaderType, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 50400, 88200, 96000, 176400, com.hw.videoprocessor.h.f35384e, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length;
        int i6 = Build.VERSION.SDK_INT >= 23 ? length - 3 : length - 5;
        for (int i7 = 0; i7 < i6; i7++) {
            iArr[i7] = validSampleRates[i7];
        }
        return i6;
    }

    @CalledByNative
    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        int length = queryEffects.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            if (queryEffects[i6].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
            i6++;
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
