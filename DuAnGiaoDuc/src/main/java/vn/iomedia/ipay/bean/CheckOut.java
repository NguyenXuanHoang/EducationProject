package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
    private Student student;
    private List<RegistrationDetail> listDetail;
    private GroupSchool group;
    private String moneyString;
    private Double money = 0.0;
    private String payment;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
        this.listDetail = (List<RegistrationDetail>) ObjectUtils.getObjectByString(CommonContanst.LIST_DETAIL);
        this.group = (GroupSchool) ObjectUtils.getObjectByString(CommonContanst.GROUP_SCHOOL);
        if ((group != null) && (group.getNumberChose() == 2)) {
            money = CommonContanst.single_school + CommonContanst.single_school_extra;
        } else if ((group != null) && (group.getNumberChose() == 4)) {
            String schoolName = listDetail.get(0).getSchool().getName().trim();
            listDetail.forEach(detail -> {
                if (detail != null && detail.getSchool() != null && detail.getSchool().getName() != null) {
                    if (!detail.getSchool().getName().trim().equals(schoolName)) {
                        money = CommonContanst.group_school + CommonContanst.group_school_extra;
                    }
                }
            });
            if (money == 0) {
                money = CommonContanst.single_school + CommonContanst.single_school_extra;
            }
        }
        this.moneyString = String.valueOf(money);
    }

    public String submit() {
        ObjectUtils.putObjectContext(CommonContanst.PAYMENT, moneyString);
        if (!StringUtils.isEmpty(payment) && CommonContanst.MOBILE.equals(payment)) {
            return CommonContanst.MOBILE;

        } else if (!StringUtils.isEmpty(payment) && CommonContanst.ATM.equals(payment)) {
            return CommonContanst.ATM;
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
