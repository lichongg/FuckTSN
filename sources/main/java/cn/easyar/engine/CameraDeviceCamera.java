package cn.easyar.engine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import cn.easyar.Buffer;
import cn.easyar.CameraParameters;
import cn.easyar.FunctorOfVoidFromInputFrame;
import cn.easyar.Image;
import cn.easyar.InputFrame;
import cn.easyar.Vec2I;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.t0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class CameraDeviceCamera implements CameraDevice, Camera.PreviewCallback {
    private static final String TAG = "EasyAR";
    private volatile Camera mCameraDevice;
    private final FunctorOfVoidFromInputFrame mInputFrameHandler;
    private List<int[]> mSupportedPreviewFpsRanges;
    private List<Camera.Size> mSupportedPreviewSizes;
    private SurfaceTexture mSurfaceTexture;
    private int mBufferCapacity = 8;
    private AtomicInteger mBufferSize = new AtomicInteger(8);
    private int mCameraIndex = -1;
    private int mCameraDeviceType = 0;
    private int mCameraOrientation = 0;
    private int mWidth = PredefinedCaptureConfigurations.f35648o;
    private int mHeight = 960;
    private Vec2I mSizeToSet = new Vec2I(PredefinedCaptureConfigurations.f35648o, 960);
    private int mCurrentFpsRange = -1;
    private Boolean mFlashTorchMode = null;
    private Integer mFocusMode = null;
    private boolean mStarted = false;
    private CameraParameters mCameraParameters = CameraParameters.createWithDefaultIntrinsics(new Vec2I(640, 480), 0, 0);

    @Override // cn.easyar.engine.CameraDevice
    public boolean autoFocus() {
        try {
            this.mCameraDevice.autoFocus(new Camera.AutoFocusCallback() { // from class: cn.easyar.engine.CameraDeviceCamera.1
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean success, Camera camera) {
                    if (CameraDeviceCamera.this.mFocusMode != null) {
                        CameraDeviceCamera cameraDeviceCamera = CameraDeviceCamera.this;
                        cameraDeviceCamera.setFocusMode(cameraDeviceCamera.mFocusMode.intValue());
                    }
                }
            });
            return true;
        } catch (RuntimeException e6) {
            e6.printStackTrace();
            return false;
        } catch (Exception e7) {
            Log.getStackTraceString(e7);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean openWithIndex(int index) {
        try {
            close();
            this.mSurfaceTexture = new SurfaceTexture(0);
            this.mCameraDevice = Camera.open(index);
            if (this.mCameraDevice == null) {
                return false;
            }
            this.mCameraIndex = index;
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.mCameraIndex, cameraInfo);
            this.mCameraDeviceType = 0;
            int i6 = cameraInfo.facing;
            if (i6 == 0) {
                this.mCameraDeviceType = 1;
            } else if (i6 == 1) {
                this.mCameraDeviceType = 2;
            }
            this.mCameraOrientation = cameraInfo.orientation;
            CameraParameters cameraParameters = this.mCameraParameters;
            if (cameraParameters != null) {
                cameraParameters.a();
            }
            this.mCameraParameters = CameraParameters.createWithDefaultIntrinsics(new Vec2I(this.mWidth, this.mHeight), this.mCameraDeviceType, this.mCameraOrientation);
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            parameters.setPreviewFormat(17);
            this.mSupportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            this.mSupportedPreviewFpsRanges = supportedPreviewFpsRange;
            int i7 = this.mCurrentFpsRange;
            if (i7 < 0 || i7 >= supportedPreviewFpsRange.size()) {
                this.mCurrentFpsRange = this.mSupportedPreviewFpsRanges.size() - 1;
                int i8 = 0;
                for (int[] iArr : this.mSupportedPreviewFpsRanges) {
                    if (iArr[0] == 30000 && iArr[1] == 30000) {
                        this.mCurrentFpsRange = i8;
                    }
                    i8++;
                }
                parameters.setPreviewFpsRange(this.mSupportedPreviewFpsRanges.get(this.mCurrentFpsRange)[0], this.mSupportedPreviewFpsRanges.get(this.mCurrentFpsRange)[1]);
            }
            int[] iArr2 = this.mSizeToSet.data;
            Camera.Size optimalPreviewSize = getOptimalPreviewSize(iArr2[0], iArr2[1]);
            parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
            this.mCameraDevice.setParameters(parameters);
            Camera.Parameters parameters2 = this.mCameraDevice.getParameters();
            Camera.Size previewSize = parameters2.getPreviewSize();
            this.mWidth = previewSize.width;
            this.mHeight = previewSize.height;
            CameraParameters cameraParameters2 = this.mCameraParameters;
            if (cameraParameters2 != null) {
                cameraParameters2.a();
            }
            this.mCameraParameters = CameraParameters.createWithDefaultIntrinsics(new Vec2I(this.mWidth, this.mHeight), this.mCameraDeviceType, this.mCameraOrientation);
            this.mCameraDevice.setParameters(parameters2);
            setFrameRateRange(this.mCurrentFpsRange);
            return true;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            if (this.mCameraDevice != null) {
                try {
                    this.mCameraDevice.release();
                } catch (Exception unused) {
                }
                this.mCameraDevice = null;
            }
            return false;
        }
    }

    private Camera.Size getOptimalPreviewSize(int width, int height) {
        Camera.Size size = null;
        float f6 = Float.MAX_VALUE;
        for (Camera.Size size2 : this.mSupportedPreviewSizes) {
            float ratioError = getRatioError(width, size2.width) + getRatioError(height, size2.height);
            if (ratioError < f6) {
                size = size2;
                f6 = ratioError;
            }
        }
        return size;
    }

    private float getRatioError(float x5, float x02) {
        float max = (x5 / Math.max(x02, 1.0f)) - 1.0f;
        float max2 = (x02 / Math.max(x5, 1.0f)) - 1.0f;
        return (max * max) + (max2 * max2);
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
        if (this.mSupportedPreviewFpsRanges == null) {
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
        List<int[]> list = this.mSupportedPreviewFpsRanges;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getNumSupportedSize() {
        List<Camera.Size> list = this.mSupportedPreviewSizes;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSizeHeight() {
        return this.mHeight;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSizeWidth() {
        return this.mWidth;
    }

    @Override // cn.easyar.engine.CameraDevice
    public float getSupportedFrameRateRangeLower(int index) {
        List<int[]> list = this.mSupportedPreviewFpsRanges;
        if (list != null && index >= 0 && index < list.size()) {
            return this.mSupportedPreviewFpsRanges.get(index)[0] / 1000.0f;
        }
        return 0.0f;
    }

    @Override // cn.easyar.engine.CameraDevice
    public float getSupportedFrameRateRangeUpper(int index) {
        List<int[]> list = this.mSupportedPreviewFpsRanges;
        if (list != null && index >= 0 && index < list.size()) {
            return this.mSupportedPreviewFpsRanges.get(index)[1] / 1000.0f;
        }
        return 0.0f;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSupportedSizeHeight(int index) {
        List<Camera.Size> list = this.mSupportedPreviewSizes;
        if (list != null && index >= 0 && index < list.size()) {
            return this.mSupportedPreviewSizes.get(index).height;
        }
        return 0;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getSupportedSizeWidth(int index) {
        List<Camera.Size> list = this.mSupportedPreviewSizes;
        if (list != null && index >= 0 && index < list.size()) {
            return this.mSupportedPreviewSizes.get(index).width;
        }
        return 0;
    }

    @Override // cn.easyar.engine.CameraDevice
    public int getType() {
        return this.mCameraDeviceType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] data, Camera camera) {
        InputFrame inputFrame;
        Buffer buffer;
        Image image;
        if (data == null) {
            return;
        }
        InputFrame inputFrame2 = null;
        try {
            buffer = Buffer.k(data);
            try {
                image = new Image(buffer, 2, this.mWidth, this.mHeight);
                try {
                    double elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() * 1.0E-9d;
                    CameraParameters resized = this.mCameraParameters.getResized(new Vec2I(this.mWidth, this.mHeight));
                    try {
                        inputFrame2 = InputFrame.createWithImageAndCameraParametersAndTemporal(image, resized, elapsedRealtimeNanos);
                        this.mInputFrameHandler.invoke(inputFrame2);
                        if (resized != 0) {
                            resized.a();
                        }
                        if (inputFrame2 != null) {
                            inputFrame2.a();
                        }
                        image.a();
                        if (buffer != null) {
                            buffer.a();
                        }
                        if (this.mBufferSize.get() <= this.mBufferCapacity) {
                            camera.addCallbackBuffer(data);
                        } else {
                            this.mBufferSize.getAndDecrement();
                        }
                    } catch (Throwable th) {
                        th = th;
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
                        if (buffer != null) {
                            buffer.a();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputFrame = null;
                }
            } catch (Throwable th3) {
                th = th3;
                inputFrame = null;
                image = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputFrame = null;
            buffer = null;
            image = null;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean openWithSpecificType(int type) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i6 = 0; i6 < numberOfCameras; i6++) {
            Camera.getCameraInfo(i6, cameraInfo);
            if (type == 1 && cameraInfo.facing == 0) {
                return openWithIndex(i6);
            }
            if (type == 2 && cameraInfo.facing == 1) {
                return openWithIndex(i6);
            }
            if (type == 0) {
                return openWithIndex(i6);
            }
        }
        return false;
    }

    public boolean ready() {
        return this.mCameraDevice != null;
    }

    @Override // cn.easyar.engine.CameraDevice
    public void setBufferCapacity(int capacity) {
        this.mBufferCapacity = capacity;
        if (ready()) {
            for (int i6 = this.mBufferSize.get(); i6 < capacity; i6++) {
                this.mCameraDevice.addCallbackBuffer(new byte[((this.mWidth * this.mHeight) * 3) / 2]);
            }
            this.mBufferSize.set(this.mBufferCapacity);
        }
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
    public boolean setFocusMode(int focusMode) {
        if (!ready()) {
            this.mFocusMode = Integer.valueOf(focusMode);
            return false;
        }
        try {
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (focusMode != 0) {
                if (focusMode != 2) {
                    if (focusMode != 3) {
                        if (focusMode != 4 || !supportedFocusModes.contains("macro")) {
                            return false;
                        }
                        parameters.setFocusMode("macro");
                    } else {
                        if (!supportedFocusModes.contains("infinity")) {
                            return false;
                        }
                        parameters.setFocusMode("infinity");
                    }
                } else if (supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                } else {
                    if (!supportedFocusModes.contains("continuous-video")) {
                        return false;
                    }
                    parameters.setFocusMode("continuous-video");
                }
            } else {
                if (!supportedFocusModes.contains("auto")) {
                    return false;
                }
                parameters.setFocusMode("auto");
            }
            this.mFocusMode = Integer.valueOf(focusMode);
            this.mCameraDevice.setParameters(parameters);
            return true;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setFrameRateRange(int index) {
        List<int[]> list = this.mSupportedPreviewFpsRanges;
        if (list != null && index >= 0 && index < list.size()) {
            this.mCurrentFpsRange = index;
            try {
                Camera.Parameters parameters = this.mCameraDevice.getParameters();
                parameters.setPreviewFpsRange(this.mSupportedPreviewFpsRanges.get(this.mCurrentFpsRange)[0], this.mSupportedPreviewFpsRanges.get(this.mCurrentFpsRange)[1]);
                this.mCameraDevice.setParameters(parameters);
                return true;
            } catch (Exception e6) {
                Log.getStackTraceString(e6);
            }
        }
        return false;
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setSize(int width, int height) {
        this.mSizeToSet = new Vec2I(width, height);
        if (!ready()) {
            return false;
        }
        try {
            if (!this.mStarted) {
                return true;
            }
            close();
            start();
            return true;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return false;
        }
    }

    public CameraDeviceCamera(Context context, FunctorOfVoidFromInputFrame inputFrameHandler) {
        this.mInputFrameHandler = inputFrameHandler;
    }

    @Override // cn.easyar.engine.CameraDevice
    public void close() {
        stop();
        CameraParameters cameraParameters = this.mCameraParameters;
        if (cameraParameters != null) {
            cameraParameters.a();
            this.mCameraParameters = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean setFlashTorchMode(boolean on) {
        String str;
        if (!ready()) {
            this.mFlashTorchMode = Boolean.valueOf(on);
            return false;
        }
        try {
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            if (on) {
                str = "torch";
            } else {
                str = t0.f49654e;
            }
            List<String> supportedFlashModes = this.mCameraDevice.getParameters().getSupportedFlashModes();
            if (supportedFlashModes == null || !supportedFlashModes.contains(str)) {
                return false;
            }
            parameters.setFlashMode(str);
            this.mCameraDevice.setParameters(parameters);
            this.mFlashTorchMode = Boolean.valueOf(on);
            return true;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public boolean start() {
        int i6;
        if (!ready() && !openWithIndex(this.mCameraIndex)) {
            return false;
        }
        try {
            this.mCameraDevice.setPreviewTexture(this.mSurfaceTexture);
            this.mCameraDevice.setPreviewCallbackWithBuffer(this);
            int i7 = 0;
            while (true) {
                i6 = this.mBufferCapacity;
                if (i7 >= i6) {
                    break;
                }
                this.mCameraDevice.addCallbackBuffer(new byte[((this.mWidth * this.mHeight) * 3) / 2]);
                i7++;
            }
            this.mBufferSize.set(i6);
            this.mCameraDevice.startPreview();
            Boolean bool = this.mFlashTorchMode;
            if (bool != null) {
                setFlashTorchMode(bool.booleanValue());
            }
            Integer num = this.mFocusMode;
            if (num != null) {
                setFocusMode(num.intValue());
            }
            this.mStarted = true;
            return true;
        } catch (Exception e6) {
            Log.getStackTraceString(e6);
            return false;
        }
    }

    @Override // cn.easyar.engine.CameraDevice
    public void stop() {
        if (!ready()) {
            return;
        }
        this.mStarted = false;
        try {
            this.mCameraDevice.stopPreview();
        } catch (Exception unused) {
        }
        try {
            this.mCameraDevice.setPreviewCallback(null);
        } catch (Exception unused2) {
        }
        try {
            this.mCameraDevice.release();
        } catch (Exception unused3) {
        }
        this.mCameraDevice = null;
    }
}
