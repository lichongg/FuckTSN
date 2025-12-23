package cn.easyar.engine.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "easyar.GlUtil";

    public static FloatBuffer createFloatBuffer(float[] coords) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(coords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(coords);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createImageTexture(ByteBuffer data, int width, int height, int format) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i6 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i6);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, format, width, height, 0, format, 5121, data);
        checkGlError("loadImageTexture");
        return i6;
    }

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void checkLocation(int location, String label) {
        if (location >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + label + "' in program");
    }

    public static void logVersionInfo() {
        GLES20.glGetString(7936);
        GLES20.glGetString(7937);
        GLES20.glGetString(7938);
    }

    private GlUtil() {
    }

    public static void checkGlError(String op) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(op + ": glError 0x" + Integer.toHexString(glGetError));
    }

    public static int createProgram(String vertexSource, String fragmentSource) {
        int loadShader;
        int loadShader2 = loadShader(35633, vertexSource);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, fragmentSource)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, loadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glGetProgramInfoLog(glCreateProgram);
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int loadShader(int shaderType, String source) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        checkGlError("glCreateShader type=" + shaderType);
        GLES20.glShaderSource(glCreateShader, source);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
