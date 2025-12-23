package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List<C> mCallbacks = new ArrayList();
    private long mFirst64Removed = 0;
    private int mNotificationLevel;
    private final NotifierCallback<C, T, A> mNotifier;
    private long[] mRemainderRemoved;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C callback, T sender, int arg, A arg2);
    }

    public synchronized void add(C callback) {
        try {
            if (callback == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int lastIndexOf = this.mCallbacks.lastIndexOf(callback);
            if (lastIndexOf >= 0) {
                if (isRemoved(lastIndexOf)) {
                }
            }
            this.mCallbacks.add(callback);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void clear() {
        try {
            if (this.mNotificationLevel == 0) {
                this.mCallbacks.clear();
            } else if (!this.mCallbacks.isEmpty()) {
                for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                    setRemovalBit(size);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.mCallbacks.size());
        int size = this.mCallbacks.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!isRemoved(i6)) {
                arrayList.add(this.mCallbacks.get(i6));
            }
        }
        return arrayList;
    }

    public synchronized boolean isEmpty() {
        if (this.mCallbacks.isEmpty()) {
            return true;
        }
        if (this.mNotificationLevel == 0) {
            return false;
        }
        int size = this.mCallbacks.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!isRemoved(i6)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void notifyCallbacks(T sender, int arg, A arg2) {
        try {
            this.mNotificationLevel++;
            notifyRecurse(sender, arg, arg2);
            int i6 = this.mNotificationLevel - 1;
            this.mNotificationLevel = i6;
            if (i6 == 0) {
                long[] jArr = this.mRemainderRemoved;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j6 = this.mRemainderRemoved[length];
                        if (j6 != 0) {
                            removeRemovedCallbacks((length + 1) * 64, j6);
                            this.mRemainderRemoved[length] = 0;
                        }
                    }
                }
                long j7 = this.mFirst64Removed;
                if (j7 != 0) {
                    removeRemovedCallbacks(0, j7);
                    this.mFirst64Removed = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void remove(C callback) {
        try {
            if (this.mNotificationLevel == 0) {
                this.mCallbacks.remove(callback);
            } else {
                int lastIndexOf = this.mCallbacks.lastIndexOf(callback);
                if (lastIndexOf >= 0) {
                    setRemovalBit(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean isRemoved(int index) {
        int i6;
        if (index < 64) {
            return ((1 << index) & this.mFirst64Removed) != 0;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr != null && (i6 = (index / 64) - 1) < jArr.length) {
            return ((1 << (index % 64)) & jArr[i6]) != 0;
        }
        return false;
    }

    private void notifyFirst64(T sender, int arg, A arg2) {
        notifyCallbacks(sender, arg, arg2, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
    }

    private void notifyRecurse(T sender, int arg, A arg2) {
        int size = this.mCallbacks.size();
        int length = this.mRemainderRemoved == null ? -1 : r0.length - 1;
        notifyRemainder(sender, arg, arg2, length);
        notifyCallbacks(sender, arg, arg2, (length + 2) * 64, size, 0L);
    }

    private void notifyRemainder(T sender, int arg, A arg2, int remainderIndex) {
        if (remainderIndex < 0) {
            notifyFirst64(sender, arg, arg2);
            return;
        }
        long j6 = this.mRemainderRemoved[remainderIndex];
        int i6 = (remainderIndex + 1) * 64;
        int min = Math.min(this.mCallbacks.size(), i6 + 64);
        notifyRemainder(sender, arg, arg2, remainderIndex - 1);
        notifyCallbacks(sender, arg, arg2, i6, min, j6);
    }

    private void removeRemovedCallbacks(int startIndex, long removed) {
        long j6 = Long.MIN_VALUE;
        for (int i6 = startIndex + 63; i6 >= startIndex; i6--) {
            if ((removed & j6) != 0) {
                this.mCallbacks.remove(i6);
            }
            j6 >>>= 1;
        }
    }

    private void setRemovalBit(int index) {
        if (index < 64) {
            this.mFirst64Removed = (1 << index) | this.mFirst64Removed;
            return;
        }
        int i6 = (index / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
        } else if (jArr.length <= i6) {
            long[] jArr2 = new long[this.mCallbacks.size() / 64];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long j6 = 1 << (index % 64);
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i6] = j6 | jArr4[i6];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized CallbackRegistry<C, T, A> m31clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e6;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.mFirst64Removed = 0L;
                callbackRegistry.mRemainderRemoved = null;
                callbackRegistry.mNotificationLevel = 0;
                callbackRegistry.mCallbacks = new ArrayList();
                int size = this.mCallbacks.size();
                for (int i6 = 0; i6 < size; i6++) {
                    if (!isRemoved(i6)) {
                        callbackRegistry.mCallbacks.add(this.mCallbacks.get(i6));
                    }
                }
            } catch (CloneNotSupportedException e7) {
                e6 = e7;
                e6.printStackTrace();
                return callbackRegistry;
            }
        } catch (CloneNotSupportedException e8) {
            callbackRegistry = null;
            e6 = e8;
        }
        return callbackRegistry;
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifier) {
        this.mNotifier = notifier;
    }

    public synchronized void copyCallbacks(List<C> callbacks) {
        callbacks.clear();
        int size = this.mCallbacks.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!isRemoved(i6)) {
                callbacks.add(this.mCallbacks.get(i6));
            }
        }
    }

    private void notifyCallbacks(T t5, int i6, A a6, int i7, int i8, long j6) {
        long j7 = 1;
        while (i7 < i8) {
            if ((j6 & j7) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(i7), t5, i6, a6);
            }
            j7 <<= 1;
            i7++;
        }
    }
}
