package org.example;

import org.example.hibernate_test.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.mindrot.jbcrypt.BCrypt;

public class Test {
    static int КолвоЭлементовКласса;
    static int identificator;
    static String password_0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String inputMenu;
        String inputMenu2;


        do {

            System.out.println("Введите:\n1 - для регистрации;\n2 - для авторизации;\n0 - для выхода");

            inputMenu = scanner.nextLine();


            if (inputMenu.equals("1")) {
                System.out.println("Регистрация");
                System.out.println("Для продолжения регистрации нажмите 1, для отказа продолжать регистрацию нажмите любое значение, отличное от 1");
                inputMenu2 = scanner2.nextLine();
                if (inputMenu2.equals("1")) {

                    Configuration configuration = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);
                    SessionFactory factory100 = configuration.buildSessionFactory();

                    Session session100 = null;

                    try {
                        session100 = factory100.getCurrentSession();
                        session100.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session100.createQuery("from Users").getResultList();

                        КолвоЭлементовКласса = users.size();
                        session100.getTransaction().commit();
                    } finally {
                        session100.close();
                        factory100.close();

                    }

                    Configuration configuration11 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);


                    SessionFactory factory = configuration11.buildSessionFactory();

                    try {
                        Session session = factory.getCurrentSession();

                        String a1;
                        String a2;
                        Users user = new Users();
                        do {
                            do {

                                System.out.println("Введите фамилию.  Формат - первая буква - заглавная."); // Формат  первая буква - заглавная
                                Scanner input = new Scanner(System.in);

                                while (!user.setSurname(input.nextLine())) ;

                                System.out.println("Вы ввели фамилию: " + user.getSurname());
                                System.out.println("Если фамилия введена неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = input.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Фамилия зафиксирована");
                            System.out.println("Зафиксированная фамилия - " + user.getSurname());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                System.out.println("Введите имя.  Формат - первая буква - заглавная."); // Формат  первая буква - заглавная
                                Scanner input = new Scanner(System.in);

                                while (!user.setName(input.nextLine())) ;

                                System.out.println("Вы ввели имя: " + user.getName());
                                System.out.println("Если имя введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = input.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Имя зафиксировано");
                            System.out.println("Зафиксированная имя - " + user.getName());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {
                                System.out.println("Введите отчество.  Формат - первая буква - заглавная.");
                                Scanner input = new Scanner(System.in);
                                while (!user.setPatronymic(input.nextLine())) ;
                                System.out.println("Вы ввели отчество: " + user.getPatronymic());
                                System.out.println("Если отчество введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = input.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Отчество зафиксировано");
                            System.out.println("Зафиксированное отчество - " + user.getPatronymic());
                            System.out.println("_______________________________________________________________________________");

//_____________________________________________________________________________________________________________________________
                            do {

                                boolean nonunicemail;
                                Scanner input2 = new Scanner(System.in);
                                do {
                                    nonunicemail = false;

                                    System.out.println("Введите email (значение не может быть пустым)"); // Формат  первая буква - заглавная


                                    while (!user.setEmail(input2.nextLine().toLowerCase())) ;

                                    Configuration configuration2 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory4 = configuration2.buildSessionFactory();

                                    Session session11 = null;
                                    try {
                                        session11 = factory4.getCurrentSession();
                                        session11.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session11.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getEmail().equals(user.getEmail())) {
                                                nonunicemail = true;
                                                System.out.println("Пользователь с таким email уже добавлен. Введите другое значение email ");
                                            }
                                        }
                                        session11.getTransaction().commit();


                                    } finally {
                                        session11.close();
                                        factory4.close();
                                    }
                                }
                                while (nonunicemail);

                                System.out.println("Вы ввели email: " + user.getEmail());

                                System.out.println("Если email введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("email зафиксирован");
                            System.out.println("Зафиксированный email - " + user.getEmail());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                boolean nonunic_telephone_number;
                                Scanner input2 = new Scanner(System.in);
                                do {
                                    nonunic_telephone_number = false;


                                    System.out.println("Введите номер телефона в формате 8-ХХХ-ХХХ-ХХ-ХХ или +7-ХХХ-ХХХ-ХХ-ХХ, значение не может быть пустым");

                                    while (!user.setTelephone_number(input2.nextLine())) ;


                                    Configuration configuration3 = new Configuration().
                                            addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory5 = configuration3.buildSessionFactory();

                                    Session session12 = null;
                                    try {
                                        session12 = factory5.getCurrentSession();
                                        session12.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session12.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getTelephone_number().equals(user.getTelephone_number())) {
                                                nonunic_telephone_number = true;
                                                System.out.println("Пользователь с таким номером телефона уже зарегистрирован. Введите другое значение номера телефона ");
                                            }
                                        }
                                        session12.getTransaction().commit();


                                    } finally {
                                        session12.close();
                                        factory5.close();
                                    }
                                }
                                while (nonunic_telephone_number);
                                System.out.println("Вы ввели номер телефона: " + user.getTelephone_number() + " (если номер телефона был введен в формате 8-ХХХ-ХХХ-ХХ-ХХ, то он преобразован в формат +7-ХХХ-ХХХ-ХХ-ХХ для универсальности)");
                                System.out.println("Если номер телефона введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("номер телефона зафиксирован");
                            System.out.println("Зафиксированный номер телефона -" + user.getTelephone_number());
                            System.out.println("_______________________________________________________________________________");


//_____________________________________________________________________________________________________________________________
                            if (КолвоЭлементовКласса == 0) {
                                user.setRole("администратор");
                            } else {
                                user.setRole("пользователь");
                            }
//_____________________________________________________________________________________________________________________________

                            do {

                                boolean nonuniclogin;
                                Scanner input2 = new Scanner(System.in);
                                do {
                                    nonuniclogin = false;

                                    System.out.println("Введите логин (значение не может быть пустым)");

                                    while (!user.setLogin(input2.nextLine())) ;

                                    Configuration configuration4 =
                                            new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                    SessionFactory factory3 = configuration4.buildSessionFactory();

                                    Session session1 = null;
                                    try {
                                        session1 = factory3.getCurrentSession();
                                        session1.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session1.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getLogin().equals(user.getLogin())) {
                                                nonuniclogin = true;
                                                System.out.println("Пользователь с таким логином уже добавлен. Введите другое значение логина");
                                            }
                                        }
                                        session1.getTransaction().commit();

                                    } finally {
                                        session1.close();
                                        factory3.close();
                                    }
                                }
                                while (nonuniclogin);

                                System.out.println("Вы ввели login: " + user.getLogin());

                                System.out.println("Если login введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = scanner.nextLine();

                            }
                            while (a1.equals("0"));
                            System.out.println("Логин зафиксирован");
                            System.out.println("Зафиксированный логин - " + user.getLogin());
                            System.out.println("_______________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            do {

                                System.out.println("Введите пароль");
                                Scanner input3 = new Scanner(System.in);
                                String password100 = input3.nextLine();
                                password_0 = password100;
                                String salt = BCrypt.gensalt();

                                String hashedPassword = BCrypt.hashpw(password100, salt);

                                while (!user.setPassword(hashedPassword)) ;
                                System.out.println("Вы ввели пароль: " + password_0);
                                System.out.println("Если пароль введен неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                System.out.println("_______________________________________________________________________________");
                                a1 = input3.nextLine();
                            }
                            while (a1.equals("0"));
                            System.out.println("Пароль зафиксирован");

                            System.out.println("_________________________________________________________________________________________________");
//_____________________________________________________________________________________________________________________________
                            System.out.println("_________________________________________________________________________________________________");
                            System.out.println("Итоговая проверка введенных данных регистрации:");
                            System.out.println("Вы ввели фамилию: " + user.getSurname());
                            System.out.println("Вы ввели имя: " + user.getName());
                            System.out.println("Вы ввели отчество: " + user.getPatronymic());
                            System.out.println("Вы ввели номер телефона: " + user.getTelephone_number());
                            System.out.println("Вы ввели адрес электронной почты: " + user.getEmail());
                            System.out.println("Вы ввели login: " + user.getLogin());
                            System.out.println("Вы ввели пароль: " + password_0);

                            System.out.println("Если необходимо откорректировать данные регистрации (есть ошибка) - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                            Scanner in = new Scanner(System.in);
                            a2 = in.nextLine();
                        }

                        while (a2.equals("0"));

                        System.out.println("_______________________________________________________________________________");
                        System.out.println("Данные о пользователе зафиксированы");
//_____________________________________________________________________________________________________________________________

                        session.beginTransaction();
                        session.persist(user);

                        session.getTransaction().commit();

                        System.out.println("Регистрация пользователя завершена, информация о пользователе записана в базу данных");
                        System.out.println(user);

                    } finally {
                        factory.close();
                    }

                }

//_____________________________________________________________________________________________________________________________
            } else if (inputMenu.equals("2")) {


                System.out.println("Авторизация");

                System.out.println("Для продолжения авторизации нажмите 2, для отказа продолжать авторизацию нажмите любое значение, отличное от 2");
                inputMenu2 = scanner2.nextLine();
                if (inputMenu2.equals("2")) {

                    System.out.println("Введите login или email или номер телефона (в формате 8-ХХХ-ХХХ-ХХ-ХХ или +7-ХХХ-ХХХ-ХХ-ХХ)");

                    Scanner input5 = new Scanner(System.in);
                    String login = input5.nextLine();
                    System.out.println("Вы ввели - " + login);

                    if (login.matches("(\\+7|8)-\\d{3}-\\d{3}-\\d{2}-\\d{2}")) {
                        if (login.length() == 16) {
                            login = login.substring(3);
                        } else if ((login.length() == 15)) {
                            login = login.substring(2);
                        }
                    }

                    System.out.println("Введите пароль");
                    String passwordAuth = input5.nextLine();

                    Configuration configuration5 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);


                    SessionFactory factory3 = configuration5.buildSessionFactory();

                    Session session4 = null;
                    try {
                        session4 = factory3.getCurrentSession();
                        session4.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session4.createQuery("from Users").getResultList();
                        if ((findUser1(login, passwordAuth, users)) || (findUser2(login, passwordAuth, users)) || (findUser3(login, passwordAuth, users))) {

                        } else {
                            System.out.println("Вы НЕ АВТОИЗОВАНЫ");
                        }
                        session4.getTransaction().commit();
                    } finally {
                        session4.close();
                        factory3.close();
                    }
                }
            } else if (inputMenu.equals("0")) {
            } else {
                System.out.println("Ни одно из условий не подошло");
            }

        }

        while (!inputMenu.equals("0"));
        System.out.println("Выход из программы осуществлен");

    }

    public static boolean findUser1(String login1, String password, List<Users> users) {


        for (Users us3 : users) {
            if ((us3.getLogin().equals(login1)) && (BCrypt.checkpw(password, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }

    public static boolean findUser2(String email, String password2, List<Users> users) {

        for (Users us3 : users) {
            if ((us3.getEmail().equals(email)) && (BCrypt.checkpw(password2, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }

    public static boolean findUser3(String telephone_number, String password3, List<Users> users) {

        for (Users us3 : users) {
            if ((us3.getTelephone_number().substring(3).equals(telephone_number)) && (BCrypt.checkpw(password3, us3.getPassword()))) {
                System.out.println("Здравствуйте " + us3.getName() + " " + us3.getSurname() + "! " + "Вы авторизованы. Ваша роль - " + us3.getRole() + ".");

                identificator = us3.getId();
                rabota_autoriz(users);

                return true;
            }
        }
        return false;
    }


    public static boolean rabota_autoriz(List<Users> users) {

        for (Users us3 : users) {

            if (us3.getId() == identificator) {
                if (us3.getRole().equals("администратор")) {
                    System.out.println("Для работы в меню администратора нажмите любую цифру, отличную от 0");

                    Scanner inp = new Scanner(System.in);
                    String z = inp.nextLine();

                    while (!z.equals("0")) {
                        do {
                            System.out.println("Введите:" +
                                    "\n1 - для просмотра списка всех категорий товаров;" +
                                    "\n2 - для добавление категории товаров;" +
                                    "\n3 - для добавления товара (товар можно добавить, если создана соответствующая категория товаров);" +
                                    "\n4 - для удаления товара по артикулу в списке (со списком товаров (который в т.ч. содержит артикул товара) можно ознакомиться, если нажать 5 в меню администратора);" +
                                    "\n5 - для просмотра информации о всех товарах;" +
                                    "\n6 - для просмотра информации о всех зарегистрированных пользователях;" +
                                    "\n7 - для смены роли пользователю (с информацией о пользователях (в т.ч. о том - у какого пользователя какая роль) можно ознакомиться, если нажать 6 в меню администратора);" +
                                    "\n8 - для просмотра списка заказов;" +
                                    "\n9 - для поиска заказа по номеру;" +
                                    "\n0 - для выхода из меню администратора");
                            z = inp.nextLine();
                            switch (z) {
                                case "1":
                                    Configuration configuration20 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory20 = configuration20.buildSessionFactory();

                                    Session session20 = null;
                                    try {
                                        session20 = factory20.getCurrentSession();
                                        session20.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session20.createQuery("from Category").getResultList();
                                        for (Category category : categoryList) {
                                            System.out.println(category);
                                        }
                                        session20.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session20.close();
                                        factory20.close();
                                    }

                                    break;

                                case "2":

                                    System.out.println("Добавление категории товаров");
                                    Category category = new Category();
                                    Scanner input100 = new Scanner(System.in);
                                    String a1;
                                    do {
                                        System.out.println("Введите наименование категории товара");


                                        boolean nonuniclogin;
                                        do {
                                            nonuniclogin = false;
                                            // System.out.println("Введите наименование категории товара");
                                            Scanner scanner = new Scanner(System.in);
                                            while (!category.setName(scanner.nextLine())) ;


                                            Configuration configuration6 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                            SessionFactory factory500 = configuration6.buildSessionFactory();

                                            Session session500 = null;
                                            try {
                                                session500 = factory500.getCurrentSession();
                                                session500.beginTransaction();

                                                List<Category> categories = new ArrayList<>();

                                                categories = session500.createQuery("from Category").getResultList();
                                                for (Category categ : categories) {
                                                    if (categ.getName().equals(category.getName())) {
                                                        nonuniclogin = true;
                                                        System.out.println("Такая категория товаров уже добавлена. Введите другое значение категории товаров");
                                                    }
                                                }
                                                session500.getTransaction().commit();

                                            } finally {
                                                session500.close();
                                                factory500.close();
                                            }

                                        }
                                        while (nonuniclogin);


                                        System.out.println("Вы ввели наименование категории: " + category.getName());

                                        System.out.println("Если наименование категории введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                        a1 = input100.nextLine();

                                    }
                                    while (a1.equals("0"));
                                    System.out.println("Наименование категории зафиксировано.");
                                    System.out.println("Зафиксированное наименование категории - " + category.getName());


                                    Configuration configuration7 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory700 = configuration7.buildSessionFactory();

                                    Session session700 = null;
                                    try {
                                        session700 = factory700.getCurrentSession();

                                        session700.beginTransaction();
                                        session700.persist(category);

                                        session700.getTransaction().commit();


                                    } finally {
                                        session700.close();
                                        factory700.close();
                                    }


                                    break;


                                case "3": // добавление товара

                                    String categor = null;


                                    Product product = new Product();

                                    Configuration configuration = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory5000 = configuration.buildSessionFactory();

                                    Session session5000 = null;
                                    String a2;
                                    try {
                                        session5000 = factory5000.getCurrentSession();
                                        session5000.beginTransaction();
                                        do {
                                            Boolean isInTable = false;
                                            int Ident;
                                            String b1;

                                            int Identificator;
                                            Category category1 = null;
                                            Scanner scanner = new Scanner(System.in);
                                            Scanner input2 = new Scanner(System.in);
//___________________________________________________________________________________________________________________________________________________________________________________________

                                            Scanner input4 = new Scanner(System.in);

//_____________________________________________________________________________________________________________________________________

                                            Configuration configuration123 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                            SessionFactory factory123 = configuration123.buildSessionFactory();

                                            Session session123 = null;
                                            try {
                                                session123 = factory123.getCurrentSession();
                                                session123.beginTransaction();

                                                Scanner console10000 = new Scanner(System.in);

                                                int value;
                                                do {
                                                    boolean isTrue = false;
                                                    Scanner scanner10000 = new Scanner(System.in);
                                                    do {
                                                        System.out.println("Введите id категории товара");
                                                        //__________________________________________________________________________________________
                                                        //проверка на тип "int"

                                                        while (!scanner10000.hasNextInt()) {
                                                            scanner10000.next();
                                                            System.out.println("Вы ввели не значение типа int, попробуйте еще раз");
                                                        }
                                                        value = scanner10000.nextInt();

                                                        List<Category> categories = session123.createQuery("from Category").getResultList();

                                                        for (Category cat : categories) {
                                                            if (cat.getId() == value) {
                                                                categor = cat.getName();
                                                                isTrue = true;

                                                            }
                                                            if (isTrue) {


                                                                categor = cat.getName();

                                                                break;
                                                            }
                                                        }
                                                        if (isTrue == false) {
                                                            System.out.println("Отсутствует категория товара с указанным Вами id");
                                                        }
                                                    }
                                                    //__________________________________________________________________________________________

                                                    //проверка на тип "true"
                                                    while (!isTrue);
                                                    category1 = session123.get(Category.class, value);
                                                    System.out.println("Вы ввели значение id = " + value + " ,что соответствует категории - " + categor); // вывод текста если введенное значение соответствует true


                                                    System.out.println("Если значение id введено неправильно - введите 0, иначе введите любое значение целого числа типа int, отличное от 0");
                                                    //проверка на тип "int", если хотим изменить введенное значение
                                                    while (!console10000.hasNextInt()) {
                                                        console10000.next();
                                                        System.out.println("Вы ввели не значение типа int, попробуйте еще раз");
                                                    }
                                                }
                                                while (console10000.nextInt() == 0);
                                                // здесь писать условие по сохранению при необходимости
                                                product.setCat(category1);
                                                session123.getTransaction().commit();

                                            } finally {
                                                session123.close();
                                                factory123.close();
                                            }

//________________________________________________________________________________________________________________________________________________________________________________

                                            do {
                                                Scanner input3 = new Scanner(System.in);
                                                System.out.println("Введите наименование товара (формат  - значение не должно быть пустым)"); // Формат  - значение не должно быть пустым

                                                while (!product.setProduct_name(input3.nextLine())) ;

                                                System.out.println("Вы ввели наименование товара: " + product.getProduct_name());
                                                System.out.println("Если наименование товара введено неправильно - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                                System.out.println("_______________________________________________________________________________");
                                                a1 = input3.nextLine();
                                            }
                                            while (a1.equals("0"));
                                            System.out.println("Наименование товара зафиксировано");
                                            System.out.println("Зафиксированное наименование товара - " + product.getProduct_name());
                                            System.out.println("_______________________________________________________________________________");
//__________________________________________________________________________________________________________________________________________________________________________________

                                            Scanner console = new Scanner(System.in);
                                            do {
                                                do {
                                                    System.out.println("Введите цену товара (значение должно быть положительным и типа double)");
                                                    while (!console.hasNextDouble()) {
                                                        console.next();
                                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                                    }
                                                }
                                                while (!product.setProduct_price(console.nextDouble()));

                                                System.out.println("Вы ввели цену: " + product.getProduct_price());
                                                System.out.println("Если цена введена неправильно - нажмите - 0, если все правильно - введите любое значение, отличное от 0");
                                            }
                                            while (console.nextDouble() == 0);
                                            System.out.println("Цена товара зафиксирована");
                                            System.out.println("Зафиксированная цена товара - " + product.getProduct_price());
                                            System.out.println("_________________________________________________________________________________________________");

//__________________________________________________________________________________________________________________________________________________________________________________


                                            Scanner console20000 = new Scanner(System.in);

                                            String valueArticul;
                                            do {
                                                boolean isUnic = false;
                                                Scanner scanner20000 = new Scanner(System.in);
                                                do {
                                                    int count = 0;
                                                    Configuration configuration124 = new Configuration()
                                                            .addAnnotatedClass(Users.class)
                                                            .addAnnotatedClass(Product.class)
                                                            .addAnnotatedClass(Category.class)
                                                            .addAnnotatedClass(Order.class)
                                                            .addAnnotatedClass(Status.class);


                                                    SessionFactory factory124 = configuration124.buildSessionFactory();

                                                    Session session124 = null;

                                                    try {
                                                        session124 = factory124.getCurrentSession();
                                                        session124.beginTransaction();
                                                        System.out.println("Введите артикул товара (формат ввода: первые 2 символа - заглавные буквы, остальные 4 символа - цифры)");


                                                        while (!product.setCode(scanner20000.nextLine())) ;


                                                        List<Product> productList = session124.createQuery("from Product").getResultList();

                                                        for (Product p : productList) {

                                                            if (p.getCode().equals(product.getCode())) {
                                                                count++;
                                                            }

                                                        }
                                                        if (count == 0) {
                                                            isUnic = true;
                                                        }


                                                        if (isUnic == false) {
                                                            System.out.println("Товар с указанным артикулом уже создан. Необходимо ввести другое значение артикула. ");
                                                        } else {
                                                            System.out.println("Вы ввели уникальное значение артикула");
                                                        }
                                                        session124.getTransaction().commit();

                                                    } finally {
                                                        session124.close();
                                                        factory124.close();
                                                    }
                                                }

                                                while (!isUnic);
                                                System.out.println("Вы ввели " + product.getCode()); // вывод текста если введенное значение соответствует true
                                                System.out.println("Если значение введено ошибочно (если необходимо откорректировать значение) - введите 0, если все верно - введите любое значение целого числа типа int, отличное от 0");

                                            }
                                            while (console20000.nextInt() == 0);

                                            System.out.println("Итоговая проверка введенных данных о товаре:");
                                            System.out.println("Вы ввели категорию товара: - " + categor);
                                            System.out.println("Вы ввели наименование товара: " + product.getProduct_name());
                                            System.out.println("Вы ввели цену: " + product.getProduct_price());
                                            System.out.println("Вы ввели артикул товара: " + product.getCode());

                                            System.out.println("Если необходимо откорректировать данные о товаре (есть ошибка) - нажмите 0, если все правильно - введите любое значение, отличное от 0");
                                            System.out.println("_________________________________________________________________________________________________");
                                            Scanner in = new Scanner(System.in);
                                            a2 = in.nextLine();

                                        } while (a2.equals("0"));

                                        System.out.println("_______________________________________________________________________________");
                                        System.out.println("Данные о товаре зафиксированы");

                                        session5000.persist(product);
                                        session5000.getTransaction().commit();
                                        System.out.println("Регистрация товара завершена, информация о товаре записана в базу данных");
//_____________________________________________________________________________________________________________________________________

                                    } finally {
                                        session5000.close();
                                        factory5000.close();
                                    }

                                    break;
                                case "4":

                                    Product product1000 = new Product();
                                    List<Product> products = new ArrayList<>();
                                    if (!deleteProdArtikul(product1000.getCode())) {
                                        System.out.println("Товара с таким артикулом нет в списке товаров");

                                    }


                                    break;

                                case "5"://информация о всех товарах из базы данных

                                    Configuration configuration5 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory200 = configuration5.buildSessionFactory();

                                    Session session200 = null;
                                    try {
                                        session200 = factory200.getCurrentSession();
                                        session200.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session200.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session200.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session200.close();
                                        factory200.close();
                                    }

                                    break;


                                case "6":
                                    //  "Информация о зарегистрированных пользователях:"

                                    Configuration configuration8 = new Configuration().
                                            addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory1 = configuration8.buildSessionFactory();

                                    Session session1 = null;
                                    try {
                                        session1 = factory1.getCurrentSession();
                                        session1.beginTransaction();

                                        List<Users> users32 = new ArrayList<>();

                                        users32 = session1.createQuery("from Users").getResultList();
                                        for (Users us32 : users32) {
                                            System.out.println(us32);
                                        }
                                        session1.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех зарегистрированных пользователях из базы данных");
                                    } finally {
                                        session1.close();
                                        factory1.close();
                                    }
                                    break;
                                case "7":
                                    System.out.println("Смена роли пользователю: (с информацией о пользователях (в т.ч.о том - у какого пользователя какая роль) можно ознакомиться, если нажать 4 в меню администратора)");
                                    if (!smenaRoli(us3.getId(), us3.getRole(), users)) {
                                        System.out.println("Пользователя с таким id нет среди зарегистрированных пользователей");
                                    }
                                    break;

                                case "8":

                                    Configuration configuration1150 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory1150 = configuration1150.buildSessionFactory();

                                    Session session1150 = null;
                                    try {
                                        session1150 = factory1150.getCurrentSession();
                                        session1150.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session1150.createQuery("from Order").getResultList();


                                        System.out.println("ИНФОРМАЦИЯ ОБО ВСЕХ ЗАКАЗАХ:");
                                        System.out.println();
                                        // Лист, чтобы разместить номера заказов без повтора
                                        HashSet<String> hashList = new HashSet<>();
                                        // Получаю номера всех заказов
                                        for (Order o : orderList) {
                                            // Заполняю поэлементно Hash лист
                                            hashList.add(o.getNumber());
                                        }

                                        for (String hl : hashList) {
                                            for (Order order : orderList) {
                                                if (hl.equals(order.getNumber())) {
                                                    System.out.println("Номер заказа: " + order.getNumber());
                                                    System.out.println("Статус заказа: " + order.getStatus());

                                                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                    String text = dtf1.format(order.getdAndT());
                                                    System.out.println("Дата и время заказа: " + text);
                                                    System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                    System.out.println("Список товаров заказа:");
                                                    price = 0;
                                                    for (Order order1 : orderList) {
                                                        if (order1.getNumber().equals(hl)) {
                                                            System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                            price = order1.getProduct().getProduct_price() + price;
                                                        }
                                                    }

                                                    System.out.println("Итоговая цена заказа: " + price);
                                                    break;
                                                }
                                            }
                                            System.out.println();
                                        }

                                        System.out.println("Итого количество заказов у всех пользователей: " + hashList.size());

                                        session1150.getTransaction().commit();

                                    } finally {
                                        session1150.close();
                                        factory1150.close();
                                    }
                                    System.out.println();


                                    break;

                                case "9":

                                    Configuration configuration1152 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory1152 = configuration1152.buildSessionFactory();

                                    Session session1152 = null;
                                    try {
                                        session1152 = factory1152.getCurrentSession();
                                        session1152.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session1152.createQuery("from Order").getResultList();

                                        System.out.println("Введите символы окончания номера заказа");
                                        Scanner console = new Scanner(System.in);
                                        String path = console.nextLine();
                                        // System.out.println("Введите символы окончания номера заказа");

                                        // Лист, чтобы разместить номера заказов без повтора
                                        HashSet<String> hashList = new HashSet<>();
                                        // Получаю номера всех заказов
                                        for (Order o : orderList) {
                                            // Заполняю поэлементно Hash лист
                                            hashList.add(o.getNumber());
                                        }

                                        for (String hl : hashList) {
                                            for (Order order : orderList) {
                                                if (hl.equals(order.getNumber()) && hl.endsWith(path)) {
                                                    System.out.println("Номер заказа: " + order.getNumber());
                                                    System.out.println("Статус заказа: " + order.getStatus());

                                                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                    String text = dtf1.format(order.getdAndT());
                                                    System.out.println("Дата и время заказа: " + text);
                                                    System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                    System.out.println("Список товаров заказа:");
                                                    price = 0;
                                                    for (Order order1 : orderList) {
                                                        if (order1.getNumber().equals(hl)) {
                                                            System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                            price = order1.getProduct().getProduct_price() + price;
                                                        }
                                                    }

                                                    System.out.println("Итоговая цена заказа: " + price);
                                                    break;
                                                }
                                            }

                                        }


                                        session1152.getTransaction().commit();

                                    } finally {
                                        session1152.close();
                                        factory1152.close();
                                    }
                                    System.out.println();

                                    break;


                                default:
                                    System.out.println("Введите корректное значение");
                                    break;
                            }
                        }
                        while (!z.equals("0"));
                    }
                } else if (us3.getRole().equals("пользователь")) {
                    System.out.println("Для работы в меню пользователя нажмите любую цифру, отличную от 0");

                    Scanner input20 = new Scanner(System.in);
                    String z2 = input20.nextLine();

                    while (!z2.equals("0")) {
                        do {
                            System.out.println("Введите:" +
                                    "\n1 - для просмотра категорий товаров;" +
                                    "\n2 - для просмотра списка товаров;" +
                                    "\n3 - для добавления товаров в корзину; " +
                                    "\n4 - для просмотра списка товаров в корзине;" +
                                    "\n5 - для удаления товара из корзины;" +
                                    "\n6 - для фильтрации товаров по категории и по цене;" +
                                    "\n7 - для оформления заказа;" +
                                    "\n8 - для просмотра списка заказов;" +
                                    "\n0 - для выхода из меню пользователя");
                            z2 = input20.nextLine();
                            switch (z2) {

                                case "1":

                                    Configuration configuration2011 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory2011 = configuration2011.buildSessionFactory();

                                    Session session2011 = null;
                                    try {
                                        session2011 = factory2011.getCurrentSession();
                                        session2011.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session2011.createQuery("from Category").getResultList();
                                        for (Category category : categoryList) {
                                            System.out.println(category);
                                        }
                                        session2011.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session2011.close();
                                        factory2011.close();
                                    }

                                    break;
                                case "2"://информация о всех товарах из базы данных

                                    Configuration configuration9 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory200 = configuration9.buildSessionFactory();

                                    Session session200 = null;
                                    try {
                                        session200 = factory200.getCurrentSession();
                                        session200.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session200.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session200.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session200.close();
                                        factory200.close();
                                    }

                                    break;

                                case "3":

                                    System.out.println("Добавление товара в корзину");
                                    int count = 0;
                                    int n = 0;
                                    String art;
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Введите артикул товара, который хотите добавить в корзину");
                                    art = sc.nextLine();
                                    Users user = null;

                                    Configuration configuration = new Configuration().addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).addAnnotatedClass(Users.class).addAnnotatedClass(Order.class);
                                    SessionFactory factory = configuration.buildSessionFactory();
                                    Session session = null;
                                    try {
                                        session = factory.getCurrentSession();
                                        session.beginTransaction();
                                        user = session.get(Users.class, identificator);

                                        List<Product> productList = session.createQuery("from Product").getResultList();


                                        for (Product pruductOfUser : user.getProductList()) {
                                            if (pruductOfUser.getCode().equals(art)) {
                                                n++;
                                            }

                                        }

                                        if (n > 0) {
                                            System.out.println("Данный товар уже находится в корзине");
                                        } else {
                                            for (Product p : productList) {
                                                if (p.getCode().equals(art)) {
                                                    count++;
                                                    user.addUserToProduct(p);
                                                }
                                            }
                                            if (count == 0) {
                                                System.out.println("Товара с данным артикулом не существует");
                                            }
                                        }


                                        session.getTransaction().commit();

                                        if (count != 0) {
                                            System.out.println("Товар с артикулом " + art + " добавлен в корзину");
                                        }

                                    } finally {
                                        session.close();
                                        factory.close();
                                    }

                                    break;

                                case "4":
                                    System.out.println("Просмотр списка товаров в корзине");

                                    double sum = 0;
                                    Users user1 = null;


                                    Configuration configuration1 = new Configuration().addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).addAnnotatedClass(Users.class).addAnnotatedClass(Order.class);
                                    SessionFactory factory1 = configuration1.buildSessionFactory();
                                    Session session1 = null;
                                    try {
                                        session1 = factory1.getCurrentSession();
                                        session1.beginTransaction();
                                        user1 = session1.get(Users.class, identificator);

                                        if (user1.getProductList().isEmpty()) {
                                            System.out.println("Корзина пуста");
                                        } else {

                                            System.out.println("У Вас в корзине лежат следующие товары:");

                                            for (Product product : user1.getProductList()) {
                                                sum = sum + product.getProduct_price();
                                                System.out.println(product);

                                            }
                                            System.out.println("Итоговая цена  = " + sum);

                                        }
                                        session1.getTransaction().commit();


                                    } finally {
                                        session1.close();
                                        factory1.close();
                                    }

                                    break;

                                case "5":
                                    System.out.println("Удаление товара из корзины");
                                    int v = 0; //счетчик
                                    int z = 0;
                                    String art2;
                                    Scanner sc2 = new Scanner(System.in);
                                    System.out.println("Введите артикул товара, который хотите удалить из корзины");
                                    art2 = sc2.nextLine();

                                    Users user2 = null;

                                    Configuration configuration2 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);
                                    SessionFactory factory2 = configuration2.buildSessionFactory();
                                    Session session2 = null;
                                    try {
                                        session2 = factory2.getCurrentSession();
                                        session2.beginTransaction();
                                        user2 = session2.get(Users.class, identificator);


                                        for (Product product : user2.getProductList()) {
                                            if (product.getCode().equals(art2)) {
                                                z = product.getId();
                                                v++;
                                            }
                                        }
                                        if (v == 0) {
                                            System.out.println("Отсутствует товар с данным индексом в корзине");
                                        }

                                        if (v != 0) {
                                            Product product = session2.get(Product.class, z);
                                            product.getUsersList().remove(user2);
                                        }

                                        session2.getTransaction().commit();

                                    } finally {
                                        session2.close();
                                        factory2.close();
                                    }
                                    // Если товар в корзине есть
                                    if (v != 0) {
                                        System.out.println("Товар с артикулом " + art2 + " удален из корзины");
                                    }

                                    break;

                                case "6":
                                    boolean isCategory = false;
                                    String nameCategory = null;
                                    int findIdProd;
                                    Scanner sc3 = new Scanner(System.in);

                                    Configuration configuration12345 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory12345 = configuration12345.buildSessionFactory();

                                    Session session12345 = null;

                                    try {
                                        session12345 = factory12345.getCurrentSession();
                                        session12345.beginTransaction();


                                        System.out.println("Поиск подходящих товаров по категории и по цене");

                                        do {
                                            System.out.println("Введите id категории товара");
                                            // Проверка на тип int
                                            while (!sc3.hasNextInt()) {
                                                sc3.next();
                                                System.out.println("Вы ввели не целое число (не значение типа int), попробуйте еще раз");
                                            }
                                            findIdProd = sc3.nextInt();

                                            List<Category> categoryList1 = session12345.createQuery("from Category").getResultList();
                                            for (Category cat : categoryList1) {
                                                if (cat.getId() == findIdProd) {

                                                    isCategory = true;
                                                }
                                                if (isCategory) {
                                                    nameCategory = cat.getName();
                                                    System.out.println("Вы ввели значение, id = " + findIdProd + ", что соответствует категории  - " + nameCategory);
                                                    break;
                                                }
                                            }
                                            if (isCategory == false) {
                                                System.out.println("Отсутствует категория с указанным Вами id");
                                            }

                                        }
                                        while (!isCategory);

                                    } finally {
                                        session12345.close();
                                        factory12345.close();
                                    }


                                    //_______________________________________________________________________________

                                    System.out.println("Введите стартовую цену товара");


                                    while (!sc3.hasNextDouble()) {
                                        sc3.next();
                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                    }
                                    Double startPriceProd = sc3.nextDouble();

                                    System.out.println("Введите верхнюю границу цены товара");

                                    while (!sc3.hasNextDouble()) {
                                        sc3.next();
                                        System.out.println("Вы ввели не значение типа double, попробуйте еще раз");
                                    }
                                    Double endPriceProd = sc3.nextDouble();

                                    Configuration configuration10 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory201 = configuration10.buildSessionFactory();

                                    Session session201 = null;
                                    try {
                                        session201 = factory201.getCurrentSession();
                                        session201.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session201.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            if ((prod2.getProduct_price() >= startPriceProd) && (prod2.getProduct_price() <= endPriceProd) && (prod2.getCat().id == findIdProd)) {
                                                System.out.println(prod2);
                                            }
                                        }
                                        session201.getTransaction().commit();

                                    } finally {
                                        session201.close();
                                        factory201.close();
                                    }

                                    break;

                                case "7":
                                    System.out.println("Оформить заказ");

                                    // Получение уникальной строки - она будет номером заказа
                                    String uuid = UUID.randomUUID().toString();


                                    // Получение даты и времени
                                    LocalDate date = LocalDate.now();
                                    LocalTime time = LocalTime.now();
                                    LocalDateTime current = LocalDateTime.of(date, time);


                                    //Создаем лист заказа
                                    List<Product> productorderList = new ArrayList<>();

                                    Users user543 = null;


                                    Configuration configuration543 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);
                                    SessionFactory factory543 = configuration543.buildSessionFactory();
                                    Session session543 = null;
                                    try {
                                        session543 = factory543.getCurrentSession();
                                        session543.beginTransaction();
                                        user543 = session543.get(Users.class, identificator);

                                        //Получаем товары из корзины пользователя...
                                        for (Product product : user543.getProductList()) {
                                            //...и добавляем их в лист заказа
                                            productorderList.add(product);

                                            //... и удаляем товары из корзины пользователя
                                            product.getUsersList().remove(user543);
                                        }


                                        for (Product productorder : productorderList) {
                                            Order newOrder = new Order(uuid, user543, productorder, current, Status.Оформлен);
                                            session543.persist(newOrder);
                                        }


                                        session543.getTransaction().commit();


                                    } finally {
                                        session543.close();
                                        factory543.close();
                                    }

                                    Configuration configuration115 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory115 = configuration115.buildSessionFactory();

                                    Session session115 = null;
                                    try {
                                        session115 = factory115.getCurrentSession();
                                        session115.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session115.createQuery("from Order").getResultList();
                                        System.out.println("Информация о заказе:");
                                        System.out.println("Номер заказа: " + uuid);

                                        //дата и время
                                        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                        String text = dtf1.format(current);
                                        System.out.println("Дата и время заказа: " + text);

                                        // Получение статуса заказа
                                        for (Order order : orderList) {
                                            if (order.getNumber().equals(uuid)) {
                                                System.out.println("Статус заказа: " + order.getStatus());
                                                break;
                                            }
                                        }

                                        System.out.println("Список товаров заказа:");

                                        for (Order order : orderList) {
                                            if (order.getNumber().equals(uuid)) {

                                                System.out.println("id товара - " + order.getProduct().getId() + " , артикул товара - " + order.getProduct().getCode() + ", наименование товара - " + order.getProduct().getProduct_name() + ", цена товара - " + order.getProduct().getProduct_price());
                                                price = order.getProduct().getProduct_price() + price;
                                            }

                                        }

                                        System.out.println("Итоговая цена: " + price);
                                        price = 0;


                                        session115.getTransaction().commit();

                                    } finally {
                                        session115.close();
                                        factory115.close();
                                    }
                                    System.out.println();


                                    break;

                                case "8":

                                    Configuration configuration1151 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory1151 = configuration1151.buildSessionFactory();
                                    Session session1151 = null;

                                    try {
                                        session1151 = factory1151.getCurrentSession();
                                        session1151.beginTransaction();
                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session1151.createQuery("from Order").getResultList();

                                        System.out.println("Информация о Ваших заказах");

                                        System.out.println();

                                        HashSet<String> hashList = new HashSet<>();

                                        for (Order order : orderList) {
                                            if (order.getUser().getId() == identificator) {
                                                hashList.add(order.getNumber());
                                            }
                                        }

                                        for (String hl : hashList) {
                                            for (Order order : orderList) {
                                                if (hl.equals(order.getNumber())) {
                                                    System.out.println("Номер заказа: " + order.getNumber());
                                                    System.out.println("Статус заказа: " + order.getStatus());

                                                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yy, HH:mm");
                                                    String text = dtf1.format(order.getdAndT());
                                                    System.out.println("Дата и время заказа: " + text);
                                                    System.out.println("id заказчика - " + order.getUser().getId() + ", ФИО заказчика - " + order.getUser().getSurname() + " " + order.getUser().getName() + " " + order.getUser().getPatronymic());

                                                    System.out.println("Список товаров заказа:");
                                                    price = 0;

                                                    for (Order order1 : orderList) {
                                                        if (order1.getNumber().equals(hl)) {
                                                            System.out.println("id товара - " + order1.getProduct().getId() + " , артикул товара - " + order1.getProduct().getCode() + ", наименование товара - " + order1.getProduct().getProduct_name() + ", цена товара - " + order1.getProduct().getProduct_price());
                                                            price = order1.getProduct().getProduct_price() + price;
                                                        }
                                                    }
                                                    System.out.println("Итоговая цена заказа - " + price);

                                                    break;
                                                }
                                            }

                                            System.out.println();

                                        }
                                        System.out.println("Количество Ваших заказов - " + hashList.size());


                                        session1151.getTransaction().commit();
                                    } finally {
                                        session1151.close();
                                        factory1151.close();
                                    }


                                    System.out.println();


                                    break;


                                case "0":
                                    break;
                                default:
                                    System.out.println("Вы ввели некорректное значение");
                                    break;
                            }
                        }
                        while (!z2.equals("0"));
                    }
                }

                return true;
            }

        }
        return false;
    }

    public static boolean smenaRoli(int id, String role, List<Users> users) {

        System.out.println("Введите id пользователя, которому хотите поменять роль");
        Scanner input = new Scanner(System.in);
        int f = input.nextInt();


        Configuration configuration12 = new Configuration().
                addAnnotatedClass(Users.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);


        SessionFactory factory1 = configuration12.buildSessionFactory();

        Session session1 = null;
        try {
            session1 = factory1.getCurrentSession();
            session1.beginTransaction();

            List<Users> users3 = new ArrayList<>();

            users3 = session1.createQuery("from Users").getResultList();
            for (Users smenaRoli : users3) {
                if (smenaRoli.getId() == f) {
                    Users users31 = session1.get(Users.class, f);

                    if (users31.getRole().equals("пользователь")) {
                        users31.setRole("администратор");
                        session1.getTransaction().commit();
                    } else if (users31.getRole().equals("администратор")) {
                        users31.setRole("пользователь");
                        session1.getTransaction().commit();
                    }

                    System.out.println("Роль пользователя с id - " + f + " изменена. Новая роль пользователя с id " + f + " - " + users31.getRole());

                    return true;
                }
            }

        } finally {
            session1.close();
            factory1.close();
        }
        return false;
    }

    public static boolean deleteProdArtikul(String code) {

        Configuration configuration10 = new Configuration().
                addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);


        SessionFactory factory201 = configuration10.buildSessionFactory();

        Session session201 = null;
        try {


            session201 = factory201.getCurrentSession();
            session201.beginTransaction();
            System.out.println("Удаление товара по его артикулу(со списком товаров (который в т.ч. содержит артикул товара) можно ознакомиться, если нажать 3 в меню администратора)");
            System.out.println("Введите артикул товара, который хотите удалить");
            Scanner scanner1 = new Scanner(System.in);
            String artikul = scanner1.nextLine();
            int id_;

            List<Product> productSssses = new ArrayList<>();
            productSssses = session201.createQuery("from Product").getResultList();
            for (Product prod : productSssses) {
                if (prod.getCode().equals(artikul)) {
                    id_ = prod.getId();
                    Product productForDelete = session201.get(Product.class, id_);
                    session201.delete(productForDelete);
                    System.out.println("Товар с артикулом " + artikul + " удален");
                    session201.getTransaction().commit();
                    return true;
                }

            }

            return false;

        } finally {
            session201.close();
            factory201.close();
        }
    }
}











