package tree;

@FunctionalInterface
public interface Parser<T> {
    T parse(String token);
}