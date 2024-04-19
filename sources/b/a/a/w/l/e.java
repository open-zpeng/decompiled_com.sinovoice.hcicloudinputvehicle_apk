package b.a.a.w.l;

import b.a.a.o;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class e extends JsonReader {

    /* renamed from: a  reason: collision with root package name */
    private static final Reader f101a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f102b = new Object();
    private Object[] c;
    private int d;
    private String[] e;
    private int[] f;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    private void a(JsonToken jsonToken) {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private Object b() {
        return this.c[this.d - 1];
    }

    private Object c() {
        Object[] objArr = this.c;
        int i = this.d - 1;
        this.d = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private void e(Object obj) {
        int i = this.d;
        Object[] objArr = this.c;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[i * 2];
            int[] iArr = new int[i * 2];
            String[] strArr = new String[i * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f, 0, iArr, 0, this.d);
            System.arraycopy(this.e, 0, strArr, 0, this.d);
            this.c = objArr2;
            this.f = iArr;
            this.e = strArr;
        }
        Object[] objArr3 = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        objArr3[i2] = obj;
    }

    private String locationString() {
        return " at path " + getPath();
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        a(JsonToken.BEGIN_ARRAY);
        e(((b.a.a.g) b()).iterator());
        this.f[this.d - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        a(JsonToken.BEGIN_OBJECT);
        e(((b.a.a.m) b()).i().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c = new Object[]{f102b};
        this.d = 1;
    }

    public void d() {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) b()).next();
        e(entry.getValue());
        e(new o((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        a(JsonToken.END_ARRAY);
        c();
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        a(JsonToken.END_OBJECT);
        c();
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.d) {
            Object[] objArr = this.c;
            if (objArr[i] instanceof b.a.a.g) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof b.a.a.m) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.e;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        a(JsonToken.BOOLEAN);
        boolean h = ((o) c()).h();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return h;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        double j = ((o) b()).j();
        if (!isLenient() && (Double.isNaN(j) || Double.isInfinite(j))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + j);
        }
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return j;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        int k = ((o) b()).k();
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return k;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        long l = ((o) b()).l();
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return l;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) b()).next();
        String str = (String) entry.getKey();
        this.e[this.d - 1] = str;
        e(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        a(JsonToken.NULL);
        c();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        String n = ((o) c()).n();
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return n;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.d == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object b2 = b();
        if (b2 instanceof Iterator) {
            boolean z = this.c[this.d - 2] instanceof b.a.a.m;
            Iterator it = (Iterator) b2;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                e(it.next());
                return peek();
            }
        } else if (b2 instanceof b.a.a.m) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (b2 instanceof b.a.a.g) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (b2 instanceof o) {
                o oVar = (o) b2;
                if (oVar.s()) {
                    return JsonToken.STRING;
                }
                if (oVar.o()) {
                    return JsonToken.BOOLEAN;
                }
                if (oVar.q()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (b2 instanceof b.a.a.l) {
                return JsonToken.NULL;
            } else {
                if (b2 == f102b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.e[this.d - 2] = "null";
        } else {
            c();
            int i = this.d;
            if (i > 0) {
                this.e[i - 1] = "null";
            }
        }
        int i2 = this.d;
        if (i2 > 0) {
            int[] iArr = this.f;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return e.class.getSimpleName();
    }
}
