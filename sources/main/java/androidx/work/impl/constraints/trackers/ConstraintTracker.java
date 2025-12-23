package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    protected final Context mAppContext;
    T mCurrentState;
    protected final TaskExecutor mTaskExecutor;
    private final Object mLock = new Object();
    private final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();

    public abstract T getInitialState();

    public abstract void startTracking();

    public abstract void stopTracking();

    public void addListener(ConstraintListener<T> listener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.add(listener)) {
                    if (this.mListeners.size() == 1) {
                        this.mCurrentState = getInitialState();
                        Logger.get().debug(TAG, String.format("%s: initial state = %s", getClass().getSimpleName(), this.mCurrentState), new Throwable[0]);
                        startTracking();
                    }
                    listener.onConstraintChanged(this.mCurrentState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeListener(ConstraintListener<T> listener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.remove(listener) && this.mListeners.isEmpty()) {
                    stopTracking();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setState(T newState) {
        synchronized (this.mLock) {
            try {
                T t5 = this.mCurrentState;
                if (t5 != newState && (t5 == null || !t5.equals(newState))) {
                    this.mCurrentState = newState;
                    final ArrayList arrayList = new ArrayList(this.mListeners);
                    this.mTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.ConstraintTracker.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((ConstraintListener) it.next()).onConstraintChanged(ConstraintTracker.this.mCurrentState);
                            }
                        }
                    });
                }
            } finally {
            }
        }
    }

    ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }
}
