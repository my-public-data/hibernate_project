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

                    Configuration configuration10001 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);
                    SessionFactory factory10001 = configuration10001.buildSessionFactory();

                    Session session10001 = null;

                    try {
                        session10001 = factory10001.getCurrentSession();
                        session10001.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session10001.createQuery("from Users").getResultList();

                        КолвоЭлементовКласса = users.size();
                        session10001.getTransaction().commit();
                    } finally {
                        session10001.close();
                        factory10001.close();

                    }

                    Configuration configuration10002 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);


                    SessionFactory factory10002 = configuration10002.buildSessionFactory();

                    try {
                        Session session10002 = factory10002.getCurrentSession();

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

                                    Configuration configuration10003 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10003 = configuration10003.buildSessionFactory();

                                    Session session10003 = null;
                                    try {
                                        session10003 = factory10003.getCurrentSession();
                                        session10003.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session10003.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getEmail().equals(user.getEmail())) {
                                                nonunicemail = true;
                                                System.out.println("Пользователь с таким email уже добавлен. Введите другое значение email ");
                                            }
                                        }
                                        session10003.getTransaction().commit();


                                    } finally {
                                        session10003.close();
                                        factory10003.close();
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


                                    Configuration configuration10004 = new Configuration().
                                            addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10004 = configuration10004.buildSessionFactory();

                                    Session session10004 = null;
                                    try {
                                        session10004 = factory10004.getCurrentSession();
                                        session10004.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session10004.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getTelephone_number().equals(user.getTelephone_number())) {
                                                nonunic_telephone_number = true;
                                                System.out.println("Пользователь с таким номером телефона уже зарегистрирован. Введите другое значение номера телефона ");
                                            }
                                        }
                                        session10004.getTransaction().commit();


                                    } finally {
                                        session10004.close();
                                        factory10004.close();
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

                                    Configuration configuration10005 =
                                            new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                    SessionFactory factory10005 = configuration10005.buildSessionFactory();

                                    Session session10005 = null;
                                    try {
                                        session10005 = factory10005.getCurrentSession();
                                        session10005.beginTransaction();

                                        List<Users> users = new ArrayList<>();

                                        users = session10005.createQuery("from Users").getResultList();
                                        for (Users us3 : users) {
                                            if (us3.getLogin().equals(user.getLogin())) {
                                                nonuniclogin = true;
                                                System.out.println("Пользователь с таким логином уже добавлен. Введите другое значение логина");
                                            }
                                        }
                                        session10005.getTransaction().commit();

                                    } finally {
                                        session10005.close();
                                        factory10005.close();
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

                        session10002.beginTransaction();
                        session10002.persist(user);

                        session10002.getTransaction().commit();

                        System.out.println("Регистрация пользователя завершена, информация о пользователе записана в базу данных");
                        System.out.println(user);

                    } finally {

                        factory10002.close();
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

                    Configuration configuration10006 = new Configuration()
                            .addAnnotatedClass(Users.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Order.class)
                            .addAnnotatedClass(Status.class);


                    SessionFactory factory10006 = configuration10006.buildSessionFactory();

                    Session session10006 = null;
                    try {
                        session10006 = factory10006.getCurrentSession();
                        session10006.beginTransaction();

                        List<Users> users = new ArrayList<>();

                        users = session10006.createQuery("from Users").getResultList();
                        if ((findUser1(login, passwordAuth, users)) || (findUser2(login, passwordAuth, users)) || (findUser3(login, passwordAuth, users))) {

                        } else {
                            System.out.println("Вы НЕ АВТОИЗОВАНЫ");
                        }
                        session10006.getTransaction().commit();
                    } finally {
                        session10006.close();
                        factory10006.close();
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
                                    "\n10 - для смены статуса заказа;" +
                                    "\n0 - для выхода из меню администратора");
                            z = inp.nextLine();
                            switch (z) {
                                case "1":
                                    Configuration configuration10007 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10007 = configuration10007.buildSessionFactory();

                                    Session session10007 = null;
                                    try {
                                        session10007 = factory10007.getCurrentSession();
                                        session10007.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session10007.createQuery("from Category").getResultList();
                                        for (Category category : categoryList) {
                                            System.out.println(category);
                                        }
                                        session10007.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session10007.close();
                                        factory10007.close();
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


                                            Configuration configuration10008 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                            SessionFactory factory10008 = configuration10008.buildSessionFactory();

                                            Session session10008 = null;
                                            try {
                                                session10008 = factory10008.getCurrentSession();
                                                session10008.beginTransaction();

                                                List<Category> categories = new ArrayList<>();

                                                categories = session10008.createQuery("from Category").getResultList();
                                                for (Category categ : categories) {
                                                    if (categ.getName().equals(category.getName())) {
                                                        nonuniclogin = true;
                                                        System.out.println("Такая категория товаров уже добавлена. Введите другое значение категории товаров");
                                                    }
                                                }
                                                session10008.getTransaction().commit();

                                            } finally {
                                                session10008.close();
                                                factory10008.close();
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


                                    Configuration configuration10009 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10009 = configuration10009.buildSessionFactory();

                                    Session session10009 = null;
                                    try {
                                        session10009 = factory10009.getCurrentSession();

                                        session10009.beginTransaction();
                                        session10009.persist(category);

                                        session10009.getTransaction().commit();


                                    } finally {
                                        session10009.close();
                                        factory10009.close();
                                    }


                                    break;


                                case "3": // добавление товара

                                    String categor = null;


                                    Product product = new Product();

                                    Configuration configuration10010 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10010 = configuration10010.buildSessionFactory();

                                    Session session10010 = null;
                                    String a2;
                                    try {
                                        session10010 = factory10010.getCurrentSession();
                                        session10010.beginTransaction();
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

                                            Configuration configuration10011 = new Configuration()
                                                    .addAnnotatedClass(Users.class)
                                                    .addAnnotatedClass(Product.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Order.class)
                                                    .addAnnotatedClass(Status.class);


                                            SessionFactory factory10011 = configuration10011.buildSessionFactory();

                                            Session session10011 = null;
                                            try {
                                                session10011 = factory10011.getCurrentSession();
                                                session10011.beginTransaction();

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

                                                        List<Category> categories = session10011.createQuery("from Category").getResultList();

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
                                                    category1 = session10011.get(Category.class, value);
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
                                                session10011.getTransaction().commit();

                                            } finally {
                                                session10011.close();
                                                factory10011.close();
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
                                                    Configuration configuration10012 = new Configuration()
                                                            .addAnnotatedClass(Users.class)
                                                            .addAnnotatedClass(Product.class)
                                                            .addAnnotatedClass(Category.class)
                                                            .addAnnotatedClass(Order.class)
                                                            .addAnnotatedClass(Status.class);


                                                    SessionFactory factory10012 = configuration10012.buildSessionFactory();

                                                    Session session10012 = null;

                                                    try {
                                                        session10012 = factory10012.getCurrentSession();
                                                        session10012.beginTransaction();
                                                        System.out.println("Введите артикул товара (формат ввода: первые 2 символа - заглавные буквы, остальные 4 символа - цифры)");


                                                        while (!product.setCode(scanner20000.nextLine())) ;


                                                        List<Product> productList = session10012.createQuery("from Product").getResultList();

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
                                                        session10012.getTransaction().commit();

                                                    } finally {
                                                        session10012.close();
                                                        factory10012.close();
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

                                        session10010.persist(product);
                                        session10010.getTransaction().commit();
                                        System.out.println("Регистрация товара завершена, информация о товаре записана в базу данных");
//_____________________________________________________________________________________________________________________________________

                                    } finally {
                                        session10010.close();
                                        factory10010.close();
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

                                    Configuration configuration10013 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10013 = configuration10013.buildSessionFactory();

                                    Session session10013 = null;
                                    try {
                                        session10013 = factory10013.getCurrentSession();
                                        session10013.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session10013.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session10013.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session10013.close();
                                        factory10013.close();
                                    }

                                    break;


                                case "6":
                                    //  "Информация о зарегистрированных пользователях:"

                                    Configuration configuration10014 = new Configuration().
                                            addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10014 = configuration10014.buildSessionFactory();

                                    Session session10014 = null;
                                    try {
                                        session10014 = factory10014.getCurrentSession();
                                        session10014.beginTransaction();

                                        List<Users> users32 = new ArrayList<>();

                                        users32 = session10014.createQuery("from Users").getResultList();
                                        for (Users us32 : users32) {
                                            System.out.println(us32);
                                        }
                                        session10014.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех зарегистрированных пользователях из базы данных");
                                    } finally {
                                        session10014.close();
                                        factory10014.close();
                                    }
                                    break;
                                case "7":
                                    System.out.println("Смена роли пользователю: (с информацией о пользователях (в т.ч.о том - у какого пользователя какая роль) можно ознакомиться, если нажать 4 в меню администратора)");
                                    if (!smenaRoli(us3.getId(), us3.getRole(), users)) {
                                        System.out.println("Пользователя с таким id нет среди зарегистрированных пользователей");
                                    }
                                    break;

                                case "8":

                                    Configuration configuration10015 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10015 = configuration10015.buildSessionFactory();

                                    Session session10015 = null;
                                    try {
                                        session10015 = factory10015.getCurrentSession();
                                        session10015.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session10015.createQuery("from Order").getResultList();


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

                                        session10015.getTransaction().commit();

                                    } finally {
                                        session10015.close();
                                        factory10015.close();
                                    }
                                    System.out.println();


                                    break;

                                case "9":

                                    boolean isorderin = false;
                                    int counterin = 0;

                                    Configuration configuration10016 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10016 = configuration10016.buildSessionFactory();

                                    Session session10016 = null;
                                    try {
                                        session10016 = factory10016.getCurrentSession();
                                        session10016.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session10016.createQuery("from Order").getResultList();

                                        System.out.println("Введите символы окончания номера заказа");
                                        Scanner console = new Scanner(System.in);
                                        String path = console.nextLine();


                                        // Лист, чтобы разместить номера заказов без повтора
                                        HashSet<String> hashList = new HashSet<>();
                                        // Получаю номера всех заказов
                                        for (Order o : orderList) {
                                            // Заполняю поэлементно Hash лист
                                            hashList.add(o.getNumber());
                                        }

                                        for (Order o : orderList) {
                                            if (o.getNumber().endsWith(path)) {
                                                counterin++;
                                            }
                                        }

                                        if (counterin == 0) {
                                            isorderin = false;
                                        } else {
                                            isorderin = true;
                                        }

                                        if (isorderin == false) {
                                            System.out.println("Нет заказов с номером, заканчивающимся на символы " + path);
                                        } else {

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
                                        }


                                        session10016.getTransaction().commit();

                                    } finally {
                                        session10016.close();
                                        factory10016.close();
                                    }
                                    System.out.println();

                                    break;

                                case "10":

                                    int counter = 0;
                                    String teknumber = null;
                                    boolean sovpadstatus = false;
                                    String temp = null;
                                    Status status = null;
                                    Status tekstatus = null;

                                    Configuration configuration10017 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory10017 = configuration10017.buildSessionFactory();

                                    Session session10017 = null;
                                    System.out.println("Введите символы окончания номера заказа");
                                    Scanner console = new Scanner(System.in);
                                    String path = console.nextLine();
                                    Scanner input = new Scanner(System.in);
                                    String numbstat = null;
                                    boolean znach = false;
                                    boolean isorder = false;

                                    try {
                                        session10017 = factory10017.getCurrentSession();
                                        session10017.beginTransaction();

                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session10017.createQuery("from Order").getResultList();

                                        for (Order o : orderList) {
                                            if (o.getNumber().endsWith(path)) {
                                                tekstatus = o.getStatus();
                                                counter++;
                                            }
                                        }
                                        if (counter != 0) {
                                            isorder = true;
                                        } else {
                                            isorder = false;
                                        }
                                        if (isorder) {
                                            for (Order o : orderList) {
                                                if (o.getNumber().endsWith(path)) {
                                                    teknumber = o.getNumber();
                                                }
                                            }
                                        }

                                        if (isorder == false) {
                                            System.out.println("Нет заказов с номером, заканчивающимся на символы " + path);
                                        }
                                        // Если Правда
                                        else {
                                            System.out.println("Есть заказ с номером, заканчивающимся на символы " + path);
                                            System.out.print("Это заказ с номером " + teknumber);
                                            System.out.println(" и статусом - " + tekstatus);
                                            do {
                                                System.out.println("Для изменения текущего статуса заказа введите кодовое значение нового статуса  (1 - принят, 2 - оформлен, 3 - ожидает или 4 - получен), на который будет изменен текущий статус:");
                                                numbstat = input.nextLine();
                                                if (numbstat.equals("1") || numbstat.equals("2") || numbstat.equals("3") || numbstat.equals("4")) {
                                                    znach = true;
                                                }
                                            }
                                            while (znach == false);

                                            if (numbstat.equals("1")) {
                                                status = Status.Принят;
                                            } else if (numbstat.equals("2")) {
                                                status = Status.Оформлен;
                                            } else if (numbstat.equals("3")) {
                                                status = Status.Ожидает;
                                            } else if (numbstat.equals("4")) {
                                                status = Status.Получен;
                                            }


                                            for (Order o : orderList) {
                                                if (o.getNumber().endsWith(path)) {

                                                    if (o.getStatus().equals(status)) {
                                                        sovpadstatus = true;
                                                        System.out.println("Текущее значение статуса совпадает со значением статуса, которое Вы хотите присвоить. Выберите другое значение нового статуса товара.");
                                                        break;
                                                    }
                                                }
                                            }
                                            for (Order o : orderList) {

                                                if (o.getNumber().endsWith(path)) {
                                                    if (o.getStatus().equals(status) == false) {
                                                        temp = o.getNumber();
                                                        o.setStatus(status);
                                                    }
                                                }
                                            }
                                        }

                                        if (isorder && sovpadstatus == false) {
                                            System.out.println("У товара с номером " + temp + " статус заказа изменен на - " + status);
                                        }

                                        session10017.getTransaction().commit();

                                    } finally {
                                        session10017.close();
                                        factory10017.close();
                                    }

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

                                    Configuration configuration10018 = new Configuration()
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10018 = configuration10018.buildSessionFactory();

                                    Session session10018 = null;
                                    try {
                                        session10018 = factory10018.getCurrentSession();
                                        session10018.beginTransaction();
                                        List<Category> categoryList = new ArrayList<>();

                                        categoryList = session10018.createQuery("from Category").getResultList();
                                        for (Category category : categoryList) {
                                            System.out.println(category);
                                        }
                                        session10018.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех категориях товаров из базы данных");
                                    } finally {
                                        session10018.close();
                                        factory10018.close();
                                    }

                                    break;
                                case "2"://информация о всех товарах из базы данных

                                    Configuration configuration10019 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10019 = configuration10019.buildSessionFactory();

                                    Session session10019 = null;
                                    try {
                                        session10019 = factory10019.getCurrentSession();
                                        session10019.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session10019.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            System.out.println(prod2);
                                        }
                                        session10019.getTransaction().commit();

                                        System.out.println("Выше выведена информация о всех товарах из базы данных");
                                    } finally {
                                        session10019.close();
                                        factory10019.close();
                                    }

                                    break;

                                case "3":

                                    System.out.println("Добавление товара в корзину");

                                    /////////////
                                    String tovarname = null;
                                    /////////////
                                    int count = 0;

                                    int n = 0;
                                    String art;
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Введите артикул товара, который хотите добавить в корзину");
                                    art = sc.nextLine();
                                    Users user = null;

                                    Configuration configuration10020 = new Configuration().addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).addAnnotatedClass(Users.class).addAnnotatedClass(Order.class);
                                    SessionFactory factory10020 = configuration10020.buildSessionFactory();
                                    Session session10020 = null;
                                    try {
                                        session10020 = factory10020.getCurrentSession();
                                        session10020.beginTransaction();
                                        user = session10020.get(Users.class, identificator);

                                        List<Product> productList = session10020.createQuery("from Product").getResultList();


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
                                                    tovarname = p.getProduct_name();
                                                    user.addUserToProduct(p);
                                                }
                                            }
                                            if (count == 0) {
                                                System.out.println("Товара с данным артикулом не существует");
                                            }
                                        }


                                        session10020.getTransaction().commit();

                                        if (count != 0) {
                                            System.out.println("Товар с артикулом " + art + " и названием " + tovarname + " добавлен в корзину");
                                        }

                                    } finally {
                                        session10020.close();
                                        factory10020.close();
                                    }

                                    break;

                                case "4":
                                    System.out.println("Просмотр списка товаров в корзине");


                                    double sum = 0;
                                    Users user1 = null;


                                    Configuration configuration10021 = new Configuration().addAnnotatedClass(Product.class).addAnnotatedClass(Category.class).addAnnotatedClass(Users.class).addAnnotatedClass(Order.class);
                                    SessionFactory factory10021 = configuration10021.buildSessionFactory();
                                    Session session10021 = null;
                                    try {
                                        session10021 = factory10021.getCurrentSession();
                                        session10021.beginTransaction();
                                        user1 = session10021.get(Users.class, identificator);

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
                                        session10021.getTransaction().commit();


                                    } finally {
                                        session10021.close();
                                        factory10021.close();
                                    }

                                    break;

                                case "5":
                                    System.out.println("Удаление товара из корзины");

                                    /////////////
                                    String tovarname2 = null;
                                    /////////////
                                    int v = 0; //счетчик
                                    int z = 0;
                                    String art2;
                                    Scanner sc2 = new Scanner(System.in);
                                    System.out.println("Введите артикул товара, который хотите удалить из корзины");
                                    art2 = sc2.nextLine();

                                    Users user2 = null;

                                    Configuration configuration10022 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);
                                    SessionFactory factory10022 = configuration10022.buildSessionFactory();
                                    Session session10022 = null;
                                    try {
                                        session10022 = factory10022.getCurrentSession();
                                        session10022.beginTransaction();
                                        user2 = session10022.get(Users.class, identificator);


                                        for (Product product : user2.getProductList()) {
                                            if (product.getCode().equals(art2)) {
                                                z = product.getId();
                                                v++;
                                                tovarname2 = product.getProduct_name();
                                            }
                                        }
                                        if (v == 0) {
                                            System.out.println("Отсутствует товар с данным индексом в корзине");
                                        }

                                        if (v != 0) {
                                            Product product = session10022.get(Product.class, z);
                                            product.getUsersList().remove(user2);
                                        }

                                        session10022.getTransaction().commit();

                                    } finally {
                                        session10022.close();
                                        factory10022.close();
                                    }
                                    // Если товар в корзине есть
                                    if (v != 0) {
                                        System.out.println("Товар с артикулом " + art2 + " и названием " + tovarname2 + " удален из корзины");
                                    }

                                    break;

                                case "6":
                                    boolean isCategory = false;
                                    String nameCategory = null;
                                    int findIdProd;
                                    Scanner sc3 = new Scanner(System.in);

                                    Configuration configuration10023 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);

                                    SessionFactory factory10023 = configuration10023.buildSessionFactory();

                                    Session session10023 = null;

                                    try {
                                        session10023 = factory10023.getCurrentSession();
                                        session10023.beginTransaction();


                                        System.out.println("Поиск подходящих товаров по категории и по цене");

                                        do {
                                            System.out.println("Введите id категории товара");
                                            // Проверка на тип int
                                            while (!sc3.hasNextInt()) {
                                                sc3.next();
                                                System.out.println("Вы ввели не целое число (не значение типа int), попробуйте еще раз");
                                            }
                                            findIdProd = sc3.nextInt();

                                            List<Category> categoryList1 = session10023.createQuery("from Category").getResultList();
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
                                        session10023.close();
                                        factory10023.close();
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

                                    Configuration configuration10024 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10024 = configuration10024.buildSessionFactory();

                                    Session session10024 = null;
                                    try {
                                        session10024 = factory10024.getCurrentSession();
                                        session10024.beginTransaction();
                                        List<Product> productSses = new ArrayList<>();

                                        productSses = session10024.createQuery("from Product").getResultList();
                                        for (Product prod2 : productSses) {
                                            if ((prod2.getProduct_price() >= startPriceProd) && (prod2.getProduct_price() <= endPriceProd) && (prod2.getCat().id == findIdProd)) {
                                                System.out.println(prod2);
                                            }
                                        }
                                        session10024.getTransaction().commit();

                                    } finally {
                                        session10024.close();
                                        factory10024.close();
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


                                    Configuration configuration10025 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);
                                    SessionFactory factory10025 = configuration10025.buildSessionFactory();
                                    Session session10025 = null;
                                    try {
                                        session10025 = factory10025.getCurrentSession();
                                        session10025.beginTransaction();
                                        user543 = session10025.get(Users.class, identificator);

                                        //Получаем товары из корзины пользователя...
                                        for (Product product : user543.getProductList()) {
                                            //...и добавляем их в лист заказа
                                            productorderList.add(product);

                                            //... и удаляем товары из корзины пользователя
                                            product.getUsersList().remove(user543);
                                        }


                                        for (Product productorder : productorderList) {
                                            Order newOrder = new Order(uuid, user543, productorder, current, Status.Оформлен);
                                            session10025.persist(newOrder);
                                        }


                                        session10025.getTransaction().commit();


                                    } finally {
                                        session10025.close();
                                        factory10025.close();
                                    }

                                    Configuration configuration10026 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10026 = configuration10026.buildSessionFactory();

                                    Session session10026 = null;
                                    try {
                                        session10026 = factory10026.getCurrentSession();
                                        session10026.beginTransaction();

                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session10026.createQuery("from Order").getResultList();
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


                                        session10026.getTransaction().commit();

                                    } finally {
                                        session10026.close();
                                        factory10026.close();
                                    }
                                    System.out.println();


                                    break;

                                case "8":

                                    Configuration configuration10027 = new Configuration()
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Category.class)
                                            .addAnnotatedClass(Users.class)
                                            .addAnnotatedClass(Order.class)
                                            .addAnnotatedClass(Status.class);


                                    SessionFactory factory10027 = configuration10027.buildSessionFactory();
                                    Session session10027 = null;

                                    try {
                                        session10027 = factory10027.getCurrentSession();
                                        session10027.beginTransaction();
                                        double price = 0;
                                        List<Order> orderList = new ArrayList<>();
                                        orderList = session10027.createQuery("from Order").getResultList();

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


                                        session10027.getTransaction().commit();
                                    } finally {
                                        session10027.close();
                                        factory10027.close();
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


        Configuration configuration10028 = new Configuration().
                addAnnotatedClass(Users.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);


        SessionFactory factory10028 = configuration10028.buildSessionFactory();

        Session session10028 = null;
        try {
            session10028 = factory10028.getCurrentSession();
            session10028.beginTransaction();

            List<Users> users3 = new ArrayList<>();

            users3 = session10028.createQuery("from Users").getResultList();
            for (Users smenaRoli : users3) {
                if (smenaRoli.getId() == f) {
                    Users users31 = session10028.get(Users.class, f);

                    if (users31.getRole().equals("пользователь")) {
                        users31.setRole("администратор");
                        session10028.getTransaction().commit();
                    } else if (users31.getRole().equals("администратор")) {
                        users31.setRole("пользователь");
                        session10028.getTransaction().commit();
                    }

                    System.out.println("Роль пользователя с id - " + f + " изменена. Новая роль пользователя с id " + f + " - " + users31.getRole());

                    return true;
                }
            }

        } finally {
            session10028.close();
            factory10028.close();
        }
        return false;
    }

    public static boolean deleteProdArtikul(String code) {

        Configuration configuration10029 = new Configuration().
                addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Status.class);


        SessionFactory factory10029 = configuration10029.buildSessionFactory();

        Session session10029 = null;
        try {


            session10029 = factory10029.getCurrentSession();
            session10029.beginTransaction();
            System.out.println("Удаление товара по его артикулу(со списком товаров (который в т.ч. содержит артикул товара) можно ознакомиться, если нажать 5 в меню администратора)");
            System.out.println("Введите артикул товара, который хотите удалить");
            Scanner scanner1 = new Scanner(System.in);
            String artikul = scanner1.nextLine();
            int id_;

            List<Product> productSssses = new ArrayList<>();
            productSssses = session10029.createQuery("from Product").getResultList();
            for (Product prod : productSssses) {
                if (prod.getCode().equals(artikul)) {
                    id_ = prod.getId();
                    Product productForDelete = session10029.get(Product.class, id_);
                    session10029.delete(productForDelete);
                    System.out.println("Товар с артикулом " + artikul + " удален");
                    session10029.getTransaction().commit();
                    return true;
                }

            }

            return false;

        } finally {
            session10029.close();
            factory10029.close();
        }
    }
}











