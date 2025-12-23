package com.amap.api.col.p0003l;

import android.opengl.GLES20;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u1 {

    /* renamed from: a, reason: collision with root package name */
    public int f7325a;

    /* renamed from: b, reason: collision with root package name */
    public int f7326b;

    /* renamed from: c, reason: collision with root package name */
    public int f7327c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7328d;

    public final void a() {
        int i6 = this.f7325a;
        if (i6 >= 0) {
            GLES20.glDeleteProgram(i6);
        }
        int i7 = this.f7326b;
        if (i7 >= 0) {
            GLES20.glDeleteShader(i7);
        }
        int i8 = this.f7327c;
        if (i8 >= 0) {
            GLES20.glDeleteShader(i8);
        }
        this.f7328d = true;
    }
}
