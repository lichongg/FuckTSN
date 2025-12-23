package cn.easyar.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import cn.easyar.Buffer;
import cn.easyar.CameraParameters;
import cn.easyar.FunctorOfVoid;
import cn.easyar.FunctorOfVoidFromInputFrame;
import cn.easyar.Image;
import cn.easyar.InputFrame;
import cn.easyar.JniUtility;
import cn.easyar.Vec2I;
import com.bykv.vk.component.ttvideo.player.C;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(21)
/* loaded from: D:\Downloads\app\classes2.dex */
class CameraDeviceCamera2 implements CameraDevice {
    private static final String TAG = "EasyAR";
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private ByteArrayPool mByteArrayPool;
    private Rect mCameraActiveSize;
    private android.hardware.camera2.CameraDevice mCameraDevice;
    private AutoResetEvent mCameraDeviceCloseSignal;
    private String mCameraId;
    private Size mCameraSize;
    private CameraCaptureSession mCaptureSession;
    private CameraCharacteristics mCharacteristics;
    private final Context mContext;
    private ImageReader mImageReader;
    private final FunctorOfVoidFromInputFrame mInputFrameHandler;
    private long mL1;
    private Range<Integer>[] mSupportedFpsRanges;
    private Size[] mSupportedSizes;
    private int mBufferCapacity = 8;
    private int mCameraIndex = -1;
    private boolean firstOpen = true;
    private int mCameraDeviceType = 0;
    private int mCameraOrientation = 0;
    private boolean mIsTimeStampSourceRealTime = true;
    private boolean mIsTimeStampSystemRealTime = false;
    private long mTimeStampOffset = 0;
    private int mCurrentFpsRange = -1;
    private int mCurrentFocusMode = 0;
    private boolean mFlashSupported = false;
    private boolean mFlashEnabled = false;
    private boolean mIsStarted = false;
    private CameraParameters mCameraParameters = CameraParameters.createWithDefaultIntrinsics(new Vec2I(640, 480), 0, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AutoResetEvent {
        private Condition condition;
        private Lock lock;
        private boolean signaled;

        public void set() {
            this.lock.lock();
            try {
                this.signaled = true;
                this.condition.signal();
            } finally {
                this.lock.unlock();
            }
        }

        public void waitOne() {
            while (true) {
                this.lock.lock();
                try {
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
                if (this.signaled) {
                    this.signaled = false;
                    this.lock.unlock();
                    return;
                } else {
                    this.condition.await();
                    this.lock.unlock();
                }
            }
        }

        public AutoResetEvent() {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
            this.signaled = false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ByteArrayPair {
        public byte[] array;
        public Buffer buffer;

        private ByteArrayPair() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ByteArrayPool {
        private final int blockSize;
        private final int capacity;
        private final Lock lock = new ReentrantLock();
        private final Queue<byte[]> queue = new LinkedList();
        private int size;

        static /* synthetic */ int access$1520(ByteArrayPool byteArrayPool, int i6) {
            int i7 = byteArrayPool.size - i6;
            byteArrayPool.size = i7;
            return i7;
        }

        public int getBlockSize() {
            return this.blockSize;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public int getSize() {
            this.lock.lock();
            try {
                return this.size;
            } finally {
                this.lock.unlock();
            }
        }

        public ByteArrayPair tryAcquire() {
            this.lock.lock();
            try {
                if (this.size >= this.capacity) {
                    return null;
                }
                final byte[] poll = this.queue.poll();
                this.size++;
                if (poll == null) {
                    poll = new byte[this.blockSize];
                }
                Buffer wrapByteArray = Buffer.wrapByteArray(poll, 0, poll.length, true, new FunctorOfVoid() { // from class: cn.easyar.engine.CameraDeviceCamera2.ByteArrayPool.1
                    @Override // cn.easyar.FunctorOfVoid
                    public void invoke() {
                        Arrays.fill(poll, (byte) 0);
                        ByteArrayPool.this.lock.lock();
                        try {
                            ByteArrayPool.access$1520(ByteArrayPool.this, 1);
                            if (ByteArrayPool.this.size < ByteArrayPool.this.capacity) {
                                ByteArrayPool.this.queue.add(poll);
                            }
                        } finally {
                            ByteArrayPool.this.lock.unlock();
                        }
                    }
                });
                ByteArrayPair byteArrayPair = new ByteArrayPair();
                byteArrayPair.array = poll;
                byteArrayPair.buffer = wrapByteArray;
                return byteArrayPair;
            } finally {
                this.lock.unlock();
            }
        }

        public ByteArrayPool(int blockSize, int capacity) {
            this.blockSize = blockSize;
            this.capacity = capacity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int checkPixelFormat(ByteBuffer dataY, ByteBuffer dataU, ByteBuffer dataV, long rawByteY, long rawByteU, long rawByteV, int pixelStrideY, int pixelStrideU, int pixelStrideV, int rowStrideY, int rowStrideU, int rowStrideV) {
        if (pixelStrideY == 1 && pixelStrideU == pixelStrideV && rowStrideU == rowStrideV && rawByteY != 0 && rawByteU != 0 && rawByteV != 0) {
            if (pixelStrideU != 2) {
                if (pixelStrideU == pixelStrideY && pixelStrideU == 1 && rowStrideY == rowStrideU * 2) {
                    return rawByteU < rawByteV ? 4 : 5;
                }
                return 0;
            }
            if (rowStrideY != rowStrideU) {
                return 0;
            }
            if (rawByteU + 1 == rawByteV) {
                return 3;
            }
            if (1 + rawByteV == rawByteU) {
                return 2;
            }
        }
        return 0;
    }

    private static boolean contains(int[] values, int value) {
        for (int i6 : values) {
            if (i6 == value) {
                return true;
            }
        }
        return false;
    }

    private boolean runRequest() {
        return runRequest(true);
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean autoFocus() {
        runRequest(false);
        runRequest(true);
        return true;
    }

    @Override // cn.easyar.engine.CameraDevice
    public void stop() {
        this.mIsStarted = false;
        CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.mCaptureSession = null;
        }
        android.hardware.camera2.CameraDevice cameraDevice = this.mCameraDevice;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.mCameraDeviceCloseSignal.waitOne();
            this.mCameraDeviceCloseSignal = null;
            this.mCameraDevice = null;
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            imageReader.close();
            this.mImageReader = null;
        }
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
            } catch (InterruptedException unused) {
            }
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillImageBuffer(ByteBuffer dataY, ByteBuffer dataU, ByteBuffer dataV, int pixelWidth, int pixelHeight, int pixelFormat, byte[] imageBuffer) {
        int i6 = pixelWidth * pixelHeight;
        int i7 = i6 / 2;
        copyBufferOrFillZero(dataY, 0, imageBuffer, 0, i6);
        if (pixelFormat == 3) {
            copyBufferOrFillZero(dataU, 0, imageBuffer, i6, i7);
            if (dataU.limit() != dataV.limit() || dataU.limit() >= i7) {
                return;
            }
            copyBufferOrFillZero(dataV, dataV.limit() - 1, imageBuffer, i6 + dataU.limit(), 1);
            return;
        }
        if (pixelFormat == 2) {
            copyBufferOrFillZero(dataV, 0, imageBuffer, i6, i7);
            if (dataU.limit() != dataV.limit() || dataU.limit() >= i7) {
                return;
            }
            copyBufferOrFillZero(dataU, dataU.limit() - 1, imageBuffer, i6 + dataV.limit(), 1);
            return;
        }
        if (pixelFormat == 4) {
            int i8 = i7 / 2;
            copyBufferOrFillZero(dataU, 0, imageBuffer, i6, i8);
            copyBufferOrFillZero(dataV, 0, imageBuffer, i6 + i8, i8);
        } else {
            if (pixelFormat != 5) {
                throw new RuntimeException("NotSupported");
            }
            int i9 = i7 / 2;
            copyBufferOrFillZero(dataV, 0, imageBuffer, i6, i9);
            copyBufferOrFillZero(dataU, 0, imageBuffer, i6 + i9, i9);
        }
    }

    private Size getOptimalPreviewSize(int width, int height) {
        Size[] sizeArr = this.mSupportedSizes;
        Size size = null;
        if (sizeArr == null) {
            return null;
        }
        float f6 = Float.MAX_VALUE;
        for (Size size2 : sizeArr) {
            float ratioError = getRatioError(width, size2.getWidth()) + getRatioError(height, size2.getHeight());
            if (ratioError < f6) {
                size = size2;
                f6 = ratioError;
            }
        }
        return size;
    }

    private static float getRatioError(float x5, float x02) {
        float max = (x5 / Math.max(x02, 1.0f)) - 1.0f;
        float max2 = (x02 / Math.max(x5, 1.0f)) - 1.0f;
        return (max * max) + (max2 * max2);
    }

    private boolean runRequest(boolean repeating) {
        android.hardware.camera2.CameraDevice cameraDevice = this.mCameraDevice;
        if (cameraDevice == null || this.mCaptureSession == null) {
            return false;
        }
        try {
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(1);
            createCaptureRequest.addTarget(this.mImageReader.getSurface());
            int round = ((int) Math.round(Math.ceil(this.mCameraActiveSize.width() / 8))) * 8;
            int round2 = ((int) Math.round(Math.ceil(this.mCameraActiveSize.height() / 8))) * 8;
            Rect rect = this.mCameraActiveSize;
            int width = rect.left + ((rect.width() - round) / 2);
            Rect rect2 = this.mCameraActiveSize;
            int height = rect2.top + ((rect2.height() - round2) / 2);
            createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, new Rect(width, height, round + width, round2 + height));
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
            createCaptureRequest.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
            createCaptureRequest.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.mSupportedFpsRanges[this.mCurrentFpsRange]);
            if (this.mFlashEnabled) {
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
            }
            createCaptureRequest.set(CaptureRequest.CONTROL_MODE, 1);
            int i6 = this.mCurrentFocusMode;
            if (i6 == 0) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 1);
                if (!repeating) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                }
            } else if (i6 == 2) {
                CameraCharacteristics cameraCharacteristics = this.mCharacteristics;
                CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
                if (contains((int[]) cameraCharacteristics.get(key), 4)) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                } else if (contains((int[]) this.mCharacteristics.get(key), 3)) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 3);
                } else {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 1);
                }
            } else if (i6 == 3) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 0);
                CameraCharacteristics cameraCharacteristics2 = this.mCharacteristics;
                CameraCharacteristics.Key key2 = CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE;
                if ((cameraCharacteristics2.get(key2) != null ? ((Float) this.mCharacteristics.get(key2)).floatValue() : 0.0f) > 0.0f) {
                    createCaptureRequest.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
                }
            } else {
                if (i6 != 4) {
                    if (i6 == 5) {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 0);
                        CameraCharacteristics cameraCharacteristics3 = this.mCharacteristics;
                        CameraCharacteristics.Key key3 = CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE;
                        float floatValue = cameraCharacteristics3.get(key3) != null ? ((Float) this.mCharacteristics.get(key3)).floatValue() : 0.0f;
                        if (floatValue > 0.0f) {
                            if (0.6f <= floatValue) {
                                floatValue = 0.6f;
                            }
                            createCaptureRequest.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(floatValue));
                        }
                    }
                    return false;
                }
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 2);
                if (!repeating) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                }
            }
            try {
                CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: cn.easyar.engine.CameraDeviceCamera2.4
                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                        CaptureResult.Key key4 = CaptureResult.SENSOR_ROLLING_SHUTTER_SKEW;
                        long longValue = result.get(key4) != null ? ((Long) result.get(key4)).longValue() : 0L;
                        CaptureResult.Key key5 = CaptureResult.SENSOR_EXPOSURE_TIME;
                        CameraDeviceCamera2.this.mL1 = (longValue + (result.get(key5) != null ? ((Long) result.get(key5)).longValue() : 0L)) / 2;
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureStarted(CameraCaptureSession session, CaptureRequest request, long timestamp, long frameNumber) {
                        if (CameraDeviceCamera2.this.mIsTimeStampSourceRealTime || CameraDeviceCamera2.this.mTimeStampOffset != 0 || CameraDeviceCamera2.this.mIsTimeStampSystemRealTime) {
                            return;
                        }
                        CameraDeviceCamera2.this.mTimeStampOffset = SystemClock.elapsedRealtimeNanos() - timestamp;
                        if (Math.abs(CameraDeviceCamera2.this.mTimeStampOffset) < C.NANOS_PER_SECOND) {
                            CameraDeviceCamera2.this.mTimeStampOffset = 0L;
                            CameraDeviceCamera2.this.mIsTimeStampSystemRealTime = true;
                        }
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureProgressed(CameraCaptureSession session, CaptureRequest request, CaptureResult partialResult) {
                    }
                };
                if (repeating) {
                    this.mCaptureSession.setRepeatingRequest(createCaptureRequest.build(), captureCallback, this.mBackgroundHandler);
                } else {
                    this.mCaptureSession.capture(createCaptureRequest.build(), captureCallback, this.mBackgroundHandler);
                }
                return true;
            } catch (CameraAccessException e6) {
                Log.getStackTraceString(e6);
            } catch (Exception e7) {
                Log.getStackTraceString(e7);
                return false;
            }
        } catch (CameraAccessException e8) {
            Log.getStackTraceString(e8);
            return false;
        } catch (Exception e9) {
            Log.getStackTraceString(e9);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getBufferCapacity() {
        return this.mBufferCapacity;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getCameraOrientation() {
        return this.mCameraOrientation;
    }

    @Override // cn.easyar.engine.CameraDevice
    public CameraParameters getCameraParameters() {
        return new CameraParameters(this.mCameraParameters.size(), this.mCameraParameters.focalLength(), this.mCameraParameters.principalPoint(), this.mCameraParameters.cameraDeviceType(), this.mCameraParameters.cameraOrientation());
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getFrameRateRange() {
        if (this.mSupportedFpsRanges == null) {
            return -1;
        }
        return this.mCurrentFpsRange;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getIndex() {
        return this.mCameraIndex;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getNumSupportedFrameRateRange() {
        Range<Integer>[] rangeArr = this.mSupportedFpsRanges;
        if (rangeArr == null) {
            return 0;
        }
        return rangeArr.length;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getNumSupportedSize() {
        Size[] sizeArr = this.mSupportedSizes;
        if (sizeArr == null) {
            return 0;
        }
        return sizeArr.length;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSizeHeight() {
        Size size = this.mCameraSize;
        if (size == null) {
            return 0;
        }
        return size.getHeight();
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSizeWidth() {
        Size size = this.mCameraSize;
        if (size == null) {
            return 0;
        }
        return size.getWidth();
    }

    @Override // cn.easyar.engine.CameraDevice
    public float getSupportedFrameRateRangeLower(int index) {
        Range<Integer>[] rangeArr = this.mSupportedFpsRanges;
        if (rangeArr != null && index >= 0 && index < rangeArr.length) {
            return rangeArr[index].getLower().intValue();
        }
        return 0.0f;
    }

    @Override // cn.easyar.engine.CameraDevice
    public float getSupportedFrameRateRangeUpper(int index) {
        Range<Integer>[] rangeArr = this.mSupportedFpsRanges;
        if (rangeArr != null && index >= 0 && index < rangeArr.length) {
            return rangeArr[index].getUpper().intValue();
        }
        return 0.0f;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSupportedSizeHeight(int index) {
        Size[] sizeArr = this.mSupportedSizes;
        if (sizeArr == null || index < 0 || index >= sizeArr.length) {
            return 0;
        }
        return sizeArr[index].getHeight();
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSupportedSizeWidth(int index) {
        Size[] sizeArr = this.mSupportedSizes;
        if (sizeArr == null || index < 0 || index >= sizeArr.length) {
            return 0;
        }
        return sizeArr[index].getWidth();
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getType() {
        return this.mCameraDeviceType;
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean openWithSpecificType(int type) {
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        if (cameraManager == null) {
            return false;
        }
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            for (int i6 = 0; i6 < cameraIdList.length; i6++) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(cameraIdList[i6]).get(CameraCharacteristics.LENS_FACING);
                if (type == 1 && num.intValue() == 1) {
                    return openWithIndex(i6);
                }
                if (type == 2 && num.intValue() == 0) {
                    return openWithIndex(i6);
                }
                if (type == 0) {
                    return openWithIndex(i6);
                }
            }
            return false;
        } catch (CameraAccessException e6) {
            Log.getStackTraceString(e6);
            return false;
        } catch (Exception e7) {
            Log.getStackTraceString(e7);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public void setBufferCapacity(int capacity) {
        this.mBufferCapacity = capacity;
    }

    @Override // cn.easyar.engine.CameraDevice
    public void setCameraParameters(CameraParameters cameraParameters) {
        if (cameraParameters == null) {
            return;
        }
        CameraParameters cameraParameters2 = this.mCameraParameters;
        if (cameraParameters2 != null) {
            cameraParameters2.a();
        }
        this.mCameraParameters = new CameraParameters(cameraParameters.size(), cameraParameters.focalLength(), cameraParameters.principalPoint(), cameraParameters.cameraDeviceType(), cameraParameters.cameraOrientation());
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setFlashTorchMode(boolean on) {
        if (!this.mFlashSupported) {
            return false;
        }
        this.mFlashEnabled = on;
        if (!this.mIsStarted) {
            return true;
        }
        runRequest();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    @Override // cn.easyar.engine.CameraDevice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean setFocusMode(int r9) {
        /*
            r8 = this;
            android.hardware.camera2.CameraCharacteristics r0 = r8.mCharacteristics
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r2 = 1
            if (r9 != 0) goto La
            goto L60
        La:
            r3 = 2
            r4 = 3
            r5 = 4
            if (r9 != r3) goto L35
            android.hardware.camera2.CameraCharacteristics$Key r3 = android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES
            java.lang.Object r0 = r0.get(r3)
            int[] r0 = (int[]) r0
            boolean r0 = contains(r0, r5)
            if (r0 == 0) goto L1e
            goto L60
        L1e:
            android.hardware.camera2.CameraCharacteristics r0 = r8.mCharacteristics
            java.lang.Object r0 = r0.get(r3)
            int[] r0 = (int[]) r0
            boolean r0 = contains(r0, r4)
            if (r0 == 0) goto L2d
            goto L60
        L2d:
            java.lang.String r0 = "Camera2: FocusMode.Continousauto not supported or not reliable"
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String.format(r0, r2)
            goto L85
        L35:
            r6 = 4442235333156365461(0x3da5fd7fe1796495, double:1.0E-11)
            r3 = 0
            if (r9 != r4) goto L5e
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE
            java.lang.Object r0 = r0.get(r4)
            if (r0 == 0) goto L51
            android.hardware.camera2.CameraCharacteristics r0 = r8.mCharacteristics
            java.lang.Object r0 = r0.get(r4)
            java.lang.Float r0 = (java.lang.Float) r0
            float r3 = r0.floatValue()
        L51:
            double r3 = (double) r3
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 >= 0) goto L60
            java.lang.String r0 = "Camera2: FocusMode.Infinity not supported or not reliable: manual sensor not available"
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String.format(r0, r2)
            goto L85
        L5e:
            if (r9 != r5) goto L62
        L60:
            r1 = 1
            goto L85
        L62:
            r4 = 5
            if (r9 != r4) goto L8e
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE
            java.lang.Object r0 = r0.get(r4)
            if (r0 == 0) goto L79
            android.hardware.camera2.CameraCharacteristics r0 = r8.mCharacteristics
            java.lang.Object r0 = r0.get(r4)
            java.lang.Float r0 = (java.lang.Float) r0
            float r3 = r0.floatValue()
        L79:
            double r3 = (double) r3
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 >= 0) goto L60
            java.lang.String r0 = "Camera2: FocusMode.Medium not supported or not reliable: manual sensor not available"
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String.format(r0, r2)
        L85:
            r8.mCurrentFocusMode = r9
            boolean r9 = r8.mIsStarted
            if (r9 == 0) goto L8e
            r8.runRequest()
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.easyar.engine.CameraDeviceCamera2.setFocusMode(int):boolean");
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setFrameRateRange(int index) {
        Range<Integer>[] rangeArr = this.mSupportedFpsRanges;
        if (rangeArr == null || index < 0 || index >= rangeArr.length) {
            return false;
        }
        this.mCurrentFpsRange = index;
        if (!this.mIsStarted) {
            return true;
        }
        runRequest();
        return true;
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setSize(int width, int height) {
        if (this.mSupportedSizes == null) {
            return false;
        }
        this.mCameraSize = getOptimalPreviewSize(width, height);
        if (!this.mIsStarted) {
            return true;
        }
        close();
        start();
        return true;
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean start() {
        if ((this.mBackgroundThread == null || this.mBackgroundHandler == null || this.mCameraDevice == null) && (this.mContext == null || !openWithIndex(this.mCameraIndex))) {
            return false;
        }
        if (this.mIsStarted) {
            return true;
        }
        Size size = this.mCameraSize;
        if (size == null) {
            return false;
        }
        ImageReader newInstance = ImageReader.newInstance(size.getWidth(), this.mCameraSize.getHeight(), 35, 2);
        this.mImageReader = newInstance;
        newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: cn.easyar.engine.CameraDeviceCamera2.2
            private boolean notSupportedFired = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader reader) {
                InputFrame inputFrame;
                Image image;
                android.media.Image acquireLatestImage = reader.acquireLatestImage();
                if (acquireLatestImage == null) {
                    return;
                }
                try {
                    Image.Plane[] planes = acquireLatestImage.getPlanes();
                    if (planes.length != 3) {
                        if (!this.notSupportedFired) {
                            this.notSupportedFired = true;
                        }
                        return;
                    }
                    int width = acquireLatestImage.getWidth();
                    int height = acquireLatestImage.getHeight();
                    long timestamp = acquireLatestImage.getTimestamp();
                    Image.Plane plane = planes[0];
                    Image.Plane plane2 = planes[1];
                    Image.Plane plane3 = planes[2];
                    ByteBuffer buffer = plane.getBuffer();
                    ByteBuffer buffer2 = plane2.getBuffer();
                    ByteBuffer buffer3 = plane3.getBuffer();
                    long directBufferAddress = CameraDeviceCamera2.getDirectBufferAddress(buffer);
                    long directBufferAddress2 = CameraDeviceCamera2.getDirectBufferAddress(buffer2);
                    long directBufferAddress3 = CameraDeviceCamera2.getDirectBufferAddress(buffer3);
                    int pixelStride = plane.getPixelStride();
                    int pixelStride2 = plane2.getPixelStride();
                    int pixelStride3 = plane3.getPixelStride();
                    int rowStride = plane.getRowStride();
                    int checkPixelFormat = CameraDeviceCamera2.checkPixelFormat(buffer, buffer2, buffer3, directBufferAddress, directBufferAddress2, directBufferAddress3, pixelStride, pixelStride2, pixelStride3, rowStride, plane2.getRowStride(), plane3.getRowStride());
                    if (checkPixelFormat == 0) {
                        if (!this.notSupportedFired) {
                            this.notSupportedFired = true;
                        }
                        return;
                    }
                    int min = (int) ((Math.min(directBufferAddress2, directBufferAddress3) - directBufferAddress) / rowStride);
                    int i6 = ((rowStride * min) * 3) / 2;
                    if (CameraDeviceCamera2.this.mByteArrayPool == null || CameraDeviceCamera2.this.mByteArrayPool.getBlockSize() != i6 || CameraDeviceCamera2.this.mByteArrayPool.getCapacity() != CameraDeviceCamera2.this.mBufferCapacity) {
                        CameraDeviceCamera2 cameraDeviceCamera2 = CameraDeviceCamera2.this;
                        cameraDeviceCamera2.mByteArrayPool = new ByteArrayPool(i6, cameraDeviceCamera2.mBufferCapacity);
                    }
                    ByteArrayPair tryAcquire = CameraDeviceCamera2.this.mByteArrayPool.tryAcquire();
                    if (tryAcquire == null) {
                        return;
                    }
                    CameraDeviceCamera2.fillImageBuffer(buffer, buffer2, buffer3, rowStride, min, checkPixelFormat, tryAcquire.array);
                    Buffer buffer4 = tryAcquire.buffer;
                    InputFrame inputFrame2 = null;
                    try {
                        cn.easyar.Image create = cn.easyar.Image.create(buffer4, checkPixelFormat, width, height, rowStride, min);
                        try {
                            long j6 = timestamp + CameraDeviceCamera2.this.mTimeStampOffset + CameraDeviceCamera2.this.mL1;
                            double elapsedRealtimeNanos = (j6 == 0 ? SystemClock.elapsedRealtimeNanos() : j6) * 1.0E-9d;
                            CameraParameters resized = CameraDeviceCamera2.this.mCameraParameters.getResized(new Vec2I(width, height));
                            try {
                                inputFrame2 = InputFrame.createWithImageAndCameraParametersAndTemporal(create, resized, elapsedRealtimeNanos);
                                CameraDeviceCamera2.this.mInputFrameHandler.invoke(inputFrame2);
                                if (resized != 0) {
                                    resized.a();
                                }
                                if (inputFrame2 != null) {
                                    inputFrame2.a();
                                }
                                if (create != null) {
                                    create.a();
                                }
                                if (buffer4 != null) {
                                    buffer4.a();
                                }
                            } catch (Throwable th) {
                                th = th;
                                image = create;
                                inputFrame = inputFrame2;
                                inputFrame2 = resized;
                                if (inputFrame2 != null) {
                                    inputFrame2.a();
                                }
                                if (inputFrame != null) {
                                    inputFrame.a();
                                }
                                if (image != null) {
                                    image.a();
                                }
                                if (buffer4 != null) {
                                    buffer4.a();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            image = create;
                            inputFrame = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputFrame = null;
                        image = null;
                    }
                } catch (IllegalStateException unused) {
                } finally {
                    acquireLatestImage.close();
                }
            }
        }, this.mBackgroundHandler);
        final AutoResetEvent autoResetEvent = new AutoResetEvent();
        try {
            this.mCameraDevice.createCaptureSession(Collections.singletonList(this.mImageReader.getSurface()), new CameraCaptureSession.StateCallback() { // from class: cn.easyar.engine.CameraDeviceCamera2.3
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    autoResetEvent.set();
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    CameraDeviceCamera2.this.mCaptureSession = cameraCaptureSession;
                    autoResetEvent.set();
                }
            }, this.mBackgroundHandler);
            autoResetEvent.waitOne();
            if (this.mCaptureSession == null) {
                close();
                return false;
            }
            if (runRequest()) {
                this.mIsStarted = true;
                return true;
            }
            close();
            return false;
        } catch (CameraAccessException e6) {
            Log.getStackTraceString(e6);
            return false;
        } catch (Exception e7) {
            Log.getStackTraceString(e7);
            return false;
        }
    }

    public CameraDeviceCamera2(Context context, FunctorOfVoidFromInputFrame inputFrameHandler) {
        this.mContext = context;
        this.mInputFrameHandler = inputFrameHandler;
    }

    private static void copyBufferOrFillZero(ByteBuffer src, int srcOffset, byte[] dest, int destOffset, int size) {
        int limit = src.limit();
        src.position(srcOffset);
        if (srcOffset + size <= limit) {
            src.get(dest, destOffset, size);
        } else {
            int i6 = limit - srcOffset;
            src.get(dest, destOffset, i6);
            Arrays.fill(dest, i6 + destOffset, destOffset + size, (byte) 0);
        }
        src.position(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getDirectBufferAddress(ByteBuffer buffer) {
        long newJniGlobalPointer = JniUtility.newJniGlobalPointer(buffer);
        try {
            return JniUtility.getDirectBufferAddress(newJniGlobalPointer);
        } finally {
            JniUtility.deleteJniGlobalPointer(newJniGlobalPointer);
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public void close() {
        stop();
        CameraParameters cameraParameters = this.mCameraParameters;
        if (cameraParameters != null) {
            cameraParameters.a();
            this.mCameraParameters = null;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    @SuppressLint({"MissingPermission"})
    public boolean openWithIndex(int index) {
        boolean z5;
        close();
        try {
            CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
            if (cameraManager == null) {
                close();
                return false;
            }
            try {
                String[] cameraIdList = cameraManager.getCameraIdList();
                if (index >= 0 && index < cameraIdList.length) {
                    String str = cameraIdList[index];
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    this.mCameraId = str;
                    this.mCameraIndex = index;
                    this.mCharacteristics = cameraCharacteristics;
                    if (((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE)).intValue() == 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    this.mIsTimeStampSourceRealTime = z5;
                    if (this.firstOpen && !z5) {
                        this.firstOpen = false;
                    }
                    int intValue = ((Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
                    this.mCameraDeviceType = 0;
                    if (intValue == 1) {
                        this.mCameraDeviceType = 1;
                    } else if (intValue == 0) {
                        this.mCameraDeviceType = 2;
                    }
                    this.mCameraOrientation = ((Integer) this.mCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                    this.mSupportedSizes = ((StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
                    this.mCameraActiveSize = (Rect) this.mCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                    this.mSupportedFpsRanges = (Range[]) this.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                    this.mFlashSupported = ((Boolean) this.mCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
                    if (this.mCameraSize == null) {
                        this.mCameraSize = getOptimalPreviewSize(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
                    }
                    int i6 = this.mCurrentFpsRange;
                    if (i6 < 0 || i6 >= this.mSupportedFpsRanges.length) {
                        Range<Integer>[] rangeArr = this.mSupportedFpsRanges;
                        this.mCurrentFpsRange = rangeArr.length - 1;
                        int i7 = 0;
                        for (Range<Integer> range : rangeArr) {
                            if (range.getLower().intValue() == 30 && range.getUpper().intValue() == 30) {
                                this.mCurrentFpsRange = i7;
                            }
                            i7++;
                        }
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraBackground");
                    this.mBackgroundThread = handlerThread;
                    handlerThread.start();
                    this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
                    final AutoResetEvent autoResetEvent = new AutoResetEvent();
                    try {
                        try {
                            cameraManager.openCamera(this.mCameraId, new CameraDevice.StateCallback() { // from class: cn.easyar.engine.CameraDeviceCamera2.1
                                @Override // android.hardware.camera2.CameraDevice.StateCallback
                                public void onClosed(android.hardware.camera2.CameraDevice camera) {
                                    CameraDeviceCamera2.this.mCameraDeviceCloseSignal.set();
                                }

                                @Override // android.hardware.camera2.CameraDevice.StateCallback
                                public void onOpened(android.hardware.camera2.CameraDevice cameraDevice) {
                                    CameraDeviceCamera2.this.mCameraDevice = cameraDevice;
                                    CameraDeviceCamera2.this.mCameraDeviceCloseSignal = new AutoResetEvent();
                                    autoResetEvent.set();
                                }

                                @Override // android.hardware.camera2.CameraDevice.StateCallback
                                public void onDisconnected(android.hardware.camera2.CameraDevice cameraDevice) {
                                    cameraDevice.close();
                                    autoResetEvent.set();
                                }

                                @Override // android.hardware.camera2.CameraDevice.StateCallback
                                public void onError(android.hardware.camera2.CameraDevice cameraDevice, int error) {
                                    cameraDevice.close();
                                    autoResetEvent.set();
                                }
                            }, this.mBackgroundHandler);
                            autoResetEvent.waitOne();
                            if (this.mCameraDevice == null) {
                                close();
                                return false;
                            }
                            CameraParameters cameraParameters = this.mCameraParameters;
                            if (cameraParameters != null) {
                                cameraParameters.a();
                            }
                            this.mCameraParameters = CameraParameters.createWithDefaultIntrinsics(new Vec2I(640, 480), this.mCameraDeviceType, this.mCameraOrientation);
                            return true;
                        } catch (CameraAccessException e6) {
                            Log.getStackTraceString(e6);
                            close();
                            return false;
                        }
                    } catch (Exception e7) {
                        Log.getStackTraceString(e7);
                        close();
                        return false;
                    }
                }
                return false;
            } catch (CameraAccessException e8) {
                Log.getStackTraceString(e8);
                close();
                return false;
            } catch (Exception e9) {
                Log.getStackTraceString(e9);
                close();
                return false;
            }
        } finally {
            close();
        }
    }
}
