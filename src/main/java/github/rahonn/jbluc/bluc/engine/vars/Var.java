package github.rahonn.jbluc.bluc.engine.vars;

public class Var<T> {

    private T data;

    public Var(T data) {

        this.data = data;

    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    @Override
    public boolean equals(Object o) {
        return data.equals(o);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
