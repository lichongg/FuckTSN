package com.bxkj.student.common.view;

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
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NumberButton extends LinearLayout implements View.OnClickListener, TextWatcher {
    private int mBuyMax;
    private EditText mCount;
    private int mInventory;
    private OnWarnListener mOnWarnListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnWarnListener {
        void onNumberChanged(int number);

        void onWarningForBuyMax(int max);

        void onWarningForInventory(int inventory);
    }

    public NumberButton(Context context) {
        this(context, null);
    }

    public NumberButton setCurrentNumber(int currentNumber) {
        if (currentNumber < 1) {
            this.mCount.setText("1");
        }
        this.mCount.setText("" + Math.min(Math.min(this.mBuyMax, this.mInventory), currentNumber));
        return this;
    }

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInventory = Integer.MAX_VALUE;
        this.mBuyMax = Integer.MAX_VALUE;
        init(context, attrs);
    }

    private void onNumberChanged() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onNumberChanged(getNumber());
        }
    }

    private void setEditable(boolean editable) {
        if (editable) {
            this.mCount.setFocusable(true);
            this.mCount.setKeyListener(new DigitsKeyListener());
        } else {
            this.mCount.setFocusable(false);
            this.mCount.setKeyListener(null);
        }
    }

    private void warningForBuyMax() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onWarningForBuyMax(this.mBuyMax);
        }
    }

    private void warningForInventory() {
        OnWarnListener onWarnListener = this.mOnWarnListener;
        if (onWarnListener != null) {
            onWarnListener.onWarningForInventory(this.mInventory);
        }
    }

    public int getBuyMax() {
        return this.mBuyMax;
    }

    public int getInventory() {
        return this.mInventory;
    }

    public int getNumber() {
        try {
            return Integer.parseInt(this.mCount.getText().toString());
        } catch (NumberFormatException unused) {
            this.mCount.setText("1");
            return 1;
        }
    }

    public NumberButton setBuyMax(int buyMax) {
        this.mBuyMax = buyMax;
        return this;
    }

    public NumberButton setInventory(int inventory) {
        this.mInventory = inventory;
        return this;
    }

    public NumberButton setOnWarnListener(OnWarnListener onWarnListener) {
        this.mOnWarnListener = onWarnListener;
        return this;
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(2131493624, this);
        TextView textView = (TextView) findViewById(2131296672);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(2131296674);
        textView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(2131298668);
        this.mCount = editText;
        editText.setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NumberButton);
        boolean z5 = obtainStyledAttributes.getBoolean(1, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        int color = obtainStyledAttributes.getColor(2, -10066330);
        obtainStyledAttributes.recycle();
        setEditable(z5);
        this.mCount.setTextColor(color);
        textView2.setTextColor(color);
        textView.setTextColor(color);
        if (dimensionPixelSize3 > 0) {
            this.mCount.setTextSize(dimensionPixelSize3);
        }
        if (dimensionPixelSize > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
            textView2.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams);
        }
        if (dimensionPixelSize2 > 0) {
            this.mCount.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, -1));
        }
    }

    private void onNumberInput() {
        int number = getNumber();
        if (number <= 0) {
            this.mCount.setText("1");
            return;
        }
        int min = Math.min(this.mBuyMax, this.mInventory);
        if (number > min) {
            this.mCount.setText(min + "");
            if (this.mInventory < this.mBuyMax) {
                warningForInventory();
            } else {
                warningForBuyMax();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        int number = getNumber();
        if (id == 2131296674) {
            if (number > 1) {
                this.mCount.setText("" + (number - 1));
                onNumberChanged();
                return;
            }
            return;
        }
        if (id == 2131296672) {
            if (number < Math.min(this.mBuyMax, this.mInventory)) {
                this.mCount.setText("" + (number + 1));
                onNumberChanged();
                return;
            }
            if (this.mInventory < this.mBuyMax) {
                warningForInventory();
                return;
            } else {
                warningForBuyMax();
                return;
            }
        }
        if (id == 2131298668) {
            EditText editText = this.mCount;
            editText.setSelection(editText.getText().toString().length());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s5, int start, int before, int count) {
        onNumberInput();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s5) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
    }
}
