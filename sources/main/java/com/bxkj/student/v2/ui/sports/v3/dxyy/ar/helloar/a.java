package com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar;

import android.opengl.GLES20;
import cn.easyar.Matrix44F;
import cn.easyar.Vec2F;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private EGLContext f21738a;

    /* renamed from: b, reason: collision with root package name */
    private final int f21739b;

    /* renamed from: c, reason: collision with root package name */
    private final int f21740c;

    /* renamed from: d, reason: collision with root package name */
    private final int f21741d;

    /* renamed from: e, reason: collision with root package name */
    private final int f21742e;

    /* renamed from: f, reason: collision with root package name */
    private final int f21743f;

    /* renamed from: g, reason: collision with root package name */
    private final int f21744g;

    /* renamed from: h, reason: collision with root package name */
    private final int f21745h;

    /* renamed from: i, reason: collision with root package name */
    private final int f21746i;

    /* renamed from: j, reason: collision with root package name */
    private final int f21747j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final String f21748k = "uniform mat4 trans;\nuniform mat4 proj;\nattribute vec4 coord;\nattribute vec4 color;\nvarying vec4 vcolor;\n\nvoid main(void)\n{\n    vcolor = color;\n    gl_Position = proj*trans*coord;\n}\n\n";

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final String f21749l = "#ifdef GL_ES\nprecision highp float;\n#endif\nvarying vec4 vcolor;\n\nvoid main(void)\n{\n    gl_FragColor = vcolor;\n}\n\n";

    private final byte[] a(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            bArr[i6] = (byte) (iArr[i6] & 255);
        }
        return bArr;
    }

    private final byte[] d(byte[][] bArr) {
        int i6 = 0;
        for (byte[] bArr2 : bArr) {
            i6 += bArr2.length;
        }
        byte[] bArr3 = new byte[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < bArr.length; i8++) {
            byte[] bArr4 = bArr[i8];
            System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
            i7 += bArr[i8].length;
        }
        return bArr3;
    }

    private final float[] e(float[][] fArr) {
        int i6 = 0;
        for (float[] fArr2 : fArr) {
            i6 += fArr2.length;
        }
        float[] fArr3 = new float[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < fArr.length; i8++) {
            float[] fArr4 = fArr[i8];
            System.arraycopy(fArr4, 0, fArr3, i7, fArr4.length);
            i7 += fArr[i8].length;
        }
        return fArr3;
    }

    private final int[] f(int[][] iArr) {
        int i6 = 0;
        for (int[] iArr2 : iArr) {
            i6 += iArr2.length;
        }
        int[] iArr3 = new int[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            int[] iArr4 = iArr[i8];
            System.arraycopy(iArr4, 0, iArr3, i7, iArr4.length);
            i7 += iArr[i8].length;
        }
        return iArr3;
    }

    private final short[] g(short[][] sArr) {
        int i6 = 0;
        for (short[] sArr2 : sArr) {
            i6 += sArr2.length;
        }
        short[] sArr3 = new short[i6];
        int i7 = 0;
        for (int i8 = 0; i8 < sArr.length; i8++) {
            short[] sArr4 = sArr[i8];
            System.arraycopy(sArr4, 0, sArr3, i7, sArr4.length);
            i7 += sArr[i8].length;
        }
        return sArr3;
    }

    private final int h() {
        int[] iArr = {0};
        GLES20.glGenBuffers(1, iArr, 0);
        return iArr[0];
    }

    private final float[] i(Matrix44F matrix44F) {
        float[] data = matrix44F.data;
        g0.o(data, "data");
        return new float[]{data[0], data[4], data[8], data[12], data[1], data[5], data[9], data[13], data[2], data[6], data[10], data[14], data[3], data[7], data[11], data[15]};
    }

    public final void j(@NotNull Matrix44F projectionMatrix, @NotNull Matrix44F cameraview, @NotNull Vec2F size) {
        g0.p(projectionMatrix, "projectionMatrix");
        g0.p(cameraview, "cameraview");
        g0.p(size, "size");
        float[] fArr = size.data;
        float f6 = fArr[0];
        float f7 = fArr[1];
        GLES20.glBindBuffer(34962, this.f21744g);
        float f8 = 2;
        float f9 = f6 / f8;
        float f10 = f7 / f8;
        float f11 = (f6 / 1000) / f8;
        float f12 = -f7;
        float f13 = f12 / f8;
        float f14 = -f6;
        float f15 = f14 / f8;
        FloatBuffer wrap = FloatBuffer.wrap(e(new float[][]{new float[]{f9, f10, f11}, new float[]{f9, f13, f11}, new float[]{f15, f13, f11}, new float[]{f15, f10, f11}, new float[]{f9, f10, 0.0f}, new float[]{f9, f13, 0.0f}, new float[]{f15, f13, 0.0f}, new float[]{f15, f10, 0.0f}}));
        GLES20.glBufferData(34962, wrap.limit() * 4, wrap, 35048);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glEnable(2929);
        GLES20.glUseProgram(this.f21739b);
        GLES20.glBindBuffer(34962, this.f21744g);
        GLES20.glEnableVertexAttribArray(this.f21740c);
        GLES20.glVertexAttribPointer(this.f21740c, 3, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.f21745h);
        GLES20.glEnableVertexAttribArray(this.f21741d);
        GLES20.glVertexAttribPointer(this.f21741d, 4, 5121, true, 0, 0);
        GLES20.glUniformMatrix4fv(this.f21742e, 1, false, i(cameraview), 0);
        GLES20.glUniformMatrix4fv(this.f21743f, 1, false, i(projectionMatrix), 0);
        GLES20.glBindBuffer(34963, this.f21747j);
        for (int i6 = 0; i6 < 6; i6++) {
            GLES20.glDrawElements(6, 4, 5123, i6 * 8);
        }
        GLES20.glBindBuffer(34962, this.f21744g);
        float f16 = 4;
        float f17 = f6 / f16;
        float f18 = f7 / f16;
        float f19 = f12 / f16;
        float f20 = f14 / f16;
        FloatBuffer wrap2 = FloatBuffer.wrap(e(new float[][]{new float[]{f17, f18, f17}, new float[]{f17, f19, f17}, new float[]{f20, f19, f17}, new float[]{f20, f18, f17}, new float[]{f17, f18, 0.0f}, new float[]{f17, f19, 0.0f}, new float[]{f20, f19, 0.0f}, new float[]{f20, f18, 0.0f}}));
        GLES20.glBufferData(34962, wrap2.limit() * 4, wrap2, 35048);
        GLES20.glEnableVertexAttribArray(this.f21740c);
        GLES20.glVertexAttribPointer(this.f21740c, 3, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.f21746i);
        GLES20.glEnableVertexAttribArray(this.f21741d);
        GLES20.glVertexAttribPointer(this.f21741d, 4, 5121, true, 0, 0);
        for (int i7 = 0; i7 < 6; i7++) {
            GLES20.glDrawElements(6, 4, 5123, i7 * 8);
        }
    }

    public a() {
        EGL egl = EGLContext.getEGL();
        g0.n(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        this.f21738a = ((EGL10) egl).eglGetCurrentContext();
        int glCreateProgram = GLES20.glCreateProgram();
        this.f21739b = glCreateProgram;
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, "uniform mat4 trans;\nuniform mat4 proj;\nattribute vec4 coord;\nattribute vec4 color;\nvarying vec4 vcolor;\n\nvoid main(void)\n{\n    vcolor = color;\n    gl_Position = proj*trans*coord;\n}\n\n");
        GLES20.glCompileShader(glCreateShader);
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, "#ifdef GL_ES\nprecision highp float;\n#endif\nvarying vec4 vcolor;\n\nvoid main(void)\n{\n    gl_FragColor = vcolor;\n}\n\n");
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glUseProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        this.f21740c = GLES20.glGetAttribLocation(glCreateProgram, "coord");
        this.f21741d = GLES20.glGetAttribLocation(glCreateProgram, "color");
        this.f21742e = GLES20.glGetUniformLocation(glCreateProgram, "trans");
        this.f21743f = GLES20.glGetUniformLocation(glCreateProgram, "proj");
        int h6 = h();
        this.f21744g = h6;
        GLES20.glBindBuffer(34962, h6);
        FloatBuffer wrap = FloatBuffer.wrap(e(new float[][]{new float[]{0.5f, 0.5f, 0.005f}, new float[]{0.5f, -0.5f, 0.005f}, new float[]{-0.5f, -0.5f, 0.005f}, new float[]{-0.5f, 0.5f, 0.005f}, new float[]{0.5f, 0.5f, -0.005f}, new float[]{0.5f, -0.5f, -0.005f}, new float[]{-0.5f, -0.5f, -0.005f}, new float[]{-0.5f, 0.5f, -0.005f}}));
        GLES20.glBufferData(34962, wrap.limit() * 4, wrap, 35048);
        int h7 = h();
        this.f21745h = h7;
        GLES20.glBindBuffer(34962, h7);
        ByteBuffer wrap2 = ByteBuffer.wrap(a(f(new int[][]{new int[]{255, 0, 0, 128}, new int[]{0, 255, 0, 128}, new int[]{0, 0, 255, 128}, new int[]{0, 0, 0, 128}, new int[]{0, 255, 255, 128}, new int[]{255, 0, 255, 128}, new int[]{255, 255, 0, 128}, new int[]{255, 255, 255, 128}})));
        GLES20.glBufferData(34962, wrap2.limit(), wrap2, 35044);
        int h8 = h();
        this.f21746i = h8;
        GLES20.glBindBuffer(34962, h8);
        ByteBuffer wrap3 = ByteBuffer.wrap(a(f(new int[][]{new int[]{255, 0, 0, 255}, new int[]{255, 255, 0, 255}, new int[]{0, 255, 0, 255}, new int[]{255, 0, 255, 255}, new int[]{255, 0, 255, 255}, new int[]{255, 255, 255, 255}, new int[]{0, 255, 255, 255}, new int[]{255, 0, 255, 255}})));
        GLES20.glBufferData(34962, wrap3.limit(), wrap3, 35044);
        int h9 = h();
        this.f21747j = h9;
        GLES20.glBindBuffer(34963, h9);
        ShortBuffer wrap4 = ShortBuffer.wrap(g(new short[][]{new short[]{0, 1, 5, 4}, new short[]{3, 7, 6, 2}, new short[]{0, 4, 7, 3}, new short[]{1, 2, 6, 5}, new short[]{0, 3, 2, 1}, new short[]{4, 5, 6, 7}}));
        GLES20.glBufferData(34963, wrap4.limit() * 2, wrap4, 35044);
    }

    private final void b(int i6) {
        GLES20.glDeleteBuffers(1, new int[]{i6}, 0);
    }

    public final void c() {
        EGL egl = EGLContext.getEGL();
        g0.n(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        if (g0.g(((EGL10) egl).eglGetCurrentContext(), this.f21738a)) {
            GLES20.glDeleteProgram(this.f21739b);
            b(this.f21744g);
            b(this.f21745h);
            b(this.f21746i);
            b(this.f21747j);
        }
    }
}
