/* 국영수 */ 
package day6_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B10825 {
	
	// 학생 클래스 정의
    static class Student{
        String name;
        int korean;
        int english;
        int math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 학생수 입력받기
        int N = Integer.parseInt(br.readLine());
        
        // 학생들의 정보를 입력받아 객체로 생성해서 저장
        Student[] student = new Student[N];
        
        for(int i=0; i<N; i++){
            String[] score = br.readLine().split(" ");
            student[i] = new Student(score[0],Integer.parseInt(score[1]),
                                     Integer.parseInt(score[2]),Integer.parseInt(score[3]));
        }
        
        // 문제에 주어진 조건으로 정렬하기 위해 Comparator 객체 정의
        Comparator<Student> myComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean < o2.korean) {
                    return 1; // 국어 점수를 기준으로 o1이 o2보다 큼
                }else if(o1.korean == o2.korean) {
                    if(o1.english > o2.english) {
                        return 1; // 영어 점수를 기준으로 o1이 o2보다 큼
                    }else if(o1.english == o2.english) {
                        if(o1.math < o2.math) {
                            return 1; // 수학 점수를 기준으로 o1이 o2보다 큼
                        }else if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
            }
        };
        
        // 정렬 기준대로 배열 정렬
        Arrays.sort(student, myComparator);
        
        // 정렬된 학생들 이름 출력
        for(int i=0; i<N; i++){
            System.out.println(student[i].name);
        }

    }
}
