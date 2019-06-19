package dataTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import vn.iomedia.ipay.entity.OnlinePaymentDetail;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.SchoolService;
import vn.iomedia.ipay.serviceImpl.LoginServiceImpl;
import vn.iomedia.ipay.serviceImpl.PaymentServiceImpl;
import vn.iomedia.ipay.serviceImpl.SchoolServiceImpl;

public class TestQuery {

    private static void loginService() {
        LoginServiceImpl service = new LoginServiceImpl();
        Student stu = service.getStudentByIdCardAndPass("1", "1");
        if (stu != null) {
            System.out.println("success");
        }
    }

//    private static void testOnlinePayment() {
//        PaymentServiceImpl service = new PaymentServiceImpl();
//        List<RegistrationDetail> listDetail = new ArrayList<>();
//        RegistrationDetail detail = new RegistrationDetail();
//        listDetail.add(detail);
//        OnlinePaymentDetail onlinePaymentDetail = new OnlinePaymentDetail();
//        service.saveDetailCart(listDetail, onlinePaymentDetail);
//
//    }
    
    private static void testRegAdmissionService() {
        
    }

    private static void SchoolService() {
        SchoolService service = new SchoolServiceImpl();
        List<School> schs = service.searchListSchoolByName("Dai hoc quoc gia - dai hoc cntt");
        if (!CollectionUtils.isEmpty(schs)) {
            System.out.println("success");
        }
    }

//    public static void main(String[] args) {
//        testOnlinePayment();
//    }
}
