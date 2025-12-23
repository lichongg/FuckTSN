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
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class FmV3RecordListTotalBinding extends ViewDataBinding {

    @NonNull
    public final AAChartView AAChartView;

    @NonNull
    public final MaterialCardView cardChat;

    @NonNull
    public final MaterialCardView cardMorningRun;

    @NonNull
    public final MaterialCardView cardPace;

    @NonNull
    public final MaterialCardView cardSunRun;

    @NonNull
    public final MaterialCardView cardUser;

    @NonNull
    public final ConstraintLayout clMorningRun;

    @NonNull
    public final ConstraintLayout clSunrun;

    @NonNull
    public final ImageView ivDbcs;

    @NonNull
    public final ImageView ivDbcsMorning;

    @NonNull
    public final ImageView ivDblc;

    @NonNull
    public final ImageView ivDblcMorning;

    @NonNull
    public final ShapeableImageView ivHead;

    @NonNull
    public final ImageView ivSycl;

    @NonNull
    public final ImageView ivSyclMorning;

    @NonNull
    public final ImageView ivSylc;

    @NonNull
    public final ImageView ivSylcMorning;

    @NonNull
    public final ImageView ivYxlc;

    @NonNull
    public final ImageView ivYxlcMorning;

    @NonNull
    public final ImageView ivYxxs;

    @NonNull
    public final ImageView ivYxxsMorning;

    @NonNull
    public final View line;

    @NonNull
    public final View line0;

    @NonNull
    public final View line00;

    @NonNull
    public final View line2;

    @NonNull
    public final LinearLayout ll0;

    @NonNull
    public final LinearLayout ll00;

    @NonNull
    public final LinearLayout ll1;

    @NonNull
    public final LinearLayout ll2;

    @NonNull
    public final LinearLayout ll3;

    @NonNull
    public final LinearLayout llUser;

    @NonNull
    public final ProgressBar pbCount;

    @NonNull
    public final ProgressBar pbCountMorning;

    @NonNull
    public final ProgressBar pbDistance;

    @NonNull
    public final ProgressBar pbDistanceMorning;

    @NonNull
    public final TabLayout tbType;

    @NonNull
    public final TextView tvAccount;

    @NonNull
    public final TextView tvAvgCount;

    @NonNull
    public final TextView tvAvgCountHint;

    @NonNull
    public final TextView tvAvgCountUnit;

    @NonNull
    public final TextView tvAvgDistance;

    @NonNull
    public final TextView tvAvgDistanceHint;

    @NonNull
    public final TextView tvAvgDistanceUnit;

    @NonNull
    public final TextView tvAvgTime;

    @NonNull
    public final TextView tvAvgTimeHint;

    @NonNull
    public final TextView tvAvgTimeUnit;

    @NonNull
    public final TextView tvCount;

    @NonNull
    public final TextView tvCountHint;

    @NonNull
    public final TextView tvCountUnit;

    @NonNull
    public final TextView tvDay;

    @NonNull
    public final TextView tvDayHint;

    @NonNull
    public final TextView tvDayUnit;

    @NonNull
    public final TextView tvDbcs;

    @NonNull
    public final TextView tvDbcsHint;

    @NonNull
    public final TextView tvDbcsHintMorning;

    @NonNull
    public final TextView tvDbcsMorning;

    @NonNull
    public final TextView tvDbcsUnit;

    @NonNull
    public final TextView tvDbcsUnitMorning;

    @NonNull
    public final TextView tvDblc;

    @NonNull
    public final TextView tvDblcHint;

    @NonNull
    public final TextView tvDblcHintMorning;

    @NonNull
    public final TextView tvDblcMorning;

    @NonNull
    public final TextView tvDblcUnit;

    @NonNull
    public final TextView tvDblcUnitMorning;

    @NonNull
    public final TextView tvDistance;

    @NonNull
    public final TextView tvDistanceHint;

    @NonNull
    public final TextView tvDistanceUnit;

    @NonNull
    public final TextView tvHeart;

    @NonNull
    public final TextView tvHeartHint;

    @NonNull
    public final TextView tvHeartUnit;

    @NonNull
    public final TextView tvMorningRun;

    @NonNull
    public final TextView tvName;

    @NonNull
    public final TextView tvPace;

    @NonNull
    public final TextView tvPaceHint;

    @NonNull
    public final TextView tvPaceUnit;

    @NonNull
    public final TextView tvStep;

    @NonNull
    public final TextView tvStepDistance;

    @NonNull
    public final TextView tvStepDistanceHint;

    @NonNull
    public final TextView tvStepDistanceUnit;

    @NonNull
    public final TextView tvStepHint;

    @NonNull
    public final TextView tvStepUnit;

    @NonNull
    public final TextView tvSunRun;

    @NonNull
    public final TextView tvSycs;

    @NonNull
    public final TextView tvSycsHint;

    @NonNull
    public final TextView tvSycsHintMorning;

    @NonNull
    public final TextView tvSycsMorning;

    @NonNull
    public final TextView tvSycsUnit;

    @NonNull
    public final TextView tvSycsUnitMorning;

    @NonNull
    public final TextView tvSylc;

    @NonNull
    public final TextView tvSylcHint;

    @NonNull
    public final TextView tvSylcHintMorning;

    @NonNull
    public final TextView tvSylcMorning;

    @NonNull
    public final TextView tvSylcUnit;

    @NonNull
    public final TextView tvSylcUnitMorning;

    @NonNull
    public final TextView tvTime;

    @NonNull
    public final TextView tvTimeHint;

    @NonNull
    public final TextView tvTimeUnit;

    @NonNull
    public final TextView tvYxcs;

    @NonNull
    public final TextView tvYxcsHint;

    @NonNull
    public final TextView tvYxcsHintMorning;

    @NonNull
    public final TextView tvYxcsMorning;

    @NonNull
    public final TextView tvYxcsUnit;

    @NonNull
    public final TextView tvYxcsUnitMorning;

    @NonNull
    public final TextView tvYxlc;

    @NonNull
    public final TextView tvYxlcHint;

    @NonNull
    public final TextView tvYxlcHintMorning;

    @NonNull
    public final TextView tvYxlcMorning;

    @NonNull
    public final TextView tvYxlcUnit;

    @NonNull
    public final TextView tvYxlcUnitMorning;

    protected FmV3RecordListTotalBinding(Object _bindingComponent, View _root, int _localFieldCount, AAChartView AAChartView, MaterialCardView cardChat, MaterialCardView cardMorningRun, MaterialCardView cardPace, MaterialCardView cardSunRun, MaterialCardView cardUser, ConstraintLayout clMorningRun, ConstraintLayout clSunrun, ImageView ivDbcs, ImageView ivDbcsMorning, ImageView ivDblc, ImageView ivDblcMorning, ShapeableImageView ivHead, ImageView ivSycl, ImageView ivSyclMorning, ImageView ivSylc, ImageView ivSylcMorning, ImageView ivYxlc, ImageView ivYxlcMorning, ImageView ivYxxs, ImageView ivYxxsMorning, View line, View line0, View line00, View line2, LinearLayout ll0, LinearLayout ll00, LinearLayout ll1, LinearLayout ll2, LinearLayout ll3, LinearLayout llUser, ProgressBar pbCount, ProgressBar pbCountMorning, ProgressBar pbDistance, ProgressBar pbDistanceMorning, TabLayout tbType, TextView tvAccount, TextView tvAvgCount, TextView tvAvgCountHint, TextView tvAvgCountUnit, TextView tvAvgDistance, TextView tvAvgDistanceHint, TextView tvAvgDistanceUnit, TextView tvAvgTime, TextView tvAvgTimeHint, TextView tvAvgTimeUnit, TextView tvCount, TextView tvCountHint, TextView tvCountUnit, TextView tvDay, TextView tvDayHint, TextView tvDayUnit, TextView tvDbcs, TextView tvDbcsHint, TextView tvDbcsHintMorning, TextView tvDbcsMorning, TextView tvDbcsUnit, TextView tvDbcsUnitMorning, TextView tvDblc, TextView tvDblcHint, TextView tvDblcHintMorning, TextView tvDblcMorning, TextView tvDblcUnit, TextView tvDblcUnitMorning, TextView tvDistance, TextView tvDistanceHint, TextView tvDistanceUnit, TextView tvHeart, TextView tvHeartHint, TextView tvHeartUnit, TextView tvMorningRun, TextView tvName, TextView tvPace, TextView tvPaceHint, TextView tvPaceUnit, TextView tvStep, TextView tvStepDistance, TextView tvStepDistanceHint, TextView tvStepDistanceUnit, TextView tvStepHint, TextView tvStepUnit, TextView tvSunRun, TextView tvSycs, TextView tvSycsHint, TextView tvSycsHintMorning, TextView tvSycsMorning, TextView tvSycsUnit, TextView tvSycsUnitMorning, TextView tvSylc, TextView tvSylcHint, TextView tvSylcHintMorning, TextView tvSylcMorning, TextView tvSylcUnit, TextView tvSylcUnitMorning, TextView tvTime, TextView tvTimeHint, TextView tvTimeUnit, TextView tvYxcs, TextView tvYxcsHint, TextView tvYxcsHintMorning, TextView tvYxcsMorning, TextView tvYxcsUnit, TextView tvYxcsUnitMorning, TextView tvYxlc, TextView tvYxlcHint, TextView tvYxlcHintMorning, TextView tvYxlcMorning, TextView tvYxlcUnit, TextView tvYxlcUnitMorning) {
        super(_bindingComponent, _root, _localFieldCount);
        this.AAChartView = AAChartView;
        this.cardChat = cardChat;
        this.cardMorningRun = cardMorningRun;
        this.cardPace = cardPace;
        this.cardSunRun = cardSunRun;
        this.cardUser = cardUser;
        this.clMorningRun = clMorningRun;
        this.clSunrun = clSunrun;
        this.ivDbcs = ivDbcs;
        this.ivDbcsMorning = ivDbcsMorning;
        this.ivDblc = ivDblc;
        this.ivDblcMorning = ivDblcMorning;
        this.ivHead = ivHead;
        this.ivSycl = ivSycl;
        this.ivSyclMorning = ivSyclMorning;
        this.ivSylc = ivSylc;
        this.ivSylcMorning = ivSylcMorning;
        this.ivYxlc = ivYxlc;
        this.ivYxlcMorning = ivYxlcMorning;
        this.ivYxxs = ivYxxs;
        this.ivYxxsMorning = ivYxxsMorning;
        this.line = line;
        this.line0 = line0;
        this.line00 = line00;
        this.line2 = line2;
        this.ll0 = ll0;
        this.ll00 = ll00;
        this.ll1 = ll1;
        this.ll2 = ll2;
        this.ll3 = ll3;
        this.llUser = llUser;
        this.pbCount = pbCount;
        this.pbCountMorning = pbCountMorning;
        this.pbDistance = pbDistance;
        this.pbDistanceMorning = pbDistanceMorning;
        this.tbType = tbType;
        this.tvAccount = tvAccount;
        this.tvAvgCount = tvAvgCount;
        this.tvAvgCountHint = tvAvgCountHint;
        this.tvAvgCountUnit = tvAvgCountUnit;
        this.tvAvgDistance = tvAvgDistance;
        this.tvAvgDistanceHint = tvAvgDistanceHint;
        this.tvAvgDistanceUnit = tvAvgDistanceUnit;
        this.tvAvgTime = tvAvgTime;
        this.tvAvgTimeHint = tvAvgTimeHint;
        this.tvAvgTimeUnit = tvAvgTimeUnit;
        this.tvCount = tvCount;
        this.tvCountHint = tvCountHint;
        this.tvCountUnit = tvCountUnit;
        this.tvDay = tvDay;
        this.tvDayHint = tvDayHint;
        this.tvDayUnit = tvDayUnit;
        this.tvDbcs = tvDbcs;
        this.tvDbcsHint = tvDbcsHint;
        this.tvDbcsHintMorning = tvDbcsHintMorning;
        this.tvDbcsMorning = tvDbcsMorning;
        this.tvDbcsUnit = tvDbcsUnit;
        this.tvDbcsUnitMorning = tvDbcsUnitMorning;
        this.tvDblc = tvDblc;
        this.tvDblcHint = tvDblcHint;
        this.tvDblcHintMorning = tvDblcHintMorning;
        this.tvDblcMorning = tvDblcMorning;
        this.tvDblcUnit = tvDblcUnit;
        this.tvDblcUnitMorning = tvDblcUnitMorning;
        this.tvDistance = tvDistance;
        this.tvDistanceHint = tvDistanceHint;
        this.tvDistanceUnit = tvDistanceUnit;
        this.tvHeart = tvHeart;
        this.tvHeartHint = tvHeartHint;
        this.tvHeartUnit = tvHeartUnit;
        this.tvMorningRun = tvMorningRun;
        this.tvName = tvName;
        this.tvPace = tvPace;
        this.tvPaceHint = tvPaceHint;
        this.tvPaceUnit = tvPaceUnit;
        this.tvStep = tvStep;
        this.tvStepDistance = tvStepDistance;
        this.tvStepDistanceHint = tvStepDistanceHint;
        this.tvStepDistanceUnit = tvStepDistanceUnit;
        this.tvStepHint = tvStepHint;
        this.tvStepUnit = tvStepUnit;
        this.tvSunRun = tvSunRun;
        this.tvSycs = tvSycs;
        this.tvSycsHint = tvSycsHint;
        this.tvSycsHintMorning = tvSycsHintMorning;
        this.tvSycsMorning = tvSycsMorning;
        this.tvSycsUnit = tvSycsUnit;
        this.tvSycsUnitMorning = tvSycsUnitMorning;
        this.tvSylc = tvSylc;
        this.tvSylcHint = tvSylcHint;
        this.tvSylcHintMorning = tvSylcHintMorning;
        this.tvSylcMorning = tvSylcMorning;
        this.tvSylcUnit = tvSylcUnit;
        this.tvSylcUnitMorning = tvSylcUnitMorning;
        this.tvTime = tvTime;
        this.tvTimeHint = tvTimeHint;
        this.tvTimeUnit = tvTimeUnit;
        this.tvYxcs = tvYxcs;
        this.tvYxcsHint = tvYxcsHint;
        this.tvYxcsHintMorning = tvYxcsHintMorning;
        this.tvYxcsMorning = tvYxcsMorning;
        this.tvYxcsUnit = tvYxcsUnit;
        this.tvYxcsUnitMorning = tvYxcsUnitMorning;
        this.tvYxlc = tvYxlc;
        this.tvYxlcHint = tvYxlcHint;
        this.tvYxlcHintMorning = tvYxlcHintMorning;
        this.tvYxlcMorning = tvYxlcMorning;
        this.tvYxlcUnit = tvYxlcUnit;
        this.tvYxlcUnitMorning = tvYxlcUnitMorning;
    }

    public static FmV3RecordListTotalBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FmV3RecordListTotalBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.bind(component, view, R.layout.fm_v3_record_list_total);
    }

    @NonNull
    @Deprecated
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fm_v3_record_list_total, root, attachToRoot, component);
    }

    @NonNull
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV3RecordListTotalBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV3RecordListTotalBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fm_v3_record_list_total, null, false, component);
    }
}
