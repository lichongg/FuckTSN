package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity;
import com.bxkj.student.v2.ai.fitness.data.FitnessModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2ItemForAiFitnessListBinding extends ViewDataBinding {

    @NonNull
    public final TextView btMenu;

    @NonNull
    public final ImageView ivIcon;

    @Bindable
    protected AIFitnessHomeActivity mAiFitnessHomeActivity;

    @Bindable
    protected FitnessModel mFitnessModel;

    public static V2ItemForAiFitnessListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForAiFitnessListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setAiFitnessHomeActivity(@Nullable AIFitnessHomeActivity aiFitnessHomeActivity);

    public abstract void setFitnessModel(@Nullable FitnessModel fitnessModel);

    @Deprecated
    public static V2ItemForAiFitnessListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForAiFitnessListBinding) ViewDataBinding.bind(component, view, R.layout.v2_item_for_ai_fitness_list);
    }

    @NonNull
    @Deprecated
    public static V2ItemForAiFitnessListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForAiFitnessListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_ai_fitness_list, root, attachToRoot, component);
    }

    @Nullable
    public AIFitnessHomeActivity getAiFitnessHomeActivity() {
        return this.mAiFitnessHomeActivity;
    }

    @Nullable
    public FitnessModel getFitnessModel() {
        return this.mFitnessModel;
    }

    protected V2ItemForAiFitnessListBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btMenu, ImageView ivIcon) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btMenu = btMenu;
        this.ivIcon = ivIcon;
    }

    @NonNull
    public static V2ItemForAiFitnessListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForAiFitnessListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForAiFitnessListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_item_for_ai_fitness_list, null, false, component);
    }
}
