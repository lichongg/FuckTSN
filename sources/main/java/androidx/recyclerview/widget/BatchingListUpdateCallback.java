package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public void dispatchLastEvent() {
        int i6 = this.mLastEventType;
        if (i6 == 0) {
            return;
        }
        if (i6 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i6 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i6 == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i6, int i7, Object obj) {
        int i8;
        if (this.mLastEventType == 3) {
            int i9 = this.mLastEventPosition;
            int i10 = this.mLastEventCount;
            if (i6 <= i9 + i10 && (i8 = i6 + i7) >= i9 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i6, i9);
                this.mLastEventCount = Math.max(i10 + i9, i8) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i6;
        this.mLastEventCount = i7;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i6, int i7) {
        int i8;
        if (this.mLastEventType == 1 && i6 >= (i8 = this.mLastEventPosition)) {
            int i9 = this.mLastEventCount;
            if (i6 <= i8 + i9) {
                this.mLastEventCount = i9 + i7;
                this.mLastEventPosition = Math.min(i6, i8);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i6;
        this.mLastEventCount = i7;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i6, int i7) {
        int i8;
        if (this.mLastEventType == 2 && (i8 = this.mLastEventPosition) >= i6 && i8 <= i6 + i7) {
            this.mLastEventCount += i7;
            this.mLastEventPosition = i6;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i6;
            this.mLastEventCount = i7;
            this.mLastEventType = 2;
        }
    }

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i6, int i7) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i6, i7);
    }
}
