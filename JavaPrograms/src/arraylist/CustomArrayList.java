package arraylist;

public class CustomArrayList<T>{

    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY=10;

    public CustomArrayList(){
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size=0;
    }


    public CustomArrayList(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.elements = new Object[capacity];
        this.size=0;
    }

    private void checkCapacity(){
        double loadFactor = (double) size /elements.length;

        if(loadFactor >=0.75){
            Object[] newElements = new Object[2* elements.length];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= elements.length){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
    }


    public  int size(){
        return size;
    }

    public void add(T element){
        checkCapacity();
        elements[size++]=element;
    }

    public void removeAt(int index){
        checkIndex(index);
        for(int i=index;i<size-1;i++){
           elements[i]=elements[i+1];
        }
        elements[--size]=null;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];
    }

    public void display(){
        System.out.print("[");
        for(int i=0;i<= size-1;i++){
            System.out.print(elements[i]);
            if(i < size-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
