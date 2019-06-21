package vn.iomedia.ipay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.entity.Majors;
import vn.iomedia.ipay.entity.Student;

public class StringUtillStudy {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric() {
        int count = 1;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static Integer getIdByValueName(String value) {
        String[] st = value.split("//");
        return Integer.valueOf(st[0]);
    }

    public static String getNameByValueName(String value) {
        String[] st = value.split("//");
        return String.valueOf(st[1]);
    }

    public static String getTotalMark(Student student, GroupSubjects sub, Majors major) {
        StringBuilder sb = new StringBuilder();
        Double total = 0.0;
        Double total_priority = 0.0;
        getMajor(sub.getCodeSubject1(), sb, student);
        getMajor(sub.getCodeSubject2(), sb, student);
        getMajor(sub.getCodeSubject3(), sb, student);
        total += getTotal(sub.getCodeSubject1(), student);
        total += getTotal(sub.getCodeSubject2(), student);
        total += getTotal(sub.getCodeSubject3(), student);
        sb.append("Tong :");
        sb.append(total);
        sb.append("|");
        if (student.getPriorityArea() != null && student.getPriorityArea().getPriorityMark() > 0) {
            total_priority += student.getPriorityArea().getPriorityMark();
        }
        if (student.getPriorityObject() != null && student.getPriorityObject().getPriorityMark() > 0) {
            total_priority += student.getPriorityObject().getPriorityMark();
        }
        if (total_priority > 0) {
            sb.append("Diem Uu Tien :");
            sb.append(total_priority);
            sb.append("|");
        }
        sb.append("Diem Xet Tuyen :");
        sb.append(total + total_priority);
        return sb.toString();
    }

    private static StringBuilder getMajor(String nameMajor, StringBuilder sb, Student stu) {
        switch (nameMajor) {
        case "T":
            sb.append("TO:");
            sb.append(stu.getMark().getMath());
            sb.append(" ");
            return sb;
        case "L":
            sb.append("LY:");
            sb.append(stu.getMark().getPhysical());
            sb.append(" ");
            return sb;
        case "H":
            sb.append("HO:");
            sb.append(stu.getMark().getChemistry());
            sb.append(" ");
            return sb;
        case "V":
            sb.append("VA:");
            sb.append(stu.getMark().getLiterature());
            sb.append(" ");
            return sb;
        case "A":
            sb.append("AN:");
            sb.append(stu.getMark().getEnglish());
            sb.append(" ");
            return sb;
        }
        return sb;
    };

    private static Double getTotal(String nameMajor, Student stu) {
        Double total = 0.0;
        switch (nameMajor) {
        case "T":
            total = stu.getMark().getMath();

            return total;
        case "L":
            total = stu.getMark().getPhysical();

            return total;
        case "H":
            total = stu.getMark().getChemistry();

            return total;
        case "V":
            total = stu.getMark().getLiterature();

            return total;
        case "A":
            total = stu.getMark().getEnglish();
            return total;
        }
        return total;
    }

    public static String getDateRegis() {
        Date date = new Date();
        String pattern = "dd/MM/yyyy HH:MM:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
