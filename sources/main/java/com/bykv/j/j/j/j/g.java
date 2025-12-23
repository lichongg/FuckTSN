package com.bykv.j.j.j.j;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f22778a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f22779b = -1;

    /* renamed from: c, reason: collision with root package name */
    private String f22780c = null;

    /* renamed from: d, reason: collision with root package name */
    private ValueSet f22781d = null;

    static /* synthetic */ class a {
    }

    private static final class b implements Result {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f22782a;

        /* renamed from: b, reason: collision with root package name */
        private final int f22783b;

        /* renamed from: c, reason: collision with root package name */
        private final String f22784c;

        /* renamed from: d, reason: collision with root package name */
        private final ValueSet f22785d;

        /* synthetic */ b(boolean z5, int i6, String str, ValueSet valueSet, a aVar) {
            this(z5, i6, str, valueSet);
        }

        private b(boolean z5, int i6, String str, ValueSet valueSet) {
            this.f22782a = z5;
            this.f22783b = i6;
            this.f22784c = str;
            this.f22785d = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f22783b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f22782a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f22784c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f22785d;
        }
    }

    public static final g a() {
        return new g();
    }

    public g b(int i6) {
        this.f22779b = i6;
        return this;
    }

    public g c(ValueSet valueSet) {
        this.f22781d = valueSet;
        return this;
    }

    public g d(String str) {
        this.f22780c = str;
        return this;
    }

    public g e(boolean z5) {
        this.f22778a = z5;
        return this;
    }

    public Result f() {
        boolean z5 = this.f22778a;
        int i6 = this.f22779b;
        String str = this.f22780c;
        ValueSet valueSet = this.f22781d;
        if (valueSet == null) {
            valueSet = com.bykv.j.j.j.j.a.a().k();
        }
        return new b(z5, i6, str, valueSet, null);
    }

    private g() {
    }
}
