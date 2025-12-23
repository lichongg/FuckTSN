package com.oplus.omes.stdsco.auth;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AuthClient {

    /* renamed from: a, reason: collision with root package name */
    public static String f36390a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f36391b;

    public static native void nativeAuthInit(Object context, String appId);

    public static synchronized void a(Context context, String appId) {
        synchronized (AuthClient.class) {
            if (TextUtils.isEmpty(appId)) {
                throw new IllegalArgumentException("There are some arguments empty");
            }
            if (f36391b) {
                return;
            }
            f36391b = true;
            f36390a = appId;
            nativeAuthInit(context, appId);
        }
    }
}
