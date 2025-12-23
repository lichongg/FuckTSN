package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV2SportsSetBinding extends ViewDataBinding {

    @Bindable
    protected SportsSetActivity mMSportsSetActivity;

    @NonNull
    public final NewPubTitleBinding titleLayout;

    @NonNull
    public final TextView tvDescription;

    @NonNull
    public final TextView tvPermissionSet;

    @NonNull
    public final TextView tvQuestion;

    @NonNull
    public final TextView tvRank;

    @NonNull
    public final TextView tvRecord;

    @NonNull
    public final TextView tvSoundSet;

    @NonNull
    public final TextView tvStatistics;

    public static AcV2SportsSetBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMSportsSetActivity(@Nullable SportsSetActivity mSportsSetActivity);

    @Deprecated
    public static AcV2SportsSetBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.bind(component, view, R.layout.ac_v2_sports_set);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_set, root, attachToRoot, component);
    }

    @Nullable
    public SportsSetActivity getMSportsSetActivity() {
        return this.mMSportsSetActivity;
    }

    protected AcV2SportsSetBinding(Object _bindingComponent, View _root, int _localFieldCount, NewPubTitleBinding titleLayout, TextView tvDescription, TextView tvPermissionSet, TextView tvQuestion, TextView tvRank, TextView tvRecord, TextView tvSoundSet, TextView tvStatistics) {
        super(_bindingComponent, _root, _localFieldCount);
        this.titleLayout = titleLayout;
        this.tvDescription = tvDescription;
        this.tvPermissionSet = tvPermissionSet;
        this.tvQuestion = tvQuestion;
        this.tvRank = tvRank;
        this.tvRecord = tvRecord;
        this.tvSoundSet = tvSoundSet;
        this.tvStatistics = tvStatistics;
    }

    @NonNull
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v2_sports_set, null, false, component);
    }
}
