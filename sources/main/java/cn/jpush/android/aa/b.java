package cn.jpush.android.aa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f3343a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f3344b;

    public Map<String, Integer> a() {
        return this.f3343a.getAll();
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(String str) {
        this.f3344b.putInt(str, this.f3343a.getInt(str, 0) + 1);
        this.f3344b.apply();
    }

    public void b() {
        this.f3344b.clear();
        this.f3344b.apply();
    }

    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.statistics", 0);
        this.f3343a = sharedPreferences;
        this.f3344b = sharedPreferences.edit();
    }
}
