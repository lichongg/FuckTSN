package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final int REBOUND = 3;
    protected final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mInStateFlowRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private WeakListener[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = true;
    private static final CreateWeakListener CREATE_PROPERTY_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.1
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakPropertyListener(viewDataBinding, i6, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_LIST_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.2
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakListListener(viewDataBinding, i6, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_MAP_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.3
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new WeakMapListener(viewDataBinding, i6, referenceQueue).getListener();
        }
    };
    private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.4
        @Override // androidx.databinding.CreateWeakListener
        public WeakListener create(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            return new LiveDataListener(viewDataBinding, i6, referenceQueue).getListener();
        }
    };
    private static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i6, Void r42) {
            if (i6 == 1) {
                if (onRebindCallback.onPreBind(viewDataBinding)) {
                    return;
                }
                viewDataBinding.mRebindHalted = true;
            } else if (i6 == 2) {
                onRebindCallback.onCanceled(viewDataBinding);
            } else {
                if (i6 != 3) {
                    return;
                }
                onRebindCallback.onBound(viewDataBinding);
            }
        }
    };
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() { // from class: androidx.databinding.ViewDataBinding.6
        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final String[][] layouts;

        public void setIncludes(int i6, String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i6] = strArr;
            this.indexes[i6] = iArr;
            this.layoutIds[i6] = iArr2;
        }

        public IncludedLayouts(int i6) {
            this.layouts = new String[i6][];
            this.indexes = new int[i6][];
            this.layoutIds = new int[i6][];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {

        @Nullable
        WeakReference<LifecycleOwner> mLifecycleOwnerRef = null;
        final WeakListener<LiveData<?>> mListener;

        @Nullable
        private LifecycleOwner getLifecycleOwner() {
            WeakReference<LifecycleOwner> weakReference = this.mLifecycleOwnerRef;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(LiveData<?> liveData) {
            LifecycleOwner lifecycleOwner = getLifecycleOwner();
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<LiveData<?>> getListener() {
            return this.mListener;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                WeakListener<LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }

        public LiveDataListener(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i6, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
            LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
            LiveData<?> target = this.mListener.getTarget();
            if (target != null) {
                if (lifecycleOwner2 != null) {
                    target.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    target.observe(lifecycleOwner, this);
                }
            }
            if (lifecycleOwner != null) {
                this.mLifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class OnStartListener implements LifecycleObserver {
        final WeakReference<ViewDataBinding> mBinding;

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        final int mPropertyId;

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i6) {
            if (i6 == this.mPropertyId || i6 == 0) {
                onChange();
            }
        }

        public PropertyChangedInverseListener(int i6) {
            this.mPropertyId = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        final WeakListener<ObservableList> mListener;

        @Override // androidx.databinding.ObservableReference
        public void addListener(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<ObservableList> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(ObservableList observableList) {
            ObservableList target;
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }

        public WeakListListener(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i6, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(ObservableList observableList, int i6, int i7) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(ObservableList observableList, int i6, int i7) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(ObservableList observableList, int i6, int i7, int i8) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(ObservableList observableList, int i6, int i7) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        final WeakListener<ObservableMap> mListener;

        @Override // androidx.databinding.ObservableReference
        public void addListener(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<ObservableMap> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public void onMapChanged(ObservableMap observableMap, Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder == null || observableMap != this.mListener.getTarget()) {
                return;
            }
            binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }

        public WeakMapListener(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i6, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        final WeakListener<Observable> mListener;

        @Override // androidx.databinding.ObservableReference
        public void addListener(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<Observable> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i6) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i6);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }

        public WeakPropertyListener(ViewDataBinding viewDataBinding, int i6, ReferenceQueue<ViewDataBinding> referenceQueue) {
            this.mListener = new WeakListener<>(viewDataBinding, i6, this, referenceQueue);
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    protected ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i6) {
        this.mRebindRunnable = new Runnable() { // from class: androidx.databinding.ViewDataBinding.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.executePendingBindings();
                } else {
                    ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                }
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i6];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new Choreographer.FrameCallback() { // from class: androidx.databinding.ViewDataBinding.8
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j6) {
                    ViewDataBinding.this.mRebindRunnable.run();
                }
            };
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    protected static <T> T getFromArray(T[] tArr, int i6) {
        if (tArr == null || i6 < 0 || i6 >= tArr.length) {
            return null;
        }
        return tArr[i6];
    }

    protected static <T> T getFromList(List<T> list, int i6) {
        if (list == null || i6 < 0 || i6 >= list.size()) {
            return null;
        }
        return list.get(i6);
    }

    protected static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i6, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i6];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    protected static boolean parse(String str, boolean z5) {
        return str == null ? z5 : Boolean.parseBoolean(str);
    }

    protected static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static <T> void setTo(T[] tArr, int i6, T t5) {
        if (tArr == null || i6 < 0 || i6 >= tArr.length) {
            return;
        }
        tArr[i6] = t5;
    }

    protected abstract void executeBindings();

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    protected abstract boolean onFieldChange(int i6, Object obj, int i7);

    protected void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i6, @Nullable Object obj);

    protected boolean updateLiveDataRegistration(int i6, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i6, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean updateRegistration(int i6, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i6);
        }
        WeakListener weakListener = this.mLocalFieldObservers[i6];
        if (weakListener == null) {
            registerTo(i6, obj, createWeakListener);
            return true;
        }
        if (weakListener.getTarget() == obj) {
            return false;
        }
        unregisterFrom(i6);
        registerTo(i6, obj, createWeakListener);
        return true;
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
            return;
        }
        if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    private static int findIncludeIndex(String str, int i6, IncludedLayouts includedLayouts, int i7) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.layouts[i7];
        int length = strArr.length;
        while (i6 < length) {
            if (TextUtils.equals(subSequence, strArr[i6])) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    protected static int getColorFromResource(View view, int i6) {
        int color;
        if (Build.VERSION.SDK_INT < 23) {
            return view.getResources().getColor(i6);
        }
        color = view.getContext().getColor(i6);
        return color;
    }

    protected static ColorStateList getColorStateListFromResource(View view, int i6) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT < 23) {
            return view.getResources().getColorStateList(i6);
        }
        colorStateList = view.getContext().getColorStateList(i6);
        return colorStateList;
    }

    protected static <K, T> T getFrom(Map<K, T> map, K k6) {
        if (map == null) {
            return null;
        }
        return map.get(k6);
    }

    protected static byte parse(String str, byte b6) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof WeakListener) {
                ((WeakListener) poll).unregister();
            }
        }
    }

    protected static long safeUnbox(Long l6) {
        if (l6 == null) {
            return 0L;
        }
        return l6.longValue();
    }

    protected static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    public void addOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    protected void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    protected Object getObservedField(int i6) {
        WeakListener weakListener = this.mLocalFieldObservers[i6];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.mRoot;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void handleFieldChange(int i6, Object obj, int i7) {
        if (this.mInLiveDataRegisterObserver || this.mInStateFlowRegisterObserver || !onFieldChange(i6, obj, i7)) {
            return;
        }
        requestRebind();
    }

    protected void registerTo(int i6, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return;
        }
        WeakListener weakListener = this.mLocalFieldObservers[i6];
        if (weakListener == null) {
            weakListener = createWeakListener.create(this, i6, sReferenceQueue);
            this.mLocalFieldObservers[i6] = weakListener;
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
        weakListener.setTarget(obj);
    }

    public void removeOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    protected void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                try {
                    if (this.mPendingRebind) {
                        return;
                    }
                    this.mPendingRebind = true;
                    if (USE_CHOREOGRAPHER) {
                        this.mChoreographer.postFrameCallback(this.mFrameCallback);
                    } else {
                        this.mUIThreadHandler.post(this.mRebindRunnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    protected void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    @MainThread
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            return;
        }
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new OnStartListener();
            }
            lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
        }
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
    }

    protected void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    public void unbind() {
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    protected boolean unregisterFrom(int i6) {
        WeakListener weakListener = this.mLocalFieldObservers[i6];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    protected static ViewDataBinding bind(Object obj, View view, int i6) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i6);
    }

    protected static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findLastMatching(ViewGroup viewGroup, int i6) {
        String str;
        String str2 = (String) viewGroup.getChildAt(i6).getTag();
        String substring = str2.substring(0, str2.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i7 = i6 + 1; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if (childAt.getTag() instanceof String) {
                str = (String) childAt.getTag();
            } else {
                str = null;
            }
            if (str != null && str.startsWith(substring)) {
                if (str.length() == str2.length() && str.charAt(str.length() - 1) == '0') {
                    break;
                }
                if (isNumeric(str, length)) {
                    i6 = i7;
                }
            }
        }
        return i6;
    }

    protected static Drawable getDrawableFromResource(View view, int i6) {
        return view.getContext().getDrawable(i6);
    }

    protected static boolean getFromArray(boolean[] zArr, int i6) {
        if (zArr == null || i6 < 0 || i6 >= zArr.length) {
            return false;
        }
        return zArr[i6];
    }

    protected static <T> T getFromList(SparseArray<T> sparseArray, int i6) {
        if (sparseArray == null || i6 < 0) {
            return null;
        }
        return sparseArray.get(i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static <T extends ViewDataBinding> T inflateInternal(@NonNull LayoutInflater layoutInflater, int i6, @Nullable ViewGroup viewGroup, boolean z5, @Nullable Object obj) {
        return (T) DataBindingUtil.inflate(layoutInflater, i6, viewGroup, z5, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i6) {
        int length = str.length();
        if (length == i6) {
            return false;
        }
        while (i6 < length) {
            if (!Character.isDigit(str.charAt(i6))) {
                return false;
            }
            i6++;
        }
        return true;
    }

    protected static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArr, int i6, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i6];
        for (View view : viewArr) {
            mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    protected static short parse(String str, short s5) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s5;
        }
    }

    private static int parseTagInt(String str, int i6) {
        int i7 = 0;
        while (i6 < str.length()) {
            i7 = (i7 * 10) + (str.charAt(i6) - '0');
            i6++;
        }
        return i7;
    }

    protected static short safeUnbox(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    protected static void setTo(boolean[] zArr, int i6, boolean z5) {
        if (zArr == null || i6 < 0 || i6 >= zArr.length) {
            return;
        }
        zArr[i6] = z5;
    }

    void forceExecuteBindings() {
        executeBindings();
    }

    @TargetApi(16)
    protected static <T> T getFromList(LongSparseArray<T> longSparseArray, int i6) {
        if (longSparseArray == null || i6 < 0) {
            return null;
        }
        return longSparseArray.get(i6);
    }

    protected static int parse(String str, int i6) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    protected static byte safeUnbox(Byte b6) {
        if (b6 == null) {
            return (byte) 0;
        }
        return b6.byteValue();
    }

    protected static byte getFromArray(byte[] bArr, int i6) {
        if (bArr == null || i6 < 0 || i6 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i6];
    }

    protected static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i6) {
        if (longSparseArray == null || i6 < 0) {
            return null;
        }
        return longSparseArray.get(i6);
    }

    protected static long parse(String str, long j6) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j6;
        }
    }

    protected static char safeUnbox(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    protected static void setTo(byte[] bArr, int i6, byte b6) {
        if (bArr == null || i6 < 0 || i6 >= bArr.length) {
            return;
        }
        bArr[i6] = b6;
    }

    protected static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i6) {
        if (sparseBooleanArray == null || i6 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapBindings(androidx.databinding.DataBindingComponent r18, android.view.View r19, java.lang.Object[] r20, androidx.databinding.ViewDataBinding.IncludedLayouts r21, android.util.SparseIntArray r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    protected static float parse(String str, float f6) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f6;
        }
    }

    protected static double safeUnbox(Double d6) {
        if (d6 == null) {
            return 0.0d;
        }
        return d6.doubleValue();
    }

    protected static short getFromArray(short[] sArr, int i6) {
        if (sArr == null || i6 < 0 || i6 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i6];
    }

    protected static int getFromList(SparseIntArray sparseIntArray, int i6) {
        if (sparseIntArray == null || i6 < 0) {
            return 0;
        }
        return sparseIntArray.get(i6);
    }

    protected static double parse(String str, double d6) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d6;
        }
    }

    protected static float safeUnbox(Float f6) {
        if (f6 == null) {
            return 0.0f;
        }
        return f6.floatValue();
    }

    protected static void setTo(short[] sArr, int i6, short s5) {
        if (sArr == null || i6 < 0 || i6 >= sArr.length) {
            return;
        }
        sArr[i6] = s5;
    }

    protected boolean updateRegistration(int i6, Observable observable) {
        return updateRegistration(i6, observable, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    protected static long getFromList(SparseLongArray sparseLongArray, int i6) {
        if (sparseLongArray == null || i6 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i6);
    }

    protected static char parse(String str, char c6) {
        return (str == null || str.isEmpty()) ? c6 : str.charAt(0);
    }

    protected static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected boolean updateRegistration(int i6, ObservableList observableList) {
        return updateRegistration(i6, observableList, CREATE_LIST_LISTENER);
    }

    protected static char getFromArray(char[] cArr, int i6) {
        if (cArr == null || i6 < 0 || i6 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i6];
    }

    protected static void setTo(char[] cArr, int i6, char c6) {
        if (cArr == null || i6 < 0 || i6 >= cArr.length) {
            return;
        }
        cArr[i6] = c6;
    }

    protected boolean updateRegistration(int i6, ObservableMap observableMap) {
        return updateRegistration(i6, observableMap, CREATE_MAP_LISTENER);
    }

    protected static int getFromArray(int[] iArr, int i6) {
        if (iArr == null || i6 < 0 || i6 >= iArr.length) {
            return 0;
        }
        return iArr[i6];
    }

    protected static void setTo(int[] iArr, int i6, int i7) {
        if (iArr == null || i6 < 0 || i6 >= iArr.length) {
            return;
        }
        iArr[i6] = i7;
    }

    protected static long getFromArray(long[] jArr, int i6) {
        if (jArr == null || i6 < 0 || i6 >= jArr.length) {
            return 0L;
        }
        return jArr[i6];
    }

    protected static void setTo(long[] jArr, int i6, long j6) {
        if (jArr == null || i6 < 0 || i6 >= jArr.length) {
            return;
        }
        jArr[i6] = j6;
    }

    protected ViewDataBinding(Object obj, View view, int i6) {
        this(checkAndCastToBindingComponent(obj), view, i6);
    }

    protected static float getFromArray(float[] fArr, int i6) {
        if (fArr == null || i6 < 0 || i6 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i6];
    }

    protected static void setTo(float[] fArr, int i6, float f6) {
        if (fArr == null || i6 < 0 || i6 >= fArr.length) {
            return;
        }
        fArr[i6] = f6;
    }

    protected static double getFromArray(double[] dArr, int i6) {
        if (dArr == null || i6 < 0 || i6 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i6];
    }

    protected static void setTo(double[] dArr, int i6, double d6) {
        if (dArr == null || i6 < 0 || i6 >= dArr.length) {
            return;
        }
        dArr[i6] = d6;
    }

    protected static <T> void setTo(List<T> list, int i6, T t5) {
        if (list == null || i6 < 0 || i6 >= list.size()) {
            return;
        }
        list.set(i6, t5);
    }

    protected static <T> void setTo(SparseArray<T> sparseArray, int i6, T t5) {
        if (sparseArray == null || i6 < 0 || i6 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i6, t5);
    }

    @TargetApi(16)
    protected static <T> void setTo(LongSparseArray<T> longSparseArray, int i6, T t5) {
        if (longSparseArray == null || i6 < 0 || i6 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i6, t5);
    }

    protected static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i6, T t5) {
        if (longSparseArray == null || i6 < 0 || i6 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i6, t5);
    }

    protected static void setTo(SparseBooleanArray sparseBooleanArray, int i6, boolean z5) {
        if (sparseBooleanArray == null || i6 < 0 || i6 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i6, z5);
    }

    protected static void setTo(SparseIntArray sparseIntArray, int i6, int i7) {
        if (sparseIntArray == null || i6 < 0 || i6 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i6, i7);
    }

    @TargetApi(18)
    protected static void setTo(SparseLongArray sparseLongArray, int i6, long j6) {
        if (sparseLongArray == null || i6 < 0 || i6 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i6, j6);
    }

    protected static <K, T> void setTo(Map<K, T> map, K k6, T t5) {
        if (map == null) {
            return;
        }
        map.put(k6, t5);
    }
}
