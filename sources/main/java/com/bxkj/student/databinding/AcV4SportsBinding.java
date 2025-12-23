package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.v2.common.view.StepArcView;
import com.bxkj.student.v2.ui.sports.v3.V4SportActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV4SportsBinding extends ViewDataBinding {

    @NonNull
    public final MaterialCardView bottomCard;

    @NonNull
    public final NestedScrollView bottomSheet;

    @NonNull
    public final ConstraintLayout clGps;

    @NonNull
    public final ConstraintLayout collapseView;

    @NonNull
    public final MaterialCardView cvToMap;

    @NonNull
    public final ConstraintLayout expandView;

    @NonNull
    public final AppCompatImageButton ibBack;

    @NonNull
    public final ConstraintLayout ibSet;

    @NonNull
    public final View ivCollapse;

    @NonNull
    public final ImageView ivExpand;

    @NonNull
    public final AppCompatImageView ivGps;

    @NonNull
    public final AppCompatImageView ivLock;

    @NonNull
    public final LongPressButton ivStop;

    @NonNull
    public final AppCompatImageView ivToMap;

    @NonNull
    public final LongPressButton ivUnlock;

    @Bindable
    protected V4SportActivity mBackEvent;

    @Bindable
    protected String mIsClock;

    @NonNull
    public final MapView mMapView;

    @Bindable
    protected String mNotice;

    @Bindable
    protected int mSportType;

    @Bindable
    protected String mTitle;

    @NonNull
    public final StepArcView saDistance;

    @NonNull
    public final StepArcView saStep;

    @NonNull
    public final StepArcView saTime;

    @NonNull
    public final AppCompatSeekBar sbLock;

    @NonNull
    public final TabLayout tab;

    @NonNull
    public final ConstraintLayout titleLayout;

    @NonNull
    public final TextView tvAvgSpeed;

    @NonNull
    public final TextView tvAvgSpeedHint;

    @NonNull
    public final MarqueeTextView tvDescription;

    @NonNull
    public final TextView tvDistance;

    @NonNull
    public final TextView tvGps;

    @NonNull
    public final TextView tvPaceSpeed;

    @NonNull
    public final TextView tvPaceSpeedHint;

    @NonNull
    public final TextView tvStep;

    @NonNull
    public final TextView tvTime;

    protected AcV4SportsBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView bottomCard, NestedScrollView bottomSheet, ConstraintLayout clGps, ConstraintLayout collapseView, MaterialCardView cvToMap, ConstraintLayout expandView, AppCompatImageButton ibBack, ConstraintLayout ibSet, View ivCollapse, ImageView ivExpand, AppCompatImageView ivGps, AppCompatImageView ivLock, LongPressButton ivStop, AppCompatImageView ivToMap, LongPressButton ivUnlock, MapView mMapView, StepArcView saDistance, StepArcView saStep, StepArcView saTime, AppCompatSeekBar sbLock, TabLayout tab, ConstraintLayout titleLayout, TextView tvAvgSpeed, TextView tvAvgSpeedHint, MarqueeTextView tvDescription, TextView tvDistance, TextView tvGps, TextView tvPaceSpeed, TextView tvPaceSpeedHint, TextView tvStep, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bottomCard = bottomCard;
        this.bottomSheet = bottomSheet;
        this.clGps = clGps;
        this.collapseView = collapseView;
        this.cvToMap = cvToMap;
        this.expandView = expandView;
        this.ibBack = ibBack;
        this.ibSet = ibSet;
        this.ivCollapse = ivCollapse;
        this.ivExpand = ivExpand;
        this.ivGps = ivGps;
        this.ivLock = ivLock;
        this.ivStop = ivStop;
        this.ivToMap = ivToMap;
        this.ivUnlock = ivUnlock;
        this.mMapView = mMapView;
        this.saDistance = saDistance;
        this.saStep = saStep;
        this.saTime = saTime;
        this.sbLock = sbLock;
        this.tab = tab;
        this.titleLayout = titleLayout;
        this.tvAvgSpeed = tvAvgSpeed;
        this.tvAvgSpeedHint = tvAvgSpeedHint;
        this.tvDescription = tvDescription;
        this.tvDistance = tvDistance;
        this.tvGps = tvGps;
        this.tvPaceSpeed = tvPaceSpeed;
        this.tvPaceSpeedHint = tvPaceSpeedHint;
        this.tvStep = tvStep;
        this.tvTime = tvTime;
    }

    public static AcV4SportsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV4SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setBackEvent(@Nullable V4SportActivity backEvent);

    public abstract void setIsClock(@Nullable String isClock);

    public abstract void setNotice(@Nullable String notice);

    public abstract void setSportType(int sportType);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static AcV4SportsBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV4SportsBinding) ViewDataBinding.bind(component, view, R.layout.ac_v4_sports);
    }

    @NonNull
    @Deprecated
    public static AcV4SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV4SportsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v4_sports, root, attachToRoot, component);
    }

    @Nullable
    public V4SportActivity getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getIsClock() {
        return this.mIsClock;
    }

    @Nullable
    public String getNotice() {
        return this.mNotice;
    }

    public int getSportType() {
        return this.mSportType;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public static AcV4SportsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV4SportsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV4SportsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v4_sports, null, false, component);
    }
}
