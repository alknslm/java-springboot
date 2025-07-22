package com.alknslm.starter;

import com.alknslm.dto.DtoEmployee;
import com.alknslm.service.IEmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ExceptionManagementStarter.class}) //test sınıfı olduğunu belirtmek için
class ExceptionManagementApplicationTests {

    /** ---- TESTLER CONTROLLER KATMANI İLE DEĞİL SERVICE KATMANI İLE YAZILIR ----*/

    @Autowired
    private IEmployeeService employeeService;

    /**
     * Asıl test method'dan önce veritabanı bağlantısı için bir test methodu yazılabilir.
     * Asıl test edilecek method için bir token'a ihtiyaç vardır öncesinde o token'ı alıp burada oluşturabilriiz
     */
    @BeforeEach //her test sınıfında önce çalışacak method
    public void beforeEach(){
        System.out.println("Before Each Çalıştı");
    }

    /**
     * test+(TEST EDİLECEK METHOD) olarak isimlendirmek doğru olan
     */
    @Test //test methodu olduğunu göstermek için
    public void testFindEmployeeById(){
        DtoEmployee employee = employeeService.findEmployeeById(3L);

        assertEquals("Ahmet Işık",employee.getName()); //servisten beklenen ve dönen değer birbirine eişt mi

//        assertNotNull(employee); // null'sa hata verir


//        if(employee!=null){
//            System.out.println("İsim : " + employee.getName());
//        }
    }

    /**
     * Her method çalıştıktan sonra email at
     * Asıl test method'u çalıştıktan sonra burayı temizle, buraya yaz vb.
     */
    @AfterEach // her test sınıfından sonra çalışacak method
    public void afterEach(){
        System.out.println("After Each Çalıştı");
    }

}
