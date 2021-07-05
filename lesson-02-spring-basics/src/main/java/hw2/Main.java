package hw2;

import com.sun.security.jgss.GSSUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.AppConfig;
import ru.geekbrains.Camera;

import java.text.spi.BreakIteratorProvider;
import java.util.Scanner;

public class Main  {


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("hw2");

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        System.out.println("Добро подаловать в наш магазин!!!");

        Scanner scanner = new Scanner(System.in);

        while (true){
            Cart cart = context.getBean(Cart.class);
            while (true){
                System.out.println("Выберите товар");
                productRepository.findAll().forEach(System.out::println);
                long q = scanner.nextLong();
                Product product = productRepository.findById(q);
                cart.add(product);
                System.out.println("Выберите действие: Купить(B) , Удалить(D) , Добавить(A) ");
                String action = scanner.next();
                if("B".equalsIgnoreCase(action)){
                    cart.findAll().forEach(System.out::println);
                    break;

                }else if("D".equalsIgnoreCase(action)){
                    System.out.println("Выберите товар для удалением");
                    cart.findAll().forEach(System.out::println);
                    long r = scanner.nextLong();
                    cart.delete(r);
                    System.out.println("Товар удален из корзины");
                }
            }
            System.out.println("Сделать еще заказ?  ДА(Y)");
            String j = scanner.next();
            if(!"Y".equalsIgnoreCase(j)){
                break;
            }
        }




    }
}
