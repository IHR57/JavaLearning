package OpenClosed;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {

    public Stream<Product> filterByColor(List<Product> productList, Color color) {
        return productList.stream().filter(product -> product.color == color);
    }

    public Stream<Product> filterBySize(List<Product> productList, Size size) {
        return productList.stream().filter(product -> product.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> productList, Color color,
                                                Size size) {
        return productList.stream().filter(product -> product.color == color &&
                product.size == size);
    }
}
