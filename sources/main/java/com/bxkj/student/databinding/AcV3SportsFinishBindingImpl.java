package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.common.view.CircleProgressView;
import com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV3SportsFinishBindingImpl extends AcV3SportsFinishBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback21;

    @Nullable
    private final View.OnClickListener mCallback22;
    private long mDirtyFlags;

    @NonNull
    private final TextView mboundView14;

    public AcV3SportsFinishBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3SportsFinishDialog v3SportsFinishDialog;
        if (sourceId != 1) {
            if (sourceId == 2 && (v3SportsFinishDialog = this.mDialog) != null) {
                v3SportsFinishDialog.Z();
                return;
            }
            return;
        }
        V3SportsFinishDialog v3SportsFinishDialog2 = this.mDialog;
        if (v3SportsFinishDialog2 != null) {
            v3SportsFinishDialog2.u0();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i6 = this.mSportType;
        String str = this.mTipsText;
        long j7 = j6 & 9;
        int i7 = 0;
        if (j7 != 0) {
            boolean z5 = i6 == 5;
            if (j7 != 0) {
                j6 |= z5 ? 32L : 16L;
            }
            if (z5) {
                i7 = 8;
            }
        }
        long j8 = 12 & j6;
        if ((8 & j6) != 0) {
            this.btBack.setOnClickListener(this.mCallback22);
            this.cardNoPass.setOnClickListener(this.mCallback21);
        }
        if ((j6 & 9) != 0) {
            this.cpDistance.setVisibility(i7);
            this.cpStep.setVisibility(i7);
            this.tvDistance.setVisibility(i7);
            this.tvDistanceHint.setVisibility(i7);
            this.tvDistanceStatus.setVisibility(i7);
            this.tvDistanceTag.setVisibility(i7);
            this.tvStep.setVisibility(i7);
            this.tvStepHint.setVisibility(i7);
            this.tvStepStatus.setVisibility(i7);
            this.tvStepTarget.setVisibility(i7);
            this.vDistance.setVisibility(i7);
            this.vStep.setVisibility(i7);
        }
        if (j8 != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str);
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
            this.mDirtyFlags = 8L;
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
        sparseIntArray.put(R.id.tv_title_hint, 16);
        sparseIntArray.put(R.id.v_time, 17);
        sparseIntArray.put(R.id.tv_time_target, 18);
        sparseIntArray.put(R.id.tv_time_hint, 19);
        sparseIntArray.put(2131299158, 20);
        sparseIntArray.put(R.id.tv_time_status, 21);
        sparseIntArray.put(R.id.cp_time, 22);
        sparseIntArray.put(R.id.card_pass_point, 23);
        sparseIntArray.put(R.id.tv_pass_point_target, 24);
        sparseIntArray.put(R.id.tv_pass_point, 25);
        sparseIntArray.put(R.id.tv_pass, 26);
        sparseIntArray.put(R.id.tv_no_pass_point, 27);
        sparseIntArray.put(2131296623, 28);
    }

    private AcV3SportsFinishBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialButton) bindings[15], (MaterialButton) bindings[28], (MaterialCardView) bindings[13], (MaterialCardView) bindings[23], (CircleProgressView) bindings[11], (CircleProgressView) bindings[12], (CircleProgressView) bindings[22], (MaterialCardView) bindings[0], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[27], (TextView) bindings[26], (TextView) bindings[25], (TextView) bindings[24], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[7], (TextView) bindings[20], (TextView) bindings[19], (TextView) bindings[21], (TextView) bindings[18], (TextView) bindings[16], (View) bindings[1], (View) bindings[6], (View) bindings[17]);
        this.mDirtyFlags = -1L;
        this.btBack.setTag(null);
        this.cardNoPass.setTag(null);
        this.cpDistance.setTag(null);
        this.cpStep.setTag(null);
        TextView textView = (TextView) bindings[14];
        this.mboundView14 = textView;
        textView.setTag(null);
        this.rlThreetwoone.setTag(null);
        this.tvDistance.setTag(null);
        this.tvDistanceHint.setTag(null);
        this.tvDistanceStatus.setTag(null);
        this.tvDistanceTag.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepHint.setTag(null);
        this.tvStepStatus.setTag(null);
        this.tvStepTarget.setTag(null);
        this.vDistance.setTag(null);
        this.vStep.setTag(null);
        setRootTag(root);
        this.mCallback21 = new a(this, 1);
        this.mCallback22 = new a(this, 2);
        invalidateAll();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setDialog(@Nullable V3SportsFinishDialog Dialog) {
        this.mDialog = Dialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsFinishBinding
    public void setTipsText(@Nullable String TipsText) {
        this.mTipsText = TipsText;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (26 == variableId) {
            setSportType(((Integer) variable).intValue());
            return true;
        }
        if (9 == variableId) {
            setDialog((V3SportsFinishDialog) variable);
            return true;
        }
        if (28 != variableId) {
            return false;
        }
        setTipsText((String) variable);
        return true;
    }
}
