package com.github.mikephil.charting.matrix;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Vector3 {

    /* renamed from: x, reason: collision with root package name */
    public float f32560x;

    /* renamed from: y, reason: collision with root package name */
    public float f32561y;

    /* renamed from: z, reason: collision with root package name */
    public float f32562z;
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);

    public Vector3() {
    }

    public final void add(Vector3 vector3) {
        this.f32560x += vector3.f32560x;
        this.f32561y += vector3.f32561y;
        this.f32562z += vector3.f32562z;
    }

    public final void divide(float f6) {
        if (f6 != 0.0f) {
            this.f32560x /= f6;
            this.f32561y /= f6;
            this.f32562z /= f6;
        }
    }

    public final void multiply(float f6) {
        this.f32560x *= f6;
        this.f32561y *= f6;
        this.f32562z *= f6;
    }

    public final void set(Vector3 vector3) {
        this.f32560x = vector3.f32560x;
        this.f32561y = vector3.f32561y;
        this.f32562z = vector3.f32562z;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public final Vector3 cross(Vector3 vector3) {
        float f6 = this.f32561y;
        float f7 = vector3.f32562z;
        float f8 = this.f32562z;
        float f9 = vector3.f32561y;
        float f10 = (f6 * f7) - (f8 * f9);
        float f11 = vector3.f32560x;
        float f12 = this.f32560x;
        return new Vector3(f10, (f8 * f11) - (f7 * f12), (f12 * f9) - (f6 * f11));
    }

    public final float distance2(Vector3 vector3) {
        float f6 = this.f32560x - vector3.f32560x;
        float f7 = this.f32561y - vector3.f32561y;
        float f8 = this.f32562z - vector3.f32562z;
        return (f6 * f6) + (f7 * f7) + (f8 * f8);
    }

    public final float dot(Vector3 vector3) {
        return (this.f32560x * vector3.f32560x) + (this.f32561y * vector3.f32561y) + (this.f32562z * vector3.f32562z);
    }

    public final float length2() {
        float f6 = this.f32560x;
        float f7 = this.f32561y;
        float f8 = (f6 * f6) + (f7 * f7);
        float f9 = this.f32562z;
        return f8 + (f9 * f9);
    }

    public final void subtract(Vector3 vector3) {
        this.f32560x -= vector3.f32560x;
        this.f32561y -= vector3.f32561y;
        this.f32562z -= vector3.f32562z;
    }

    public final void subtractMultiple(Vector3 vector3, float f6) {
        this.f32560x -= vector3.f32560x * f6;
        this.f32561y -= vector3.f32561y * f6;
        this.f32562z -= vector3.f32562z * f6;
    }

    public final float length() {
        return (float) Math.sqrt(length2());
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f32560x /= length;
            this.f32561y /= length;
            this.f32562z /= length;
        }
        return length;
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        if (dot(vector3) > 0.0f) {
            return true;
        }
        return false;
    }

    public Vector3(float f6, float f7, float f8) {
        set(f6, f7, f8);
    }

    public final void add(float f6, float f7, float f8) {
        this.f32560x += f6;
        this.f32561y += f7;
        this.f32562z += f8;
    }

    public final void multiply(Vector3 vector3) {
        this.f32560x *= vector3.f32560x;
        this.f32561y *= vector3.f32561y;
        this.f32562z *= vector3.f32562z;
    }

    public final void set(float f6, float f7, float f8) {
        this.f32560x = f6;
        this.f32561y = f7;
        this.f32562z = f8;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }
}
