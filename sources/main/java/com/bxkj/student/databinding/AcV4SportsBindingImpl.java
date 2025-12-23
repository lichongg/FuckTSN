package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.amap.api.maps.MapView;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.common.view.StepArcView;
import com.bxkj.student.v2.ui.sports.v3.V4SportActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV4SportsBindingImpl extends AcV4SportsBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback28;

    @Nullable
    private final View.OnClickListener mCallback29;

    @Nullable
    private final View.OnClickListener mCallback30;

    @Nullable
    private final View.OnClickListener mCallback31;

    @Nullable
    private final View.OnClickListener mCallback32;

    @Nullable
    private final View.OnClickListener mCallback33;
    private long mDirtyFlags;

    @NonNull
    private final CoordinatorLayout mboundView0;

    @NonNull
    private final TextView mboundView6;

    @NonNull
    private final TextView mboundView8;

    public AcV4SportsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 34, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mNotice;
        int i6 = this.mSportType;
        long j7 = j6 & 40;
        int i7 = 0;
        if (j7 != 0) {
            boolean z5 = i6 == 5;
            if (j7 != 0) {
                j6 |= z5 ? 128L : 64L;
            }
            if (z5) {
                i7 = 8;
            }
        }
        if ((32 & j6) != 0) {
            this.ibBack.setOnClickListener(this.mCallback28);
            this.ibSet.setOnClickListener(this.mCallback29);
            this.ivCollapse.setOnClickListener(this.mCallback31);
            this.ivExpand.setOnClickListener(this.mCallback30);
            this.ivLock.setOnClickListener(this.mCallback32);
            this.ivToMap.setOnClickListener(this.mCallback33);
        }
        if ((40 & j6) != 0) {
            this.mboundView6.setVisibility(i7);
            this.mboundView8.setVisibility(i7);
            this.saDistance.setVisibility(i7);
            this.saStep.setVisibility(i7);
            this.tvAvgSpeed.setVisibility(i7);
            this.tvAvgSpeedHint.setVisibility(i7);
            this.tvDistance.setVisibility(i7);
            this.tvPaceSpeed.setVisibility(i7);
            this.tvPaceSpeedHint.setVisibility(i7);
            this.tvStep.setVisibility(i7);
        }
        if ((j6 & 36) != 0) {
            TextViewBindingAdapter.setText(this.tvDescription, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 18);
        sparseIntArray.put(R.id.tab, 19);
        sparseIntArray.put(R.id.mMapView, 20);
        sparseIntArray.put(R.id.cl_gps, 21);
        sparseIntArray.put(R.id.tv_gps, 22);
        sparseIntArray.put(R.id.iv_gps, 23);
        sparseIntArray.put(R.id.bottom_sheet, 24);
        sparseIntArray.put(R.id.bottom_card, 25);
        sparseIntArray.put(R.id.collapse_view, 26);
        sparseIntArray.put(2131299158, 27);
        sparseIntArray.put(R.id.expand_view, 28);
        sparseIntArray.put(R.id.sa_time, 29);
        sparseIntArray.put(R.id.iv_unlock, 30);
        sparseIntArray.put(R.id.iv_stop, 31);
        sparseIntArray.put(R.id.cv_to_map, 32);
        sparseIntArray.put(R.id.sb_lock, 33);
    }

    private AcV4SportsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[25], (NestedScrollView) bindings[24], (ConstraintLayout) bindings[21], (ConstraintLayout) bindings[26], (MaterialCardView) bindings[32], (ConstraintLayout) bindings[28], (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[2], (View) bindings[9], (ImageView) bindings[4], (AppCompatImageView) bindings[23], (AppCompatImageView) bindings[16], (LongPressButton) bindings[31], (AppCompatImageView) bindings[17], (LongPressButton) bindings[30], (MapView) bindings[20], (StepArcView) bindings[10], (StepArcView) bindings[11], (StepArcView) bindings[29], (AppCompatSeekBar) bindings[33], (TabLayout) bindings[19], (ConstraintLayout) bindings[18], (TextView) bindings[12], (TextView) bindings[13], (MarqueeTextView) bindings[3], (TextView) bindings[5], (TextView) bindings[22], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[7], (TextView) bindings[27]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibSet.setTag(null);
        this.ivCollapse.setTag(null);
        this.ivExpand.setTag(null);
        this.ivLock.setTag(null);
        this.ivToMap.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.mboundView6 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[8];
        this.mboundView8 = textView2;
        textView2.setTag(null);
        this.saDistance.setTag(null);
        this.saStep.setTag(null);
        this.tvAvgSpeed.setTag(null);
        this.tvAvgSpeedHint.setTag(null);
        this.tvDescription.setTag(null);
        this.tvDistance.setTag(null);
        this.tvPaceSpeed.setTag(null);
        this.tvPaceSpeedHint.setTag(null);
        this.tvStep.setTag(null);
        setRootTag(root);
        this.mCallback30 = new a(this, 3);
        this.mCallback28 = new a(this, 1);
        this.mCallback32 = new a(this, 5);
        this.mCallback31 = new a(this, 4);
        this.mCallback33 = new a(this, 6);
        this.mCallback29 = new a(this, 2);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.AcV4SportsBinding
    public void setBackEvent(@Nullable V4SportActivity BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV4SportsBinding
    public void setIsClock(@Nullable String IsClock) {
        this.mIsClock = IsClock;
    }

    @Override // com.bxkj.student.databinding.AcV4SportsBinding
    public void setNotice(@Nullable String Notice) {
        this.mNotice = Notice;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV4SportsBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV4SportsBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (11 == variableId) {
            setIsClock((String) variable);
            return true;
        }
        if (4 == variableId) {
            setBackEvent((V4SportActivity) variable);
            return true;
        }
        if (22 == variableId) {
            setNotice((String) variable);
            return true;
        }
        if (26 == variableId) {
            setSportType(((Integer) variable).intValue());
            return true;
        }
        if (29 != variableId) {
            return false;
        }
        setTitle((String) variable);
        return true;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                V4SportActivity v4SportActivity = this.mBackEvent;
                if (v4SportActivity != null) {
                    v4SportActivity.r1();
                    break;
                }
                break;
            case 2:
                V4SportActivity v4SportActivity2 = this.mBackEvent;
                if (v4SportActivity2 != null) {
                    v4SportActivity2.g0();
                    break;
                }
                break;
            case 3:
                V4SportActivity v4SportActivity3 = this.mBackEvent;
                if (v4SportActivity3 != null) {
                    v4SportActivity3.Q();
                    break;
                }
                break;
            case 4:
                V4SportActivity v4SportActivity4 = this.mBackEvent;
                if (v4SportActivity4 != null) {
                    v4SportActivity4.O();
                    break;
                }
                break;
            case 5:
                V4SportActivity v4SportActivity5 = this.mBackEvent;
                if (v4SportActivity5 != null) {
                    v4SportActivity5.X();
                    break;
                }
                break;
            case 6:
                V4SportActivity v4SportActivity6 = this.mBackEvent;
                if (v4SportActivity6 != null) {
                    v4SportActivity6.c0();
                    break;
                }
                break;
        }
    }
}
