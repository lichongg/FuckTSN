package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final DifferentialVelocityProvider mVelocityProvider;
    private final FlingVelocityThresholdCalculator mVelocityThresholdCalculator;

    @Nullable
    private VelocityTracker mVelocityTracker;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface DifferentialVelocityProvider {
        float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface FlingVelocityThresholdCalculator {
        void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i6);
    }

    public DifferentialMotionFlingController(@NonNull Context context, @NonNull DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new FlingVelocityThresholdCalculator() { // from class: androidx.core.view.q
            @Override // androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator
            public final void calculateFlingVelocityThresholds(Context context2, int[] iArr, MotionEvent motionEvent, int i6) {
                DifferentialMotionFlingController.calculateFlingVelocityThresholds(context2, iArr, motionEvent, i6);
            }
        }, new DifferentialVelocityProvider() { // from class: androidx.core.view.r
            @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
            public final float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i6) {
                float currentVelocity;
                currentVelocity = DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i6);
                return currentVelocity;
            }
        });
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent motionEvent, int i6) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.mLastProcessedSource == source && this.mLastProcessedDeviceId == deviceId && this.mLastProcessedAxis == i6) {
            return false;
        }
        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, motionEvent, i6);
        this.mLastProcessedSource = source;
        this.mLastProcessedDeviceId = deviceId;
        this.mLastProcessedAxis = i6;
        return true;
    }

    private float getCurrentVelocity(MotionEvent motionEvent, int i6) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        return this.mVelocityProvider.getCurrentVelocity(this.mVelocityTracker, motionEvent, i6);
    }

    @VisibleForTesting
    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, FlingVelocityThresholdCalculator flingVelocityThresholdCalculator, DifferentialVelocityProvider differentialVelocityProvider) {
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{Integer.MAX_VALUE, 0};
        this.mContext = context;
        this.mTarget = differentialMotionFlingTarget;
        this.mVelocityThresholdCalculator = flingVelocityThresholdCalculator;
        this.mVelocityProvider = differentialVelocityProvider;
    }

    public void onMotionEvent(@NonNull MotionEvent motionEvent, int i6) {
        boolean calculateFlingVelocityThresholds = calculateFlingVelocityThresholds(motionEvent, i6);
        if (this.mFlingVelocityThresholds[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
                return;
            }
            return;
        }
        float currentVelocity = getCurrentVelocity(motionEvent, i6) * this.mTarget.getScaledScrollFactor();
        float signum = Math.signum(currentVelocity);
        float f6 = 0.0f;
        if (calculateFlingVelocityThresholds || (signum != Math.signum(this.mLastFlingVelocity) && signum != 0.0f)) {
            this.mTarget.stopDifferentialMotionFling();
        }
        float abs = Math.abs(currentVelocity);
        int[] iArr = this.mFlingVelocityThresholds;
        if (abs < iArr[0]) {
            return;
        }
        float max = Math.max(-r6, Math.min(currentVelocity, iArr[1]));
        if (this.mTarget.startDifferentialMotionFling(max)) {
            f6 = max;
        }
        this.mLastFlingVelocity = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i6) {
        VelocityTrackerCompat.addMovement(velocityTracker, motionEvent);
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker, 1000);
        return VelocityTrackerCompat.getAxisVelocity(velocityTracker, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i6) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i6, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i6, motionEvent.getSource());
    }
}
