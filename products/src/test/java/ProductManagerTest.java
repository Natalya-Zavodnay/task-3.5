import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Сказка о царе Салтане", 300, "А.С.Пушкин");
    private Book book2 = new Book(2, "Меняя маски", 450, "Метельский");
    private Book book3 = new Book(3, "Мертвые души", 400, "Н.В.Гоголь");
    private Book book4 = new Book(4, "Евгений Онегин", 350, "А.С.Пушкин");
    private Smartphone smartphone1 = new Smartphone(5, "iPhone", 31000, "Apple");
    private Smartphone smartphone2 = new Smartphone(6, "Samsung", 17000, "Samsung");
    private Smartphone smartphone3 = new Smartphone(7, "Honor", 14000, "Huawei");

    @BeforeEach
    public void shouldAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Мертвые души");
        Product[] expected = new Product[] {book3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByAuthorMoreThatOne() {
        Product[] actual = manager.searchBy("А.С.Пушкин");
        Product[] expected = new Product[] {book1, book4};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[] {smartphone1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[] {smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNonExistedProduct() {
        Product[] actual = manager.searchBy("Лев Толстой");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}