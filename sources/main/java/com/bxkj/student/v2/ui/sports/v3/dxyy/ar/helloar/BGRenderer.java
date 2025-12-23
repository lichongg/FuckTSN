package com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar;

import android.opengl.GLES20;
import androidx.work.Data;
import cn.easyar.Matrix44F;
import cn.easyar.Vec2I;
import cn.easyar.p0;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class BGRenderer {

    /* renamed from: i, reason: collision with root package name */
    private boolean f21712i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private EGLContext f21713j;

    /* renamed from: k, reason: collision with root package name */
    private int f21714k;

    /* renamed from: u, reason: collision with root package name */
    private int f21724u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    private Vec2I f21725v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    private byte[] f21726w;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f21704a = "attribute vec4 coord;\nattribute vec2 texCoord;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    gl_Position = coord;\n    texc = texCoord;\n}\n\n";

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f21705b = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform sampler2D texture;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    gl_FragColor = texture2D(texture, texc).bgra;\n}\n\n";

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f21706c = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform sampler2D texture;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    gl_FragColor = texture2D(texture, texc);\n}\n\n";

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f21707d = "#ifdef GL_ES\nprecision highp float;\n#endif\nuniform sampler2D texture;\nuniform sampler2D u_texture;\nuniform sampler2D v_texture;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    float cb = texture2D(u_texture, texc).r - 0.5;\n    float cr = texture2D(v_texture, texc).r - 0.5;\n    vec3 ycbcr = vec3(texture2D(texture, texc).r, cb, cr);\n    vec3 rgb = mat3(1, 1, 1,\n        0, -0.344, 1.772,\n        1.402, -0.714, 0) * ycbcr;\n    gl_FragColor = vec4(rgb, 1.0);\n}\n\n";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f21708e = "#ifdef GL_ES\nprecision highp float;\n#endif\nuniform sampler2D texture;\nuniform sampler2D uv_texture;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    vec2 cbcr = texture2D(uv_texture, texc).ra - vec2(0.5, 0.5);\n    vec3 ycbcr = vec3(texture2D(texture, texc).r, cbcr);\n    vec3 rgb = mat3(1.0, 1.0, 1.0,\n        0.0, -0.344, 1.772,\n        1.402, -0.714, 0.0) * ycbcr;\n    gl_FragColor = vec4(rgb, 1.0);\n}\n\n";

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final String f21709f = "#ifdef GL_ES\nprecision highp float;\n#endif\nuniform sampler2D texture;\nuniform sampler2D uv_texture;\nvarying vec2 texc;\n\nvoid main(void)\n{\n    vec2 cbcr = texture2D(uv_texture, texc).ar - vec2(0.5, 0.5);\n    vec3 ycbcr = vec3(texture2D(texture, texc).r, cbcr);\n    vec3 rgb = mat3(1, 1, 1,\n        0, -0.344, 1.772,\n        1.402, -0.714, 0.0) * ycbcr;\n    gl_FragColor = vec4(rgb, 1.0);\n}\n\n";

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final byte[] f21710g = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE};

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private FrameShader f21711h = FrameShader.RGB;

    /* renamed from: l, reason: collision with root package name */
    private final IntBuffer f21715l = IntBuffer.allocate(1);

    /* renamed from: m, reason: collision with root package name */
    private final IntBuffer f21716m = IntBuffer.allocate(1);

    /* renamed from: n, reason: collision with root package name */
    private final IntBuffer f21717n = IntBuffer.allocate(1);

    /* renamed from: o, reason: collision with root package name */
    private final IntBuffer f21718o = IntBuffer.allocate(1);

    /* renamed from: p, reason: collision with root package name */
    private int f21719p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f21720q = -1;

    /* renamed from: r, reason: collision with root package name */
    private final IntBuffer f21721r = IntBuffer.allocate(1);

    /* renamed from: s, reason: collision with root package name */
    private final IntBuffer f21722s = IntBuffer.allocate(1);

    /* renamed from: t, reason: collision with root package name */
    private final IntBuffer f21723t = IntBuffer.allocate(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class FrameShader {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ FrameShader[] $VALUES;
        public static final FrameShader RGB = new FrameShader("RGB", 0);
        public static final FrameShader YUV = new FrameShader("YUV", 1);

        private static final /* synthetic */ FrameShader[] $values() {
            return new FrameShader[]{RGB, YUV};
        }

        static {
            FrameShader[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<FrameShader> getEntries() {
            return $ENTRIES;
        }

        public static FrameShader valueOf(String str) {
            return (FrameShader) Enum.valueOf(FrameShader.class, str);
        }

        public static FrameShader[] values() {
            return (FrameShader[]) $VALUES.clone();
        }

        private FrameShader(String str, int i6) {
        }
    }

    private final boolean c(int i6) {
        if (i6 == 0) {
            return false;
        }
        EGL egl = EGLContext.getEGL();
        g0.n(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        this.f21713j = ((EGL10) egl).eglGetCurrentContext();
        this.f21714k = GLES20.glCreateProgram();
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, this.f21704a);
        GLES20.glCompileShader(glCreateShader);
        int glCreateShader2 = GLES20.glCreateShader(35632);
        switch (i6) {
            case 1:
            case 6:
            case 8:
                this.f21711h = FrameShader.RGB;
                GLES20.glShaderSource(glCreateShader2, this.f21706c);
                break;
            case 2:
                this.f21711h = FrameShader.YUV;
                GLES20.glShaderSource(glCreateShader2, this.f21709f);
                break;
            case 3:
                this.f21711h = FrameShader.YUV;
                GLES20.glShaderSource(glCreateShader2, this.f21708e);
                break;
            case 4:
            case 5:
                this.f21711h = FrameShader.YUV;
                GLES20.glShaderSource(glCreateShader2, this.f21707d);
                break;
            case 7:
            case 9:
                this.f21711h = FrameShader.RGB;
                GLES20.glShaderSource(glCreateShader2, this.f21705b);
                break;
        }
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glAttachShader(this.f21714k, glCreateShader);
        GLES20.glAttachShader(this.f21714k, glCreateShader2);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGetShaderiv(glCreateShader, 35713, allocate);
        if (allocate.get(0) == 0) {
            GLES20.glGetShaderInfoLog(glCreateShader);
        }
        IntBuffer allocate2 = IntBuffer.allocate(1);
        GLES20.glGetShaderiv(glCreateShader2, 35713, allocate2);
        if (allocate2.get(0) == 0) {
            GLES20.glGetShaderInfoLog(glCreateShader2);
        }
        GLES20.glLinkProgram(this.f21714k);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(this.f21714k, 35714, IntBuffer.allocate(1));
        GLES20.glUseProgram(this.f21714k);
        this.f21719p = GLES20.glGetAttribLocation(this.f21714k, "coord");
        this.f21720q = GLES20.glGetAttribLocation(this.f21714k, "texCoord");
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGenBuffers(1, this.f21721r);
        GLES20.glBindBuffer(34962, this.f21721r.get(0));
        GLES20.glBufferData(34962, 48, FloatBuffer.wrap(new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f}), 35048);
        GLES20.glGenBuffers(1, this.f21722s);
        GLES20.glBindBuffer(34962, this.f21722s.get(0));
        GLES20.glBufferData(34962, 32, FloatBuffer.wrap(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f}), 35044);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f21714k, "texture"), 0);
        GLES20.glGenTextures(1, this.f21715l);
        GLES20.glBindTexture(3553, this.f21715l.get(0));
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i7 = a.f21727a[this.f21711h.ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (i6 == 2 || i6 == 3) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f21714k, "uv_texture"), 1);
                GLES20.glGenTextures(1, this.f21716m);
                GLES20.glBindTexture(3553, this.f21716m.get(0));
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
            } else {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f21714k, "u_texture"), 1);
                GLES20.glGenTextures(1, this.f21717n);
                GLES20.glBindTexture(3553, this.f21717n.get(0));
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f21714k, "v_texture"), 2);
                GLES20.glGenTextures(1, this.f21718o);
                GLES20.glBindTexture(3553, this.f21718o.get(0));
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
            }
        }
        GLES20.glGenFramebuffers(1, this.f21723t);
        this.f21712i = true;
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21727a;

        static {
            int[] iArr = new int[FrameShader.values().length];
            try {
                iArr[FrameShader.RGB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FrameShader.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f21727a = iArr;
        }
    }

    private final void b(int i6) {
        if (this.f21712i) {
            EGL egl = EGLContext.getEGL();
            g0.n(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            if (g0.g(((EGL10) egl).eglGetCurrentContext(), this.f21713j)) {
                GLES20.glDeleteProgram(this.f21714k);
                GLES20.glDeleteBuffers(1, this.f21721r);
                GLES20.glDeleteBuffers(1, this.f21722s);
                GLES20.glDeleteFramebuffers(1, this.f21723t);
                GLES20.glDeleteTextures(1, this.f21715l);
                int i7 = a.f21727a[this.f21711h.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (i6 == 2 || i6 == 3) {
                        GLES20.glDeleteTextures(1, this.f21716m);
                    } else {
                        GLES20.glDeleteTextures(1, this.f21717n);
                        GLES20.glDeleteTextures(1, this.f21718o);
                    }
                }
            }
            this.f21712i = false;
        }
    }

    private final p0 d(Matrix44F matrix44F, p0 p0Var) {
        p0 p0Var2 = new p0(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i6 = 0; i6 < 4; i6++) {
            for (int i7 = 0; i7 < 4; i7++) {
                float[] fArr = p0Var2.data;
                fArr[i6] = fArr[i6] + (matrix44F.data[(i6 * 4) + i7] * p0Var.data[i7]);
            }
        }
        return p0Var2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
    
        if (r3.length != r2) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f(int r22, int r23, int r24, int r25, int r26, java.nio.ByteBuffer r27, int r28) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.BGRenderer.f(int, int, int, int, int, java.nio.ByteBuffer, int):void");
    }

    public final void a() {
        b(this.f21724u);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0433  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(@org.jetbrains.annotations.NotNull cn.easyar.Matrix44F r45) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.BGRenderer.e(cn.easyar.Matrix44F):void");
    }

    public final void g(int i6, int i7, int i8, int i9, int i10, @NotNull ByteBuffer buffer) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        g0.p(buffer, "buffer");
        IntBuffer allocate = IntBuffer.allocate(1);
        IntBuffer allocate2 = IntBuffer.allocate(1);
        IntBuffer allocate3 = IntBuffer.allocate(1);
        IntBuffer allocate4 = IntBuffer.allocate(1);
        IntBuffer allocate5 = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(35725, allocate2);
        GLES20.glGetIntegerv(34016, allocate3);
        GLES20.glActiveTexture(33984);
        GLES20.glGetIntegerv(32873, allocate);
        GLES20.glActiveTexture(33985);
        GLES20.glGetIntegerv(32873, allocate4);
        GLES20.glActiveTexture(33986);
        GLES20.glGetIntegerv(32873, allocate5);
        try {
            int i17 = this.f21724u;
            try {
                if (i17 != i6) {
                    b(i17);
                    if (!c(i6)) {
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, allocate.get(0));
                        GLES20.glActiveTexture(33985);
                        GLES20.glBindTexture(3553, allocate4.get(0));
                        GLES20.glActiveTexture(33986);
                        GLES20.glBindTexture(3553, allocate5.get(0));
                        GLES20.glActiveTexture(allocate3.get(0));
                        i16 = allocate2.get(0);
                        GLES20.glUseProgram(i16);
                        return;
                    }
                    this.f21724u = i6;
                }
                if (i15 == 1) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, this.f21715l.get(0));
                    i11 = 3553;
                    i12 = 0;
                    try {
                        f(i6, i7, i8, i9, i10, buffer, 0);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, this.f21715l.get(0));
                        f(i6, i7, i8, i9, i10, buffer, 0);
                        if (i6 == 2 || i6 == 3) {
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, this.f21716m.get(0));
                            f(i6, i7, i8, i9, i10, buffer, 1);
                        } else {
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, this.f21717n.get(0));
                            f(i6, i7, i8, i9, i10, buffer, 1);
                            GLES20.glActiveTexture(33986);
                            GLES20.glBindTexture(3553, this.f21718o.get(0));
                            f(i6, i7, i8, i9, i10, buffer, 2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        GLES20.glActiveTexture(i13);
                        GLES20.glBindTexture(i11, allocate.get(i12));
                        GLES20.glActiveTexture(i14);
                        GLES20.glBindTexture(i11, allocate4.get(i12));
                        GLES20.glActiveTexture(33986);
                        GLES20.glBindTexture(i11, allocate5.get(i12));
                        GLES20.glActiveTexture(allocate3.get(i12));
                        GLES20.glUseProgram(allocate2.get(i12));
                        throw th;
                    }
                } else {
                    if (i15 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    try {
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, this.f21715l.get(0));
                        f(i6, i7, i8, i9, i10, buffer, 0);
                        if (i6 == 2 || i6 == 3) {
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, this.f21716m.get(0));
                            f(i6, i7, i8, i9, i10, buffer, 1);
                        } else {
                            GLES20.glActiveTexture(33985);
                            try {
                                GLES20.glBindTexture(3553, this.f21717n.get(0));
                                f(i6, i7, i8, i9, i10, buffer, 1);
                                GLES20.glActiveTexture(33986);
                                GLES20.glBindTexture(3553, this.f21718o.get(0));
                                f(i6, i7, i8, i9, i10, buffer, 2);
                            } catch (Throwable th2) {
                                th = th2;
                                i11 = 3553;
                                i12 = 0;
                                GLES20.glActiveTexture(i13);
                                GLES20.glBindTexture(i11, allocate.get(i12));
                                GLES20.glActiveTexture(i14);
                                GLES20.glBindTexture(i11, allocate4.get(i12));
                                GLES20.glActiveTexture(33986);
                                GLES20.glBindTexture(i11, allocate5.get(i12));
                                GLES20.glActiveTexture(allocate3.get(i12));
                                GLES20.glUseProgram(allocate2.get(i12));
                                throw th;
                            }
                        }
                        i11 = 3553;
                        i12 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(i11, allocate.get(i12));
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(i11, allocate4.get(i12));
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(i11, allocate5.get(i12));
                GLES20.glActiveTexture(allocate3.get(i12));
                i16 = allocate2.get(i12);
                GLES20.glUseProgram(i16);
                return;
            } catch (Throwable th4) {
                th = th4;
            }
            this.f21725v = new Vec2I(i7, i8);
            i15 = a.f21727a[this.f21711h.ordinal()];
            i13 = 33984;
            i14 = 33985;
        } catch (Throwable th5) {
            th = th5;
            i11 = 3553;
            i12 = 0;
            i13 = 33984;
            i14 = 33985;
        }
    }
}
