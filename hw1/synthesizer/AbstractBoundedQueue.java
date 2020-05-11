package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /**這次HW中abstract class的目的是把interface不能裝的變數放進來，再讓ArrayRB去extend，
     * 而autoGrader不希望我們用abstract method(abstract method的東西一定要被Override)去複寫enqueue等API
     * ，其實還是可以這麼做，但是有點多此一舉。
     */
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }
}
