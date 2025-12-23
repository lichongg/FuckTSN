package com.beizi.ad.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.model.f$f, reason: collision with other inner class name */
    public enum EnumC0127f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);


        /* renamed from: g, reason: collision with root package name */
        private final int f13063g;

        public static EnumC0127f a(int i6) {
            if (i6 == 0) {
                return RENDER_UNKNOWN;
            }
            if (i6 == 1) {
                return RENDER_VIDEO;
            }
            if (i6 == 2) {
                return RENDER_PIC;
            }
            if (i6 == 3) {
                return RENDER_H5;
            }
            if (i6 == 4) {
                return RENDER_JSON;
            }
            if (i6 != 5) {
                return null;
            }
            return RENDER_VAST_VIDEO;
        }

        EnumC0127f(int i6) {
            this.f13063g = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);


        /* renamed from: d, reason: collision with root package name */
        private final int f13073d;

        public static h a(int i6) {
            if (i6 == 0) {
                return SCREEN_DIRECTION_UNKOWN;
            }
            if (i6 == 1) {
                return PORTRAIT;
            }
            if (i6 != 2) {
                return null;
            }
            return LANDSCAPE;
        }

        h(int i6) {
            this.f13073d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        ADP_UNKNOWN(0),
        ADP_IVIDEO(1),
        ADP_LOADING(2),
        ADP_TABLE(3),
        ADP_BANNER(4),
        ADP_CUSTOMER(5),
        ADP_NATIVE(6);


        /* renamed from: h, reason: collision with root package name */
        private final int f13025h;

        a(int i6) {
            this.f13025h = i6;
        }

        public static a a(int i6) {
            switch (i6) {
                case 0:
                    return ADP_UNKNOWN;
                case 1:
                    return ADP_IVIDEO;
                case 2:
                    return ADP_LOADING;
                case 3:
                    return ADP_TABLE;
                case 4:
                    return ADP_BANNER;
                case 5:
                    return ADP_CUSTOMER;
                case 6:
                    return ADP_NATIVE;
                default:
                    return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);


        /* renamed from: g, reason: collision with root package name */
        private final int f13033g;

        b(int i6) {
            this.f13033g = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);


        /* renamed from: f, reason: collision with root package name */
        private final int f13040f;

        c(int i6) {
            this.f13040f = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);


        /* renamed from: h, reason: collision with root package name */
        private final int f13049h;

        d(int i6) {
            this.f13049h = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);


        /* renamed from: e, reason: collision with root package name */
        private final int f13055e;

        e(int i6) {
            this.f13055e = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);


        /* renamed from: d, reason: collision with root package name */
        private final int f13068d;

        g(int i6) {
            this.f13068d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);


        /* renamed from: f, reason: collision with root package name */
        private final int f13080f;

        i(int i6) {
            this.f13080f = i6;
        }
    }
}
