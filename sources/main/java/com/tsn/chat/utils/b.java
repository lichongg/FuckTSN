package com.tsn.chat.utils;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static ChannelGroup f40730a = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /* renamed from: b, reason: collision with root package name */
    public static String f40731b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f40732c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f40733d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f40734e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f40735f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f40736g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f40737h = "";

    /* renamed from: i, reason: collision with root package name */
    public static ConcurrentHashMap<String, LinkedBlockingQueue<Object>> f40738i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f40739j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public static int f40740k = 0;
}
