package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProductHandler {

    public static void main(String[] args) throws NoSuchMethodException {
        ProductInfo productInfo = new ProductInfo();
        Class<? extends ProductInfo> infoClass = productInfo.getClass();
        getAnnot(infoClass);
        Method method = infoClass.getMethod("getData");
        getAnnot(method);
    }

    static void getAnnot(AnnotatedElement element) {

        try  {

            Annotation[] annotations = element.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Product product) {
                    System.out.printf("Product: %s, quota: %d%n",
                            product.name(), product.quota());
                }
            }
        } catch (Exception e) {
            System.out.println("Something was wrong: " + e.getMessage());
        }
    }
}
