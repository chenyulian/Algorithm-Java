package com.algorithm.sort;

public class Student implements Comparable {
    private int score;
    private String name;
    public Student(String name, int score){
        this.score = score;
        this.name = name;
    }
    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   @Override
    public int compareTo(Object o) {
        if(this.score > ((Student) o).getScore()){
            return 1;
        }else if(this.score < ((Student) o).getScore()){
            return -1;
        }else{
            return 0;
        }
    }
}
