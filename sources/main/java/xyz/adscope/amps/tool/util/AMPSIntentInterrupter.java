package xyz.adscope.amps.tool.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class AMPSIntentInterrupter {
    private PrefixTrie trie;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.amps.tool.util.AMPSIntentInterrupter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InterruptHolder {
        private static final AMPSIntentInterrupter INSTANCE = new AMPSIntentInterrupter(null);

        private InterruptHolder() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PrefixTrie {
        private TrieNode root;

        private PrefixTrie() {
            this.root = new TrieNode(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean startsWithAny(String str) {
            TrieNode trieNode = this.root;
            for (char c6 : str.toCharArray()) {
                trieNode = trieNode.children.get(Character.valueOf(c6));
                if (trieNode == null) {
                    return false;
                }
                if (trieNode.isEndOfWord) {
                    return true;
                }
            }
            return false;
        }

        /* synthetic */ PrefixTrie(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void insert(String str) {
            if (!TextUtils.isEmpty(str)) {
                TrieNode trieNode = this.root;
                for (char c6 : str.toCharArray()) {
                    TrieNode trieNode2 = trieNode.children.get(Character.valueOf(c6));
                    if (trieNode2 == null) {
                        trieNode2 = new TrieNode(null);
                        trieNode.children.put(Character.valueOf(c6), trieNode2);
                    }
                    trieNode = trieNode2;
                }
                trieNode.isEndOfWord = true;
            }
        }
    }

    /* synthetic */ AMPSIntentInterrupter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void initInterrupter(List<String> list) {
        AnonymousClass1 anonymousClass1 = null;
        if (list == null || list.isEmpty()) {
            this.trie = null;
            return;
        }
        this.trie = new PrefixTrie(anonymousClass1);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.trie.insert(it.next());
        }
    }

    public boolean interruptRpkDeeplink(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if (interruptByComponentName(context, intent)) {
                    return true;
                }
                return interruptBlackList(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    private AMPSIntentInterrupter() {
    }

    private boolean interruptBlackList(Intent intent) {
        Uri data;
        if (!"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null || TextUtils.isEmpty(data.toString())) {
            return false;
        }
        return interruptData(data.toString());
    }

    private boolean interruptData(String str) {
        PrefixTrie prefixTrie = this.trie;
        if (prefixTrie != null) {
            return prefixTrie.startsWithAny(str);
        }
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        private TrieNode() {
            this.children = new HashMap();
            this.isEndOfWord = false;
        }

        /* synthetic */ TrieNode(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static AMPSIntentInterrupter getInstance() {
        return InterruptHolder.INSTANCE;
    }

    private boolean interruptByComponentName(Context context, Intent intent) {
        if (intent.getComponent() != null) {
            return !isAppInternalIntent(context, r2);
        }
        return false;
    }

    private boolean isAppInternalIntent(Context context, ComponentName componentName) {
        return componentName.getPackageName().equals(context.getPackageName());
    }
}
