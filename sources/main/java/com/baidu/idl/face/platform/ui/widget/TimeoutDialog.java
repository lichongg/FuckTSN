package com.baidu.idl.face.platform.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.baidu.idl.face.platform.ui.R;
import com.baidu.idl.face.platform.utils.DensityUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimeoutDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private OnTimeoutDialogClickListener mOnTimeoutDialogClickListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnTimeoutDialogClickListener {
        void onRecollect();

        void onReturn();
    }

    public TimeoutDialog(@NonNull Context context) {
        super(context, R.style.DefaultDialog);
        this.mContext = context;
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_time_out, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        window.setGravity(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DensityUtils.dip2px(getContext(), DensityUtils.px2dip(getContext(), DensityUtils.getDisplayWidth(getContext())) - 40);
        attributes.height = -2;
        window.setAttributes(attributes);
        ((Button) inflate.findViewById(R.id.btn_dialog_recollect)).setOnClickListener(this);
        ((Button) inflate.findViewById(R.id.btn_dialog_return)).setOnClickListener(this);
    }

    public void setDialogListener(OnTimeoutDialogClickListener onTimeoutDialogClickListener) {
        this.mOnTimeoutDialogClickListener = onTimeoutDialogClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnTimeoutDialogClickListener onTimeoutDialogClickListener;
        int id = view.getId();
        if (id == R.id.btn_dialog_recollect) {
            OnTimeoutDialogClickListener onTimeoutDialogClickListener2 = this.mOnTimeoutDialogClickListener;
            if (onTimeoutDialogClickListener2 != null) {
                onTimeoutDialogClickListener2.onRecollect();
                return;
            }
            return;
        }
        if (id == R.id.btn_dialog_return && (onTimeoutDialogClickListener = this.mOnTimeoutDialogClickListener) != null) {
            onTimeoutDialogClickListener.onReturn();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }
}
