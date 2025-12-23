package com.trello.rxlifecycle2.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.b;
import com.trello.rxlifecycle2.c;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class RxFragment extends Fragment implements b<FragmentEvent> {

    /* renamed from: c, reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f40728c = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> c<T> A() {
        return com.trello.rxlifecycle2.android.b.b(this.f40728c);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> I(@NonNull FragmentEvent fragmentEvent) {
        return d.c(this.f40728c, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> o() {
        return this.f40728c.hide();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f40728c.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f40728c.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.f40728c.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f40728c.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f40728c.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f40728c.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f40728c.onNext(FragmentEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f40728c.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f40728c.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f40728c.onNext(FragmentEvent.CREATE_VIEW);
    }
}
