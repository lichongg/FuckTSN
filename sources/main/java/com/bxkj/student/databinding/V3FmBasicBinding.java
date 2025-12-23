package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.bxkj.student.v2.common.view.TrackProgressView;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V3FmBasicBinding extends ViewDataBinding {

    @NonNull
    public final MaterialCardView card1;

    @NonNull
    public final MaterialCardView card2;

    @NonNull
    public final MaterialCardView card3;

    @NonNull
    public final MaterialCardView cardCjLine;

    @NonNull
    public final MaterialCardView cardRankLine;

    @NonNull
    public final MaterialCardView cardUser;

    @NonNull
    public final ConstraintLayout clRoot;

    @NonNull
    public final ShapeableImageView ivHead;

    @NonNull
    public final ImageView ivJb1;

    @NonNull
    public final ImageView ivJb2;

    @NonNull
    public final ImageView ivJb3;

    @NonNull
    public final LinearLayout llContent;

    @NonNull
    public final LinearLayout llUser;

    @Bindable
    protected V3RecordDetailActivity mMActivity;

    @Bindable
    protected Map<String, Object> mMap;

    @NonNull
    public final TrackProgressView tpDistance;

    @NonNull
    public final TrackProgressView tpStep;

    @NonNull
    public final TrackProgressView tpTime;

    @NonNull
    public final TextView tv1;

    @NonNull
    public final TextView tvAccount;

    @NonNull
    public final TextView tvCj;

    @NonNull
    public final TextView tvCjHint;

    @NonNull
    public final TextView tvCurrentDistance;

    @NonNull
    public final TextView tvCurrentStep;

    @NonNull
    public final TextView tvCurrentTime;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvRank;

    @NonNull
    public final TextView tvRankHint;

    @NonNull
    public final TextView tvRankUnit;

    @NonNull
    public final TextView tvResult;

    @NonNull
    public final TextView tvResultHint;

    protected V3FmBasicBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView card1, MaterialCardView card2, MaterialCardView card3, MaterialCardView cardCjLine, MaterialCardView cardRankLine, MaterialCardView cardUser, ConstraintLayout clRoot, ShapeableImageView ivHead, ImageView ivJb1, ImageView ivJb2, ImageView ivJb3, LinearLayout llContent, LinearLayout llUser, TrackProgressView tpDistance, TrackProgressView tpStep, TrackProgressView tpTime, TextView tv1, TextView tvAccount, TextView tvCj, TextView tvCjHint, TextView tvCurrentDistance, TextView tvCurrentStep, TextView tvCurrentTime, TextView tvName, TextView tvRank, TextView tvRankHint, TextView tvRankUnit, TextView tvResult, TextView tvResultHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.cardCjLine = cardCjLine;
        this.cardRankLine = cardRankLine;
        this.cardUser = cardUser;
        this.clRoot = clRoot;
        this.ivHead = ivHead;
        this.ivJb1 = ivJb1;
        this.ivJb2 = ivJb2;
        this.ivJb3 = ivJb3;
        this.llContent = llContent;
        this.llUser = llUser;
        this.tpDistance = tpDistance;
        this.tpStep = tpStep;
        this.tpTime = tpTime;
        this.tv1 = tv1;
        this.tvAccount = tvAccount;
        this.tvCj = tvCj;
        this.tvCjHint = tvCjHint;
        this.tvCurrentDistance = tvCurrentDistance;
        this.tvCurrentStep = tvCurrentStep;
        this.tvCurrentTime = tvCurrentTime;
        this.tvName = tvName;
        this.tvRank = tvRank;
        this.tvRankHint = tvRankHint;
        this.tvRankUnit = tvRankUnit;
        this.tvResult = tvResult;
        this.tvResultHint = tvResultHint;
    }

    public static V3FmBasicBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setMActivity(@Nullable V3RecordDetailActivity mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3FmBasicBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.bind(component, view, R.layout.v3_fm_basic);
    }

    @NonNull
    @Deprecated
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_basic, root, attachToRoot, component);
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
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v3_fm_basic, null, false, component);
    }
}
