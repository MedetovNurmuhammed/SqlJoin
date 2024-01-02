import dao.impl.LaptopDaoImpl;
import databasa.Databasa;
import model.Laptop;
import service.LaptopService;
import service.iml.LaptopserviceImpl;

public class Main {
    public static void main(String[] args) {
        Databasa databasa = new Databasa();
        LaptopService laptopService =  new LaptopserviceImpl(new LaptopDaoImpl(databasa));
      //  PhoneService phoneService = new PhoneServiceimpl((PhoneDao) new PhoneDAOimpl(databasa));
        System.out.println(laptopService.getall());
        System.out.println(laptopService.add(new Laptop(1l, "Мак")));
        System.out.println(laptopService.getall());
        // System.out.println("\"n\".isBlank() = " + "".isBlank());
 }
}
