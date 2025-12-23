package cn.easyar.engine.gl;

import android.opengl.GLES20;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = "easyar.GlUtil";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private float mColorAdjust;
    private float[] mKernel = new float[9];
    private int mProgramHandle;
    private ProgramType mProgramType;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }

    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i6 = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i6);
        GlUtil.checkGlError("glBindTexture " + i6);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i6;
    }

    public void setKernel(float[] values, float colorAdj) {
        if (values.length == 9) {
            System.arraycopy(values, 0, this.mKernel, 0, 9);
            this.mColorAdjust = colorAdj;
            return;
        }
        throw new IllegalArgumentException("Kernel size is " + values.length + " vs. 9");
    }

    public void setTexSize(int width, int height) {
        float f6 = 1.0f / width;
        float f7 = 1.0f / height;
        float f8 = -f6;
        float f9 = -f7;
        this.mTexOffset = new float[]{f8, f9, 0.0f, f9, f6, f9, f8, 0.0f, 0.0f, 0.0f, f6, 0.0f, f8, f7, 0.0f, f7, f6, f7};
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: cn.easyar.engine.gl.Texture2dProgram$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType;

        static {
            int[] iArr = new int[ProgramType.values().length];
            $SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void draw(float[] mvpMatrix, FloatBuffer vertexBuffer, int firstVertex, int vertexCount, int coordsPerVertex, int vertexStride, float[] texMatrix, FloatBuffer texBuffer, int textureId, int texStride) {
        GlUtil.checkGlError("draw request");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, textureId);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, mvpMatrix, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, texMatrix, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, coordsPerVertex, 5126, false, vertexStride, (Buffer) vertexBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, texStride, (Buffer) texBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        int i6 = this.muKernelLoc;
        if (i6 >= 0) {
            GLES20.glUniform1fv(i6, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        GLES20.glDrawArrays(5, firstVertex, vertexCount);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    public void release() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public Texture2dProgram(ProgramType programType) {
        this.mProgramType = programType;
        int i6 = AnonymousClass1.$SwitchMap$cn$easyar$engine$gl$Texture2dProgram$ProgramType[programType.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        this.mTextureTarget = 36197;
                        this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_FILT);
                    } else {
                        throw new RuntimeException("Unhandled type " + programType);
                    }
                } else {
                    this.mTextureTarget = 36197;
                    this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_BW);
                }
            } else {
                this.mTextureTarget = 36197;
                this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
            }
        } else {
            this.mTextureTarget = 3553;
            this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_2D);
        }
        if (this.mProgramHandle != 0) {
            programType.toString();
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            GlUtil.checkLocation(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.maTextureCoordLoc = glGetAttribLocation2;
            GlUtil.checkLocation(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation;
            GlUtil.checkLocation(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.muTexMatrixLoc = glGetUniformLocation2;
            GlUtil.checkLocation(glGetUniformLocation2, "uTexMatrix");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
            this.muKernelLoc = glGetUniformLocation3;
            if (glGetUniformLocation3 < 0) {
                this.muKernelLoc = -1;
                this.muTexOffsetLoc = -1;
                this.muColorAdjustLoc = -1;
                return;
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            this.muTexOffsetLoc = glGetUniformLocation4;
            GlUtil.checkLocation(glGetUniformLocation4, "uTexOffset");
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            this.muColorAdjustLoc = glGetUniformLocation5;
            GlUtil.checkLocation(glGetUniformLocation5, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }
}
