package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class CommonMatcher {
    public abstract int end();

    public abstract boolean find();

    public abstract boolean find(int i6);

    public abstract boolean matches();

    public abstract String replaceAll(String str);

    public abstract int start();

    CommonMatcher() {
    }
}
