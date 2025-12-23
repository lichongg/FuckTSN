package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3FmDataBinding extends ViewDataBinding {

    @NonNull
    public final MaterialCardView card1;

    @NonNull
    public final MaterialCardView cardTotalTagrt;

    @NonNull
    public final MaterialCardView cardUser;

    @NonNull
    public final ConstraintLayout clRoot;

    @NonNull
    public final ImageView ivDbcs;

    @NonNull
    public final ImageView ivDblc;

    @NonNull
    public final ShapeableImageView ivHead;

    @NonNull
    public final ImageView ivLjsc;

    @NonNull
    public final ImageView ivPbts;

    @NonNull
    public final ImageView ivSycl;

    @NonNull
    public final ImageView ivSylc;

    @NonNull
    public final ImageView ivYxlc;

    @NonNull
    public final ImageView ivYxxs;

    @NonNull
    public final LinearLayout llUser;

    @Bindable
    protected V3RecordDetailActivity mMActivity;

    @Bindable
    protected Map<String, Object> mMap;

    @NonNull
    public final ProgressBar pbCount;

    @NonNull
    public final ProgressBar pbDistance;

    @NonNull
    public final TextView tv1;

    @NonNull
    public final TextView tv2;

    @NonNull
    public final TextView tvAccount;

    @NonNull
    public final TextView tvDbcs;

    @NonNull
    public final TextView tvDbcsHint;

    @NonNull
    public final TextView tvDbcsUnit;

    @NonNull
    public final TextView tvDblc;

    @NonNull
    public final TextView tvDblcHint;

    @NonNull
    public final TextView tvDblcUnit;

    @NonNull
    public final TextView tvLjsc;

    @NonNull
    public final TextView tvLjscUnit;

    @NonNull
    public final TextView tvLsscHint;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvPbts;

    @NonNull
    public final TextView tvPbtsHint;

    @NonNull
    public final TextView tvPbtsUnit;

    @NonNull
    public final TextView tvSycs;

    @NonNull
    public final TextView tvSycsHint;

    @NonNull
    public final TextView tvSycsUnit;

    @NonNull
    public final TextView tvSylc;

    @NonNull
    public final TextView tvSylcHint;

    @NonNull
    public final TextView tvSylcUnit;

    @NonNull
    public final TextView tvYxcs;

    @NonNull
    public final TextView tvYxcsHint;

    @NonNull
    public final TextView tvYxcsUnit;

    @NonNull
    public final TextView tvYxlc;

    @NonNull
    public final TextView tvYxlcHint;

    @NonNull
    public final TextView tvYxlcUnit;

    @NonNull
    public final TextView tvZdbsj;

    protected V3FmDataBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView card1, MaterialCardView cardTotalTagrt, MaterialCardView cardUser, ConstraintLayout clRoot, ImageView ivDbcs, ImageView ivDblc, ShapeableImageView ivHead, ImageView ivLjsc, ImageView ivPbts, ImageView ivSycl, ImageView ivSylc, ImageView ivYxlc, ImageView ivYxxs, LinearLayout llUser, ProgressBar pbCount, ProgressBar pbDistance, TextView tv1, TextView tv2, TextView tvAccount, TextView tvDbcs, TextView tvDbcsHint, TextView tvDbcsUnit, TextView tvDblc, TextView tvDblcHint, TextView tvDblcUnit, TextView tvLjsc, TextView tvLjscUnit, TextView tvLsscHint, TextView tvName, TextView tvPbts, TextView tvPbtsHint, TextView tvPbtsUnit, TextView tvSycs, TextView tvSycsHint, TextView tvSycsUnit, TextView tvSylc, TextView tvSylcHint, TextView tvSylcUnit, TextView tvYxcs, TextView tvYxcsHint, TextView tvYxcsUnit, TextView tvYxlc, TextView tvYxlcHint, TextView tvYxlcUnit, TextView tvZdbsj) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card1 = card1;
        this.cardTotalTagrt = cardTotalTagrt;
        this.cardUser = cardUser;
        this.clRoot = clRoot;
        this.ivDbcs = ivDbcs;
        this.ivDblc = ivDblc;
        this.ivHead = ivHead;
        this.ivLjsc = ivLjsc;
        this.ivPbts = ivPbts;
        this.ivSycl = ivSycl;
        this.ivSylc = ivSylc;
        this.ivYxlc = ivYxlc;
        this.ivYxxs = ivYxxs;
        this.llUser = llUser;
        this.pbCount = pbCount;
        this.pbDistance = pbDistance;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tvAccount = tvAccount;
        this.tvDbcs = tvDbcs;
        this.tvDbcsHint = tvDbcsHint;
        this.tvDbcsUnit = tvDbcsUnit;
        this.tvDblc = tvDblc;
        this.tvDblcHint = tvDblcHint;
        this.tvDblcUnit = tvDblcUnit;
        this.tvLjsc = tvLjsc;
        this.tvLjscUnit = tvLjscUnit;
        this.tvLsscHint = tvLsscHint;
        this.tvName = tvName;
        this.tvPbts = tvPbts;
        this.tvPbtsHint = tvPbtsHint;
        this.tvPbtsUnit = tvPbtsUnit;
        this.tvSycs = tvSycs;
        this.tvSycsHint = tvSycsHint;
        this.tvSycsUnit = tvSycsUnit;
        this.tvSylc = tvSylc;
        this.tvSylcHint = tvSylcHint;
        this.tvSylcUnit = tvSylcUnit;
        this.tvYxcs = tvYxcs;
        this.tvYxcsHint = tvYxcsHint;
        this.tvYxcsUnit = tvYxcsUnit;
        this.tvYxlc = tvYxlc;
        this.tvYxlcHint = tvYxlcHint;
        this.tvYxlcUnit = tvYxlcUnit;
        this.tvZdbsj = tvZdbsj;
    }

    public static V3FmDataBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable V3RecordDetailActivity mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3FmDataBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.bind(component, view, R.layout.v3_fm_data);
    }

    @NonNull
    @Deprecated
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_data, root, attachToRoot, component);
    }

    @Nullable
    public V3RecordDetailActivity getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    @NonNull
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_data, null, false, component);
    }
}
