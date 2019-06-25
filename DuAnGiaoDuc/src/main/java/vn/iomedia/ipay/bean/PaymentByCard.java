package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.OnlinePaymentDetail;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.PaymentService;
import vn.iomedia.ipay.serviceImpl.PaymentServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "paymentByCard")
@ViewScoped
public class PaymentByCard implements Serializable {

    private static final long serialVersionUID = -39199585621294241L;
    private Logger log = Logger.getLogger(PaymentByCard.class);
    private String mobileCompany;
    private String codeMobile;
    private String seriMobile;
    private String result;
    private List<RegistrationDetail> listDetail;
    private Student student;
    private PaymentService paymentService = new PaymentServiceImpl();

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("get Student,listDetail from Context in payment by card page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            this.listDetail = (List<RegistrationDetail>) ObjectUtils.getObjectByString(CommonContanst.LIST_DETAIL);
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String submit() {
        OnlinePaymentDetail paymentResult = null;
        if (!StringUtils.isEmpty(mobileCompany) && !StringUtils.isEmpty(codeMobile)
                && !StringUtils.isEmpty(seriMobile)) {
            paymentResult = paymentService.paymentByMobileCard(mobileCompany, codeMobile, seriMobile);
        }
        if (paymentResult != null && paymentResult.isStatusTrans()) {
            paymentService.saveDetailCart(listDetail, paymentResult, student);
            return CommonContanst.SUCCESS;
        }
        return CommonContanst.FAIL;
    }

    public String turnBack() {
        return CommonContanst.SUCCESS;
    }

    /**
     * @return the mobileCompany
     */
    public String getMobileCompany() {
        return mobileCompany;
    }

    /**
     * @param mobileCompany
     *            the mobileCompany to set
     */
    public void setMobileCompany(String mobileCompany) {
        this.mobileCompany = mobileCompany;
    }

    /**
     * @return the codeMobile
     */
    public String getCodeMobile() {
        return codeMobile;
    }

    /**
     * @param codeMobile
     *            the codeMobile to set
     */
    public void setCodeMobile(String codeMobile) {
        this.codeMobile = codeMobile;
    }

    /**
     * @return the seriMobile
     */
    public String getSeriMobile() {
        return seriMobile;
    }

    /**
     * @param seriMobile
     *            the seriMobile to set
     */
    public void setSeriMobile(String seriMobile) {
        this.seriMobile = seriMobile;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the listDetail
     */
    public List<RegistrationDetail> getListDetail() {
        return listDetail;
    }

    /**
     * @param listDetail
     *            the listDetail to set
     */
    public void setListDetail(List<RegistrationDetail> listDetail) {
        this.listDetail = listDetail;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student
     *            the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
