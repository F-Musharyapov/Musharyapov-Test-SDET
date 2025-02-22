package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов формы
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface FormTestConfig extends Config {

    /**
     * Метод возвращает параметр firstName из form_test_config.properties
     *
     * @return параметр поля ввода First Name
     */
    String firstName();

    /**
     * Метод возвращает параметр inputLastName из form_test_config.properties
     *
     * @return параметр поля ввода Last Name
     */
    String inputLastName();

    /**
     * Метод возвращает параметр inputUserEmail из form_test_config.properties
     *
     * @return параметр поля ввода User Email
     */
    String inputUserEmail();

    /**
     * Метод возвращает параметр inputUserNumber из form_test_config.properties
     *
     * @return параметр поля ввода User Number
     */
    String inputUserNumber();

    /**
     * Метод возвращает параметр inputSubjects из form_test_config.properties
     *
     * @return параметр поля ввода Subjects
     */
    String inputSubjects();

    /**
     * Метод возвращает параметр testPicture из form_test_config.properties
     *
     * @return параметр поля загрузки изображения Picture
     */
    String testPicture();

    /**
     * Метод возвращает параметр inputCurrentAddress из form_test_config.properties
     *
     * @return параметр поля ввода Current Address
     */
    String inputCurrentAddress();

}
