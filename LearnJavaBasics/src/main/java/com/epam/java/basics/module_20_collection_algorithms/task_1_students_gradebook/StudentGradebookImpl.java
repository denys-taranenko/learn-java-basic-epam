package com.epam.java.basics.module_20_collection_algorithms.task_1_students_gradebook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentGradebookImpl implements StudentGradebook {
    private final Map<Student, Map<String, BigDecimal>> map;

    public StudentGradebookImpl() {
        this.map = new TreeMap<>(new StudentComparator(false));
    }

    @Override
    public boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade) {
        Map<String, BigDecimal> studentGrades = map.get(student);

        if (studentGrades == null) {
            studentGrades = new HashMap<>();
            studentGrades.put(discipline, grade);
            map.put(student, studentGrades);
            return true;
        }

        boolean hasDiscipline = studentGrades.containsKey(discipline);
        studentGrades.put(discipline, grade);

        return !hasDiscipline;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Comparator<Student> getComparator() {
        return new StudentComparator(true);
    }

    @Override
    public List<String> getStudentsByDiscipline(String discipline) {
        List<String> resultStudentsList = new ArrayList<>();

        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            Student student = entry.getKey();
            Map<String, BigDecimal> disciplines = entry.getValue();

            for (Map.Entry<String, BigDecimal> entryDis : disciplines.entrySet()) {
                String disciplineName = entryDis.getKey();
                BigDecimal grade = entryDis.getValue();

                if (disciplineName.equals(discipline)) {
                    String studentInfo = student.getLastName() + "_" + student.getFirstName() + ": " + grade;
                    resultStudentsList.add(studentInfo);
                }
            }
        }
        return resultStudentsList;
    }

    @Override
    public Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal grade) {
        Map<Student, Map<String, BigDecimal>> removedStudents = new HashMap<>();

        Iterator<Map.Entry<Student, Map<String, BigDecimal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Student, Map<String, BigDecimal>> entry = iterator.next();
            Student student = entry.getKey();
            Map<String, BigDecimal> grades = entry.getValue();

            boolean hasLowGrade = false;

            for (BigDecimal studentGrade : grades.values()) {
                if (studentGrade.compareTo(grade) < 0) {
                    hasLowGrade = true;
                    break;
                }
            }
            if (hasLowGrade) {
                removedStudents.put(student, grades);
                iterator.remove();
            }
        }
        return removedStudents;
    }

    @Override
    public Map<BigDecimal, List<Student>> getAndSortAllStudents() {
        Map<BigDecimal, List<Student>> resultSortAllStudents = new TreeMap<>();

        for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
            Student student = entry.getKey();
            Map<String, BigDecimal> grades = entry.getValue();

            BigDecimal totalGrade = BigDecimal.ZERO;
            int count = 0;

            for (BigDecimal grade : grades.values()) {
                totalGrade = totalGrade.add(grade);
                count++;
            }

            BigDecimal averageGrade = totalGrade.divide(BigDecimal.valueOf(count), 1, RoundingMode.HALF_UP);
            if (!resultSortAllStudents.containsKey(averageGrade)) {
                resultSortAllStudents.put(averageGrade, new ArrayList<>());
            }
            resultSortAllStudents.get(averageGrade).add(student);
        }
        return resultSortAllStudents;
    }

    private static class StudentComparator implements Comparator<Student> {
        private final boolean compareGroup;

        public StudentComparator(boolean compareGroup) {
            this.compareGroup = compareGroup;
        }

        @Override
        public int compare(Student student1, Student student2) {
            int compareToFirstName = student1.getFirstName().compareTo(student2.getFirstName());
            if (compareToFirstName != 0) {
                return compareToFirstName;
            }

            int compareToLastName = student1.getLastName().compareTo(student2.getLastName());
            if (compareToLastName != 0) {
                return compareToLastName;
            }

            if (compareGroup) {
                return student1.getGroup().compareTo(student2.getGroup());
            }
            return 0;
        }
    }
}
