package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class SurfaceEdge {

    @Nullable
    private SurfaceOutputImpl mConsumerToNotify;
    private final Rect mCropRect;
    private final int mFormat;
    private final boolean mHasCameraTransform;
    private final boolean mMirroring;

    @Nullable
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;

    @NonNull
    private SettableSurface mSettableSurface;
    private final StreamSpec mStreamSpec;
    private int mTargetRotation;
    private final int mTargets;
    private boolean mHasConsumer = false;

    @NonNull
    private final Set<Runnable> mOnInvalidatedListeners = new HashSet();
    private boolean mIsClosed = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SettableSurface extends DeferrableSurface {
        CallbackToFutureAdapter.Completer<Surface> mCompleter;
        private DeferrableSurface mProvider;
        final ListenableFuture<Surface> mSurfaceFuture;

        public static /* synthetic */ Object d(SettableSurface settableSurface, CallbackToFutureAdapter.Completer completer) {
            settableSurface.mCompleter = completer;
            return "SettableFuture hashCode: " + settableSurface.hashCode();
        }

        @VisibleForTesting
        boolean hasProvider() {
            return this.mProvider != null;
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        @NonNull
        protected ListenableFuture<Surface> provideSurface() {
            return this.mSurfaceFuture;
        }

        SettableSurface(@NonNull Size size, int i6) {
            super(size, i6);
            this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.a0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return SurfaceEdge.SettableSurface.d(SurfaceEdge.SettableSurface.this, completer);
                }
            });
        }

        @MainThread
        boolean canSetProvider() {
            Threads.checkMainThread();
            if (this.mProvider == null && !isClosed()) {
                return true;
            }
            return false;
        }

        @MainThread
        public boolean setProvider(@NonNull final DeferrableSurface deferrableSurface, @NonNull Runnable runnable) throws DeferrableSurface.SurfaceClosedException {
            boolean z5;
            Threads.checkMainThread();
            Preconditions.checkNotNull(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.mProvider;
            boolean z6 = false;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            if (deferrableSurface2 == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkState(z5, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            Preconditions.checkArgument(getPrescribedSize().equals(deferrableSurface.getPrescribedSize()), "The provider's size must match the parent");
            if (getPrescribedStreamFormat() == deferrableSurface.getPrescribedStreamFormat()) {
                z6 = true;
            }
            Preconditions.checkArgument(z6, "The provider's format must match the parent");
            Preconditions.checkState(!isClosed(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.mProvider = deferrableSurface;
            Futures.propagate(deferrableSurface.getSurface(), this.mCompleter);
            deferrableSurface.incrementUseCount();
            getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.processing.z
                @Override // java.lang.Runnable
                public final void run() {
                    DeferrableSurface.this.decrementUseCount();
                }
            }, CameraXExecutors.directExecutor());
            deferrableSurface.getCloseFuture().addListener(runnable, CameraXExecutors.mainThreadExecutor());
            return true;
        }
    }

    public void updateTransformation(int i6) {
        updateTransformation(i6, -1);
    }

    public static /* synthetic */ void c(SurfaceEdge surfaceEdge) {
        if (surfaceEdge.mIsClosed) {
            return;
        }
        surfaceEdge.invalidate();
    }

    private void checkAndSetHasConsumer() {
        Preconditions.checkState(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
    }

    private void checkNotClosed() {
        Preconditions.checkState(!this.mIsClosed, "Edge is already closed.");
    }

    public static /* synthetic */ void d(SurfaceEdge surfaceEdge, int i6, int i7) {
        boolean z5;
        boolean z6 = true;
        if (surfaceEdge.mRotationDegrees != i6) {
            surfaceEdge.mRotationDegrees = i6;
            z5 = true;
        } else {
            z5 = false;
        }
        if (surfaceEdge.mTargetRotation != i7) {
            surfaceEdge.mTargetRotation = i7;
        } else {
            z6 = z5;
        }
        if (z6) {
            surfaceEdge.notifyTransformationInfoUpdate();
        }
    }

    @NonNull
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @NonNull
    @VisibleForTesting
    public DeferrableSurface getDeferrableSurfaceForTesting() {
        return this.mSettableSurface;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public boolean getMirroring() {
        return this.mMirroring;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    @NonNull
    public StreamSpec getStreamSpec() {
        return this.mStreamSpec;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean hasCameraTransform() {
        return this.mHasCameraTransform;
    }

    @VisibleForTesting
    public boolean hasProvider() {
        return this.mSettableSurface.hasProvider();
    }

    @VisibleForTesting
    public boolean isClosed() {
        return this.mIsClosed;
    }

    public void updateTransformation(final int i6, final int i7) {
        Threads.runOnMain(new Runnable() { // from class: androidx.camera.core.processing.v
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceEdge.d(SurfaceEdge.this, i6, i7);
            }
        });
    }

    public SurfaceEdge(int i6, int i7, @NonNull StreamSpec streamSpec, @NonNull Matrix matrix, boolean z5, @NonNull Rect rect, int i8, int i9, boolean z6) {
        this.mTargets = i6;
        this.mFormat = i7;
        this.mStreamSpec = streamSpec;
        this.mSensorToBufferTransform = matrix;
        this.mHasCameraTransform = z5;
        this.mCropRect = rect;
        this.mRotationDegrees = i8;
        this.mTargetRotation = i9;
        this.mMirroring = z6;
        this.mSettableSurface = new SettableSurface(streamSpec.getResolution(), i7);
    }

    public static /* synthetic */ ListenableFuture a(SurfaceEdge surfaceEdge, final SettableSurface settableSurface, int i6, Size size, Rect rect, int i7, boolean z5, CameraInternal cameraInternal, Surface surface) {
        surfaceEdge.getClass();
        Preconditions.checkNotNull(surface);
        try {
            settableSurface.incrementUseCount();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, surfaceEdge.getTargets(), i6, surfaceEdge.mStreamSpec.getResolution(), size, rect, i7, z5, cameraInternal, surfaceEdge.mSensorToBufferTransform);
            surfaceOutputImpl.getCloseFuture().addListener(new Runnable() { // from class: androidx.camera.core.processing.y
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceEdge.SettableSurface.this.decrementUseCount();
                }
            }, CameraXExecutors.directExecutor());
            surfaceEdge.mConsumerToNotify = surfaceOutputImpl;
            return Futures.immediateFuture(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e6) {
            return Futures.immediateFailedFuture(e6);
        }
    }

    public static /* synthetic */ void b(final SurfaceEdge surfaceEdge) {
        surfaceEdge.getClass();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.processing.w
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceEdge.c(SurfaceEdge.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectWithoutCheckingClosed() {
        Threads.checkMainThread();
        this.mSettableSurface.close();
        SurfaceOutputImpl surfaceOutputImpl = this.mConsumerToNotify;
        if (surfaceOutputImpl != null) {
            surfaceOutputImpl.requestClose();
            this.mConsumerToNotify = null;
        }
    }

    @MainThread
    private void notifyTransformationInfoUpdate() {
        Threads.checkMainThread();
        SurfaceRequest surfaceRequest = this.mProviderSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.updateTransformationInfo(SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, hasCameraTransform(), this.mSensorToBufferTransform, this.mMirroring));
        }
    }

    @MainThread
    public void addOnInvalidatedListener(@NonNull Runnable runnable) {
        Threads.checkMainThread();
        checkNotClosed();
        this.mOnInvalidatedListeners.add(runnable);
    }

    @MainThread
    public final void close() {
        Threads.checkMainThread();
        disconnectWithoutCheckingClosed();
        this.mIsClosed = true;
    }

    @NonNull
    @MainThread
    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(@NonNull final Size size, final int i6, @NonNull final Rect rect, final int i7, final boolean z5, @Nullable final CameraInternal cameraInternal) {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        final SettableSurface settableSurface = this.mSettableSurface;
        return Futures.transformAsync(settableSurface.getSurface(), new AsyncFunction() { // from class: androidx.camera.core.processing.x
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return SurfaceEdge.a(SurfaceEdge.this, settableSurface, i6, size, rect, i7, z5, cameraInternal, (Surface) obj);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    @NonNull
    @MainThread
    public SurfaceRequest createSurfaceRequest(@NonNull CameraInternal cameraInternal) {
        Threads.checkMainThread();
        checkNotClosed();
        SurfaceRequest surfaceRequest = new SurfaceRequest(this.mStreamSpec.getResolution(), cameraInternal, this.mStreamSpec.getDynamicRange(), this.mStreamSpec.getExpectedFrameRateRange(), new Runnable() { // from class: androidx.camera.core.processing.s
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceEdge.b(SurfaceEdge.this);
            }
        });
        try {
            final DeferrableSurface deferrableSurface = surfaceRequest.getDeferrableSurface();
            if (this.mSettableSurface.setProvider(deferrableSurface, new t(this))) {
                ListenableFuture<Void> terminationFuture = this.mSettableSurface.getTerminationFuture();
                Objects.requireNonNull(deferrableSurface);
                terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.processing.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeferrableSurface.this.close();
                    }
                }, CameraXExecutors.directExecutor());
            }
            this.mProviderSurfaceRequest = surfaceRequest;
            notifyTransformationInfoUpdate();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e6) {
            throw new AssertionError("Surface is somehow already closed", e6);
        } catch (RuntimeException e7) {
            surfaceRequest.willNotProvideSurface();
            throw e7;
        }
    }

    @MainThread
    public final void disconnect() {
        Threads.checkMainThread();
        checkNotClosed();
        disconnectWithoutCheckingClosed();
    }

    @NonNull
    @MainThread
    public DeferrableSurface getDeferrableSurface() {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        return this.mSettableSurface;
    }

    @MainThread
    public void invalidate() {
        Threads.checkMainThread();
        checkNotClosed();
        if (!this.mSettableSurface.canSetProvider()) {
            disconnectWithoutCheckingClosed();
            this.mHasConsumer = false;
            this.mSettableSurface = new SettableSurface(this.mStreamSpec.getResolution(), this.mFormat);
            Iterator<Runnable> it = this.mOnInvalidatedListeners.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    @MainThread
    public void setProvider(@NonNull DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        checkNotClosed();
        this.mSettableSurface.setProvider(deferrableSurface, new t(this));
    }
}
