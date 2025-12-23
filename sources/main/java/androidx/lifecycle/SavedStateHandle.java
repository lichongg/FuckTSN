package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.o0;
import kotlinx.coroutines.flow.h0;
import kotlinx.coroutines.flow.j0;
import kotlinx.coroutines.flow.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SavedStateHandle {

    @NotNull
    private static final String KEYS = "keys";

    @NotNull
    private static final String VALUES = "values";

    @NotNull
    private final Map<String, t<Object>> flows;

    @NotNull
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    @NotNull
    private final Map<String, Object> regular;

    @NotNull
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    @NotNull
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(@Nullable Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.ACCEPTABLE_CLASSES) {
                g0.m(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new SavedStateHandle();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    g0.o(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                Object obj = parcelableArrayList.get(i6);
                g0.n(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i6));
            }
            return new SavedStateHandle(linkedHashMap);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        @Nullable
        private SavedStateHandle handle;

        @NotNull
        private String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String key, T t5) {
            super(t5);
            g0.p(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t5) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t5);
                t tVar = (t) savedStateHandle.flows.get(this.key);
                if (tVar != null) {
                    tVar.setValue(t5);
                }
            }
            super.setValue(t5);
        }

        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String key) {
            g0.p(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle(@NotNull Map<String, ? extends Object> initialState) {
        g0.p(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.k
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle savedStateProvider$lambda$0;
                savedStateProvider$lambda$0 = SavedStateHandle.savedStateProvider$lambda$0(SavedStateHandle.this);
                return savedStateProvider$lambda$0;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    @MainThread
    @NotNull
    public final <T> MutableLiveData<T> getLiveData(@NotNull String key) {
        g0.p(key, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(key, false, null);
        g0.n(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z5, T t5) {
        SavingStateLiveData<?> savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(str);
        SavingStateLiveData<?> savingStateLiveData3 = savingStateLiveData2 instanceof MutableLiveData ? savingStateLiveData2 : null;
        if (savingStateLiveData3 != null) {
            return savingStateLiveData3;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData<>(this, str, this.regular.get(str));
        } else if (z5) {
            this.regular.put(str, t5);
            savingStateLiveData = new SavingStateLiveData<>(this, str, t5);
        } else {
            savingStateLiveData = new SavingStateLiveData<>(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle this$0) {
        g0.p(this$0, "this$0");
        for (Map.Entry entry : i1.D0(this$0.savedStateProviders).entrySet()) {
            this$0.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        Set<String> keySet = this$0.regular.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.regular.get(str));
        }
        return BundleKt.bundleOf(o0.a(KEYS, arrayList), o0.a(VALUES, arrayList2));
    }

    @MainThread
    public final void clearSavedStateProvider(@NotNull String key) {
        g0.p(key, "key");
        this.savedStateProviders.remove(key);
    }

    @MainThread
    public final boolean contains(@NotNull String key) {
        g0.p(key, "key");
        return this.regular.containsKey(key);
    }

    @MainThread
    @Nullable
    public final <T> T get(@NotNull String key) {
        g0.p(key, "key");
        try {
            return (T) this.regular.get(key);
        } catch (ClassCastException unused) {
            remove(key);
            return null;
        }
    }

    @MainThread
    @NotNull
    public final <T> MutableLiveData<T> getLiveData(@NotNull String key, T t5) {
        g0.p(key, "key");
        return getLiveDataInternal(key, true, t5);
    }

    @MainThread
    @NotNull
    public final <T> h0<T> getStateFlow(@NotNull String key, T t5) {
        g0.p(key, "key");
        Map<String, t<Object>> map = this.flows;
        t<Object> tVar = map.get(key);
        if (tVar == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, t5);
            }
            tVar = j0.a(this.regular.get(key));
            this.flows.put(key, tVar);
            map.put(key, tVar);
        }
        h0<T> m6 = kotlinx.coroutines.flow.k.m(tVar);
        g0.n(m6, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return m6;
    }

    @MainThread
    @NotNull
    public final Set<String> keys() {
        return u1.C(u1.C(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    @Nullable
    public final <T> T remove(@NotNull String key) {
        g0.p(key, "key");
        T t5 = (T) this.regular.remove(key);
        SavingStateLiveData<?> remove = this.liveDatas.remove(key);
        if (remove != null) {
            remove.detach();
        }
        this.flows.remove(key);
        return t5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(@NotNull String key, @Nullable T t5) {
        g0.p(key, "key");
        if (!Companion.validateValue(t5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            g0.m(t5);
            sb.append(t5.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(key);
        SavingStateLiveData<?> savingStateLiveData2 = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
        if (savingStateLiveData2 != null) {
            savingStateLiveData2.setValue(t5);
        } else {
            this.regular.put(key, t5);
        }
        t<Object> tVar = this.flows.get(key);
        if (tVar == null) {
            return;
        }
        tVar.setValue(t5);
    }

    @MainThread
    public final void setSavedStateProvider(@NotNull String key, @NotNull SavedStateRegistry.SavedStateProvider provider) {
        g0.p(key, "key");
        g0.p(provider, "provider");
        this.savedStateProviders.put(key, provider);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.k
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle savedStateProvider$lambda$0;
                savedStateProvider$lambda$0 = SavedStateHandle.savedStateProvider$lambda$0(SavedStateHandle.this);
                return savedStateProvider$lambda$0;
            }
        };
    }
}
