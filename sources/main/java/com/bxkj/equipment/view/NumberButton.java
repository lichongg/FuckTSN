package com.bxkj.equipment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bxkj.equipment.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NumberButton extends LinearLayout implements View.OnClickListener, TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private int f17507a;

    /* renamed from: b, reason: collision with root package name */
    private int f17508b;

    /* renamed from: c, reason: collision with root package name */
    private EditText f17509c;

    /* renamed from: d, reason: collision with root package name */
    private a f17510d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onNumberChanged(int number);

        void onWarningForBuyMax(int max);

        void onWarningForInventory(int inventory);
    }

    public NumberButton(Context context) {
        this(context, null);
    }

    public NumberButton e(int currentNumber) {
        if (currentNumber < 1) {
            this.f17509c.setText("1");
        }
        this.f17509c.setText("" + Math.min(Math.min(this.f17508b, this.f17507a), currentNumber));
        return this;
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f17507a = Integer.MAX_VALUE;
        this.f17508b = Integer.MAX_VALUE;
        a(context, attrs);
    }

    private void b() {
        a aVar = this.f17510d;
        if (aVar != null) {
            aVar.onNumberChanged(getNumber());
        }
    }

    private void h() {
        a aVar = this.f17510d;
        if (aVar != null) {
            aVar.onWarningForBuyMax(this.f17508b);
        }
    }

    private void i() {
        a aVar = this.f17510d;
        if (aVar != null) {
            aVar.onWarningForInventory(this.f17507a);
        }
    }

    private void setEditable(boolean editable) {
        if (editable) {
            this.f17509c.setFocusable(true);
            this.f17509c.setKeyListener(new DigitsKeyListener());
        } else {
            this.f17509c.setFocusable(false);
            this.f17509c.setKeyListener(null);
        }
    }

    public NumberButton d(int buyMax) {
        this.f17508b = buyMax;
        return this;
    }

    public NumberButton f(int inventory) {
        this.f17507a = inventory;
        return this;
    }

    public NumberButton g(a onWarnListener) {
        this.f17510d = onWarnListener;
        return this;
    }

    public int getBuyMax() {
        return this.f17508b;
    }

    public int getInventory() {
        return this.f17507a;
    }

    public int getNumber() {
        try {
            return Integer.parseInt(this.f17509c.getText().toString());
        } catch (NumberFormatException unused) {
            this.f17509c.setText("1");
            return 1;
        }
    }

    private void a(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.number_layout, this);
        TextView textView = (TextView) findViewById(R.id.button_add);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.button_sub);
        textView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.text_count);
        this.f17509c = editText;
        editText.setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NumberButton);
        boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.NumberButton_editable, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_buttonWidth, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_textWidth, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberButton_textSize, -1);
        int color = obtainStyledAttributes.getColor(R.styleable.NumberButton_textColor, -10066330);
        obtainStyledAttributes.recycle();
        setEditable(z5);
        this.f17509c.setTextColor(color);
        textView2.setTextColor(color);
        textView.setTextColor(color);
        if (dimensionPixelSize3 > 0) {
            this.f17509c.setTextSize(dimensionPixelSize3);
        }
        if (dimensionPixelSize > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
            textView2.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams);
        }
        if (dimensionPixelSize2 > 0) {
            this.f17509c.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, -1));
        }
    }

    private void c() {
        int number = getNumber();
        if (number <= 0) {
            this.f17509c.setText("1");
            return;
        }
        int min = Math.min(this.f17508b, this.f17507a);
        if (number > min) {
            this.f17509c.setText(min + "");
            if (this.f17507a < this.f17508b) {
                i();
            } else {
                h();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        int number = getNumber();
        if (id == R.id.button_sub) {
            if (number > 1) {
                this.f17509c.setText("" + (number - 1));
                b();
                return;
            }
            return;
        }
        if (id == R.id.button_add) {
            if (number < Math.min(this.f17508b, this.f17507a)) {
                this.f17509c.setText("" + (number + 1));
                b();
                return;
            }
            if (this.f17507a < this.f17508b) {
                i();
                return;
            } else {
                h();
                return;
            }
        }
        if (id == R.id.text_count) {
            EditText editText = this.f17509c;
            editText.setSelection(editText.getText().toString().length());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s5, int start, int before, int count) {
        c();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s5) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
    }
}
