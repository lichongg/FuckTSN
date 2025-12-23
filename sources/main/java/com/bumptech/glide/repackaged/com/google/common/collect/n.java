package com.bumptech.glide.repackaged.com.google.common.collect;

import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class n<E extends Enum<E>> extends ImmutableSet<E> {

    /* renamed from: a, reason: collision with root package name */
    private final transient EnumSet<E> f15924a;

    /* renamed from: b, reason: collision with root package name */
    private transient int f15925b;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15924a.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof n) {
            collection = ((n) collection).f15924a;
        }
        return this.f15924a.containsAll(collection);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            obj = ((n) obj).f15924a;
        }
        return this.f15924a.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i6 = this.f15925b;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = this.f15924a.hashCode();
        this.f15925b = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f15924a.isEmpty();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return v.q(this.f15924a.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15924a.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f15924a.toString();
    }

    private n(EnumSet<E> enumSet) {
        this.f15924a = enumSet;
    }

    static ImmutableSet a(EnumSet enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            if (size != 1) {
                return new n(enumSet);
            }
            return ImmutableSet.of(u.d(enumSet));
        }
        return ImmutableSet.of();
    }
}
