package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.ColorRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class PreviewView extends FrameLayout {

    @ColorRes
    static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final ImplementationMode DEFAULT_IMPL_MODE = ImplementationMode.PERFORMANCE;
    private static final String TAG = "PreviewView";

    @Nullable
    final AtomicReference<PreviewStreamStateObserver> mActiveStreamStateObserver;
    CameraController mCameraController;

    @Nullable
    CameraInfoInternal mCameraInfoInternal;

    @NonNull
    private final DisplayRotationListener mDisplayRotationListener;

    @Nullable
    @VisibleForTesting
    PreviewViewImplementation mImplementation;

    @NonNull
    ImplementationMode mImplementationMode;

    @Nullable
    OnFrameUpdateListener mOnFrameUpdateListener;

    @Nullable
    Executor mOnFrameUpdateListenerExecutor;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;

    @NonNull
    final MutableLiveData<StreamState> mPreviewStreamStateLiveData;

    @NonNull
    final PreviewTransformation mPreviewTransform;

    @NonNull
    PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;

    @NonNull
    private final ScaleGestureDetector mScaleGestureDetector;
    final Preview.SurfaceProvider mSurfaceProvider;

    @Nullable
    private MotionEvent mTouchUpEvent;
    boolean mUseDisplayRotation;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.view.PreviewView$1, reason: invalid class name */
    class AnonymousClass1 implements Preview.SurfaceProvider {
        AnonymousClass1() {
        }

        public static /* synthetic */ void b(AnonymousClass1 anonymousClass1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
            if (p.a(PreviewView.this.mActiveStreamStateObserver, previewStreamStateObserver, null)) {
                previewStreamStateObserver.updatePreviewStreamState(StreamState.IDLE);
            }
            previewStreamStateObserver.clear();
            cameraInternal.getCameraState().removeObserver(previewStreamStateObserver);
        }

        public static /* synthetic */ void c(AnonymousClass1 anonymousClass1, CameraInternal cameraInternal, SurfaceRequest surfaceRequest, SurfaceRequest.TransformationInfo transformationInfo) {
            boolean z5;
            PreviewView previewView;
            PreviewViewImplementation previewViewImplementation;
            anonymousClass1.getClass();
            Logger.d(PreviewView.TAG, "Preview transformation info updated. " + transformationInfo);
            if (cameraInternal.getCameraInfoInternal().getLensFacing() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            PreviewView.this.mPreviewTransform.setTransformationInfo(transformationInfo, surfaceRequest.getResolution(), z5);
            if (transformationInfo.getTargetRotation() != -1 && ((previewViewImplementation = (previewView = PreviewView.this).mImplementation) == null || !(previewViewImplementation instanceof SurfaceViewImplementation))) {
                previewView.mUseDisplayRotation = false;
            } else {
                PreviewView.this.mUseDisplayRotation = true;
            }
            PreviewView.this.redrawPreview();
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        @AnyThread
        public void onSurfaceRequested(@NonNull final SurfaceRequest surfaceRequest) {
            Executor executor;
            PreviewViewImplementation surfaceViewImplementation;
            if (!Threads.isMainThread()) {
                ContextCompat.getMainExecutor(PreviewView.this.getContext()).execute(new Runnable() { // from class: androidx.camera.view.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreviewView.this.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
                    }
                });
                return;
            }
            Logger.d(PreviewView.TAG, "Surface requested by Preview.");
            final CameraInternal camera = surfaceRequest.getCamera();
            PreviewView.this.mCameraInfoInternal = camera.getCameraInfoInternal();
            surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor(PreviewView.this.getContext()), new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.view.s
                @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
                public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                    PreviewView.AnonymousClass1.c(PreviewView.AnonymousClass1.this, camera, surfaceRequest, transformationInfo);
                }
            });
            PreviewView previewView = PreviewView.this;
            if (!PreviewView.shouldReuseImplementation(previewView.mImplementation, surfaceRequest, previewView.mImplementationMode)) {
                PreviewView previewView2 = PreviewView.this;
                if (PreviewView.shouldUseTextureView(surfaceRequest, previewView2.mImplementationMode)) {
                    PreviewView previewView3 = PreviewView.this;
                    surfaceViewImplementation = new TextureViewImplementation(previewView3, previewView3.mPreviewTransform);
                } else {
                    PreviewView previewView4 = PreviewView.this;
                    surfaceViewImplementation = new SurfaceViewImplementation(previewView4, previewView4.mPreviewTransform);
                }
                previewView2.mImplementation = surfaceViewImplementation;
            }
            CameraInfoInternal cameraInfoInternal = camera.getCameraInfoInternal();
            PreviewView previewView5 = PreviewView.this;
            final PreviewStreamStateObserver previewStreamStateObserver = new PreviewStreamStateObserver(cameraInfoInternal, previewView5.mPreviewStreamStateLiveData, previewView5.mImplementation);
            PreviewView.this.mActiveStreamStateObserver.set(previewStreamStateObserver);
            camera.getCameraState().addObserver(ContextCompat.getMainExecutor(PreviewView.this.getContext()), previewStreamStateObserver);
            PreviewView.this.mImplementation.onSurfaceRequested(surfaceRequest, new PreviewViewImplementation.OnSurfaceNotInUseListener() { // from class: androidx.camera.view.t
                @Override // androidx.camera.view.PreviewViewImplementation.OnSurfaceNotInUseListener
                public final void onSurfaceNotInUse() {
                    PreviewView.AnonymousClass1.b(PreviewView.AnonymousClass1.this, previewStreamStateObserver, camera);
                }
            });
            PreviewView previewView6 = PreviewView.this;
            OnFrameUpdateListener onFrameUpdateListener = previewView6.mOnFrameUpdateListener;
            if (onFrameUpdateListener != null && (executor = previewView6.mOnFrameUpdateListenerExecutor) != null) {
                previewView6.mImplementation.setFrameUpdateListener(executor, onFrameUpdateListener);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class DisplayRotationListener implements DisplayManager.DisplayListener {
        DisplayRotationListener() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i6) {
            Display display = PreviewView.this.getDisplay();
            if (display == null || display.getDisplayId() != i6) {
                return;
            }
            PreviewView.this.redrawPreview();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i6) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);

        private final int mId;

        int getId() {
            return this.mId;
        }

        ImplementationMode(int i6) {
            this.mId = i6;
        }

        static ImplementationMode fromId(int i6) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i6) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnFrameUpdateListener {
        void onFrameUpdate(long j6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class PinchToZoomOnScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        PinchToZoomOnScaleGestureListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            CameraController cameraController = PreviewView.this.mCameraController;
            if (cameraController == null) {
                return true;
            }
            cameraController.onPinchToZoom(scaleGestureDetector.getScaleFactor());
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);

        private final int mId;

        int getId() {
            return this.mId;
        }

        ScaleType(int i6) {
            this.mId = i6;
        }

        static ScaleType fromId(int i6) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i6) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum StreamState {
        IDLE,
        STREAMING
    }

    @UiThread
    public PreviewView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    @UiThread
    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (getDisplay() == null) {
            return null;
        }
        return getViewPort(getDisplay().getRotation());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.view.PreviewView$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode;
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

        static {
            int[] iArr = new int[ImplementationMode.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode = iArr;
            try {
                iArr[ImplementationMode.COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[ImplementationMode.PERFORMANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ScaleType.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType = iArr2;
            try {
                iArr2[ScaleType.FILL_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[ScaleType.FILL_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[ScaleType.FIT_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getViewPortScaleType() {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[getScaleType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                throw new IllegalStateException("Unexpected scale type: " + getScaleType());
        }
    }

    @VisibleForTesting
    static boolean shouldReuseImplementation(@Nullable PreviewViewImplementation previewViewImplementation, @NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        return (previewViewImplementation instanceof SurfaceViewImplementation) && !shouldUseTextureView(surfaceRequest, implementationMode);
    }

    @NonNull
    public LiveData<StreamState> getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mCameraController == null) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z5 = motionEvent.getPointerCount() == 1;
        boolean z6 = motionEvent.getAction() == 1;
        boolean z7 = motionEvent.getEventTime() - motionEvent.getDownTime() < ((long) ViewConfiguration.getLongPressTimeout());
        if (!z5 || !z6 || !z7) {
            return this.mScaleGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
        }
        this.mTouchUpEvent = motionEvent;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mCameraController != null) {
            MotionEvent motionEvent = this.mTouchUpEvent;
            float x5 = motionEvent != null ? motionEvent.getX() : getWidth() / 2.0f;
            MotionEvent motionEvent2 = this.mTouchUpEvent;
            this.mCameraController.onTapToFocus(this.mPreviewViewMeteringPointFactory, x5, motionEvent2 != null ? motionEvent2.getY() : getHeight() / 2.0f);
        }
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFrameUpdateListener(@NonNull Executor executor, @NonNull OnFrameUpdateListener onFrameUpdateListener) {
        if (this.mImplementationMode == ImplementationMode.PERFORMANCE) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
        this.mOnFrameUpdateListener = onFrameUpdateListener;
        this.mOnFrameUpdateListenerExecutor = executor;
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.setFrameUpdateListener(executor, onFrameUpdateListener);
        }
    }

    void updateDisplayRotationIfNeeded() {
        Display display;
        CameraInfoInternal cameraInfoInternal;
        if (!this.mUseDisplayRotation || (display = getDisplay()) == null || (cameraInfoInternal = this.mCameraInfoInternal) == null) {
            return;
        }
        this.mPreviewTransform.overrideWithDisplayRotation(cameraInfoInternal.getSensorRotationDegrees(display.getRotation()), display.getRotation());
    }

    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, 0);
    }

    public static /* synthetic */ void a(PreviewView previewView, View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        previewView.getClass();
        if (i8 - i6 == i12 - i10 && i9 - i7 == i13 - i11) {
            return;
        }
        previewView.redrawPreview();
        previewView.attachToControllerIfReady(true);
    }

    @MainThread
    private void attachToControllerIfReady(boolean z5) {
        Threads.checkMainThread();
        ViewPort viewPort = getViewPort();
        if (this.mCameraController != null && viewPort != null && isAttachedToWindow()) {
            try {
                this.mCameraController.attachPreviewSurface(getSurfaceProvider(), viewPort);
            } catch (IllegalStateException e6) {
                if (z5) {
                    Logger.e(TAG, e6.toString(), e6);
                    return;
                }
                throw e6;
            }
        }
    }

    @Nullable
    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    static boolean shouldUseTextureView(@NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        boolean z5;
        int i6;
        boolean equals = surfaceRequest.getCamera().getCameraInfoInternal().getImplementationType().equals(CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY);
        if (DeviceQuirks.get(SurfaceViewStretchedQuirk.class) == null && DeviceQuirks.get(SurfaceViewNotCroppedByParentQuirk.class) == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (Build.VERSION.SDK_INT <= 24 || equals || z5 || (i6 = AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[implementationMode.ordinal()]) == 1) {
            return true;
        }
        if (i6 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private void startListeningToDisplayChange() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
    }

    private void stopListeningToDisplayChange() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.mDisplayRotationListener);
    }

    @Nullable
    @UiThread
    public Bitmap getBitmap() {
        Threads.checkMainThread();
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation == null) {
            return null;
        }
        return previewViewImplementation.getBitmap();
    }

    @Nullable
    @UiThread
    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    @NonNull
    @UiThread
    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    @NonNull
    @UiThread
    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    @Nullable
    @TransformExperimental
    public OutputTransform getOutputTransform() {
        Matrix matrix;
        Threads.checkMainThread();
        try {
            matrix = this.mPreviewTransform.getSurfaceToPreviewViewMatrix(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect surfaceCropRect = this.mPreviewTransform.getSurfaceCropRect();
        if (matrix != null && surfaceCropRect != null) {
            matrix.preConcat(TransformUtils.getNormalizedToBuffer(surfaceCropRect));
            if (this.mImplementation instanceof TextureViewImplementation) {
                matrix.postConcat(getMatrix());
            } else if (!getMatrix().isIdentity()) {
                Logger.w(TAG, "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
            }
            return new OutputTransform(matrix, new Size(surfaceCropRect.width(), surfaceCropRect.height()));
        }
        Logger.d(TAG, "Transform info is not ready");
        return null;
    }

    @NonNull
    @UiThread
    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getSensorToViewTransform() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getSensorToViewTransform(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    @NonNull
    @UiThread
    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startListeningToDisplayChange();
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onAttachedToWindow();
        }
        attachToControllerIfReady(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onDetachedFromWindow();
        }
        CameraController cameraController = this.mCameraController;
        if (cameraController != null) {
            cameraController.clearPreviewSurface();
        }
        stopListeningToDisplayChange();
    }

    @OptIn(markerClass = {TransformExperimental.class})
    @MainThread
    void redrawPreview() {
        Threads.checkMainThread();
        if (this.mImplementation != null) {
            updateDisplayRotationIfNeeded();
            this.mImplementation.redrawPreview();
        }
        this.mPreviewViewMeteringPointFactory.recalculate(new Size(getWidth(), getHeight()), getLayoutDirection());
        CameraController cameraController = this.mCameraController;
        if (cameraController != null) {
            cameraController.updatePreviewViewTransform(getSensorToViewTransform());
        }
    }

    @UiThread
    public void setController(@Nullable CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (cameraController2 != null && cameraController2 != cameraController) {
            cameraController2.clearPreviewSurface();
        }
        this.mCameraController = cameraController;
        attachToControllerIfReady(false);
    }

    @UiThread
    public void setImplementationMode(@NonNull ImplementationMode implementationMode) {
        Threads.checkMainThread();
        this.mImplementationMode = implementationMode;
        if (implementationMode == ImplementationMode.PERFORMANCE && this.mOnFrameUpdateListener != null) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
    }

    @UiThread
    public void setScaleType(@NonNull ScaleType scaleType) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(scaleType);
        redrawPreview();
        attachToControllerIfReady(false);
    }

    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        ImplementationMode implementationMode = DEFAULT_IMPL_MODE;
        this.mImplementationMode = implementationMode;
        PreviewTransformation previewTransformation = new PreviewTransformation();
        this.mPreviewTransform = previewTransformation;
        this.mUseDisplayRotation = true;
        this.mPreviewStreamStateLiveData = new MutableLiveData<>(StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference<>();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(previewTransformation);
        this.mDisplayRotationListener = new DisplayRotationListener();
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.camera.view.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                PreviewView.a(PreviewView.this, view, i8, i9, i10, i11, i12, i13, i14, i15);
            }
        };
        this.mSurfaceProvider = new AnonymousClass1();
        Threads.checkMainThread();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R.styleable.PreviewView;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i6, i7);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i6, i7);
        try {
            setScaleType(ScaleType.fromId(obtainStyledAttributes.getInteger(R.styleable.PreviewView_scaleType, previewTransformation.getScaleType().getId())));
            setImplementationMode(ImplementationMode.fromId(obtainStyledAttributes.getInteger(R.styleable.PreviewView_implementationMode, implementationMode.getId())));
            obtainStyledAttributes.recycle();
            this.mScaleGestureDetector = new ScaleGestureDetector(context, new PinchToZoomOnScaleGestureListener());
            if (getBackground() == null) {
                setBackgroundColor(ContextCompat.getColor(getContext(), 17170444));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Nullable
    @SuppressLint({"WrongConstant"})
    @UiThread
    public ViewPort getViewPort(int i6) {
        Threads.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new ViewPort.Builder(new Rational(getWidth(), getHeight()), i6).setScaleType(getViewPortScaleType()).setLayoutDirection(getLayoutDirection()).build();
    }
}
