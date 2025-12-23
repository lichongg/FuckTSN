package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class RxActivity extends Activity implements com.trello.rxlifecycle2.b<ActivityEvent> {

    /* renamed from: a, reason: collision with root package name */
    private final BehaviorSubject<ActivityEvent> f40716a = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> com.trello.rxlifecycle2.c<T> A() {
        return com.trello.rxlifecycle2.android.b.a(this.f40716a);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final <T> com.trello.rxlifecycle2.c<T> I(@NonNull ActivityEvent activityEvent) {
        return com.trello.rxlifecycle2.d.c(this.f40716a, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> o() {
        return this.f40716a.hide();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onDestroy() {
        this.f40716a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onPause() {
        this.f40716a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStop() {
        this.f40716a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f40716a.onNext(ActivityEvent.CREATE);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onResume() {
        super.onResume();
        this.f40716a.onNext(ActivityEvent.RESUME);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onStart() {
        super.onStart();
        this.f40716a.onNext(ActivityEvent.START);
    }
}
