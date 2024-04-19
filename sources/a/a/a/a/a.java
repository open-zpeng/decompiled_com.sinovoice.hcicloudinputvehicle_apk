package a.a.a.a;

import a.a.a.a.b;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
/* compiled from: FastSafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.d<K, V>> e = new HashMap<>();

    public boolean contains(K k) {
        return this.e.containsKey(k);
    }
}
