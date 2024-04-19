package b.a.a.w.l;

import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class i implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.w.c f112a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.d f113b;
    private final b.a.a.w.d c;
    private final d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a extends c {
        final /* synthetic */ Field d;
        final /* synthetic */ boolean e;
        final /* synthetic */ t f;
        final /* synthetic */ b.a.a.e g;
        final /* synthetic */ b.a.a.x.a h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, t tVar, b.a.a.e eVar, b.a.a.x.a aVar, boolean z4) {
            super(str, z, z2);
            this.d = field;
            this.e = z3;
            this.f = tVar;
            this.g = eVar;
            this.h = aVar;
            this.i = z4;
        }

        @Override // b.a.a.w.l.i.c
        void a(JsonReader jsonReader, Object obj) {
            Object b2 = this.f.b(jsonReader);
            if (b2 == null && this.i) {
                return;
            }
            this.d.set(obj, b2);
        }

        @Override // b.a.a.w.l.i.c
        void b(JsonWriter jsonWriter, Object obj) {
            (this.e ? this.f : new m(this.g, this.f, this.h.e())).d(jsonWriter, this.d.get(obj));
        }

        @Override // b.a.a.w.l.i.c
        public boolean c(Object obj) {
            return this.f117b && this.d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b.a.a.w.h<T> f114a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, c> f115b;

        b(b.a.a.w.h<T> hVar, Map<String, c> map) {
            this.f114a = hVar;
            this.f115b = map;
        }

        @Override // b.a.a.t
        public T b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T a2 = this.f114a.a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    c cVar = this.f115b.get(jsonReader.nextName());
                    if (cVar != null && cVar.c) {
                        cVar.a(jsonReader, a2);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return a2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new r(e2);
            }
        }

        @Override // b.a.a.t
        public void d(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (c cVar : this.f115b.values()) {
                    if (cVar.c(t)) {
                        jsonWriter.name(cVar.f116a);
                        cVar.b(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f116a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f117b;
        final boolean c;

        protected c(String str, boolean z, boolean z2) {
            this.f116a = str;
            this.f117b = z;
            this.c = z2;
        }

        abstract void a(JsonReader jsonReader, Object obj);

        abstract void b(JsonWriter jsonWriter, Object obj);

        abstract boolean c(Object obj);
    }

    public i(b.a.a.w.c cVar, b.a.a.d dVar, b.a.a.w.d dVar2, d dVar3) {
        this.f112a = cVar;
        this.f113b = dVar;
        this.c = dVar2;
        this.d = dVar3;
    }

    private c b(b.a.a.e eVar, Field field, String str, b.a.a.x.a<?> aVar, boolean z, boolean z2) {
        boolean b2 = b.a.a.w.i.b(aVar.c());
        b.a.a.v.b bVar = (b.a.a.v.b) field.getAnnotation(b.a.a.v.b.class);
        t<?> b3 = bVar != null ? this.d.b(this.f112a, eVar, aVar, bVar) : null;
        boolean z3 = b3 != null;
        if (b3 == null) {
            b3 = eVar.k(aVar);
        }
        return new a(str, z, z2, field, z3, b3, eVar, aVar, b2);
    }

    static boolean d(Field field, boolean z, b.a.a.w.d dVar) {
        return (dVar.c(field.getType(), z) || dVar.d(field, z)) ? false : true;
    }

    private Map<String, c> e(b.a.a.e eVar, b.a.a.x.a<?> aVar, Class<?> cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type e = aVar.e();
        b.a.a.x.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean c2 = c(field, true);
                boolean c3 = c(field, z);
                if (c2 || c3) {
                    field.setAccessible(true);
                    Type p = b.a.a.w.b.p(aVar2.e(), cls2, field.getGenericType());
                    List<String> f = f(field);
                    int size = f.size();
                    c cVar2 = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = f.get(i2);
                        boolean z2 = i2 != 0 ? false : c2;
                        int i3 = i2;
                        c cVar3 = cVar2;
                        int i4 = size;
                        List<String> list = f;
                        Field field2 = field;
                        cVar2 = cVar3 == null ? (c) linkedHashMap.put(str, b(eVar, field, str, b.a.a.x.a.b(p), z2, c3)) : cVar3;
                        i2 = i3 + 1;
                        c2 = z2;
                        f = list;
                        size = i4;
                        field = field2;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(e + " declares multiple JSON fields named " + cVar.f116a);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = b.a.a.x.a.b(b.a.a.w.b.p(aVar2.e(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.c();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        b.a.a.v.c cVar = (b.a.a.v.c) field.getAnnotation(b.a.a.v.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f113b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
        Class<? super T> c2 = aVar.c();
        if (Object.class.isAssignableFrom(c2)) {
            return new b(this.f112a.a(aVar), e(eVar, aVar, c2));
        }
        return null;
    }

    public boolean c(Field field, boolean z) {
        return d(field, z, this.c);
    }
}
