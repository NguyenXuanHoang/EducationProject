package vn.iomedia.ipay.service;

import java.util.List;

import vn.iomedia.ipay.entity.OnlinePaymentDetail;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;

public interface PaymentService {

    OnlinePaymentDetail paymentByMobileCard(String mobileCompany, String codeMobile, String seriMobile);

    void saveDetailCart(List<RegistrationDetail> listDetail, OnlinePaymentDetail cart,Student student);
}
