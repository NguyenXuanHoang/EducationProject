package dataTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vn.iomedia.ipay.entity.Mark;
import vn.iomedia.ipay.entity.PriorityArea;
import vn.iomedia.ipay.entity.PriorityObject;
import vn.iomedia.ipay.entity.Student;

public class InsertStudent {

    public static void insertStudent1(EntityManager em, EntityTransaction transaction) {
        transaction.begin();

        Mark mr = new Mark();
        mr.setChemistry(8.5);
        mr.setPhysical(7.0);
        mr.setMath(5.0);
        mr.setEnglish(8.0);
        mr.setLiterature(7.5);
        mr.setOrtherLanguage(5.5);
        em.persist(mr);

        PriorityArea area = new PriorityArea();
        area.setCodeArea("KV2");
        area.setPriorityMark(1.5);
        em.persist(area);

        PriorityObject ob = new PriorityObject();
        ob.setCodeObject("LS");
        ob.setPriorityMark(2.5);
        em.persist(ob);

        Student st = new Student();
        st.setLastName("Giao");
        st.setFirstName("Nguyen Hoan");
        st.setPassword("1");
        st.setIdCard("1");
        st.setIdNumber("ABC213");
        st.setAddress("viet nam");
        st.setDob("30041995");
        st.setEmail("hoangiao.se@gmail.com");
        st.setNumberRegis(2);
        st.setPriorityArea(area);
        st.setPriorityObject(ob);
        st.setMark(mr);
        em.persist(st);

        Student st2 = new Student();
        st2.setLastName("Hoàng");
        st2.setFirstName("Nguyen Xuân");
        st2.setPassword("12");
        st2.setIdCard("12");
        st2.setIdNumber("ABC2131");
        st2.setAddress("viet nam");
        st2.setDob("30081987");
        st2.setEmail("hoangnx1503@gmail.com");
        st2.setNumberRegis(2);
        st2.setPriorityArea(area);
        st2.setPriorityObject(ob);
        st2.setMark(mr);
        em.persist(st2);
        transaction.commit();
    };

}
