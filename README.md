# Açıklama

You will implement an application with the following explanation ... You are required
to use Hibernate during database operations.

    Employee Table -> Fields: Name,Surname and Salary
    Department Table -> Fields: Name,Description and Employee
    Meetings Table -> Fields: Name,Description and Deparment
    
An employee can belong to one deparment, deparments can join any meeting and can
also join meeting more than one.

Reconfigure Question with using Spring Framework and Hibernate as a JPA
Implementation.

Projede TaskListte bulunan 9 ve 10. sorular bir arada işlenmiştir.
Proje SpringMVC ve Hibernate kullanılarak yapılmış bir Web Projesidir.
Projede detaylı olarak CRUD işlemleri işlenmemiştir ancak basit şekilde bir takım işlemler yapılmıştır.
Projede yapılan işlemler proje içerisinde comment satırlarıyla gösterilmiştir.
Projenin UI kısmında BootStrap kullanılmıştır.

# Proje Maven Web Projesidir

Projenin düzgün şekilde koşturulması için kullanıcının

    servlet-context.xml

dosyasında kendi veritabanı bilgilerini girmesi gerekmetedir.

Projeyi indirdikten sonra kullandığınız IDE ' e import edip "clean" "install" komutuyla çalıştırabilirsiniz.

Veya

"cmd" ile projeyi indirdiğiniz directory'e gidip

    mvn clean install 

komutunu çalıştırabilirsiniz. Proje düzgün şekilde ayağa kaldırıldığında,

    http://localhost:8080/QuestionNineandTen/index
    
adresinden projeyi kullanabilirsiniz.

