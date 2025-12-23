package com.jmolsmobile.landscapevideocapture;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35594a = "VideoCapture_Exception";

    /* renamed from: b, reason: collision with root package name */
    public static final String f35595b = "VideoCapture_Activity";

    /* renamed from: c, reason: collision with root package name */
    public static final String f35596c = "VideoCapture_Preview";

    /* renamed from: d, reason: collision with root package name */
    public static final String f35597d = "VideoCapture_CaptureHelper";

    /* renamed from: e, reason: collision with root package name */
    public static final String f35598e = "VideoCapture_VideoRecorder";

    /* renamed from: f, reason: collision with root package name */
    public static final String f35599f = "VideoCapture_CameraWrapper";

    /* renamed from: g, reason: collision with root package name */
    private static boolean f35600g = true;

    public static void c(Context context) {
        boolean z5;
        if ((context.getApplicationInfo().flags & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        f35600g = z5;
    }

    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2) {
    }
}
