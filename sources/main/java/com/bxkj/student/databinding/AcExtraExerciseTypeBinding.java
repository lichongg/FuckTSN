package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.R;
import com.bxkj.student.run.extraclass.SignTypeActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcExtraExerciseTypeBinding extends ViewDataBinding {

    @NonNull
    public final Button btIn;

    @NonNull
    public final Button btOut;

    @Bindable
    protected SignTypeActivity mSignTypeActivity;

    @NonNull
    public final NewPubTitleBinding toolbar;

    public static AcExtraExerciseTypeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setSignTypeActivity(@Nullable SignTypeActivity signTypeActivity);

    @Deprecated
    public static AcExtraExerciseTypeBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.bind(component, view, R.layout.ac_extra_exercise_type);
    }

    @NonNull
    @Deprecated
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_extra_exercise_type, root, attachToRoot, component);
    }

    @Nullable
    public SignTypeActivity getSignTypeActivity() {
        return this.mSignTypeActivity;
    }

    protected AcExtraExerciseTypeBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btIn, Button btOut, NewPubTitleBinding toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btIn = btIn;
        this.btOut = btOut;
        this.toolbar = toolbar;
    }

    @NonNull
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_extra_exercise_type, null, false, component);
    }
}
