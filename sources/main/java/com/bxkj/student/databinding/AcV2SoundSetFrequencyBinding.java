package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.set.SoundFrequencyActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2SoundSetFrequencyBinding extends ViewDataBinding {

    @NonNull
    public final Button btOk;

    @Bindable
    protected SoundFrequencyActivity mMActivity;

    @NonNull
    public final RadioGroup rg;

    @NonNull
    public final V3PubTitleBinding titleLayout;

    public static AcV2SoundSetFrequencyBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable SoundFrequencyActivity mActivity);

    @Deprecated
    public static AcV2SoundSetFrequencyBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_sound_set_frequency);
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sound_set_frequency, root, attachToRoot, component);
    }

    @Nullable
    public SoundFrequencyActivity getMActivity() {
        return this.mMActivity;
    }

    protected AcV2SoundSetFrequencyBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btOk, RadioGroup rg, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btOk = btOk;
        this.rg = rg;
        this.titleLayout = titleLayout;
    }

    @NonNull
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sound_set_frequency, null, false, component);
    }
}
