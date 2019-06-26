package vn.iomedia.ipay.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.iomedia.ipay.contanst.CommonContanst;

@ManagedBean(name = "registerButton")
@SessionScoped
public class RegisterButton {


    public String submit() {
        return CommonContanst.SUCCESS;
    }

    public String payment() {
        return CommonContanst.SUCCESS;
    }

    public String returnPayment() {
        return CommonContanst.SUCCESS;
    }

    public String endRegister() {
        return CommonContanst.SUCCESS;
    }
   
}
