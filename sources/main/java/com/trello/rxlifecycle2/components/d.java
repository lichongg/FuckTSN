package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.android.FragmentEvent;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class d extends PreferenceFragment implements com.trello.rxlifecycle2.b<FragmentEvent> {

    /* renamed from: a, reason: collision with root package name */
    private final BehaviorSubject<FragmentEvent> f40725a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> com.trello.rxlifecycle2.c<T> A() {
        return com.trello.rxlifecycle2.android.b.b(this.f40725a);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final <T> com.trello.rxlifecycle2.c<T> I(@NonNull FragmentEvent fragmentEvent) {
        return com.trello.rxlifecycle2.d.c(this.f40725a, fragmentEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> o() {
        return this.f40725a.hide();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onDestroy() {
        this.f40725a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onDestroyView() {
        this.f40725a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onDetach() {
        this.f40725a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onPause() {
        this.f40725a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onStop() {
        this.f40725a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f40725a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f40725a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f40725a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onStart() {
        super.onStart();
        this.f40725a.onNext(FragmentEvent.START);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f40725a.onNext(FragmentEvent.CREATE_VIEW);
    }
}
