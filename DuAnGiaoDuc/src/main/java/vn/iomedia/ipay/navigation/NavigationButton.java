package vn.iomedia.ipay.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.iomedia.ipay.contanst.CommonContanst;

@ManagedBean
@SessionScoped
public class NavigationButton {

    public String goHome() {
        return CommonContanst.SUCCESS;
    }

    public String goRegisterLetter() {
        return CommonContanst.SUCCESS;
    }

    public String goSearch() {
        return CommonContanst.SUCCESS;
    }

    public String goRegisterAdmissions() {
        return CommonContanst.SUCCESS;
    }

    public String goChangePass() {
        return CommonContanst.SUCCESS;
    }
    
    public String nextAction() {
        return CommonContanst.SUCCESS;
    }
    
    public String cancelRegister() {
        return CommonContanst.SUCCESS;
    }
}
