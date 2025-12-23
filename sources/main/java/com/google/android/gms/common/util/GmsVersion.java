package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class GmsVersion {

    @KeepForSdk
    public static final int VERSION_HALLOUMI = 4100000;

    @KeepForSdk
    public static final int VERSION_JARLSBERG = 4300000;

    @KeepForSdk
    public static final int VERSION_KENAFA = 4400000;

    @KeepForSdk
    public static final int VERSION_LONGHORN = 5000000;

    @KeepForSdk
    public static final int VERSION_MANCHEGO = 6000000;

    @KeepForSdk
    public static final int VERSION_ORLA = 7000000;

    @KeepForSdk
    public static final int VERSION_PARMESAN = 7200000;

    @KeepForSdk
    public static final int VERSION_QUESO = 7500000;

    @KeepForSdk
    public static final int VERSION_REBLOCHON = 7800000;

    @KeepForSdk
    public static final int VERSION_SAGA = 8000000;

    private GmsVersion() {
    }

    @KeepForSdk
    public static boolean isAtLeastFenacho(int i6) {
        if (i6 >= 3200000) {
            return true;
        }
        return false;
    }
}
