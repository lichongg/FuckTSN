package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface ComponentContainer {
    <T> T get(Class<T> cls);

    <T> Deferred<T> getDeferred(Class<T> cls);

    <T> Provider<T> getProvider(Class<T> cls);

    <T> Set<T> setOf(Class<T> cls);

    <T> Provider<Set<T>> setOfProvider(Class<T> cls);
}
