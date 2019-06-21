package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.GroupSchool;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "checkOut")
@ViewScoped
public class CheckOut implements Serializable {

    private static final long serialVersionUID = -39199585621294241L;
    private Log log = LogFactory.getLog(CheckOut.class);
    private Student student;
    private List<RegistrationDetail> listDetail;
    private GroupSchool group;
    private String moneyString;
    private Double money = 0.0;
    private String payment;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("Get Student,list Detail,group from Context in checkOut page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            this.listDetail = (List<RegistrationDetail>) ObjectUtils.getObjectByString(CommonContanst.LIST_DETAIL);
            this.group = (GroupSchool) ObjectUtils.getObjectByString(CommonContanst.GROUP_SCHOOL);
         
            if ((group != null) && (group.getNumberChose() == 2)) {
                log.debug("if group number ==2 ,return money.");
                money = CommonContanst.single_school + CommonContanst.single_school_extra;
            } else if ((group != null) && (group.getNumberChose() == 4)) {
                log.debug("if group number ==4 ,change option.");
                String schoolName = listDetail.get(0).getSchool().getName().trim();
                listDetail.forEach(detail -> {
                    if (detail != null && detail.getSchool() != null && detail.getSchool().getName() != null) {
                        if (!detail.getSchool().getName().trim().equals(schoolName)) {
                            money = CommonContanst.group_school + CommonContanst.group_school_extra;
                        }
                    }
                });
               
                if (money == 0) {
                    log.debug("after condition,return money.");
                    money = CommonContanst.single_school + CommonContanst.single_school_extra;
                }
            }
            this.moneyString = String.valueOf(money);
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String submit() {
        ObjectUtils.putObjectContext(CommonContanst.PAYMENT, moneyString);
        if (!StringUtils.isEmpty(payment) && CommonContanst.MOBILE.equals(payment)) {
            log.debug("User chose Mobile,return mobile.");
            return CommonContanst.MOBILE;

        } else if (!StringUtils.isEmpty(payment) && CommonContanst.ATM.equals(payment)) {
            log.debug("User chose ATM,return ATM.");
            //this code will implement payment by ATM in future.            
            return CommonContanst.MOBILE;
        }
        return CommonContanst.FAIL;
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
     * @return the group
     */
    public GroupSchool getGroup() {
        return group;
    }

    /**
     * @param group
     *            the group to set
     */
    public void setGroup(GroupSchool group) {
        this.group = group;
    }

    /**
     * @return the moneyString
     */
    public String getMoneyString() {
        return moneyString;
    }

    /**
     * @param moneyString
     *            the moneyString to set
     */
    public void setMoneyString(String moneyString) {
        this.moneyString = moneyString;
    }

    /**
     * @return the money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money
     *            the money to set
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @param payment
     *            the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

}
