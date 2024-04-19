package b.a.a.w;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable> f75a = new a();

    /* renamed from: b  reason: collision with root package name */
    Comparator<? super K> f76b;
    e<K, V> c;
    int d;
    int e;
    final e<K, V> f;
    private g<K, V>.b g;
    private g<K, V>.c h;

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends g<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c;
            if ((obj instanceof Map.Entry) && (c = g.this.c((Map.Entry) obj)) != null) {
                g.this.f(c, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.d;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends g<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f79a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f80b = null;
        int c;

        d() {
            this.f79a = g.this.f.d;
            this.c = g.this.e;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f79a;
            g gVar = g.this;
            if (eVar != gVar.f) {
                if (gVar.e == this.c) {
                    this.f79a = eVar.d;
                    this.f80b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f79a != g.this.f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f80b;
            if (eVar != null) {
                g.this.f(eVar, true);
                this.f80b = null;
                this.c = g.this.e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public g() {
        this(f75a);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f82b;
            e<K, V> eVar3 = eVar.c;
            int i = eVar2 != null ? eVar2.h : 0;
            int i2 = eVar3 != null ? eVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.f82b;
                e<K, V> eVar5 = eVar3.c;
                int i4 = (eVar4 != null ? eVar4.h : 0) - (eVar5 != null ? eVar5.h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    j(eVar3);
                    i(eVar);
                } else {
                    i(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.f82b;
                e<K, V> eVar7 = eVar2.c;
                int i5 = (eVar6 != null ? eVar6.h : 0) - (eVar7 != null ? eVar7.h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    i(eVar2);
                    j(eVar);
                } else {
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f81a;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f81a;
        eVar.f81a = null;
        if (eVar2 != null) {
            eVar2.f81a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f82b == eVar) {
                eVar3.f82b = eVar2;
                return;
            } else {
                eVar3.c = eVar2;
                return;
            }
        }
        this.c = eVar2;
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f82b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar3.f82b;
        e<K, V> eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.f81a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f82b = eVar;
        eVar.f81a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.h : 0, eVar4 != null ? eVar4.h : 0) + 1;
        eVar.h = max;
        eVar3.h = Math.max(max, eVar5 != null ? eVar5.h : 0) + 1;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f82b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar2.f82b;
        e<K, V> eVar5 = eVar2.c;
        eVar.f82b = eVar5;
        if (eVar5 != null) {
            eVar5.f81a = eVar;
        }
        h(eVar, eVar2);
        eVar2.c = eVar;
        eVar.f81a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.h : 0, eVar5 != null ? eVar5.h : 0) + 1;
        eVar.h = max;
        eVar2.h = Math.max(max, eVar4 != null ? eVar4.h : 0) + 1;
    }

    e<K, V> b(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f76b;
        e<K, V> eVar2 = this.c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f75a ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(eVar2.f);
                } else {
                    i = comparator.compare(k, (K) eVar2.f);
                }
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.f82b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.f;
            if (eVar2 == null) {
                if (comparator == f75a && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k, eVar4, eVar4.e);
                this.c = eVar;
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.e);
                if (i < 0) {
                    eVar2.f82b = eVar;
                } else {
                    eVar2.c = eVar;
                }
                e(eVar2, true);
            }
            this.d++;
            this.e++;
            return eVar;
        }
        return null;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> d2 = d(entry.getKey());
        if (d2 != null && a(d2.g, entry.getValue())) {
            return d2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.c = null;
        this.d = 0;
        this.e++;
        e<K, V> eVar = this.f;
        eVar.e = eVar;
        eVar.d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b bVar = this.g;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.g = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.e;
            eVar2.d = eVar.d;
            eVar.d.e = eVar2;
        }
        e<K, V> eVar3 = eVar.f82b;
        e<K, V> eVar4 = eVar.c;
        e<K, V> eVar5 = eVar.f81a;
        int i2 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.h > eVar4.h ? eVar3.b() : eVar4.a();
            f(b2, false);
            e<K, V> eVar6 = eVar.f82b;
            if (eVar6 != null) {
                i = eVar6.h;
                b2.f82b = eVar6;
                eVar6.f81a = b2;
                eVar.f82b = null;
            } else {
                i = 0;
            }
            e<K, V> eVar7 = eVar.c;
            if (eVar7 != null) {
                i2 = eVar7.h;
                b2.c = eVar7;
                eVar7.f81a = b2;
                eVar.c = null;
            }
            b2.h = Math.max(i, i2) + 1;
            h(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            h(eVar, eVar3);
            eVar.f82b = null;
        } else if (eVar4 != null) {
            h(eVar, eVar4);
            eVar.c = null;
        } else {
            h(eVar, null);
        }
        e(eVar5, false);
        this.d--;
        this.e++;
    }

    e<K, V> g(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            f(d2, true);
        }
        return d2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c cVar = this.h;
        if (cVar != null) {
            return cVar;
        }
        g<K, V>.c cVar2 = new c();
        this.h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> b2 = b(k, true);
        V v2 = b2.g;
        b2.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> g = g(obj);
        if (g != null) {
            return g.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    public g(Comparator<? super K> comparator) {
        this.d = 0;
        this.e = 0;
        this.f = new e<>();
        this.f76b = comparator == null ? f75a : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f81a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f82b;
        e<K, V> c;
        e<K, V> d;
        e<K, V> e;
        final K f;
        V g;
        int h;

        e() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f82b; eVar2 != null; eVar2 = eVar2.f82b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.c; eVar2 != null; eVar2 = eVar2.c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.g;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.g;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f81a = eVar;
            this.f = k;
            this.h = 1;
            this.d = eVar2;
            this.e = eVar3;
            eVar3.d = this;
            eVar2.e = this;
        }
    }
}
