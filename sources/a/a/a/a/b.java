package a.a.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private d<K, V> f0a;

    /* renamed from: b  reason: collision with root package name */
    private d<K, V> f1b;
    private WeakHashMap<?, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0000b<K, V> extends f<K, V> {
        C0000b(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // a.a.a.a.b.f
        d<K, V> a(d<K, V> dVar) {
            throw null;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static class c<K, V> extends f<K, V> {
        c(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // a.a.a.a.b.f
        d<K, V> a(d<K, V> dVar) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class d<K, V> implements Map.Entry<K, V> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class e implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private d<K, V> f2a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3b;

        private e() {
            this.f3b = true;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.f3b) {
                this.f3b = false;
                d unused = b.this.f0a;
            } else if (this.f2a != null) {
                throw null;
            }
            return this.f2a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f3b) {
                return b.this.f0a != null;
            } else if (this.f2a == null) {
                return false;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        d<K, V> f4a;

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f5b;

        f(d<K, V> dVar, d<K, V> dVar2) {
        }

        private d<K, V> c() {
            d<K, V> dVar = this.f5b;
            d<K, V> dVar2 = this.f4a;
            if (dVar == dVar2 || dVar2 == null) {
                return null;
            }
            return a(dVar);
        }

        abstract d<K, V> a(d<K, V> dVar);

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            d<K, V> dVar = this.f5b;
            c();
            return dVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5b != null;
        }
    }

    public Iterator<Map.Entry<K, V>> b() {
        c cVar = new c(this.f1b, this.f0a);
        this.c.put(cVar, Boolean.FALSE);
        return cVar;
    }

    public Map.Entry<K, V> c() {
        return this.f0a;
    }

    public b<K, V>.e d() {
        b<K, V>.e eVar = new e();
        this.c.put(eVar, Boolean.FALSE);
        return eVar;
    }

    public Map.Entry<K, V> e() {
        return this.f1b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        C0000b c0000b = new C0000b(this.f0a, this.f1b);
        this.c.put(c0000b, Boolean.FALSE);
        return c0000b;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
