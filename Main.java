package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите числа первого конплексного числа");
        double a = input.nextDouble();
        double b = input.nextDouble();
        System.out.println("Введите числа второго конплексного числа");
        double c = input.nextDouble();
        double d = input.nextDouble();
        ComplexNumber first = new ComplexNumber(a, b);
        ComplexNumber second = new ComplexNumber(c, d);
        System.out.println("Сумма = " + first.add(first, second));
        System.out.println("Разность = " + first.subtract(first, second));
        System.out.println("Умножение = " + first.multiply(first, second));
        System.out.println("Деление = " + first.divide(first, second));
    }
}
class ComplexNumber{
    public double real;
    public double imaginary;
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    @Override
    public String toString(){
        return real + "+" + imaginary + "i";
    }
    public ComplexNumber add(ComplexNumber current, ComplexNumber other){
        double realSum = current.real + other.real;
        double imaginarySum = current.imaginary + other.imaginary;
        return new ComplexNumber(realSum, imaginarySum);
    }
    public ComplexNumber subtract(ComplexNumber current, ComplexNumber other){
        double realDiff = current.real - other.real;
        double imaginaryDiff = current.imaginary - other.imaginary;
        return new ComplexNumber(realDiff, imaginaryDiff);
    }
    public  ComplexNumber multiply(ComplexNumber current, ComplexNumber other){
        double realPart = current.real * other.real - current.imaginary * other.imaginary;
        double imaginaryPart = current.real * other.imaginary + other.real * current.imaginary;
        return  new ComplexNumber(realPart, imaginaryPart);
    }
    public ComplexNumber divide(ComplexNumber current, ComplexNumber other){
        double divisor = other.real * other.real + other.imaginary * other.imaginary;
        if (divisor != 0){
            double realPart = current.real * other.real + current.imaginary * other.imaginary/divisor;
            double imaginaryPart = other.real * current.imaginary - current.real * other.imaginary/divisor;
            return new ComplexNumber(realPart, imaginaryPart);
        }
        else {
            System.out.println("Error");
            return new ComplexNumber(-1, -1);
        }
    }
}




