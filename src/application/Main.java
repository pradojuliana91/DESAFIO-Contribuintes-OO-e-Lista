package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Digite os dados do " + (i+1) + "o contribuinte: ");
            System.out.print("Renda anual com salário: ");
            Double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            Double serviceIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            Double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            Double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            Double educationSpending = sc.nextDouble();
            System.out.println();

            list.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending));
        }

        int i = 1;
        for (TaxPayer taxPayer : list) {
            System.out.print("Resumo do " + i + "o contribuinte: ");
            System.out.print(taxPayer);
            System.out.println();
            i++;
            System.out.println();
            }

        sc.close();
    }

}