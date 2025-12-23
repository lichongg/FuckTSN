package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import androidx.work.Data;
import com.google.auto.value.AutoValue;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@WorkerThread
/* loaded from: D:\Downloads\app\classes.dex */
public final class OpenGlRenderer {
    private static final String DEFAULT_FRAGMENT_SHADER;
    private static final String DEFAULT_VERTEX_SHADER;
    private static final String HDR_FRAGMENT_SHADER;
    private static final String HDR_VERTEX_SHADER;
    private static final OutputSurface NO_OUTPUT_SURFACE;
    private static final int PIXEL_STRIDE = 4;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "OpenGlRenderer";
    private static final FloatBuffer TEX_BUF;
    private static final float[] TEX_COORDS;
    private static final String VAR_TEXTURE = "sTexture";
    private static final String VAR_TEXTURE_COORD = "vTextureCoord";
    private static final FloatBuffer VERTEX_BUF;
    private static final float[] VERTEX_COORDS;

    @Nullable
    private Surface mCurrentSurface;

    @Nullable
    private EGLConfig mEglConfig;

    @Nullable
    private Thread mGlThread;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);

    @VisibleForTesting
    final Map<Surface, OutputSurface> mOutputSurfaceMap = new HashMap();

    @NonNull
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;

    @NonNull
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;

    @NonNull
    private EGLSurface mTempSurface = EGL14.EGL_NO_SURFACE;
    private int mExternalTextureId = -1;
    private int mProgramHandle = -1;
    private int mTexMatrixLoc = -1;
    private int mPositionLoc = -1;
    private int mTexCoordLoc = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class OutputSurface {
        @NonNull
        abstract EGLSurface getEglSurface();

        abstract int getHeight();

        abstract int getWidth();

        @NonNull
        static OutputSurface of(@NonNull EGLSurface eGLSurface, int i6, int i7) {
            return new AutoValue_OpenGlRenderer_OutputSurface(eGLSurface, i6, i7);
        }

        OutputSurface() {
        }
    }

    @NonNull
    public static FloatBuffer createFloatBuffer(@NonNull float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private void createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        int i6 = iArr[0];
        GLES20.glBindTexture(36197, i6);
        checkGlErrorOrThrow("glBindTexture " + i6);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        this.mExternalTextureId = i6;
    }

    private static int generateFbo() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGlErrorOrThrow("glGenFramebuffers");
        return iArr[0];
    }

    private static int generateTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        return iArr[0];
    }

    private static int querySurface(@NonNull EGLDisplay eGLDisplay, @NonNull EGLSurface eGLSurface, int i6) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i6, iArr, 0);
        return iArr[0];
    }

    public int getTextureName() {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        return this.mExternalTextureId;
    }

    public void init(@NonNull DynamicRange dynamicRange, @NonNull ShaderProvider shaderProvider) {
        checkInitializedOrThrow(false);
        try {
            if (dynamicRange.is10BitHdr() && !getGlExtensionsBeforeInitialized(dynamicRange).contains("GL_EXT_YUV_target")) {
                dynamicRange = DynamicRange.SDR;
            }
            createEglContext(dynamicRange);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            createProgram(dynamicRange, shaderProvider);
            loadLocations();
            createTexture();
            useAndConfigureProgram();
            this.mGlThread = Thread.currentThread();
            this.mInitialized.set(true);
        } catch (IllegalArgumentException e6) {
            e = e6;
            releaseInternal();
            throw e;
        } catch (IllegalStateException e7) {
            e = e7;
            releaseInternal();
            throw e;
        }
    }

    public void registerOutputSurface(@NonNull Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        if (this.mOutputSurfaceMap.containsKey(surface)) {
            return;
        }
        this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
    }

    public void render(long j6, @NonNull float[] fArr, @NonNull Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        OutputSurface outSurfaceOrThrow = getOutSurfaceOrThrow(surface);
        if (outSurfaceOrThrow == NO_OUTPUT_SURFACE) {
            outSurfaceOrThrow = createOutputSurfaceInternal(surface);
            if (outSurfaceOrThrow == null) {
                return;
            } else {
                this.mOutputSurfaceMap.put(surface, outSurfaceOrThrow);
            }
        }
        if (surface != this.mCurrentSurface) {
            makeCurrent(outSurfaceOrThrow.getEglSurface());
            this.mCurrentSurface = surface;
            GLES20.glViewport(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
            GLES20.glScissor(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
        }
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, outSurfaceOrThrow.getEglSurface(), j6);
        if (EGL14.eglSwapBuffers(this.mEglDisplay, outSurfaceOrThrow.getEglSurface())) {
            return;
        }
        Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(surface, false);
    }

    @NonNull
    public Bitmap snapshot(@NonNull Size size, @NonNull float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        snapshot(allocateDirect, size, fArr);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, allocateDirect, size.getWidth() * 4);
        return createBitmap;
    }

    public void unregisterOutputSurface(@NonNull Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        removeOutputSurfaceInternal(surface, true);
    }

    static {
        Locale locale = Locale.US;
        DEFAULT_VERTEX_SHADER = String.format(locale, "uniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", VAR_TEXTURE_COORD, VAR_TEXTURE_COORD);
        HDR_VERTEX_SHADER = String.format(locale, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", VAR_TEXTURE_COORD, VAR_TEXTURE_COORD);
        DEFAULT_FRAGMENT_SHADER = String.format(locale, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nvoid main() {\n    gl_FragColor = texture2D(%s, %s);\n}\n", VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE, VAR_TEXTURE_COORD);
        HDR_FRAGMENT_SHADER = String.format(locale, "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorTransform = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorTransform * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  outColor = vec4(yuvToRgb(srcYuv), 1.0);\n}", VAR_TEXTURE, VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE_COORD);
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEX_COORDS = fArr;
        VERTEX_BUF = createFloatBuffer(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEX_COORDS = fArr2;
        TEX_BUF = createFloatBuffer(fArr2);
        NO_OUTPUT_SURFACE = OutputSurface.of(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    private void checkGlThreadOrThrow() {
        Preconditions.checkState(this.mGlThread == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    private void checkInitializedOrThrow(boolean z5) {
        Preconditions.checkState(z5 == this.mInitialized.get(), z5 ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    private static void checkLocationOrThrow(int i6, @NonNull String str) {
        if (i6 >= 0) {
            return;
        }
        throw new IllegalStateException("Unable to locate '" + str + "' in program");
    }

    private void createEglContext(@NonNull DynamicRange dynamicRange) {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eglGetDisplay;
        if (Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEglDisplay, iArr, 0, iArr, 1)) {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        int i6 = dynamicRange.is10BitHdr() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12324, i6, 12323, i6, 12322, i6, 12321, dynamicRange.is10BitHdr() ? 2 : 8, 12325, 0, 12326, 0, 12352, dynamicRange.is10BitHdr() ? 64 : 4, 12610, !dynamicRange.is10BitHdr() ? 1 : 0, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, dynamicRange.is10BitHdr() ? 3 : 2, 12344}, 0);
        checkEglErrorOrThrow("eglCreateContext");
        this.mEglConfig = eGLConfig;
        this.mEglContext = eglCreateContext;
        EGL14.eglQueryContext(this.mEglDisplay, eglCreateContext, 12440, new int[1], 0);
    }

    @Nullable
    private OutputSurface createOutputSurfaceInternal(@NonNull Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = this.mEglConfig;
            Objects.requireNonNull(eGLConfig);
            EGLSurface createWindowSurface = createWindowSurface(eGLDisplay, eGLConfig, surface);
            Size surfaceSize = getSurfaceSize(createWindowSurface);
            return OutputSurface.of(createWindowSurface, surfaceSize.getWidth(), surfaceSize.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e6) {
            Logger.w(TAG, "Failed to create EGL surface: " + e6.getMessage(), e6);
            return null;
        }
    }

    @NonNull
    private static EGLSurface createPBufferSurface(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, int i6, int i7) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i6, 12374, i7, 12344}, 0);
        checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void createProgram(@androidx.annotation.NonNull androidx.camera.core.DynamicRange r8, @androidx.annotation.NonNull androidx.camera.core.processing.ShaderProvider r9) {
        /*
            r7 = this;
            java.lang.String r0 = "glAttachShader"
            r1 = -1
            boolean r2 = r8.is10BitHdr()     // Catch: java.lang.IllegalArgumentException -> Lc java.lang.IllegalStateException -> L12
            if (r2 == 0) goto L14
            java.lang.String r2 = androidx.camera.core.processing.OpenGlRenderer.HDR_VERTEX_SHADER     // Catch: java.lang.IllegalArgumentException -> Lc java.lang.IllegalStateException -> L12
            goto L16
        Lc:
            r8 = move-exception
        Ld:
            r9 = -1
            r0 = -1
            r2 = -1
            goto L7a
        L12:
            r8 = move-exception
            goto Ld
        L14:
            java.lang.String r2 = androidx.camera.core.processing.OpenGlRenderer.DEFAULT_VERTEX_SHADER     // Catch: java.lang.IllegalArgumentException -> Lc java.lang.IllegalStateException -> L12
        L16:
            r3 = 35633(0x8b31, float:4.9932E-41)
            int r2 = loadShader(r3, r2)     // Catch: java.lang.IllegalArgumentException -> Lc java.lang.IllegalStateException -> L12
            int r8 = r7.loadFragmentShader(r8, r9)     // Catch: java.lang.IllegalArgumentException -> L75 java.lang.IllegalStateException -> L78
            int r9 = android.opengl.GLES20.glCreateProgram()     // Catch: java.lang.IllegalArgumentException -> L6d java.lang.IllegalStateException -> L73
            java.lang.String r3 = "glCreateProgram"
            checkGlErrorOrThrow(r3)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            android.opengl.GLES20.glAttachShader(r9, r2)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            checkGlErrorOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            android.opengl.GLES20.glAttachShader(r9, r8)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            checkGlErrorOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            android.opengl.GLES20.glLinkProgram(r9)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r0 = 1
            int[] r3 = new int[r0]     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r4 = 35714(0x8b82, float:5.0046E-41)
            r5 = 0
            android.opengl.GLES20.glGetProgramiv(r9, r4, r3, r5)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r3 = r3[r5]     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            if (r3 != r0) goto L52
            r7.mProgramHandle = r9     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            return
        L4a:
            r0 = move-exception
        L4b:
            r6 = r9
            r9 = r8
            r8 = r0
            r0 = r6
            goto L7a
        L50:
            r0 = move-exception
            goto L4b
        L52:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r3.<init>()     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            java.lang.String r4 = "Could not link program: "
            r3.append(r4)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            java.lang.String r4 = android.opengl.GLES20.glGetProgramInfoLog(r9)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r3.append(r4)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            r0.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
            throw r0     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.IllegalStateException -> L50
        L6d:
            r9 = move-exception
        L6e:
            r0 = r9
            r9 = r8
            r8 = r0
        L71:
            r0 = -1
            goto L7a
        L73:
            r9 = move-exception
            goto L6e
        L75:
            r8 = move-exception
        L76:
            r9 = -1
            goto L71
        L78:
            r8 = move-exception
            goto L76
        L7a:
            if (r2 == r1) goto L7f
            android.opengl.GLES20.glDeleteShader(r2)
        L7f:
            if (r9 == r1) goto L84
            android.opengl.GLES20.glDeleteShader(r9)
        L84:
            if (r0 == r1) goto L89
            android.opengl.GLES20.glDeleteProgram(r0)
        L89:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.OpenGlRenderer.createProgram(androidx.camera.core.DynamicRange, androidx.camera.core.processing.ShaderProvider):void");
    }

    private void createTempSurface() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLConfig eGLConfig = this.mEglConfig;
        Objects.requireNonNull(eGLConfig);
        this.mTempSurface = createPBufferSurface(eGLDisplay, eGLConfig, 1, 1);
    }

    @NonNull
    private static EGLSurface createWindowSurface(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, @NonNull Surface surface) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, new int[]{12344}, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    @NonNull
    private String getGlExtensionsBeforeInitialized(@NonNull DynamicRange dynamicRange) {
        checkInitializedOrThrow(false);
        try {
            createEglContext(dynamicRange);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            String glGetString = GLES20.glGetString(7939);
            return glGetString != null ? glGetString : "";
        } catch (IllegalStateException e6) {
            Logger.w(TAG, "Failed to get GL extensions: " + e6.getMessage(), e6);
            return "";
        } finally {
            releaseInternal();
        }
    }

    @NonNull
    private OutputSurface getOutSurfaceOrThrow(@NonNull Surface surface) {
        Preconditions.checkState(this.mOutputSurfaceMap.containsKey(surface), "The surface is not registered.");
        OutputSurface outputSurface = this.mOutputSurfaceMap.get(surface);
        Objects.requireNonNull(outputSurface);
        return outputSurface;
    }

    @NonNull
    private Size getSurfaceSize(@NonNull EGLSurface eGLSurface) {
        return new Size(querySurface(this.mEglDisplay, eGLSurface, 12375), querySurface(this.mEglDisplay, eGLSurface, 12374));
    }

    private int loadFragmentShader(@NonNull DynamicRange dynamicRange, @NonNull ShaderProvider shaderProvider) {
        if (shaderProvider == ShaderProvider.DEFAULT) {
            return loadShader(35632, dynamicRange.is10BitHdr() ? HDR_FRAGMENT_SHADER : DEFAULT_FRAGMENT_SHADER);
        }
        try {
            String createFragmentShader = shaderProvider.createFragmentShader(VAR_TEXTURE, VAR_TEXTURE_COORD);
            if (createFragmentShader != null && createFragmentShader.contains(VAR_TEXTURE_COORD) && createFragmentShader.contains(VAR_TEXTURE)) {
                return loadShader(35632, createFragmentShader);
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                throw th;
            }
            throw new IllegalArgumentException("Unable to compile fragment shader", th);
        }
    }

    private void loadLocations() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.mPositionLoc = glGetAttribLocation;
        checkLocationOrThrow(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        this.mTexCoordLoc = glGetAttribLocation2;
        checkLocationOrThrow(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.mTexMatrixLoc = glGetUniformLocation;
        checkLocationOrThrow(glGetUniformLocation, "uTexMatrix");
    }

    private void makeCurrent(@NonNull EGLSurface eGLSurface) {
        Preconditions.checkNotNull(this.mEglDisplay);
        Preconditions.checkNotNull(this.mEglContext);
        if (!EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    private void releaseInternal() {
        int i6 = this.mProgramHandle;
        if (i6 != -1) {
            GLES20.glDeleteProgram(i6);
            this.mProgramHandle = -1;
        }
        if (!Objects.equals(this.mEglDisplay, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (OutputSurface outputSurface : this.mOutputSurfaceMap.values()) {
                if (!Objects.equals(outputSurface.getEglSurface(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.mEglDisplay, outputSurface.getEglSurface())) {
                    checkEglErrorOrLog("eglDestroySurface");
                }
            }
            this.mOutputSurfaceMap.clear();
            if (!Objects.equals(this.mTempSurface, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.mEglDisplay, this.mTempSurface);
                this.mTempSurface = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.mEglContext, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        }
        this.mEglConfig = null;
        this.mProgramHandle = -1;
        this.mTexMatrixLoc = -1;
        this.mPositionLoc = -1;
        this.mTexCoordLoc = -1;
        this.mExternalTextureId = -1;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    private void removeOutputSurfaceInternal(@NonNull Surface surface, boolean z5) {
        if (this.mCurrentSurface == surface) {
            this.mCurrentSurface = null;
            makeCurrent(this.mTempSurface);
        }
        OutputSurface remove = z5 ? this.mOutputSurfaceMap.remove(surface) : this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
        if (remove == null || remove == NO_OUTPUT_SURFACE) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.mEglDisplay, remove.getEglSurface());
        } catch (RuntimeException e6) {
            Logger.w(TAG, "Failed to destroy EGL surface: " + e6.getMessage(), e6);
        }
    }

    private void useAndConfigureProgram() {
        GLES20.glUseProgram(this.mProgramHandle);
        checkGlErrorOrThrow("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, (Buffer) VERTEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, (Buffer) TEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
    }

    public void release() {
        if (this.mInitialized.getAndSet(false)) {
            checkGlThreadOrThrow();
            releaseInternal();
        }
    }

    private static void checkEglErrorOrLog(@NonNull String str) {
        try {
            checkEglErrorOrThrow(str);
        } catch (IllegalStateException e6) {
            Logger.e(TAG, e6.toString(), e6);
        }
    }

    private static void checkEglErrorOrThrow(@NonNull String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private static void checkGlErrorOrThrow(@NonNull String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(glGetError));
    }

    private static void deleteFbo(int i6) {
        GLES20.glDeleteFramebuffers(1, new int[]{i6}, 0);
        checkGlErrorOrThrow("glDeleteFramebuffers");
    }

    private static void deleteTexture(int i6) {
        GLES20.glDeleteTextures(1, new int[]{i6}, 0);
        checkGlErrorOrThrow("glDeleteTextures");
    }

    private static int loadShader(int i6, @NonNull String str) {
        int glCreateShader = GLES20.glCreateShader(i6);
        checkGlErrorOrThrow("glCreateShader type=" + i6);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Logger.w(TAG, "Could not compile shader: " + str);
        GLES20.glDeleteShader(glCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i6 + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
    }

    private void snapshot(@NonNull ByteBuffer byteBuffer, @NonNull Size size, @NonNull float[] fArr) {
        Preconditions.checkArgument(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        Preconditions.checkArgument(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int generateTexture = generateTexture();
        GLES20.glActiveTexture(33985);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, generateTexture);
        checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, null);
        checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int generateFbo = generateFbo();
        GLES20.glBindFramebuffer(36160, generateFbo);
        checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, generateTexture, 0);
        checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        checkGlErrorOrThrow("glBindTexture");
        this.mCurrentSurface = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        deleteTexture(generateTexture);
        deleteFbo(generateFbo);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
    }
}
