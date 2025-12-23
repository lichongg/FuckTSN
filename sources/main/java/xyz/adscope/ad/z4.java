package xyz.adscope.ad;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class z4 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final String f56215a;

    @Override // java.lang.Throwable
    @Nullable
    public String getLocalizedMessage() {
        return "Render structs has conflict or unexpected error, " + this.f56215a;
    }

    public z4(String str) {
        this.f56215a = str;
    }
}
