package cn.bluemobi.dylan.base.view;

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
public class iOSThreeButtonDialog extends Dialog {
    private final Button btn_one;
    private final Button btn_three;
    private final Button btn_two;
    private CenterButtonOnClick centerButtonOnClick;
    private boolean isClickAutoCancel;
    private LeftButtonOnClick lefttButtonOnClick;
    private final View line_title;
    private final LinearLayout ll_content;
    private RightButtonOnClick rightButtonOnClick;
    private final TextView textView;
    private final TextView tv_title;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CenterButtonOnClick {
        void buttonCenterOnClick();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface LeftButtonOnClick {
        void buttonLeftOnClick();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface RightButtonOnClick {
        void buttonRightOnClick();
    }

    public iOSThreeButtonDialog(@NonNull Context context) {
        super(context, R.style.ios_dialog_theme);
        this.isClickAutoCancel = true;
        requestWindowFeature(1);
        setContentView(R.layout.ios_dialog_three_bt);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(R.id.ll_content);
        this.textView = (TextView) findViewById(R.id.text_message);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        Button button = (Button) findViewById(R.id.btn_one);
        this.btn_one = button;
        Button button2 = (Button) findViewById(R.id.btn_two);
        this.btn_two = button2;
        Button button3 = (Button) findViewById(R.id.btn_three);
        this.btn_three = button3;
        this.line_title = findViewById(R.id.line_title);
        button.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.lefttButtonOnClick != null) {
                    iOSThreeButtonDialog.this.lefttButtonOnClick.buttonLeftOnClick();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.centerButtonOnClick != null) {
                    iOSThreeButtonDialog.this.centerButtonOnClick.buttonCenterOnClick();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.rightButtonOnClick != null) {
                    iOSThreeButtonDialog.this.rightButtonOnClick.buttonRightOnClick();
                }
            }
        });
    }

    public iOSThreeButtonDialog setCenterButtonOnClick(CenterButtonOnClick centerButtonOnClick) {
        this.centerButtonOnClick = centerButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setCenterButtonText(CharSequence charSequence) {
        this.btn_two.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setClickAutoCancel(boolean z5) {
        this.isClickAutoCancel = z5;
        return this;
    }

    public iOSThreeButtonDialog setLeftButtonOnClickListener(LeftButtonOnClick leftButtonOnClick) {
        this.lefttButtonOnClick = leftButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setLeftButtonText(CharSequence charSequence) {
        this.btn_one.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setMessage(CharSequence charSequence) {
        this.textView.setVisibility(TextUtils.isEmpty(charSequence.toString()) ? 8 : 0);
        this.textView.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setMessageGrivity(int i6) {
        this.textView.setGravity(i6);
        return this;
    }

    public iOSThreeButtonDialog setRightButtonOnClickListener(RightButtonOnClick rightButtonOnClick) {
        this.rightButtonOnClick = rightButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setRightButtonText(CharSequence charSequence) {
        this.btn_three.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setTitle(String str) {
        this.tv_title.setText(str);
        return this;
    }

    public iOSThreeButtonDialog setTitleLineVisiBility(int i6) {
        this.line_title.setVisibility(i6);
        return this;
    }

    public iOSThreeButtonDialog setCenterCustomView(int i6) {
        LayoutInflater.from(getContext()).inflate(i6, this.ll_content);
        return this;
    }
}
