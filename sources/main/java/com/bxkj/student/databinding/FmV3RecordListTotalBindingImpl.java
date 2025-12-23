package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.R;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FmV3RecordListTotalBindingImpl extends FmV3RecordListTotalBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tb_type, 1);
        sparseIntArray.put(R.id.card_chat, 2);
        sparseIntArray.put(R.id.AAChartView, 3);
        sparseIntArray.put(R.id.card_user, 4);
        sparseIntArray.put(2131298083, 5);
        sparseIntArray.put(2131297148, 6);
        sparseIntArray.put(2131298986, 7);
        sparseIntArray.put(R.id.tv_account, 8);
        sparseIntArray.put(R.id.card_pace, 9);
        sparseIntArray.put(R.id.tv_distance_hint, 10);
        sparseIntArray.put(2131298881, 11);
        sparseIntArray.put(R.id.tv_distance_unit, 12);
        sparseIntArray.put(R.id.ll00, 13);
        sparseIntArray.put(R.id.tv_day_hint, 14);
        sparseIntArray.put(2131298861, 15);
        sparseIntArray.put(R.id.tv_day_unit, 16);
        sparseIntArray.put(R.id.tv_avg_distance_hint, 17);
        sparseIntArray.put(R.id.tv_avg_distance, 18);
        sparseIntArray.put(R.id.tv_avg_distance_unit, 19);
        sparseIntArray.put(R.id.line00, 20);
        sparseIntArray.put(R.id.ll0, 21);
        sparseIntArray.put(R.id.tv_avg_count_hint, 22);
        sparseIntArray.put(R.id.tv_avg_count, 23);
        sparseIntArray.put(R.id.tv_avg_count_unit, 24);
        sparseIntArray.put(R.id.tv_avg_time_hint, 25);
        sparseIntArray.put(R.id.tv_avg_time, 26);
        sparseIntArray.put(R.id.tv_avg_time_unit, 27);
        sparseIntArray.put(R.id.line0, 28);
        sparseIntArray.put(R.id.ll1, 29);
        sparseIntArray.put(R.id.tv_count_hint, 30);
        sparseIntArray.put(2131298848, 31);
        sparseIntArray.put(R.id.tv_count_unit, 32);
        sparseIntArray.put(R.id.tv_time_hint, 33);
        sparseIntArray.put(2131299158, 34);
        sparseIntArray.put(R.id.tv_time_unit, 35);
        sparseIntArray.put(2131297979, 36);
        sparseIntArray.put(R.id.ll2, 37);
        sparseIntArray.put(R.id.tv_heart_hint, 38);
        sparseIntArray.put(R.id.tv_heart, 39);
        sparseIntArray.put(R.id.tv_heart_unit, 40);
        sparseIntArray.put(R.id.tv_pace_hint, 41);
        sparseIntArray.put(R.id.tv_pace, 42);
        sparseIntArray.put(R.id.tv_pace_unit, 43);
        sparseIntArray.put(2131297983, 44);
        sparseIntArray.put(R.id.ll3, 45);
        sparseIntArray.put(R.id.tv_step_hint, 46);
        sparseIntArray.put(2131299117, 47);
        sparseIntArray.put(R.id.tv_step_unit, 48);
        sparseIntArray.put(R.id.tv_step_distance_hint, 49);
        sparseIntArray.put(R.id.tv_step_distance, 50);
        sparseIntArray.put(R.id.tv_step_distance_unit, 51);
        sparseIntArray.put(R.id.card_sun_run, 52);
        sparseIntArray.put(R.id.cl_sunrun, 53);
        sparseIntArray.put(R.id.tv_sun_run, 54);
        sparseIntArray.put(R.id.iv_yxlc, 55);
        sparseIntArray.put(R.id.tv_yxlc_hint, 56);
        sparseIntArray.put(R.id.tv_yxlc, 57);
        sparseIntArray.put(R.id.tv_yxlc_unit, 58);
        sparseIntArray.put(R.id.iv_dblc, 59);
        sparseIntArray.put(R.id.tv_dblc_hint, 60);
        sparseIntArray.put(R.id.tv_dblc, 61);
        sparseIntArray.put(R.id.tv_dblc_unit, 62);
        sparseIntArray.put(R.id.iv_sylc, 63);
        sparseIntArray.put(R.id.tv_sylc_hint, 64);
        sparseIntArray.put(R.id.tv_sylc, 65);
        sparseIntArray.put(R.id.tv_sylc_unit, 66);
        sparseIntArray.put(R.id.pb_distance, 67);
        sparseIntArray.put(R.id.iv_yxxs, 68);
        sparseIntArray.put(R.id.tv_yxcs_hint, 69);
        sparseIntArray.put(R.id.tv_yxcs, 70);
        sparseIntArray.put(R.id.tv_yxcs_unit, 71);
        sparseIntArray.put(R.id.iv_dbcs, 72);
        sparseIntArray.put(R.id.tv_dbcs_hint, 73);
        sparseIntArray.put(R.id.tv_dbcs, 74);
        sparseIntArray.put(R.id.tv_dbcs_unit, 75);
        sparseIntArray.put(R.id.iv_sycl, 76);
        sparseIntArray.put(R.id.tv_sycs_hint, 77);
        sparseIntArray.put(R.id.tv_sycs, 78);
        sparseIntArray.put(R.id.tv_sycs_unit, 79);
        sparseIntArray.put(R.id.pb_count, 80);
        sparseIntArray.put(R.id.card_morning_run, 81);
        sparseIntArray.put(R.id.cl_morning_run, 82);
        sparseIntArray.put(R.id.tv_morning_run, 83);
        sparseIntArray.put(R.id.iv_yxlc_morning, 84);
        sparseIntArray.put(R.id.tv_yxlc_hint_morning, 85);
        sparseIntArray.put(R.id.tv_yxlc_morning, 86);
        sparseIntArray.put(R.id.tv_yxlc_unit_morning, 87);
        sparseIntArray.put(R.id.iv_dblc_morning, 88);
        sparseIntArray.put(R.id.tv_dblc_hint_morning, 89);
        sparseIntArray.put(R.id.tv_dblc_morning, 90);
        sparseIntArray.put(R.id.tv_dblc_unit_morning, 91);
        sparseIntArray.put(R.id.iv_sylc_morning, 92);
        sparseIntArray.put(R.id.tv_sylc_hint_morning, 93);
        sparseIntArray.put(R.id.tv_sylc_morning, 94);
        sparseIntArray.put(R.id.tv_sylc_unit_morning, 95);
        sparseIntArray.put(R.id.pb_distance_morning, 96);
        sparseIntArray.put(R.id.iv_yxxs_morning, 97);
        sparseIntArray.put(R.id.tv_yxcs_hint_morning, 98);
        sparseIntArray.put(R.id.tv_yxcs_morning, 99);
        sparseIntArray.put(R.id.tv_yxcs_unit_morning, 100);
        sparseIntArray.put(R.id.iv_dbcs_morning, 101);
        sparseIntArray.put(R.id.tv_dbcs_hint_morning, 102);
        sparseIntArray.put(R.id.tv_dbcs_morning, 103);
        sparseIntArray.put(R.id.tv_dbcs_unit_morning, 104);
        sparseIntArray.put(R.id.iv_sycl_morning, 105);
        sparseIntArray.put(R.id.tv_sycs_hint_morning, 106);
        sparseIntArray.put(R.id.tv_sycs_morning, 107);
        sparseIntArray.put(R.id.tv_sycs_unit_morning, 108);
        sparseIntArray.put(R.id.pb_count_morning, 109);
    }

    public FmV3RecordListTotalBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 110, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        return true;
    }

    private FmV3RecordListTotalBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AAChartView) bindings[3], (MaterialCardView) bindings[2], (MaterialCardView) bindings[81], (MaterialCardView) bindings[9], (MaterialCardView) bindings[52], (MaterialCardView) bindings[4], (ConstraintLayout) bindings[82], (ConstraintLayout) bindings[53], (ImageView) bindings[72], (ImageView) bindings[101], (ImageView) bindings[59], (ImageView) bindings[88], (ShapeableImageView) bindings[6], (ImageView) bindings[76], (ImageView) bindings[105], (ImageView) bindings[63], (ImageView) bindings[92], (ImageView) bindings[55], (ImageView) bindings[84], (ImageView) bindings[68], (ImageView) bindings[97], (View) bindings[36], (View) bindings[28], (View) bindings[20], (View) bindings[44], (LinearLayout) bindings[21], (LinearLayout) bindings[13], (LinearLayout) bindings[29], (LinearLayout) bindings[37], (LinearLayout) bindings[45], (LinearLayout) bindings[5], (ProgressBar) bindings[80], (ProgressBar) bindings[109], (ProgressBar) bindings[67], (ProgressBar) bindings[96], (TabLayout) bindings[1], (TextView) bindings[8], (TextView) bindings[23], (TextView) bindings[22], (TextView) bindings[24], (TextView) bindings[18], (TextView) bindings[17], (TextView) bindings[19], (TextView) bindings[26], (TextView) bindings[25], (TextView) bindings[27], (TextView) bindings[31], (TextView) bindings[30], (TextView) bindings[32], (TextView) bindings[15], (TextView) bindings[14], (TextView) bindings[16], (TextView) bindings[74], (TextView) bindings[73], (TextView) bindings[102], (TextView) bindings[103], (TextView) bindings[75], (TextView) bindings[104], (TextView) bindings[61], (TextView) bindings[60], (TextView) bindings[89], (TextView) bindings[90], (TextView) bindings[62], (TextView) bindings[91], (TextView) bindings[11], (TextView) bindings[10], (TextView) bindings[12], (TextView) bindings[39], (TextView) bindings[38], (TextView) bindings[40], (TextView) bindings[83], (TextView) bindings[7], (TextView) bindings[42], (TextView) bindings[41], (TextView) bindings[43], (TextView) bindings[47], (TextView) bindings[50], (TextView) bindings[49], (TextView) bindings[51], (TextView) bindings[46], (TextView) bindings[48], (TextView) bindings[54], (TextView) bindings[78], (TextView) bindings[77], (TextView) bindings[106], (TextView) bindings[107], (TextView) bindings[79], (TextView) bindings[108], (TextView) bindings[65], (TextView) bindings[64], (TextView) bindings[93], (TextView) bindings[94], (TextView) bindings[66], (TextView) bindings[95], (TextView) bindings[34], (TextView) bindings[33], (TextView) bindings[35], (TextView) bindings[70], (TextView) bindings[69], (TextView) bindings[98], (TextView) bindings[99], (TextView) bindings[71], (TextView) bindings[100], (TextView) bindings[57], (TextView) bindings[56], (TextView) bindings[85], (TextView) bindings[86], (TextView) bindings[58], (TextView) bindings[87]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
