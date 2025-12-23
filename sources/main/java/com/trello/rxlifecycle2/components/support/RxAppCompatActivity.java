package com.trello.rxlifecycle2.components.support;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.b;
import com.trello.rxlifecycle2.c;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class RxAppCompatActivity extends AppCompatActivity implements b<ActivityEvent> {
    private final BehaviorSubject<ActivityEvent> M = BehaviorSubject.create();

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final <T> c<T> A() {
        return com.trello.rxlifecycle2.android.b.a(this.M);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> I(@NonNull ActivityEvent activityEvent) {
        return d.c(this.M, activityEvent);
    }

    @Override // com.trello.rxlifecycle2.b
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> o() {
        return this.M.hide();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    protected void onDestroy() {
        this.M.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    protected void onPause() {
        this.M.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    protected void onStop() {
        this.M.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.M.onNext(ActivityEvent.CREATE);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    protected void onResume() {
        super.onResume();
        this.M.onNext(ActivityEvent.RESUME);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    protected void onStart() {
        super.onStart();
        this.M.onNext(ActivityEvent.START);
    }
}
