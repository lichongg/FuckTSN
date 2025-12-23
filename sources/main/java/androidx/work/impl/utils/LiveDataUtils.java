package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    class AnonymousClass1<In> implements Observer<In> {
        Out mCurrentOutput = null;
        final /* synthetic */ Object val$lock;
        final /* synthetic */ Function val$mappingMethod;
        final /* synthetic */ MediatorLiveData val$outputLiveData;
        final /* synthetic */ TaskExecutor val$workTaskExecutor;

        AnonymousClass1(final TaskExecutor val$workTaskExecutor, final Object val$lock, final Function val$mappingMethod, final MediatorLiveData val$outputLiveData) {
            this.val$workTaskExecutor = val$workTaskExecutor;
            this.val$lock = val$lock;
            this.val$mappingMethod = val$mappingMethod;
            this.val$outputLiveData = val$outputLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable final In input) {
            this.val$workTaskExecutor.executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.val$lock) {
                        try {
                            ?? apply = AnonymousClass1.this.val$mappingMethod.apply(input);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Out out = anonymousClass1.mCurrentOutput;
                            if (out == 0 && apply != 0) {
                                anonymousClass1.mCurrentOutput = apply;
                                anonymousClass1.val$outputLiveData.postValue(apply);
                            } else if (out != 0 && !out.equals(apply)) {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                anonymousClass12.mCurrentOutput = apply;
                                anonymousClass12.val$outputLiveData.postValue(apply);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> inputLiveData, @NonNull final Function<In, Out> mappingMethod, @NonNull final TaskExecutor workTaskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(inputLiveData, new AnonymousClass1(workTaskExecutor, obj, mappingMethod, mediatorLiveData));
        return mediatorLiveData;
    }

    private LiveDataUtils() {
    }
}
