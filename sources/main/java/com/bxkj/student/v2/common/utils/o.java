package com.bxkj.student.v2.common.utils;

import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f20914a = new o();

    public final boolean a() {
        return (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || Integer.parseInt(System.getProperty("http.proxyPort", "-1")) == -1) ? false : true;
    }

    private o() {
    }
}
