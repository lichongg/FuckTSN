package com.bxkj.base.util.file;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ObservableTransformer {
        a() {
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.trello.rxlifecycle2.c a(@NonNull Context context) {
        if (context instanceof com.trello.rxlifecycle2.b) {
            return ((com.trello.rxlifecycle2.b) context).A();
        }
        throw new IllegalArgumentException("context not the LifecycleProvider type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> com.trello.rxlifecycle2.c b(@NonNull Fragment fragment) {
        if (fragment instanceof com.trello.rxlifecycle2.b) {
            return ((com.trello.rxlifecycle2.b) fragment).A();
        }
        throw new IllegalArgumentException("fragment not the LifecycleProvider type");
    }

    public static ObservableTransformer d() {
        return new a();
    }

    public static <T> com.trello.rxlifecycle2.c c(@NonNull com.trello.rxlifecycle2.b bVar) {
        return bVar.A();
    }
}
