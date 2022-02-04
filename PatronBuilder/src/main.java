interface Builder {
    Product build();
    ConcreteBuilder setName(String name);
    ConcreteBuilder setColor(String color);
}

class ConcreteBuilder implements Builder {
    private Product product;

    ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public Product build() {
        Product product = new Product();
        product.setColor(this.product.getColor());
        product.setName(this.product.getName());
        return product;
    }

    @Override
    public ConcreteBuilder setColor(final String color) {
        product.setColor(color);
        return this;
    }

    @Override
    public ConcreteBuilder setName(final String name) {
        product.setName(name);
        return this;
    }
}

class Product {
    // ...
}

public class Director {

    private Builder builder;

    private Director(final Builder builder) {
        this.builder = builder;
    }

    public static void main(final String ... arguments) {
        final Builder builder = new ConcreteBuilder();
        final Director director = new Director(builder);
        System.out.println(director.construct());
    }

    private Product construct() {
        return builder.setName("ProductA")
                .setColor("Red")
                .build();
    }
}