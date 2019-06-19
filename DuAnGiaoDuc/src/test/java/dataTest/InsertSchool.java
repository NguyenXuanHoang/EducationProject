package dataTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vn.iomedia.ipay.entity.GroupSchool;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.entity.MajorGroupSubject;
import vn.iomedia.ipay.entity.Majors;
import vn.iomedia.ipay.entity.School;

public class InsertSchool {

    public static void insertSchool(EntityManager em, EntityTransaction transaction) {

        transaction.begin();
        
        GroupSubjects gb = new GroupSubjects();
        gb.setCodeGroupSubject("TLH");
        gb.setCodeSubject1("T");
        gb.setCodeSubject2("L");
        gb.setCodeSubject3("H");
        em.persist(gb);

        GroupSubjects gb2 = new GroupSubjects();
        gb2.setCodeGroupSubject("TAV");
        gb2.setCodeSubject1("T");
        gb2.setCodeSubject2("A");
        gb2.setCodeSubject3("V");
        em.persist(gb2);

        GroupSubjects gb3 = new GroupSubjects();
        gb3.setCodeGroupSubject("TLA");
        gb3.setCodeSubject1("T");
        gb3.setCodeSubject2("L");
        gb3.setCodeSubject3("A");
        em.persist(gb3);

        GroupSchool grp4 = new GroupSchool();
        grp4.setGroupSchool("Nhom truong Dai Hoc Quoc Gia");
        grp4.setNumberChose(4);
        em.persist(grp4);

        School sc = new School();
        sc.setCodeSchool("DHQG001");
        sc.setName("Dai hoc quoc gia - dai hoc cntt");
        sc.setAddress("Quan Thu Duc - Thanh Pho Hoc Chi Minh");
        sc.setGroupSchool(grp4);
        em.persist(sc);

        Majors mj1 = new Majors();
        mj1.setCodeMajor("DH4850103");
        mj1.setNameMajor("Cong Nghe Phan Mem");
        mj1.setSchool(sc);
        em.persist(mj1);

        Majors mj2 = new Majors();
        mj2.setCodeMajor("DH4850104");
        mj2.setNameMajor("Cong Nghe Thong Tin");
        mj2.setSchool(sc);
        em.persist(mj2);

        School sc2 = new School();
        sc2.setCodeSchool("DHQG002");
        sc2.setName("Dai hoc quoc gia - dai hoc khtn");
        sc2.setAddress("Quan 5 - Thanh Pho Hoc Chi Minh");
        sc2.setGroupSchool(grp4);
        em.persist(sc2);

        Majors mj3 = new Majors();
        mj3.setCodeMajor("DH4850105");
        mj3.setNameMajor("Truyen thong va mang may tinh");
        mj3.setSchool(sc2);
        em.persist(mj3);

        Majors mj4 = new Majors();
        mj4.setCodeMajor("DH4850106");
        mj4.setNameMajor("Khoa hoc may tinh");
        mj4.setSchool(sc2);
        em.persist(mj4);

        School sc3 = new School();
        sc3.setCodeSchool("TCT");
        sc3.setName("Dai hoc can tho");
        sc3.setAddress("Ninh Kieu - Thanh Pho Can Tho");
        sc3.setGroupSchool(grp4);
        em.persist(sc3);

        Majors mj5 = new Majors();
        mj5.setCodeMajor("TCT0103");
        mj5.setNameMajor("Kinh te quoc te");
        mj5.setSchool(sc3);
        em.persist(mj5);

        Majors mj6 = new Majors();
        mj6.setCodeMajor("TCT0201");
        mj6.setNameMajor("Dich vu va  du lich");
        mj6.setSchool(sc3);
        em.persist(mj6);

        MajorGroupSubject r3 = new MajorGroupSubject();
        r3.setGroupsSubject(gb2);
        r3.setMajor(mj2);
        em.persist(r3);

        MajorGroupSubject r4 = new MajorGroupSubject();
        r4.setGroupsSubject(gb3);
        r4.setMajor(mj2);
        em.persist(r4);

        MajorGroupSubject r5 = new MajorGroupSubject();
        r5.setGroupsSubject(gb);
        r5.setMajor(mj3);
        em.persist(r5);

        MajorGroupSubject r6 = new MajorGroupSubject();
        r6.setGroupsSubject(gb3);
        r6.setMajor(mj3);
        em.persist(r6);

        MajorGroupSubject r7 = new MajorGroupSubject();
        r7.setGroupsSubject(gb2);
        r7.setMajor(mj4);
        em.persist(r7);

        MajorGroupSubject r8 = new MajorGroupSubject();
        r8.setGroupsSubject(gb3);
        r8.setMajor(mj4);
        em.persist(r8);

        MajorGroupSubject r9 = new MajorGroupSubject();
        r9.setGroupsSubject(gb3);
        r9.setMajor(mj5);
        em.persist(r9);

        MajorGroupSubject r10 = new MajorGroupSubject();
        r10.setGroupsSubject(gb);
        r10.setMajor(mj5);
        em.persist(r10);

        MajorGroupSubject r11 = new MajorGroupSubject();
        r11.setGroupsSubject(gb2);
        r11.setMajor(mj6);
        em.persist(r11);

        MajorGroupSubject r12 = new MajorGroupSubject();
        r12.setGroupsSubject(gb);
        r12.setMajor(mj6);
        em.persist(r12);

        

        // truong don le thu 1
        GroupSchool grp = new GroupSchool();
        grp.setGroupSchool("TrÆ°á»�ng Ä‘Æ¡n láº»");
        grp.setNumberChose(2);
        em.persist(grp);

        School sc5 = new School();
        sc5.setCodeSchool("HUCU");
        sc5.setName("Dai hoc hutech");
        sc5.setAddress("Quan Thu Duc - Thanh Pho Hoc Chi Minh");
        sc5.setGroupSchool(grp);
        em.persist(sc5);


        Majors mj9 = new Majors();
        mj9.setCodeMajor("HUC1234");
        mj9.setNameMajor("Truyen thong va quang cao");
        mj9.setSchool(sc5);
        em.persist(mj9);

        Majors mj = new Majors();
        mj.setCodeMajor("HUC2314");
        mj.setNameMajor("kinh te ngoai thuong");
        mj.setSchool(sc5);
        em.persist(mj);
   

        MajorGroupSubject r = new MajorGroupSubject();
        r.setGroupsSubject(gb);
        r.setMajor(mj);
        em.persist(r);

        MajorGroupSubject r2 = new MajorGroupSubject();
        r2.setGroupsSubject(gb2);
        r2.setMajor(mj);
        em.persist(r2);

        MajorGroupSubject r17 = new MajorGroupSubject();
        r17.setGroupsSubject(gb);
        r17.setMajor(mj9);
        em.persist(r17);

        MajorGroupSubject r18 = new MajorGroupSubject();
        r18.setGroupsSubject(gb3);
        r18.setMajor(mj9);
        em.persist(r18);

        MajorGroupSubject r19 = new MajorGroupSubject();
        r19.setGroupsSubject(gb);
        r19.setMajor(mj1);
        em.persist(r19);

        MajorGroupSubject r20 = new MajorGroupSubject();
        r20.setGroupsSubject(gb3);
        r20.setMajor(mj1);
        em.persist(r20);

        // truong don le thu 2
        School sc4 = new School();
        sc4.setCodeSchool("AGU");
        sc4.setName("Dai hoc an giang");
        sc4.setAddress("Long Xuyen - Tinh An Giang");
        sc4.setGroupSchool(grp);
        em.persist(sc4);

        Majors mj7 = new Majors();
        mj7.setCodeMajor("AG0231");
        mj7.setNameMajor("Bao ve thuc vat");
        mj7.setSchool(sc4);
        em.persist(mj7);

        Majors mj8 = new Majors();
        mj8.setCodeMajor("AG2340");
        mj8.setNameMajor("Kinh te nong nghiep");
        mj8.setSchool(sc4);
        em.persist(mj8);

        MajorGroupSubject r13 = new MajorGroupSubject();
        r13.setGroupsSubject(gb2);
        r13.setMajor(mj7);
        em.persist(r13);

        MajorGroupSubject r14 = new MajorGroupSubject();
        r14.setGroupsSubject(gb3);
        r14.setMajor(mj7);
        em.persist(r14);

        MajorGroupSubject r15 = new MajorGroupSubject();
        r15.setGroupsSubject(gb);
        r15.setMajor(mj8);
        em.persist(r15);

        MajorGroupSubject r16 = new MajorGroupSubject();
        r16.setGroupsSubject(gb3);
        r16.setMajor(mj8);
        em.persist(r16);

        transaction.commit();
    }

}
