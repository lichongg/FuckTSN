package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.EmptyRecyclerView;
import com.bxkj.student.R;
import com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2AiFitnessHomeBinding extends ViewDataBinding {

    @NonNull
    public final V2PubTitleBinding layoutTitle;

    @Bindable
    protected AIFitnessHomeActivity mActivity;

    @NonNull
    public final EmptyRecyclerView recyclerView;

    public static V2AiFitnessHomeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AiFitnessHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setActivity(@Nullable AIFitnessHomeActivity activity);

    @Deprecated
    public static V2AiFitnessHomeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AiFitnessHomeBinding) ViewDataBinding.bind(component, view, R.layout.v2_ai_fitness_home);
    }

    @NonNull
    @Deprecated
    public static V2AiFitnessHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AiFitnessHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_ai_fitness_home, root, attachToRoot, component);
    }

    @Nullable
    public AIFitnessHomeActivity getActivity() {
        return this.mActivity;
    }

    protected V2AiFitnessHomeBinding(Object _bindingComponent, View _root, int _localFieldCount, V2PubTitleBinding layoutTitle, EmptyRecyclerView recyclerView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.layoutTitle = layoutTitle;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static V2AiFitnessHomeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AiFitnessHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AiFitnessHomeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_ai_fitness_home, null, false, component);
    }
}
