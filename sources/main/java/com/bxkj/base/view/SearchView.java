package com.bxkj.base.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bxkj.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SearchView extends LinearLayout implements TextWatcher, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private EditText f17170a;

    /* renamed from: b, reason: collision with root package name */
    private Button f17171b;

    /* renamed from: c, reason: collision with root package name */
    private a f17172c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(TextView textView, int i6, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            ((InputMethodManager) this.f17170a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f17170a.getWindowToken(), 0);
            a aVar = this.f17172c;
            if (aVar != null) {
                aVar.a(this.f17170a.getText().toString());
            }
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f17170a.getText().toString().trim().isEmpty()) {
            this.f17171b.setVisibility(8);
        } else {
            this.f17171b.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f17170a.setText("");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        a aVar = this.f17172c;
        if (aVar != null) {
            aVar.a(charSequence.toString());
        }
    }

    public void setOnSearchListener(a aVar) {
        this.f17172c = aVar;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.pub_searchview, (ViewGroup) this, true);
        this.f17170a = (EditText) findViewById(R.id.et_search);
        Button button = (Button) findViewById(R.id.bt_clear);
        this.f17171b = button;
        button.setVisibility(8);
        this.f17170a.addTextChangedListener(this);
        this.f17171b.setOnClickListener(this);
        this.f17170a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.bxkj.base.view.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
                boolean b6;
                b6 = SearchView.this.b(textView, i6, keyEvent);
                return b6;
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
    }
}
