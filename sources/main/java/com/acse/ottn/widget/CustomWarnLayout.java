package com.acse.ottn.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CustomWarnLayout extends LinearLayout {
    private RelativeLayout sncakbar_relativeLayout;
    private TextView textView;
    private TextView tv_look;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5471a;

        public a(Activity activity) {
            this.f5471a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f5471a, 10010);
        }
    }

    public CustomWarnLayout(Context context) {
        super(context);
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.my_seeding_snackbar, (ViewGroup) this, true);
        this.textView = (TextView) findViewById(R.id.tv_content);
        this.sncakbar_relativeLayout = (RelativeLayout) findViewById(R.id.sncakbar_relativeLayout);
        this.tv_look = (TextView) findViewById(R.id.tv_look);
        initView();
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        this.sncakbar_relativeLayout.setBackgroundResource(i6);
    }

    public void setButtonBackgroundResource(int i6) {
        this.tv_look.setBackgroundResource(i6);
    }

    public void setButtonPadding(int i6, int i7, int i8, int i9) {
        this.tv_look.setPadding(i6, i7, i8, i9);
    }

    public void setButtonText(String str) {
        this.tv_look.setText(str);
    }

    public void setButtonTextSize(float f6) {
        this.tv_look.setTextSize(f6);
    }

    public void setContentText(String str) {
        this.textView.setText(str);
    }

    public void setContentTextSize(float f6) {
        this.textView.setTextSize(f6);
    }

    public void setOnClickListener(Activity activity) {
        this.sncakbar_relativeLayout.setOnClickListener(new a(activity));
        invalidate();
    }

    private void initView() {
        if (AcseHelpManager.isOPenPermission()) {
            this.sncakbar_relativeLayout.setVisibility(8);
        }
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}
