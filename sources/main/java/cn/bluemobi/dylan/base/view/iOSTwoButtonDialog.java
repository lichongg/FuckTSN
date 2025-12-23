package cn.bluemobi.dylan.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.bluemobi.dylan.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class iOSTwoButtonDialog extends Dialog {
    private final Button btn_one;
    private final Button btn_two;
    private boolean isClickAutoCancel;
    private LeftButtonOnClick lefttButtonOnClick;
    private final View line_title;
    private final LinearLayout ll_content;
    private final Context mContext;
    private RightButtonOnClick rightButtonOnClick;
    private final TextView textView;
    private final TextView tv_title;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface LeftButtonOnClick {
        void buttonLeftOnClick();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface RightButtonOnClick {
        void buttonRightOnClick();
    }

    public iOSTwoButtonDialog(@NonNull Context context) {
        super(context, R.style.ios_dialog_theme);
        this.isClickAutoCancel = true;
        this.mContext = context;
        requestWindowFeature(1);
        setContentView(R.layout.ios_dialog_two_bt);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(R.id.ll_content);
        this.textView = (TextView) findViewById(R.id.text_message);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        Button button = (Button) findViewById(R.id.btn_one);
        this.btn_one = button;
        Button button2 = (Button) findViewById(R.id.btn_two);
        this.btn_two = button2;
        this.line_title = findViewById(R.id.line_title);
        button.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSTwoButtonDialog.this.isClickAutoCancel) {
                    iOSTwoButtonDialog.this.dismiss();
                }
                if (iOSTwoButtonDialog.this.lefttButtonOnClick != null) {
                    iOSTwoButtonDialog.this.lefttButtonOnClick.buttonLeftOnClick();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSTwoButtonDialog.this.isClickAutoCancel) {
                    iOSTwoButtonDialog.this.dismiss();
                }
                if (iOSTwoButtonDialog.this.rightButtonOnClick != null) {
                    iOSTwoButtonDialog.this.rightButtonOnClick.buttonRightOnClick();
                }
            }
        });
    }

    public iOSTwoButtonDialog setClickAutoCancel(boolean z5) {
        this.isClickAutoCancel = z5;
        return this;
    }

    public iOSTwoButtonDialog setLeftButtonOnClickListener(LeftButtonOnClick leftButtonOnClick) {
        this.lefttButtonOnClick = leftButtonOnClick;
        return this;
    }

    public iOSTwoButtonDialog setLeftButtonText(CharSequence charSequence) {
        this.btn_one.setText(charSequence);
        return this;
    }

    public iOSTwoButtonDialog setMessage(CharSequence charSequence) {
        this.textView.setVisibility(TextUtils.isEmpty(charSequence.toString()) ? 8 : 0);
        this.textView.setText(charSequence);
        return this;
    }

    public iOSTwoButtonDialog setMessageGrivity(int i6) {
        this.textView.setGravity(i6);
        return this;
    }

    public iOSTwoButtonDialog setRightButtonOnClickListener(RightButtonOnClick rightButtonOnClick) {
        this.rightButtonOnClick = rightButtonOnClick;
        return this;
    }

    public iOSTwoButtonDialog setRightButtonText(CharSequence charSequence) {
        this.btn_two.setText(charSequence);
        return this;
    }

    public iOSTwoButtonDialog setTitle(String str) {
        this.tv_title.setText(str);
        return this;
    }

    public iOSTwoButtonDialog setTitleLineVisiBility(int i6) {
        this.line_title.setVisibility(i6);
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            super.show();
        }
    }

    public iOSTwoButtonDialog setCenterCustomView(int i6) {
        LayoutInflater.from(getContext()).inflate(i6, this.ll_content);
        return this;
    }
}
