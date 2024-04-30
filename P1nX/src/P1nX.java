import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) throws Exception {

        String genero_incial;

        try{
            genero_incial = args[0];
            genero_incial = genero_incial.toUpperCase();

            String mes_String = args[4].toUpperCase();
            int auxiliarMes;
            auxiliarMes = MesesConstantes.verificarMes(mes_String);
            long auxiliarCPF = ValidaCPF.toLong(args[6]);

            if(!genero_incial.equals("HOMEM") && !genero_incial.equals("MULHER")){
                System.out.println("ERRO! O genero deve ser Homem ou Mulher.");

            }else if(genero_incial.equals("HOMEM")){
                Homem exemplo = new Homem(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF, 
                Float.parseFloat(args[7]), Float.parseFloat(args[8]));

                System.out.println(exemplo.toString());

            }else{
                Mulher exemplo = new Mulher(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF,
                Float.parseFloat(args[7]), Float.parseFloat(args[8]));

                System.out.println(exemplo.toString());
            }
            
        }catch(NumberFormatException nf){
            System.out.println(nf + "\nFormatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
        }catch (IllegalArgumentException i) {
            System.out.println(i + "\nFormatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
        }catch(InputMismatchException in){
            System.out.println(in + "\nFormatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println(a + "\nFormatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
        }

        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);

        int elem;
        int count= 0, HomemCount= 0, MulherCount = 0;
        String genero = "";

        try {

            System.out.println("Quantos elementos adicionais serão criados no array?");
            elem = teclado.nextInt();
            teclado.nextLine();

            Pessoa array2[] = new Pessoa[elem];

            for (int i = 0; i < (array2.length) && !genero.equals("NEUTRO"); i++) {
                String nome, sobrenome;
                int dia, mes, ano;
                String mes_String;

                System.out.println("Qual o genero da próxima pessoa?('neutro' interrompe)");
                genero = teclado.next().toUpperCase();
                teclado.nextLine();
                if(!genero.equals("HOMEM") && !genero.equals("MULHER")){
                    System.out.println("Genero NEUTRO/INVALIDO(encerrando...)");
                    break;
                }

                System.out.print("Nome: ");
                nome = teclado.nextLine();
                System.out.print("Sobrenome: ");
                sobrenome = teclado.nextLine();
                System.out.print("Dia do nascimento: ");
                dia = teclado.nextInt();
                teclado.nextLine();

                System.out.print("Mes de nascimento: ");
                mes_String = teclado.next().toUpperCase();
                teclado.nextLine();
                mes = MesesConstantes.verificarMes(mes_String);

                System.out.print("Ano de nascimento: ");
                ano = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Deseja inserir CPF/Peso/Altura?");
                String resposta = teclado.next().toUpperCase();
                teclado.nextLine();

                if(resposta.equals("SIM")){
                    System.out.print("CPF: ");
                    String CPF_STRING = teclado.nextLine();
                    Long CPF_LONG = ValidaCPF.toLong(CPF_STRING);
                    System.out.print("Peso: ");
                    float peso= teclado.nextFloat();
                    teclado.nextLine();
                    System.out.print("Altura: ");
                    float altura = teclado.nextFloat();
                    teclado.nextLine();

                    if (genero.equals("HOMEM")) {
                        array2[i] = new Homem(nome, sobrenome, dia, mes, ano, CPF_LONG , peso, altura);
                    } else if (genero.equals("MULHER")) {
                        array2[i] = new Mulher(nome, sobrenome, dia, mes, ano, CPF_LONG, peso , altura);
                    } else {
                        throw new IllegalArgumentException("Genero Invalido");
                    }
                }else{
                    if (genero.equals("HOMEM")) {
                        array2[i] = new Homem(nome, sobrenome, dia, mes, ano);
                    } else if (genero.equals("MULHER")) {
                        array2[i] = new Mulher(nome, sobrenome, dia, mes, ano);
                    } else {
                        throw new IllegalArgumentException("Genero Invalido");
                    }
                }
                count++;
            }

            if(array2.length != count){
                Pessoa[] ArrayMenor = Arrays.copyOf(array2 , count);
                for(Pessoa valor: ArrayMenor){
                    System.out.println(valor.toString());
                }

                for(int i = 0; i<ArrayMenor.length; i++){
                    if(ArrayMenor[i] instanceof Homem){
                        HomemCount++;
                    }else{
                        MulherCount++;
                        }
                    }
                System.out.println("Instancias de Homem: " + HomemCount);
                System.out.println("Instancias de Mulher: " + MulherCount);

            }else{
                for(Pessoa valor: array2){
                    System.out.println(valor.toString());
                }

                for(int i = 0; i<array2.length; i++){
                    if(array2[i] instanceof Homem){
                        HomemCount++;
                    }else{
                        MulherCount++;
                        }
                    }

                System.out.println("Instancias de Homem: " + HomemCount);
                System.out.println("Instancias de Mulher: " + MulherCount);
                }

        }catch(NumberFormatException nf){
            System.out.println("EROO! Insira um valor valido para mes");
        }catch (IllegalArgumentException i) {
            System.out.println(i);
        }catch(NegativeArraySizeException n){
            System.out.println("ERRO! O tamanho do array nao pode ser negativo.");
        }catch(InputMismatchException in){
            System.out.println("ERRO! Formatação invalida");
        }
    }
}
