package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback mCallback;
    private T mCurrentValue;
    private final List<String> mMatchingWorkSpecIds = new ArrayList();
    private ConstraintTracker<T> mTracker;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NonNull List<String> workSpecIds);

        void onConstraintNotMet(@NonNull List<String> workSpecIds);
    }

    abstract boolean hasConstraint(@NonNull WorkSpec workSpec);

    abstract boolean isConstrained(@NonNull T currentValue);

    private void updateCallback(@Nullable OnConstraintUpdatedCallback callback, @Nullable T currentValue) {
        if (this.mMatchingWorkSpecIds.isEmpty() || callback == null) {
            return;
        }
        if (currentValue == null || isConstrained(currentValue)) {
            callback.onConstraintNotMet(this.mMatchingWorkSpecIds);
        } else {
            callback.onConstraintMet(this.mMatchingWorkSpecIds);
        }
    }

    public boolean isWorkSpecConstrained(@NonNull String workSpecId) {
        T t5 = this.mCurrentValue;
        return t5 != null && isConstrained(t5) && this.mMatchingWorkSpecIds.contains(workSpecId);
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(@Nullable T newValue) {
        this.mCurrentValue = newValue;
        updateCallback(this.mCallback, newValue);
    }

    public void replace(@NonNull Iterable<WorkSpec> workSpecs) {
        this.mMatchingWorkSpecIds.clear();
        for (WorkSpec workSpec : workSpecs) {
            if (hasConstraint(workSpec)) {
                this.mMatchingWorkSpecIds.add(workSpec.id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener(this);
        } else {
            this.mTracker.addListener(this);
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public void reset() {
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            return;
        }
        this.mMatchingWorkSpecIds.clear();
        this.mTracker.removeListener(this);
    }

    public void setCallback(@Nullable OnConstraintUpdatedCallback callback) {
        if (this.mCallback != callback) {
            this.mCallback = callback;
            updateCallback(callback, this.mCurrentValue);
        }
    }

    ConstraintController(ConstraintTracker<T> tracker) {
        this.mTracker = tracker;
    }
}
