package com.hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(16)
/* loaded from: D:\Downloads\app\classes6.dex */
public class h {

    /* renamed from: k, reason: collision with root package name */
    private static final int f35480k = 4;

    /* renamed from: l, reason: collision with root package name */
    private static final int f35481l = 20;

    /* renamed from: m, reason: collision with root package name */
    private static final int f35482m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f35483n = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final float[] f35484o = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: p, reason: collision with root package name */
    private static final String f35485p = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: q, reason: collision with root package name */
    private static final String f35486q = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: a, reason: collision with root package name */
    private FloatBuffer f35487a;

    /* renamed from: d, reason: collision with root package name */
    private int f35490d;

    /* renamed from: f, reason: collision with root package name */
    private int f35492f;

    /* renamed from: g, reason: collision with root package name */
    private int f35493g;

    /* renamed from: h, reason: collision with root package name */
    private int f35494h;

    /* renamed from: i, reason: collision with root package name */
    private int f35495i;

    /* renamed from: j, reason: collision with root package name */
    private int f35496j;

    /* renamed from: b, reason: collision with root package name */
    private float[] f35488b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private float[] f35489c = new float[16];

    /* renamed from: e, reason: collision with root package name */
    private int f35491e = -12345;

    public void a(String str) {
        GLES20.glDeleteProgram(this.f35490d);
        int c6 = c(f35485p, str);
        this.f35490d = c6;
        if (c6 == 0) {
            throw new RuntimeException("failed creating program");
        }
    }

    public void d(SurfaceTexture surfaceTexture, boolean z5) {
        b("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f35489c);
        if (z5) {
            float[] fArr = this.f35489c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.f35490d);
        b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f35491e);
        this.f35487a.position(0);
        GLES20.glVertexAttribPointer(this.f35494h, 3, 5126, false, 20, (Buffer) this.f35487a);
        b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f35494h);
        b("glEnableVertexAttribArray maPositionHandle");
        this.f35487a.position(3);
        GLES20.glVertexAttribPointer(this.f35495i, 2, 5126, false, 20, (Buffer) this.f35487a);
        b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f35495i);
        b("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f35493g, 1, false, this.f35489c, 0);
        GLES20.glUniformMatrix4fv(this.f35492f, 1, false, this.f35488b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glFinish();
    }

    public int e() {
        return this.f35491e;
    }

    public void g() {
        int c6 = c(f35485p, f35486q);
        this.f35490d = c6;
        if (c6 == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.f35494h = GLES20.glGetAttribLocation(c6, "aPosition");
        b("glGetAttribLocation aPosition");
        if (this.f35494h == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f35495i = GLES20.glGetAttribLocation(this.f35490d, "aTextureCoord");
        b("glGetAttribLocation aTextureCoord");
        if (this.f35495i == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f35492f = GLES20.glGetUniformLocation(this.f35490d, "uMVPMatrix");
        b("glGetUniformLocation uMVPMatrix");
        if (this.f35492f == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.f35493g = GLES20.glGetUniformLocation(this.f35490d, "uSTMatrix");
        b("glGetUniformLocation uSTMatrix");
        if (this.f35493g == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i6 = iArr[0];
        this.f35491e = i6;
        GLES20.glBindTexture(36197, i6);
        b("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        b("glTexParameter");
        Matrix.setIdentityM(this.f35488b, 0);
        int i7 = this.f35496j;
        if (i7 != 0) {
            Matrix.rotateM(this.f35488b, 0, i7, 0.0f, 0.0f, 1.0f);
        }
    }

    public h(int i6) {
        this.f35496j = i6;
        float[] fArr = f35484o;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f35487a = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f35489c, 0);
    }

    private int c(String str, String str2) {
        int f6;
        int f7 = f(35633, str);
        if (f7 == 0 || (f6 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        b("glCreateProgram");
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, f7);
        b("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f6);
        b("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private int f(int i6, String str) {
        int glCreateShader = GLES20.glCreateShader(i6);
        b("glCreateShader type=" + i6);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + glGetError);
    }
}
