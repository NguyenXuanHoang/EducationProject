package vn.iomedia.ipay.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.LoginService;
import vn.iomedia.ipay.serviceImpl.LoginServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;
import vn.iomedia.ipay.utils.StringUtillStudy;

@ManagedBean(name = "login")
@ViewScoped
public class MainPage implements Serializable {

    private static final long serialVersionUID = -5571821043199656622L;
    private Logger log = Logger.getLogger(MainPage.class);
    private LoginService service = new LoginServiceImpl();

    private String idCard;
    private String password;
    private String codeInput;
    private String codeOutput;

    public MainPage() {
        this.codeOutput = StringUtillStudy.randomAlphaNumeric();
    }

    public String checkValidate() {
        if (codeInput.equals(codeOutput)) {
            log.debug("Check Code OK,then check idCard and pass");
            Student stu = service.getStudentByIdCardAndPass(idCard, password);
            if (stu != null) {
                log.debug("Get Student by idCard and password success.");
                ObjectUtils.putObjectContext(CommonContanst.STUDENT, stu);
                return CommonContanst.SUCCESS;
            }
        }
        log.debug("Can not validate by IdCard,return.");
        this.codeOutput = StringUtillStudy.randomAlphaNumeric();
        return CommonContanst.FAIL + "?faces-redirect=true";
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     *            the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the codeInput
     */
    public String getCodeInput() {
        return codeInput;
    }

    /**
     * @param codeInput
     *            the codeInput to set
     */
    public void setCodeInput(String codeInput) {
        this.codeInput = codeInput;
    }

    /**
     * @return the codeOutput
     */
    public String getCodeOutput() {
        return codeOutput;
    }

    /**
     * @param codeOutput
     *            the codeOutput to set
     */
    public void setCodeOutput(String codeOutput) {
        this.codeOutput = codeOutput;
    }
}
