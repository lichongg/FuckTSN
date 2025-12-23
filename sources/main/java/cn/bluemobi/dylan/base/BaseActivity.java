package cn.bluemobi.dylan.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar M;
    private FrameLayout N;
    private TextView O;
    private c P;
    private c Q;
    private int R;
    private String S;
    protected Context T;
    protected FragmentActivity U;
    private Toast V;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements c {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            BaseActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void onClick();
    }

    private boolean V(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i6 = iArr[0];
        int i7 = iArr[1];
        return motionEvent.getX() <= ((float) i6) || motionEvent.getX() >= ((float) (view.getWidth() + i6)) || motionEvent.getY() <= ((float) i7) || motionEvent.getY() >= ((float) (view.getHeight() + i7));
    }

    public abstract void M();

    protected abstract int O();

    public abstract void S();

    public abstract void T();

    public abstract void U(Bundle bundle);

    private CharSequence P() {
        return this.O.getText();
    }

    private void R(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    public FrameLayout Q() {
        return this.N;
    }

    protected BaseActivity X(int i6) {
        this.M.setNavigationIcon(i6);
        return this;
    }

    protected BaseActivity Y(c cVar) {
        this.P = cVar;
        return this;
    }

    protected BaseActivity Z(boolean z5) {
        if (!z5) {
            this.M.setNavigationIcon((Drawable) null);
        }
        return this;
    }

    protected BaseActivity a0(int i6, c cVar) {
        this.R = i6;
        this.Q = cVar;
        return this;
    }

    protected BaseActivity b0(String str, int i6, c cVar) {
        this.R = i6;
        this.S = str;
        this.Q = cVar;
        return this;
    }

    protected BaseActivity c0(String str, c cVar) {
        this.Q = cVar;
        this.S = str;
        return this;
    }

    protected BaseActivity d0(boolean z5) {
        this.M.setVisibility(z5 ? 0 : 8);
        return this;
    }

    protected BaseActivity e0(int i6) {
        this.O.setTextColor(i6);
        return this;
    }

    protected BaseActivity f0(float f6) {
        this.O.setTextSize(f6);
        return this;
    }

    public void g0(CharSequence charSequence) {
        Toast toast = this.V;
        if (toast == null) {
            Toast makeText = Toast.makeText(this.T, charSequence, 0);
            this.V = makeText;
            makeText.setGravity(17, 0, 0);
        } else {
            toast.setText(charSequence);
        }
        this.V.show();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.R == 0 && TextUtils.isEmpty(this.S)) {
            return true;
        }
        getMenuInflater().inflate(R.menu.menu_base_title_bar, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.menu_1);
        int i6 = this.R;
        if (i6 != 0) {
            findItem.setIcon(i6);
        }
        if (!TextUtils.isEmpty(this.S)) {
            findItem.setTitle(this.S);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private BaseActivity W() {
        if (cn.bluemobi.dylan.base.a.a() != null) {
            X(cn.bluemobi.dylan.base.a.a().intValue()).Y(new a());
            return this;
        }
        X(R.drawable.ic_return_white_24dp).Y(new b());
        return this;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (V(currentFocus, motionEvent)) {
                R(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.U = this;
        this.T = this;
        N();
        setContentView(R.layout.ac_base_title_bar);
        cn.bluemobi.dylan.base.utils.a.n().c(this);
        this.M = (Toolbar) findViewById(R.id.toolbar);
        this.N = (FrameLayout) findViewById(R.id.viewContent);
        this.O = (TextView) findViewById(R.id.tvTitle);
        setRequestedOrientation(1);
        setSupportActionBar(this.M);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        W();
        T();
        LayoutInflater.from(this).inflate(O(), this.N);
        U(bundle);
        S();
        M();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        cn.bluemobi.dylan.base.utils.a.n().h(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        c cVar;
        if (menuItem.getItemId() == 16908332) {
            c cVar2 = this.P;
            if (cVar2 != null) {
                cVar2.onClick();
                return true;
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_1 && (cVar = this.Q) != null) {
            cVar.onClick();
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Toast toast = this.V;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.O.setText(charSequence);
        }
    }

    protected void N() {
    }
}
