package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.util.Pair;
import android.view.Surface;
import com.acse.ottn.l3;
import com.baidu.mobads.sdk.internal.cm;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.bytedance.sdk.component.utils.vl;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

@Keep
@TargetApi(16)
/* loaded from: D:\Downloads\app\classes3.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "aj_media_codec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private MediaCodec.BufferInfo mBufferInfo;
    private Surface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;

    public static int ceilDivide(int i6, int i7) {
        return ((i6 + i7) - 1) / i7;
    }

    private void createDummySurface() {
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    private static int getMaxInputSize(String str, int i6, int i7) {
        int i8;
        int i9;
        if (i6 == -1 || i7 == -1) {
            return -1;
        }
        if (!str.equals("video/3gpp") && !str.equals("video/mp4v-es")) {
            if (str.equals("video/avc")) {
                if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                    return -1;
                }
                i8 = ceilDivide(i6, 16) * ceilDivide(i7, 16) * 256;
                i9 = 2;
                return (i8 * 3) / (i9 * 2);
            }
            if (!str.equals("video/x-vnd.on2.vp8")) {
                if (!str.equals("video/hevc") && !str.equals("video/x-vnd.on2.vp9")) {
                    return -1;
                }
                i8 = i6 * i7;
                i9 = 4;
                return (i8 * 3) / (i9 * 2);
            }
        }
        i8 = i6 * i7;
        i9 = 2;
        return (i8 * 3) / (i9 * 2);
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i6) {
        if (i6 != -1) {
            mediaFormat.setInteger(str, i6);
        }
    }

    @CalledByNative
    public int configure(int i6, int i7, int i8, int i9, int i10, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z5, boolean z6, int i11, int i12, boolean z7, int i13, boolean z8, boolean z9, int i14, int i15) {
        Surface surface2;
        int i16 = i11;
        int i17 = i12;
        vl.j(TAG, "configure =" + surface + ", surfaceConfigure =" + z5);
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        maybeSetInteger(mediaFormat, "width", i6);
        maybeSetInteger(mediaFormat, "height", i7);
        if (i16 != -1 && i17 != -1) {
            if (i16 <= i6) {
                i16 = i6;
            }
            maybeSetInteger(mediaFormat, "max-width", i16);
            if (i17 <= i7) {
                i17 = i7;
            }
            maybeSetInteger(mediaFormat, "max-height", i17);
        }
        maybeSetInteger(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, i9);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, i10);
        vl.j(TAG, "format  = ".concat(String.valueOf(mediaFormat)));
        int maxInputSize = getMaxInputSize(str, i6, i7);
        vl.j(TAG, "max input = ".concat(String.valueOf(maxInputSize)));
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z5) {
            int i18 = Util.SDK_INT;
            if (i18 >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i8);
            }
            if ((surface == null || !surface.isValid()) && this.mDummySurface == null && i18 >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                vl.j(TAG, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            } else {
                surface2 = surface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        } else {
            surface2 = surface;
        }
        if (Util.SDK_INT >= 23 && z6) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z7) {
            VendorQTI.setupVpp(mediaFormat, i13);
        }
        if (z8) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z9) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i15 > 0 && i14 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i14, i15);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split("\\."));
            if (dolbyVisionProfileAndLevel != null) {
                maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e6) {
            handleCodecException(e6);
            if (e6 instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    @CalledByNative
    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame != null && aJMediaCodecFrame.data != null) {
            try {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(30000L);
                if (dequeueInputBuffer < 0) {
                    return dequeueInputBuffer == -1 ? 4 : -1;
                }
                this.mInputBuffers[dequeueInputBuffer].put(aJMediaCodecFrame.data);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                return 0;
            } catch (Exception e6) {
                vl.r(TAG, "write meet exception =".concat(String.valueOf(e6)));
            }
        }
        return -1;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i6 = Util.SDK_INT;
        if (i6 < 18) {
            return true;
        }
        if (i6 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (i6 == 19 && Util.MODEL.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r1.equals("AFTA") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004b, code lost:
    
        if (r1.equals("deb") != false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:11:0x0071, B:12:0x0073, B:14:0x001d, B:21:0x004f, B:26:0x0060, B:29:0x0069, B:31:0x0033, B:34:0x004d, B:35:0x003c, B:38:0x0045, B:40:0x0075), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.bykv.vk.component.ttvideo.player.AJMediaCodec> r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto L75
            int r1 = com.bykv.vk.component.ttvideo.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L19
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L1b
            java.lang.String r4 = "dangal"
            java.lang.String r5 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L19
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L19
            if (r4 != 0) goto L71
            goto L1b
        L19:
            r1 = move-exception
            goto L79
        L1b:
            if (r1 >= r2) goto L73
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L19
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L19
            r4 = 99329(0x18401, float:1.3919E-40)
            if (r2 == r4) goto L45
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L3c
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L33
            goto L4f
        L33:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L4f
            goto L4d
        L3c:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L4f
            goto L4d
        L45:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L4f
        L4d:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L19
        L4f:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.MODEL     // Catch: java.lang.Throwable -> L19
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L19
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L69
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L60
            goto L73
        L60:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L73
            goto L71
        L69:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L73
        L71:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L19
        L73:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L19
        L75:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            boolean r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e6) {
                vl.j(e6);
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private boolean isHisiByteVC1BlockList() {
        double d6;
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (!property.startsWith("kirin960") && !property.startsWith("hi3660")) {
            return false;
        }
        try {
            d6 = Double.parseDouble(getProperty(VERSION_PROPERTY, cm.f10901d));
        } catch (NumberFormatException unused) {
            vl.xt(TAG, "vendor property abnormal");
            d6 = 0.0d;
        }
        return d6 < FIX_VERSION;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i6) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i6)), byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            Surface surface = this.mDummySurface;
            if (surface != null) {
                surface.release();
                this.mDummySurface = null;
            }
            vl.j(TAG, "codec release end");
        } catch (Exception unused) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            vl.j(TAG, "codec release end");
        } catch (Throwable th) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            vl.j(TAG, "codec release end");
            throw th;
        }
    }

    @TargetApi(21)
    private int renderOutputBufferV21(int i6, long j6) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i6, j6);
            return 0;
        } catch (Exception unused) {
            return CODEC_ERROR;
        }
    }

    @CalledByNative
    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    @CalledByNative
    public void close() {
        vl.j(TAG, "close start");
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            this.mMediaCodec = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJMediaCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        vl.j(AJMediaCodec.TAG, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable unused) {
                vl.xt(TAG, "new thread failed");
                releaseCodec(mediaCodec);
            }
        }
        vl.j(TAG, "close end");
    }

    @CalledByNative
    public int createByCodecName(String str) {
        vl.j(TAG, "createByCodecName = ".concat(String.valueOf(str)));
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e6) {
            handleCodecException(e6);
            return -1;
        }
    }

    @TargetApi(23)
    @CalledByNative
    public void decodeFRC(int i6) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        vl.j(TAG, "frc level = ".concat(String.valueOf(i6)));
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i6);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e6) {
            vl.xt(TAG, "setParameters failed ret = ".concat(String.valueOf(e6)));
        }
    }

    @CalledByNative
    public int dequeueInputBuffer(long j6) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j6);
        } catch (Exception e6) {
            return handleCodecException(e6);
        }
    }

    @CalledByNative
    public void flush() {
        vl.j(TAG, "flush");
        try {
            this.mMediaCodec.flush();
        } catch (Exception unused) {
        }
        vl.j(TAG, "flush done");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0073, code lost:
    
        r8 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mVideoHWDecoderCodecs.get(r7);
     */
    @com.bykv.vk.component.ttvideo.player.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBestCodecName(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.getBestCodecName(java.lang.String):java.lang.String");
    }

    @CalledByNative
    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    @CalledByNative
    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) ? (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1 : this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) ? (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    @CalledByNative
    public int getOSVerion() {
        return Util.SDK_INT;
    }

    @CalledByNative
    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @TargetApi(21)
    public int handleCodecExceptionV21(Exception exc) {
        int errorCode;
        int errorCode2;
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                codecException.isRecoverable();
                codecException.getErrorCode();
                if (!codecException.isRecoverable()) {
                    errorCode = codecException.getErrorCode();
                    if (errorCode != 1100) {
                        errorCode2 = codecException.getErrorCode();
                        if (errorCode2 != 1101) {
                            return CODEC_EXCEPTION_ERROR;
                        }
                    }
                }
            } else {
                codecException.isRecoverable();
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        return exc instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int open(int i6, int i7, int i8, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        vl.j(TAG, "open, rotation = " + i8 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            vl.j(TAG, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, str2);
            maybeSetInteger(mediaFormat, "width", i6);
            maybeSetInteger(mediaFormat, "height", i7);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i8);
            }
            this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            vl.j(TAG, "mediacodec start");
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            this.mInputBuffersValid = true;
            String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i6), Integer.valueOf(i7));
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    @CalledByNative
    public int queueInputBuffer(int i6, int i7, int i8, long j6, int i9) {
        try {
            this.mMediaCodec.queueInputBuffer(i6, i7, i8, j6, i9);
            return 0;
        } catch (Exception e6) {
            return handleCodecException(e6);
        }
    }

    @CalledByNative
    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j6) {
        while (true) {
            try {
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j6);
                if (dequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[dequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    aJMediaCodecFrame.pts = bufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = dequeueOutputBuffer;
                    aJMediaCodecFrame.size = bufferInfo.size;
                    aJMediaCodecFrame.flags = bufferInfo.flags;
                    return 0;
                }
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer != -1) {
                            vl.r(TAG, "error, idx = ".concat(String.valueOf(dequeueOutputBuffer)));
                        }
                        return -1;
                    }
                    vl.j(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers != null) {
                            return dequeueOutputBuffer;
                        }
                        try {
                            this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            return dequeueOutputBuffer;
                        } catch (Exception e6) {
                            vl.j(TAG, "getOutputBuffers e = ".concat(String.valueOf(e6)));
                            return handleCodecException(e6);
                        }
                    } catch (Exception e7) {
                        vl.j(TAG, "getOutputFormat e =".concat(String.valueOf(e7)));
                        return handleCodecException(e7);
                    }
                }
                vl.j(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                } catch (Exception e8) {
                    vl.j(TAG, "getOutputBuffers e = ".concat(String.valueOf(e8)));
                    return handleCodecException(e8);
                }
            } catch (Exception e9) {
                vl.j(TAG, "dequeueOutputBuffer e :".concat(String.valueOf(e9)));
                return handleCodecException(e9);
            }
        }
    }

    @CalledByNative
    public int releaseBuffer(int i6, boolean z5, long j6) {
        if (Util.SDK_INT >= 21 && z5) {
            return renderOutputBufferV21(i6, j6);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i6, z5);
            return 0;
        } catch (Exception e6) {
            return handleCodecException(e6);
        }
    }

    @CalledByNative
    public int setOutputSurface(Surface surface) {
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            vl.j(TAG, "use dummy surface");
        }
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    @TargetApi(23)
    @CalledByNative
    public void speedEnhance(float f6) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f6 <= 30.0f) {
            return;
        }
        vl.j(TAG, "rate ".concat(String.valueOf(f6)));
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f6);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e6) {
            vl.xt(TAG, "setParameters failed ret = ".concat(String.valueOf(e6)));
        }
    }

    @CalledByNative
    public int start() {
        vl.j(TAG, "start");
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            vl.j(TAG, "start end");
            return 0;
        } catch (Exception e6) {
            handleCodecException(e6);
            return -1;
        }
    }

    @CalledByNative
    public int stop() {
        if (this.mInputBuffersValid) {
            vl.j(TAG, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                return -1;
            }
        }
        return 0;
    }

    @CalledByNative
    public int vendorOppoHWEnable() {
        if (!Util.BARND.equals("OPPO")) {
            return 1;
        }
        String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
        vl.j(TAG, "oppo property = ".concat(String.valueOf(property)));
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            vl.xt(TAG, "vendor oppo property abnormal");
            return 1;
        }
    }

    @CalledByNative
    public AJMediaCodec() {
        boolean z5 = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z5 = true;
            }
            mNeedByteVC1WorkAround = z5;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        vl.j(TAG, "initialize, need workaround " + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    @TargetApi(23)
    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e6) {
            handleCodecException(e6);
            vl.xt(TAG, "setoutputsurface failed = ".concat(String.valueOf(e6)));
            return -1;
        }
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return CODEC_ERROR;
    }
}
